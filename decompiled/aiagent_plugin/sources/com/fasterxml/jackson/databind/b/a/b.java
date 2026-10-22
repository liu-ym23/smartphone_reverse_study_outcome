package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: BeanAsArrayDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends com.fasterxml.jackson.databind.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.d f12273a;
    protected final com.fasterxml.jackson.databind.b.v[] w;

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d h() {
        return this;
    }

    public b(com.fasterxml.jackson.databind.b.d r1, com.fasterxml.jackson.databind.b.v[] r2) {
        super(r1);
        this.f12273a = r1;
        this.w = r2;
    }

    @Override // com.fasterxml.jackson.databind.b.d, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.l.q r1) {
        return this.f12273a.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d b(s r3) {
        return new b(this.f12273a.b(r3), this.w);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d b(Set<String> r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        return new b(this.f12273a.b(r5, r6), this.w);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d a(boolean r3) {
        return new b(this.f12273a.a(r3), this.w);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public com.fasterxml.jackson.databind.b.d a(c r3) {
        return new b(this.f12273a.a(r3), this.w);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9) {
        if (r8.q() == true) goto L7;
        return f(r8, r9);
    L7:
        if (this.j == false) goto L9;
        Object r0 = this.f12514e.a(r9);
        r8.a(r0);
        com.fasterxml.jackson.databind.b.v[] r1 = this.w;
        int r2 = r1.length;
        int r4 = 0;
    L12:
        if (r8.g() == com.fasterxml.jackson.a.n.f12155e) goto L13;
        if (r4 == r2) goto L16;
        com.fasterxml.jackson.databind.b.v r5 = r1[r4];
        if (r5 != null) goto L31;
        r8.k();
    L30:
        r4 = r4 + 1;
        goto L12
    L31:
        r5.a(r8, r9, r0);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        a(e, r0, r5.a(), r9);
        goto L30
    L16:
        if (this.p == true) goto L20;
        if (r9.a(com.fasterxml.jackson.databind.i.f12758e) == false) goto L20;
        r9.a(this, com.fasterxml.jackson.a.n.f12155e, "Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[]{Integer.valueOf(r2)});
    L20:
        r8.k();
        if (r8.g() != com.fasterxml.jackson.a.n.f12155e) goto L20;
        return r0;
    L13:
        return r0;
    L9:
        return d(r8, r9);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, Object r9) {
        r7.a(r9);
        if (r7.q() == true) goto L7;
        return f(r7, r8);
    L7:
        if (this.l == null) goto L9;
        a(r8, r9);
    L9:
        com.fasterxml.jackson.databind.b.v[] r0 = this.w;
        int r1 = r0.length;
        int r3 = 0;
    L11:
        if (r7.g() == com.fasterxml.jackson.a.n.f12155e) goto L12;
        if (r3 == r1) goto L15;
        com.fasterxml.jackson.databind.b.v r4 = r0[r3];
        if (r4 != null) goto L30;
        r7.k();
    L29:
        r3 = r3 + 1;
        goto L11
    L30:
        r4.a(r7, r8, r9);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        a(e, r9, r4.a(), r8);
        goto L29
    L15:
        if (this.p == true) goto L19;
        if (r8.a(com.fasterxml.jackson.databind.i.f12758e) == false) goto L19;
        r8.a(this, com.fasterxml.jackson.a.n.f12155e, "Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[]{Integer.valueOf(r1)});
    L19:
        r7.k();
        if (r7.g() != com.fasterxml.jackson.a.n.f12155e) goto L19;
        return r9;
    L12:
        return r9;
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return f(r1, r2);
    }

    public Object d(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        if (this.i == true) goto L5;
        Object r0 = this.f12514e.a(r10);
        r9.a(r0);
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
        if (r6 == null) goto L33;
        if (r1 != null) goto L28;
    L34:
        r6.a(r9, r10, r0);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        a(e, r0, r6.a(), r10);
        goto L15
    L28:
        if (r6.a(r1) == true) goto L34;
    L33:
        r9.k();
        goto L15
    L19:
        if (this.p == true) goto L21;
        r10.a(this, com.fasterxml.jackson.a.n.f12155e, "Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[]{Integer.valueOf(r3)});
    L21:
        r9.k();
        if (r9.g() != com.fasterxml.jackson.a.n.f12155e) goto L21;
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
        if (r14.g() == com.fasterxml.jackson.a.n.f12155e) goto L38;
        if (r8 >= r3) goto L11;
        com.fasterxml.jackson.databind.b.v r9 = r2[r8];
    L12:
        if (r9 != null) goto L14;
        r14.k();
    L37:
        r8 = r8 + 1;
        goto L8
    L14:
        if (r4 != null) goto L16;
    L18:
        if (r7 != null) goto L49;
        String r10 = r9.a();
        com.fasterxml.jackson.databind.b.v r11 = r0.a(r10);
        if (r1.a(r10) == false) goto L27;
        if (r11 == null) goto L37;
    L27:
        if (r11 != null) goto L29;
        r1.b(r9, r9.a(r14, r15));
        goto L37
    L29:
        if (r1.a(r11, r11.a(r14, r15)) == false) goto L37;
        r7 = r0.a(r15, r1);     // Catch: Exception -> L34
        r14.a(r7);
        if (r7.getClass() == this.f12512c.e()) goto L37;
        r15.b(this.f12512c, String.format("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(this.f12512c), com.fasterxml.jackson.databind.l.h.c(r7)}));
    L34:
        e = move-exception;
        a(e, this.f12512c.e(), r10, r15);
        goto L37
    L49:
        r9.a(r14, r15, r7);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        a(e, r7, r9.a(), r15);
        goto L37
    L16:
        if (r9.a(r4) == true) goto L18;
        r14.k();
        goto L37
    L11:
        r9 = null;
        goto L12
    L38:
        if (r7 == null) goto L47;
        return r7;
    L47:
        return r0.a(r15, r1);
    L41:
        e = move-exception;
        return a(e, r15);
    L5:
        r4 = null;
        goto L6
    }

    public Object f(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        return r8.a(f(r8), r7.l(), r7, "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", new Object[]{com.fasterxml.jackson.databind.l.h.b(this.f12512c), r7.l()});
    }
}
