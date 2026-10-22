package com.obric.aiagent.ttnet.c;

import com.obric.aiagent.platform.depend.AppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.ttnet.c;
import com.obric.autogui.common.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetHookLogManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "TTENT_MONITOR_PROCESS_HOOK";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<c, Long> f22224b = null;

    private b() {
    }

    static {
        f22223a = new b();
        f22224b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final void a(c r5) {
        o.e(r5, "biz");
        ILogDepend.Companion.i(TAG, "onNetworkError: biz=" + r5.a() + ", time=" + System.currentTimeMillis());
        f22224b.put(r5, Long.valueOf(System.currentTimeMillis()));
        com.obric.aiagent.os.libs.a.a().d();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (AppContext.INSTANCE.isDebug() == true) goto L10;
        ILogDepend.Companion.e(TAG, "reportAssistantFailure error", th);
        return;
    L10:
        throw th;
    }

    public final void a(Long r4, Long r5, String r6, String r7, String r8, Integer r9, JSONObject r10) {
        o.e(r10, "extJson");
        if (a() == true) goto L5;
        return;
    L5:
        boolean r3 = com.obric.aiagent.utils.a.b.f22307a.a();
        ILogDepend.Companion.i(TAG, "ERROR BIZ: " + f22224b);
        ILogDepend.Companion.i(TAG, "【API_OK】ttent msg: isScreenOn=" + r3 + ", sendDuration=" + r4 + ", sentTime=" + r5 + ", sendUrl=" + r6 + ", sendIp=" + r7 + ", traceCode=" + r8 + ", status=" + r9);
    }

    public final void b(Long r4, Long r5, String r6, String r7, String r8, Integer r9, JSONObject r10) {
        o.e(r10, "extJson");
        if (a() == true) goto L5;
        return;
    L5:
        boolean r3 = com.obric.aiagent.utils.a.b.f22307a.a();
        ILogDepend.Companion.i(TAG, "ERROR BIZ: " + f22224b);
        ILogDepend.Companion.i(TAG, "【API_ERROR】ttent msg: isScreenOn=" + r3 + ", sendDuration=" + r4 + ", sentTime=" + r5 + ", sendUrl=" + r6 + ", sendIp=" + r7 + ", traceCode=" + r8 + ", status=" + r9);
    }

    private final boolean a() {
        boolean r0 = false;
        if (d.f28974a.ab() == true) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<c, Long>> r5 = f22224b.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if ((System.currentTimeMillis() - r1) >= 5000) goto L7;
        r0 = true;
        goto L7
    L11:
        return r0;
    }
}
