package com.bytedance.android.livesdk.chatroom.replay.ui;

import com.bytedance.android.live.commonui.LiveSettingKeys;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends ir1.c {
    public final boolean o() {
        if (g() == true) goto L9;
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == true) goto L7;
    L11:
        return false;
    L7:
        if (a() == false) goto L11;
    L9:
        if (d() == false) goto L11;
        return true;
    }

    public h() {
    }
}
