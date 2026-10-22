package androidx.compose.runtime;

import S7.n;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import m9.AbstractC1683A;
import m9.C1730w;
import m9.InterfaceC1731x;
import m9.InterfaceC1733z;
import m9.c0;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R0\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/compose/runtime/LaunchedEffectImpl;", "Landroidx/compose/runtime/RememberObserver;", "Lm9/x;", "LH7/h;", "parentCoroutineContext", "Lkotlin/Function2;", "Lm9/z;", "LH7/c;", "LC7/r;", "", "task", AppAgent.CONSTRUCT, "(LH7/h;LS7/n;)V", "onRemembered", "()V", "onForgotten", "onAbandoned", "context", "", "exception", "handleException", "(LH7/h;Ljava/lang/Throwable;)V", "LH7/h;", "LS7/n;", "scope", "Lm9/z;", "Lm9/c0;", "job", "Lm9/c0;", "LH7/g;", "getKey", "()LH7/g;", "key", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LaunchedEffectImpl implements RememberObserver, InterfaceC1731x {
    public static final int $stable = 8;
    private c0 job;
    private final H7.h parentCoroutineContext;
    private final InterfaceC1733z scope;
    private final n task;

    public LaunchedEffectImpl(H7.h hVar, n nVar) {
        this.parentCoroutineContext = hVar;
        this.task = nVar;
        this.scope = AbstractC1683A.b(hVar.plus(hVar.get(CompositionErrorContextImpl.INSTANCE) != null ? this : EmptyCoroutineContext.f4908a));
    }

    @Override // H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) z2.l.w(this, r5, nVar);
    }

    @Override // H7.h
    public <E extends H7.f> E get(H7.g gVar) {
        return (E) z2.l.x(this, gVar);
    }

    @Override // H7.f
    public H7.g getKey() {
        return C1730w.f5337a;
    }

    @Override // m9.InterfaceC1731x
    public void handleException(H7.h context, Throwable exception) throws Throwable {
        CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) context.get(CompositionErrorContextImpl.INSTANCE);
        if (compositionErrorContextImpl != null) {
            compositionErrorContextImpl.attachComposeStackTrace(exception, this);
        }
        InterfaceC1731x interfaceC1731x = (InterfaceC1731x) this.parentCoroutineContext.get(C1730w.f5337a);
        if (interfaceC1731x == null) {
            throw exception;
        }
        interfaceC1731x.handleException(context, exception);
    }

    @Override // H7.h
    public H7.h minusKey(H7.g gVar) {
        return z2.l.C(this, gVar);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        c0 c0Var = this.job;
        if (c0Var != null) {
            c0Var.cancel(new LeftCompositionCancellationException());
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        c0 c0Var = this.job;
        if (c0Var != null) {
            c0Var.cancel(new LeftCompositionCancellationException());
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        c0 c0Var = this.job;
        if (c0Var != null) {
            CancellationException cancellationException = new CancellationException("Old job was still running!");
            cancellationException.initCause(null);
            c0Var.cancel(cancellationException);
        }
        this.job = AbstractC1683A.n(this.scope, null, this.task, 3);
    }

    @Override // H7.h
    public H7.h plus(H7.h hVar) {
        return z2.l.H(this, hVar);
    }
}
