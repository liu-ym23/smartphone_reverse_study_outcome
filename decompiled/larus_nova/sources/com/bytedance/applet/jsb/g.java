package com.bytedance.applet.jsb;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g {
    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Intrinsics.checkNotNullParameter(r101, "status");
        AppletEvent$BizEvent r102 = AppletEvent$BizEvent.MUSIC_PLAY_STATUS_CHANGE;
        String r103 = r102.getEventName();
        long r104 = System.currentTimeMillis();
        JSONObject r105 = new JSONObject();
        r105.put("music_id", r100);
        r105.put("status", r101);
        Unit r106 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event(r103, r104, new f66.d(r105)));
        Lazy r107 = l3.d.f507201a;
        String r108 = r102.getEventName();
        JsonObject r109 = new JsonObject();
        r109.addProperty("music_id", r100);
        r109.addProperty("status", r101);
        l3.d.c(new l3.a(r108, r109, 4));
    }
}
