package com.android.server.wm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.HardwareBuffer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.service.displayhash.DisplayHashParams;
import android.service.displayhash.IDisplayHashingService;
import android.util.Size;
import android.util.Slog;
import android.view.MagnificationSpec;
import android.view.displayhash.DisplayHash;
import android.view.displayhash.VerifiedDisplayHash;
import android.window.ScreenCapture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayHashController {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowManager";
    private final Context mContext;
    private Map<String, DisplayHashParams> mDisplayHashAlgorithms;
    private final Object mDisplayHashAlgorithmsLock;
    private boolean mDisplayHashThrottlingEnabled;
    private final Handler mHandler;
    private int mIntervalBetweenRequestMillis;
    private final Object mIntervalBetweenRequestsLock;
    private long mLastRequestTimeMs;
    private int mLastRequestUid;
    private final byte[] mSalt;
    private DisplayHashingServiceConnection mServiceConnection;
    private final Object mServiceConnectionLock;
    private final float[] mTmpFloat9;
    private final Matrix mTmpMatrix;
    private final RectF mTmpRectF;

    private interface Command {
        void run(IDisplayHashingService r1) throws RemoteException;
    }

    private class DisplayHashingServiceConnection implements ServiceConnection {
        private ArrayList<Command> mQueuedCommands;
        private IDisplayHashingService mRemoteService;
        final /* synthetic */ DisplayHashController this$0;

        /* JADX INFO: renamed from: -$$Nest$mrunCommandLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9918$$Nest$mrunCommandLocked(DisplayHashingServiceConnection r0, Command r1) {
            r0.runCommandLocked(r1);
        }

        /* synthetic */ DisplayHashingServiceConnection(DisplayHashController r1, DisplayHashControllerIA r2) {
            this(r1);
        }

        private DisplayHashingServiceConnection(DisplayHashController r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Object r0 = DisplayHashController.m9915$$Nest$fgetmServiceConnectionLock(this.this$0);
            monitor-enter(r0);
            this.mRemoteService = IDisplayHashingService.Stub.asInterface(service);     // Catch: Throwable -> L11
            if (this.mQueuedCommands == null) goto L17;
            int size = this.mQueuedCommands.size();     // Catch: Throwable -> L11
            int i = 0;
        L7:
            if (i >= size) goto L16;
            Command queuedCommand = this.mQueuedCommands.get(i);     // Catch: Throwable -> L11
            queuedCommand.run(this.mRemoteService);     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            i = i + 1;     // Catch: Throwable -> L11
        L13:
            e = move-exception;
            Slog.w(DisplayHashController.TAG, "exception calling " + name + ": " + e);     // Catch: Throwable -> L11
            goto L15
        L16:
            this.mQueuedCommands = null;     // Catch: Throwable -> L11
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Object r0 = DisplayHashController.m9915$$Nest$fgetmServiceConnectionLock(this.this$0);
            monitor-enter(r0);
            this.mRemoteService = null;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName name) {
            Object r0 = DisplayHashController.m9915$$Nest$fgetmServiceConnectionLock(this.this$0);
            monitor-enter(r0);
            this.mRemoteService = null;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName name) {
            Object r0 = DisplayHashController.m9915$$Nest$fgetmServiceConnectionLock(this.this$0);
            monitor-enter(r0);
            this.mRemoteService = null;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void runCommandLocked(Command command) {
            if (this.mRemoteService == null) goto L5;
            command.run(this.mRemoteService);     // Catch: RemoteException -> L10
            return;
        L10:
            e = move-exception;
            Slog.w(DisplayHashController.TAG, "exception calling service: " + e);
            return;
        L5:
            if (this.mQueuedCommands != null) goto L7;
            this.mQueuedCommands = new ArrayList(1);
        L7:
            this.mQueuedCommands.add(command);
        }
    }

    private class Handler extends android.os.Handler {
        static final int MSG_SERVICE_SHUTDOWN_TIMEOUT = 1;
        static final long SERVICE_SHUTDOWN_TIMEOUT_MILLIS = 10000;
        final /* synthetic */ DisplayHashController this$0;

        Handler(DisplayHashController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 1) goto L15;
            Object r0 = DisplayHashController.m9915$$Nest$fgetmServiceConnectionLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (DisplayHashController.m9914$$Nest$fgetmServiceConnection(this.this$0) == null) goto L11;
            DisplayHashController.m9913$$Nest$fgetmContext(this.this$0).unbindService(DisplayHashController.m9914$$Nest$fgetmServiceConnection(this.this$0));     // Catch: Throwable -> L9
            DisplayHashController.m9916$$Nest$fputmServiceConnection(this.this$0, null);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        }

        void resetTimeoutMessage() {
            removeMessages(1);
            sendEmptyMessageDelayed(1, 10000);
        }
    }

    private class SyncCommand {
        private static final int WAIT_TIME_S = 5;
        private final CountDownLatch mCountDownLatch;
        private Bundle mResult;
        final /* synthetic */ DisplayHashController this$0;

        public static /* synthetic */ void $r8$lambda$AnaETkpRW9zy8UEmjMUUtJcvZAs(SyncCommand r0, Bundle r1) {
            r0.lambda$run$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$zEDC0kdkJC9x83ljDFbPCh5kv7s(SyncCommand r0, BiConsumer r1, IDisplayHashingService r2) {
            r0.lambda$run$1(r1, r2);
        }

        /* synthetic */ SyncCommand(DisplayHashController r1, DisplayHashControllerIA r2) {
            this(r1);
        }

        private SyncCommand(DisplayHashController r2) {
            this.this$0 = r2;
            this.mCountDownLatch = new CountDownLatch(1);
        }

        public Bundle run(final BiConsumer<IDisplayHashingService, RemoteCallback> func) {
            DisplayHashController.m9917$$Nest$mconnectAndRun(this.this$0, new DisplayHashController$SyncCommand$$ExternalSyntheticLambda1(this, func));
            this.mCountDownLatch.await(5, TimeUnit.SECONDS);     // Catch: Exception -> L5
        L8:
            return this.mResult;
        L5:
            e = move-exception;
            Slog.e(DisplayHashController.TAG, "Failed to wait for command", e);
            goto L8
        }

        private /* synthetic */ void lambda$run$1(BiConsumer func, IDisplayHashingService service) throws RemoteException {
            RemoteCallback callback = new RemoteCallback(new DisplayHashController$SyncCommand$$ExternalSyntheticLambda0(this));
            func.accept(service, callback);
        }

        private /* synthetic */ void lambda$run$0(Bundle result) {
            this.mResult = result;
            this.mCountDownLatch.countDown();
        }
    }

    public static /* synthetic */ void $r8$lambda$FQw_m9JVKEczm4AAxgtPQnLAHh8(IDisplayHashingService r0, RemoteCallback r1) {
        lambda$getIntervalBetweenRequestMillis$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$LTcDSj0TyvQOPDbOGQ0_VgiuHeY(DisplayHashController r0, DisplayHash r1, IDisplayHashingService r2, RemoteCallback r3) {
        r0.lambda$verifyDisplayHash$0(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$QpvhZBvKdvbIAqWQZAUo6iBrvTE(IDisplayHashingService r0, RemoteCallback r1) {
        lambda$getDisplayHashAlgorithms$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$iDwBNKJI_hwGnqP4uyTLnqBBLHo(DisplayHashController r0, HardwareBuffer r1, Rect r2, String r3, RemoteCallback r4, IDisplayHashingService r5) {
        r0.lambda$generateDisplayHash$1(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9913$$Nest$fgetmContext(DisplayHashController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayHashingServiceConnection m9914$$Nest$fgetmServiceConnection(DisplayHashController r0) {
        return r0.mServiceConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceConnectionLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9915$$Nest$fgetmServiceConnectionLock(DisplayHashController r0) {
        return r0.mServiceConnectionLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmServiceConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9916$$Nest$fputmServiceConnection(DisplayHashController r0, DisplayHashingServiceConnection r1) {
        r0.mServiceConnection = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectAndRun, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9917$$Nest$mconnectAndRun(DisplayHashController r0, Command r1) {
        r0.connectAndRun(r1);
    }

    DisplayHashController(Context context) {
        this.mServiceConnectionLock = new Object();
        this.mDisplayHashAlgorithmsLock = new Object();
        this.mTmpFloat9 = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpRectF = new RectF();
        this.mIntervalBetweenRequestsLock = new Object();
        this.mIntervalBetweenRequestMillis = -1;
        this.mDisplayHashThrottlingEnabled = true;
        this.mContext = context;
        this.mHandler = new Handler(this, Looper.getMainLooper());
        this.mSalt = UUID.randomUUID().toString().getBytes();
    }

    String[] getSupportedHashAlgorithms() {
        Map<String, DisplayHashParams> displayHashAlgorithms = getDisplayHashAlgorithms();
        return (String[]) displayHashAlgorithms.keySet().toArray(new String[0]);
    }

    VerifiedDisplayHash verifyDisplayHash(final DisplayHash displayHash) {
        SyncCommand syncCommand = new SyncCommand(this, null);
        Bundle results = syncCommand.run(new DisplayHashController$$ExternalSyntheticLambda2(this, displayHash));
        return (VerifiedDisplayHash) results.getParcelable("android.service.displayhash.extra.VERIFIED_DISPLAY_HASH");
    }

    private /* synthetic */ void lambda$verifyDisplayHash$0(DisplayHash displayHash, IDisplayHashingService service, RemoteCallback remoteCallback) {
        service.verifyDisplayHash(this.mSalt, displayHash, remoteCallback);     // Catch: RemoteException -> L4
        return;
    L5:
        Slog.e(TAG, "Failed to invoke verifyDisplayHash command");
    }

    void setDisplayHashThrottlingEnabled(boolean enable) {
        this.mDisplayHashThrottlingEnabled = enable;
    }

    private void generateDisplayHash(final HardwareBuffer buffer, final Rect bounds, final String hashAlgorithm, final RemoteCallback callback) {
        connectAndRun(new DisplayHashController$$ExternalSyntheticLambda0(this, buffer, bounds, hashAlgorithm, callback));
    }

    private /* synthetic */ void lambda$generateDisplayHash$1(HardwareBuffer buffer, Rect bounds, String hashAlgorithm, RemoteCallback callback, IDisplayHashingService service) throws RemoteException {
        service.generateDisplayHash(this.mSalt, buffer, bounds, hashAlgorithm, callback);
    }

    private boolean allowedToGenerateHash(int uid) {
        if (this.mDisplayHashThrottlingEnabled == true) goto L5;
        return true;
    L5:
        long currentTime = System.currentTimeMillis();
        if (this.mLastRequestUid == uid) goto L9;
        this.mLastRequestUid = uid;
        this.mLastRequestTimeMs = currentTime;
        return true;
    L9:
        int mIntervalBetweenRequestsMs = getIntervalBetweenRequestMillis();
        if ((currentTime - this.mLastRequestTimeMs) >= mIntervalBetweenRequestsMs) goto L13;
        return false;
    L13:
        this.mLastRequestTimeMs = currentTime;
        return true;
    }

    void generateDisplayHash(ScreenCapture.LayerCaptureArgs.Builder args, Rect boundsInWindow, String hashAlgorithm, int uid, RemoteCallback callback) {
        if (allowedToGenerateHash(uid) == true) goto L6;
        sendDisplayHashError(callback, -6);
        return;
    L6:
        Map<String, DisplayHashParams> displayHashAlgorithmsMap = getDisplayHashAlgorithms();
        DisplayHashParams displayHashParams = displayHashAlgorithmsMap.get(hashAlgorithm);
        if (displayHashParams != null) goto L10;
        Slog.w(TAG, "Failed to generateDisplayHash. Invalid hashAlgorithm");
        sendDisplayHashError(callback, -5);
        return;
    L10:
        Size size = displayHashParams.getBufferSize();
        if (size != null) goto L13;
    L17:
        args.setGrayscale(displayHashParams.isGrayscaleBuffer());
        ScreenCapture.ScreenshotHardwareBuffer screenshotHardwareBuffer = ScreenCapture.captureLayers(args.build());
        if (screenshotHardwareBuffer != null) goto L20;
    L24:
        Slog.w(TAG, "Failed to generate DisplayHash. Couldn't capture content");
        sendDisplayHashError(callback, -1);
        return;
    L20:
        if (screenshotHardwareBuffer.getHardwareBuffer() == null) goto L24;
        generateDisplayHash(screenshotHardwareBuffer.getHardwareBuffer(), boundsInWindow, hashAlgorithm, callback);
        return;
    L13:
        if (size.getWidth() <= 0) goto L15;
    L16:
        args.setFrameScale(size.getWidth() / boundsInWindow.width(), size.getHeight() / boundsInWindow.height());
        goto L17
    L15:
        if (size.getHeight() <= 0) goto L17;
        goto L16
    }

    private Map<String, DisplayHashParams> getDisplayHashAlgorithms() {
        Object r0 = this.mDisplayHashAlgorithmsLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDisplayHashAlgorithms == null) goto L11;
        Map<String, DisplayHashParams> r1 = this.mDisplayHashAlgorithms;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        SyncCommand syncCommand = new SyncCommand(this, null);     // Catch: Throwable -> L9
        Bundle results = syncCommand.run(new DisplayHashController$$ExternalSyntheticLambda3());     // Catch: Throwable -> L9
        this.mDisplayHashAlgorithms = new HashMap(results.size());     // Catch: Throwable -> L9
        Iterator<String> r3 = results.keySet().iterator();     // Catch: Throwable -> L9
    L13:
        if (r3.hasNext() == false) goto L15;
        String key = r3.next();     // Catch: Throwable -> L9
        this.mDisplayHashAlgorithms.put(key, (DisplayHashParams) results.getParcelable(key));     // Catch: Throwable -> L9
        goto L13
    L15:
        Map<String, DisplayHashParams> r4 = this.mDisplayHashAlgorithms;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    }

    private static /* synthetic */ void lambda$getDisplayHashAlgorithms$2(IDisplayHashingService service, RemoteCallback remoteCallback) {
        service.getDisplayHashAlgorithms(remoteCallback);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to invoke getDisplayHashAlgorithms command", e);
    }

    void sendDisplayHashError(RemoteCallback callback, int errorCode) {
        Bundle bundle = new Bundle();
        bundle.putInt("DISPLAY_HASH_ERROR_CODE", errorCode);
        callback.sendResult(bundle);
    }

    void calculateDisplayHashBoundsLocked(WindowState win, Rect boundsInWindow, Rect outBounds) {
        outBounds.set(boundsInWindow);
        DisplayContent displayContent = win.getDisplayContent();
        if (displayContent != null) goto L5;
        return;
    L5:
        Rect windowBounds = new Rect();
        win.getBounds(windowBounds);
        windowBounds.offsetTo(0, 0);
        outBounds.intersectUnchecked(windowBounds);
        if (outBounds.isEmpty() == false) goto L8;
        return;
    L8:
        win.getTransformationMatrix(this.mTmpFloat9, this.mTmpMatrix);
        this.mTmpRectF.set(outBounds);
        this.mTmpMatrix.mapRect(this.mTmpRectF, this.mTmpRectF);
        outBounds.set((int) this.mTmpRectF.left, (int) this.mTmpRectF.top, (int) this.mTmpRectF.right, (int) this.mTmpRectF.bottom);
        MagnificationSpec magSpec = displayContent.getMagnificationSpec();
        if (magSpec == null) goto L12;
        outBounds.scale(magSpec.scale);
        outBounds.offset((int) magSpec.offsetX, (int) magSpec.offsetY);
    L12:
        if (outBounds.isEmpty() == false) goto L14;
        return;
    L14:
        Rect displayBounds = displayContent.getBounds();
        outBounds.intersectUnchecked(displayBounds);
    }

    private int getIntervalBetweenRequestMillis() {
        Object r0 = this.mIntervalBetweenRequestsLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntervalBetweenRequestMillis == (-1)) goto L11;
        int r1 = this.mIntervalBetweenRequestMillis;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        SyncCommand syncCommand = new SyncCommand(this, null);     // Catch: Throwable -> L9
        Bundle results = syncCommand.run(new DisplayHashController$$ExternalSyntheticLambda1());     // Catch: Throwable -> L9
        this.mIntervalBetweenRequestMillis = results.getInt("android.service.displayhash.extra.INTERVAL_BETWEEN_REQUESTS", 0);     // Catch: Throwable -> L9
        int r3 = this.mIntervalBetweenRequestMillis;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    }

    private static /* synthetic */ void lambda$getIntervalBetweenRequestMillis$3(IDisplayHashingService service, RemoteCallback remoteCallback) {
        service.getIntervalBetweenRequestsMillis(remoteCallback);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to invoke getDisplayHashAlgorithms command", e);
    }

    private void connectAndRun(Command command) {
        Object r0 = this.mServiceConnectionLock;
        monitor-enter(r0);
        this.mHandler.resetTimeoutMessage();     // Catch: Throwable -> L11
        if (this.mServiceConnection != null) goto L17;
        ComponentName component = getServiceComponentName();     // Catch: Throwable -> L11
        if (component == null) goto L17;
        Intent intent = new Intent();     // Catch: Throwable -> L11
        intent.setComponent(component);     // Catch: Throwable -> L11
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        this.mServiceConnection = new DisplayHashingServiceConnection(this, null);     // Catch: Throwable -> L13
        this.mContext.bindService(intent, this.mServiceConnection, 1);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L11
        goto L17
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L17:
        if (this.mServiceConnection == null) goto L19;
        DisplayHashingServiceConnection.m9918$$Nest$mrunCommandLocked(this.mServiceConnection, command);     // Catch: Throwable -> L11
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private ServiceInfo getServiceInfo() {
        String packageName = this.mContext.getPackageManager().getServicesSystemSharedLibraryPackageName();
        if (packageName != null) goto L6;
        Slog.w(TAG, "no external services package!");
        return null;
    L6:
        Intent intent = new Intent("android.service.displayhash.DisplayHashingService");
        intent.setPackage(packageName);
        long token = Binder.clearCallingIdentity();
        ResolveInfo resolveInfo = this.mContext.getPackageManager().resolveService(intent, 132);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(token);
        if (resolveInfo != null) goto L11;
    L15:
        Slog.w(TAG, "No valid components found.");
        return null;
    L11:
        if (resolveInfo.serviceInfo == null) goto L15;
        return resolveInfo.serviceInfo;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private ComponentName getServiceComponentName() {
        ServiceInfo serviceInfo = getServiceInfo();
        if (serviceInfo != null) goto L5;
        return null;
    L5:
        ComponentName name = new ComponentName(serviceInfo.packageName, serviceInfo.name);
        if ("android.permission.BIND_DISPLAY_HASHING_SERVICE".equals(serviceInfo.permission) == true) goto L9;
        Slog.w(TAG, name.flattenToShortString() + " requires permission android.permission.BIND_DISPLAY_HASHING_SERVICE");
        return null;
    L9:
        return name;
    }
}
