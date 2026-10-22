package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68179a;

    public final void m() {
        JSONObject r100 = new JSONObject();
        BaseMonitor.add(r100, "error_msg", "LiveSmallItemBeautyFragment show error");
        LiveSlardarMonitor.monitorStatus(this.f68179a, 3, r100);
    }

    public e(String r100) {
        this.f68179a = ("ttlive_load_" + r100 + "_list") + "_error";
    }

    public final void l(String r100) {
        JSONObject r101 = new JSONObject();
        BaseMonitor.add(r101, "error_msg", r100);
        LiveSlardarMonitor.monitorStatus(this.f68179a, 2, r101);
    }
}
