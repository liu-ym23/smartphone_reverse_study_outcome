package com.android.server.policy;

import android.pico.utils.Features;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtWindowManagerPolicy extends IExtBase {
    static int getWindowLayerFromTypeLw(int type, boolean canAddInternalSystemWindow) {
        if (Features.isIslandEnabled() == false) goto L20;
        switch(type) {
            case 2991: goto L18;
            case 2992: goto L16;
            case 2993: goto L14;
            case 2994: goto L12;
            case 2995: goto L12;
            case 2996: goto L10;
            case 2997: goto L8;
            case 2998: goto L6;
            default: goto L22;
        };
    L6:
        return 25;
    L8:
        return 15;
    L10:
        return 5;
    L12:
        return 12;
    L14:
        return 21;
    L16:
        return 11;
    L18:
        return 16;
    L22:
        return -1;
    L20:
        return -1;
    }
}
