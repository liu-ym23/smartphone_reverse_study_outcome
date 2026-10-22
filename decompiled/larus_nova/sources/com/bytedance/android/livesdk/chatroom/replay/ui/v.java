package com.bytedance.android.livesdk.chatroom.replay.ui;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayABSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;

/* JADX INFO: loaded from: classes7.dex */
public final class v extends ir1.c {

    public static final class a {
    }

    static {
    }

    public v() {
    }

    public final boolean o(int r100) {
        switch(r100) {
            case 2: goto L28;
            case 3: goto L28;
            case 4: goto L7;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L25;
            default: goto L23;
        };
    L23:
        return true;
    L25:
        return ReplayABSettingKeys.REPLAY_GESTURE_CONFIG.getValue().a();
    L26:
        return ReplayABSettingKeys.REPLAY_GESTURE_CONFIG.getValue().c();
    L7:
        if (ReplayABSettingKeys.REPLAY_GESTURE_CONFIG.getValue().b() == false) goto L21;
        fq1.a r101 = fq1.b.a();
        if (r101 == null) goto L21;
        Episode r102 = r101.f478400a;
        if (r102 == null) goto L21;
        IRoomAuthStatus r103 = r102.getRoomAuthStatus();
        if (r103 == null) goto L21;
        if (r103.getVideoAmplificationType() != 1) goto L21;
        if (e() == false) goto L21;
        if (h() == true) goto L23;
    L21:
        return false;
    L28:
        return e();
    }
}
