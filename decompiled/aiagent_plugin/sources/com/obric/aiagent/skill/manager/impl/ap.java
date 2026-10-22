package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19504b;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ap.class) == true) goto L8;
        return false;
    L8:
        ap r8 = (ap) ZeusTransformUtils.preCheckCast(r7, ap.class, "com.obric.aiagent.plugin");
        if (this.f19503a == r8.f19503a) goto L12;
        return false;
    L12:
        if (this.f19504b == r8.f19504b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f19503a) * 31) + Long.hashCode(this.f19504b);
    }

    public String toString() {
        return "ShopSkillDownload(version=" + this.f19503a + ", downloadedBytes=" + this.f19504b + ')';
    }

    public ap(int r1, long r2) {
        this.f19503a = r1;
        this.f19504b = r2;
    }

    public final int a() {
        return this.f19503a;
    }

    public final long b() {
        return this.f19504b;
    }
}
