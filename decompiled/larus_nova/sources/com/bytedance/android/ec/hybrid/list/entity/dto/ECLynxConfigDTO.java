package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R:\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECLynxConfigDTO;", "Ljava/io/Serializable;", "", "lynxSchema", "Ljava/lang/String;", "getLynxSchema", "()Ljava/lang/String;", "setLynxSchema", "(Ljava/lang/String;)V", "", "predictHeight", "D", "getPredictHeight", "()D", "setPredictHeight", "(D)V", "fixedHeight", "getFixedHeight", "setFixedHeight", "", "formModifiable", "Z", "getFormModifiable", "()Z", "setFormModifiable", "(Z)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extra", "Ljava/util/HashMap;", "getExtra", "()Ljava/util/HashMap;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLynxConfigDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("extra")
    private final HashMap<String, String> extra;

    @SerializedName("fixed_height")
    private double fixedHeight;

    @SerializedName("form_modifiable")
    private boolean formModifiable;

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

    public ECLynxConfigDTO() {
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final double getFixedHeight() {
        return this.fixedHeight;
    }

    public final boolean getFormModifiable() {
        return this.formModifiable;
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

    public final void setFormModifiable(boolean r100) {
        this.formModifiable = r100;
    }

    public final void setLynxSchema(String r100) {
        this.lynxSchema = r100;
    }

    public final void setPredictHeight(double r100) {
        this.predictHeight = r100;
    }
}
