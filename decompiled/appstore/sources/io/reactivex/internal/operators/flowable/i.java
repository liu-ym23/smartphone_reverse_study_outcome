package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowableTimeoutTimed$TimeoutSupport f20643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20644b;

    public i(long r10, FlowableTimeoutTimed$TimeoutSupport r11) {
        this.f20644b = r10;
        this.f20643a = r11;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20643a.onTimeout(this.f20644b);
    }
}
