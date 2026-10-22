package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class k {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39029a;

        public a(Object r1) {
            this.f39029a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.b.h
        public Object collect(i<? super T> r3, d.c.d<? super d.x> r4) {
            i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            Object r2 = r5.emit(this.f39029a, r6);
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return d.x.f38692a;
        }
    }

    public static final <T> h<T> a(d.h.a.m<? super i<? super T>, ? super d.c.d<? super d.x>, ? extends Object> r2) {
        return (h) ZeusTransformUtils.preCheckCast(new aa((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
    }

    public static final <T> h<T> a() {
        return (h) ZeusTransformUtils.preCheckCast(g.f39028a, h.class, "com.obric.aiagent.plugin");
    }

    public static final <T> h<T> b(d.h.a.m<? super kotlinx.coroutines.a.q<? super T>, ? super d.c.d<? super d.x>, ? extends Object> r9) {
        return (h) ZeusTransformUtils.preCheckCast(new e((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null), h.class, "com.obric.aiagent.plugin");
    }

    public static final <T> h<T> c(d.h.a.m<? super kotlinx.coroutines.a.q<? super T>, ? super d.c.d<? super d.x>, ? extends Object> r9) {
        return (h) ZeusTransformUtils.preCheckCast(new b((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null), h.class, "com.obric.aiagent.plugin");
    }

    public static final <T> h<T> a(T r2) {
        return (h) ZeusTransformUtils.preCheckCast(new a(r2), h.class, "com.obric.aiagent.plugin");
    }
}
