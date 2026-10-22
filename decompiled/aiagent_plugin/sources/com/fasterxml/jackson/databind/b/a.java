package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.e.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: AbstractDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends com.fasterxml.jackson.databind.l<Object> implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.a.s f12261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Map<String, v> f12262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected transient Map<String, v> f12263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12264e;
    protected final boolean f;
    protected final boolean g;
    protected final boolean h;

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        return true;
    }

    public a(e r3, com.fasterxml.jackson.databind.c r4, Map<String, v> r5, Map<String, v> r6) {
        Map<String, v> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Map<String, v> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.k r9 = r4.getType();
        this.f12260a = r9;
        this.f12261b = r3.e();
        this.f12262c = r7;
        this.f12263d = r8;
        Class<?> r10 = r9.e();
        this.f12264e = r10.isAssignableFrom(String.class);
        boolean r11 = false;
        if (r10 != Boolean.TYPE) goto L5;
    L8:
        boolean r12 = true;
    L9:
        this.f = r12;
        if (r10 != Integer.TYPE) goto L12;
    L15:
        boolean r13 = true;
    L16:
        this.g = r13;
        if (r10 != Double.TYPE) goto L19;
    L20:
        r11 = true;
    L21:
        this.h = r11;
        return;
    L19:
        if (r10.isAssignableFrom(Double.class) == false) goto L21;
    L12:
        if (r10.isAssignableFrom(Integer.class) == true) goto L15;
        r13 = false;
        goto L16
    L5:
        if (r10.isAssignableFrom(Boolean.class) == true) goto L8;
        r12 = false;
        goto L9
    }

    public a(com.fasterxml.jackson.databind.c r4) {
        com.fasterxml.jackson.databind.k r5 = r4.getType();
        this.f12260a = r5;
        this.f12261b = null;
        this.f12262c = null;
        Class<?> r6 = r5.e();
        this.f12264e = r6.isAssignableFrom(String.class);
        boolean r1 = false;
        if (r6 != Boolean.TYPE) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.f = r0;
        if (r6 != Integer.TYPE) goto L12;
    L15:
        boolean r2 = true;
    L16:
        this.g = r2;
        if (r6 != Double.TYPE) goto L19;
    L20:
        r1 = true;
    L21:
        this.h = r1;
        return;
    L19:
        if (r6.isAssignableFrom(Double.class) == false) goto L21;
    L12:
        if (r6.isAssignableFrom(Integer.class) == true) goto L15;
        r2 = false;
        goto L16
    L5:
        if (r6.isAssignableFrom(Boolean.class) == true) goto L8;
        r0 = false;
        goto L9
    }

    public a(a r3, com.fasterxml.jackson.databind.b.a.s r4, Map<String, v> r5) {
        Map<String, v> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.f12260a = r3.f12260a;
        this.f12262c = r3.f12262c;
        this.f12264e = r3.f12264e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.f12261b = r4;
        this.f12263d = r6;
    }

    public static a a(com.fasterxml.jackson.databind.c r1) {
        return new a(r1);
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r12, com.fasterxml.jackson.databind.d r13) {
        com.fasterxml.jackson.databind.d r14 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r13, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r0 = r12.f();
        if (r14 == null) goto L22;
        if (r0 == null) goto L22;
        com.fasterxml.jackson.databind.e.j r15 = r14.d();
        if (r15 == null) goto L22;
        ac r3 = r0.a(r15);
        if (r3 == null) goto L22;
        ObjectIdResolver r4 = r12.b(r15, r3);
        ac r1 = r0.a(r15, r3);
        Class<? extends ObjectIdGenerator<?>> r5 = r1.d();
        if (r5 != ObjectIdGenerators.PropertyGenerator.class) goto L18;
        com.fasterxml.jackson.databind.x r16 = r1.b();
        Map<String, v> r6 = this.f12263d;
        if (r6 != null) goto L14;
        v r2 = null;
    L15:
        if (r2 != null) goto L17;
        r12.b(this.f12260a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(a()), com.fasterxml.jackson.databind.l.h.a(r16)}));
    L17:
        com.fasterxml.jackson.databind.k r17 = r2.getType();
        ObjectIdGenerator<?> r7 = new com.fasterxml.jackson.databind.b.a.w(r1.c());
        com.fasterxml.jackson.databind.k r8 = r17;
        v r9 = r2;
    L20:
        return new a(this, com.fasterxml.jackson.databind.b.a.s.a(r8, r1.b(), r7, r12.b(r8), r9, r4), null);
    L14:
        r2 = (v) ZeusTransformUtils.preCheckCast(r6.get(r16.b()), v.class, "com.obric.aiagent.plugin");
        goto L15
    L18:
        r4 = r12.b(r15, r1);
        com.fasterxml.jackson.databind.k r10 = r12.b().c(r12.b(r5), ObjectIdGenerator.class)[0];
        r7 = r12.a(r15, r1);
        r8 = r10;
        r9 = null;
    L22:
        if (this.f12263d != null) goto L25;
        return this;
    L25:
        return new a(this, this.f12261b, null);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Class<?> a() {
        return this.f12260a.e();
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12970d;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.b.a.s f() {
        return this.f12261b;
    }

    @Override // com.fasterxml.jackson.databind.l
    public v a(String r2) {
        Map<String, v> r1 = this.f12262c;
        if (r1 != null) goto L6;
        return null;
    L6:
        return (v) ZeusTransformUtils.preCheckCast(r1.get(r2), v.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.h.e r5) {
        if (this.f12261b == null) goto L21;
        com.fasterxml.jackson.a.n r0 = r3.l();
        if (r0 == null) goto L21;
        if (r0.g() == false) goto L11;
        return c(r3, r4);
    L11:
        if (r0 != com.fasterxml.jackson.a.n.f12152b) goto L14;
        r0 = r3.g();
    L14:
        if (r0 != com.fasterxml.jackson.a.n.f) goto L21;
        if (this.f12261b.c() == false) goto L21;
        if (this.f12261b.a(r3.w(), r3) == false) goto L21;
        return c(r3, r4);
    L21:
        Object r2 = b(r3, r4);
        if (r2 == null) goto L25;
        return r2;
    L25:
        return r5.a(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        y.a r2 = new y.a(this.f12260a);
        return r8.a(this.f12260a.e(), r2, r7, "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
    }

    public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        switch(r1.m()) {
            case 6: goto L22;
            case 7: goto L18;
            case 8: goto L14;
            case 9: goto L10;
            case 10: goto L6;
            default: goto L31;
        };
    L31:
        return null;
    L6:
        if (this.f == true) goto L8;
        return null;
    L8:
        return Boolean.FALSE;
    L10:
        if (this.f == true) goto L12;
        return null;
    L12:
        return Boolean.TRUE;
    L14:
        if (this.h == true) goto L16;
        return null;
    L16:
        return Double.valueOf(r1.L());
    L18:
        if (this.g == true) goto L20;
        return null;
    L20:
        return Integer.valueOf(r1.H());
    L22:
        if (this.f12264e == true) goto L24;
        return null;
    L24:
        return r1.x();
    }

    public Object c(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        Object r0 = this.f12261b.a(r4, r5);
        com.fasterxml.jackson.databind.b.a.z r3 = r5.a(r0, this.f12261b.f12330c, this.f12261b.f12331d);
        Object r6 = r3.b();
        if (r6 == null) goto L6;
        return r6;
    L6:
        throw new w(r4, "Could not resolve Object Id [" + r0 + "] -- unresolved forward-reference?", r4.e(), r3);
    }
}
