package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: compiled from: BigIntegerNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BigInteger f12760b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BigInteger f12761c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigInteger f12762d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final BigInteger f12763e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final BigInteger f12764a;

    static {
        f12760b = BigInteger.valueOf(-2147483648L);
        f12761c = BigInteger.valueOf(2147483647L);
        f12762d = BigInteger.valueOf(Long.MIN_VALUE);
        f12763e = BigInteger.valueOf(Long.MAX_VALUE);
    }

    public c(BigInteger r1) {
        this.f12764a = r1;
    }

    public static c a(BigInteger r1) {
        return new c(r1);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.i;
    }

    @Override // com.fasterxml.jackson.databind.n
    public double b() {
        return this.f12764a.doubleValue();
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r1, ac r2) {
        r1.a(this.f12764a);
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, c.class) == true) goto L13;
        return false;
    L13:
        return ((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin")).f12764a.equals(this.f12764a);
    }

    public int hashCode() {
        return this.f12764a.hashCode();
    }
}
