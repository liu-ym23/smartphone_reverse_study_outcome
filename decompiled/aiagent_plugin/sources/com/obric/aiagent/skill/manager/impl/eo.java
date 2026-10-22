package com.obric.aiagent.skill.manager.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ep f19830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19832d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, eo.class) == true) goto L8;
        return false;
    L8:
        eo r6 = (eo) ZeusTransformUtils.preCheckCast(r5, eo.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19829a, r6.f19829a) == true) goto L12;
        return false;
    L12:
        if (this.f19830b == r6.f19830b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19831c, r6.f19831c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19832d, r6.f19832d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f19829a.hashCode() * 31) + this.f19830b.hashCode()) * 31) + this.f19831c.hashCode()) * 31) + this.f19832d.hashCode();
    }

    public String toString() {
        return "SkillSecurityScanTrackingContext(taskId=" + this.f19829a + ", triggerType=" + this.f19830b + ", skillId=" + this.f19831c + ", skillName=" + this.f19832d + ')';
    }

    public eo(String r2, ep r3, String r4, String r5) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        d.h.b.o.e(r3, "triggerType");
        d.h.b.o.e(r4, "skillId");
        d.h.b.o.e(r5, "skillName");
        this.f19829a = r2;
        this.f19830b = r3;
        this.f19831c = r4;
        this.f19832d = r5;
    }

    public final String a() {
        return this.f19829a;
    }

    public final ep b() {
        return this.f19830b;
    }

    public final String c() {
        return this.f19831c;
    }

    public final String d() {
        return this.f19832d;
    }
}
