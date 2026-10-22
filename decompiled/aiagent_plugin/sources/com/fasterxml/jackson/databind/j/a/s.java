package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: UnwrappingBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends com.fasterxml.jackson.databind.j.d implements Serializable {
    protected final com.fasterxml.jackson.databind.l.q w;

    @Override // com.fasterxml.jackson.databind.j.d
    public /* synthetic */ com.fasterxml.jackson.databind.j.d a(com.fasterxml.jackson.databind.l.q r1) {
        return c(r1);
    }

    public s(com.fasterxml.jackson.databind.j.d r1, com.fasterxml.jackson.databind.l.q r2) {
        super(r1);
        this.w = r2;
    }

    public s(s r1, com.fasterxml.jackson.databind.l.q r2, com.fasterxml.jackson.a.d.m r3) {
        super(r1, r3);
        this.w = r2;
    }

    public s c(com.fasterxml.jackson.databind.l.q r3) {
        String r0 = r3.a(this.f12940d.a());
        return a(com.fasterxml.jackson.databind.l.q.a(r3, this.w), new com.fasterxml.jackson.a.d.m(r0));
    }

    public s a(com.fasterxml.jackson.databind.l.q r2, com.fasterxml.jackson.a.d.m r3) {
        return new s(this, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.j.d, com.fasterxml.jackson.databind.j.o
    public void a(Object r5, com.fasterxml.jackson.a.h r6, ac r7) {
        Object r0 = a(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        com.fasterxml.jackson.databind.p<?> r1 = this.m;
        if (r1 != null) goto L12;
        Class<?> r2 = r0.getClass();
        k r3 = this.p;
        com.fasterxml.jackson.databind.p<?> r4 = r3.a(r2);
        if (r4 != null) goto L10;
        r1 = a(r3, r2, r7);
        goto L12
    L10:
        r1 = r4;
    L12:
        if (this.r != null) goto L14;
    L21:
        if (r0 != r5) goto L26;
        if (a(r5, r6, r7, r1) == false) goto L26;
        return;
    L26:
        if (r1.c() == true) goto L29;
        r6.b(this.f12940d);
    L29:
        if (this.o != null) goto L31;
        r1.a(r0, r6, r7);
        return;
    L31:
        r1.a(r0, r6, r7, this.o);
        return;
    L14:
        if (f12939c != this.r) goto L19;
        if (r1.a(r7, r0) == false) goto L21;
        return;
    L19:
        if (this.r.equals(r0) == false) goto L21;
    }

    @Override // com.fasterxml.jackson.databind.j.d
    public void a(com.fasterxml.jackson.databind.p<Object> r4) {
        if (r4 == null) goto L9;
        com.fasterxml.jackson.databind.l.q r0 = this.w;
        if (r4.c() == true) goto L6;
    L8:
        r4 = r4.a(r0);
        goto L9
    L6:
        if (ZeusTransformUtils.instanceOf(r4, t.class) == false) goto L8;
        r0 = com.fasterxml.jackson.databind.l.q.a(r0, ((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.aiagent.plugin")).f12850a);
    L9:
        super.a(r4);
    }

    @Override // com.fasterxml.jackson.databind.j.d
    public com.fasterxml.jackson.databind.p<Object> a(k r3, Class<?> r4, ac r5) {
        if (this.h == null) goto L5;
        com.fasterxml.jackson.databind.p<Object> r6 = r5.a(r5.a(this.h, r4), this);
    L6:
        com.fasterxml.jackson.databind.l.q r7 = this.w;
        if (r6.c() == true) goto L9;
    L11:
        com.fasterxml.jackson.databind.p<Object> r8 = r6.a(r7);
        this.p = this.p.b(r4, r8);
        return r8;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, t.class) == false) goto L11;
        r7 = com.fasterxml.jackson.databind.l.q.a(r7, ((t) ZeusTransformUtils.preCheckCast(r6, t.class, "com.obric.aiagent.plugin")).f12850a);
        goto L11
    L5:
        r6 = r5.a(r4, this);
        goto L6
    }
}
