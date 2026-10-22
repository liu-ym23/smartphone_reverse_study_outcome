package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/w0;", "", "", "", "rules", "Ljava/util/List;", "b", "()Ljava/util/List;", FilterData.FilterSheetItem.Id.FILTER_VALUE, "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName("filter_value")
    private final Object filterValue;

    @SerializedName("rules")
    private final List<List<String>> rules;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w0) == false) goto L10;
        w0 r101 = (w0) r100;
        if (Intrinsics.areEqual(this.rules, r101.rules) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.filterValue, r101.filterValue) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<List<String>> r100 = this.rules;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.filterValue;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FilterConfig(rules=" + this.rules + ", filterValue=" + this.filterValue + ")";
    }

    public w0() {
        this.rules = null;
        this.filterValue = null;
    }

    public final Object a() {
        return this.filterValue;
    }

    public final List<List<String>> b() {
        return this.rules;
    }
}
