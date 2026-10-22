package d.c.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class l extends d implements d.h.b.j<Object> {
    private final int arity;

    @Override // d.h.b.j
    public int getArity() {
        return this.arity;
    }

    public l(int r3, d.c.d<Object> r4) {
        super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        this.arity = r3;
    }

    public l(int r2) {
        this(r2, null);
    }

    @Override // d.c.b.a.a
    public String toString() {
        if (getCompletion() != null) goto L6;
        String r2 = aa.a((d.h.b.j) ZeusTransformUtils.preCheckCast(this, d.h.b.j.class, "com.obric.aiagent.plugin"));
        o.c(r2, "renderLambdaToString(...)");
        return r2;
    L6:
        return super.toString();
    }
}
