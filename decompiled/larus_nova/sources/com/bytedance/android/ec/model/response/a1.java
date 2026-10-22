package com.bytedance.android.ec.model.response;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/android/ec/model/response/a1;", "", "Lcom/bytedance/android/ec/model/response/BottomBannerType;", "bottomBannerType", "Lcom/bytedance/android/ec/model/response/BottomBannerType;", "b", "()Lcom/bytedance/android/ec/model/response/BottomBannerType;", "setBottomBannerType", "(Lcom/bytedance/android/ec/model/response/BottomBannerType;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "leftIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setLeftIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "text", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "rightIcon", "e", "setRightIcon", "", "priority", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "setPriority", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/ec/model/response/j0;", "action", "Lcom/bytedance/android/ec/model/response/j0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/j0;", "setAction", "(Lcom/bytedance/android/ec/model/response/j0;)V", "Lcom/bytedance/android/ec/model/response/s1;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/ec/model/response/s1;", ce.f26391f, "()Lcom/bytedance/android/ec/model/response/s1;", "setTrack", "(Lcom/bytedance/android/ec/model/response/s1;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a1 {

    @SerializedName("action")
    private j0 action;

    @SerializedName("banner_type")
    private BottomBannerType bottomBannerType;

    @SerializedName("left_icon")
    private ECUrlModel leftIcon;

    @SerializedName("priority")
    private Long priority;

    @SerializedName("right_icon")
    private ECUrlModel rightIcon;

    @SerializedName("text")
    private String text;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private s1 track;

    public a1() {
    }

    public final j0 a() {
        return this.action;
    }

    public final BottomBannerType b() {
        return this.bottomBannerType;
    }

    public final ECUrlModel c() {
        return this.leftIcon;
    }

    public final Long d() {
        return this.priority;
    }

    public final ECUrlModel e() {
        return this.rightIcon;
    }

    public final String f() {
        return this.text;
    }

    public final s1 g() {
        return this.track;
    }
}
