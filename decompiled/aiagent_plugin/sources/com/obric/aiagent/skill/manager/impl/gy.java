package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopPaging.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f20060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20062c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, gy.class) == true) goto L8;
        return false;
    L8:
        gy r10 = (gy) ZeusTransformUtils.preCheckCast(r9, gy.class, "com.obric.aiagent.plugin");
        if (this.f20060a == r10.f20060a) goto L12;
        return false;
    L12:
        if (this.f20061b == r10.f20061b) goto L15;
        return false;
    L15:
        if (this.f20062c == r10.f20062c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f20060a) * 31) + Integer.hashCode(this.f20061b)) * 31) + Integer.hashCode(this.f20062c);
    }

    public String toString() {
        return "SkillStorePageRequest(generation=" + this.f20060a + ", page=" + this.f20061b + ", pageSize=" + this.f20062c + ')';
    }

    public gy(long r1, int r3, int r4) {
        this.f20060a = r1;
        this.f20061b = r3;
        this.f20062c = r4;
    }

    public final long a() {
        return this.f20060a;
    }

    public final int b() {
        return this.f20061b;
    }

    public final int c() {
        return this.f20062c;
    }
}
