package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TextFormat extends FlexModelBase<b5> implements b5 {
    public static final int BOLD = 700;

    @SerializedName("color")
    String color;

    @SerializedName("font_size")
    int fontSize;

    @SerializedName("ignore_color_mapping")
    boolean ignoreColorMapping;

    @SerializedName("italic")
    boolean italic;

    @SerializedName("use_heigh_light_color")
    boolean useHeighLight;

    @SerializedName("use_remote_clor")
    boolean useRemoteColor;

    @SerializedName("weight")
    int weight;

    public TextFormat() {
        super(b5.class);
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public boolean enableColorMapping() {
        return !this.ignoreColorMapping;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public String getColor() {
        return this.color;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public int getFontSize() {
        return this.fontSize;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public boolean getIgnoreColorMapping() {
        return this.ignoreColorMapping;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public boolean getItalic() {
        return this.italic;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public boolean getUseHeighLight() {
        return this.useHeighLight;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public boolean getUseRemoteColor() {
        return this.useRemoteColor;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public int getWeight() {
        return this.weight;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public boolean isItalic() {
        return this.italic;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public boolean isUseHeighLight() {
        return this.useHeighLight;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public boolean isUseRemoteColor() {
        return this.useRemoteColor;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public void setColor(String r100) {
        this.color = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public void setFontSize(int r100) {
        this.fontSize = r100;
    }

    public void setItalic(boolean r100) {
        this.italic = r100;
    }

    public void setUseHeighLight(boolean r100) {
        this.useHeighLight = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public void setUseRemoteColor(boolean r100) {
        this.useRemoteColor = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.b5
    public void setWeight(int r100) {
        this.weight = r100;
    }
}
