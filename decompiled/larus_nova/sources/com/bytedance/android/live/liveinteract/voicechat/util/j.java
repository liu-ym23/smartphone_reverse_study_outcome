package com.bytedance.android.live.liveinteract.voicechat.util;

import com.bytedance.android.live.browser.IBaseBrowserService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f80863a = 0;

    static {
    }

    public static void a(int r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("eventName", "switch_scene_failed_event");
        r102.put("current_scene", r100);
        r102.put("current_uilayout", r101);
        ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).sendEventToAllJsBridges("H5_webcastNotification", r102);
    }

    public static void b(int r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("eventName", "switch_scene_success_event");
        r102.put("current_scene", r100);
        r102.put("current_uilayout", r101);
        ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).sendEventToAllJsBridges("H5_webcastNotification", r102);
    }
}
