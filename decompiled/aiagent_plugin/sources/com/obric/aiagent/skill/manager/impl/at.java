package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillCoverStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19521b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, at.class) == true) goto L8;
        return false;
    L8:
        at r6 = (at) ZeusTransformUtils.preCheckCast(r5, at.class, "com.obric.aiagent.plugin");
        if (this.f19520a == r6.f19520a) goto L12;
        return false;
    L12:
        if (this.f19521b == r6.f19521b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f19520a) * 31) + Integer.hashCode(this.f19521b);
    }

    public String toString() {
        return "SkillCoverCleanupResult(deletedCount=" + this.f19520a + ", failedCount=" + this.f19521b + ')';
    }

    public at(int r1, int r2) {
        this.f19520a = r1;
        this.f19521b = r2;
    }

    public final int a() {
        return this.f19520a;
    }

    public final int b() {
        return this.f19521b;
    }
}
