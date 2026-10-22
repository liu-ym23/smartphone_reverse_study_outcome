package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 extends kotlinx.coroutines.flow.internal.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f21510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Continuation f21511b;

    public c1() {
        this.f21510a = -1;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* bridge */ /* synthetic */ boolean a(Object r10) {
        return c((SharedFlowImpl) r10);
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* bridge */ /* synthetic */ Continuation[] b(Object r10) {
        return d((SharedFlowImpl) r10);
    }

    public boolean c(SharedFlowImpl r10) {
        if (this.f21510a < 0) goto L6;
        return false;
    L6:
        this.f21510a = r10.S();
        return true;
    }

    public Continuation[] d(SharedFlowImpl r10) {
        long r11 = this.f21510a;
        this.f21510a = -1;
        this.f21511b = null;
        return r10.R(r11);
    }
}
