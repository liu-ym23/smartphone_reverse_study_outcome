package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/CompositionScopedCoroutineScopeCanceller;", "Landroidx/compose/runtime/RememberObserver;", "Lm9/z;", "coroutineScope", AppAgent.CONSTRUCT, "(Lm9/z;)V", "LC7/r;", "onRemembered", "()V", "onForgotten", "onAbandoned", "Lm9/z;", "getCoroutineScope", "()Lm9/z;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {
    public static final int $stable = 8;
    private final InterfaceC1733z coroutineScope;

    public CompositionScopedCoroutineScopeCanceller(InterfaceC1733z interfaceC1733z) {
        this.coroutineScope = interfaceC1733z;
    }

    public final InterfaceC1733z getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        InterfaceC1733z interfaceC1733z = this.coroutineScope;
        if (interfaceC1733z instanceof RememberedCoroutineScope) {
            ((RememberedCoroutineScope) interfaceC1733z).cancelIfCreated();
        } else {
            AbstractC1683A.e(interfaceC1733z, new LeftCompositionCancellationException());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        InterfaceC1733z interfaceC1733z = this.coroutineScope;
        if (interfaceC1733z instanceof RememberedCoroutineScope) {
            ((RememberedCoroutineScope) interfaceC1733z).cancelIfCreated();
        } else {
            AbstractC1683A.e(interfaceC1733z, new LeftCompositionCancellationException());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
