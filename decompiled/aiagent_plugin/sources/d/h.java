package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class h {

    /* JADX INFO: compiled from: LazyJVM.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38476a = null;

        static {
            int[] r0 = new int[j.values().length];
            r0[j.f38505a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[j.f38506b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[j.f38507c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f38476a = r0;
        }
    }

    public static final <T> f<T> a(d.h.a.a<? extends T> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "initializer");
        d.h.b.h r2 = null;
        return (f) ZeusTransformUtils.preCheckCast(new q(r5, r2, 2, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static final <T> f<T> a(j r3, d.h.a.a<? extends T> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "mode");
        d.h.b.o.e(r5, "initializer");
        int r6 = a.f38476a[r3.ordinal()];
        int r2 = 2;
        if (r6 == 1) goto L11;
        if (r6 == 2) goto L14;
        if (r6 != 3) goto L9;
        return (f) ZeusTransformUtils.preCheckCast(new y(r5), f.class, "com.obric.aiagent.plugin");
    L9:
        throw new k();
    L14:
        return (f) ZeusTransformUtils.preCheckCast(new p(r5), f.class, "com.obric.aiagent.plugin");
    L11:
        d.h.b.h r0 = null;
        return (f) ZeusTransformUtils.preCheckCast(new q(r5, r0, r2, r0), f.class, "com.obric.aiagent.plugin");
    }
}
