package d.c.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class k extends j implements d.h.b.j<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38416a;

    @Override // d.h.b.j
    public int getArity() {
        return this.f38416a;
    }

    public k(int r3, d.c.d<Object> r4) {
        super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        this.f38416a = r3;
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
