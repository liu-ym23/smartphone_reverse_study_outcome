package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableTimeoutTimed$TimeoutSupport f20686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20687b;

    public j(long r10, ObservableTimeoutTimed$TimeoutSupport r11) {
        this.f20687b = r10;
        this.f20686a = r11;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20686a.onTimeout(this.f20687b);
    }
}
