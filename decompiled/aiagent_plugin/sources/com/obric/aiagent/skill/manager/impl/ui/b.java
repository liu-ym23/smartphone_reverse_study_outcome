package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSkillUi.kt */
/* JADX INFO: loaded from: classes3.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f20623b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20622a, r6.f20622a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f20623b, r6.f20623b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f20622a.hashCode() * 31) + Float.hashCode(this.f20623b);
    }

    public String toString() {
        return "AppFunctionSkillIconBindingToken(packageName=" + this.f20622a + ", radiusPx=" + this.f20623b + ')';
    }

    public b(String r2, float r3) {
        d.h.b.o.e(r2, "packageName");
        this.f20622a = r2;
        this.f20623b = r3;
    }
}
