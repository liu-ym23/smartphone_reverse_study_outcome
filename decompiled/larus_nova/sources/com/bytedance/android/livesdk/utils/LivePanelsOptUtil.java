package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v61;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePanelsOptUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f158759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f158760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f158761c = null;

    static {
        f158759a = -1;
        f158760b = true;
        f158761c = LazyKt.lazy(LivePanelsOptUtil$v1Config$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(DataCenter r100) {
        if (b(r100) == false) goto L15;
        v61.a r101 = ((v61) f158761c.getValue()).a();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.a() == true) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 != true) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r101.b() == false) goto L11;
        r102 = true;
        goto L12
    L15:
        return false;
    }

    public static boolean b(DataCenter r100) {
        if (r100 == null) goto L4;
        Boolean r101 = (Boolean) r100.get("data_is_anchor", Boolean.FALSE);
    L6:
        return !Intrinsics.areEqual(r101, Boolean.TRUE);
    L4:
        r101 = null;
        goto L6
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.i("LivePanelsOptUtil", r100);
    }

    @JvmStatic
    public static final void d(DataCenter r100) {
        IRoom r101 = null;
        if (r100 == null) goto L5;
        r101 = (IRoom) r100.get("data_room", null);
    L5:
        long r102 = System.currentTimeMillis();
        long r103 = r102 - f158759a;
        ALogger.i("LivePanelsOptUtil", "longPanel startTime:" + f158759a + " endTime:" + r102 + ", duration:" + r103);
        if (f158760b == false) goto L12;
        com.bytedance.android.livesdk.log.j0 r104 = com.bytedance.android.livesdk.log.j0.l();
        Pair[] r105 = new Pair[2];
        r105[0] = TuplesKt.to("duration", String.valueOf(r103));
        if (r101 == null) goto L10;
        long r106 = r101.getLiveRoomMode();
    L11:
        r105[1] = TuplesKt.to("live_mode", String.valueOf(r106));
        r104.sendLog("livesdk_lp_panel_duration", MapsKt.mapOf(r105), new Object[]{IRoom.class, am2.x.class});
        goto L12
    L10:
        r106 = -1;
    L12:
        f158760b = false;
    }
}
