package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/x0;", "", "", "ruleKey", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "ruleValue", "Ljava/util/List;", "b", "()Ljava/util/List;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x0 {

    @SerializedName("rule_key")
    private final String ruleKey;

    @SerializedName("rule_value")
    private final List<String> ruleValue;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x0) == false) goto L10;
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.ruleKey, r101.ruleKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ruleValue, r101.ruleValue) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.ruleKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.ruleValue;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FilterRule(ruleKey=" + this.ruleKey + ", ruleValue=" + this.ruleValue + ")";
    }

    public x0() {
        this.ruleKey = null;
        this.ruleValue = null;
    }

    public final String a() {
        return this.ruleKey;
    }

    public final List<String> b() {
        return this.ruleValue;
    }
}
