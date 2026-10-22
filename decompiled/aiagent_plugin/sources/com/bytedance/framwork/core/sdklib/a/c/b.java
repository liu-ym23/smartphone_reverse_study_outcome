package com.bytedance.framwork.core.sdklib.a.c;

import android.content.Context;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.utility.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdklib.a.k;
import com.bytedance.framwork.core.sdkmonitor.g;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomExceptionHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f8597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f8599c;

    static /* synthetic */ void c(String r0, String r1, Throwable r2) {
        d(r0, r1, r2);
    }

    static {
        f8597a = new AtomicInteger(0);
        f8598b = true;
        f8599c = "https://mon.snssdk.com/monitor/collect/c/exception";
    }

    static void a(final String r2, final String r3, final Throwable r4) {
        if (f8598b == true) goto L5;
        return;
    L5:
        if (f8597a.get() >= 3) goto L10;
        f8597a.incrementAndGet();
        com.bytedance.framwork.core.sdklib.thread.a.a().a(new AnonymousClass1(r2, r3, r4));
        return;
    }

    private static void d(String r7, String r8, Throwable r9) {
        a r3 = new a("tag=" + r7 + " message=" + r8, r9);
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L8
        r10.put("event_type", "exception");     // Catch: Throwable -> L8
        r10.put(DBHelper.COL_TIME, System.currentTimeMillis());     // Catch: Throwable -> L8
        r10.put("stack", a(r3));     // Catch: Throwable -> L8
        r10.put("exception_type", 1);     // Catch: Throwable -> L8
        r10.put("message", r7 + "_" + r8);     // Catch: Throwable -> L8
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L8
        r4.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L8
        r10.put("filters", r4);     // Catch: Throwable -> L8
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L8
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L8
        r6.put(r10);     // Catch: Throwable -> L8
        r5.put("data", r6);     // Catch: Throwable -> L8
        JSONObject r11 = com.bytedance.framwork.core.sdklib.b.c.a(k.a());     // Catch: Throwable -> L8
        r11.put(WsConstants.KEY_APP_ID, "44444");     // Catch: Throwable -> L8
        r5.put("header", r11);     // Catch: Throwable -> L8
        if (k.d() == false) goto L6;
        b("APM-SDK", "tag:" + r7 + " message:" + r8, r3);     // Catch: Throwable -> L8
    L6:
        a(f8599c, r5.toString().getBytes());     // Catch: Throwable -> L8
        return;
    L9:
        if (k.d() == false) goto L14;
        b("APM-SDK", "tag:" + r7 + " message:" + r8, r3);
        return;
    }

    private static void a(String r5, byte[] r6) {
        if (i.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L5;
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.length == 0) goto L27;
        HashMap r0 = new HashMap();     // Catch: Throwable -> L17
        byte[] r7 = g.a(r6, r0);     // Catch: Throwable -> L17
        HashMap r2 = new HashMap(k.b());     // Catch: Throwable -> L17
        r2.put(WsConstants.KEY_APP_ID, "44444");     // Catch: Throwable -> L17
        String r8 = com.bytedance.apm6.util.k.a(r5, r2);     // Catch: Throwable -> L17
        if (k.d() == false) goto L15;
        com.bytedance.apm6.util.c.b.a("APM-SDK", "http request:url:" + r8);     // Catch: Throwable -> L17
    L15:
        k.a(r8, r0, r7);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (k.d() == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (k.d() == false) goto L24;
        com.bytedance.apm6.util.c.b.a("APM-SDK", "network unreachable");
        return;
    }

    private static String a(Throwable r2) {
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        r2.printStackTrace(r1);
        Throwable r3 = r2.getCause();
        if (r3 == null) goto L7;
        r3.printStackTrace(r1);
        Throwable r4 = r3.getCause();
        if (r4 == null) goto L7;
        r4.printStackTrace(r1);
    L7:
        String r5 = r0.toString();
        r1.close();
        return r5;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
