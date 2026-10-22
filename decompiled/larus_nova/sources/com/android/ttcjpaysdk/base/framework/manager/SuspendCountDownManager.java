package com.android.ttcjpaysdk.base.framework.manager;

import android.os.CountDownTimer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/SuspendCountDownManager;", "", "countDownInterval", "", "totalTime", "(JJ)V", "countDownTimer", "Landroid/os/CountDownTimer;", "isPaused", "", "listener", "Lcom/android/ttcjpaysdk/base/framework/manager/SuspendCountDownManager$OnCountdownListener;", "remainingTime", "cancel", "", "resume", "start", "suspend", "OnCountdownListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SuspendCountDownManager {
    private final long countDownInterval;
    private CountDownTimer countDownTimer;
    private boolean isPaused;
    private OnCountdownListener listener;
    private long remainingTime;
    private final long totalTime;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/SuspendCountDownManager$OnCountdownListener;", "", "onFinish", "", "onTick", "millisUntilFinished", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCountdownListener {
        void onFinish();

        void onTick(long r100);
    }

    public final void resume() {
        this.isPaused = false;
        start(this.listener);
    }

    public final void suspend() {
        this.isPaused = true;
        CountDownTimer r100 = this.countDownTimer;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public final void cancel() {
        CountDownTimer r100 = this.countDownTimer;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public static final /* synthetic */ boolean access$isPaused$p(SuspendCountDownManager r100) {
        return r100.isPaused;
    }

    public final void start(final OnCountdownListener r100) {
        this.listener = r100;
        final long r101 = this.remainingTime;
        final long r102 = this.countDownInterval;
        this.countDownTimer = new AnonymousClass1(this, r100, r101, r102).start();
    }

    public SuspendCountDownManager(long r100, long r101) {
        this.countDownInterval = r100;
        this.totalTime = r101;
        this.remainingTime = r101;
    }

    public static final /* synthetic */ void access$setRemainingTime$p(SuspendCountDownManager r100, long r101) {
        r100.remainingTime = r101;
    }
}
