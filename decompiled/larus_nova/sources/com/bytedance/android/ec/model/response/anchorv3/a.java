package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/a;", "", "", "textPrefix", "Ljava/lang/String;", "getTextPrefix", "()Ljava/lang/String;", "setTextPrefix", "(Ljava/lang/String;)V", SocialConstants.PARAM_APP_DESC, "c", "f", "textSuffix", "getTextSuffix", "setTextSuffix", "couponId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "d", "couponType", "b", "e", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("coupon_id")
    private String couponId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE)
    private String couponType;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("text_prefix")
    private String textPrefix;

    @SerializedName("text_suffix")
    private String textSuffix;

    public a() {
    }

    public final String a() {
        return this.couponId;
    }

    public final String b() {
        return this.couponType;
    }

    public final String c() {
        return this.desc;
    }

    public final void d(String r100) {
        this.couponId = r100;
    }

    public final void e(String r100) {
        this.couponType = r100;
    }

    public final void f(String r100) {
        this.desc = r100;
    }
}
