package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/d11;", "", "", "huaweiOrHonor", "Ljava/lang/String;", "getHuaweiOrHonor", "()Ljava/lang/String;", "setHuaweiOrHonor", "(Ljava/lang/String;)V", DimLocationCheckUtil.VIVO, "getVivo", "setVivo", AppConstants.CHANNEL_OPPO, "getOppo", "setOppo", DimLocationCheckUtil.XIAOMI, "getXiaomi", "setXiaomi", "others", "getOthers", "setOthers", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d11 {

    @SerializedName("huawei_or_honor")
    private String huaweiOrHonor;

    @SerializedName(AppConstants.CHANNEL_OPPO)
    private String oppo;

    @SerializedName("others")
    private String others;

    @SerializedName(DimLocationCheckUtil.VIVO)
    private String vivo;

    @SerializedName(DimLocationCheckUtil.XIAOMI)
    private String xiaomi;

    public d11() {
        this.huaweiOrHonor = "https://lf3-static.bytednsdoc.com/obj/eden-cn/4186eh7pxhpqnuhog/live-android/ttlive_accecssibility_guide_douyin_huawei_honor.png";
        this.vivo = "https://lf3-static.bytednsdoc.com/obj/eden-cn/4186eh7pxhpqnuhog/live-android/ttlive_accecssibility_guide_douyin_vivo.png";
        this.oppo = "https://lf3-static.bytednsdoc.com/obj/eden-cn/4186eh7pxhpqnuhog/live-android/ttlive_accecssibility_guide_douyin_oppo.png";
        this.xiaomi = "https://lf3-static.bytednsdoc.com/obj/eden-cn/4186eh7pxhpqnuhog/live-android/ttlive_accecssibility_guide_douyin_xiaomi.png";
        this.others = "https://lf3-static.bytednsdoc.com/obj/eden-cn/4186eh7pxhpqnuhog/live-android/ttlive_accecssibility_guide_douyin_others.png";
    }
}
