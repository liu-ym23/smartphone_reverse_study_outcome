package com.obric.aiagent.skill.manager.impl;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.skill.manager.api.aq;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManager.kt */
/* JADX INFO: loaded from: classes3.dex */
final class cm<S extends com.obric.aiagent.skill.manager.api.aq> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final S f19680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.q f19681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19682c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, cm.class) == true) goto L8;
        return false;
    L8:
        cm r6 = (cm) ZeusTransformUtils.preCheckCast(r5, cm.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19680a, r6.f19680a) == true) goto L12;
        return false;
    L12:
        if (this.f19681b == r6.f19681b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19682c, r6.f19682c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f19680a.hashCode() * 31) + this.f19681b.hashCode()) * 31;
        String r2 = this.f19682c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillInstallTrackingEntry(source=" + this.f19680a + ", installMethod=" + this.f19681b + ", skillSourceUrl=" + this.f19682c + ')';
    }

    public cm(S r3, com.obric.aiagent.skill.manager.api.q r4, String r5) {
        S r6 = (S) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "installMethod");
        this.f19680a = r6;
        this.f19681b = r4;
        this.f19682c = r5;
    }

    public /* synthetic */ cm(com.obric.aiagent.skill.manager.api.aq r2, com.obric.aiagent.skill.manager.api.q r3, String r4, int r5, d.h.b.h r6) {
        com.obric.aiagent.skill.manager.api.aq r7 = (com.obric.aiagent.skill.manager.api.aq) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.manager.api.aq.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        this(r7, r3, r4);
    }

    public final S a() {
        return this.f19680a;
    }

    public final com.obric.aiagent.skill.manager.api.q b() {
        return this.f19681b;
    }

    public final String c() {
        return this.f19682c;
    }

    public final ep d() {
        return cy.b(this.f19681b);
    }
}
