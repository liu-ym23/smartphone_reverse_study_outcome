package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillImportTempCleaner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19659b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ch.class) == true) goto L8;
        return false;
    L8:
        ch r6 = (ch) ZeusTransformUtils.preCheckCast(r5, ch.class, "com.obric.aiagent.plugin");
        if (this.f19658a == r6.f19658a) goto L12;
        return false;
    L12:
        if (this.f19659b == r6.f19659b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f19658a) * 31) + Integer.hashCode(this.f19659b);
    }

    public String toString() {
        return "SkillImportTempCleanupResult(deletedCount=" + this.f19658a + ", failedCount=" + this.f19659b + ')';
    }

    public ch(int r1, int r2) {
        this.f19658a = r1;
        this.f19659b = r2;
    }

    public final int a() {
        return this.f19658a;
    }

    public final int b() {
        return this.f19659b;
    }
}
