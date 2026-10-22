package com.bytedance.android.live.liveinteract.plantform.utils;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f77531a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void a(String r100) {
        HashMap r101 = new HashMap();
        r101.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r101.put("opened", (Boolean) tc0.c.h().f481009b);
        r101.put("link_mic_id", tc0.c.h().f545349f);
        r101.put("state", (Integer) hd0.c.f().f481009b);
        r101.put("mode", Integer.valueOf(hd0.c.f().f484576g));
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_interact", r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HashMap r102 = new HashMap();
        r102.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r102.put("extra", r101);
        r102.put("opened", (Boolean) tc0.c.h().f481009b);
        r102.put("link_mic_id", tc0.c.h().f545349f);
        r102.put("state", (Integer) hd0.c.f().f481009b);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_interact", r102);
    }
}
