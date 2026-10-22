package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("version")
    private final Integer f19896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("skill_md_content")
    private final String f19897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("usage_examples")
    private final List<String> f19898c;

    public fl() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fl.class) == true) goto L8;
        return false;
    L8:
        fl r6 = (fl) ZeusTransformUtils.preCheckCast(r5, fl.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19896a, r6.f19896a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19897b, r6.f19897b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19898c, r6.f19898c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f19896a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f19897b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.f19898c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillShopCurrentVersion(version=" + this.f19896a + ", skillMdContent=" + this.f19897b + ", usageExamples=" + this.f19898c + ')';
    }

    public fl(Integer r3, String r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f19896a = r3;
        this.f19897b = r4;
        this.f19898c = r6;
    }

    public /* synthetic */ fl(Integer r2, String r3, List r4, int r5, d.h.b.h r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r7 = null;
    L11:
        this(r2, r3, r7);
    }

    public final Integer a() {
        return this.f19896a;
    }

    public final String b() {
        return this.f19897b;
    }

    public final List<String> c() {
        return this.f19898c;
    }
}
