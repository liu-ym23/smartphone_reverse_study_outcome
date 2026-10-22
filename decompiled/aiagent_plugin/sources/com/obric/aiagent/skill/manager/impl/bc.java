package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDerivedProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19552c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bc.class) == true) goto L8;
        return false;
    L8:
        bc r6 = (bc) ZeusTransformUtils.preCheckCast(r5, bc.class, "com.obric.aiagent.plugin");
        if (this.f19550a == r6.f19550a) goto L12;
        return false;
    L12:
        if (this.f19551b == r6.f19551b) goto L15;
        return false;
    L15:
        if (this.f19552c == r6.f19552c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f19550a) * 31) + Boolean.hashCode(this.f19551b)) * 31) + Boolean.hashCode(this.f19552c);
    }

    public String toString() {
        return "SkillDetailMenuVisibility(showEdit=" + this.f19550a + ", editEnabled=" + this.f19551b + ", showDelete=" + this.f19552c + ')';
    }

    public bc(boolean r1, boolean r2, boolean r3) {
        this.f19550a = r1;
        this.f19551b = r2;
        this.f19552c = r3;
    }

    public final boolean a() {
        return this.f19550a;
    }

    public final boolean b() {
        return this.f19551b;
    }

    public final boolean c() {
        return this.f19552c;
    }
}
