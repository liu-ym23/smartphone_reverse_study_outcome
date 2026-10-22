package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ArrayNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends f<a> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.fasterxml.jackson.databind.n> f12759b;

    @Override // com.fasterxml.jackson.databind.n
    public com.fasterxml.jackson.databind.n a(String r1) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.n
    public boolean a() {
        return true;
    }

    public a(l r1) {
        super(r1);
        this.f12759b = new ArrayList();
    }

    @Override // com.fasterxml.jackson.databind.o.a
    public boolean a(ac r1) {
        return this.f12759b.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.n
    public Iterator<com.fasterxml.jackson.databind.n> c() {
        return this.f12759b.iterator();
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r6, ac r7) {
        List<com.fasterxml.jackson.databind.n> r0 = this.f12759b;
        int r1 = r0.size();
        r6.a(this, r1);
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L5;
        ((b) ZeusTransformUtils.preCheckCast((com.fasterxml.jackson.databind.n) ZeusTransformUtils.preCheckCast(r0.get(r5), com.fasterxml.jackson.databind.n.class, "com.obric.aiagent.plugin"), b.class, "com.obric.aiagent.plugin")).a(r6, r7);
        r5 = r5 + 1;
        goto L3
    L5:
        r6.i();
    }

    @Override // com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r5, ac r6, com.fasterxml.jackson.databind.h.h r7) {
        com.fasterxml.jackson.a.g.b r0 = r7.a(r5, r7.a(this, com.fasterxml.jackson.a.n.f12154d));
        Iterator<com.fasterxml.jackson.databind.n> r4 = this.f12759b.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast((com.fasterxml.jackson.databind.n) ZeusTransformUtils.preCheckCast(r4.next(), com.fasterxml.jackson.databind.n.class, "com.obric.aiagent.plugin"), b.class, "com.obric.aiagent.plugin")).a(r5, r6);
        goto L4
    L6:
        r7.b(r5, r0);
    }

    public a a(com.fasterxml.jackson.databind.n r1) {
        if (r1 != null) goto L4;
        r1 = d();
    L4:
        b(r1);
        return this;
    }

    public a insert(int r1, com.fasterxml.jackson.databind.n r2) {
        if (r2 != null) goto L4;
        r2 = d();
    L4:
        a(r1, r2);
        return this;
    }

    public a a(int r2) {
        return a(r2, d());
    }

    public a insert(int r1, short r2) {
        return a(r1, a(r2));
    }

    public a insert(int r1, Short r2) {
        if (r2 != null) goto L4;
        com.fasterxml.jackson.databind.n r3 = d();
    L6:
        return a(r1, r3);
    L4:
        r3 = a(r2.shortValue());
        goto L6
    }

    public a insert(int r1, int r2) {
        return a(r1, b(r2));
    }

    public a insert(int r1, Integer r2) {
        if (r2 != null) goto L4;
        com.fasterxml.jackson.databind.n r3 = d();
    L6:
        return a(r1, r3);
    L4:
        r3 = b(r2.intValue());
        goto L6
    }

    public a insert(int r1, long r2) {
        return a(r1, a(r2));
    }

    public a insert(int r3, Long r4) {
        if (r4 != null) goto L4;
        com.fasterxml.jackson.databind.n r5 = d();
    L6:
        return a(r3, r5);
    L4:
        r5 = a(r4.longValue());
        goto L6
    }

    public a insert(int r1, float r2) {
        return a(r1, a(r2));
    }

    public a insert(int r1, Float r2) {
        if (r2 != null) goto L4;
        com.fasterxml.jackson.databind.n r3 = d();
    L6:
        return a(r1, r3);
    L4:
        r3 = a(r2.floatValue());
        goto L6
    }

    public a insert(int r1, double r2) {
        return a(r1, a(r2));
    }

    public a insert(int r3, Double r4) {
        if (r4 != null) goto L4;
        com.fasterxml.jackson.databind.n r5 = d();
    L6:
        return a(r3, r5);
    L4:
        r5 = a(r4.doubleValue());
        goto L6
    }

    public a insert(int r1, BigDecimal r2) {
        if (r2 != null) goto L4;
        u r3 = d();
    L6:
        return a(r1, r3);
    L4:
        r3 = a(r2);
        goto L6
    }

    public a insert(int r1, BigInteger r2) {
        if (r2 != null) goto L4;
        u r3 = d();
    L6:
        return a(r1, r3);
    L4:
        r3 = a(r2);
        goto L6
    }

    public a insert(int r1, String r2) {
        if (r2 != null) goto L4;
        com.fasterxml.jackson.databind.n r3 = d();
    L6:
        return a(r1, r3);
    L4:
        r3 = b(r2);
        goto L6
    }

    public a insert(int r1, boolean r2) {
        return a(r1, a(r2));
    }

    public a insert(int r1, Boolean r2) {
        if (r2 != null) goto L6;
        return a(r1);
    L6:
        return a(r1, a(r2.booleanValue()));
    }

    public a insert(int r1, byte[] r2) {
        if (r2 != null) goto L6;
        return a(r1);
    L6:
        return a(r1, a(r2));
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L12;
        return false;
    L12:
        return this.f12759b.equals(((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin")).f12759b);
    }

    public int hashCode() {
        return this.f12759b.hashCode();
    }

    public a b(com.fasterxml.jackson.databind.n r2) {
        this.f12759b.add(r2);
        return this;
    }

    public a a(int r2, com.fasterxml.jackson.databind.n r3) {
        if (r2 >= 0) goto L5;
        this.f12759b.add(0, r3);
    L8:
        return this;
    L5:
        if (r2 < this.f12759b.size()) goto L7;
        this.f12759b.add(r3);
        goto L8
    L7:
        this.f12759b.add(r2, r3);
        goto L8
    }
}
