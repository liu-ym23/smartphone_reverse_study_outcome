package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ih0.c f75061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f75062b;

    static {
        f75062b = "link_setting_click";
    }

    public static void a(Context r110, DataCenter r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f75061a == null) goto L6;
        ALogger.i("MultiLinkSettingPanelReuseManager", "genSettingPanelContainerCard reuse");
        return;
    L6:
        u6 r100 = new u6(vm2.i.b().getSettingPanelSchema());
        r100.b("url", vm2.i.b().getSettingPanelUrl());
        u6 r101 = r100.d("url");
        LinkedHashMap r102 = new LinkedHashMap();
        if (r112 < 0) goto L9;
        r102.put("position", String.valueOf(r112));
    L9:
        Iterator r113 = r102.entrySet().iterator();
    L11:
        if (r113.hasNext() == false) goto L13;
        Map.Entry r103 = (Map.Entry) r113.next();
        r101.b((String) r103.getKey(), (String) r103.getValue());
        goto L11
    L13:
        Uri r104 = r100.c();
        long r105 = System.currentTimeMillis();
        IInteractService r114 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r114 == null) goto L18;
        ih0.b r106 = r114.dynamicService(r111);
        if (r106 == null) goto L18;
        ih0.c r115 = ih0.b.a.a(r106, r110, r104, new q(), System.currentTimeMillis());
    L19:
        f75061a = r115;
        ALogger.i("MultiLinkSettingPanelReuseManager", "genSettingPanelContainerCard cost=" + (System.currentTimeMillis() - r105));
        return;
    L18:
        r115 = null;
        goto L19
    }
}
