package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 extends AbstractFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2 f21507a;

    public a1(Function2 r10) {
        this.f21507a = r10;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object a(FlowCollector r10, Continuation r11) {
        Object r12 = this.f21507a.mo0invoke(r10, r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }
}
