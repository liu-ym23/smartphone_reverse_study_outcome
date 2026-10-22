package com.bytedance.apm.block.trace;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MethodItem.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4453e;

    public h(int r2, int r3, long r4, int r6) {
        this.f4453e = 1;
        this.f4449a = r2;
        this.f4450b = r3;
        this.f4452d = r6;
        this.f4451c = r4;
    }

    public String toString() {
        return this.f4452d + "," + this.f4449a + "," + this.f4453e + "," + this.f4450b + "," + this.f4451c;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L10;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
        if (r4.f4449a == this.f4449a) goto L7;
        return false;
    L7:
        if (r4.f4452d != this.f4452d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void a(long r3) {
        this.f4453e++;
        this.f4450b = (int) (((long) this.f4450b) + r3);
    }
}
