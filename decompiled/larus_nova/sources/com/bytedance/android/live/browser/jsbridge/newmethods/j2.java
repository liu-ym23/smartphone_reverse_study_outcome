package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.browser.jsbridge.base.CommunityLiveAppointmentStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "community.liveAppointmentStatus")
public final class j2 extends w20.e0<w20.k8, CommunityLiveAppointmentStatusResultModel> {
    public j2() {
    }

    public static String j(List r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "scheduleTime");
        Calendar r100 = Calendar.getInstance();
        Object r101 = r100.clone();
        if (r101 == null) goto L39;
        Calendar r102 = (Calendar) r101;
        Iterator r112 = r110.iterator();
        int r103 = Integer.MAX_VALUE;
    L6:
        if (r112.hasNext() == false) goto L37;
        int r104 = (((Number) r112.next()).intValue() - r100.get(7)) + 1;
        if (r104 != 0) goto L28;
        Intrinsics.checkNotNullParameter(r111, "inputTime");
        if (r111.length() != 3) goto L13;
        String r105 = "0".concat(r111);
    L15:
        String r106 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (r105 == null) goto L23;
        String r107 = r106 + ' ' + r105.substring(0, 2) + ':' + r105.substring(2, 4) + ":00";
        System.out.println("fullTime：" + r107);
        long r108 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(r107).getTime();     // Catch: Exception -> L20
    L26:
        if (System.currentTimeMillis() <= r108) goto L28;
        r104 = r104 + 7;
    L20:
        e = move-exception;
        e.printStackTrace();
    L24:
        r108 = 0;
        goto L26
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        if (r111.length() != 4) goto L24;
        r105 = r111;
    L28:
        if (r104 >= 0) goto L30;
        r104 = r104 + 7;
    L30:
        if (r104 >= r103) goto L6;
        Object r109 = r100.clone();
        if (r109 == null) goto L35;
        r102 = (Calendar) r109;
        r102.add(5, r104);
        r103 = r104;
        goto L6
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.util.Calendar");
    L37:
        return new SimpleDateFormat("yyyyMMdd").format(r102.getTime());
    L39:
        throw new NullPointerException("null cannot be cast to non-null type java.util.Calendar");
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.k8 r100 = (w20.k8) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r101 = r100.b();     // Catch: Exception -> L65
        JsonObject r102 = r100.a();     // Catch: Exception -> L65
        Boolean r103 = null;
        if (r102 == null) goto L6;
        String r104 = r102.toString();     // Catch: Exception -> L65
    L7:
        com.bytedance.android.live.browser.jsbridge.protobuf.b r105 = (com.bytedance.android.live.browser.jsbridge.protobuf.b) JsonUtil.parse(r104, com.bytedance.android.live.browser.jsbridge.protobuf.b.class);     // Catch: Exception -> L65
        if (r105 == null) goto L10;
        List<Integer> r112 = r105.g();     // Catch: Exception -> L65
    L11:
        if (r105 == null) goto L13;
        String r106 = r105.a();     // Catch: Exception -> L65
    L14:
        if (r105 == null) goto L16;
        String r107 = r105.d();     // Catch: Exception -> L65
    L17:
        if (r105 == null) goto L19;
        Long r108 = r105.e();     // Catch: Exception -> L65
    L20:
        if (r105 == null) goto L22;
        Long r109 = r105.f();     // Catch: Exception -> L65
    L23:
        if (r105 == null) goto L25;
        String r113 = r105.b();     // Catch: Exception -> L65
    L26:
        if (r105 == null) goto L29;
        Integer r114 = r105.c();     // Catch: Exception -> L65
    L31:
        if (r108 != null) goto L70;
    L34:
        if (r112 != null) goto L36;
    L38:
        Boolean r115 = Boolean.TRUE;     // Catch: Exception -> L65
        if (Intrinsics.areEqual(r101, r115) == false) goto L60;
        IAnnouncementService r116 = (IAnnouncementService) jc1.k.f(IAnnouncementService.class);     // Catch: Exception -> L65
        if (r116 == null) goto L57;
        Activity r117 = com.bytedance.android.livesdk.utils.z2.f159233b.getActivity();     // Catch: Exception -> L65
        String r118 = String.valueOf(r108);     // Catch: Exception -> L65
        String r119 = String.valueOf(r109);     // Catch: Exception -> L65
        if (r106 != null) goto L46;
        r106 = "";
    L46:
        if (r107 != null) goto L48;
        String r120 = "";
    L49:
        if (r114 == null) goto L51;
        int r121 = r114.intValue();     // Catch: Exception -> L65
    L52:
        Pair[] r122 = new Pair[3];     // Catch: Exception -> L65
        r122[0] = TuplesKt.to("enter_from_merge", "");     // Catch: Exception -> L65
        r122[1] = TuplesKt.to("enter_method", PrefetchTiming.JSB);     // Catch: Exception -> L65
        if (r113 != null) goto L55;
        r113 = "";
    L55:
        r122[2] = TuplesKt.to("appointment_id", r113);     // Catch: Exception -> L65
        r103 = Boolean.valueOf(r116.addAudienceAnnounceCalendar(r117, r118, r119, r106, r120, r121, MapsKt.mutableMapOf(r122), r112));     // Catch: Exception -> L65
        goto L57
    L51:
        r121 = 0;
        goto L52
    L48:
        r120 = r107;
    L57:
        if ((!Intrinsics.areEqual(r103, r115)) == false) goto L72;
        com.bytedance.android.live.core.utils.f2.c("预约成功，开播时将通知你", 0);     // Catch: Exception -> L65
        return;
    L72:
        return;
    L60:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L74;
        IAnnouncementService r123 = (IAnnouncementService) jc1.k.f(IAnnouncementService.class);     // Catch: Exception -> L65
        if (r123 == null) goto L75;
        r123.removeAudienceAnnounceCalendar(com.bytedance.android.livesdk.utils.z2.f159233b.getActivity(), String.valueOf(r113));     // Catch: Exception -> L65
        return;
    L75:
        return;
    L74:
        return;
    L36:
        if ((!r112.isEmpty()) != true) goto L38;
        r108 = Long.valueOf(com.bytedance.android.livesdk.utils.d5.c(j(r112, String.valueOf(r109))));     // Catch: Exception -> L68
    L77:
        return;
    L70:
        if (r108.longValue() != 0) goto L38;
    L29:
        r114 = null;
        goto L31
    L25:
        r113 = null;
        goto L26
    L22:
        r109 = null;
        goto L23
    L19:
        r108 = null;
        goto L20
    L16:
        r107 = null;
        goto L17
    L13:
        r106 = null;
        goto L14
    L10:
        r112 = null;
        goto L11
    L6:
        r104 = null;
    L65:
        e = move-exception;
        ALogger.e("CommunityLiveAppointmentStatusMethod", e.toString());
    }
}
