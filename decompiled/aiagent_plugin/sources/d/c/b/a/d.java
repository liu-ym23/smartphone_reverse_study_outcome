package d.c.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends a {
    private final d.c.g _context;
    private transient d.c.d<Object> intercepted;

    public d(d.c.d<Object> r3, d.c.g r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        super(r5);
        this._context = r6;
    }

    public d(d.c.d<Object> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        d.c.g r0 = r4.getContext();
    L6:
        this(r4, r0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // d.c.d
    public d.c.g getContext() {
        d.c.g r0 = this._context;
        o.a(r0);
        return r0;
    }

    public final d.c.d<Object> intercepted() {
        d.c.d<Object> r0 = this.intercepted;
        if (r0 != null) goto L10;
        d.c.e r1 = (d.c.e) ZeusTransformUtils.preCheckCast(getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin")), d.c.e.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        r0 = r1.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        if (r0 == null) goto L8;
    L9:
        this.intercepted = r0;
    L8:
        r0 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
    L10:
        return r0;
    }

    @Override // d.c.b.a.a
    public void releaseIntercepted() {
        d.c.d<?> r0 = this.intercepted;
        if (r0 == null) goto L6;
        if (r0 == this) goto L6;
        d.c.g.b r2 = getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin"));
        o.a(r2);
        ((d.c.e) ZeusTransformUtils.preCheckCast(r2, d.c.e.class, "com.obric.aiagent.plugin")).b(r0);
    L6:
        this.intercepted = (d.c.d) ZeusTransformUtils.preCheckCast(c.f38409a, d.c.d.class, "com.obric.aiagent.plugin");
    }
}
