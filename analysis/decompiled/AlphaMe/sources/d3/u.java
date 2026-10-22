package d3;

import Z2.AbstractC0114a;
import Z2.AbstractC0145t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* loaded from: classes2.dex */
public class u extends AbstractC0114a implements CoroutineStackFrame {

    /* renamed from: d, reason: collision with root package name */
    public final Continuation f12479d;

    public u(Continuation continuation, CoroutineContext coroutineContext) {
        super(coroutineContext, true);
        this.f12479d = continuation;
    }

    @Override // Z2.x0
    public final boolean M() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f12479d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // Z2.x0
    public void s(Object obj) {
        AbstractC0539a.a(IntrinsicsKt.intercepted(this.f12479d), AbstractC0145t.a(obj), null);
    }

    @Override // Z2.x0
    public void t(Object obj) {
        this.f12479d.resumeWith(AbstractC0145t.a(obj));
    }
}
