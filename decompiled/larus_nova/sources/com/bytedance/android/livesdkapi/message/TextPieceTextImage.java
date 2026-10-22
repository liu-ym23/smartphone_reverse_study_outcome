package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.h5;

/* JADX INFO: loaded from: classes12.dex */
public class TextPieceTextImage extends TextPieceImage implements h5 {
    public int textColor;
    public String textContent;
    public float textSizeRate;
    public int textType;

    public TextPieceTextImage() {
        this.extraOpt = ITextPieceImage.ExtraOpt.OTHER;
    }

    @Override // com.bytedance.android.live.base.model.message.h5
    public int getTextColor() {
        return this.textColor;
    }

    @Override // com.bytedance.android.live.base.model.message.h5
    public String getTextContent() {
        return this.textContent;
    }

    @Override // com.bytedance.android.live.base.model.message.h5
    public float getTextSizeRate() {
        return this.textSizeRate;
    }

    @Override // com.bytedance.android.live.base.model.message.h5
    public int getTextType() {
        return this.textType;
    }

    @Override // com.bytedance.android.live.base.model.message.h5
    public void setTextColor(int r100) {
        this.textColor = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.h5
    public void setTextContent(String r100) {
        this.textContent = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.h5
    public void setTextSizeRate(float r100) {
        this.textSizeRate = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.h5
    public void setTextType(int r100) {
        this.textType = r100;
    }
}
