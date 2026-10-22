package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/c0;", "", "", "enable", "Z", "d", "()Z", "", "introduceTitle", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "introduceDesc", "e", "alertTitle", "c", "alertDesc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "alertDescForAnchor", "b", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("alert_desc")
    private final String alertDesc;

    @SerializedName("alert_desc_for_anchor")
    private final String alertDescForAnchor;

    @SerializedName("alert_title")
    private final String alertTitle;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("introduce_desc")
    private final String introduceDesc;

    @SerializedName("introduce_title")
    private final String introduceTitle;

    public c0() {
        this.enable = true;
        this.introduceTitle = "礼物声音/震动说明";
        this.introduceDesc = "部分礼物特效会有声音/震动效果，关闭后，所有礼物均会静音并关闭震动";
        this.alertTitle = "关闭礼物声音/震动";
        this.alertDesc = "关闭后所有人（包括自己）送出的礼物均会静音并关闭震动。是否确认关闭？";
        this.alertDescForAnchor = "关闭后，观众送出的礼物均会静音并关闭震动，是否确认关闭？";
    }

    public final String a() {
        return this.alertDesc;
    }

    public final String b() {
        return this.alertDescForAnchor;
    }

    public final String c() {
        return this.alertTitle;
    }

    public final boolean d() {
        return this.enable;
    }

    public final String e() {
        return this.introduceDesc;
    }

    public final String f() {
        return this.introduceTitle;
    }
}
