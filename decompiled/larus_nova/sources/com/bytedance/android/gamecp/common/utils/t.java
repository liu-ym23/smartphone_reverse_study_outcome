package com.bytedance.android.gamecp.common.utils;

import android.util.Log;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.bytedance.android.gamecp.host_api.model.Room;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveTracingMonitor.EventModule f57302a = null;

    public t() {
    }

    static {
        f57302a = LiveTracingMonitor.EventModule.GAME_PROMOTE;
    }

    public static void b(int r100, JSONObject r101) {
        LiveTracingMonitor.EventType r102 = LiveTracingMonitor.EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r102, "eventType");
        Intrinsics.checkNotNullParameter(r102, "eventType");
        a(r100, r101, null, null, r102);
    }

    public static void d(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        JSONObject r102 = new JSONObject();
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
        hu.a.b(r102, "room_id", r106);
    L14:
        Room r107 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r107 == null) goto L24;
        String r108 = r107.getOwnerUserId();
        if (r108 == null) goto L24;
        if ((!StringsKt.isBlank(r108)) == true) goto L22;
        r108 = null;
    L22:
        if (r108 == null) goto L24;
        hu.a.b(r102, "anchor_id", r108);
    L24:
        hw.b r109 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user();
        if (r109 == null) goto L33;
        String r110 = r109.getCurrentUserId();
        if (r110 == null) goto L33;
        if ((!StringsKt.isBlank(r110)) == false) goto L31;
        r104 = r110;
    L31:
        if (r104 == null) goto L33;
        hu.a.b(r102, "user_id", r104);
    L33:
        JSONObject r111 = new JSONObject();
        r111.putOpt("tag", r100);
        r111.putOpt("class", Reflection.getOrCreateKotlinClass(r101.getClass()).getSimpleName());
        r111.putOpt("cause", r101.getCause());
        LiveTracingMonitor.EventModule r112 = f57302a;
        LiveTracingMonitor.EventType r113 = LiveTracingMonitor.EventType.BUSSINESS_API_CALL;
        JSONObject r114 = new JSONObject();
        r102.putOpt("message", r101.getMessage());
        r102.putOpt("stack", Log.getStackTraceString(r101));
        Unit r115 = Unit.INSTANCE;
        LiveTracingMonitor.a("ttlive_cooperation_partner_exception", r112, r113, r111, r114, r102);
    }

    public static void c(int r100, JSONObject r101, JSONObject r102) {
        LiveTracingMonitor.EventType r103 = LiveTracingMonitor.EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r103, "eventType");
        a(r100, r101, null, r102, r103);
    }

    public static void a(int r100, JSONObject r101, JSONObject r102, JSONObject r103, LiveTracingMonitor.EventType r110) {
        Intrinsics.checkNotNullParameter(r110, "eventType");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        JSONObject r104 = r101;
        if (r102 != null) goto L8;
        r102 = new JSONObject();
    L8:
        JSONObject r105 = r102;
        if (r103 != null) goto L11;
        r103 = new JSONObject();
    L11:
        JSONObject r106 = r103;
        hu.a.a(r104, "status", r100);
        Room r107 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        String r108 = null;
        if (r107 == null) goto L23;
        Long r109 = r107.getRoomId();
        if (r109 == null) goto L23;
        String r111 = String.valueOf(r109.longValue());
        if (r111 == null) goto L23;
        if ((!StringsKt.isBlank(r111)) == true) goto L21;
        r111 = null;
    L21:
        if (r111 == null) goto L23;
        hu.a.b(r106, "room_id", r111);
    L23:
        Room r112 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r112 == null) goto L33;
        String r113 = r112.getOwnerUserId();
        if (r113 == null) goto L33;
        if ((!StringsKt.isBlank(r113)) == true) goto L31;
        r113 = null;
    L31:
        if (r113 == null) goto L33;
        hu.a.b(r106, "anchor_id", r113);
    L33:
        hw.b r114 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user();
        if (r114 == null) goto L42;
        String r115 = r114.getCurrentUserId();
        if (r115 == null) goto L42;
        if ((!StringsKt.isBlank(r115)) == false) goto L40;
        r108 = r115;
    L40:
        if (r108 == null) goto L42;
        hu.a.b(r106, "user_id", r108);
    L42:
        LiveTracingMonitor.a("ttlive_cooperation_partner_track", f57302a, r110, r104, r105, r106);
    }
}
