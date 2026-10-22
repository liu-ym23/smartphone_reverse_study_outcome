package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bb f20533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bb f20534b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ak.class) == true) goto L8;
        return false;
    L8:
        ak r6 = (ak) ZeusTransformUtils.preCheckCast(r5, ak.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20533a, r6.f20533a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20534b, r6.f20534b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f20533a.hashCode() * 31) + this.f20534b.hashCode();
    }

    public String toString() {
        return "SkillFormAttachmentRestorePoint(snapshot=" + this.f20533a + ", baseline=" + this.f20534b + ')';
    }

    public ak(bb r2, bb r3) {
        d.h.b.o.e(r2, "snapshot");
        d.h.b.o.e(r3, "baseline");
        this.f20533a = r2;
        this.f20534b = r3;
    }

    public final bb a() {
        return this.f20533a;
    }

    public final bb b() {
        return this.f20534b;
    }
}
