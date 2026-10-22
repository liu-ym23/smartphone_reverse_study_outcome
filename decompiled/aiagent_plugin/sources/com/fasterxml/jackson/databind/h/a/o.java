package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: compiled from: StdTypeResolverBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class o implements com.fasterxml.jackson.databind.h.g<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected JsonTypeInfo.Id f12725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected JsonTypeInfo.As f12726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f12727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f12728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Class<?> f12729e;
    protected com.fasterxml.jackson.databind.h.f f;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.h.a.o$1, reason: invalid class name */
    /* JADX INFO: compiled from: StdTypeResolverBuilder.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12730a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12731b = null;

        static {
            int[] r0 = new int[JsonTypeInfo.Id.values().length];
            f12731b = r0;
            r0[JsonTypeInfo.Id.DEDUCTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            f12731b[JsonTypeInfo.Id.CLASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L39:
            f12731b[JsonTypeInfo.Id.MINIMAL_CLASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L51:
            f12731b[JsonTypeInfo.Id.NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L35:
            f12731b[JsonTypeInfo.Id.NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L41:
            f12731b[JsonTypeInfo.Id.CUSTOM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L13:
            int[] r5 = new int[JsonTypeInfo.As.values().length];
            f12730a = r5;
            r5[JsonTypeInfo.As.WRAPPER_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L45:
            f12730a[JsonTypeInfo.As.PROPERTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L33:
            f12730a[JsonTypeInfo.As.WRAPPER_OBJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L37:
            f12730a[JsonTypeInfo.As.EXTERNAL_PROPERTY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L47:
            f12730a[JsonTypeInfo.As.EXISTING_PROPERTY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
            return;
        }
    }

    public boolean b(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.k r2) {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public /* synthetic */ com.fasterxml.jackson.databind.h.g a(JsonTypeInfo.As r1) {
        return b(r1);
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public /* synthetic */ com.fasterxml.jackson.databind.h.g a(JsonTypeInfo.Id r3, com.fasterxml.jackson.databind.h.f r4) {
        return b(r3, (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public /* synthetic */ com.fasterxml.jackson.databind.h.g a(Class r1) {
        return c(r1);
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public /* synthetic */ com.fasterxml.jackson.databind.h.g a(String r1) {
        return b(r1);
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public /* synthetic */ com.fasterxml.jackson.databind.h.g a(boolean r1) {
        return b(r1);
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public /* synthetic */ com.fasterxml.jackson.databind.h.g b(Class r1) {
        return d(r1);
    }

    public o() {
        this.f12728d = false;
    }

    public o(o r2, Class<?> r3) {
        this.f12728d = false;
        this.f12725a = r2.f12725a;
        this.f12726b = r2.f12726b;
        this.f12727c = r2.f12727c;
        this.f12728d = r2.f12728d;
        this.f = r2.f;
        this.f12729e = r3;
    }

    public static o b() {
        return new o().b(JsonTypeInfo.Id.NONE, null);
    }

    public o b(JsonTypeInfo.Id r3, com.fasterxml.jackson.databind.h.f r4) {
        com.fasterxml.jackson.databind.h.f r5 = (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        this.f12725a = r3;
        this.f = r5;
        this.f12727c = r3.getDefaultPropertyName();
        return this;
    L7:
        throw new IllegalArgumentException("idType cannot be null");
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public com.fasterxml.jackson.databind.h.h a(aa r9, com.fasterxml.jackson.databind.k r10, Collection<com.fasterxml.jackson.databind.h.b> r11) {
        Collection<com.fasterxml.jackson.databind.h.b> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r11, Collection.class, "com.obric.aiagent.plugin");
        if (this.f12725a != JsonTypeInfo.Id.NONE) goto L6;
        return null;
    L6:
        if (r10.o() == true) goto L8;
    L10:
        com.fasterxml.jackson.databind.h.f r12 = a(r9, r10, a(r9), r4, true, false);
        if (this.f12725a == JsonTypeInfo.Id.DEDUCTION) goto L13;
        int r13 = AnonymousClass1.f12730a[this.f12726b.ordinal()];
        if (r13 == 1) goto L35;
        if (r13 == 2) goto L33;
        if (r13 == 3) goto L31;
        if (r13 == 4) goto L29;
        if (r13 != 5) goto L27;
        return new d(r12, null, this.f12727c);
    L27:
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f12726b);
    L29:
        return new f(r12, null, this.f12727c);
    L31:
        return new j(r12, null);
    L33:
        return new h(r12, null, this.f12727c);
    L35:
        return new b(r12, null);
    L13:
        return new d(r12, null, this.f12727c);
    L8:
        if (b(r9, r10) == true) goto L10;
        return null;
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public com.fasterxml.jackson.databind.h.e a(com.fasterxml.jackson.databind.g r17, com.fasterxml.jackson.databind.k r18, Collection<com.fasterxml.jackson.databind.h.b> r19) {
        Collection<com.fasterxml.jackson.databind.h.b> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r19, Collection.class, "com.obric.aiagent.plugin");
        if (this.f12725a != JsonTypeInfo.Id.NONE) goto L6;
        return null;
    L6:
        if (r18.o() == true) goto L8;
    L10:
        com.fasterxml.jackson.databind.h.f r11 = a(r17, r18, a(r17, r18), r8, false, true);
        com.fasterxml.jackson.databind.k r14 = a(r17, r18);
        if (this.f12725a == JsonTypeInfo.Id.DEDUCTION) goto L13;
        int r0 = AnonymousClass1.f12730a[this.f12726b.ordinal()];
        if (r0 == 1) goto L34;
        if (r0 == 2) goto L32;
        if (r0 == 3) goto L30;
        if (r0 == 4) goto L28;
        if (r0 == 5) goto L32;
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f12726b);
    L28:
        return new e(r18, r11, this.f12727c, this.f12728d, r14);
    L30:
        return new i(r18, r11, this.f12727c, this.f12728d, r14);
    L32:
        return new g(r18, r11, this.f12727c, this.f12728d, r14, this.f12726b);
    L34:
        return new a(r18, r11, this.f12727c, this.f12728d, r14);
    L13:
        return new c(r18, r11, r14, r17, r8);
    L8:
        if (b(r17, r18) == true) goto L10;
        return null;
    }

    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.k r4) {
        Class<?> r0 = this.f12729e;
        if (r0 == null) goto L22;
        if (r0 == Void.class) goto L20;
        if (r0 == NoClass.class) goto L20;
        if (r4.a(r0) == false) goto L13;
        return r4;
    L13:
        if (r4.c(this.f12729e) == false) goto L17;
        return r3.o().a(r4, this.f12729e);
    L17:
        if (r4.a(this.f12729e) == false) goto L22;
        return r4;
    L20:
        return r3.o().a(this.f12729e);
    L22:
        if (r3.a(com.fasterxml.jackson.databind.r.q) == true) goto L24;
        return null;
    L24:
        if (r4.g() == true) goto L28;
        return r4;
    L28:
        return null;
    }

    public o b(JsonTypeInfo.As r1) {
        if (r1 == null) goto L6;
        this.f12726b = r1;
        return this;
    L6:
        throw new IllegalArgumentException("includeAs cannot be null");
    }

    public o b(String r2) {
        if (r2 != null) goto L4;
    L5:
        r2 = this.f12725a.getDefaultPropertyName();
    L6:
        this.f12727c = r2;
        return this;
    L4:
        if (r2.isEmpty() == false) goto L6;
        goto L5
    }

    public o c(Class<?> r1) {
        this.f12729e = r1;
        return this;
    }

    public o b(boolean r1) {
        this.f12728d = r1;
        return this;
    }

    public o d(Class<?> r3) {
        if (this.f12729e != r3) goto L5;
        return this;
    L5:
        com.fasterxml.jackson.databind.l.h.a(o.class, this, "withDefaultImpl");
        return new o(this, r3);
    }

    @Override // com.fasterxml.jackson.databind.h.g
    public Class<?> a() {
        return this.f12729e;
    }

    public com.fasterxml.jackson.databind.h.f a(com.fasterxml.jackson.databind.a.m<?> r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.h.c r5, Collection<com.fasterxml.jackson.databind.h.b> r6, boolean r7, boolean r8) {
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.f r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.f12725a == null) goto L28;
        int r1 = AnonymousClass1.f12731b[this.f12725a.ordinal()];
        if (r1 == 1) goto L26;
        if (r1 == 2) goto L26;
        if (r1 == 3) goto L24;
        if (r1 == 4) goto L22;
        if (r1 != 5) goto L20;
        return null;
    L20:
        throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.f12725a);
    L22:
        return s.a(r3, r4, r9, r7, r8);
    L24:
        return m.b(r4, r3, r5);
    L26:
        return k.a(r4, r3, r5);
    L28:
        throw new IllegalStateException("Cannot build, 'init()' not yet called");
    }

    public com.fasterxml.jackson.databind.h.c a(com.fasterxml.jackson.databind.a.m<?> r1) {
        return r1.n();
    }

    public com.fasterxml.jackson.databind.h.c a(com.fasterxml.jackson.databind.a.m<?> r4, com.fasterxml.jackson.databind.k r5) {
        com.fasterxml.jackson.databind.h.c r0 = a(r4);
        if (this.f12725a != JsonTypeInfo.Id.CLASS) goto L5;
    L6:
        com.fasterxml.jackson.databind.h.c.b r1 = r0.a(r4, r5);
        if (r1 != com.fasterxml.jackson.databind.h.c.b.f12749b) goto L11;
        return a(r4, r5, r0);
    L11:
        if (r1 == com.fasterxml.jackson.databind.h.c.b.f12748a) goto L13;
    L14:
        return r0;
    L13:
        return l.f12721a;
    L5:
        if (this.f12725a != JsonTypeInfo.Id.MINIMAL_CLASS) goto L14;
        goto L6
    }

    public com.fasterxml.jackson.databind.h.c a(com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.h.c r4) {
        throw new IllegalArgumentException(String.format("Configured `PolymorphicTypeValidator` (of type %s) denied resolution of all subtypes of base type %s", new Object[]{com.fasterxml.jackson.databind.l.h.d(r4), com.fasterxml.jackson.databind.l.h.d(r3.e())}));
    }
}
