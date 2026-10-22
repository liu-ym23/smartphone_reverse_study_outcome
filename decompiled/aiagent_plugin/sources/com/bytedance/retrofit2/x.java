package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes.dex */
abstract class x<T> {

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class a<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9630a;

        a(com.bytedance.retrofit2.i<T, String> r3) {
            this.f9630a = (com.bytedance.retrofit2.i) ZeusTransformUtils.preCheckCast(an.a((com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin"), "converter == null"), com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.a(Boolean.parseBoolean((String) ZeusTransformUtils.preCheckCast(this.f9630a.b(r4), String.class, "com.obric.aiagent.plugin")));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to AddCommonParam", e);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class b<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f9631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f9633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> f9634d;

        b(Method r3, int r4, boolean r5, com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> r6) {
            com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> r7 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9631a = r3;
            this.f9632b = r4;
            this.f9633c = r5;
            this.f9634d = r7;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r5, T r6) {
            if (r6 == null) goto L5;
        L16:
            e = move-exception;
            throw an.a(this.f9631a, e, this.f9632b, "Unable to convert " + r6 + " to RequestBody", new Object[0]);
        L11:
            if (this.f9634d.a() == false) goto L13;
            com.bytedance.retrofit2.e.j r1 = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.preCheckCast(this.f9634d.a(r6, r5), com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L16
        L14:
            r5.a(r1);
            return;
        L13:
            r1 = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.preCheckCast(this.f9634d.b(r6), com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L16
            goto L14
        L5:
            if (this.f9633c == false) goto L8;
            return;
        L8:
            throw an.a(this.f9631a, this.f9632b, "Body parameter value must not be null.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class c extends x<okhttp3.ac> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f9635a = null;

        c() {
        }

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, okhttp3.ac r4) {
            a2(r3, (okhttp3.ac) ZeusTransformUtils.preCheckCast(r4, okhttp3.ac.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9635a = new c();
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        void a2(z r1, okhttp3.ac r2) {
            if (r2 == null) goto L6;
            r1.a(r2);
            r1.a();
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class d extends x<okhttp3.ac> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final okhttp3.u f9636a;

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, okhttp3.ac r4) {
            a2(r3, (okhttp3.ac) ZeusTransformUtils.preCheckCast(r4, okhttp3.ac.class, "com.obric.aiagent.plugin"));
        }

        d(okhttp3.u r1) {
            this.f9636a = r1;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        void a2(z r1, okhttp3.ac r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            r1.a(this.f9636a, r2);
            r1.a();
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class e extends x<Map<String, okhttp3.ac>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9637a;

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, Map<String, okhttp3.ac> r4) {
            a2(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        }

        e(String r1) {
            this.f9637a = r1;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        void a2(z r8, Map<String, okhttp3.ac> r9) {
            Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L19;
            Iterator r11 = r10.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L16;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L15;
            okhttp3.ac r1 = (okhttp3.ac) ZeusTransformUtils.preCheckCast(r0.getValue(), okhttp3.ac.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L13;
            r8.a(okhttp3.u.a(new String[]{"Content-Disposition", "form-data; name=\"" + r2 + "\"", "Content-Transfer-Encoding", this.f9637a}), r1);
            goto L6
        L13:
            throw new IllegalArgumentException("Part map contained null value for key '" + r2 + "'.");
        L15:
            throw new IllegalArgumentException("Part map contained null key.");
        L16:
            r8.a();
            return;
        L19:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class f extends x<okhttp3.y.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f9638a = null;

        f() {
        }

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, okhttp3.y.c r4) {
            a2(r3, (okhttp3.y.c) ZeusTransformUtils.preCheckCast(r4, okhttp3.y.c.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9638a = new f();
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        void a2(z r1, okhttp3.y.c r2) {
            if (r2 == null) goto L4;
            r1.a(r2);
        L4:
            r1.a();
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class g<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, Object> f9639a;

        g(com.bytedance.retrofit2.i<T, Object> r3) {
            this.f9639a = (com.bytedance.retrofit2.i) ZeusTransformUtils.preCheckCast(an.a((com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin"), "converter == null"), com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.b(this.f9639a.b(r4));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to ExtraInfo", e);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class h<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f9642c;

        h(String r3, com.bytedance.retrofit2.i<T, String> r4, boolean r5) {
            com.bytedance.retrofit2.i<T, String> r6 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9640a = (String) ZeusTransformUtils.preCheckCast(an.a(r3, "name == null"), String.class, "com.obric.aiagent.plugin");
            this.f9641b = r6;
            this.f9642c = r5;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r3, T r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f9641b.b(r4), String.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L7;
            return;
        L7:
            r3.c(this.f9640a, r5, this.f9642c);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class i<T> extends x<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f9643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f9646d;

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, Object r4) {
            a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        }

        i(Method r3, int r4, com.bytedance.retrofit2.i<T, String> r5, boolean r6) {
            com.bytedance.retrofit2.i<T, String> r7 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9643a = r3;
            this.f9644b = r4;
            this.f9645c = r7;
            this.f9646d = r6;
        }

        void a(z r8, Map<String, T> r9) {
            Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L22;
            Iterator r11 = r10.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L20;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L19;
            Object r4 = r2.getValue();
            if (r4 == null) goto L17;
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f9645c.b((T) r4), String.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L15;
            r8.c(r3, r5, this.f9646d);
            goto L6
        L15:
            throw an.a(this.f9643a, this.f9644b, "Field map value '" + r4 + "' converted to null by " + this.f9645c.getClass().getName() + " for key '" + r3 + "'.", new Object[0]);
        L17:
            throw an.a(this.f9643a, this.f9644b, "Field map contained null value for key '" + r3 + "'.", new Object[0]);
        L19:
            throw an.a(this.f9643a, this.f9644b, "Field map contained null key.", new Object[0]);
        L20:
            return;
        L22:
            throw an.a(this.f9643a, this.f9644b, "Field map was null.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class j<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9648b;

        j(String r3, com.bytedance.retrofit2.i<T, String> r4) {
            com.bytedance.retrofit2.i<T, String> r5 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9647a = (String) ZeusTransformUtils.preCheckCast(an.a(r3, "name == null"), String.class, "com.obric.aiagent.plugin");
            this.f9648b = r5;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r3, T r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f9648b.b(r4), String.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L7;
            return;
        L7:
            r3.a(this.f9647a, r5);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class k<T> extends x<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.b.b> f9649a;

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, Object r4) {
            a(r3, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
        }

        k(com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.b.b> r3) {
            this.f9649a = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
        }

        void a(z r4, List<T> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L5;
            return;
        L5:
            Iterator r7 = r6.iterator();
        L7:
            if (r7.hasNext() == false) goto L9;
            Object r0 = r7.next();
            com.bytedance.retrofit2.b.b r1 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(this.f9649a.b((T) r0), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
            r4.a(r1.a(), r1.b());
            goto L7
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class l<T> extends x<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f9650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9652c;

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, Object r4) {
            a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        }

        l(Method r3, int r4, com.bytedance.retrofit2.i<T, String> r5) {
            com.bytedance.retrofit2.i<T, String> r6 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9650a = r3;
            this.f9651b = r4;
            this.f9652c = r6;
        }

        void a(z r6, Map<String, T> r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L18;
            Iterator r9 = r8.entrySet().iterator();
        L6:
            if (r9.hasNext() == false) goto L16;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L15;
            Object r4 = r2.getValue();
            if (r4 == null) goto L13;
            r6.a(r3, (String) ZeusTransformUtils.preCheckCast(this.f9652c.b((T) r4), String.class, "com.obric.aiagent.plugin"));
            goto L6
        L13:
            throw an.a(this.f9650a, this.f9651b, "Header map contained null value for key '" + r3 + "'.", new Object[0]);
        L15:
            throw an.a(this.f9650a, this.f9651b, "Header map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw an.a(this.f9650a, this.f9651b, "Header map was null.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class m<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9653a;

        m(com.bytedance.retrofit2.i<T, String> r3) {
            this.f9653a = (com.bytedance.retrofit2.i) ZeusTransformUtils.preCheckCast(an.a((com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin"), "converter == null"), com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.a(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(this.f9653a.b(r4), String.class, "com.obric.aiagent.plugin")));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to MaxLength", e);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class n<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9655b;

        n(String r3, com.bytedance.retrofit2.i<T, String> r4) {
            com.bytedance.retrofit2.i<T, String> r5 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9654a = (String) ZeusTransformUtils.preCheckCast(an.a(r3, "name == null"), String.class, "com.obric.aiagent.plugin");
            this.f9655b = r5;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r3, T r4) {
            if (r4 == null) goto L6;
            r3.b(this.f9654a, (String) ZeusTransformUtils.preCheckCast(this.f9655b.b(r4), String.class, "com.obric.aiagent.plugin"));
            return;
        L6:
            throw new IllegalArgumentException("Method parameter \"" + this.f9654a + "\" value must not be null.");
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class o<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f9656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f9658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> f9659d;

        o(Method r3, int r4, String r5, com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> r6) {
            com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> r7 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9656a = r3;
            this.f9657b = r4;
            this.f9658c = r5;
            this.f9659d = r7;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r4, T r5) {
            if (r5 != null) goto L10;
            return;
        L10:
            r4.a(this.f9658c, (com.bytedance.retrofit2.e.j) ZeusTransformUtils.preCheckCast(this.f9659d.b(r5), com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin"));
            return;
        L7:
            e = move-exception;
            throw an.a(this.f9656a, this.f9657b, "Unable to convert " + r5 + " to RequestBody", new Object[]{e});
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class p<T> extends x<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f9660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> f9662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f9663d;

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, Object r4) {
            a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        }

        p(Method r3, int r4, com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> r5, String r6) {
            com.bytedance.retrofit2.i<T, com.bytedance.retrofit2.e.j> r7 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9660a = r3;
            this.f9661b = r4;
            this.f9662c = r7;
            this.f9663d = r6;
        }

        void a(z r7, Map<String, T> r8) {
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L18;
            Iterator r10 = r9.entrySet().iterator();
        L6:
            if (r10.hasNext() == false) goto L16;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L15;
            Object r4 = r2.getValue();
            if (r4 == null) goto L13;
            r7.a(r3, this.f9663d, (com.bytedance.retrofit2.e.j) ZeusTransformUtils.preCheckCast(this.f9662c.b((T) r4), com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin"));
            goto L6
        L13:
            throw an.a(this.f9660a, this.f9661b, "Part map contained null value for key '" + r3 + "'.", new Object[0]);
        L15:
            throw an.a(this.f9660a, this.f9661b, "Part map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw an.a(this.f9660a, this.f9661b, "Part map was null.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class q<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f9664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f9666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f9668e;

        q(Method r3, int r4, String r5, com.bytedance.retrofit2.i<T, String> r6, boolean r7) {
            com.bytedance.retrofit2.i<T, String> r8 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9664a = r3;
            this.f9665b = r4;
            this.f9666c = (String) ZeusTransformUtils.preCheckCast(an.a(r5, "name == null"), String.class, "com.obric.aiagent.plugin");
            this.f9667d = r8;
            this.f9668e = r7;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r4, T r5) {
            if (r5 == null) goto L6;
            r4.a(this.f9666c, (String) ZeusTransformUtils.preCheckCast(this.f9667d.b(r5), String.class, "com.obric.aiagent.plugin"), this.f9668e);
            return;
        L6:
            throw an.a(this.f9664a, this.f9665b, "Path parameter \"" + this.f9666c + "\" value must not be null.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class r<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f9671c;

        r(String r3, com.bytedance.retrofit2.i<T, String> r4, boolean r5) {
            com.bytedance.retrofit2.i<T, String> r6 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9669a = (String) ZeusTransformUtils.preCheckCast(an.a(r3, "name == null"), String.class, "com.obric.aiagent.plugin");
            this.f9670b = r6;
            this.f9671c = r5;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r3, T r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f9670b.b(r4), String.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L7;
            return;
        L7:
            r3.b(this.f9669a, r5, this.f9671c);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class s<T> extends x<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f9672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f9675d;

        @Override // com.bytedance.retrofit2.x
        /* synthetic */ void a(z r3, Object r4) {
            a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        }

        s(Method r3, int r4, com.bytedance.retrofit2.i<T, String> r5, boolean r6) {
            com.bytedance.retrofit2.i<T, String> r7 = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9672a = r3;
            this.f9673b = r4;
            this.f9674c = r7;
            this.f9675d = r6;
        }

        void a(z r7, Map<String, T> r8) {
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L5;
            return;
        L5:
            Iterator r10 = r9.entrySet().iterator();
        L7:
            if (r10.hasNext() == false) goto L20;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            Object r1 = r0.getValue();
            if (r1 == null) goto L7;
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f9674c.b((T) r1), String.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L17;
            r7.b(r2, r4, this.f9675d);
            goto L7
        L17:
            throw an.a(this.f9672a, this.f9673b, "Query map value '" + r1 + "' converted to null by " + this.f9674c.getClass().getName() + " for key '" + r2 + "'.", new Object[0]);
        L19:
            throw an.a(this.f9672a, this.f9673b, "Query map contained null key.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class t<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.i<T, String> f9676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f9677b;

        t(com.bytedance.retrofit2.i<T, String> r3, boolean r4) {
            this.f9676a = (com.bytedance.retrofit2.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.i.class, "com.obric.aiagent.plugin");
            this.f9677b = r4;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r3, T r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            r3.b((String) ZeusTransformUtils.preCheckCast(this.f9676a.b(r4), String.class, "com.obric.aiagent.plugin"), null, this.f9677b);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class u<T> extends x<T> {
        u() {
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r2, T r3) {
            if (r3 != null) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, com.bytedance.retrofit2.c.a.b.class) == false) goto L9;
            r2.a(((com.bytedance.retrofit2.c.a.b) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.c.a.b.class, "com.obric.aiagent.plugin")).a());
            return;
        L9:
            throw new RuntimeException("wrong type:" + r3.getClass() + ",not implement QueryParamObject");
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class v extends x<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f9678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9679b;

        v(Method r1, int r2) {
            this.f9678a = r1;
            this.f9679b = r2;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r1, Object r2) {
            r1.a(r2);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class w<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<T> f9680a;

        w(Class<T> r1) {
            this.f9680a = r1;
        }

        @Override // com.bytedance.retrofit2.x
        void a(z r1, T r2) {
            r1.a(this.f9680a, r2);
        }
    }

    abstract void a(z r1, T r2);

    x() {
    }

    final x<Iterable<T>> a() {
        return new AnonymousClass1(this);
    }

    final x<Object> b() {
        return new AnonymousClass2(this);
    }
}
