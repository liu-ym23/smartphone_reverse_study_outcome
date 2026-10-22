package com.bytedance.android.live.room.util;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f100383a = 0;

    static {
    }

    public static void a(IRoom r100) {
        HashMap r101 = new HashMap();
        r101.put("event_belong", "live");
        r101.put("event_type", "click");
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        r101.put("event_module", "top_tab");
        if (r100 == null) goto L6;
        String r102 = r100.getIdStr();
        if (r102 == null) goto L6;
    L7:
        r101.put("room_id", r102);
        if (r100 == null) goto L10;
        String r103 = r100.getOwnerUserIdString();
    L11:
        r101.put("anchor_id", String.valueOf(r103));
        if (r100 != null) goto L14;
    L16:
        j0.l().sendLog("livesdk_audience_list_click_v2", r101, new Object[]{new x()});
        return;
    L14:
        if (r100.isEcomNew() != true) goto L16;
        r101.put("is_ecom_new", "1");
        goto L16
    L10:
        r103 = null;
    L6:
        r102 = "";
        goto L7
    }
}
