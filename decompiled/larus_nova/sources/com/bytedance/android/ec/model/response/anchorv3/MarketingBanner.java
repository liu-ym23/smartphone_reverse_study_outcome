package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/MarketingBanner;", "Ljava/io/Serializable;", "()V", "bgImgUrl", "", "getBgImgUrl", "()Ljava/lang/String;", "setBgImgUrl", "(Ljava/lang/String;)V", "jumpUrl", "getJumpUrl", "setJumpUrl", "leftContent", "", "Lcom/bytedance/android/ec/model/response/anchorv3/ElementBlock;", "getLeftContent", "()Ljava/util/List;", "setLeftContent", "(Ljava/util/List;)V", "rightContent", "getRightContent", "setRightContent", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class MarketingBanner implements Serializable {

    @SerializedName("bg_img_url")
    private String bgImgUrl;

    @SerializedName("jump_url")
    private String jumpUrl;

    @SerializedName("left_content")
    private List<ElementBlock> leftContent;

    @SerializedName("right_content")
    private List<ElementBlock> rightContent;

    @SerializedName("type")
    private Integer type;

    public MarketingBanner() {
    }

    public final String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<ElementBlock> getLeftContent() {
        return this.leftContent;
    }

    public final List<ElementBlock> getRightContent() {
        return this.rightContent;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setBgImgUrl(String r100) {
        this.bgImgUrl = r100;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public final void setLeftContent(List<ElementBlock> r100) {
        this.leftContent = r100;
    }

    public final void setRightContent(List<ElementBlock> r100) {
        this.rightContent = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
