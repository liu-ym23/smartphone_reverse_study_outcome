package com.bytedance.android.livesdk.chatroom.tetris.vr;

import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f111944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f111945b = 0;

    static {
        f111944a = -1;
    }

    public static void a(DataCenter r100, Map r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "logMap");
        com.bytedance.android.livesdk.log.filter.o r102 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r103 = "";
        if (r102 == null) goto L8;
        Map<String, String> r104 = r102.getMap();
        if (r104 == null) goto L8;
        String r105 = r104.get("action_type");
        if (r105 == null) goto L8;
    L10:
        if (r102 == null) goto L15;
        Map<String, String> r106 = r102.getMap();
        if (r106 == null) goto L15;
        String r107 = r106.get("enter_from_merge");
        if (r107 == null) goto L15;
    L17:
        if (r102 == null) goto L22;
        Map<String, String> r108 = r102.getMap();
        if (r108 == null) goto L22;
        String r109 = r108.get("enter_method");
        if (r109 == null) goto L22;
    L23:
        String r111 = String.valueOf(VrUtils.l(r100));
        r101.put("enter_from_merge", r107);
        r101.put("enter_method", r109);
        if (r100 == null) goto L28;
        Room r112 = com.bytedance.android.live.core.utils.z.o(r100);
        if (r112 == null) goto L28;
        Long r113 = Long.valueOf(r112.f162599id);
    L29:
        r101.put("room_id", String.valueOf(r113));
        if (r100 == null) goto L37;
        Room r114 = com.bytedance.android.live.core.utils.z.o(r100);
        if (r114 == null) goto L37;
        String r115 = r114.getOwnerUserIdString();
        if (r115 == null) goto L37;
        r103 = r115;
    L37:
        r101.put("anchor_id", r103);
        r101.put("screen_direction", r111);
        if (r110 == false) goto L41;
        r101.put("action_type", r105);
        return;
    L41:
        return;
    L28:
        r113 = null;
    L22:
        r109 = "";
    L15:
        r107 = "";
    L8:
        r105 = "";
        goto L10
    }

    public static void b(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "resetType");
        HashMap r103 = new HashMap();
        a(null, r103, true);
        r103.put("restting_type", r100);
        if (r101 == false) goto L5;
        String r104 = "on";
    L6:
        r103.put("gyroscope_state", r104);
        if (r102 == false) goto L9;
        String r105 = "on_immersion";
    L10:
        r103.put("source", r105);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_vrmodel_view_resting", r103, new Object[0]);
        return;
    L9:
        r105 = "on_vr";
        goto L10
    L5:
        r104 = "off";
        goto L6
    }
}
