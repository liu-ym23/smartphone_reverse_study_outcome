package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/u31;", "", "", "settingEntranceUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setSettingEntranceUrl", "(Ljava/lang/String;)V", "selectGuestListEntrance", "getSelectGuestListEntrance", "setSelectGuestListEntrance", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u31 {

    @SerializedName("select_guest_list_entrance")
    private String selectGuestListEntrance;

    @SerializedName("setting_entrance")
    private String settingEntranceUrl;

    public u31() {
        this.settingEntranceUrl = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_receive_gift_lynx_douyin%2Fpages%2Faudience_list%2Ftemplate.js%3Fweb_bg_color%3Dff161616%26show_source%3Dclick&type=popup&gravity=bottom&height=484";
        this.selectGuestListEntrance = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_receive_gift_lynx_douyin%2Fpages%2Faudience_list%2Ftemplate.js%3Fweb_bg_color%3Dff161616%26show_source%3Dprofile_card&type=popup&gravity=bottom&height=484";
    }

    public final String a() {
        return this.settingEntranceUrl;
    }
}
