package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f21632a;

    public k(Future r10) {
        this.f21632a = r10;
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable r10) {
        if (r10 == null) goto L5;
        this.f21632a.cancel(false);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        a((Throwable) r10);
        return Unit.f21064a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f21632a + ']';
    }
}
