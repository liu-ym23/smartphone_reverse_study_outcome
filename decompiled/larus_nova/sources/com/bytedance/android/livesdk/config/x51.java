package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/x51;", "", "", "wirelineUrl", "Ljava/lang/String;", "getWirelineUrl", "()Ljava/lang/String;", "setWirelineUrl", "(Ljava/lang/String;)V", "wirelessUrl", "getWirelessUrl", "setWirelessUrl", "newWirelineUrl", "getNewWirelineUrl", "setNewWirelineUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x51 {

    @SerializedName("newWirelineUrl")
    private String newWirelineUrl;

    @SerializedName("wirelessUrl")
    private String wirelessUrl;

    @SerializedName("wirelineUrl")
    private String wirelineUrl;

    public x51() {
        this.wirelineUrl = "sslocal://webcast_webview?type=popup&gravity=bottom&height=484&hide_nav_bar=1&hide_status_bar=1&url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fmirror_guide%2Findex.html%3Fos_type%3DAndroid%26mirror_type%3Dwireline";
        this.wirelessUrl = "https://webcast.amemv.com/falcon/webcast_douyin/page/mirror_guide/index.html?os_type=Android&mirror_type=wireless";
        this.newWirelineUrl = "sslocal://webcast_webview?type=popup&gravity=bottom&height=484&hide_nav_bar=1&hide_status_bar=1&url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fmirror_guide%2Findex.html%3Fos_type%3DAndroid%26mirror_type%3Dall%26show_confirm_button%3D1";
    }
}
