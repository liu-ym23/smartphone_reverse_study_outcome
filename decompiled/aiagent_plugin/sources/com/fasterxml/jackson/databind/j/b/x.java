package com.fasterxml.jackson.databind.j.b;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.Map;

/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.j.b.x$1, reason: invalid class name */
    /* JADX INFO: compiled from: NumberSerializers.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12929a = null;

        static {
            int[] r0 = new int[JsonFormat.Shape.values().length];
            f12929a = r0;
            r0[JsonFormat.Shape.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    /* JADX INFO: compiled from: NumberSerializers.java */
    public static abstract class a<T> extends ai<T> implements com.fasterxml.jackson.databind.j.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final com.fasterxml.jackson.a.k.b f12930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final String f12931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final boolean f12932c;

        public a(Class<?> r2, com.fasterxml.jackson.a.k.b r3, String r4) {
            boolean r0 = false;
            super(r2, false);
            this.f12930a = r3;
            this.f12931b = r4;
            if (r3 != com.fasterxml.jackson.a.k.b.f12143a) goto L5;
        L8:
            r0 = true;
        L9:
            this.f12932c = r0;
            return;
        L5:
            if (r3 == com.fasterxml.jackson.a.k.b.f12144b) goto L8;
            if (r3 != com.fasterxml.jackson.a.k.b.f12145c) goto L9;
            goto L8
        }

        @Override // com.fasterxml.jackson.databind.j.j
        public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4) {
            JsonFormat.Value r5 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a());
            if (r5 != null) goto L5;
            return this;
        L5:
            if (AnonymousClass1.f12929a[r5.getShape().ordinal()] == 1) goto L8;
            return this;
        L8:
            if (a() != BigDecimal.class) goto L12;
            return w.d();
        L12:
            return an.f12885a;
        }
    }

    /* JADX INFO: compiled from: NumberSerializers.java */
    @JacksonStdImpl
    public static class b extends a<Object> {
        public b(Class<?> r3) {
            super(r3, com.fasterxml.jackson.a.k.b.f12147e, "number");
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.a(((Double) ZeusTransformUtils.preCheckCast(r1, Double.class, "com.obric.aiagent.plugin")).doubleValue());
        }

        @Override // com.fasterxml.jackson.databind.j.b.ai, com.fasterxml.jackson.databind.p
        public void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
            Double r2 = (Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.aiagent.plugin");
            if (com.fasterxml.jackson.a.d.j.a(r2.doubleValue()) == false) goto L5;
            com.fasterxml.jackson.a.g.b r7 = r6.a(r4, r6.a(r3, com.fasterxml.jackson.a.n.j));
            r4.a(r2.doubleValue());
            r6.b(r4, r7);
            return;
        L5:
            r4.a(r2.doubleValue());
        }
    }

    /* JADX INFO: compiled from: NumberSerializers.java */
    @JacksonStdImpl
    public static class c extends a<Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final c f12933d = null;

        static {
            f12933d = new c();
        }

        public c() {
            super(Float.class, com.fasterxml.jackson.a.k.b.f12146d, "number");
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.a(((Float) ZeusTransformUtils.preCheckCast(r1, Float.class, "com.obric.aiagent.plugin")).floatValue());
        }
    }

    /* JADX INFO: compiled from: NumberSerializers.java */
    @JacksonStdImpl
    public static class d extends a<Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final d f12934d = null;

        static {
            f12934d = new d();
        }

        public d() {
            super(Number.class, com.fasterxml.jackson.a.k.b.f12143a, WsChannelMultiProcessSharedProvider.INT_TYPE);
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.d(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue());
        }
    }

    /* JADX INFO: compiled from: NumberSerializers.java */
    @JacksonStdImpl
    public static class e extends a<Object> {
        public e(Class<?> r3) {
            super(r3, com.fasterxml.jackson.a.k.b.f12143a, WsChannelMultiProcessSharedProvider.INT_TYPE);
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.d(((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.aiagent.plugin")).intValue());
        }

        @Override // com.fasterxml.jackson.databind.j.b.ai, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.h.h r4) {
            a(r1, r2, r3);
        }
    }

    /* JADX INFO: compiled from: NumberSerializers.java */
    @JacksonStdImpl
    public static class f extends a<Object> {
        public f(Class<?> r3) {
            super(r3, com.fasterxml.jackson.a.k.b.f12144b, "number");
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.b(((Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.aiagent.plugin")).longValue());
        }
    }

    /* JADX INFO: compiled from: NumberSerializers.java */
    @JacksonStdImpl
    public static class g extends a<Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final g f12935d = null;

        static {
            f12935d = new g();
        }

        public g() {
            super(Short.class, com.fasterxml.jackson.a.k.b.f12143a, "number");
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.a(((Short) ZeusTransformUtils.preCheckCast(r1, Short.class, "com.obric.aiagent.plugin")).shortValue());
        }
    }

    public static void a(Map<String, com.fasterxml.jackson.databind.p<?>> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        r4.put(Integer.class.getName(), new e(Integer.class));
        r4.put(Integer.TYPE.getName(), new e(Integer.TYPE));
        r4.put(Long.class.getName(), new f(Long.class));
        r4.put(Long.TYPE.getName(), new f(Long.TYPE));
        r4.put(Byte.class.getName(), d.f12934d);
        r4.put(Byte.TYPE.getName(), d.f12934d);
        r4.put(Short.class.getName(), g.f12935d);
        r4.put(Short.TYPE.getName(), g.f12935d);
        r4.put(Double.class.getName(), new b(Double.class));
        r4.put(Double.TYPE.getName(), new b(Double.TYPE));
        r4.put(Float.class.getName(), c.f12933d);
        r4.put(Float.TYPE.getName(), c.f12933d);
    }
}
