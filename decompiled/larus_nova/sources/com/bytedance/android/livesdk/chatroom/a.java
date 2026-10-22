package com.bytedance.android.livesdk.chatroom;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.utils.x1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f105090a = 0;

    static {
    }

    public static boolean a(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = ((Number) r101.get("data_link_state", 0)).intValue();
        if (gd0.v.a(r102, 8) == false) goto L8;
        return true;
    L8:
        if (x1.e() == false) goto L10;
        return true;
    L10:
        if (x1.c() == false) goto L12;
        return true;
    L12:
        if (x1.a() == false) goto L14;
        return true;
    L14:
        if (x1.b() == false) goto L16;
        return true;
    L16:
        if (x1.d() == false) goto L18;
        return true;
    L18:
        if (gd0.v.a(r102, 512) == true) goto L28;
        UIUtils.setViewVisibility(r100, 0);
        HashMap r103 = new HashMap();
        r103.put(ReportCardMonitorPlugin.EVENT_NAME, "anchor_pause_tips_status");
        r103.put("view_status", "show");
        r103.put("reason", "receive pause control msg by anchor suspend.");
        com.bytedance.android.livesdk.log.k0.o().b("ttlive_room", r103);
        return true;
    L28:
        return true;
    }
}
