package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;

/* JADX INFO: renamed from: com.bytedance.android.live.base.model.message.ICommonChatMessage$-CC, reason: invalid class name */
/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class ICommonChatMessage$CC {
    public static /* bridge */ /* synthetic */ boolean $default$canPin(k0 r100) {
        return false;
    }

    public static /* bridge */ /* synthetic */ Map $default$getBuriedPoint(k0 r100) {
        return null;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinBaseMessageId(k0 r100) {
        return 0;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinCommenterId(k0 r100) {
        return 0;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinMessageShowArea(k0 r100) {
        return 2;
    }

    public static IBaseUser $default$getPinUser(k0 r100) {
        return r100.getChatUserInfo();
    }
}
