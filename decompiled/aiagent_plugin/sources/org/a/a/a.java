package org.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Interval.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f40246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f40247b;

    @Override // org.a.a.b
    public int a() {
        return this.f40246a;
    }

    @Override // org.a.a.b
    public int b() {
        return this.f40247b;
    }

    public int c() {
        return (this.f40247b - this.f40246a) + 1;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L5;
        return false;
    L5:
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        if (this.f40246a == r5.a()) goto L8;
        return false;
    L8:
        if (this.f40247b != r5.b()) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return (this.f40246a % 100) + (this.f40247b % 100);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L6;
        return -1;
    L6:
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        int r0 = this.f40246a - r4.a();
        if (r0 == 0) goto L10;
        return r0;
    L10:
        return this.f40247b - r4.b();
    }

    public String toString() {
        return this.f40246a + ":" + this.f40247b;
    }
}
