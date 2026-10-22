package com.bytedance.android.livesdk.interactivity.comment.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;

/* JADX INFO: loaded from: classes9.dex */
public final class f {
    public static final boolean a(IRoom r100) {
        if (r100 == null) goto L20;
        IRoomAuthStatus r101 = r100.getRoomAuthStatus();
        if (r101 == null) goto L21;
        IRoomAuthStatus.IRoomAuthSpecialStyle r102 = r101.getRoomAuthSpecialStyle();
        if (r102 == null) goto L22;
        IRoomAuthStatusStyle r103 = r102.getChatStyle();
        if (r103 == null) goto L23;
        String r104 = r103.getContent();
        if (r104 != null) goto L13;
        return true;
    L13:
        if (r104.length() <= 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 != true) goto L25;
        return false;
    L25:
        return true;
    L15:
        r105 = false;
        goto L16
    L23:
        return true;
    L22:
        return true;
    L21:
        return true;
    L20:
        return true;
    }

    public static final String c(IRoom r100) {
        if (r100 == null) goto L11;
        IRoomAuthStatus r101 = r100.getRoomAuthStatus();
        if (r101 == null) goto L11;
        IRoomAuthStatus.IRoomAuthSpecialStyle r102 = r101.getRoomAuthSpecialStyle();
        if (r102 == null) goto L11;
        IRoomAuthStatusStyle r103 = r102.getChatStyle();
        if (r103 == null) goto L11;
        String r104 = r103.getContent();
        if (r104 == null) goto L11;
        return r104;
    L11:
        return "";
    }

    public static final boolean b(IRoom r100, boolean r101) {
        if (r100 == null) goto L7;
        IRoomAuthStatus r102 = r100.getRoomAuthStatus();
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.getEnableChat();
    L7:
        return r101;
    }
}
