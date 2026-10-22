package com.bytedance.android.anniex.salamander.xelement;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes43.dex */
public class AnnieXEngineElement$$PropsSetter extends UIGroup$$PropsSetter {
    public AnnieXEngineElement$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        AnnieXEngineElement r103 = (AnnieXEngineElement) r100;
        r101.getClass();
        if (r101.equals("anniexContainerId") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setAnnieXContainerId(r102.h(r101));
    }
}
