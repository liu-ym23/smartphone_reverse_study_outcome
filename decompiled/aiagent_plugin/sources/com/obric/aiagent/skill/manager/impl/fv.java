package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fv<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(MonitorConstants.CODE)
    private final int f19924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("msg")
    private final String f19925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("data")
    private final T f19926c;

    public fv() {
        this(0, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fv.class) == true) goto L8;
        return false;
    L8:
        fv r6 = (fv) ZeusTransformUtils.preCheckCast(r5, fv.class, "com.obric.aiagent.plugin");
        if (this.f19924a == r6.f19924a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19925b, r6.f19925b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19926c, r6.f19926c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f19924a) * 31;
        String r1 = this.f19925b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        T r5 = this.f19926c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillShopResponse(code=" + this.f19924a + ", msg=" + this.f19925b + ", data=" + this.f19926c + ')';
    }

    public fv(int r1, String r2, T r3) {
        this.f19924a = r1;
        this.f19925b = r2;
        this.f19926c = r3;
    }

    public /* synthetic */ fv(int r2, String r3, Object r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final int a() {
        return this.f19924a;
    }

    public final String b() {
        return this.f19925b;
    }

    public final T c() {
        return this.f19926c;
    }
}
