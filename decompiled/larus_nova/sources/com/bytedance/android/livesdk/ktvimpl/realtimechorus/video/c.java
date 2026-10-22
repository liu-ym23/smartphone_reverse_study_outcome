package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonType");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("function_type2", "chorus");
        r101.put("function_type", "chorus");
        r101.put(FastStartLiveConfig.PLAY_MODE, "music");
        r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r100);
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L5;
        String r102 = "anchor";
    L6:
        r101.put("user_type", r102);
        j0.l().sendLog("livesdk_anchor_ksong_button_click", r101, new Object[]{IRoom.class});
        return;
    L5:
        r102 = "guest";
        goto L6
    }
}
