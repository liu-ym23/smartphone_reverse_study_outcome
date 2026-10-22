package com.bytedance.android.livesdk.interactivity.common.utils;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final boolean a(boolean r100) {
        if (r100 == true) goto L15;
        IMiddlewareUserService r101 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r101 == null) goto L13;
        com.bytedance.android.livesdk.user.e r102 = r101.user();
        if (r102 == null) goto L13;
        UserAttr r103 = r102.q();
        if (r103 == null) goto L13;
        if (r103.isAdmin() != true) goto L13;
        return true;
    L13:
        return false;
    L15:
        return true;
    }

    @JvmStatic
    public static final boolean b(boolean r100) {
        if (r100 == true) goto L24;
        IMiddlewareUserService r101 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.user.e r102 = r101.user();
        if (r102 == null) goto L9;
        UserAttr r103 = r102.q();
    L11:
        if (r103 != null) goto L13;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == true) goto L25;
        return false;
    L25:
        return true;
    L13:
        if (r103.isAdmin() == false) goto L19;
        List<Integer> r105 = r103.getAdminPrivileges();
        if (r105 == null) goto L19;
        LiveRoomPermission.D.getClass();
        if (r105.contains(Integer.valueOf(LiveRoomPermission.f105074x.f105077a)) != true) goto L19;
        r104 = true;
    L9:
        r103 = null;
        goto L11
    L24:
        return true;
    }
}
