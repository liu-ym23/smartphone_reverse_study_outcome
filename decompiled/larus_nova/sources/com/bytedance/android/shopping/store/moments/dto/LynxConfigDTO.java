package com.bytedance.android.shopping.store.moments.dto;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000e\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/dto/LynxConfigDTO;", "Ljava/io/Serializable;", "", "lynxSchema", "Ljava/lang/String;", "getLynxSchema", "()Ljava/lang/String;", "setLynxSchema", "(Ljava/lang/String;)V", "", "predictHeight", "D", "getPredictHeight", "()D", "setPredictHeight", "(D)V", "fixedHeight", "getFixedHeight", "setFixedHeight", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxConfigDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("fixed_height")
    private double fixedHeight;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private String lynxSchema;

    @SerializedName("predict_height")
    private double predictHeight;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LynxConfigDTO() {
    }

    public final double getFixedHeight() {
        return this.fixedHeight;
    }

    public final String getLynxSchema() {
        return this.lynxSchema;
    }

    public final double getPredictHeight() {
        return this.predictHeight;
    }

    public final void setFixedHeight(double r100) {
        this.fixedHeight = r100;
    }

    public final void setLynxSchema(String r100) {
        this.lynxSchema = r100;
    }

    public final void setPredictHeight(double r100) {
        this.predictHeight = r100;
    }
}
