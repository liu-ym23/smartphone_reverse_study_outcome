package com.fasterxml.jackson.databind.l;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RawValue.java */
/* JADX INFO: loaded from: classes2.dex */
public class u implements com.fasterxml.jackson.databind.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object f13066a;

    public u(String r1) {
        this.f13066a = r1;
    }

    @Override // com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r3, ac r4) {
        if (ZeusTransformUtils.instanceOf(this.f13066a, com.fasterxml.jackson.databind.o.class) == false) goto L5;
        ((com.fasterxml.jackson.databind.o) ZeusTransformUtils.preCheckCast(this.f13066a, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin")).a(r3, r4);
        return;
    L5:
        b(r3);
    }

    @Override // com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r3, ac r4, com.fasterxml.jackson.databind.h.h r5) {
        if (ZeusTransformUtils.instanceOf(this.f13066a, com.fasterxml.jackson.databind.o.class) == false) goto L6;
        ((com.fasterxml.jackson.databind.o) ZeusTransformUtils.preCheckCast(this.f13066a, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin")).a(r3, r4, r5);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(this.f13066a, com.fasterxml.jackson.a.q.class) == false) goto L10;
        a(r3, r4);
        return;
    }

    public void a(com.fasterxml.jackson.a.h r3) {
        if (ZeusTransformUtils.instanceOf(this.f13066a, com.fasterxml.jackson.databind.o.class) == false) goto L5;
        r3.h(this.f13066a);
        return;
    L5:
        b(r3);
    }

    public void b(com.fasterxml.jackson.a.h r3) {
        if (ZeusTransformUtils.instanceOf(this.f13066a, com.fasterxml.jackson.a.q.class) == false) goto L5;
        r3.e((com.fasterxml.jackson.a.q) ZeusTransformUtils.preCheckCast(this.f13066a, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r3.d(String.valueOf(this.f13066a));
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
        Object r4 = this.f13066a;
        Object r7 = r6.f13066a;
        if (r4 != r7) goto L11;
        return true;
    L11:
        if (r4 == null) goto L16;
        if (r4.equals(r7) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Object r0 = this.f13066a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return String.format("[RawValue of type %s]", new Object[]{h.d(this.f13066a)});
    }
}
