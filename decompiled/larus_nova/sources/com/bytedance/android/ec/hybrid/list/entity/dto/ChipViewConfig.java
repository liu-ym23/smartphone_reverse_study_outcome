package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\"\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\"\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\"\u0010\"\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R\"\u0010%\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R \u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R \u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b¨\u00061"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ChipViewConfig;", "Ljava/io/Serializable;", "()V", "aspectRatio", "", "getAspectRatio", "()Ljava/lang/String;", "setAspectRatio", "(Ljava/lang/String;)V", "background", "getBackground", "setBackground", "bottomRadius", "", "getBottomRadius", "()Ljava/lang/Integer;", "setBottomRadius", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "chipData", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ChipData;", "getChipData", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ChipData;", "setChipData", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ChipData;)V", "loadLynxNextLoop", "getLoadLynxNextLoop", "setLoadLynxNextLoop", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "minHeight", "getMinHeight", "setMinHeight", "mode", "getMode", "setMode", "topRadius", "getTopRadius", "setTopRadius", "type", "getType", "setType", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChipViewConfig implements Serializable {

    @SerializedName(TextureRenderKeys.KEY_IS_ASPECT_RATIO)
    private String aspectRatio;

    @SerializedName("background")
    private String background;

    @SerializedName("bottom_radius")
    private Integer bottomRadius;

    @SerializedName("chip_data")
    private ChipData chipData;

    @SerializedName("load_lynx_next_loop")
    private Integer loadLynxNextLoop;

    @SerializedName("margin_left")
    private Integer marginLeft;

    @SerializedName("margin_right")
    private Integer marginRight;

    @SerializedName("margin_top")
    private Integer marginTop;

    @SerializedName("min_height")
    private Integer minHeight;

    @SerializedName("mode")
    private String mode;

    @SerializedName("top_radius")
    private Integer topRadius;

    @SerializedName("type")
    private String type;

    public ChipViewConfig() {
        this.marginTop = 0;
        this.marginLeft = 0;
        this.marginRight = 0;
        this.minHeight = 0;
        this.topRadius = 0;
        this.bottomRadius = 0;
        this.aspectRatio = "1.0";
        this.mode = "aspectFill";
        this.loadLynxNextLoop = 0;
    }

    public final String getAspectRatio() {
        return this.aspectRatio;
    }

    public final String getBackground() {
        return this.background;
    }

    public final Integer getBottomRadius() {
        return this.bottomRadius;
    }

    public final ChipData getChipData() {
        return this.chipData;
    }

    public final Integer getLoadLynxNextLoop() {
        return this.loadLynxNextLoop;
    }

    public final Integer getMarginLeft() {
        return this.marginLeft;
    }

    public final Integer getMarginRight() {
        return this.marginRight;
    }

    public final Integer getMarginTop() {
        return this.marginTop;
    }

    public final Integer getMinHeight() {
        return this.minHeight;
    }

    public final String getMode() {
        return this.mode;
    }

    public final Integer getTopRadius() {
        return this.topRadius;
    }

    public final String getType() {
        return this.type;
    }

    public final void setAspectRatio(String r100) {
        this.aspectRatio = r100;
    }

    public final void setBackground(String r100) {
        this.background = r100;
    }

    public final void setBottomRadius(Integer r100) {
        this.bottomRadius = r100;
    }

    public final void setChipData(ChipData r100) {
        this.chipData = r100;
    }

    public final void setLoadLynxNextLoop(Integer r100) {
        this.loadLynxNextLoop = r100;
    }

    public final void setMarginLeft(Integer r100) {
        this.marginLeft = r100;
    }

    public final void setMarginRight(Integer r100) {
        this.marginRight = r100;
    }

    public final void setMarginTop(Integer r100) {
        this.marginTop = r100;
    }

    public final void setMinHeight(Integer r100) {
        this.minHeight = r100;
    }

    public final void setMode(String r100) {
        this.mode = r100;
    }

    public final void setTopRadius(Integer r100) {
        this.topRadius = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
