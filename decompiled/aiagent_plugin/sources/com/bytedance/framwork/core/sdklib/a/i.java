package com.bytedance.framwork.core.sdklib.a;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f8640e;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.a.i$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkHelper.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: NetworkHelper.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static i f8641a;

        static /* synthetic */ i a() {
            return f8641a;
        }

        static {
            f8641a = new i(null);
        }
    }

    /* synthetic */ i(AnonymousClass1 r1) {
        this();
    }

    private i() {
        this.f8639d = null;
    }

    public static i a() {
        return a.a();
    }

    boolean a(byte[] r9) {
        if (r9 != null) goto L5;
    L60:
        return false;
    L5:
        if (r9.length == 0) goto L60;
        String r2 = b();     // Catch: Throwable -> L58
        com.bytedance.services.apm.api.c r10 = a(r2, r9);     // Catch: Throwable -> L58
        if (k.d() == false) goto L14;
        StringBuilder r3 = new StringBuilder().append("http result:");     // Catch: Throwable -> L58
        if (r10 != null) goto L12;
        Object r4 = -1;     // Catch: Throwable -> L58
    L13:
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", r3.append(r4).toString());     // Catch: Throwable -> L58
        goto L14
    L12:
        r4 = r10.a() + " header:" + r10.c();     // Catch: Throwable -> L58
    L14:
        this.f8636a = null;     // Catch: Throwable -> L58
        this.f8639d = null;     // Catch: Throwable -> L58
        boolean r5 = true;
        if (r10 != null) goto L17;
    L51:
        this.f8637b = true;     // Catch: Throwable -> L58
        Boolean r11 = this.f8640e;     // Catch: Throwable -> L58
        if (r11 != null) goto L54;
    L56:
        this.f8640e = true;     // Catch: Throwable -> L58
        return false;
    L54:
        if (r11.booleanValue() == false) goto L56;
        d.a().c();     // Catch: Throwable -> L58
        goto L56
    L17:
        if (r10.a() <= 0) goto L51;
        this.f8637b = false;     // Catch: Throwable -> L58
        if (500 <= r10.a()) goto L22;
    L30:
        JSONObject r6 = a(r10);     // Catch: Throwable -> L58
        if (r6 != null) goto L33;
    L49:
        this.f8640e = true;     // Catch: Throwable -> L58
        return false;
    L33:
        if (r10.a() != 200) goto L49;
        String r12 = r6.optString("message");     // Catch: Throwable -> L58
        String r7 = r6.optString("redirect");     // Catch: Throwable -> L58
        long r8 = r6.optLong("delay");     // Catch: Throwable -> L58
        if ("success".equals(r12) == false) goto L38;
        d.a().e();     // Catch: Throwable -> L58
        this.f8639d = r2;     // Catch: Throwable -> L58
        this.f8640e = false;     // Catch: Throwable -> L58
        boolean r13 = false;
    L42:
        this.f8636a = r7;     // Catch: Throwable -> L58
        if (r8 <= 0) goto L45;
        d.a().a(r8);     // Catch: Throwable -> L58
    L45:
        if (r13 == false) goto L47;
        d.a().g();     // Catch: Throwable -> L58
    L48:
        return r5;
    L47:
        d.a().h();     // Catch: Throwable -> L58
        goto L48
    L38:
        this.f8640e = true;     // Catch: Throwable -> L58
        r13 = "drop data".equals(r12);     // Catch: Throwable -> L58
        if (k.d() == false) goto L41;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "responseMessage:" + r12);     // Catch: Throwable -> L58
    L41:
        r5 = false;
        goto L42
    L22:
        if (r10.a() > 600) goto L30;
        Boolean r14 = this.f8640e;     // Catch: Throwable -> L58
        if (r14 != null) goto L26;
    L28:
        this.f8640e = true;     // Catch: Throwable -> L58
        return false;
    L26:
        if (r14.booleanValue() == false) goto L28;
        d.a().b();     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "sendLog failed.", th);
        goto L60
    }

    private JSONObject a(com.bytedance.services.apm.api.c r7) {
        JSONObject r2 = new JSONObject(new String(r7.b()));     // Catch: Exception -> L23
        Map<String, String> r8 = r7.c();     // Catch: Exception -> L23
        if (r8 != null) goto L6;
    L9:
        String r9 = null;
    L10:
        boolean r3 = true;
        String r4 = r2.optString("data");     // Catch: Throwable -> L21
        if (r4.isEmpty() == false) goto L14;
    L17:
        if (r3 == true) goto L20;
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L21
        r10.put("message", "success");     // Catch: Throwable -> L21
        return r10;
    L20:
        return r2;
    L14:
        if (TextUtils.isEmpty(r9) == true) goto L16;
        String r11 = com.bytedance.framwork.core.sdklib.b.b.a(r4.getBytes(), r9);     // Catch: Throwable -> L21
        r2 = new JSONObject(r11);     // Catch: Throwable -> L21
        r3 = true ^ TextUtils.isEmpty(r11);     // Catch: Throwable -> L21
        goto L17
    L16:
        r2 = new JSONObject(new String(r4.getBytes()));     // Catch: Throwable -> L21
    L21:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L23
        r12.put("message", "success");     // Catch: Exception -> L23
        return r12;
    L6:
        if (r8.isEmpty() == true) goto L9;
        r9 = (String) ZeusTransformUtils.preCheckCast(r8.get("ran"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
    L23:
        return null;
    }

    private String b() {
        List<String> r0 = d.a().j();
        if (TextUtils.isEmpty(this.f8636a) == true) goto L13;
        if (r0 != null) goto L7;
    L11:
        return null;
    L7:
        if (r0.size() <= 0) goto L11;
        return "https://" + this.f8636a + new URL((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.aiagent.plugin")).getPath();
    L13:
        if (TextUtils.isEmpty(this.f8639d) == true) goto L17;
        return this.f8639d;
    L17:
        if (this.f8637b == false) goto L19;
        this.f8638c++;
    L19:
        int r1 = r0.size();
        int r4 = this.f8638c;
        if (r1 <= r4) goto L23;
        if (r4 < 0) goto L23;
        return (String) ZeusTransformUtils.preCheckCast(r0.get(r4), String.class, "com.obric.aiagent.plugin");
    L23:
        this.f8638c = 0;
        return (String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.aiagent.plugin");
    }

    private com.bytedance.services.apm.api.c a(String r7, byte[] r8) {
        HashMap r6 = new HashMap();
        HashMap r0 = new HashMap(k.b());
        byte[] r1 = com.bytedance.framwork.core.sdkmonitor.g.a(r8, r6);     // Catch: Exception -> L5
    L6:
        if (r1 != null) goto L8;
        r1 = r8;
    L8:
        r6.put(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8");
        if (d.a().k() == false) goto L20;
        r1 = com.bytedance.frameworks.core.encrypt.b.a(r1, r1.length);
        if (r1 == null) goto L19;
        r0.put("tt_data", "a");
        String r9 = com.bytedance.apm6.util.k.a(r7, r0);
        r6.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (k.d() == false) goto L15;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "before encrypt url:" + r9);
    L15:
        LinkedList r2 = new LinkedList();
        String r10 = com.bytedance.frameworks.core.encrypt.a.a(r9, r2);
        if (k.d() == false) goto L18;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "after encrypt url:" + r10);
    L18:
        r6.putAll(com.bytedance.apm6.util.f.b(r2));
    L21:
        r6.put("Version-Code", "1");
        if (r1 == null) goto L26;
        r8 = r1;
    L26:
        if (k.d() == false) goto L29;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "http request:url:" + r10 + " headers:" + r6);
    L29:
        return k.a(r10, r6, r8);
    L19:
        r10 = com.bytedance.apm6.util.k.a(r7, r0);
        goto L21
    L20:
        r10 = com.bytedance.apm6.util.k.a(r7, r0);
    L5:
        r1 = null;
        goto L6
    }
}
