package com.bytedance.android.gamecp.live_impl.utils;

import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import java.util.HashMap;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class i {
    public static final void a(String r100, String r101, HashMap r102) {
        r102.put("game_id", r101);
        Room r103 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        String r104 = null;
        if (r103 == null) goto L14;
        Long r105 = r103.getRoomId();
        if (r105 == null) goto L14;
        String r106 = String.valueOf(r105.longValue());
        if (r106 == null) goto L14;
        if ((!StringsKt.isBlank(r106)) == true) goto L12;
        r106 = null;
    L12:
        if (r106 == null) goto L14;
        r102.put("room_id", r106);
    L14:
        if (r103 == null) goto L22;
        String r107 = r103.getOwnerUserId();
        if (r107 == null) goto L22;
        if ((!StringsKt.isBlank(r107)) == false) goto L20;
        r104 = r107;
    L20:
        if (r104 == null) goto L22;
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r104);
    L22:
        HashMap<String, String> r108 = GamecpTracker.f56755a;
        GamecpTracker.B(r100, r102);
    }
}
