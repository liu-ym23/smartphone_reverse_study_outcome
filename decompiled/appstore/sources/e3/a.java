package e3;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.foundation.safety.ApmInternalException;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.d;
import r3.e;
import r3.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicInteger f19282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f19283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f19284c;

    /* JADX INFO: renamed from: e3.a$a, reason: collision with other inner class name */
    public static class C0239a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f19285d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f19286e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Throwable f19287f;

        public C0239a(String r10, String r11, Throwable r12) {
            this.f19285d = r10;
            this.f19286e = r11;
            this.f19287f = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f19285d, this.f19286e, this.f19287f);
        }
    }

    static {
        f19282a = new AtomicInteger(0);
        f19283b = true;
    }

    public static /* synthetic */ void a(String r10, String r11, Throwable r12) {
        e(r10, r11, r12);
    }

    public static byte[] b(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r12 = null;
        GZIPOutputStream r13 = new GZIPOutputStream(r11);     // Catch: Throwable -> L9
        r13.write(r10);     // Catch: Throwable -> L7
        d.a(r13);
        return r11.toByteArray();
    L7:
        th = th;
        r12 = r13;
    L10:
        d.a(r12);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static p3.a c(String r10, byte[] r11) {
        HashMap r12 = new HashMap();
        if (r11.length <= 128) goto L7;
        byte[] r13 = b(r11);     // Catch: IOException -> L8
        r12.put("Content-Encoding", "gzip");     // Catch: IOException -> L8
        r11 = r13;
    L7:
        return new p3.a(j.a(r10, d3.a.w()), r12, r11);
    }

    public static String d(Throwable r10) {
        StringWriter r11 = new StringWriter();
        PrintWriter r12 = new PrintWriter(r11);
        r10.printStackTrace(r12);
        Throwable r13 = r10.getCause();
        if (r13 == null) goto L7;
        r13.printStackTrace(r12);
        Throwable r14 = r13.getCause();
        if (r14 == null) goto L7;
        r14.printStackTrace(r12);
    L7:
        String r15 = r11.toString();
        r12.close();
        return r15;
    }

    public static void e(String r10, String r11, Throwable r12) {
        ApmInternalException r13 = new ApmInternalException("tag=" + r10 + " message=" + r11, r12);
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L11
        r14.put("event_type", "exception");     // Catch: Throwable -> L11
        r14.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L11
        r14.put("stack", d(r13));     // Catch: Throwable -> L11
        r14.put("exception_type", 1);     // Catch: Throwable -> L11
        r14.put("message", r10 + "_" + r11);     // Catch: Throwable -> L11
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L11
        r15.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L11
        r15.put("host_aid", String.valueOf(d3.a.h()));     // Catch: Throwable -> L11
        r14.put("filters", r15);     // Catch: Throwable -> L11
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L11
        JSONArray r17 = new JSONArray();     // Catch: Throwable -> L11
        r17.put(r14);     // Catch: Throwable -> L11
        r16.put("data", r17);     // Catch: Throwable -> L11
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L11
        e.a(r18, d3.a.t());     // Catch: Throwable -> L11
        ApmContextAdapter r19 = d3.a.i();     // Catch: Throwable -> L11
        if (r19 == null) goto L6;
        e.a(r18, r19.getDynamicHeaderExtras());     // Catch: Throwable -> L11
    L6:
        r18.put("os", "Android");     // Catch: Throwable -> L11
        r18.put("aid", 2085);     // Catch: Throwable -> L11
        r18.put("device_id", d3.a.n());     // Catch: Throwable -> L11
        r18.put("channel", d3.a.k());     // Catch: Throwable -> L11
        r18.put("version_code", d3.a.y());     // Catch: Throwable -> L11
        r18.put("update_version_code", d3.a.v());     // Catch: Throwable -> L11
        r18.put("device_id", d3.a.n());     // Catch: Throwable -> L11
        r18.put("uid", d3.a.x());     // Catch: Throwable -> L11
        r18.put("process_name", d3.a.m());     // Catch: Throwable -> L11
        r16.put("header", r18);     // Catch: Throwable -> L11
        if (r3.a.c() == false) goto L9;
        Log.e("APM-CustomException", "tag:" + r10 + " message:" + r11, r13);     // Catch: Throwable -> L11
    L9:
        g(f19284c, r16.toString().getBytes());     // Catch: Throwable -> L11
        return;
    }

    public static void f(String r10, String r11, Throwable r12) {
        s1.a.a(r10, r11);
        if (f19283b == true) goto L5;
        return;
    L5:
        if (f19282a.get() >= 3) goto L10;
        f19282a.incrementAndGet();
        u3.b.a(AsyncTaskManagerType.IO).c(new C0239a(r10, r11, r12));
        return;
    }

    public static void g(String r10, byte[] r11) {
        if (NetworkUtils.l(r3.a.b()) == false) goto L5;
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.length == 0) goto L28;
        p3.a r12 = c(r10, r11);     // Catch: Throwable -> L15
        if (r3.a.c() == false) goto L17;
        s3.a.a("APM-CustomException", "http request:url:" + r12.f23320a + " headers:" + r12.f23321b);     // Catch: Throwable -> L15
    L17:
        d3.a.g(r12.f23320a, r12.f23321b, r12.f23322c);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        if (r3.a.c() == false) goto L27;
        th.printStackTrace();
        return;
    L27:
        return;
    L28:
        return;
    L5:
        if (r3.a.c() == false) goto L25;
        s3.a.a("APM-CustomException", "network unreachable");
        return;
    }

    public static void h(boolean r10) {
        f19283b = r10;
    }

    public static void i(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        f19284c = r10;
        return;
    }
}
