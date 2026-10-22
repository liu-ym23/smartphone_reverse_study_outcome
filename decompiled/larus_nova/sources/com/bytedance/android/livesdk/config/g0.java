package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/g0;", "", "", "switchSubTitleOpen", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setSwitchSubTitleOpen", "(Ljava/lang/String;)V", "managerEntranceTitle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setManagerEntranceTitle", "switchSubTitleClose", "b", "setSwitchSubTitleClose", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("manager_entrance_title")
    private String managerEntranceTitle;

    @SerializedName("switch_sub_title_close")
    private String switchSubTitleClose;

    @SerializedName("switch_sub_title_open")
    private String switchSubTitleOpen;

    public g0() {
        this.switchSubTitleOpen = "开启后每场直播均生效，可得观众收入20%分成";
        this.managerEntranceTitle = "管理快捷收礼观众名单";
        this.switchSubTitleClose = "关闭后观众无法收礼，每场直播均生效";
    }

    public final String a() {
        return this.managerEntranceTitle;
    }

    public final String b() {
        return this.switchSubTitleClose;
    }

    public final String c() {
        return this.switchSubTitleOpen;
    }
}
