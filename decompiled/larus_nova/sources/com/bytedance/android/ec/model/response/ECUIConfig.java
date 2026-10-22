package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECUIConfig;", "Ljava/io/Serializable;", "()V", "cornerRadius", "", "getCornerRadius", "()Z", "textBgColor", "", "getTextBgColor", "()Ljava/lang/String;", "textBorderColor", "getTextBorderColor", "textColor", "getTextColor", "textSize", "", "getTextSize", "()I", "textSplitorColor", "getTextSplitorColor", "textSplitorStyle", "getTextSplitorStyle", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECUIConfig implements Serializable {

    @SerializedName("corner_radius")
    private final boolean cornerRadius;

    @SerializedName("text_bg_color")
    private final String textBgColor;

    @SerializedName("text_border_color")
    private final String textBorderColor;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("text_size")
    private final int textSize;

    @SerializedName("text_splitor_color")
    private final String textSplitorColor;

    @SerializedName("text_splitor_style")
    private final int textSplitorStyle;

    public ECUIConfig() {
    }

    public final boolean getCornerRadius() {
        return this.cornerRadius;
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

    public final int getTextSize() {
        return this.textSize;
    }

    public final String getTextSplitorColor() {
        return this.textSplitorColor;
    }

    public final int getTextSplitorStyle() {
        return this.textSplitorStyle;
    }
}
