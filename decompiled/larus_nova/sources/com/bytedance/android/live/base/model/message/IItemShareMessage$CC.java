package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;

/* JADX INFO: renamed from: com.bytedance.android.live.base.model.message.IItemShareMessage$-CC, reason: invalid class name */
/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class IItemShareMessage$CC {
    public static /* bridge */ /* synthetic */ boolean $default$canPin(m1 r100) {
        return false;
    }

    public static /* bridge */ /* synthetic */ Map $default$getBuriedPoint(m1 r100) {
        return null;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinBaseMessageId(m1 r100) {
        return 0;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinCommenterId(m1 r100) {
        return 0;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinMessageShowArea(m1 r100) {
        return 2;
    }

    public static IBaseUser $default$getPinUser(m1 r100) {
        return r100.getChatUserInfo();
    }
}
