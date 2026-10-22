package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: POJONode.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Object f12796a;

    public r(Object r1) {
        this.f12796a = r1;
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.g;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r3, ac r4) {
        Object r0 = this.f12796a;
        if (r0 != null) goto L6;
        r4.a(r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.o.class) == false) goto L8;
        ((com.fasterxml.jackson.databind.o) ZeusTransformUtils.preCheckCast(this.f12796a, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin")).a(r3, r4);
        return;
    L8:
        r4.a(this.f12796a, r3);
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, r.class) == true) goto L12;
        return false;
    L12:
        return a((r) ZeusTransformUtils.preCheckCast(r4, r.class, "com.obric.aiagent.plugin"));
    }

    public boolean a(r r1) {
        Object r0 = this.f12796a;
        if (r0 != null) goto L10;
        if (r1.f12796a != null) goto L7;
        return true;
    L7:
        return false;
    L10:
        return r0.equals(r1.f12796a);
    }

    public int hashCode() {
        return this.f12796a.hashCode();
    }
}
