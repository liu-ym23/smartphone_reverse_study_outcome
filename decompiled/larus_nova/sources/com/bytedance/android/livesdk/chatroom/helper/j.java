package com.bytedance.android.livesdk.chatroom.helper;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.log.filter.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public static void a(String r100, long r101, Map<String, Object> r102, int r110) {
        com.bytedance.android.livesdk.log.filter.o r103 = j0.l().c(IRoom.class);
        String r104 = "";
        if ((r103 instanceof u) == false) goto L12;
        u r105 = (u) r103;
        if (r105.getMap().containsKey("room_id") == false) goto L7;
        String r106 = r105.getMap().get("room_id");
    L9:
        if (r105.getMap().containsKey("anchor_id") == false) goto L11;
        r104 = r105.getMap().get("anchor_id");
    L11:
        String r107 = r105.n();
    L13:
        r102.put("event", r100);
        r102.put(VideoThumbInfo.KEY_INTERVAL, Long.valueOf(r101));
        r102.put("room_id", r106);
        r102.put("anchor_id", r104);
        r102.put("user_id", r107);
        LiveSlardarMonitor.monitorStatus("ttlive_room_ping_audience", r110, r102);
        return;
    L7:
        r106 = "";
        goto L9
    L12:
        r107 = "";
        r106 = r107;
        goto L13
    }
}
