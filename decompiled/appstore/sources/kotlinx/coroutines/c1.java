package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f21319a;

    public c1(Function1 r10) {
        this.f21319a = r10;
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable r10) {
        this.f21319a.invoke(r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        a((Throwable) r10);
        return Unit.f21064a;
    }

    public String toString() {
        return "InvokeOnCancel[" + e0.a(this.f21319a) + '@' + e0.b(this) + ']';
    }
}
