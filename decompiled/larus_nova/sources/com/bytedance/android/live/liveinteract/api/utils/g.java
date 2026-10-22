package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f71512a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f71513b = null;

    static {
        LiveSlardarConstants.suffixAll("ttlive_pk_open_api");
        LiveSlardarConstants.suffixError("ttlive_pk_open_api");
        LiveSlardarConstants.suffixAll("ttlive_pk_finish_api");
        LiveSlardarConstants.suffixError("ttlive_pk_finish_api");
        LiveSlardarConstants.suffixAll("ttlive_pk_stats_api");
        LiveSlardarConstants.suffixError("ttlive_pk_stats_api");
        LiveSlardarConstants.suffixAll("ttlive_pk_sei_api");
        LiveSlardarConstants.suffixError("ttlive_pk_sei_api");
        LiveSlardarConstants.suffixAll("ttlive_pk_permission_api");
        LiveSlardarConstants.suffixError("ttlive_pk_permission_api");
        f71512a = LiveSlardarConstants.suffixAll("ttlive_interact_plugin_api");
        f71513b = LiveSlardarConstants.suffixError("ttlive_interact_plugin_api");
    }

    public static boolean l(String r100) {
        List r101 = (List) vm2.d.f555945q8.getValue(null, vm2.d.f555776a[481(0x1e1, float:6.74E-43)]);
        if (Lists.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (r101.contains(r100) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void p(Map r100) {
        r100.put("event", "rtc_mix_sei");
        Room r101 = m.i().getCurrentRoom();
        if (r101 == null) goto L5;
        r100.put("room_id", r101.getIdStr());
        r100.put("anchor_id", r101.getOwnerUserIdString());
    L5:
        b0.o().j("ttlive_link", r100);
    }

    public static void q(long r100, int r101) {
        HashMap r102 = new HashMap();
        r102.put("pluginName", "live_resource");
        r102.put("duration", Long.valueOf(r100));
        r102.put("pre_load_strategy", Integer.valueOf(r101));
        LiveSlardarMonitor.monitorStatusAndDuration(f71513b, 1, 0, r102);
    }

    public static void r(String r100, Throwable r101) {
        if (l(r100) == false) goto L5;
        return;
    L5:
        HashMap r102 = new HashMap();
        r102.put("message", r101.getMessage());
        r102.put("event", r100);
        StringBuilder r103 = new StringBuilder();
        if (r101.getStackTrace() == null) goto L10;
        StackTraceElement[] r104 = r101.getStackTrace();
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L10;
        r103.append("\t\t" + r104[r106].toString());
        r106 = r106 + 1;
    L10:
        r102.put("trace", r103.toString());
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", 1, r102);
    }

    public static void s(String r100, Map<String, Object> r101) {
        if (l(r100) == false) goto L5;
        return;
    L5:
        HashMap r102 = new HashMap();
        r102.put("event", r100);
        r102.putAll(r101);
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", 1, r102);
    }

    public static void o(String r100, Map<String, Object> r101, tf0.i r102) {
        r101.put("event", r100);
        r101.put("channel_id", Long.valueOf(r102.getChannelId()));
        r101.put("interact_id", r102.getInteractId());
        Room r103 = m.i().getCurrentRoom();
        if (r103 == null) goto L5;
        r101.put("room_id", r103.getIdStr());
        r101.put("anchor_id", r103.getOwnerUserIdString());
    L5:
        b0.o().j("ttlive_link", r101);
    }

    public static void m(String r100, Map<String, Object> r101, tf0.i r102, long r103) {
        if (l(r100) == false) goto L5;
        return;
    L5:
        r101.put("event", r100);
        r101.put("channel_id", Long.valueOf(r102.getChannelId()));
        r101.put("interact_id", r102.getInteractId());
        com.bytedance.android.livesdk.user.e r104 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user();
        Room r105 = m.i().getCurrentRoom();
        if (r105 == null) goto L9;
        if (r104 == null) goto L9;
        r101.put("room_id", r105.getIdStr());
        r101.put("anchor_id", r105.getOwnerUserIdString());
        boolean r106 = Objects.equals(r105.getOwnerUserIdString(), r104.n());
    L10:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_interact_event_api_all", d.a(r100, ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene(), r106), r103, r101);
        b0.o().j("ttlive_link", r101);
        return;
    L9:
        r106 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void n(String r100, Map<String, Object> r101, tf0.i r102, boolean r103) {
        if (l(r100) == false) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
        r101 = new HashMap();
    L7:
        r101.put("event", r100);
        r101.put("channel_id", Long.valueOf(r102.getChannelId()));
        r101.put("interact_id", r102.getInteractId());
        if (r103 == false) goto L10;
        r101.put("rtc_info", r102.getRtcInfo());
    L10:
        com.bytedance.android.livesdk.user.e r104 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user();
        Room r105 = m.i().getCurrentRoom();
        if (r105 == null) goto L14;
        if (r104 == null) goto L14;
        r101.put("room_id", r105.getIdStr());
        r101.put("anchor_id", r105.getOwnerUserIdString());
        boolean r106 = Objects.equals(r105.getOwnerUserIdString(), r104.n());
    L15:
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", d.a(r100, ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene(), r106), r101);
        b0.o().j("ttlive_link", r101);
        return;
    L14:
        r106 = false;
        goto L15
    }
}
