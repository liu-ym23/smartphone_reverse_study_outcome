package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final gv f20058b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, gw.class) == true) goto L8;
        return false;
    L8:
        gw r6 = (gw) ZeusTransformUtils.preCheckCast(r5, gw.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20057a, r6.f20057a) == true) goto L12;
        return false;
    L12:
        if (this.f20058b == r6.f20058b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f20057a.hashCode() * 31) + this.f20058b.hashCode();
    }

    public String toString() {
        return "SkillStoreMetadataRefreshResult(slug=" + this.f20057a + ", outcome=" + this.f20058b + ')';
    }

    public gw(String r2, gv r3) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r3, "outcome");
        this.f20057a = r2;
        this.f20058b = r3;
    }

    public final gv a() {
        return this.f20058b;
    }
}
