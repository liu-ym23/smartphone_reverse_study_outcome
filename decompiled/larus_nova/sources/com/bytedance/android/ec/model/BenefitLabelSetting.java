package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/BenefitLabelSetting;", "Ljava/io/Serializable;", "()V", "colorStyleMap", "", "", "Lcom/bytedance/android/ec/model/ColorPattern;", "getColorStyleMap", "()Ljava/util/Map;", "divLineMap", "Lcom/bytedance/android/ec/model/DivLinePattern;", "getDivLineMap", "textStyleMap", "Lcom/bytedance/android/ec/model/TextPattern;", "getTextStyleMap", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BenefitLabelSetting implements Serializable {

    @SerializedName("color_style")
    private final Map<Integer, ColorPattern> colorStyleMap;

    @SerializedName("div_line")
    private final Map<Integer, DivLinePattern> divLineMap;

    @SerializedName("text_style")
    private final Map<Integer, TextPattern> textStyleMap;

    public BenefitLabelSetting() {
    }

    public final Map<Integer, ColorPattern> getColorStyleMap() {
        return this.colorStyleMap;
    }

    public final Map<Integer, DivLinePattern> getDivLineMap() {
        return this.divLineMap;
    }

    public final Map<Integer, TextPattern> getTextStyleMap() {
        return this.textStyleMap;
    }
}
