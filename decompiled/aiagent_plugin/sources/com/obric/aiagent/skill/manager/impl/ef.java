package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("scan_id")
    private final String f19809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("scan_status")
    private final String f19810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("risk_score")
    private final Integer f19811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("decision_action")
    private final String f19812d;

    public ef() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ef.class) == true) goto L8;
        return false;
    L8:
        ef r6 = (ef) ZeusTransformUtils.preCheckCast(r5, ef.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19809a, r6.f19809a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19810b, r6.f19810b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19811c, r6.f19811c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19812d, r6.f19812d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f19809a.hashCode() * 31) + this.f19810b.hashCode()) * 31;
        Integer r1 = this.f19811c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f19812d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillScanDecisionData(scanId=" + this.f19809a + ", scanStatus=" + this.f19810b + ", riskScore=" + this.f19811c + ", decisionAction=" + this.f19812d + ')';
    }

    public ef(String r2, String r3, Integer r4, String r5) {
        d.h.b.o.e(r2, "scanId");
        d.h.b.o.e(r3, "scanStatus");
        this.f19809a = r2;
        this.f19810b = r3;
        this.f19811c = r4;
        this.f19812d = r5;
    }

    public /* synthetic */ ef(String r2, String r3, Integer r4, String r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String a() {
        return this.f19809a;
    }

    public final String b() {
        return this.f19810b;
    }

    public final Integer c() {
        return this.f19811c;
    }

    public final String d() {
        return this.f19812d;
    }
}
