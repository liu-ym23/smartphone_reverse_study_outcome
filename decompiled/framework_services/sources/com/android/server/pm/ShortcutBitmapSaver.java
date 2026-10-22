package com.android.server.pm;

import android.content.pm.ShortcutInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.util.Slog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutBitmapSaver {
    private static final boolean ADD_DELAY_BEFORE_SAVE_FOR_TEST = false;
    private static final boolean DEBUG = false;
    private static final long SAVE_DELAY_MS_FOR_TEST = 1000;
    private static final String TAG = "ShortcutService";
    private final long SAVE_WAIT_TIMEOUT_MS;
    private final Executor mExecutor;
    private final Deque<PendingItem> mPendingItems;
    private final Runnable mRunnable;
    private final ShortcutService mService;

    private static class PendingItem {
        public final byte[] bytes;
        private final long mInstantiatedUptimeMillis;
        public final ShortcutInfo shortcut;

        /* synthetic */ PendingItem(ShortcutInfo r1, byte[] r2, ShortcutBitmapSaverIA r3) {
            this(r1, r2);
        }

        private PendingItem(ShortcutInfo shortcut, byte[] bytes) {
            this.shortcut = shortcut;
            this.bytes = bytes;
            this.mInstantiatedUptimeMillis = SystemClock.uptimeMillis();
        }

        public String toString() {
            return "PendingItem{size=" + this.bytes.length + " age=" + (SystemClock.uptimeMillis() - this.mInstantiatedUptimeMillis) + "ms shortcut=" + this.shortcut.toInsecureString() + "}";
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0cDwbUuQexB0Dry-KJy6ApKQ1Ic, reason: not valid java name */
    public static /* synthetic */ void m6899$r8$lambda$0cDwbUuQexB0DryKJy6ApKQ1Ic(CountDownLatch r0) {
        lambda$waitForAllSavesLocked$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$wKssjE-q5ILUoVR6U1K1OFvMExk, reason: not valid java name */
    public static /* synthetic */ void m6900$r8$lambda$wKssjEq5ILUoVR6U1K1OFvMExk(ShortcutBitmapSaver r0) {
        r0.lambda$new$1();
    }

    public ShortcutBitmapSaver(ShortcutService service) {
        this.SAVE_WAIT_TIMEOUT_MS = 5000;
        this.mExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.mPendingItems = new LinkedBlockingDeque();
        this.mRunnable = new ShortcutBitmapSaver$$ExternalSyntheticLambda0(this);
        this.mService = service;
    }

    public boolean waitForAllSavesLocked() {
        final CountDownLatch latch = new CountDownLatch(1);
        this.mExecutor.execute(new ShortcutBitmapSaver$$ExternalSyntheticLambda1(latch));
        if (latch.await(5000, TimeUnit.MILLISECONDS) == false) goto L6;
        return true;
    L6:
        this.mService.wtf("Timed out waiting on saving bitmaps.");     // Catch: InterruptedException -> L8
        return false;
    L9:
        Slog.w(TAG, "interrupted");
        return false;
    }

    private static /* synthetic */ void lambda$waitForAllSavesLocked$0(CountDownLatch latch) {
        latch.countDown();
    }

    public String getBitmapPathMayWaitLocked(ShortcutInfo shortcut) {
        boolean success = waitForAllSavesLocked();
        if (success == true) goto L5;
        return null;
    L5:
        if (shortcut.hasIconFile() == true) goto L7;
        return null;
    L7:
        return shortcut.getBitmapPath();
    }

    public void removeIcon(ShortcutInfo shortcut) {
        shortcut.setIconResourceId(0);
        shortcut.setIconResName(null);
        shortcut.setBitmapPath(null);
        shortcut.setIconUri(null);
        shortcut.clearFlags(35340);
    }

    public void saveBitmapLocked(ShortcutInfo shortcut, int maxDimension, Bitmap.CompressFormat format, int quality) {
        Icon icon = shortcut.getIcon();
        icon.getClass();
        Bitmap original = icon.getBitmap();
        if (original != null) goto L6;
        Log.e(TAG, "Missing icon: " + shortcut);
        return;
    L6:
        StrictMode.ThreadPolicy oldPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(oldPolicy).permitCustomSlowCalls().build());     // Catch: Throwable -> L19 Throwable -> L21
        Bitmap shrunk = ShortcutService.shrinkBitmap(original, maxDimension);     // Catch: Throwable -> L19 Throwable -> L21
        ByteArrayOutputStream out = new ByteArrayOutputStream(65536);     // Catch: Throwable -> L35
    L12:
        th = move-exception;
        out.close();     // Catch: Throwable -> L39
    L41:
        throw th;     // Catch: Throwable -> L35
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L35
        goto L41
    L10:
        if (shrunk.compress(format, quality, out) == true) goto L14;
        Slog.wtf(TAG, "Unable to compress bitmap");     // Catch: Throwable -> L12
    L14:
        out.flush();     // Catch: Throwable -> L12
        byte[] bytes = out.toByteArray();     // Catch: Throwable -> L12
        out.close();     // Catch: Throwable -> L12
        out.close();     // Catch: Throwable -> L35
        if (shrunk == original) goto L23;
        shrunk.recycle();     // Catch: Throwable -> L19 Throwable -> L21 Throwable -> L21 Throwable -> L21
    L23:
        StrictMode.setThreadPolicy(oldPolicy);
        shortcut.addFlags(2056);
        if (icon.getType() != 5) goto L26;
        shortcut.addFlags(512);
    L26:
        PendingItem item = new PendingItem(shortcut, bytes, null);
        Deque<PendingItem> r6 = this.mPendingItems;
        monitor-enter(r6);
        this.mPendingItems.add(item);     // Catch: Throwable -> L32
        monitor-exit(r6);     // Catch: Throwable -> L32
        this.mExecutor.execute(this.mRunnable);
        return;
    L32:
        th = move-exception;
        throw th;
    L35:
        th = move-exception;
        if (shrunk == original) goto L45;
        shrunk.recycle();     // Catch: Throwable -> L19 Throwable -> L21 Throwable -> L21 Throwable -> L21
    L45:
        throw th;     // Catch: Throwable -> L19 Throwable -> L21 Throwable -> L21 Throwable -> L21
    L19:
        th = move-exception;
        StrictMode.setThreadPolicy(oldPolicy);
        throw th;
    L21:
        e = move-exception;
        Slog.wtf(TAG, "Unable to write bitmap to file", e);     // Catch: Throwable -> L19
        StrictMode.setThreadPolicy(oldPolicy);
    }

    private /* synthetic */ void lambda$new$1() {
    L3:
        if (processPendingItems() == true) goto L3;
    }

    private boolean processPendingItems() {
        ShortcutInfo shortcut = null;
        Deque<PendingItem> r2 = this.mPendingItems;     // Catch: Throwable -> L37
        monitor-enter(r2);     // Catch: Throwable -> L37
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L6:
        if (this.mPendingItems.size() != 0) goto L17;
        monitor-exit(r2);     // Catch: Throwable -> L15
        if (0 != 0) goto L10;
        return false;
    L10:
        if (shortcut.getBitmapPath() != null) goto L12;
        removeIcon(null);
    L12:
        shortcut.clearFlags(2048);
        return false;
    L17:
        PendingItem item = this.mPendingItems.pop();     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        shortcut = item.shortcut;     // Catch: Throwable -> L37
        if (shortcut.isIconPendingSave() == false) goto L23;
        File file = null;
        ShortcutService.FileOutputStreamWithPath out = this.mService.openIconFileForWrite(shortcut.getUserId(), shortcut);     // Catch: Throwable -> L37 Throwable -> L39
        File file2 = out.getFile();     // Catch: Throwable -> L37 Throwable -> L39
        out.write(item.bytes);     // Catch: Throwable -> L41
        IoUtils.closeQuietly(out);     // Catch: Throwable -> L37 Throwable -> L39 Throwable -> L39
        String path = file2.getAbsolutePath();     // Catch: Throwable -> L37 Throwable -> L39 Throwable -> L39
        shortcut.setBitmapPath(path);     // Catch: Throwable -> L37 Throwable -> L39 Throwable -> L39
        if (shortcut.getBitmapPath() != null) goto L35;
        removeIcon(shortcut);
    L35:
        shortcut.clearFlags(2048);
        return true;
    L41:
        th = move-exception;
        IoUtils.closeQuietly(out);     // Catch: Throwable -> L37 Throwable -> L39 Throwable -> L39
        throw th;     // Catch: Throwable -> L37 Throwable -> L39 Throwable -> L39
    L39:
        e = move-exception;
        Slog.e(TAG, "Unable to write bitmap to file", e);     // Catch: Throwable -> L37
        if (0 == 0) goto L51;
        if (file.exists() == false) goto L51;
        file.delete();     // Catch: Throwable -> L37
    L51:
        if (shortcut.getBitmapPath() != null) goto L53;
        removeIcon(shortcut);
    L53:
        shortcut.clearFlags(2048);
        return true;
    L23:
        if (shortcut.getBitmapPath() != null) goto L25;
        removeIcon(shortcut);
    L25:
        shortcut.clearFlags(2048);
        return true;
    L37:
        th = move-exception;
        if (shortcut != null) goto L60;
    L63:
        throw th;
    L60:
        if (shortcut.getBitmapPath() != null) goto L62;
        removeIcon(shortcut);
    L62:
        shortcut.clearFlags(2048);
        goto L63
    }

    public void dumpLocked(PrintWriter pw, String prefix) {
        Deque<PendingItem> r0 = this.mPendingItems;
        monitor-enter(r0);
        int N = this.mPendingItems.size();     // Catch: Throwable -> L8
        pw.print(prefix);     // Catch: Throwable -> L8
        pw.println("Pending saves: Num=" + N + " Executor=" + this.mExecutor);     // Catch: Throwable -> L8
        Iterator<PendingItem> r2 = this.mPendingItems.iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        PendingItem item = r2.next();     // Catch: Throwable -> L8
        pw.print(prefix);     // Catch: Throwable -> L8
        pw.print("  ");     // Catch: Throwable -> L8
        pw.println(item);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
