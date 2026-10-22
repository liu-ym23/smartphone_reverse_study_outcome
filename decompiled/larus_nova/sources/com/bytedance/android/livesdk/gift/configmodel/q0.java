package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/q0;", "", "", "giftMarketingSchema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGiftMarketingSchema", "(Ljava/lang/String;)V", "giftMarketingMixSchema", "b", "setGiftMarketingMixSchema", "", "giftMarketingEnable", "Z", "getGiftMarketingEnable", "()Z", "setGiftMarketingEnable", "(Z)V", "giftMarketingMixEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGiftMarketingMixEnable", "updateExtraAfterDialogCloseEnable", "e", "setUpdateExtraAfterDialogCloseEnable", "", "updateExtraAfterDialogCloseDuration", "J", "d", "()J", "setUpdateExtraAfterDialogCloseDuration", "(J)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName("gift_marketing_enable")
    private boolean giftMarketingEnable;

    @SerializedName("gift_marketing_mix_enable")
    private boolean giftMarketingMixEnable;

    @SerializedName("gift_marketing_mix_schema")
    private String giftMarketingMixSchema;

    @SerializedName("gift_marketing_schema")
    private String giftMarketingSchema;

    @SerializedName("update_extra_after_dialog_close_duration")
    private long updateExtraAfterDialogCloseDuration;

    @SerializedName("update_extra_after_dialog_close_enable")
    private boolean updateExtraAfterDialogCloseEnable;

    public q0() {
        this.giftMarketingSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fgift_marketing%2Ftemplate.js";
        this.giftMarketingMixSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fgift_marketing_mix%2Ftemplate.js";
        this.updateExtraAfterDialogCloseDuration = 5000;
    }

    public final boolean a() {
        return this.giftMarketingMixEnable;
    }

    public final String b() {
        return this.giftMarketingMixSchema;
    }

    public final String c() {
        return this.giftMarketingSchema;
    }

    public final long d() {
        return this.updateExtraAfterDialogCloseDuration;
    }

    public final boolean e() {
        return this.updateExtraAfterDialogCloseEnable;
    }
}
