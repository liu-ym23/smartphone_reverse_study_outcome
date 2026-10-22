package com.bytedance.apm6.foundation.a;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm6.util.d;
import com.bytedance.apm6.util.e;
import com.bytedance.apm6.util.k;
import com.bytedance.common.utility.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.RomInfo;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomExceptionHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "APM-CustomException";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f5329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f5331c;

    static /* synthetic */ void c(String r0, String r1, Throwable r2) {
        d(r0, r1, r2);
    }

    static {
        f5329a = new AtomicInteger(0);
        f5330b = true;
    }

    public static void a(boolean r0) {
        f5330b = r0;
    }

    public static void a(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        f5331c = r1;
        return;
    }

    static void a(final String r2, final String r3, final Throwable r4) {
        com.bytedance.apm.h.a.a(r2, r3);
        if (f5330b == true) goto L5;
        return;
    L5:
        if (f5329a.get() >= 3) goto L10;
        f5329a.incrementAndGet();
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5473a).a(new AnonymousClass1(r2, r3, r4));
        return;
    }

    private static void d(String r5, String r6, Throwable r7) {
        a r1 = new a("tag=" + r5 + " message=" + r6, r7);
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L11
        r8.put("event_type", "exception");     // Catch: Throwable -> L11
        r8.put(DBHelper.COL_TIME, System.currentTimeMillis());     // Catch: Throwable -> L11
        r8.put("stack", a(r1));     // Catch: Throwable -> L11
        r8.put("exception_type", 1);     // Catch: Throwable -> L11
        r8.put("message", r5 + "_" + r6);     // Catch: Throwable -> L11
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L11
        r2.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L11
        r2.put("host_aid", String.valueOf(com.bytedance.apm6.foundation.context.a.g()));     // Catch: Throwable -> L11
        r8.put("filters", r2);     // Catch: Throwable -> L11
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L11
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L11
        r4.put(r8);     // Catch: Throwable -> L11
        r3.put("data", r4);     // Catch: Throwable -> L11
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L11
        e.a(r9, com.bytedance.apm6.foundation.context.a.o());     // Catch: Throwable -> L11
        com.bytedance.apm6.foundation.context.b r10 = com.bytedance.apm6.foundation.context.a.b();     // Catch: Throwable -> L11
        if (r10 == null) goto L6;
        e.a(r9, r10.q());     // Catch: Throwable -> L11
    L6:
        r9.put(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Throwable -> L11
        r9.put(WsConstants.KEY_APP_ID, 2085);     // Catch: Throwable -> L11
        r9.put("device_id", com.bytedance.apm6.foundation.context.a.p());     // Catch: Throwable -> L11
        r9.put("channel", com.bytedance.apm6.foundation.context.a.h());     // Catch: Throwable -> L11
        r9.put("version_code", com.bytedance.apm6.foundation.context.a.k());     // Catch: Throwable -> L11
        r9.put("update_version_code", com.bytedance.apm6.foundation.context.a.i());     // Catch: Throwable -> L11
        r9.put("device_id", com.bytedance.apm6.foundation.context.a.p());     // Catch: Throwable -> L11
        r9.put("uid", com.bytedance.apm6.foundation.context.a.r());     // Catch: Throwable -> L11
        r9.put("process_name", com.bytedance.apm6.foundation.context.a.f());     // Catch: Throwable -> L11
        r3.put("header", r9);     // Catch: Throwable -> L11
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        b(TAG, "tag:" + r5 + " message:" + r6, r1);     // Catch: Throwable -> L11
    L9:
        a(f5331c, r3.toString().getBytes());     // Catch: Throwable -> L11
        return;
    }

    private static void a(String r3, byte[] r4) {
        if (i.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")) == false) goto L5;
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.length == 0) goto L27;
        com.bytedance.apm6.service.c.a r5 = b(r3, r4);     // Catch: Throwable -> L17
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L15;
        com.bytedance.apm6.util.c.b.a(TAG, "http request:url:" + r5.f5447a + " headers:" + r5.f5448b);     // Catch: Throwable -> L17
    L15:
        com.bytedance.apm6.foundation.context.a.a(r5.f5447a, r5.f5448b, r5.f5449c);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L24;
        com.bytedance.apm6.util.c.b.a(TAG, "network unreachable");
        return;
    }

    private static com.bytedance.apm6.service.c.a b(String r4, byte[] r5) {
        HashMap r0 = new HashMap();
        if (r5.length <= 128) goto L7;
        byte[] r1 = a(r5);     // Catch: IOException -> L8
        r0.put(DownloadHelper.CONTENT_ENCODING, DownloadHelper.GZIP);     // Catch: IOException -> L8
        r5 = r1;
    L7:
        return new com.bytedance.apm6.service.c.a(k.a(r4, com.bytedance.apm6.foundation.context.a.t()), r0, r5);
    }

    private static byte[] a(byte[] r3) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = null;
        GZIPOutputStream r2 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r2.write(r3);     // Catch: Throwable -> L7
        d.a(r2);
        return r0.toByteArray();
    L7:
        th = th;
        r1 = r2;
    L10:
        d.a(r1);
        throw th;
    L9:
        th = th;
        goto L10
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
