package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class h {
    static {
    }

    public static void a(boolean r100, Throwable r101) {
        if (r100 == false) goto L5;
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_delete_api"), 0);
        return;
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        c(r102, r101);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_delete_api"), 1, r102);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError("ttlive_audio_bg_delete_api"), 1, r102);
    }

    public static void b(boolean r100, Throwable r101) {
        if (r100 == false) goto L5;
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_set_api"), 0);
        return;
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        c(r102, r101);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_set_api"), 1, r102);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError("ttlive_audio_bg_set_api"), 1, r102);
    }

    public static void c(Map r100, Throwable r101) {
        if ((r101 instanceof ApiServerException) == false) goto L5;
        ApiServerException r102 = (ApiServerException) r101;
        r100.put("error_code", Integer.valueOf(r102.getErrorCode()));
        r100.put("error_msg", r102.getErrorMsg());
        return;
    L5:
        r100.put("error_code", -1);
        if (r101 == null) goto L8;
        String r103 = r101.getMessage();
    L9:
        r100.put("error_msg", r103);
        return;
    L8:
        r103 = null;
        goto L9
    }
}
