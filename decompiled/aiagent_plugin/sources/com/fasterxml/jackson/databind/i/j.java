package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IntNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j[] f12778b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f12779a;

    static {
        f12778b = new j[12];
        int r1 = 0;
    L3:
        if (r1 >= 12) goto L5;
        f12778b[r1] = new j(r1 - 1);
        r1 = r1 + 1;
        goto L3
    }

    public j(int r1) {
        this.f12779a = r1;
    }

    public static j a(int r2) {
        if (r2 > 10) goto L10;
        if (r2 < (-1)) goto L10;
        return f12778b[r2 - (-1)];
    L10:
        return new j(r2);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.i;
    }

    @Override // com.fasterxml.jackson.databind.n
    public double b() {
        return this.f12779a;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r1, ac r2) {
        r1.d(this.f12779a);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L11;
        return false;
    L11:
        if (((j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin")).f12779a != this.f12779a) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return this.f12779a;
    }
}
