package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.UIImage;

/* JADX INFO: loaded from: classes46.dex */
public class CustomUiImage extends UIImage<FrescoImageView> {
    @Override // com.lynx.tasm.ui.image.UIImage, com.lynx.tasm.behavior.ui.LynxUI
    public final FrescoImageView createView(Context r100) {
        FrescoImageView r101 = super.createView(r100);
        r101.setFadeDuration(300);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "fade-duration")
    public void setFadeDuration(int r100) {
        if (getView() == 0) goto L6;
        ((FrescoImageView) getView()).setFadeDuration(r100);
        return;
    }

    @Override // com.lynx.tasm.ui.image.UIImage, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r100) {
        return createView(r100);
    }
}
