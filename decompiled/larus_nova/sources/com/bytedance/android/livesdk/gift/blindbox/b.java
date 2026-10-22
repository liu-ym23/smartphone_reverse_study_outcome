package com.bytedance.android.livesdk.gift.blindbox;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final h1 a(h1 r100) {
        if (r100 == null) goto L18;
        String r101 = r100.getBannerScheme();
        boolean r102 = false;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
    L15:
        if (r102 == false) goto L18;
        return r100;
    L13:
        if (r100.getType() != 12) goto L15;
        r102 = true;
        goto L15
    L7:
        if (r101.length() == 0) goto L10;
        r103 = false;
    L18:
        return null;
    }

    public static final h1 b(AbsPanel<?> r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.f126620h;
    L7:
        if ((r101 instanceof h1) == true) goto L9;
        r101 = null;
    L9:
        h1 r102 = (h1) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        return a(r102);
    L5:
        r101 = null;
        goto L7
    }
}
