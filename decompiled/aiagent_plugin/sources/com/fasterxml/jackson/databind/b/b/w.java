package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Objects;

/* JADX INFO: compiled from: ObjectArrayDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class w extends i<Object[]> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f12492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Class<?> f12493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<Object> f12494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.e f12495d;
    protected final Object[] i;

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return b(r1, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return a(r3, r4, (Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.aiagent.plugin"));
    }

    public w(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.l<Object> r4, com.fasterxml.jackson.databind.h.e r5) {
        super(r3, null, null);
        com.fasterxml.jackson.databind.k.a r6 = (com.fasterxml.jackson.databind.k.a) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.k.a.class, "com.obric.aiagent.plugin");
        Class<?> r0 = r6.x().e();
        this.f12493b = r0;
        if (r0 != Object.class) goto L5;
        boolean r1 = true;
    L6:
        this.f12492a = r1;
        this.f12494c = r4;
        this.f12495d = r5;
        this.i = r6.f_();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public w(w r3, com.fasterxml.jackson.databind.l<Object> r4, com.fasterxml.jackson.databind.h.e r5, com.fasterxml.jackson.databind.b.s r6, Boolean r7) {
        super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r7);
        this.f12493b = r3.f12493b;
        this.f12492a = r3.f12492a;
        this.i = r3.i;
        this.f12494c = r4;
        this.f12495d = r5;
    }

    public w a(com.fasterxml.jackson.databind.h.e r7, com.fasterxml.jackson.databind.l<?> r8, com.fasterxml.jackson.databind.b.s r9, Boolean r10) {
        com.fasterxml.jackson.databind.b.s r4 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r9, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        if (Objects.equals(r10, this.h) == false) goto L12;
        if (r4 != this.f) goto L12;
        if (r8 != this.f12494c) goto L12;
        if (r7 != this.f12495d) goto L12;
        return this;
    L12:
        return new w(this, r8, r7, r4, r10);
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        if (this.f12494c == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f12495d != null) goto L7;
        return true;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12967a;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l<?> r0 = this.f12494c;
        Boolean r1 = a(r4, r6, this.f12422e.e(), JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        com.fasterxml.jackson.databind.l<?> r2 = a(r4, r6, r0);
        com.fasterxml.jackson.databind.k r3 = this.f12422e.x();
        if (r2 != null) goto L5;
        com.fasterxml.jackson.databind.l<?> r7 = r4.a(r3, r6);
    L6:
        com.fasterxml.jackson.databind.h.e r8 = this.f12495d;
        if (r8 == null) goto L10;
        r8 = r8.a(r6);
    L10:
        return a(r8, r7, b(r4, r6, r7), r1);
    L5:
        r7 = r4.b(r2, r6, r3);
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.b.b.i
    public com.fasterxml.jackson.databind.l<Object> h() {
        return this.f12494c;
    }

    @Override // com.fasterxml.jackson.databind.b.b.i, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12995b;
    }

    @Override // com.fasterxml.jackson.databind.b.b.i, com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return this.i;
    }

    public Object[] b(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9) {
        if (r8.q() == false) goto L5;
        com.fasterxml.jackson.databind.l.s r0 = r9.n();
        Object[] r1 = r0.a();
        com.fasterxml.jackson.databind.h.e r2 = this.f12495d;
        int r4 = 0;
    L38:
        com.fasterxml.jackson.a.n r5 = r8.g();     // Catch: Exception -> L33
        if (r5 == com.fasterxml.jackson.a.n.f12155e) goto L28;
        if (r5 != com.fasterxml.jackson.a.n.m) goto L15;
        if (this.g == true) goto L38;
        Object r6 = this.f.a(r9);     // Catch: Exception -> L33
    L19:
        if (r4 < r1.length) goto L22;
        r1 = r0.a(r1);     // Catch: Exception -> L33
        r4 = 0;
    L22:
        int r7 = r4 + 1;
        r1[r4] = r6;     // Catch: Exception -> L25
        r4 = r7;
    L25:
        e = e;
        r4 = r7;
    L35:
        throw com.fasterxml.jackson.databind.m.a(e, r1, r0.c() + r4);
    L15:
        if (r2 != null) goto L17;
        r6 = this.f12494c.a(r8, r9);     // Catch: Exception -> L33
        goto L19
    L17:
        r6 = this.f12494c.a(r8, r9, r2);     // Catch: Exception -> L33
        goto L19
    L28:
        if (this.f12492a == false) goto L30;
        Object[] r10 = r0.b(r1, r4);
    L31:
        r9.a(r0);
        return r10;
    L30:
        r10 = r0.a(r1, r4, this.f12493b);
    L33:
        e = e;
        goto L35
    L5:
        return f(r8, r9);
    }

    public Object[] b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r3.b(r1, r2), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
    }

    public Object[] a(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, Object[] r9) {
        if (r7.q() == true) goto L9;
        Object[] r6 = f(r7, r8);
        if (r6 != null) goto L7;
        return r9;
    L7:
        int r10 = r9.length;
        Object[] r11 = new Object[r6.length + r10];
        System.arraycopy(r9, 0, r11, 0, r10);
        System.arraycopy(r6, 0, r11, r10, r6.length);
        return r11;
    L9:
        com.fasterxml.jackson.databind.l.s r0 = r8.n();
        int r2 = r9.length;
        Object[] r12 = r0.a(r9, r2);
        com.fasterxml.jackson.databind.h.e r3 = this.f12495d;
    L41:
        com.fasterxml.jackson.a.n r4 = r7.g();     // Catch: Exception -> L36
        if (r4 == com.fasterxml.jackson.a.n.f12155e) goto L31;
        if (r4 != com.fasterxml.jackson.a.n.m) goto L18;
        if (this.g == true) goto L41;
        Object r5 = this.f.a(r8);     // Catch: Exception -> L36
    L22:
        if (r2 < r12.length) goto L25;
        r12 = r0.a(r12);     // Catch: Exception -> L36
        r2 = 0;
    L25:
        int r13 = r2 + 1;
        r12[r2] = r5;     // Catch: Exception -> L28
        r2 = r13;
    L28:
        e = e;
        r2 = r13;
    L38:
        throw com.fasterxml.jackson.databind.m.a(e, r12, r0.c() + r2);
    L18:
        if (r3 != null) goto L20;
        r5 = this.f12494c.a(r7, r8);     // Catch: Exception -> L36
        goto L22
    L20:
        r5 = this.f12494c.a(r7, r8, r3);     // Catch: Exception -> L36
        goto L22
    L31:
        if (this.f12492a == false) goto L33;
        Object[] r14 = r0.b(r12, r2);
    L34:
        r8.a(r0);
        return r14;
    L33:
        r14 = r0.a(r12, r2, this.f12493b);
    L36:
        e = e;
        goto L38
    }

    public Byte[] d(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        byte[] r2 = r3.a(r4.k());
        Byte[] r5 = new Byte[r2.length];
        int r6 = r2.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r5[r0] = Byte.valueOf(r2[r0]);
        r0 = r0 + 1;
        goto L3
    L5:
        return r5;
    }

    public Object[] f(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7) {
        if (this.h != Boolean.TRUE) goto L5;
    L10:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L24;
        if (r6.a(com.fasterxml.jackson.a.n.h) == false) goto L22;
        if (this.f12493b != Byte.class) goto L20;
        return d(r6, r7);
    L20:
        return (Object[]) ZeusTransformUtils.preCheckCast(r(r6, r7), Object[].class, "com.obric.aiagent.plugin");
    L22:
        return (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r7.a(this.f12422e, r6), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
    L24:
        if (r6.a(com.fasterxml.jackson.a.n.m) == true) goto L26;
        com.fasterxml.jackson.databind.h.e r1 = this.f12495d;
        if (r1 != null) goto L33;
        Object r8 = this.f12494c.a(r6, r7);
    L35:
        if (this.f12492a == false) goto L37;
        Object[] r5 = new Object[1];
    L38:
        r5[0] = r8;
        return r5;
    L37:
        r5 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(this.f12493b, 1), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
        goto L38
    L33:
        r8 = this.f12494c.a(r6, r7, r1);
        goto L35
    L26:
        if (this.g == true) goto L28;
        r8 = this.f.a(r7);
        goto L35
    L28:
        return this.i;
    L5:
        if (this.h == null) goto L7;
    L9:
        r0 = false;
        goto L12
    L7:
        if (r7.a(com.fasterxml.jackson.databind.i.q) == false) goto L9;
        goto L9
    }
}
