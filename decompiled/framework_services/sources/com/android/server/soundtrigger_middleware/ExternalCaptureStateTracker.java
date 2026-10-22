package com.android.server.soundtrigger_middleware;

import android.util.Slog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes3.dex */
class ExternalCaptureStateTracker implements ICaptureStateNotifier {
    private static final String TAG = "CaptureStateTracker";
    private boolean mCaptureActive;
    private final List<ICaptureStateNotifier.Listener> mListeners;
    private final Semaphore mNeedToConnect;

    public static /* synthetic */ void $r8$lambda$hBoIWCt1wAYBh9Th4QLOGaxIoV0(ExternalCaptureStateTracker r0) {
        r0.run();
    }

    private native void connect();

    ExternalCaptureStateTracker() {
        this.mListeners = new LinkedList();
        this.mCaptureActive = true;
        this.mNeedToConnect = new Semaphore(1);
        new Thread(new ExternalCaptureStateTracker$$ExternalSyntheticLambda0(this)).start();
    }

    @Override // com.android.server.soundtrigger_middleware.ICaptureStateNotifier
    public boolean registerListener(ICaptureStateNotifier.Listener listener) {
        List<ICaptureStateNotifier.Listener> r0 = this.mListeners;
        monitor-enter(r0);
        this.mListeners.add(listener);     // Catch: Throwable -> L7
        boolean r1 = this.mCaptureActive;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.soundtrigger_middleware.ICaptureStateNotifier
    public void unregisterListener(ICaptureStateNotifier.Listener listener) {
        List<ICaptureStateNotifier.Listener> r0 = this.mListeners;
        monitor-enter(r0);
        this.mListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void run() {
    L2:
        this.mNeedToConnect.acquireUninterruptibly();
        connect();
        goto L2
    }

    private void setCaptureState(boolean active) {
        List<ICaptureStateNotifier.Listener> r0 = this.mListeners;     // Catch: Exception -> L14
        monitor-enter(r0);     // Catch: Exception -> L14
        this.mCaptureActive = active;     // Catch: Throwable -> L8
        Iterator<ICaptureStateNotifier.Listener> r1 = this.mListeners.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        ICaptureStateNotifier.Listener listener = r1.next();     // Catch: Throwable -> L8
        listener.onCaptureStateChange(active);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
    L22:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Slog.e(TAG, "Exception caught while setting capture state", e);
    }

    private void binderDied() {
        Slog.w(TAG, "Audio policy service died");
        this.mNeedToConnect.release();
    }
}
