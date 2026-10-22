package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: BeanAsArrayBuilderDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends com.fasterxml.jackson.databind.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.d f12265a;
    protected final com.fasterxml.jackson.databind.b.v[] w;
    protected final com.fasterxml.jackson.databind.e.k x;
    protected final com.fasterxml.jackson.databind.k y;

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d h() {
        return this;
    }

    public a(com.fasterxml.jackson.databind.b.d r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.b.v[] r3, com.fasterxml.jackson.databind.e.k r4) {
        super(r1);
        this.f12265a = r1;
        this.y = r2;
        this.w = r3;
        this.x = r4;
    }

    @Override // com.fasterxml.jackson.databind.b.d, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.l.q r1) {
        return this.f12265a.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d b(s r4) {
        return new a(this.f12265a.b(r4), this.y, this.w, this.x);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d b(Set<String> r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        return new a(this.f12265a.b(r5, r6), this.y, this.w, this.x);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d a(boolean r4) {
        return new a(this.f12265a.a(r4), this.y, this.w, this.x);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d a(c r4) {
        return new a(this.f12265a.a(r4), this.y, this.w, this.x);
    }

    @Override // com.fasterxml.jackson.databind.b.d, com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.FALSE;
    }

    public final Object b(com.fasterxml.jackson.databind.h r5, Object r6) {
        return this.x.h().invoke(r6, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.aiagent.plugin"));
    L4:
        e = move-exception;
        return a(e, r5);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9) {
        if (r8.q() == true) goto L7;
        return b(r9, f(r8, r9));
    L7:
        if (this.j == false) goto L9;
        Object r0 = this.f12514e.a(r9);
        com.fasterxml.jackson.databind.b.v[] r1 = this.w;
        int r2 = r1.length;
        int r4 = 0;
    L12:
        if (r8.g() == com.fasterxml.jackson.a.n.f12155e) goto L14;
        if (r4 == r2) goto L17;
        com.fasterxml.jackson.databind.b.v r5 = r1[r4];
        if (r5 != null) goto L34;
        r8.k();
    L33:
        r4 = r4 + 1;
        goto L12
    L34:
        r0 = r5.b(r8, r9, r0);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        a(e, r0, r5.a(), r9);
        goto L33
    L17:
        if (this.p == true) goto L22;
        if (r9.a(com.fasterxml.jackson.databind.i.f12758e) == false) goto L22;
        r9.a(a(), "Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[]{Integer.valueOf(r2)});
    L22:
        if (r8.g() == com.fasterxml.jackson.a.n.f12155e) goto L25;
        r8.k();
        goto L22
    L25:
        return b(r9, r0);
    L14:
        return b(r9, r0);
    L9:
        return b(r9, d(r8, r9));
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
        return this.f12265a.a(r1, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return f(r1, r2);
    }

    public Object d(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        if (this.i == true) goto L5;
        Object r0 = this.f12514e.a(r10);
        if (this.l == null) goto L10;
        a(r10, r0);
    L10:
        if (this.q == false) goto L12;
        Class<?> r1 = r10.d();
    L13:
        com.fasterxml.jackson.databind.b.v[] r2 = this.w;
        int r3 = r2.length;
        int r5 = 0;
    L15:
        if (r9.g() == com.fasterxml.jackson.a.n.f12155e) goto L16;
        if (r5 == r3) goto L19;
        com.fasterxml.jackson.databind.b.v r6 = r2[r5];
        r5 = r5 + 1;
        if (r6 == null) goto L36;
        if (r1 != null) goto L31;
    L37:
        r6.b(r9, r10, r0);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        a(e, r0, r6.a(), r10);
        goto L15
    L31:
        if (r6.a(r1) == true) goto L37;
    L36:
        r9.k();
        goto L15
    L19:
        if (this.p == true) goto L24;
        if (r10.a(com.fasterxml.jackson.databind.i.f12758e) == false) goto L24;
        r10.a(this, com.fasterxml.jackson.a.n.f12155e, "Unexpected JSON value(s); expected at most %d properties (in JSON Array)", new Object[]{Integer.valueOf(r3)});
    L24:
        if (r9.g() == com.fasterxml.jackson.a.n.f12155e) goto L26;
        r9.k();
        goto L24
    L26:
        return r0;
    L16:
        return r0;
    L12:
        r1 = null;
        goto L13
    L5:
        return l(r9, r10);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public final Object c(com.fasterxml.jackson.a.k r14, com.fasterxml.jackson.databind.h r15) {
        v r0 = this.h;
        y r1 = r0.a(r14, r15, this.v);
        com.fasterxml.jackson.databind.b.v[] r2 = this.w;
        int r3 = r2.length;
        if (this.q == false) goto L5;
        Class<?> r4 = r15.d();
    L6:
        Object r7 = null;
        int r8 = 0;
    L8:
        if (r14.g() == com.fasterxml.jackson.a.n.f12155e) goto L39;
        if (r8 >= r3) goto L11;
        com.fasterxml.jackson.databind.b.v r9 = r2[r8];
    L12:
        if (r9 != null) goto L14;
        r14.k();
    L38:
        r8 = r8 + 1;
        goto L8
    L14:
        if (r4 != null) goto L16;
    L18:
        if (r7 != null) goto L50;
        String r10 = r9.a();
        com.fasterxml.jackson.databind.b.v r11 = r0.a(r10);
        if (r1.a(r10) == false) goto L27;
        if (r11 == null) goto L38;
    L27:
        if (r11 != null) goto L29;
        r1.b(r9, r9.a(r14, r15));
        goto L38
    L29:
        if (r1.a(r11, r11.a(r14, r15)) == false) goto L38;
        r7 = r0.a(r15, r1);     // Catch: Exception -> L35
        if (r7.getClass() == this.f12512c.e()) goto L38;
        return r15.b(this.f12512c, String.format("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(this.f12512c), r7.getClass().getName()}));
    L35:
        e = move-exception;
        a(e, this.f12512c.e(), r10, r15);
        goto L38
    L50:
        r7 = r9.b(r14, r15, r7);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        a(e, r7, r9.a(), r15);
        goto L38
    L16:
        if (r9.a(r4) == true) goto L18;
        r14.k();
        goto L38
    L11:
        r9 = null;
        goto L12
    L39:
        if (r7 == null) goto L48;
        return r7;
    L48:
        return r0.a(r15, r1);
    L42:
        e = move-exception;
        return a(e, r15);
    L5:
        r4 = null;
        goto L6
    }

    public Object f(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        return r8.a(f(r8), r7.l(), r7, "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", new Object[]{this.f12512c.e().getName(), r7.l()});
    }
}
