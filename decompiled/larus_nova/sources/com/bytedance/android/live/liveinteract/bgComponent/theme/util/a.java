package com.bytedance.android.live.liveinteract.bgComponent.theme.util;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f71805a = 0;

    static {
    }

    public static void a(boolean r100, Throwable r101) {
        if (r100 == false) goto L5;
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_list_api"), 0);
        return;
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        if ((r101 instanceof ApiServerException) == false) goto L8;
        ApiServerException r103 = (ApiServerException) r101;
        r102.put("error_code", Integer.valueOf(r103.getErrorCode()));
        r102.put("error_msg", r103.getErrorMsg());
    L13:
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_list_api"), 1, r102);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError("ttlive_audio_bg_list_api"), 1, r102);
        return;
    L8:
        r102.put("error_code", -1);
        if (r101 == null) goto L11;
        String r104 = r101.getMessage();
    L12:
        r102.put("error_msg", r104);
        goto L13
    L11:
        r104 = null;
        goto L12
    }
}
