package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cp f20028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20029b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, gs.class) == true) goto L8;
        return false;
    L8:
        gs r6 = (gs) ZeusTransformUtils.preCheckCast(r5, gs.class, "com.obric.aiagent.plugin");
        if (this.f20028a == r6.f20028a) goto L12;
        return false;
    L12:
        if (this.f20029b == r6.f20029b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f20028a.hashCode() * 31) + Integer.hashCode(this.f20029b);
    }

    public String toString() {
        return "SkillStoreInstallTrackingMetadata(installType=" + this.f20028a + ", skillVersion=" + this.f20029b + ')';
    }

    public gs(cp r2, int r3) {
        d.h.b.o.e(r2, "installType");
        this.f20028a = r2;
        this.f20029b = r3;
    }

    public final cp a() {
        return this.f20028a;
    }

    public final int b() {
        return this.f20029b;
    }
}
