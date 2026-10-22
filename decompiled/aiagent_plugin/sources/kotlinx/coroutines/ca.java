package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ca extends d.c.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f39180a = null;

    /* JADX INFO: compiled from: Job.kt */
    public static final class a {
        public static <E extends d.c.g.b> E a(ca r2, d.c.g.c<E> r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.c.g.c r5 = (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin");
            return (E) d.c.g.b.a.a((d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"), r5);
        }

        public static d.c.g a(ca r2, d.c.g r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
            return d.c.g.b.a.a((d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"), r5);
        }

        public static <R> R a(ca r2, R r3, d.h.a.m<? super R, ? super d.c.g.b, ? extends R> r4) {
            ca r5 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
            return (R) d.c.g.b.a.a((d.c.g.b) ZeusTransformUtils.preCheckCast(r5, d.c.g.b.class, "com.obric.aiagent.plugin"), r3, r6);
        }

        public static d.c.g b(ca r2, d.c.g.c<?> r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            d.c.g.c r5 = (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin");
            return d.c.g.b.a.b((d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"), r5);
        }

        public static /* synthetic */ void a(ca r2, CancellationException r3, int r4, Object r5) {
            ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L7;
            r3 = null;
        L7:
            r6.a(r3);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    /* JADX INFO: compiled from: Job.kt */
    public static final class b implements d.c.g.c<ca> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f39181a = null;

        static {
            f39181a = new b();
        }

        private b() {
        }
    }

    static {
        f39180a = b.f39181a;
    }

    bf a(boolean r1, boolean r2, d.h.a.b<? super Throwable, d.x> r3);

    t a(v r1);

    void a(CancellationException r1);

    bf a_(d.h.a.b<? super Throwable, d.x> r1);

    Object b(d.c.d<? super d.x> r1);

    boolean b();

    ca h();

    boolean i();

    boolean j();

    CancellationException k();

    boolean s_();
}
