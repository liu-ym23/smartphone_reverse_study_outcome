package com.bytedance.android.live.core.monitor.trace;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Deprecated(message = "user TraceMonitor")
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a60.e f64995a = null;

    static {
        f64995a = LiveInfraSettingKeys.LIVE_TRACE_MONITOR_CONFIG.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        return f64995a.e();
    }

    @JvmStatic
    public static final void b(e r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "traceMeta");
        Intrinsics.checkNotNullParameter(r100, "traceMeta");
        TraceMonitor.i(r100, null, null, r101);
    }
}
