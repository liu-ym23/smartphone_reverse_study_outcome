package com.obric.aiagent.authentication.license;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LicenseExecutePolicyInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LicenseExecutePolicyInfo {
    private final String settingKey;
    private final int type;

    public static /* synthetic */ LicenseExecutePolicyInfo copy$default(LicenseExecutePolicyInfo r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.settingKey;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.settingKey;
    }

    public final LicenseExecutePolicyInfo copy(int r1, String r2) {
        return new LicenseExecutePolicyInfo(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LicenseExecutePolicyInfo.class) == true) goto L8;
        return false;
    L8:
        LicenseExecutePolicyInfo r6 = (LicenseExecutePolicyInfo) ZeusTransformUtils.preCheckCast(r5, LicenseExecutePolicyInfo.class, "com.obric.aiagent.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (o.a(this.settingKey, r6.settingKey) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.type) * 31;
        String r1 = this.settingKey;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "LicenseExecutePolicyInfo(type=" + this.type + ", settingKey=" + this.settingKey + ')';
    }

    public LicenseExecutePolicyInfo(int r1, String r2) {
        this.type = r1;
        this.settingKey = r2;
    }

    public final int getType() {
        return this.type;
    }

    public final String getSettingKey() {
        return this.settingKey;
    }
}
