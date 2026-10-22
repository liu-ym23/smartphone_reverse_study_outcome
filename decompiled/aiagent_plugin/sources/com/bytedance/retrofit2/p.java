package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: HttpServiceMethod.java */
/* JADX INFO: loaded from: classes.dex */
abstract class p<ResponseT, ReturnT> extends ag<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final aa<ReturnT> f9575a;

    /* JADX INFO: compiled from: HttpServiceMethod.java */
    static final class a<ResponseT, ReturnT> extends p<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f<ResponseT, ReturnT> f9576b;

        a(aa r3, f<ResponseT, ReturnT> r4) {
            f<ResponseT, ReturnT> r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
            super(r3);
            this.f9576b = r5;
        }

        @Override // com.bytedance.retrofit2.p
        public ReturnT a(e<ResponseT> r2, Object[] r3) {
            e<ResponseT> r4 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
            return this.f9576b.a(r4);
        }
    }

    /* JADX INFO: compiled from: HttpServiceMethod.java */
    static final class b<ResponseT> extends p<ResponseT, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f<ResponseT, e<ResponseT>> f9577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f9578c;

        b(aa r3, f<ResponseT, e<ResponseT>> r4, boolean r5) {
            f<ResponseT, e<ResponseT>> r6 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
            super(r3);
            this.f9577b = r6;
            this.f9578c = r5;
        }

        @Override // com.bytedance.retrofit2.p
        public Object a(e<ResponseT> r3, Object[] r4) {
            e r5 = (e) ZeusTransformUtils.preCheckCast(this.f9577b.a((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r4[r4.length - 1], d.c.d.class, "com.obric.aiagent.plugin");
        L8:
            e = move-exception;
            return t.a(e, r6);
        L4:
            if (this.f9578c == false) goto L7;
            return t.b(r5, r6);
        L7:
            return t.a(r5, r6);
        }
    }

    /* JADX INFO: compiled from: HttpServiceMethod.java */
    static final class c<ResponseT> extends p<ResponseT, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f<ResponseT, e<ResponseT>> f9579b;

        c(aa r3, f<ResponseT, e<ResponseT>> r4) {
            f<ResponseT, e<ResponseT>> r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
            super(r3);
            this.f9579b = r5;
        }

        @Override // com.bytedance.retrofit2.p
        public Object a(e<ResponseT> r3, Object[] r4) {
            e r2 = (e) ZeusTransformUtils.preCheckCast(this.f9579b.a((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin");
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(r4[r4.length - 1], d.c.d.class, "com.obric.aiagent.plugin");
            return t.c(r2, r5);
        L5:
            e = move-exception;
            return t.a(e, r5);
        }
    }

    public abstract ReturnT a(e<ResponseT> r1, Object[] r2);

    static <ResponseT, ReturnT> p<ResponseT, ReturnT> a(ab r9, Method r10, aa r11) {
        boolean r0 = r11.f9378a;
        Annotation[] r1 = r10.getAnnotations();
        if (r0 == false) goto L11;
        Type[] r3 = r10.getGenericParameterTypes();
        Type r4 = an.b(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r3[r3.length - 1], ParameterizedType.class, "com.obric.aiagent.plugin"));
        if (an.a(r4) == ak.class) goto L7;
    L9:
        boolean r5 = false;
    L10:
        Type r6 = new an.b(null, e.class, new Type[]{r4});
        r1 = ai.a(r1);
    L12:
        f r2 = a(r9, r10, r6, r1);
        Type r7 = r2.a();
        if (r7 == okhttp3.ad.class) goto L39;
        if (r7 == ak.class) goto L37;
        if (r7 == com.bytedance.retrofit2.b.d.class) goto L35;
        if (r11.p.equals("HEAD") == true) goto L21;
    L25:
        r11.o = a(r9, r10, r7);
        if (r0 == false) goto L28;
        if (r5 == false) goto L33;
        return new c(r11, r2);
    L33:
        return new b(r11, r2, false);
    L28:
        return new a(r11, r2);
    L21:
        if (Void.class.equals(r7) == true) goto L25;
        throw an.a(r10, "HEAD method must use Void as response type.", new Object[0]);
    L35:
        throw an.a(r10, "'" + an.a(r7).getName() + "' is not a valid response body type.", new Object[0]);
    L37:
        throw an.a(r10, "Response must include generic type (e.g., SsResponse<String>)", new Object[0]);
    L39:
        throw an.a(r10, "'" + an.a(r7).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L9;
        r4 = an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.aiagent.plugin"));
        r5 = true;
        goto L10
    L11:
        r6 = r10.getGenericReturnType();
        r5 = false;
        goto L12
    }

    private static <ResponseT, ReturnT> f<ResponseT, ReturnT> a(ab r2, Method r3, Type r4, Annotation[] r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        return (f<ResponseT, ReturnT>) r2.a(r6, r5);
    L5:
        e = move-exception;
        throw an.a(r3, e, "Unable to create call adapter for %s", new Object[]{r6});
    }

    private static <ResponseT> i<com.bytedance.retrofit2.e.i, ResponseT> a(ab r2, Method r3, Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        return r2.b(r5, r3.getAnnotations());
    L5:
        e = move-exception;
        throw an.a(r3, e, "Unable to create converter for %s", new Object[]{r5});
    }

    p(aa<ReturnT> r1) {
        this.f9575a = r1;
    }

    @Override // com.bytedance.retrofit2.ag
    final ReturnT a(Object[] r3) {
        return a(new aj(this.f9575a, r3), r3);
    }
}
