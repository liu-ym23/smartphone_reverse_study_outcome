package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEgressModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SensitiveCategoryInfo {
    private final String categoryDesc;
    private final String sensitiveCategory;

    public static /* synthetic */ SensitiveCategoryInfo copy$default(SensitiveCategoryInfo r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.sensitiveCategory;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.categoryDesc;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.sensitiveCategory;
    }

    public final String component2() {
        return this.categoryDesc;
    }

    public final SensitiveCategoryInfo copy(String r1, String r2) {
        o.e(r1, "sensitiveCategory");
        return new SensitiveCategoryInfo(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SensitiveCategoryInfo.class) == true) goto L8;
        return false;
    L8:
        SensitiveCategoryInfo r6 = (SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r5, SensitiveCategoryInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.sensitiveCategory, r6.sensitiveCategory) == true) goto L12;
        return false;
    L12:
        if (o.a(this.categoryDesc, r6.categoryDesc) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.sensitiveCategory.hashCode() * 31;
        String r1 = this.categoryDesc;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SensitiveCategoryInfo(sensitiveCategory=" + this.sensitiveCategory + ", categoryDesc=" + this.categoryDesc + ')';
    }

    public SensitiveCategoryInfo(String r2, String r3) {
        o.e(r2, "sensitiveCategory");
        this.sensitiveCategory = r2;
        this.categoryDesc = r3;
    }

    public final String getSensitiveCategory() {
        return this.sensitiveCategory;
    }

    public final String getCategoryDesc() {
        return this.categoryDesc;
    }
}
