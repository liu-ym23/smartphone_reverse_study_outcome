package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TextPieceImage extends FlexModelBase<ITextPieceImage> implements ITextPieceImage {
    public boolean enableTextWhenFailed;
    protected ITextPieceImage.ExtraOpt extraOpt;
    protected int height;

    @SerializedName("image")
    k imageModel;
    protected int localResId;
    protected boolean needExtraSpace;
    protected ITextPieceImage.ResourceType resourceType;
    protected ITextPieceImage.ScaleType scaleType;
    protected float scaleX;
    protected float scaleY;

    @SerializedName("scaling_rate")
    float scalingRate;
    protected int width;

    public TextPieceImage() {
        super(ITextPieceImage.class);
        this.resourceType = ITextPieceImage.ResourceType.NetWork;
        this.extraOpt = ITextPieceImage.ExtraOpt.NONE;
        this.scaleType = ITextPieceImage.ScaleType.DEFAULT;
        this.needExtraSpace = false;
        this.enableTextWhenFailed = false;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public ITextPieceImage doClone() {
        TextPieceImage r100 = new TextPieceImage();
        r100.imageModel = this.imageModel;
        r100.scalingRate = this.scalingRate;
        r100.width = this.width;
        r100.height = this.height;
        r100.scaleX = this.scaleX;
        r100.scaleY = this.scaleY;
        r100.resourceType = this.resourceType;
        r100.extraOpt = this.extraOpt;
        r100.scaleType = this.scaleType;
        r100.localResId = this.localResId;
        r100.needExtraSpace = this.needExtraSpace;
        r100.enableTextWhenFailed = this.enableTextWhenFailed;
        return r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public boolean getEnableTextWhenFailed() {
        return this.enableTextWhenFailed;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public ITextPieceImage.ExtraOpt getExtraOpt() {
        return this.extraOpt;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public k getImageModel() {
        return this.imageModel;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public int getLocalResId() {
        return this.localResId;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public ITextPieceImage.ResourceType getResourceType() {
        return this.resourceType;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public ITextPieceImage.ScaleType getScaleType() {
        return this.scaleType;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public float getScalingRate() {
        return this.scalingRate;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public boolean isNeedExtraSpace() {
        return this.needExtraSpace;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setEnableTextWhenFailed(boolean r100) {
        this.enableTextWhenFailed = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setExtraOpt(ITextPieceImage.ExtraOpt r100) {
        this.extraOpt = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setHeight(int r100) {
        this.height = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setImageModel(k r100) {
        this.imageModel = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setLocalResId(int r100) {
        this.localResId = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setNeedExtraSpace(boolean r100) {
        this.needExtraSpace = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setResourceType(ITextPieceImage.ResourceType r100) {
        this.resourceType = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setScaleType(ITextPieceImage.ScaleType r100) {
        this.scaleType = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setScaleX(float r100) {
        this.scaleX = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setScaleY(float r100) {
        this.scaleY = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setScalingRate(float r100) {
        this.scalingRate = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    public void setWidth(int r100) {
        this.width = r100;
    }
}
