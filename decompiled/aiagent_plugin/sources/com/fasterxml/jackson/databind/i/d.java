package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: BinaryNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d f12765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final byte[] f12766b;

    static {
        f12765a = new d(new byte[0]);
    }

    public d(byte[] r1) {
        this.f12766b = r1;
    }

    public static d a(byte[] r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.length != 0) goto L10;
        return f12765a;
    L10:
        return new d(r1);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.g;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r3, ac r4) {
        com.fasterxml.jackson.a.a r5 = r4.c().u();
        byte[] r2 = this.f12766b;
        r3.a(r5, r2, 0, r2.length);
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, d.class) == true) goto L13;
        return false;
    L13:
        return Arrays.equals(((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin")).f12766b, this.f12766b);
    }

    public int hashCode() {
        byte[] r0 = this.f12766b;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.length;
    }
}
