package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NullNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f12794a = null;

    static {
        f12794a = new o();
    }

    public o() {
    }

    public static o e() {
        return f12794a;
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.m;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r1, ac r2) {
        r2.a(r1);
    }

    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (ZeusTransformUtils.instanceOf(r1, o.class) == true) goto L7;
        return false;
    }

    public int hashCode() {
        return m.f12792e.ordinal();
    }
}
