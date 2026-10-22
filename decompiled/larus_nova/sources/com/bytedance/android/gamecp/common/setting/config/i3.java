package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/i3;", "", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "frequency", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i3 {

    @SerializedName("frequency")
    private final Integer frequency;

    @SerializedName("url")
    private final String url;

    public i3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i3) == false) goto L10;
        i3 r101 = (i3) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.frequency, r101.frequency) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.frequency;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UserAccountTransferConfig(url=" + this.url + ", frequency=" + this.frequency + ")";
    }

    public final Integer a() {
        return this.frequency;
    }

    public final String b() {
        return this.url;
    }

    public i3(int r100) {
        this.url = "sslocal://webcast_lynxview?trans_status_bar=1&disable_url_handle=1&enable_latch=1&web_bg_color=%23FFFFFF&hide_nav_bar=1&type=popup&height_percent=73&width_percent=100&gravity=bottom&mask_alpha=0.3&pull_down_close=1&add_safe_area_height=0&pull_down_indicator_not_show=1&top_level=1&business_type=gamecp_group&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fgame_priority_normal_lynx_douyin%2Fpages%2Fmigration_asset_notification%2Ftemplate.js";
        this.frequency = 3;
    }
}
