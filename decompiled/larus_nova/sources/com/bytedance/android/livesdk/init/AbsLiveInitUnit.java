package com.bytedance.android.livesdk.init;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0004J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "", "()V", "initLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getInitLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "initStatus", "Lcom/bytedance/android/livesdk/init/LiveInitStatus;", "getInitStatus", "()Lcom/bytedance/android/livesdk/init/LiveInitStatus;", "setInitStatus", "(Lcom/bytedance/android/livesdk/init/LiveInitStatus;)V", "getInitThreadWithConfig", "Lcom/bytedance/android/livesdk/init/InitThread;", "config", "", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "lazyInitThread", "needBlock", "", "postDelayTime", "", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsLiveInitUnit {
    private final ReentrantLock initLock;
    private volatile LiveInitStatus initStatus;

    public abstract LiveInitUnitKey getUnitKey();

    public abstract LiveInitPoint initPoint();

    public abstract void initialize();

    public long postDelayTime() {
        return 0;
    }

    public AbsLiveInitUnit() {
        this.initLock = new ReentrantLock();
        this.initStatus = LiveInitStatus.NOT_INIT;
    }

    public final boolean needBlock() {
        if (initPoint() != LiveInitPoint.PRE_INIT) goto L5;
        return true;
    L5:
        if (initPoint() == LiveInitPoint.COMPLETE_INIT) goto L11;
        return false;
    L11:
        return true;
    }

    public final ReentrantLock getInitLock() {
        return this.initLock;
    }

    public final LiveInitStatus getInitStatus() {
        return this.initStatus;
    }

    public InitThread lazyInitThread() {
        return InitThread.MAIN;
    }

    public final InitThread getInitThreadWithConfig(int r100) {
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L13;
        return InitThread.WITH_CALLER;
    L13:
        return InitThread.WITH_CALLER;
    L14:
        return InitThread.MAIN;
    L11:
        return InitThread.BACK_GROUND;
    }

    public final void setInitStatus(LiveInitStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.initStatus = r100;
    }
}
