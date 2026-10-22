package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PlayerDelayTimer;", "", "delayTime", "", "runnable", "Ljava/lang/Runnable;", "(JLjava/lang/Runnable;)V", "MSG", "", "getDelayTime", "()J", "handler", "com/bytedance/android/livesdkapi/roomplayer/PlayerDelayTimer$handler$2$1", "getHandler", "()Lcom/bytedance/android/livesdkapi/roomplayer/PlayerDelayTimer$handler$2$1;", "handler$delegate", "Lkotlin/Lazy;", "getRunnable", "()Ljava/lang/Runnable;", "state", "cancel", "", "isWaitRunning", "", "start", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerDelayTimer {
    public static final Companion Companion = null;
    public static final int STATE_CANCEL = 1;
    public static final int STATE_FINISH = 3;
    public static final int STATE_UNDEFINED = 4;
    public static final int STATE_WAIT_RUNNING = 2;
    private final int MSG;
    private final long delayTime;
    private final Lazy handler$delegate;
    private final Runnable runnable;
    private volatile int state;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PlayerDelayTimer$Companion;", "", "()V", "STATE_CANCEL", "", "STATE_FINISH", "STATE_UNDEFINED", "STATE_WAIT_RUNNING", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final PlayerDelayTimer$handler$2.AnonymousClass1 getHandler() {
        return (PlayerDelayTimer$handler$2.AnonymousClass1) this.handler$delegate.getValue();
    }

    public final synchronized void cancel() {
        monitor-enter(this);
        getHandler().removeMessages(this.MSG);     // Catch: Throwable -> L6
        this.state = 1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void start() {
        monitor-enter(this);
        getHandler().sendMessageDelayed(getHandler().obtainMessage(this.MSG), this.delayTime);     // Catch: Throwable -> L6
        this.state = 2;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean isWaitRunning() {
        if (this.state != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getDelayTime() {
        return this.delayTime;
    }

    public final Runnable getRunnable() {
        return this.runnable;
    }

    public static final /* synthetic */ int access$getState$p(PlayerDelayTimer r100) {
        return r100.state;
    }

    public PlayerDelayTimer(long r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r101, "runnable");
        this.delayTime = r100;
        this.runnable = r101;
        this.state = 4;
        this.MSG = 1;
        this.handler$delegate = LazyKt.lazy(new PlayerDelayTimer$handler$2(this));
    }

    public static final /* synthetic */ void access$setState$p(PlayerDelayTimer r100, int r101) {
        r100.state = r101;
    }
}
