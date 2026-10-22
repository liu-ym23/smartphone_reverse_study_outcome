package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.browser.IBaseBrowserService;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f70690a = 0;

    static {
    }

    @JvmStatic
    public static final void a(long r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("eventName", "event_song_download_progress_update");
        r102.put("songId", r100);
        r102.put("progress", r101);
        ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).sendEventToAllJsBridges("H5_webcastNotification", r102);
    }
}
