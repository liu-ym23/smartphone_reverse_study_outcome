package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("disallowed_skill_slugs")
    private final List<String> f19574a;

    /* JADX WARN: Multi-variable type inference failed */
    public bm() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bm.class) == true) goto L8;
        return false;
    L8:
        bm r6 = (bm) ZeusTransformUtils.preCheckCast(r5, bm.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19574a, r6.f19574a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.f19574a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SkillExistencePolicyData(disallowedSkillSlugs=" + this.f19574a + ')';
    }

    public bm(List<String> r3) {
        this.f19574a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ bm(List r2, int r3, d.h.b.h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    public final List<String> a() {
        return this.f19574a;
    }
}
