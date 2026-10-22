package com.bytedance.apm.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes.dex */
public class o<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public F f4988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public S f4989b;

    public o(F r1, S r2) {
        this.f4988a = r1;
        this.f4989b = r2;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, o.class) == true) goto L5;
        return false;
    L5:
        o r5 = (o) ZeusTransformUtils.preCheckCast(r4, o.class, "com.obric.aiagent.plugin");
        if (n.a(r5.f4988a, this.f4988a) == true) goto L8;
        return false;
    L8:
        if (n.a(r5.f4989b, this.f4989b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        F r0 = this.f4988a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        S r3 = this.f4989b;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f4988a) + " " + this.f4989b + "}";
    }
}
