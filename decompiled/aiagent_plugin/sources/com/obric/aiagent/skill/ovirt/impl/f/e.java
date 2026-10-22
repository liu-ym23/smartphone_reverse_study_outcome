package com.obric.aiagent.skill.ovirt.impl.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SkillProjectionModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.api.e f21345b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21344a, r6.f21344a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21345b, r6.f21345b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f21344a.hashCode() * 31) + this.f21345b.hashCode();
    }

    public String toString() {
        return "SkillSnapshotBinding(slug=" + this.f21344a + ", homeSkillPath=" + this.f21345b + ')';
    }

    public e(String r2, com.obric.aiagent.skill.virt.api.e r3) {
        o.e(r2, "slug");
        o.e(r3, "homeSkillPath");
        this.f21344a = r2;
        this.f21345b = r3;
    }
}
