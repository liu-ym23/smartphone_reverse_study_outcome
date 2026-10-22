package com.bytedance.android.livesdk.linkvideo;

import com.bytedance.android.livesdk.log.j0;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f147117a = null;

    public e() {
    }

    static {
        f147117a = new e();
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void c(String r100) {
        j0 r101 = j0.l();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("anchor_id", r100);
        Unit r103 = Unit.INSTANCE;
        r101.sendLog("livesdk_takepag_live_related_video_introduction_button_click", r102, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void g(String r100) {
        j0 r101 = j0.l();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("anchor_id", r100);
        Unit r103 = Unit.INSTANCE;
        r101.sendLog("livesdk_takepag_live_related_video_reselect", r102, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void h(String r100) {
        j0 r101 = j0.l();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("anchor_id", r100);
        Unit r103 = Unit.INSTANCE;
        r101.sendLog("livesdk_takepag_live_related_video_cancel", r102, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void i(String r100) {
        j0 r101 = j0.l();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("anchor_id", r100);
        Unit r103 = Unit.INSTANCE;
        r101.sendLog("livesdk_takepag_live_related_video_introduction_button_show", r102, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void a(String r100, String r101) {
        j0 r102 = j0.l();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("enter_from", r100);
        r103.put("anchor_id", r101);
        Unit r104 = Unit.INSTANCE;
        r102.sendLog("livesdk_takepag_confirm_live_related_video_button_show", r103, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void d(String r100, String r101) {
        j0 r102 = j0.l();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("enter_from", r100);
        r103.put("anchor_id", r101);
        Unit r104 = Unit.INSTANCE;
        r102.sendLog("livesdk_takepag_live_related_video_introduction_return", r103, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void f(boolean r100, String r101) {
        j0 r102 = j0.l();
        LinkedHashMap r103 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r104 = "live_related_video_reselect";
    L6:
        r103.put("enter_from", r104);
        r103.put("anchor_id", r101);
        Unit r105 = Unit.INSTANCE;
        r102.sendLog("livesdk_takepag_live_related_video_show_empty", r103, new Object[]{null});
        return;
    L5:
        r104 = "livesdk_takepage_second_page";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void k(String r100, String r101) {
        j0 r102 = j0.l();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("enter_from", r100);
        r103.put("anchor_id", r101);
        Unit r104 = Unit.INSTANCE;
        r102.sendLog("livesdk_takepag_live_related_video_introduction_show", r103, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void m(String r100, String r101) {
        j0 r102 = j0.l();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("enter_from", r100);
        r103.put("anchor_id", r101);
        Unit r104 = Unit.INSTANCE;
        r102.sendLog("livesdk_takepag_live_related_video_introduction_show_bottom", r103, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void b(boolean r100, String r101, String r102) {
        j0 r103 = j0.l();
        LinkedHashMap r104 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r105 = "live_related_video_reselect";
    L6:
        r104.put("enter_from", r105);
        r104.put("anchor_id", r101);
        r104.put("video_id", r102);
        Unit r106 = Unit.INSTANCE;
        r103.sendLog("livesdk_takepag_live_related_video_show", r104, new Object[]{null});
        return;
    L5:
        r105 = "livesdk_takepage_second_page";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void e(boolean r100, String r101, String r102) {
        j0 r103 = j0.l();
        LinkedHashMap r104 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r105 = "live_related_video_reselect";
    L6:
        r104.put("enter_from", r105);
        r104.put("anchor_id", r101);
        r104.put("video_id", r102);
        Unit r106 = Unit.INSTANCE;
        r103.sendLog("livesdk_takepag_live_related_video_click", r104, new Object[]{null});
        return;
    L5:
        r105 = "livesdk_takepage_second_page";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void j(String r100, String r101, String r102) {
        j0 r103 = j0.l();
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("enter_from", r100);
        r104.put("anchor_id", r101);
        r104.put("video_id", r102);
        Unit r105 = Unit.INSTANCE;
        r103.sendLog("livesdk_takepag_confirm_live_related_video_button_click", r104, new Object[]{null});
    }

    @Override // com.bytedance.android.livesdk.linkvideo.b
    public final void l(String r100, String r101, String r102) {
        j0 r103 = j0.l();
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("enter_from", r100);
        r104.put("anchor_id", r101);
        r104.put("video_id", r102);
        Unit r105 = Unit.INSTANCE;
        r103.sendLog("livesdk_takepag_live_related_video_play", r104, new Object[]{null});
    }
}
