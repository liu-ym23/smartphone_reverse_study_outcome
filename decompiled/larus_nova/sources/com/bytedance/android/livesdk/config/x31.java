package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/x31;", "", "", "giftRelayLoadingRes", "Ljava/lang/String;", "getGiftRelayLoadingRes", "()Ljava/lang/String;", "setGiftRelayLoadingRes", "(Ljava/lang/String;)V", "giftRelaySweepRes", "getGiftRelaySweepRes", "setGiftRelaySweepRes", "giftRelayDoublePrizeRes", "getGiftRelayDoublePrizeRes", "setGiftRelayDoublePrizeRes", "giftRelayFreezeRes", "getGiftRelayFreezeRes", "setGiftRelayFreezeRes", "giftRelayStarRes", "getGiftRelayStarRes", "setGiftRelayStarRes", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x31 {

    @SerializedName("gift_relay_double_prize_res")
    private String giftRelayDoublePrizeRes;

    @SerializedName("gift_relay_freeze_res")
    private String giftRelayFreezeRes;

    @SerializedName("gift_relay_loading_res")
    private String giftRelayLoadingRes;

    @SerializedName("gift_relay_star_res")
    private String giftRelayStarRes;

    @SerializedName("gift_relay_sweep_res")
    private String giftRelaySweepRes;

    public x31() {
        this.giftRelayLoadingRes = "";
        this.giftRelaySweepRes = "";
        this.giftRelayDoublePrizeRes = "";
        this.giftRelayFreezeRes = "";
        this.giftRelayStarRes = "";
    }
}
