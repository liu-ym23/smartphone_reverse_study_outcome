package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;

/* JADX INFO: loaded from: classes11.dex */
public final class j {
    public static boolean b() {
        if (LiveMode.VIDEO != null) goto L5;
    L8:
        return true;
    L5:
        if (LiveMode.THIRD_PARTY == null) goto L8;
        return false;
    }

    public static boolean c() {
        if (tb1.c.f545229a == true) goto L5;
    L9:
        return false;
    L5:
        if (LiveMode.VIDEO != null) goto L7;
    L8:
        return true;
    L7:
        if (LiveMode.THIRD_PARTY != null) goto L9;
        goto L8
    }

    public static boolean d() {
        if (c() == true) goto L5;
    L9:
        return false;
    L5:
        if (b() == false) goto L9;
        if (com.bytedance.android.livesdk.sharedpref.b.X1.getValue().booleanValue() == true) goto L9;
        return true;
    }

    public static String a(LiveMode r100) {
        if (r100 != LiveMode.VIDEO) goto L7;
        return "video_live";
    L7:
        if (r100 != LiveMode.AUDIO) goto L11;
        return "voice_live";
    L11:
        if (r100 != LiveMode.SCREEN_RECORD) goto L15;
        return "game";
    L15:
        if (r100 != LiveMode.THIRD_PARTY) goto L19;
        return PriorityModule.SCENE_THIRD_PARTY;
    L19:
        if (r100 != LiveMode.OFFICIAL_ACTIVITY) goto L23;
        return "official";
    L23:
        if (r100 != LiveMode.MEDIA) goto L26;
        return "media";
    L26:
        return "unknown";
    }
}
