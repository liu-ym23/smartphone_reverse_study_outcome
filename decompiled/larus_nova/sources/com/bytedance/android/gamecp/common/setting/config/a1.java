package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/a1;", "", "", "", "Lcom/bytedance/android/gamecp/common/setting/config/x0;", "filterRulesMap", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "Lcom/bytedance/android/gamecp/common/setting/config/w0;", "filterConfigMap", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a1 {

    @SerializedName("filter_config")
    private final Map<String, w0> filterConfigMap;

    @SerializedName("filter_rules")
    private final Map<String, x0> filterRulesMap;

    public a1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a1) == false) goto L10;
        a1 r101 = (a1) r100;
        if (Intrinsics.areEqual(this.filterRulesMap, r101.filterRulesMap) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.filterConfigMap, r101.filterConfigMap) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<String, x0> r100 = this.filterRulesMap;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, w0> r104 = this.filterConfigMap;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameCPSettingFilterConfig(filterRulesMap=" + this.filterRulesMap + ", filterConfigMap=" + this.filterConfigMap + ")";
    }

    public final Map<String, w0> a() {
        return this.filterConfigMap;
    }

    public final Map<String, x0> b() {
        return this.filterRulesMap;
    }

    public a1(Object r100) {
        this.filterRulesMap = null;
        this.filterConfigMap = null;
    }
}
