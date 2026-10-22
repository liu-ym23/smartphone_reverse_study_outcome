package com.bytedance.android.livesdkapi.player;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;
import is0.c;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes12.dex */
public class PlayerTaskManager {
    private static final int DEFAULT_CAPACITY = 64;
    private static final PlayerSingleExecutor.RejectionHandler DEFAULT_REJECTION_HANDLER = null;
    private static final String DEFAULT_THREAD_NAME = null;
    private static final String TAG = null;
    private static volatile PlayerTaskManager inst;
    private static volatile PlayerSingleExecutor.RejectionHandler sRejectHandler;
    private Executor mExecutor;
    private boolean mIsInit;
    private Handler mMainHandler;

    public static class PlayerSingleHandlerExecutor implements Executor {
        private PlayerSingleHandlerExecutor() {
        }

        public /* synthetic */ PlayerSingleHandlerExecutor(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            PlayerSingleHandler.inst().doSingle(r100, 0);
        }
    }

    public synchronized void init() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (((PlayerOptimizeConfig) c.c().getConfig(PlayerOptimizeConfig.class)).getOptWorkThread() == false) goto L6;
        init(new PlayerSingleHandlerExecutor(null));     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        init(64);     // Catch: Throwable -> L9
        goto L7
    }

    static {
        TAG = "PlayerTaskManager";
        DEFAULT_THREAD_NAME = "PlayerTaskManager-Thread";
        DEFAULT_REJECTION_HANDLER = new AnonymousClass1();
    }

    public static PlayerTaskManager inst() {
        if (inst != null) goto L15;
        monitor-enter(PlayerTaskManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (inst != null) goto L9;
        inst = new PlayerTaskManager();     // Catch: Throwable -> L11
        inst.init();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlayerTaskManager.class);     // Catch: Throwable -> L11
    L15:
        return inst;
    }

    private PlayerTaskManager() {
        this.mIsInit = false;
    }

    public static /* synthetic */ PlayerSingleExecutor.RejectionHandler access$000() {
        return sRejectHandler;
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
        if (this.mIsInit == true) goto L5;
        return;
    L5:
        Handler r101 = this.mMainHandler;
        if (r101 == null) goto L9;
        r101.post(r100);
        return;
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

    public void doInSingleThread(Runnable r100, long r101) {
        PlayerSingleHandler.inst().doSingle(r100, r101);
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
        if (this.mIsInit == true) goto L5;
        return;
    L5:
        Executor r103 = this.mExecutor;
        if (r103 != null) goto L8;
        return;
    L8:
        r103.execute(async(r100, r101, r102));
    }

    public synchronized void init(int r100, String r101, PlayerSingleExecutor.RejectionHandler r102) {
        monitor-enter(this);
        init(new PlayerSingleExecutor.Builder().setCapacity(r100).setThreadName(r101).setRejectionHandler(r102).build());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
