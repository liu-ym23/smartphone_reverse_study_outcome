package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/w0;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "liveStatusErrorViewLoadWay", "I", "getLiveStatusErrorViewLoadWay", "()I", "", "portraitBgImage", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "horizontalBgImage", "b", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("horizontal_bg_image")
    private final String horizontalBgImage;

    @SerializedName("live_status_error_view_load_way")
    private final int liveStatusErrorViewLoadWay;

    @SerializedName("portrait_bg_image")
    private final String portraitBgImage;

    public w0() {
        this(0);
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.horizontalBgImage;
    }

    public final String c() {
        return this.portraitBgImage;
    }

    public w0(int r100) {
        this.enable = false;
        this.liveStatusErrorViewLoadWay = 0;
        this.portraitBgImage = "";
        this.horizontalBgImage = "";
    }
}
