package com.bytedance.android.livesdk.chatroom.monitor;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends ActivityBaseTimeMonitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f107003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f107004d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final String b() {
        return "ttlive_long_touch_full_link_duration";
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        ActivityBaseTimeMonitor.f(r100, "roomId", Long.valueOf(this.f107004d));
        ActivityBaseTimeMonitor.f(r100, "startStep", null);
        return r100;
    }

    public c(long r100) {
        this.f107004d = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject e(Map<String, Long> r110) {
        Intrinsics.checkNotNullParameter(r110, "timeEventMap");
        if (this.f107003c == false) goto L5;
        return null;
    L5:
        this.f107003c = true;
        JSONObject r100 = new JSONObject();
        Long r101 = r110.get("lt_fetch_data");
        Long r102 = r110.get("lt_load_start");
        if (r101 == null) goto L15;
        if (r102 == null) goto L15;
        long r103 = r102.longValue();
        long r104 = r101.longValue();
        if (r104 <= 0) goto L15;
        if (r103 <= 0) goto L15;
        if (r103 < r104) goto L15;
        long r105 = r103 - r104;
        ActivityBaseTimeMonitor.f(r100, "cost_time_fd_2_lu", Long.valueOf(r105));
        Long r106 = Long.valueOf(r105);
    L16:
        if (r106 == null) goto L31;
        r106.longValue();
        Long r107 = r110.get("lt_load_start");
        Long r111 = r110.get("lt_load_finish");
        if (r107 == null) goto L27;
        if (r111 == null) goto L27;
        long r108 = r111.longValue();
        long r109 = r107.longValue();
        if (r109 <= 0) goto L27;
        if (r108 <= 0) goto L27;
        if (r108 < r109) goto L27;
        long r112 = r108 - r109;
        ActivityBaseTimeMonitor.f(r100, "cost_time_lus_2_luf", Long.valueOf(r112));
        Long r113 = Long.valueOf(r112);
    L28:
        if (r113 == null) goto L32;
        r113.longValue();
        return r100;
    L32:
        return null;
    L27:
        r113 = null;
        goto L28
    L31:
        return null;
    L15:
        r106 = null;
        goto L16
    }
}
