package com.bytedance.android.live.base.model.message;

/* JADX INFO: loaded from: classes45.dex */
public interface h5 extends ITextPieceImage {
    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ ITextPieceImage doClone();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ boolean getEnableTextWhenFailed();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ ITextPieceImage.ExtraOpt getExtraOpt();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ int getHeight();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ py.k getImageModel();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ int getLocalResId();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ ITextPieceImage.ResourceType getResourceType();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ ITextPieceImage.ScaleType getScaleType();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ float getScaleX();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ float getScaleY();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ float getScalingRate();

    int getTextColor();

    String getTextContent();

    float getTextSizeRate();

    int getTextType();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ int getWidth();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ boolean isNeedExtraSpace();

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setEnableTextWhenFailed(boolean r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setExtraOpt(ITextPieceImage.ExtraOpt r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setHeight(int r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setImageModel(py.k r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setLocalResId(int r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setNeedExtraSpace(boolean r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setResourceType(ITextPieceImage.ResourceType r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setScaleType(ITextPieceImage.ScaleType r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setScaleX(float r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setScaleY(float r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setScalingRate(float r100);

    void setTextColor(int r100);

    void setTextContent(String r100);

    void setTextSizeRate(float r100);

    void setTextType(int r100);

    @Override // com.bytedance.android.live.base.model.message.ITextPieceImage
    /* synthetic */ void setWidth(int r100);
}
