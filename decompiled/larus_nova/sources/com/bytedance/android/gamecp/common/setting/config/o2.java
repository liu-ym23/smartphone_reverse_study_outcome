package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/o2;", "", "", "canUseInstalledLayout", "Z", "getCanUseInstalledLayout", "()Z", "setCanUseInstalledLayout", "(Z)V", "propUrlSwitch", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setPropUrlSwitch", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o2 {

    @SerializedName("can_use_installed_layout")
    private boolean canUseInstalledLayout;

    @SerializedName("prop_ppe_url_switch")
    private boolean propUrlSwitch;

    public o2() {
        this.canUseInstalledLayout = true;
    }

    public final boolean a() {
        return this.propUrlSwitch;
    }
}
