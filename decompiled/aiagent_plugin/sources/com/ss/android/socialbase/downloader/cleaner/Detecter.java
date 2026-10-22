package com.ss.android.socialbase.downloader.cleaner;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes4.dex */
public class Detecter {
    private static final int COUNT_INIT = 0;
    private static final int DETECT_COUNT_MAX = 3;
    private static final int SMOOTH_COUNT_MAX = 15;
    private static final String TAG = "Detecter";
    private static final int THREAD_STUCK_MAX = 200;
    private static final int THREAD_STUCK_MIN = 50;
    private ExecutorService mDetecterThreadPool;
    private volatile IDetecterEventCallback mEventCallback;
    private volatile boolean mIsStop;
    private volatile Handler mMainThreadHandler;
    private volatile Semaphore mMainThreadResponseSem;
    private int mSmoothHitCount;
    private volatile DetecterState mState;
    private int mStuckHitCount;

    private static final enum DetecterState extends Enum<DetecterState> {
        private static final /* synthetic */ DetecterState[] $VALUES = null;
        public static final DetecterState DETECTER_INIT = null;
        public static final DetecterState DETECTER_SMOOTH = null;
        public static final DetecterState DETECTER_STUCK = null;

        private DetecterState(String r1, int r2) {
            super(r1, r2);
        }

        public static DetecterState valueOf(String r2) {
            return (DetecterState) ZeusTransformUtils.preCheckCast(Enum.valueOf(DetecterState.class, r2), DetecterState.class, "com.obric.aiagent.plugin");
        }

        public static DetecterState[] values() {
            return (DetecterState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DetecterState[].class, "com.obric.aiagent.plugin");
        }

        static {
            DetecterState r0 = new DetecterState("DETECTER_INIT", 0);
            DETECTER_INIT = r0;
            DetecterState r1 = new DetecterState("DETECTER_STUCK", 1);
            DETECTER_STUCK = r1;
            DetecterState r3 = new DetecterState("DETECTER_SMOOTH", 2);
            DETECTER_SMOOTH = r3;
            $VALUES = new DetecterState[]{r0, r1, r3};
        }
    }

    interface IDetecterEventCallback {
        void onSmooth();

        void onStuck();
    }

    static /* synthetic */ Semaphore access$000(Detecter r0) {
        return r0.mMainThreadResponseSem;
    }

    static /* synthetic */ Handler access$100(Detecter r0) {
        return r0.mMainThreadHandler;
    }

    static /* synthetic */ boolean access$200(Detecter r0) {
        return r0.mIsStop;
    }

    static /* synthetic */ boolean access$202(Detecter r0, boolean r1) {
        r0.mIsStop = r1;
        return r1;
    }

    static /* synthetic */ void access$300(Detecter r0, long r1, long r3) {
        r0.checkStuck(r1, r3);
    }

    static /* synthetic */ IDetecterEventCallback access$400(Detecter r0) {
        return r0.mEventCallback;
    }

    public Detecter(IDetecterEventCallback r3) {
        IDetecterEventCallback r4 = (IDetecterEventCallback) ZeusTransformUtils.wrapperContextForParams(r3, IDetecterEventCallback.class, "com.obric.aiagent.plugin");
        this.mState = DetecterState.DETECTER_INIT;
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mMainThreadResponseSem = new Semaphore(0);
        this.mDetecterThreadPool = Executors.newCachedThreadPool();
        this.mIsStop = false;
        this.mSmoothHitCount = 0;
        this.mStuckHitCount = 0;
        this.mEventCallback = r4;
    }

    public void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mState != DetecterState.DETECTER_INIT) goto L9;
        this.mState = DetecterState.DETECTER_SMOOTH;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.mDetecterThreadPool.execute(new AnonymousClass1(this));
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public void stop() {
        this.mIsStop = true;
        this.mEventCallback = null;
        this.mMainThreadResponseSem.release();
    }

    private void checkStuck(long r2, long r4) {
        long r5 = r4 - r2;
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "CheckStuck", "ping main thread duration=" + r5);
    L5:
        tryUpdateState(r5);
    }

    private void tryUpdateState(long r7) {
        if (r7 < 200) goto L12;
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "tryUpdateState", ">200ms enter real stuck");
    L7:
        this.mSmoothHitCount = 0;
        if (isStuck() == false) goto L10;
        return;
    L10:
        this.mStuckHitCount = 0;
        transToNewState(DetecterState.DETECTER_STUCK);
        return;
    L12:
        if (r7 >= 50) goto L14;
        this.mStuckHitCount = 0;
        if (isSmooth() == false) goto L25;
        return;
    L25:
        int r8 = this.mSmoothHitCount;
        if (r8 != 15) goto L28;
        transToNewState(DetecterState.DETECTER_SMOOTH);
        this.mSmoothHitCount++;
        return;
    L28:
        if (r8 >= 15) goto L35;
        this.mSmoothHitCount = r8 + 1;
        return;
    L35:
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "tryUpdateState", "50ms<=duration<=200ms enter maybe stuck");
    L16:
        this.mSmoothHitCount = 0;
        if (isStuck() == false) goto L19;
        return;
    L19:
        int r9 = this.mStuckHitCount + 1;
        this.mStuckHitCount = r9;
        if (r9 < 3) goto L32;
        this.mStuckHitCount = 0;
        transToNewState(DetecterState.DETECTER_STUCK);
        return;
    }

    boolean isStuck() {
        if (DetecterState.DETECTER_STUCK != this.mState) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isSmooth() {
        if (DetecterState.DETECTER_SMOOTH != this.mState) goto L5;
        return true;
    L5:
        return false;
    }

    void transToNewState(final DetecterState r3) {
        this.mState = r3;
        this.mDetecterThreadPool.execute(new AnonymousClass2(this, r3));
    }
}
