package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Distinct.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.h.a.b<Object, Object> f39037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.h.a.m<Object, Object, Boolean> f39038b = null;

    /* JADX INFO: compiled from: Distinct.kt */
    static final class a extends d.h.b.p implements d.h.a.m<Object, Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f39039a = null;

        static {
            f39039a = new a();
        }

        a() {
            super(2);
        }

        public final Boolean a(Object r1, Object r2) {
            return Boolean.valueOf(d.h.b.o.a(r1, r2));
        }

        @Override // d.h.a.m
        public /* synthetic */ Boolean invoke(Object r1, Object r2) {
            return a(r1, r2);
        }
    }

    /* JADX INFO: compiled from: Distinct.kt */
    static final class b extends d.h.b.p implements d.h.a.b<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f39040a = null;

        static {
            f39040a = new b();
        }

        b() {
            super(1);
        }

        @Override // d.h.a.b
        public final Object invoke(Object r1) {
            return r1;
        }
    }

    public static final <T> h<T> a(h<? extends T> r2) {
        h<T> r3 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ak.class) == false) goto L6;
        return r3;
    L6:
        return a(r3, f39037a, f39038b);
    }

    static {
        f39037a = (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f39040a, d.h.a.b.class, "com.obric.aiagent.plugin");
        f39038b = (d.h.a.m) ZeusTransformUtils.preCheckCast(a.f39039a, d.h.a.m.class, "com.obric.aiagent.plugin");
    }

    private static final <T> h<T> a(h<? extends T> r2, d.h.a.b<? super T, ? extends Object> r3, d.h.a.m<Object, Object, Boolean> r4) {
        h<T> r5 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, Object> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m<Object, Object, Boolean> r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L10;
        if (((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).f39019a != r6) goto L10;
        if (((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).f39020b != r7) goto L10;
        return r5;
    L10:
        return (h) ZeusTransformUtils.preCheckCast(new f(r5, r6, r7), h.class, "com.obric.aiagent.plugin");
    }
}
