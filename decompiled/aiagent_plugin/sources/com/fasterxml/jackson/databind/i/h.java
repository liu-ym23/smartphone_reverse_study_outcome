package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DoubleNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final double f12776a;

    public h(double r1) {
        this.f12776a = r1;
    }

    public static h a(double r1) {
        return new h(r1);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.j;
    }

    @Override // com.fasterxml.jackson.databind.n
    public double b() {
        return this.f12776a;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r3, ac r4) {
        r3.a(this.f12776a);
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, h.class) == false) goto L15;
        double r3 = ((h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.aiagent.plugin")).f12776a;
        if (Double.compare(this.f12776a, r3) != 0) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.f12776a);
        return ((int) r0) ^ ((int) (r0 >> 32));
    }
}
