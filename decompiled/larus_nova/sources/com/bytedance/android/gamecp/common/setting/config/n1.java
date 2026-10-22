package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/n1;", "", "", "explainCardEnable", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "toolbarEnable", "b", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n1 {

    @SerializedName("explain_enable")
    private final int explainCardEnable;

    @SerializedName("toolbar_enable")
    private final int toolbarEnable;

    public n1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n1) == false) goto L10;
        n1 r101 = (n1) r100;
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
        return "GamePromoteConfig(explainCardEnable=" + this.explainCardEnable + ", toolbarEnable=" + this.toolbarEnable + ")";
    }

    public final int a() {
        return this.explainCardEnable;
    }

    public final int b() {
        return this.toolbarEnable;
    }

    public n1(int r100) {
        this.explainCardEnable = 0;
        this.toolbarEnable = 0;
    }
}
