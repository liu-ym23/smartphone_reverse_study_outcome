package kotlinx.coroutines;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public final class b2 extends kotlinx.coroutines.internal.x implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f21317e;

    public b2(long r10, Continuation r11) {
        super(r11.getContext(), r11);
        this.f21317e = r10;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport
    public String P() {
        return super.P() + "(timeMillis=" + this.f21317e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        k(TimeoutKt.a(this.f21317e, DelayKt.c(getContext()), this));
    }
}
