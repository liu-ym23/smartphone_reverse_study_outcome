package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final at f19239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f19240b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, av.class) == true) goto L8;
        return false;
    L8:
        av r6 = (av) ZeusTransformUtils.preCheckCast(r5, av.class, "com.obric.aiagent.plugin");
        if (this.f19239a == r6.f19239a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19240b, r6.f19240b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19239a.hashCode() * 31) + this.f19240b.hashCode();
    }

    public String toString() {
        return "SkillStoreInstallResult(changeType=" + this.f19239a + ", skill=" + this.f19240b + ')';
    }

    public av(at r2, e r3) {
        d.h.b.o.e(r2, "changeType");
        d.h.b.o.e(r3, "skill");
        this.f19239a = r2;
        this.f19240b = r3;
    }

    public final at a() {
        return this.f19239a;
    }

    public final e b() {
        return this.f19240b;
    }
}
