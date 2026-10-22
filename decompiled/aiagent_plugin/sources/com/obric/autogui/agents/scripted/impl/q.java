package com.obric.autogui.agents.scripted.impl;

import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScriptPerformanceTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    private static final String TAG = "Script-PerformanceTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f27047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, Long> f27048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, Object> f27049e;
    private boolean f;

    /* JADX INFO: compiled from: ScriptPerformanceTracker.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f27045a = new a(null);
    }

    public q(String r3) {
        d.h.b.o.e(r3, "eventName");
        this.f27046b = r3;
        this.f27047c = System.currentTimeMillis();
        this.f27048d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f27049e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final q a(String r2, long r3) {
        d.h.b.o.e(r2, "name");
        this.f27048d.put(r2 + "_duration", Long.valueOf(r3));
        return this;
    }

    public final q a(String r2, Object r3) {
        d.h.b.o.e(r2, "key");
        this.f27049e.put(r2, r3);
        return this;
    }

    public final q a(Map<String, ? extends Object> r3) {
        Map<? extends String, ? extends Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "values");
        this.f27049e.putAll(r4);
        return this;
    }

    public final q a(w.a r4) {
        if (r4 != null) goto L4;
        return this;
    L4:
        Integer r0 = r4.a();
        if (r0 == null) goto L7;
        a("script_version", Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue()));
    L7:
        Integer r5 = r4.b();
        if (r5 == null) goto L10;
        a("engine_version", Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue()));
    L10:
        return this;
    }

    public final void a() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L30
        Iterator r2 = a(this, 0, 1, null).entrySet().iterator();     // Catch: Exception -> L30
    L8:
        if (r2.hasNext() == false) goto L26;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
        Object r6 = r3.getValue();     // Catch: Exception -> L30
        if (ZeusTransformUtils.instanceOf(r6, String.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r6, Integer.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r6, Long.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r6, Boolean.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, List.class) == true) goto L23;
        r5.putOpt(r4, r6);     // Catch: Exception -> L30
        goto L8
    L23:
        r5.put(r4, new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L30
        goto L8
    L20:
        r5.put(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());     // Catch: Exception -> L30
        goto L8
    L17:
        r5.put(r4, ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Exception -> L30
        goto L8
    L14:
        r5.put(r4, ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L30
        goto L8
    L11:
        r5.put(r4, r6);     // Catch: Exception -> L30
        goto L8
    L26:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L28;
        Loog.INSTANCE.d(TAG, '[' + this.f27046b + "] " + r5);     // Catch: Exception -> L30
    L28:
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), this.f27046b, r5, false, false, null, 28, null);     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        com.obric.autogui.agents.scripted.b.f.f26914a.a(TAG, "Failed to report performance event=" + this.f27046b, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Map a(q r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = System.currentTimeMillis() - r0.f27047c;
    L6:
        return r0.a(r1);
    }

    private final Map<String, Object> a(long r2) {
        LinkedHashMap r3 = ao.d(new d.m[]{d.s.a("total_duration", Long.valueOf(r2))});
        r3.putAll(this.f27048d);
        r3.putAll(this.f27049e);
        return (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin");
    }
}
