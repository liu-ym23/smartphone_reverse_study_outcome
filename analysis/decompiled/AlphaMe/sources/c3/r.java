package c3;

import Z2.InterfaceC0134k;
import Z2.n0;
import Z2.o0;
import Z2.x0;
import d3.u;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class r extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f4515a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(o oVar) {
        super(2);
        this.f4515a = oVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int iIntValue = ((Number) obj).intValue();
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        CoroutineContext.Key<?> key = element.getKey();
        CoroutineContext.Element element2 = this.f4515a.f4509b.get(key);
        if (key != n0.f2230a) {
            return Integer.valueOf(element != element2 ? Integer.MIN_VALUE : iIntValue + 1);
        }
        o0 o0Var = (o0) element2;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        o0 parent = (o0) element;
        while (true) {
            if (parent != null) {
                if (parent == o0Var || !(parent instanceof u)) {
                    break;
                }
                InterfaceC0134k interfaceC0134k = (InterfaceC0134k) x0.f2259b.get((x0) parent);
                parent = interfaceC0134k != null ? interfaceC0134k.getParent() : null;
            } else {
                parent = null;
                break;
            }
        }
        if (parent == o0Var) {
            if (o0Var != null) {
                iIntValue++;
            }
            return Integer.valueOf(iIntValue);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + parent + ", expected child of " + o0Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
