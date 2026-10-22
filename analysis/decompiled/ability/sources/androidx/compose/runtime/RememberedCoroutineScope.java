package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import m9.C1730w;
import m9.InterfaceC1733z;
import m9.b0;
import m9.c0;
import m9.d0;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0018\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/RememberedCoroutineScope;", "Lm9/z;", "Landroidx/compose/runtime/RememberObserver;", "LH7/h;", "parentContext", "overlayContext", AppAgent.CONSTRUCT, "(LH7/h;LH7/h;)V", "LC7/r;", "cancelIfCreated", "()V", "onRemembered", "onForgotten", "onAbandoned", "LH7/h;", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", "Ljava/lang/Object;", "_coroutineContext", "getCoroutineContext", "()LH7/h;", "coroutineContext", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RememberedCoroutineScope implements InterfaceC1733z, RememberObserver {
    private volatile H7.h _coroutineContext;
    private final Object lock = this;
    private final H7.h overlayContext;
    private final H7.h parentContext;
    public static final int $stable = 8;
    public static final H7.h CancelledCoroutineContext = new CancelledCoroutineContext();

    public RememberedCoroutineScope(H7.h hVar, H7.h hVar2) {
        this.parentContext = hVar;
        this.overlayContext = hVar2;
    }

    public final void cancelIfCreated() {
        synchronized (this.lock) {
            try {
                H7.h hVar = this._coroutineContext;
                if (hVar == null) {
                    this._coroutineContext = CancelledCoroutineContext;
                } else {
                    kotlinx.coroutines.a.d(hVar, new ForgottenCoroutineScopeException());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // m9.InterfaceC1733z
    public H7.h getCoroutineContext() {
        H7.h hVarPlus;
        H7.h hVar = this._coroutineContext;
        if (hVar == null || hVar == CancelledCoroutineContext) {
            CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) this.parentContext.get(CompositionErrorContextImpl.INSTANCE);
            H7.h rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 = compositionErrorContextImpl != null ? new RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(C1730w.f5337a, compositionErrorContextImpl, this) : EmptyCoroutineContext.f4908a;
            synchronized (this.lock) {
                try {
                    hVarPlus = this._coroutineContext;
                    if (hVarPlus == null) {
                        H7.h hVar2 = this.parentContext;
                        hVarPlus = hVar2.plus(new d0((c0) hVar2.get(b0.f5325a))).plus(this.overlayContext).plus(rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1);
                    } else if (hVarPlus == CancelledCoroutineContext) {
                        H7.h hVar3 = this.parentContext;
                        d0 d0Var = new d0((c0) hVar3.get(b0.f5325a));
                        d0Var.A(new ForgottenCoroutineScopeException());
                        hVarPlus = hVar3.plus(d0Var).plus(this.overlayContext).plus(rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1);
                    }
                    this._coroutineContext = hVarPlus;
                } catch (Throwable th) {
                    throw th;
                }
            }
            hVar = hVarPlus;
        }
        kotlin.jvm.internal.k.c(hVar);
        return hVar;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        cancelIfCreated();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        cancelIfCreated();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
