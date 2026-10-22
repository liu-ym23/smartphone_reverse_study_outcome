package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f65983c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends e80.a> f65984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Widget f65985b;

    public static final class a {
    }

    static {
    }

    public f(Widget r100) {
        this.f65985b = r100;
    }

    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put(NewBroadcastMonitor.STAGE.LIFECYCLE, r100);
        r101.put("error_type", "data_center_is_null");
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        LiveTracingMonitor.f("ttlive_widget_error", LiveTracingMonitor.EventModule.INTERACTION_OPT, r101, r103, r102);
    }
}
