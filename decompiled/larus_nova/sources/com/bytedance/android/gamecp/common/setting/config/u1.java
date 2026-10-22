package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/u1;", "", "", "explainCardEnable", "I", "getExplainCardEnable", "()I", "toolbarEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u1 {

    @SerializedName("explain_enable")
    private final int explainCardEnable;

    @SerializedName("toolbar_enable")
    private final int toolbarEnable;

    public u1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u1) == false) goto L10;
        u1 r101 = (u1) r100;
        if (this.explainCardEnable == r101.explainCardEnable) goto L8;
        return false;
    L8:
        if (this.toolbarEnable == r101.toolbarEnable) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.explainCardEnable * 31) + this.toolbarEnable;
    }

    public final String toString() {
        return "GamePromoteMiniEntranceConfig(explainCardEnable=" + this.explainCardEnable + ", toolbarEnable=" + this.toolbarEnable + ")";
    }

    public final int a() {
        return this.toolbarEnable;
    }

    public u1(int r100) {
        this.explainCardEnable = 1;
        this.toolbarEnable = 1;
    }
}
