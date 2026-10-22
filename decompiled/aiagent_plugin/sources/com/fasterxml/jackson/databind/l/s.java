package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: compiled from: ObjectBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o<Object[]> f13055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o<Object[]> f13056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f13058d;

    public s() {
    }

    public Object[] a() {
        d();
        Object[] r0 = this.f13058d;
        if (r0 != null) goto L6;
        Object[] r1 = new Object[12];
        this.f13058d = r1;
        return r1;
    L6:
        return r0;
    }

    public Object[] a(Object[] r3, int r4) {
        d();
        Object[] r0 = this.f13058d;
        if (r0 != null) goto L5;
    L6:
        this.f13058d = new Object[Math.max(12, r4)];
    L7:
        System.arraycopy(r3, 0, this.f13058d, 0, r4);
        return this.f13058d;
    L5:
        if (r0.length >= r4) goto L7;
        goto L6
    }

    public Object[] a(Object[] r3) {
        o<Object[]> r0 = new o(r3, null);
        if (this.f13055a != null) goto L5;
        this.f13056b = r0;
        this.f13055a = r0;
    L6:
        int r4 = r3.length;
        this.f13057c += r4;
        if (r4 >= 16384) goto L10;
        r4 = r4 + r4;
    L13:
        return new Object[r4];
    L10:
        if (r4 >= 262144) goto L13;
        r4 = r4 + (r4 >> 2);
        goto L13
    L5:
        this.f13056b.a(r0);
        this.f13056b = r0;
        goto L6
    }

    public Object[] b(Object[] r3, int r4) {
        int r0 = this.f13057c + r4;
        Object[] r1 = new Object[r0];
        a(r1, r0, r3, r4);
        d();
        return r1;
    }

    public <T> T[] a(Object[] r4, int r5, Class<T> r6) {
        int r0 = this.f13057c + r5;
        T[] r7 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r6, r0), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin"));
        a(r7, r0, r4, r5);
        d();
        return r7;
    }

    public void a(Object[] r7, int r8, List<Object> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o<Object[]> r0 = this.f13055a;
    L3:
        int r2 = 0;
        if (r0 == null) goto L9;
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(r0.b(), Object[].class, "com.obric.aiagent.plugin");
        int r4 = r3.length;
    L6:
        if (r2 >= r4) goto L8;
        r10.add(r3[r2]);
        r2 = r2 + 1;
        goto L6
    L8:
        r0 = r0.a();
    L9:
        if (r2 >= r8) goto L11;
        r10.add(r7[r2]);
        r2 = r2 + 1;
        goto L9
    L11:
        d();
    }

    public int b() {
        Object[] r0 = this.f13058d;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public int c() {
        return this.f13057c;
    }

    public void d() {
        o<Object[]> r0 = this.f13056b;
        if (r0 == null) goto L5;
        this.f13058d = (Object[]) ZeusTransformUtils.preCheckCast(r0.b(), Object[].class, "com.obric.aiagent.plugin");
    L5:
        this.f13056b = null;
        this.f13055a = null;
        this.f13057c = 0;
    }

    public final void a(Object r6, int r7, Object[] r8, int r9) {
        o<Object[]> r5 = this.f13055a;
        int r1 = 0;
    L3:
        if (r5 == null) goto L5;
        Object[] r2 = (Object[]) ZeusTransformUtils.preCheckCast(r5.b(), Object[].class, "com.obric.aiagent.plugin");
        int r3 = r2.length;
        System.arraycopy(r2, 0, r6, r1, r3);
        r1 = r1 + r3;
        r5 = r5.a();
        goto L3
    L5:
        System.arraycopy(r8, 0, r6, r1, r9);
        int r4 = r1 + r9;
        if (r4 != r7) goto L9;
        return;
    L9:
        throw new IllegalStateException("Should have gotten " + r7 + " entries, got " + r4);
    }
}
