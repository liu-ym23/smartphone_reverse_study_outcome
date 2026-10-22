package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;

/* JADX INFO: compiled from: DecimalNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12771a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BigDecimal f12772c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigDecimal f12773d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final BigDecimal f12774e = null;
    private static final BigDecimal f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final BigDecimal f12775b;

    static {
        f12771a = new g(BigDecimal.ZERO);
        f12772c = BigDecimal.valueOf(-2147483648L);
        f12773d = BigDecimal.valueOf(2147483647L);
        f12774e = BigDecimal.valueOf(Long.MIN_VALUE);
        f = BigDecimal.valueOf(Long.MAX_VALUE);
    }

    public g(BigDecimal r1) {
        this.f12775b = r1;
    }

    public static g a(BigDecimal r1) {
        return new g(r1);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.j;
    }

    @Override // com.fasterxml.jackson.databind.n
    public double b() {
        return this.f12775b.doubleValue();
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r1, ac r2) {
        r1.a(this.f12775b);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L11;
        return false;
    L11:
        if (((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).f12775b.compareTo(this.f12775b) != 0) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Double.valueOf(b()).hashCode();
    }
}
