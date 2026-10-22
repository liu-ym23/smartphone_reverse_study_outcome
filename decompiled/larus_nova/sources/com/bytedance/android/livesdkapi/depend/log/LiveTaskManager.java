package com.bytedance.android.livesdkapi.depend.log;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes12.dex */
public class LiveTaskManager {
    private static final int DEFAULT_CAPACITY = 64;
    private static final LiveSingleExecutor.RejectionHandler DEFAULT_REJECTION_HANDLER = null;
    private static final String DEFAULT_THREAD_NAME = null;
    private static final String TAG = null;
    private static volatile LiveTaskManager inst;
    private static volatile LiveSingleExecutor.RejectionHandler sRejectHandler;
    private Executor mExecutor;
    private boolean mIsInit;
    private Handler mMainHandler;

    public synchronized void init() {
        monitor-enter(this);
        init(64);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        TAG = "LiveTaskManager";
        DEFAULT_THREAD_NAME = "LiveTaskManager-Thread";
        DEFAULT_REJECTION_HANDLER = new AnonymousClass1();
    }

    public static LiveTaskManager inst() {
        if (inst != null) goto L15;
        monitor-enter(LiveTaskManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (inst != null) goto L9;
        inst = new LiveTaskManager();     // Catch: Throwable -> L11
        inst.init();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LiveTaskManager.class);     // Catch: Throwable -> L11
    L15:
        return inst;
    }

    private LiveTaskManager() {
        this.mIsInit = false;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ LiveSingleExecutor.RejectionHandler access$100() {
        return sRejectHandler;
    }

    private static void checkInit(LiveTaskManager r100) {
        if (r100.mIsInit == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("LiveTaskManager: Must call init() before use.");
    }

    public void commit(Callable r100) {
        commit(null, r100, 0);
    }

    public synchronized void init(Executor r100) {
        monitor-enter(this);
        this.mExecutor = r100;     // Catch: Throwable -> L6
        this.mMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L6
        this.mIsInit = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void postMain(Runnable r100) {
        checkInit(this);
        Handler r101 = this.mMainHandler;
        if (r101 == null) goto L6;
        r101.post(r100);
        return;
    }

    public synchronized void registerRejectHandler(LiveSingleExecutor.RejectionHandler r100) {
        monitor-enter(this);
        sRejectHandler = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void init(int r100) {
        monitor-enter(this);
        init(r100, DEFAULT_THREAD_NAME);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void init(int r100, String r101) {
        monitor-enter(this);
        init(r100, r101, DEFAULT_REJECTION_HANDLER);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private static Runnable async(final Handler r100, final Callable r101, final int r102) {
        return new AnonymousClass2(r100, r101, r102);
    }

    public void commit(Handler r100, Callable r101, int r102) {
        checkInit(this);
        this.mExecutor.execute(async(r100, r101, r102));
    }

    public synchronized void init(int r100, String r101, LiveSingleExecutor.RejectionHandler r102) {
        monitor-enter(this);
        init(new LiveSingleExecutor.Builder().setCapacity(r100).setThreadName(r101).setRejectionHandler(r102).build());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
