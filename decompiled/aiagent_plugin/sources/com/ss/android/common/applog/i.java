package com.ss.android.common.applog;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventVerifyWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
public class i implements com.bytedance.applog.util.i, Runnable {
    private static final String TAG = "EventVerifyWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f37184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f37185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f37186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BlockingQueue<a> f37187e;
    private com.bytedance.common.utility.a.c f;

    /* JADX INFO: compiled from: EventVerifyWrapper.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f37188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONArray f37189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f37190c;

        public a(i r1, String r2, JSONArray r3) {
            this.f37190c = r1;
            this.f37188a = r2;
            this.f37189b = r3;
        }
    }

    public i() {
        this.f37184b = false;
        this.f37185c = 200;
        this.f37187e = new LinkedBlockingQueue();
    }

    @Override // java.lang.Runnable
    public void run() {
    L88:
    L75:
        th = move-exception;
        com.ss.android.common.util.e.b("EventVerifyWrapper out exception =", th);
        return;
    L4:
        if (Thread.interrupted() == true) goto L5;
        if (this.f37184b == false) goto L123;
        JSONObject r0 = com.ss.android.common.applog.a.x();     // Catch: Throwable -> L75
        if (r0 != null) goto L12;
    L80:
        Thread.sleep(1000);     // Catch: InterruptedException -> L78 Throwable -> L75
        goto L88
    L12:
        if (r0.isNull("device_id") == true) goto L80;
        if (TextUtils.isEmpty(this.f37183a) == true) goto L80;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f37187e.take(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L75
        r5.add(r1);     // Catch: Throwable -> L75
        this.f37187e.drainTo(r5);     // Catch: Throwable -> L75
        HashMap r2 = new HashMap();     // Catch: Throwable -> L75
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L75
    L18:
        if (r6.hasNext() == false) goto L86;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        if (r7 == null) goto L18;
        JSONArray r8 = r7.f37189b;     // Catch: Throwable -> L75
        if (r8 != null) goto L24;
    L49:
        r2.put(r7.f37188a, a((JSONArray) ZeusTransformUtils.preCheckCast(r2.get(r7.f37188a), JSONArray.class, "com.obric.aiagent.plugin"), r8));     // Catch: Throwable -> L75
        goto L18
    L24:
        if (r8.length() <= 0) goto L49;
        int r9 = 0;
    L27:
        if (r9 >= r8.length()) goto L49;
        JSONObject r10 = r8.optJSONObject(r9);     // Catch: Throwable -> L75
        if (r10 == null) goto L48;
        Iterator<String> r11 = r10.keys();     // Catch: Throwable -> L75
    L32:
        if (r11.hasNext() == false) goto L48;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r12) == true) goto L32;
        List<String> r13 = this.f37186d;     // Catch: Throwable -> L75
        if (r13 == null) goto L40;
        if (r13.contains(r12) == false) goto L40;
    L41:
        String r14 = r10.optString(r12);     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r14) == true) goto L32;
        if (r14.contains("?") == false) goto L32;
        com.ss.android.common.util.e.b("EventVerifyWrapper original value = " + r14);     // Catch: Throwable -> L75
        String r15 = Uri.encode(r14);     // Catch: Throwable -> L75
        com.ss.android.common.util.e.b("EventVerifyWrapper encode value = " + r15);     // Catch: Throwable -> L75
        r10.put(r12, r15);     // Catch: JSONException -> L79 Throwable -> L75
    L40:
        if (r12.contains("url") == false) goto L32;
    L48:
        r9 = r9 + 1;
        goto L27
    L86:
        String r16 = y.a(Uri.parse(this.f37183a).buildUpon().toString(), true);     // Catch: Throwable -> L63
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L63
        r17.put("header", com.ss.android.common.applog.a.x());     // Catch: Throwable -> L63
        r17.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Throwable -> L63
        r17.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L63
        r17.put("time_sync", com.ss.android.common.applog.a.a(null).A());     // Catch: Throwable -> L63
        Iterator r3 = r2.entrySet().iterator();     // Catch: Throwable -> L63
    L53:
        if (r3.hasNext() == false) goto L57;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        if (r4 == null) goto L53;
        r17.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), r4.getValue());     // Catch: Throwable -> L63
        goto L53
    L57:
        byte[] r18 = r17.toString().getBytes("UTF-8");     // Catch: Throwable -> L63
        Map<String, String> r19 = com.ss.android.common.applog.a.G();     // Catch: Throwable -> L63
        if (com.ss.android.common.applog.a.n() == false) goto L60;
        String r20 = y.a(com.ss.android.common.applog.a.N(), r16, r18, null, false, null, r19, null, false, false);     // Catch: Throwable -> L63
    L61:
        com.ss.android.common.util.e.b("EventVerifyWrapper send event verify resp: " + r20);     // Catch: Throwable -> L63
    L67:
        if (this.f37185c <= 0) goto L88;
        Thread.sleep(this.f37185c);     // Catch: InterruptedException -> L70 Throwable -> L75
    L70:
        e = move-exception;
        com.ss.android.common.util.e.e("EventVerifyWrapper wait next event verify exception", e);     // Catch: Throwable -> L75
        goto L88
    L60:
        r20 = y.a(com.ss.android.common.applog.a.N(), r16, r18, false, "application/octet-stream;tt-data=b", false, r19, false, false);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        com.ss.android.common.util.e.e("EventVerifyWrapper send event verify", th);     // Catch: Throwable -> L75
        goto L67
    L123:
        return;
    L5:
        com.ss.android.common.util.e.b("EventVerifyWrapper interrupted");     // Catch: Throwable -> L75
    }

    @Override // com.bytedance.applog.util.i
    public void putEvent(String r3, JSONArray r4) {
        if (this.f37184b == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.length() <= 0) goto L15;
        this.f37187e.add(new a(this, r3, r4));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.applog.util.i
    public boolean isEnable() {
        return this.f37184b;
    }

    @Override // com.bytedance.applog.util.i
    public void setEventVerifyUrl(String r2) {
        this.f37183a = r2 + "/service/2/app_log_test/";
    }

    @Override // com.bytedance.applog.util.i
    public void setEnable(boolean r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.f37184b != r3) goto L5;
        return;
    L5:
        this.f37184b = r3;
        if (this.f37184b == false) goto L8;
        com.bytedance.common.utility.a.c r6 = new com.bytedance.common.utility.a.c(this, TAG, true);
        this.f = r6;
        r6.a();
        return;
    L8:
        this.f = null;
    }

    private JSONArray a(JSONArray r2, JSONArray r3) {
        if (r3 != null) goto L4;
    L16:
        return r2;
    L4:
        if (r3.length() <= 0) goto L16;
        if (r2 != null) goto L8;
    L15:
        return r3;
    L8:
        if (r2.length() <= 0) goto L15;
        int r1 = 0;
    L12:
        if (r1 >= r3.length()) goto L14;
        r2.put(r3.optJSONObject(r1));
        r1 = r1 + 1;
        goto L12
    L14:
        return r2;
    }
}
