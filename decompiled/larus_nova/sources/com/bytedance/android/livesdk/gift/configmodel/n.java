package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.android.livesdk.utils.r3;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/n;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "maxTimes", "I", "c", "()I", "setMaxTimes", "(I)V", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "alertTitleText", "getAlertTitleText", "setAlertTitleText", "alertDesText", "getAlertDesText", "setAlertDesText", "alertMaxTimes", "getAlertMaxTimes", "setAlertMaxTimes", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("alert_des_text")
    private String alertDesText;

    @SerializedName("alert_max_times")
    private int alertMaxTimes;

    @SerializedName("alert_title_text")
    private String alertTitleText;

    @SerializedName("notice_text")
    private String content;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("max_show_times")
    private int maxTimes;

    public n() {
        this.maxTimes = 6;
        this.content = "抖币即日起更名为\"" + r3.c() + Typography.quote;
        this.alertTitleText = "1月7日起\"抖币\"更名为\"钻石\"";
        this.alertDesText = "感谢您一直以来对抖音直播的关心与支持，1月7日起将原\"抖币\"正式更名为\"抖音钻石\"，相关功能与权益和抖币完全一致";
        this.alertMaxTimes = 3;
    }

    public final String a() {
        return this.content;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.maxTimes;
    }
}
