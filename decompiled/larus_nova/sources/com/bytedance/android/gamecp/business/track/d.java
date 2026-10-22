package com.bytedance.android.gamecp.business.track;

import bw.j;
import com.bytedance.android.gamecp.host_api.cloudgame.TeamPlayJoinMode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56426a = 0;

    static {
    }

    public static Map b(b r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("user_id", com.bytedance.android.gamecp.host_api.a.b().getUserService().getCurUserId());
        r101.put("promote_game_id", r100.f56422a);
        r101.put("creator_id", r100.f56423b);
        r101.put("room_id", r100.f56424c);
        return r101;
    }

    public static String c(Integer r100) {
        TeamPlayJoinMode.Companion.getClass();
        TeamPlayJoinMode[] r101 = TeamPlayJoinMode.values();
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L15;
        TeamPlayJoinMode r104 = r101[r103];
        int r105 = r104.getType();
        if (r100 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == true) goto L16;
        r103 = r103 + 1;
    L16:
        if (r104 == null) goto L22;
        int r107 = c.f56425a[r104.ordinal()];
        if (r107 != 1) goto L21;
        return "normal";
    L21:
        if (r107 != 2) goto L22;
        return "pay";
    L22:
        return "";
    L9:
        if (r105 != r100.intValue()) goto L11;
        r106 = true;
        goto L12
    L15:
        r104 = null;
        goto L16
    }

    public static void a(b r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "commonParams");
        j r102 = com.bytedance.android.gamecp.host_api.a.b().getLogService();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(b(r100));
        r103.put("teamplay_status", c(r101));
        Unit r104 = Unit.INSTANCE;
        r102.logV3("livesdk_cg_teamplay_attendance_failed", r103);
    }
}
