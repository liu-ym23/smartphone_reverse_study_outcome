package com.android.server.wm;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AtomicFile;
import android.util.Slog;
import android.window.TaskSnapshot;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import com.android.server.wm.nano.WindowManagerProtos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
class SnapshotPersistQueue {
    private static final int COMPRESS_QUALITY = 95;
    private static final long DELAY_MS = 100;
    static final int MAX_STORE_QUEUE_DEPTH = 2;
    private static final String TAG = "WindowManager";
    private final Object mLock;
    private boolean mPaused;
    private final Thread mPersister;
    private boolean mQueueIdling;
    private boolean mShutdown;
    private boolean mStarted;
    private final ArrayDeque<StoreWriteQueueItem> mStoreQueueItems;
    private final UserManagerInternal mUserManagerInternal;
    private final ArrayDeque<WriteQueueItem> mWriteQueue;

    private class DeleteWriteQueueItem extends WriteQueueItem {
        private final int mId;
        final /* synthetic */ SnapshotPersistQueue this$0;

        DeleteWriteQueueItem(SnapshotPersistQueue r1, int id, int userId, BaseAppSnapshotPersister.PersistInfoProvider provider) {
            this.this$0 = r1;
            super(provider, userId);
            this.mId = id;
        }

        @Override // com.android.server.wm.SnapshotPersistQueue.WriteQueueItem
        void write() {
            Trace.traceBegin(32, "DeleteWriteQueueItem");
            this.this$0.deleteSnapshot(this.mId, this.mUserId, this.mPersistInfoProvider);
            Trace.traceEnd(32);
        }

        public String toString() {
            return "DeleteWriteQueueItem{ID=" + this.mId + ", UserId=" + this.mUserId + "}";
        }
    }

    class StoreWriteQueueItem extends WriteQueueItem {
        private final int mId;
        private final TaskSnapshot mSnapshot;
        final /* synthetic */ SnapshotPersistQueue this$0;

        public static /* synthetic */ boolean $r8$lambda$MNPT25TkTGkcQvuGrbhrIBePnGg(StoreWriteQueueItem r0, StoreWriteQueueItem r1) {
            return r0.lambda$onQueuedLocked$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10148$$Nest$fgetmId(StoreWriteQueueItem r0) {
            return r0.mId;
        }

        StoreWriteQueueItem(SnapshotPersistQueue this$0, int id, int userId, TaskSnapshot snapshot, BaseAppSnapshotPersister.PersistInfoProvider provider) {
            this.this$0 = this$0;
            super(provider, userId);
            this.mId = id;
            snapshot.addReference(4);
            this.mSnapshot = snapshot;
        }

        @Override // com.android.server.wm.SnapshotPersistQueue.WriteQueueItem
        void onQueuedLocked() {
            SnapshotPersistQueue.m10144$$Nest$fgetmStoreQueueItems(this.this$0).removeIf(new SnapshotPersistQueue$StoreWriteQueueItem$$ExternalSyntheticLambda0(this));
            SnapshotPersistQueue.m10144$$Nest$fgetmStoreQueueItems(this.this$0).offer(this);
        }

        private /* synthetic */ boolean lambda$onQueuedLocked$0(StoreWriteQueueItem item) {
            if (item.equals(this) == true) goto L5;
            return false;
        L5:
            if (item.mSnapshot == this.mSnapshot) goto L10;
            item.mSnapshot.removeReference(4);
            return true;
        L10:
            return false;
        }

        @Override // com.android.server.wm.SnapshotPersistQueue.WriteQueueItem
        void onDequeuedLocked() {
            SnapshotPersistQueue.m10144$$Nest$fgetmStoreQueueItems(this.this$0).remove(this);
        }

        @Override // com.android.server.wm.SnapshotPersistQueue.WriteQueueItem
        void write() {
            if (Trace.isTagEnabled(32) == false) goto L6;
            Trace.traceBegin(32, "StoreWriteQueueItem#" + this.mId);
        L6:
            if (this.mPersistInfoProvider.createDirectory(this.mUserId) == true) goto L8;
            Slog.e(SnapshotPersistQueue.TAG, "Unable to create snapshot directory for user dir=" + this.mPersistInfoProvider.getDirectory(this.mUserId));
        L8:
            boolean failed = false;
            if (writeProto() == true) goto L12;
            failed = true;
        L12:
            if (writeBuffer() == true) goto L14;
            failed = true;
        L14:
            if (failed == false) goto L16;
            this.this$0.deleteSnapshot(this.mId, this.mUserId, this.mPersistInfoProvider);
        L16:
            this.mSnapshot.removeReference(4);
            Trace.traceEnd(32);
        }

        boolean writeProto() {
            WindowManagerProtos.TaskSnapshotProto proto = new WindowManagerProtos.TaskSnapshotProto();
            proto.orientation = this.mSnapshot.getOrientation();
            proto.rotation = this.mSnapshot.getRotation();
            proto.taskWidth = this.mSnapshot.getTaskSize().x;
            proto.taskHeight = this.mSnapshot.getTaskSize().y;
            proto.insetLeft = this.mSnapshot.getContentInsets().left;
            proto.insetTop = this.mSnapshot.getContentInsets().top;
            proto.insetRight = this.mSnapshot.getContentInsets().right;
            proto.insetBottom = this.mSnapshot.getContentInsets().bottom;
            proto.letterboxInsetLeft = this.mSnapshot.getLetterboxInsets().left;
            proto.letterboxInsetTop = this.mSnapshot.getLetterboxInsets().top;
            proto.letterboxInsetRight = this.mSnapshot.getLetterboxInsets().right;
            proto.letterboxInsetBottom = this.mSnapshot.getLetterboxInsets().bottom;
            proto.isRealSnapshot = this.mSnapshot.isRealSnapshot();
            proto.windowingMode = this.mSnapshot.getWindowingMode();
            proto.appearance = this.mSnapshot.getAppearance();
            proto.isTranslucent = this.mSnapshot.isTranslucent();
            proto.topActivityComponent = this.mSnapshot.getTopActivityComponent().flattenToString();
            proto.uiMode = this.mSnapshot.getUiMode();
            proto.id = this.mSnapshot.getId();
            byte[] bytes = WindowManagerProtos.TaskSnapshotProto.toByteArray(proto);
            File file = this.mPersistInfoProvider.getProtoFile(this.mId, this.mUserId);
            AtomicFile atomicFile = new AtomicFile(file);
            FileOutputStream fos = null;
            fos = atomicFile.startWrite();     // Catch: IOException -> L6
            fos.write(bytes);     // Catch: IOException -> L6
            atomicFile.finishWrite(fos);     // Catch: IOException -> L6
            return true;
        L6:
            e = move-exception;
            atomicFile.failWrite(fos);
            Slog.e(SnapshotPersistQueue.TAG, "Unable to open " + file + " for persisting. " + e);
            return false;
        }

        boolean writeBuffer() {
            if (AbsAppSnapshotController.isInvalidHardwareBuffer(this.mSnapshot.getHardwareBuffer()) == false) goto L6;
            Slog.e(SnapshotPersistQueue.TAG, "Invalid task snapshot hw buffer, taskId=" + this.mId);
            return false;
        L6:
            HardwareBuffer hwBuffer = this.mSnapshot.getHardwareBuffer();
            int width = hwBuffer.getWidth();
            int height = hwBuffer.getHeight();
            hwBuffer.getFormat();
            Bitmap swBitmap = copyToSwBitmapReadBack();
            if (swBitmap != null) goto L9;
            return false;
        L9:
            File file = this.mPersistInfoProvider.getHighResolutionBitmapFile(this.mId, this.mUserId);
            FileOutputStream fos = new FileOutputStream(file);     // Catch: IOException -> L36
            swBitmap.compress(Bitmap.CompressFormat.JPEG, 95, fos);     // Catch: Throwable -> L38
            fos.close();     // Catch: IOException -> L36
            if (this.mPersistInfoProvider.enableLowResSnapshots() == true) goto L18;
            swBitmap.recycle();
            return true;
        L18:
            Bitmap lowResBitmap = Bitmap.createScaledBitmap(swBitmap, (int) (width * this.mPersistInfoProvider.lowResScaleFactor()), (int) (height * this.mPersistInfoProvider.lowResScaleFactor()), true);
            swBitmap.recycle();
            File lowResFile = this.mPersistInfoProvider.getLowResolutionBitmapFile(this.mId, this.mUserId);
            FileOutputStream lowResFos = new FileOutputStream(lowResFile);     // Catch: IOException -> L25
            lowResBitmap.compress(Bitmap.CompressFormat.JPEG, 95, lowResFos);     // Catch: Throwable -> L27
            lowResFos.close();     // Catch: IOException -> L25
            lowResBitmap.recycle();
            return true;
        L27:
            th = move-exception;
            lowResFos.close();     // Catch: Throwable -> L31
        L60:
            throw th;     // Catch: IOException -> L25
        L31:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L25
            throw th;     // Catch: IOException -> L25
        L25:
            e = move-exception;
            Slog.e(SnapshotPersistQueue.TAG, "Unable to open " + lowResFile + " for persisting.", e);
            return false;
        L38:
            th = move-exception;
            fos.close();     // Catch: Throwable -> L42
        L61:
            throw th;     // Catch: IOException -> L45
        L42:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L45
            throw th;     // Catch: IOException -> L45
        L45:
            e = e;
        L46:
            Slog.e(SnapshotPersistQueue.TAG, "Unable to open " + file + " for persisting.", e);
            return 0;
        L36:
            e = e;
            goto L46
        }

        private Bitmap copyToSwBitmapReadBack() {
            Bitmap bitmap = Bitmap.wrapHardwareBuffer(this.mSnapshot.getHardwareBuffer(), this.mSnapshot.getColorSpace());
            if (bitmap != null) goto L6;
            Slog.e(SnapshotPersistQueue.TAG, "Invalid task snapshot hw bitmap");
            return null;
        L6:
            Bitmap swBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            if (swBitmap != null) goto L10;
            Slog.e(SnapshotPersistQueue.TAG, "Bitmap conversion from (config=" + bitmap.getConfig() + ", isMutable=" + bitmap.isMutable() + ") to (config=ARGB_8888, isMutable=false) failed.");
            return null;
        L10:
            bitmap.recycle();
            return swBitmap;
        }

        private Bitmap copyToSwBitmapDirect(int width, int height, int pixelFormat) {
            ImageReader ir = ImageReader.newInstance(width, height, pixelFormat, 1);
            ir.getSurface().attachAndQueueBufferWithColorSpace(this.mSnapshot.getHardwareBuffer(), this.mSnapshot.getColorSpace());     // Catch: Throwable -> L15
            Image image = ir.acquireLatestImage();     // Catch: Throwable -> L15
            if (image == null) goto L28;
        L17:
            th = move-exception;
            if (image != null) goto L46;
        L39:
            throw th;     // Catch: Throwable -> L15
        L46:
            image.close();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L15
            goto L39
        L7:
            if (image.getPlaneCount() < 1) goto L28;
            Image.Plane[] planes = image.getPlanes();     // Catch: Throwable -> L17
            if (planes.length == 1) goto L20;
            Slog.e(SnapshotPersistQueue.TAG, "Image reader cannot get plane");     // Catch: Throwable -> L17
            image.close();     // Catch: Throwable -> L15
            ir.close();
            return null;
        L20:
            Image.Plane plane = planes[0];     // Catch: Throwable -> L17
            int rowPadding = plane.getRowStride() - (plane.getPixelStride() * image.getWidth());     // Catch: Throwable -> L17
            int r4 = image.getWidth() + (rowPadding / plane.getPixelStride());     // Catch: Throwable -> L17
            int r6 = image.getHeight();     // Catch: Throwable -> L17
            if (pixelFormat != 4) goto L23;
            Bitmap.Config r7 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L17
        L24:
            Bitmap swBitmap = Bitmap.createBitmap(r4, r6, r7);     // Catch: Throwable -> L17
            swBitmap.copyPixelsFromBuffer(plane.getBuffer());     // Catch: Throwable -> L17
            image.close();     // Catch: Throwable -> L15
            ir.close();
            return swBitmap;
        L23:
            r7 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L17
        L28:
            Slog.e(SnapshotPersistQueue.TAG, "Image reader cannot acquire image");     // Catch: Throwable -> L17
            if (image == null) goto L31;
            image.close();     // Catch: Throwable -> L15
        L31:
            ir.close();
            return null;
        L15:
            th = move-exception;
            if (ir != null) goto L49;
        L45:
            throw th;
        L49:
            ir.close();     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            th.addSuppressed(th);
            goto L45
        }

        public boolean equals(Object o) {
            if (o != null) goto L5;
        L15:
            return false;
        L5:
            if (getClass() != o.getClass()) goto L15;
            StoreWriteQueueItem other = (StoreWriteQueueItem) o;
            if (this.mId == other.mId) goto L10;
            return false;
        L10:
            if (this.mUserId == other.mUserId) goto L12;
            return false;
        L12:
            if (this.mPersistInfoProvider != other.mPersistInfoProvider) goto L18;
            return true;
        L18:
            return false;
        }

        public String toString() {
            return "StoreWriteQueueItem{ID=" + this.mId + ", UserId=" + this.mUserId + "}";
        }
    }

    static abstract class WriteQueueItem {
        protected final BaseAppSnapshotPersister.PersistInfoProvider mPersistInfoProvider;
        protected final int mUserId;

        abstract void write();

        WriteQueueItem(BaseAppSnapshotPersister.PersistInfoProvider persistInfoProvider, int userId) {
            this.mPersistInfoProvider = persistInfoProvider;
            this.mUserId = userId;
        }

        boolean isReady(UserManagerInternal userManager) {
            return userManager.isUserUnlocked(this.mUserId);
        }

        void onQueuedLocked() {
        }

        void onDequeuedLocked() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10141$$Nest$fgetmLock(SnapshotPersistQueue r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPaused, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10142$$Nest$fgetmPaused(SnapshotPersistQueue r0) {
        return r0.mPaused;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShutdown, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10143$$Nest$fgetmShutdown(SnapshotPersistQueue r0) {
        return r0.mShutdown;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStoreQueueItems, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayDeque m10144$$Nest$fgetmStoreQueueItems(SnapshotPersistQueue r0) {
        return r0.mStoreQueueItems;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManagerInternal m10145$$Nest$fgetmUserManagerInternal(SnapshotPersistQueue r0) {
        return r0.mUserManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWriteQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayDeque m10146$$Nest$fgetmWriteQueue(SnapshotPersistQueue r0) {
        return r0.mWriteQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQueueIdling, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10147$$Nest$fputmQueueIdling(SnapshotPersistQueue r0, boolean r1) {
        r0.mQueueIdling = r1;
    }

    SnapshotPersistQueue() {
        this.mWriteQueue = new ArrayDeque();
        this.mStoreQueueItems = new ArrayDeque();
        this.mLock = new Object();
        final String r1 = "TaskSnapshotPersister";
        this.mPersister = new AnonymousClass1(this, r1);
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    }

    Object getLock() {
        return this.mLock;
    }

    void systemReady() {
        start();
    }

    void start() {
        if (this.mStarted == true) goto L6;
        this.mStarted = true;
        this.mPersister.start();
        return;
    }

    void setPaused(boolean paused) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPaused = paused;     // Catch: Throwable -> L7
        if (paused == true) goto L9;
        this.mLock.notifyAll();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void prepareShutdown() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mShutdown = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isQueueEmpty() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mWriteQueue.isEmpty() == true) goto L14;
        if (this.mQueueIdling == true) goto L14;
        if (this.mPaused == true) goto L14;
        boolean r1 = false;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L14:
        r1 = true;
        goto L15
    }

    void waitFlush(long timeout) {
        if (timeout > 0) goto L5;
        return;
    L5:
        long endTime = System.currentTimeMillis() + timeout;
    L7:
        if (isQueueEmpty() == true) goto L27;
        long timeRemaining = endTime - System.currentTimeMillis();
        if (timeRemaining <= 0) goto L21;
        Object r6 = this.mLock;
        monitor-enter(r6);
        this.mLock.wait(timeRemaining);     // Catch: Throwable -> L14 InterruptedException -> L16
    L14:
        th = move-exception;
        throw th;
    L17:
        monitor-exit(r6);     // Catch: Throwable -> L14
        goto L7
    L21:
        Slog.w(TAG, "Snapshot Persist Queue flush timed out");
        return;
    }

    void waitForQueueEmpty() {
    L2:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mWriteQueue.isEmpty() == true) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        SystemClock.sleep(DELAY_MS);
        goto L2
    L7:
        if (this.mQueueIdling == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    int peekWriteQueueSize() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mStoreQueueItems.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int peekQueueSize() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mWriteQueue.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void addToQueueInternal(WriteQueueItem item, boolean insertToFront) {
        this.mWriteQueue.removeFirstOccurrence(item);
        if (insertToFront == false) goto L5;
        this.mWriteQueue.addFirst(item);
    L6:
        item.onQueuedLocked();
        if (this.mShutdown == true) goto L10;
        ensureStoreQueueDepthLocked();
    L10:
        if (this.mPaused == true) goto L13;
        this.mLock.notifyAll();
        return;
    L13:
        return;
    L5:
        this.mWriteQueue.addLast(item);
        goto L6
    }

    void sendToQueueLocked(WriteQueueItem item) {
        addToQueueInternal(item, false);
    }

    void insertQueueAtFirstLocked(WriteQueueItem item) {
        addToQueueInternal(item, true);
    }

    private void ensureStoreQueueDepthLocked() {
    L3:
        if (this.mStoreQueueItems.size() <= 2) goto L5;
        StoreWriteQueueItem item = this.mStoreQueueItems.poll();
        this.mWriteQueue.remove(item);
        Slog.i(TAG, "Queue is too deep! Purged item with index=" + StoreWriteQueueItem.m10148$$Nest$fgetmId(item));
        goto L3
    }

    void deleteSnapshot(int index, int userId, BaseAppSnapshotPersister.PersistInfoProvider provider) {
        File protoFile = provider.getProtoFile(index, userId);
        File bitmapLowResFile = provider.getLowResolutionBitmapFile(index, userId);
        if (protoFile.exists() == false) goto L6;
        protoFile.delete();
    L6:
        if (bitmapLowResFile.exists() == false) goto L8;
        bitmapLowResFile.delete();
    L8:
        File bitmapFile = provider.getHighResolutionBitmapFile(index, userId);
        if (bitmapFile.exists() == false) goto L12;
        bitmapFile.delete();
        return;
    }

    StoreWriteQueueItem createStoreWriteQueueItem(int id, int userId, TaskSnapshot snapshot, BaseAppSnapshotPersister.PersistInfoProvider provider) {
        return new StoreWriteQueueItem(this, id, userId, snapshot, provider);
    }

    DeleteWriteQueueItem createDeleteWriteQueueItem(int id, int userId, BaseAppSnapshotPersister.PersistInfoProvider provider) {
        return new DeleteWriteQueueItem(this, id, userId, provider);
    }

    void dump(PrintWriter pw, String prefix) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WriteQueueItem[] items = (WriteQueueItem[]) this.mWriteQueue.toArray(new WriteQueueItem[0]);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (items.length != 0) goto L9;
        return;
    L9:
        pw.println(prefix + "PersistQueue contains:");
        int i = items.length + (-1);
    L10:
        if (i < 0) goto L13;
        pw.println(prefix + "  " + items[i] + "");
        i = i + (-1);
        goto L10
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
