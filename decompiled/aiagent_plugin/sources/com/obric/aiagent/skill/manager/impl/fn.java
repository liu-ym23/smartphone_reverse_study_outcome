package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("download_url")
    private final String f19904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("version")
    private final Integer f19905b;

    /* JADX WARN: Multi-variable type inference failed */
    public fn() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fn.class) == true) goto L8;
        return false;
    L8:
        fn r6 = (fn) ZeusTransformUtils.preCheckCast(r5, fn.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19904a, r6.f19904a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19905b, r6.f19905b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f19904a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f19905b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillShopDownloadData(downloadUrl=" + this.f19904a + ", version=" + this.f19905b + ')';
    }

    public fn(String r1, Integer r2) {
        this.f19904a = r1;
        this.f19905b = r2;
    }

    public /* synthetic */ fn(String r2, Integer r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String a() {
        return this.f19904a;
    }

    public final Integer b() {
        return this.f19905b;
    }
}
