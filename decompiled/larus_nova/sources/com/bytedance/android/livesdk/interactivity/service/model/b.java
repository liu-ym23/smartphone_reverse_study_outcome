package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final boolean a(IRoomAuthStatus r100) {
        if (r100 == null) goto L7;
        c r101 = (c) r100.castToOrNull(c.class);
        if (r101 == null) goto L7;
        long r102 = r101.getEnableAudioComment();
    L9:
        if (r102 != 2) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = 2;
        goto L9
    }

    public static final boolean b(IRoomAuthStatus r100) {
        if (r100 == null) goto L6;
        c r101 = (c) r100.castToOrNull(c.class);
        if (r101 == null) goto L6;
        long r102 = r101.getFixedChat();
    L8:
        if (r102 != 1) goto L10;
        return true;
    L10:
        return false;
    L6:
        r102 = 0;
        goto L8
    }
}
