package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.l0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class w {
    public static final long a() {
        com.bytedance.android.live.liveinteract.api.data.a.f71432h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.k().f71435c == false) goto L6;
        int r100 = com.bytedance.android.live.liveinteract.api.data.a.C1153a.k().f71433a;
    L14:
        return r100;
    L6:
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.h().f71435c == false) goto L9;
        r100 = com.bytedance.android.live.liveinteract.api.data.a.C1153a.h().f71433a;
        goto L14
    L9:
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.a().f71435c == false) goto L12;
        r100 = com.bytedance.android.live.liveinteract.api.data.a.C1153a.a().f71433a;
        goto L14
    L12:
        return 0;
    }

    public static final long b() {
        com.bytedance.android.live.liveinteract.api.data.a.f71432h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.k().f71435c == false) goto L6;
        int r100 = com.bytedance.android.live.liveinteract.api.data.a.C1153a.k().f71434b;
    L14:
        return r100;
    L6:
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.h().f71435c == false) goto L9;
        r100 = com.bytedance.android.live.liveinteract.api.data.a.C1153a.h().f71434b;
        goto L14
    L9:
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.a().f71435c == false) goto L12;
        r100 = com.bytedance.android.live.liveinteract.api.data.a.C1153a.a().f71434b;
        goto L14
    L12:
        return 0;
    }

    public static final String c() {
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        boolean r101 = false;
        if (r100 == null) goto L9;
        rj0.m r102 = r100.getVideoTalkService();
        if (r102 == null) goto L9;
        com.bytedance.android.live.liveinteract.api.data.a r103 = r102.j();
        if (r103 == null) goto L9;
        boolean r104 = r103.f71435c;
    L10:
        if (r104 == true) goto L21;
        IInteractService r105 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r105 != null) goto L14;
    L16:
        if (r101 == true) goto L21;
        com.bytedance.android.live.liveinteract.api.data.a.f71432h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.a().f71435c == true) goto L21;
        return "";
    L14:
        if (r105.getInteractAudienceService() == null) goto L16;
        r101 = com.bytedance.android.live.liveinteract.api.data.a.a().f71435c;
    L21:
        return "rechargeable_normal";
    L9:
        r104 = false;
        goto L10
    }

    public static final void d() {
        LinkedHashMap r100 = new LinkedHashMap();
        m.G(r100);
        m.B(r100, null, 6);
        l0.e(r100);
        r100.put("function_type2", "live");
        j0.l().sendLog("livesdk_anchor_priority_queue_open_success", r100, new Object[]{IRoom.class});
    }

    public static final void e(boolean r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        m.G(r101);
        m.B(r101, null, 6);
        if (r100 == false) goto L5;
        String r102 = "on";
    L6:
        r101.put("action_type", r102);
        l0.e(r101);
        r101.put("function_type2", "live");
        j0.l().sendLog("livesdk_anchor_priority_queue_switch", r101, new Object[]{IRoom.class});
        return;
    L5:
        r102 = "off";
        goto L6
    }
}
