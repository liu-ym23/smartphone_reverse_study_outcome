package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShortNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final short f12797a;

    public s(short r1) {
        this.f12797a = r1;
    }

    public static s a(short r1) {
        return new s(r1);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.i;
    }

    @Override // com.fasterxml.jackson.databind.n
    public double b() {
        return this.f12797a;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r1, ac r2) {
        r1.a(this.f12797a);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, s.class) == true) goto L11;
        return false;
    L11:
        if (((s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.aiagent.plugin")).f12797a != this.f12797a) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return this.f12797a;
    }
}
