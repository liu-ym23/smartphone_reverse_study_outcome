package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesTextConfigStruct;", "Ljava/io/Serializable;", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textBgColor", "getTextBgColor", "setTextBgColor", "textBorderColor", "getTextBorderColor", "setTextBorderColor", "textColor", "getTextColor", "setTextColor", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductPrivilegesTextConfigStruct implements Serializable {

    @SerializedName("text")
    private String text;

    @SerializedName("text_bg_color")
    private String textBgColor;

    @SerializedName("text_border_color")
    private String textBorderColor;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("weight")
    private int weight;

    public PromotionProductPrivilegesTextConfigStruct() {
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextBgColor() {
        return this.textBgColor;
    }

    public final String getTextBorderColor() {
        return this.textBorderColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextBgColor(String r100) {
        this.textBgColor = r100;
    }

    public final void setTextBorderColor(String r100) {
        this.textBorderColor = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public final void setWeight(int r100) {
        this.weight = r100;
    }
}
