package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final boolean a(com.bytedance.android.livesdk.interactivity.api.base.d r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f132904a != PublicScreenAreaPageType.ChatChannel) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L15;
        return true;
    L15:
        return false;
    L7:
        r101 = false;
        goto L8
    }
}
