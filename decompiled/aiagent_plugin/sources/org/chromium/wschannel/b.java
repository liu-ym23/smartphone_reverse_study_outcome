package org.chromium.wschannel;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: DestroyTimeoutControl.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {
    private static final String TAG = "CronetFrontierConnection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f40554a = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f40555d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f40556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f40557c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f40558e;

    static {
    }

    public b(Map<String, Object> r12, boolean r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        this.f40558e = true;
        if (g.m() <= 0) goto L5;
        f40554a = g.m();
        long r5 = a(r14, "destroy_timeout_millis", 0);
        if (r5 < 1000) goto L11;
        f40555d = true;
        if (r13 == false) goto L20;
        this.f40556b = r5 - f40554a;
        if (Logger.debug() == false) goto L39;
        Logger.d(TAG, "Destroy ws timeout: " + this.f40556b);
        return;
    L39:
        return;
    L20:
        long r15 = a(r14, "fallback_timeout_mills", 10000);
        if (Logger.debug() == false) goto L24;
        Logger.d(TAG, "fallback timeout:" + r15 + " destroy timeout:" + r5);
    L24:
        if (r15 < r5) goto L30;
        this.f40558e = false;
        if (Logger.debug() == false) goto L28;
        Logger.d(TAG, "Disable fallback to websocket, fallback >= destroy timeout");
    L28:
        this.f40557c = r5 - f40554a;
        return;
    L30:
        long r7 = f40554a;
        this.f40557c = r15 - r7;
        long r6 = (r5 - r15) - r7;
        this.f40556b = r6;
        if (r6 < 0) goto L33;
        return;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "Disable fallback to websocket, timeout <= 0:" + this.f40556b);
    L35:
        this.f40558e = false;
        return;
    L11:
        if (Logger.debug() == false) goto L38;
        Logger.d(TAG, "Destroy timeout disable: " + r5);
        return;
    L38:
        return;
    L5:
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Destroy delta disable: " + g.m());
        return;
    }

    public boolean a() {
        if (f40555d == true) goto L7;
        return true;
    L7:
        return this.f40558e;
    }

    public long b() {
        if (f40555d == true) goto L7;
        return 0;
    L7:
        return this.f40557c;
    }

    public long c() {
        if (f40555d == true) goto L7;
        return 0;
    L7:
        return this.f40556b;
    }

    private static long a(Map<String, Object> r2, String r3, long r4) {
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin")).get(WsConstants.KEY_HEADERS), Map.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return r4;
    L5:
        if (r5.isEmpty() == false) goto L8;
        return r4;
    L8:
        if (r5.containsKey(r3) == true) goto L10;
        return r4;
    L10:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(r3), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r6) == false) goto L18;
        return r4;
    L18:
        int r7 = Integer.valueOf(r6).intValue();     // Catch: Exception -> L17
        if (r7 > 0) goto L16;
        return r4;
    L16:
        return r7;
    L23:
        return r4;
    }

    public static boolean a(String r2, boolean r3) {
        if (f40555d == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        if (r3 == false) goto L16;
        if (r2.contains("\\\"net_error\\\":-7") == true) goto L12;
        return false;
    L12:
        if (r2.contains("WebSocket opening handshake timed out") == true) goto L14;
        return false;
    L14:
        return true;
    L16:
        if (r2.contains("\"error_code\":-193") == true) goto L22;
        if (r2.contains("\"error_code\":-356") == true) goto L20;
        return false;
    L20:
        if (r2.contains("\\\"internal_error\\\":67") == true) goto L22;
        return false;
    L22:
        return true;
    }
}
