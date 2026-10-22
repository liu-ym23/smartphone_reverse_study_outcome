package d.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface e extends g.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f38420b = null;

    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class a {
        public static <E extends g.b> E a(e r4, g.c<E> r5) {
            e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
            g.c r7 = (g.c) ZeusTransformUtils.wrapperContextForParams(r5, g.c.class, "com.obric.aiagent.plugin");
            o.e(r7, "key");
            if (ZeusTransformUtils.instanceOf(r7, d.c.b.class) == false) goto L11;
            if (((d.c.b) ZeusTransformUtils.preCheckCast(r7, d.c.b.class, "com.obric.aiagent.plugin")).a(r6.getKey()) == false) goto L14;
            E r8 = (E) ((d.c.b) ZeusTransformUtils.preCheckCast(r7, d.c.b.class, "com.obric.aiagent.plugin")).a((g.b) ZeusTransformUtils.preCheckCast(r6, g.b.class, "com.obric.aiagent.plugin"));
            if (ZeusTransformUtils.instanceOf(r8, g.b.class) == true) goto L9;
            return null;
        L9:
            return r8;
        L14:
            return null;
        L11:
            if (e.f38420b != r7) goto L16;
            o.a(r6, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return (E) ZeusTransformUtils.preCheckCast(r6, g.b.class, "com.obric.aiagent.plugin");
        L16:
            return null;
        }

        public static g b(e r3, g.c<?> r4) {
            e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
            g.c r6 = (g.c) ZeusTransformUtils.wrapperContextForParams(r4, g.c.class, "com.obric.aiagent.plugin");
            o.e(r6, "key");
            if (ZeusTransformUtils.instanceOf(r6, d.c.b.class) == false) goto L11;
            boolean r0 = ((d.c.b) ZeusTransformUtils.preCheckCast(r6, d.c.b.class, "com.obric.aiagent.plugin")).a(r5.getKey());
            Object r7 = r5;
            if (r0 == false) goto L10;
            g.b r8 = ((d.c.b) ZeusTransformUtils.preCheckCast(r6, d.c.b.class, "com.obric.aiagent.plugin")).a((g.b) ZeusTransformUtils.preCheckCast(r5, g.b.class, "com.obric.aiagent.plugin"));
            r7 = r5;
            if (r8 == null) goto L10;
            r7 = h.f38423a;
        L10:
            return (g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.aiagent.plugin");
        L11:
            Object r9 = r5;
            if (e.f38420b != r6) goto L15;
            r9 = h.f38423a;
        L15:
            return (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class b implements g.c<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f38421a = null;

        static {
            f38421a = new b();
        }

        private b() {
        }
    }

    static {
        f38420b = b.f38421a;
    }

    <T> d<T> a(d<? super T> r1);

    void b(d<?> r1);
}
