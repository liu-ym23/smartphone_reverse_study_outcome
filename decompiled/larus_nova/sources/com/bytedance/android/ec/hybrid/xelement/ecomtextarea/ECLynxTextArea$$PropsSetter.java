package com.bytedance.android.ec.hybrid.xelement.ecomtextarea;

import com.bytedance.ies.xelement.input.LynxTextAreaView$$PropsSetter;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes44.dex */
public class ECLynxTextArea$$PropsSetter extends LynxTextAreaView$$PropsSetter {
    public ECLynxTextArea$$PropsSetter() {
    }

    @Override // com.bytedance.ies.xelement.input.LynxTextAreaView$$PropsSetter, com.bytedance.ies.xelement.input.LynxBaseInputView$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        ECLynxTextArea r103 = (ECLynxTextArea) r100;
        r101.getClass();
        if (r101.equals("line-spacing-mult-android") == false) goto L5;
        r103.lineSpacingMult(r102.e(r101, 0.0f));
        return;
    L5:
        if (r101.equals("line-spacing-extra-android") == true) goto L8;
        super.setProperty(r100, r101, r102);
        return;
    L8:
        r103.lineSpacingExtra(r102.e(r101, 0.0f));
    }
}
