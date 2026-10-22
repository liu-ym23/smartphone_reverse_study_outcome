package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f20542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f20543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f20544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20545d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, an.class) == true) goto L8;
        return false;
    L8:
        an r6 = (an) ZeusTransformUtils.preCheckCast(r5, an.class, "com.obric.aiagent.plugin");
        if (this.f20542a == r6.f20542a) goto L12;
        return false;
    L12:
        if (this.f20543b == r6.f20543b) goto L15;
        return false;
    L15:
        if (this.f20544c == r6.f20544c) goto L18;
        return false;
    L18:
        if (this.f20545d == r6.f20545d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f20542a) * 31) + Boolean.hashCode(this.f20543b)) * 31) + Boolean.hashCode(this.f20544c)) * 31) + Boolean.hashCode(this.f20545d);
    }

    public String toString() {
        return "SkillFormCoverPresentation(showPlaceholder=" + this.f20542a + ", showAddBadge=" + this.f20543b + ", showEditBadge=" + this.f20544c + ", clickable=" + this.f20545d + ')';
    }

    public an(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.f20542a = r1;
        this.f20543b = r2;
        this.f20544c = r3;
        this.f20545d = r4;
    }

    public final boolean a() {
        return this.f20542a;
    }

    public final boolean b() {
        return this.f20543b;
    }

    public final boolean c() {
        return this.f20544c;
    }
}
