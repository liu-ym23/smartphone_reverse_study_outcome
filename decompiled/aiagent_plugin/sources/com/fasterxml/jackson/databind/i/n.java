package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LongNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final long f12793a;

    public n(long r1) {
        this.f12793a = r1;
    }

    public static n a(long r1) {
        return new n(r1);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.i;
    }

    @Override // com.fasterxml.jackson.databind.n
    public double b() {
        return this.f12793a;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r3, ac r4) {
        r3.b(this.f12793a);
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, n.class) == true) goto L11;
        return false;
    L11:
        if (((n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.aiagent.plugin")).f12793a != this.f12793a) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r0 = this.f12793a;
        return ((int) r0) ^ ((int) (r0 >> 32));
    }
}
