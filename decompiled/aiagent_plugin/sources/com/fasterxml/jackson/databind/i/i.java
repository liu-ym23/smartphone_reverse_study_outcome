package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FloatNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final float f12777a;

    public i(float r1) {
        this.f12777a = r1;
    }

    public static i a(float r1) {
        return new i(r1);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.j;
    }

    @Override // com.fasterxml.jackson.databind.n
    public double b() {
        return this.f12777a;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r1, ac r2) {
        r1.a(this.f12777a);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == false) goto L15;
        float r6 = ((i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin")).f12777a;
        if (Float.compare(this.f12777a, r6) != 0) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f12777a);
    }
}
