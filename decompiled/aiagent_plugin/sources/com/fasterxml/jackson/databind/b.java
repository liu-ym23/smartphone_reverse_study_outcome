package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.e.ai;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: compiled from: AnnotationIntrospector.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Serializable {

    /* JADX INFO: compiled from: AnnotationIntrospector.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EnumC0269a f12255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12256b;

        /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AnnotationIntrospector.java */
        public static final enum EnumC0269a extends Enum<EnumC0269a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0269a f12257a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0269a f12258b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ EnumC0269a[] f12259c = null;

            private EnumC0269a(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumC0269a valueOf(String r2) {
                return (EnumC0269a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0269a.class, r2), EnumC0269a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0269a[] values() {
                return (EnumC0269a[]) ZeusTransformUtils.preCheckCast(f12259c.clone(), EnumC0269a[].class, "com.obric.aiagent.plugin");
            }

            static {
                EnumC0269a r0 = new EnumC0269a("MANAGED_REFERENCE", 0);
                f12257a = r0;
                EnumC0269a r1 = new EnumC0269a("BACK_REFERENCE", 1);
                f12258b = r1;
                f12259c = new EnumC0269a[]{r0, r1};
            }
        }

        public a(EnumC0269a r1, String r2) {
            this.f12255a = r1;
            this.f12256b = r2;
        }

        public static a a(String r2) {
            return new a(EnumC0269a.f12257a, r2);
        }

        public static a b(String r2) {
            return new a(EnumC0269a.f12258b, r2);
        }

        public EnumC0269a getType() {
            return this.f12255a;
        }

        public String a() {
            return this.f12256b;
        }

        public boolean b() {
            if (this.f12255a != EnumC0269a.f12257a) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean c() {
            if (this.f12255a != EnumC0269a.f12258b) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Object A(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public x B(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Boolean C(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Boolean E(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    @Deprecated
    public boolean F(com.fasterxml.jackson.databind.e.b r1) {
        return false;
    }

    @Deprecated
    public JsonCreator.Mode G(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public com.fasterxml.jackson.databind.e.ac a(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public com.fasterxml.jackson.databind.e.ac a(com.fasterxml.jackson.databind.e.b r1, com.fasterxml.jackson.databind.e.ac r2) {
        return r2;
    }

    public ai<?> a(com.fasterxml.jackson.databind.e.d r1, ai<?> r2) {
        return (ai) ZeusTransformUtils.wrapperContextForParams(r2, ai.class, "com.obric.aiagent.plugin");
    }

    public com.fasterxml.jackson.databind.e.k a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.k r2, com.fasterxml.jackson.databind.e.k r3) {
        return null;
    }

    public com.fasterxml.jackson.databind.h.g<?> a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.d r2, k r3) {
        return null;
    }

    public com.fasterxml.jackson.databind.h.g<?> a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.j r2, k r3) {
        return null;
    }

    public k a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.b r2, k r3) {
        return r3;
    }

    public x a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.h r2, x r3) {
        return null;
    }

    public x a(com.fasterxml.jackson.databind.e.d r1) {
        return null;
    }

    public Boolean a(com.fasterxml.jackson.databind.e.j r1) {
        return null;
    }

    public Enum<?> a(Class<Enum<?>> r1) {
        return null;
    }

    public void a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.d r2, List<com.fasterxml.jackson.databind.j.d> r3) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void a(Class<?> r1, Enum<?>[] r2, String[][] r3) {
    }

    @Deprecated
    public boolean a(com.fasterxml.jackson.databind.e.k r1) {
        return false;
    }

    public boolean a(Annotation r2) {
        Annotation r1 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r2, Annotation.class, "com.obric.aiagent.plugin");
        return false;
    }

    public String[] a(Class<?> r1, Enum<?>[] r2, String[] r3) {
        return r3;
    }

    public a b(com.fasterxml.jackson.databind.e.j r1) {
        return null;
    }

    public com.fasterxml.jackson.databind.h.g<?> b(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.j r2, k r3) {
        return null;
    }

    public k b(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.b r2, k r3) {
        return r3;
    }

    public Boolean b(com.fasterxml.jackson.databind.e.d r1) {
        return null;
    }

    public Object b(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    @Deprecated
    public boolean b(com.fasterxml.jackson.databind.e.k r1) {
        return false;
    }

    public com.fasterxml.jackson.databind.l.q c(com.fasterxml.jackson.databind.e.j r1) {
        return null;
    }

    public Boolean c(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.b r2) {
        return null;
    }

    public Object c(com.fasterxml.jackson.databind.e.d r1) {
        return null;
    }

    public String d(com.fasterxml.jackson.databind.e.d r1) {
        return null;
    }

    public List<com.fasterxml.jackson.databind.h.b> d(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public boolean d(com.fasterxml.jackson.databind.e.j r1) {
        return false;
    }

    public Class<?>[] e(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public String[] e(com.fasterxml.jackson.databind.e.d r1) {
        return null;
    }

    public Boolean f(com.fasterxml.jackson.databind.e.j r1) {
        return null;
    }

    public Object f(com.fasterxml.jackson.databind.e.d r1) {
        return null;
    }

    public x g(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Class<?> g(com.fasterxml.jackson.databind.e.d r1) {
        return null;
    }

    public String g(com.fasterxml.jackson.databind.e.j r1) {
        return null;
    }

    public JsonPOJOBuilder.Value h(com.fasterxml.jackson.databind.e.d r1) {
        return null;
    }

    @Deprecated
    public Object h(com.fasterxml.jackson.databind.e.j r1) {
        return null;
    }

    public String h(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object i(com.fasterxml.jackson.databind.e.j r1) {
        return null;
    }

    public String i(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Integer j(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object j(com.fasterxml.jackson.databind.e.j r1) {
        return null;
    }

    public List<x> k(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public JsonProperty.Access l(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object m(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object n(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object o(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object p(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public JsonSerialize.Typing q(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object r(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Boolean t(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public x u(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object x(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object y(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public Object z(com.fasterxml.jackson.databind.e.b r1) {
        return null;
    }

    public b() {
    }

    public static b a() {
        return com.fasterxml.jackson.databind.e.ab.f12569a;
    }

    public JsonIgnoreProperties.Value a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.b r2) {
        return c(r2);
    }

    public JsonIncludeProperties.Value b(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.b r2) {
        return JsonIncludeProperties.Value.all();
    }

    @Deprecated
    public JsonIgnoreProperties.Value c(com.fasterxml.jackson.databind.e.b r1) {
        return JsonIgnoreProperties.Value.empty();
    }

    public JacksonInject.Value e(com.fasterxml.jackson.databind.e.j r1) {
        Object r0 = h(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        return JacksonInject.Value.forId(r0);
    }

    public JsonFormat.Value f(com.fasterxml.jackson.databind.e.b r1) {
        return JsonFormat.Value.empty();
    }

    public JsonInclude.Value s(com.fasterxml.jackson.databind.e.b r1) {
        return JsonInclude.Value.empty();
    }

    public Boolean v(com.fasterxml.jackson.databind.e.b r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.e.k.class) == true) goto L5;
        return null;
    L5:
        if (a((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")) == true) goto L7;
        return null;
    L7:
        return true;
    }

    public Boolean w(com.fasterxml.jackson.databind.e.b r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.e.k.class) == true) goto L5;
        return null;
    L5:
        if (b((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")) == true) goto L7;
        return null;
    L7:
        return true;
    }

    public JsonSetter.Value D(com.fasterxml.jackson.databind.e.b r1) {
        return JsonSetter.Value.empty();
    }

    public JsonCreator.Mode d(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.b r2) {
        if (F(r2) == false) goto L8;
        JsonCreator.Mode r0 = G(r2);
        if (r0 == null) goto L7;
        return r0;
    L7:
        return JsonCreator.Mode.DEFAULT;
    L8:
        return null;
    }

    public <A extends Annotation> A a(com.fasterxml.jackson.databind.e.b r1, Class<A> r2) {
        return (A) r1.a(r2);
    }

    public boolean b(com.fasterxml.jackson.databind.e.b r1, Class<? extends Annotation> r2) {
        return r1.b(r2);
    }

    public boolean a(com.fasterxml.jackson.databind.e.b r1, Class<? extends Annotation>[] r2) {
        return r1.a(r2);
    }
}
