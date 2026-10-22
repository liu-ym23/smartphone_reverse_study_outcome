package com.bytedance.android.ec.hybrid.api.card.mita;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/hybrid/api/card/mita/ECHybridMitaCardConfig;", "Ljava/io/Serializable;", "", "", "clone", "", "cardName", "Ljava/lang/String;", "getCardName", "()Ljava/lang/String;", "setCardName", "(Ljava/lang/String;)V", "templateUrl", "getTemplateUrl", "setTemplateUrl", "runtimeSchema", "getRuntimeSchema", "setRuntimeSchema", "", "predictHeight", "I", "getPredictHeight", "()I", "setPredictHeight", "(I)V", "", "bindAvoidLayoutProcess", "Z", "getBindAvoidLayoutProcess", "()Z", "setBindAvoidLayoutProcess", "(Z)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECHybridMitaCardConfig implements Serializable, Cloneable {
    public static final a Companion = null;
    public static final String KEY_CONFIG = "mita_card_config";

    @SerializedName("bind_avoid_layout_process")
    private boolean bindAvoidLayoutProcess;

    @SerializedName("card_name")
    private String cardName;

    @SerializedName("predict_height")
    private int predictHeight;

    @SerializedName("runtime_schema")
    private String runtimeSchema;

    @SerializedName("template_url")
    private String templateUrl;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECHybridMitaCardConfig() {
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean getBindAvoidLayoutProcess() {
        return this.bindAvoidLayoutProcess;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final int getPredictHeight() {
        return this.predictHeight;
    }

    public final String getRuntimeSchema() {
        return this.runtimeSchema;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final void setBindAvoidLayoutProcess(boolean r100) {
        this.bindAvoidLayoutProcess = r100;
    }

    public final void setCardName(String r100) {
        this.cardName = r100;
    }

    public final void setPredictHeight(int r100) {
        this.predictHeight = r100;
    }

    public final void setRuntimeSchema(String r100) {
        this.runtimeSchema = r100;
    }

    public final void setTemplateUrl(String r100) {
        this.templateUrl = r100;
    }
}
