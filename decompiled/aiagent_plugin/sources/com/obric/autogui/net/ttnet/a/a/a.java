package com.obric.autogui.net.ttnet.a.a;

import com.bytedance.frameworks.baselib.network.http.c.d;
import com.bytedance.frameworks.baselib.network.http.c.e;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ExceptionAnalyseUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final JsonObject a(com.obric.autogui.net.ttnet.a.a.C0737a r6) {
        o.e(r6, "<this>");
        Throwable r0 = r6.a();
        JsonObject r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == true) goto L5;
        return null;
    L5:
        Object r1 = r6.b().get("cronet_request_log");
        if (ZeusTransformUtils.instanceOf(r1, JsonObject.class) == false) goto L8;
        JsonObject r3 = (JsonObject) ZeusTransformUtils.preCheckCast(r1, JsonObject.class, "com.obric.aiagent.plugin");
    L9:
        if (r3 == null) goto L18;
        return r3;
    L18:
        r2 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(r0, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).b(), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
    L13:
        if (r2 != null) goto L15;
        r2 = new JsonObject();
    L15:
        r6.b().put("cronet_request_log", r2);
        return r2;
    L8:
        r3 = null;
        goto L9
    }

    public static final boolean a(Throwable r1) {
        o.e(r1, "<this>");
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L5;
    L14:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, com.ttnet.org.chromium.net.o.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r1, e.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r1, d.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.common.utility.b.class) == true) goto L14;
        return false;
    }

    public static final int b(Throwable r3) {
        o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L6;
        return ((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).d();
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.ttnet.org.chromium.net.o.class) == false) goto L9;
        return ((com.ttnet.org.chromium.net.o) ZeusTransformUtils.preCheckCast(r3, com.ttnet.org.chromium.net.o.class, "com.obric.aiagent.plugin")).getCronetInternalErrorCode();
    L9:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L12;
        return ((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).a();
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.net.ttnet.b.b.class) == false) goto L25;
        int r0 = ((com.obric.autogui.net.ttnet.b.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.net.ttnet.b.b.class, "com.obric.aiagent.plugin")).b();
        if (r0 != 0) goto L26;
        Throwable r4 = ((com.obric.autogui.net.ttnet.b.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.net.ttnet.b.b.class, "com.obric.aiagent.plugin")).c();
        if (r4 != null) goto L19;
        return -1;
    L19:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.net.ttnet.b.b.class) == false) goto L21;
        return -1;
    L21:
        return b(r4);
    L26:
        return r0;
    L25:
        return -1;
    }

    public static final int c(Throwable r2) {
        o.e(r2, "<this>");
        if (ZeusTransformUtils.instanceOf(r2, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L6;
        return ((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(r2, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c();
    L6:
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L9;
        return ((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin")).a();
    L9:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.net.ttnet.b.b.class) == false) goto L16;
        Throwable r3 = ((com.obric.autogui.net.ttnet.b.b) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.net.ttnet.b.b.class, "com.obric.aiagent.plugin")).c();
        if (r3 != null) goto L13;
    L15:
        return -1;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.net.ttnet.b.b.class) == true) goto L15;
        return c(r3);
    L16:
        return 0;
    }
}
