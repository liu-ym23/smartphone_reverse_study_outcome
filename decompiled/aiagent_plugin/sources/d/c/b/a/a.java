package d.c.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import java.io.Serializable;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements e, d.c.d<Object>, Serializable {
    private final d.c.d<Object> completion;

    public abstract Object invokeSuspend(Object r1);

    public void releaseIntercepted() {
    }

    public a(d.c.d<Object> r3) {
        this.completion = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
    }

    public final d.c.d<Object> getCompletion() {
        return this.completion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // d.c.d
    public final void resumeWith(Object r4) {
        ?? r3 = this;
    L3:
        h.b((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        a r5 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
        d.c.d<Object> r1 = r5.completion;
        o.a(r1);
        Object r6 = r5.invokeSuspend(r4);     // Catch: Throwable -> L9
        if (r6 == d.c.a.b.a()) goto L6;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L9
        r4 = n.f(r6);     // Catch: Throwable -> L9
    L11:
        r5.releaseIntercepted();
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L14;
        r3 = r1;
        goto L3
    L14:
        r1.resumeWith(r4);
        return;
    L6:
        return;
    L9:
        th = move-exception;
        n.a r7 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L11
    }

    public d.c.d<x> create(d.c.d<?> r2) {
        o.e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin"), "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d.c.d<x> create(Object r1, d.c.d<?> r2) {
        o.e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin"), "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Continuation at ");
        StackTraceElement r1 = getStackTraceElement();
        if (r1 == null) goto L5;
        Object r3 = ZeusTransformUtils.preCheckCast(r1, Serializable.class, "com.obric.aiagent.plugin");
    L7:
        return r0.append((Serializable) r3).toString();
    L5:
        r3 = ZeusTransformUtils.preCheckCast(getClass().getName(), Serializable.class, "com.obric.aiagent.plugin");
        goto L7
    }

    @Override // d.c.b.a.e
    public e getCallerFrame() {
        d.c.d<Object> r2 = this.completion;
        if (ZeusTransformUtils.instanceOf(r2, e.class) == true) goto L7;
        return null;
    L7:
        return (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin");
    }

    @Override // d.c.b.a.e
    public StackTraceElement getStackTraceElement() {
        return g.a(this);
    }
}
