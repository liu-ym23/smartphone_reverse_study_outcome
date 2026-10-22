package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveModeKt_androidKt;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class j1 {
    static {
    }

    @JvmStatic
    public static final String a(LiveMode r100) {
        if (r100 == null) goto L4;
        String r101 = LiveModeKt_androidKt.getSceneName(r100);
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        switch(r101.hashCode()) {
            case 3165170: goto L23;
            case 93166550: goto L20;
            case 103772132: goto L17;
            case 112202875: goto L14;
            case 439491086: goto L11;
            default: goto L36;
        };
    L36:
        return "";
    L11:
        if (r101.equals(PriorityModule.SCENE_THIRD_PARTY) == true) goto L29;
        return "";
    L29:
        return PriorityModule.SCENE_THIRD_PARTY;
    L14:
        if (r101.equals("video") == false) goto L31;
        return "video_live";
    L31:
        return "";
    L17:
        if (r101.equals("media") == false) goto L32;
        return "media";
    L32:
        return "";
    L20:
        if (r101.equals("audio") == false) goto L33;
        return "voice_live";
    L33:
        return "";
    L23:
        if (r101.equals("game") == false) goto L34;
        return "game";
    L34:
        return "";
    L4:
        r101 = null;
        goto L5
    }
}
