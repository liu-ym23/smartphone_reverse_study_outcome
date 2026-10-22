package kotlin.coroutines.jvm.internal;

import V3.n;
import V3.o;
import V3.v;
import a4.C0428b;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class a implements Z3.e<Object>, e, Serializable {
    private final Z3.e<Object> completion;

    public a(Z3.e<Object> eVar) {
        this.completion = eVar;
    }

    public Z3.e<v> create(Z3.e<?> eVar) {
        j4.k.g(eVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public e getCallerFrame() {
        Z3.e<Object> eVar = this.completion;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public final Z3.e<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.c(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [Z3.e, Z3.e<java.lang.Object>, java.lang.Object] */
    @Override // Z3.e
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        while (true) {
            h.b(this);
            a aVar = this;
            ?? r02 = aVar.completion;
            j4.k.d(r02);
            try {
                objInvokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                n.a aVar2 = n.f5531a;
                obj = n.a(o.a(th));
            }
            if (objInvokeSuspend == C0428b.e()) {
                return;
            }
            obj = n.a(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (!(r02 instanceof a)) {
                r02.resumeWith(obj);
                return;
            }
            this = r02;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public Z3.e<v> create(Object obj, Z3.e<?> eVar) {
        j4.k.g(eVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
