package com.obric.autogui.operator;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOStepDebugInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29917b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f29916a, r6.f29916a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f29917b, r6.f29917b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f29916a.hashCode() * 31;
        String r1 = this.f29917b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AOStepDebugInfo(reason=" + this.f29916a + ", debugString=" + this.f29917b + ')';
    }

    public f(String r2, String r3) {
        d.h.b.o.e(r2, "reason");
        this.f29916a = r2;
        this.f29917b = r3;
    }

    public final String a() {
        return this.f29916a;
    }

    public final String b() {
        return this.f29917b;
    }
}
