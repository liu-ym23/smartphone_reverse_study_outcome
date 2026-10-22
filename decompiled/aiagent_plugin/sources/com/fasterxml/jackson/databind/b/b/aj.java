package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ThrowableDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class aj extends com.fasterxml.jackson.databind.b.c {
    public aj(com.fasterxml.jackson.databind.b.c r1) {
        super(r1);
        this.j = false;
    }

    public aj(com.fasterxml.jackson.databind.b.c r1, com.fasterxml.jackson.databind.l.q r2) {
        super(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.c, com.fasterxml.jackson.databind.b.d, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.l.q r3) {
        if (getClass() == aj.class) goto L6;
        return this;
    L6:
        return new aj(this, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.c, com.fasterxml.jackson.databind.b.d
    public Object b(com.fasterxml.jackson.a.k r11, com.fasterxml.jackson.databind.h r12) {
        if (this.h == null) goto L7;
        return c(r11, r12);
    L7:
        if (this.f != null) goto L9;
        int r1 = 0;
        if (this.f12512c.g() == true) goto L13;
        boolean r0 = this.f12514e.d();
        boolean r2 = this.f12514e.k();
        if (r0 == true) goto L19;
        if (r2 == true) goto L19;
        return r12.a(a(), k(), r11, "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
    L19:
        int r5 = 0;
        Throwable r3 = null;
        Object[] r4 = null;
        Throwable[] r6 = null;
    L21:
        if (r11.a(com.fasterxml.jackson.a.n.f12153c) == true) goto L46;
        String r7 = r11.w();
        com.fasterxml.jackson.databind.b.v r9 = this.k.a(r7);
        r11.g();
        if (r9 == null) goto L30;
        if (r3 == null) goto L26;
        r9.a(r11, r12, r3);
    L45:
        r11.g();
        goto L21
    L26:
        if (r4 != null) goto L28;
        int r8 = this.k.b();
        r4 = new Object[r8 + r8];
    L28:
        int r10 = r5 + 1;
        r4[r5] = r9;
        r5 = r10 + 1;
        r4[r10] = r9.a(r11, r12);
        goto L45
    L30:
        if ("message".equals(r7) == false) goto L34;
        if (r0 == false) goto L37;
        r3 = (Throwable) ZeusTransformUtils.preCheckCast(this.f12514e.a(r12, r11.R()), Throwable.class, "com.obric.aiagent.plugin");
    L37:
        if (this.n == null) goto L42;
        if (this.n.contains(r7) == false) goto L42;
        r11.k();
    L42:
        if (this.m == null) goto L44;
        this.m.a(r11, r12, r3, r7);
        goto L45
    L44:
        b(r11, r12, r3, r7);
        goto L45
    L34:
        if ("suppressed".equals(r7) == false) goto L37;
        r6 = (Throwable[]) ZeusTransformUtils.preCheckCast(r12.a(r11, Throwable[].class), Throwable[].class, "com.obric.aiagent.plugin");
        goto L45
    L46:
        if (r3 != null) goto L50;
        if (r0 == false) goto L49;
        r3 = (Throwable) ZeusTransformUtils.preCheckCast(this.f12514e.a(r12, null), Throwable.class, "com.obric.aiagent.plugin");
        goto L50
    L49:
        r3 = (Throwable) ZeusTransformUtils.preCheckCast(this.f12514e.a(r12), Throwable.class, "com.obric.aiagent.plugin");
    L50:
        if (r4 == null) goto L54;
        int r13 = 0;
    L52:
        if (r13 >= r5) goto L54;
        ((com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(r4[r13], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin")).a(r3, r4[r13 + 1]);
        r13 = r13 + 2;
    L54:
        if (r6 == null) goto L58;
        int r14 = r6.length;
    L56:
        if (r1 >= r14) goto L58;
        r3.addSuppressed(r6[r1]);
        r1 = r1 + 1;
    L58:
        return r3;
    L13:
        return r12.a(a(), k(), r11, "abstract type (need to add/enable type information?)", new Object[0]);
    L9:
        return this.f12514e.a(r12, this.f.a(r11, r12));
    }
}
