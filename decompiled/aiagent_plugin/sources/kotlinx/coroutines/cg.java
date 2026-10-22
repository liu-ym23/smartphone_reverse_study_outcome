package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class cg {

    /* JADX INFO: compiled from: Job.kt */
    /* synthetic */ class a extends d.h.b.l implements d.h.a.b<Throwable, d.x> {
        a(Object r8) {
            super(1, r8, bw.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        public final void a(Throwable r3) {
            ((bw) ZeusTransformUtils.preCheckCast(this.receiver, bw.class, "com.obric.aiagent.plugin")).a(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    public static /* synthetic */ bf a(ca r1, boolean r2, boolean r3, bw r4, int r5, Object r6) {
        ca r7 = (ca) ZeusTransformUtils.wrapperContextForParams(r1, ca.class, "com.obric.aiagent.plugin");
        bw r8 = (bw) ZeusTransformUtils.wrapperContextForParams(r4, bw.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        return ce.a(r7, r2, r3, r8);
    }

    public static final bf a(ca r2, boolean r3, boolean r4, bw r5) {
        ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
        bw r7 = (bw) ZeusTransformUtils.wrapperContextForParams(r5, bw.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ci.class) == false) goto L6;
        return ((ci) ZeusTransformUtils.preCheckCast(r6, ci.class, "com.obric.aiagent.plugin")).a(r3, r4, r7);
    L6:
        return r6.a(r3, r4, (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r7), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final z a(ca r2) {
        return (z) ZeusTransformUtils.preCheckCast(new cd((ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ z a(ca r1, int r2, Object r3) {
        ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r1, ca.class, "com.obric.aiagent.plugin");
        if ((r2 & 1) == 0) goto L6;
        r4 = null;
    L6:
        return ce.a(r4);
    }

    public static final bf a(ca r8, bf r9) {
        return ce.a((ca) ZeusTransformUtils.wrapperContextForParams(r8, ca.class, "com.obric.aiagent.plugin"), false, false, (bw) ZeusTransformUtils.preCheckCast(new bh((bf) ZeusTransformUtils.wrapperContextForParams(r9, bf.class, "com.obric.aiagent.plugin")), bw.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static final Object a(ca r2, d.c.d<? super d.x> r3) {
        ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        ca.a.a(r4, null, 1, null);
        Object r6 = r4.b(r5);
        if (r6 != d.c.a.b.a()) goto L6;
        return r6;
    L6:
        return d.x.f38692a;
    }

    public static final boolean a(d.c.g r3) {
        ca r4 = (ca) ZeusTransformUtils.preCheckCast(((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin")).get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return true;
    L7:
        return r4.b();
    }

    public static /* synthetic */ void a(d.c.g r1, CancellationException r2, int r3, Object r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r1, d.c.g.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        ce.a(r5, r2);
    }

    public static final void a(d.c.g r3, CancellationException r4) {
        ca r5 = (ca) ZeusTransformUtils.preCheckCast(((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin")).get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r5.a(r4);
        return;
    }

    public static final void b(ca r2) {
        ca r3 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
        if (r3.b() == false) goto L6;
        return;
    L6:
        throw r3.k();
    }

    public static final void b(d.c.g r3) {
        ca r4 = (ca) ZeusTransformUtils.preCheckCast(((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin")).get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        ce.b(r4);
        return;
    }

    public static final void a(ca r2, String r3, Throwable r4) {
        ((ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin")).a(bo.a(r3, r4));
    }

    public static /* synthetic */ void a(ca r1, String r2, Throwable r3, int r4, Object r5) {
        ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r1, ca.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        ce.a(r6, r2, r3);
    }

    public static final ca c(d.c.g r3) {
        d.c.g r4 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        ca r0 = (ca) ZeusTransformUtils.preCheckCast(r4.get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + r4).toString());
    }
}
