package com.bytedance.android.livesdk.log;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class b0 extends com.bytedance.android.live.core.log.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b0 f153279a;

    public static synchronized b0 o() {
        monitor-enter(b0.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f153279a != null) goto L7;
        f153279a = new b0();     // Catch: Throwable -> L10
    L7:
        b0 r100 = f153279a;     // Catch: Throwable -> L10
        monitor-exit(b0.class);
        return r100;
    }

    @Override // com.bytedance.android.live.core.log.g
    public final JSONObject h() {
        JSONObject r100 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r101 = j0.l().c(IRoom.class);
        String r102 = "";
        if ((r101 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L12;
        com.bytedance.android.livesdk.log.filter.u r103 = (com.bytedance.android.livesdk.log.filter.u) r101;
        if (r103.getMap().containsKey("room_id") == false) goto L7;
        String r104 = r103.getMap().get("room_id");
    L9:
        if (r103.getMap().containsKey("anchor_id") == false) goto L11;
        r102 = r103.getMap().get("anchor_id");
    L11:
        String r105 = r102;
        r102 = r103.n();
        String r106 = r105;
    L18:
        r100.put("user_id", r102);     // Catch: JSONException -> L15
        r100.put("room_id", r104);     // Catch: JSONException -> L15
        r100.put("anchor_id", r106);     // Catch: JSONException -> L15
    L17:
        return r100;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L7:
        r104 = "";
        goto L9
    L12:
        r106 = "";
        r104 = r106;
        goto L18
    }

    public b0() {
    }
}
