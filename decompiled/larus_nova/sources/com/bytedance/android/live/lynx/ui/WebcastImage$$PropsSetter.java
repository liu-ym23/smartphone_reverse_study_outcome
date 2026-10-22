package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes46.dex */
public class WebcastImage$$PropsSetter extends LynxUI$$PropsSetter {
    public WebcastImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        WebcastImage r103 = (WebcastImage) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case 114148: goto L14;
            case 371164613: goto L10;
            case 1615004818: goto L6;
            default: goto L17;
        };
    L17:
        switch(r104) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.setProperty(r100, r101, r102);
        return;
    L20:
        r103.setAutoPlay(r102.b(r101, false));
        return;
    L22:
        r103.setFadeDuration(r102.f(r101, 0));
        return;
    L24:
        r103.setSrc(r102.h(r101));
        return;
    L6:
        if (r101.equals("auto-play") == false) goto L17;
        r104 = 2;
        goto L17
    L10:
        if (r101.equals("fade-duration") == false) goto L17;
        r104 = 1;
        goto L17
    L14:
        if (r101.equals("src") == false) goto L17;
        r104 = 0;
        goto L17
    }
}
