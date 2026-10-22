package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDeleteTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19536b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ax.class) == true) goto L8;
        return false;
    L8:
        ax r6 = (ax) ZeusTransformUtils.preCheckCast(r5, ax.class, "com.obric.aiagent.plugin");
        if (this.f19535a == r6.f19535a) goto L12;
        return false;
    L12:
        if (this.f19536b == r6.f19536b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f19535a) * 31) + Boolean.hashCode(this.f19536b);
    }

    public String toString() {
        return "SkillDeleteResult(deletedFiles=" + this.f19535a + ", removedState=" + this.f19536b + ')';
    }

    public ax(boolean r1, boolean r2) {
        this.f19535a = r1;
        this.f19536b = r2;
    }

    public final boolean a() {
        return this.f19535a;
    }

    public final boolean b() {
        return this.f19536b;
    }

    public final boolean c() {
        if (this.f19535a == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f19536b == true) goto L8;
        return false;
    }
}
