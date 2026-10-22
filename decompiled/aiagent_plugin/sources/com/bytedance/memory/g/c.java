package com.bytedance.memory.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HprofField.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f8813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8814c;

    public c(int r1, e r2, Object r3) {
        this.f8812a = r1;
        this.f8813b = r2;
        this.f8814c = r3;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f8812a == r6.f8812a) goto L12;
        return false;
    L12:
        if (this.f8813b.equals(r6.f8813b) == true) goto L14;
        return false;
    L14:
        Object r0 = this.f8814c;
        if (r0 != null) goto L17;
    L18:
        Object r7 = r6.f8814c;
        if (r7 != null) goto L21;
        return true;
    L21:
        if (r7.equals(this.f8814c) == false) goto L24;
        return true;
    L24:
        return false;
    L17:
        if (r0.equals(r6.f8814c) == false) goto L24;
        goto L18
    }

    public int hashCode() {
        return (this.f8813b.hashCode() << 31) + this.f8812a;
    }
}
