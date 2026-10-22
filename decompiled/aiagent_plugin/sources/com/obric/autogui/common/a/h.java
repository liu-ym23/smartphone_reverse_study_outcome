package com.obric.autogui.common.a;

import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.n;
import d.o;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniDataFeedbackConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private static final String TAG = "OmniDataFeedbackConfig";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f28984a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f28985b = null;

    private h() {
    }

    static {
        f28984a = new h();
        f28985b = ax.a(new String[]{"click", "double_click", "long_press"});
    }

    public final boolean a() {
        JSONObject r0 = e();
        if (a(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (a(r0, "omni_data_feedback_view_tree_enable") == false) goto L7;
        return true;
    }

    public final boolean b() {
        JSONObject r0 = e();
        if (a(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (a(r0, "omni_data_feedback_react_view_tree_enable") == false) goto L7;
        return true;
    }

    public final int c() {
        return a(e(), "omni_data_feedback_react_view_tree_context_max_entries", 200);
    }

    public final long d() {
        return a(e(), "omni_data_feedback_react_view_tree_clear_delay_millis", OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
    }

    public final boolean a(String r3) {
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(f28985b, Iterable.class, "com.obric.aiagent.plugin"), r3);
    }

    private final JSONObject e() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        h r5 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = n.f(ICloudConfig.Companion.getSettingsConfig("obric_omni_data_feedback_toggle_map"));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r6);
        if (r2 == null) goto L13;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L13;
        Loog.INSTANCE.w(TAG, "read cloud map failed, key=obric_omni_data_feedback_toggle_map", r2);
    L13:
        if (n.b(r6) == false) goto L15;
        r6 = null;
    L15:
        JSONObject r7 = (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.aiagent.plugin");
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L23;
        Loog r0 = Loog.INSTANCE;
        StringBuilder r3 = new StringBuilder().append("cloud map, key=obric_omni_data_feedback_toggle_map, value=");
        if (r7 == null) goto L21;
        String r4 = r7.toString();
        if (r4 == null) goto L21;
    L22:
        r0.d(TAG, r3.append(r4).toString());
    L21:
        r4 = "null";
    L23:
        return r7;
    L5:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L7
    }

    private final boolean a(JSONObject r2) {
        return a(r2, "omni_data_feedback_enable");
    }

    private final boolean a(JSONObject r1, String r2) {
        if (r1 == null) goto L11;
        if (r1.has(r2) == false) goto L11;
        if (r1.optInt(r2, 0) == 1) goto L9;
        return false;
    L9:
        return true;
    L11:
        return AOSystemTools.INSTANCE.isDebugVersion();
    }

    private final int a(JSONObject r1, String r2, int r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (r1.has(r2) == false) goto L18;
        Integer r0 = Integer.valueOf(r1.optInt(r2, r3));
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r0 = null;
    L13:
        if (r0 != null) goto L15;
        return r3;
    L15:
        return r0.intValue();
    L9:
        r4 = false;
        goto L10
    L18:
        return r3;
    }

    private final long a(JSONObject r3, String r4, long r5) {
        if (r3 != null) goto L4;
        return r5;
    L4:
        if (r3.has(r4) == false) goto L18;
        Long r2 = Long.valueOf(r3.optLong(r4, r5));
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r2 = null;
    L13:
        if (r2 != null) goto L15;
        return r5;
    L15:
        return r2.longValue();
    L9:
        r6 = false;
        goto L10
    L18:
        return r5;
    }
}
