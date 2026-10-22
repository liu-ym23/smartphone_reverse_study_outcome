package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/model/b0;", "", "", "firstLevelTabValue", "I", "getFirstLevelTabValue", "()I", "tabMode", "getTabMode", "Lcom/bytedance/android/live/ktv/common/model/api/m;", "response", "Lcom/bytedance/android/live/ktv/common/model/api/m;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/ktv/common/model/api/m;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b0 {

    @SerializedName("first_level_tab_value")
    private final int firstLevelTabValue;

    @SerializedName("response")
    private final com.bytedance.android.live.ktv.common.model.api.m response;

    @SerializedName("tab_mode")
    private final int tabMode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L12;
        b0 r101 = (b0) r100;
        if (this.firstLevelTabValue == r101.firstLevelTabValue) goto L8;
        return false;
    L8:
        if (this.tabMode == r101.tabMode) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.response, r101.response) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.firstLevelTabValue * 31) + this.tabMode) * 31;
        com.bytedance.android.live.ktv.common.model.api.m r101 = this.response;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "TabListData(firstLevelTabValue=" + this.firstLevelTabValue + ", tabMode=" + this.tabMode + ", response=" + this.response + ")";
    }

    public final com.bytedance.android.live.ktv.common.model.api.m a() {
        return this.response;
    }

    public b0(int r100, int r101, com.bytedance.android.live.ktv.common.model.api.m r102) {
        Intrinsics.checkNotNullParameter(r102, "response");
        this.firstLevelTabValue = r100;
        this.tabMode = r101;
        this.response = r102;
    }
}
