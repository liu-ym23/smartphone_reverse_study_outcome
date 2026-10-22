package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.ui.image.UIImage$$PropsSetter;

/* JADX INFO: loaded from: classes46.dex */
public class CustomUiImage$$PropsSetter extends UIImage$$PropsSetter {
    public CustomUiImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.ui.image.UIImage$$PropsSetter, com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        CustomUiImage r103 = (CustomUiImage) r100;
        r101.getClass();
        if (r101.equals("fade-duration") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setFadeDuration(r102.f(r101, 0));
    }
}
