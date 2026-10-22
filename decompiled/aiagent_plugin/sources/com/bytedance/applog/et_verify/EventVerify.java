package com.bytedance.applog.et_verify;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.c;
import com.bytedance.applog.k;
import com.bytedance.applog.log.f;
import com.bytedance.applog.util.i;
import com.bytedance.applog.util.m;
import com.bytedance.bdinstall.ar;
import com.bytedance.crash.general.HardwareInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EventVerify implements i, Runnable {
    private static final String TAG = "EventVerify";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f5622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f5624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Context f5625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f5626e;
    private final BlockingQueue<a> f;
    private final c g;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONArray f5631b;

        public a(String r1, JSONArray r2) {
            this.f5630a = r1;
            this.f5631b = r2;
        }

        public String toString() {
            return "EventItem{mEventType='" + this.f5630a + "', mEventJsonArray=" + this.f5631b + '}';
        }
    }

    static /* synthetic */ c a(EventVerify r0) {
        return r0.g;
    }

    public EventVerify(c r3) {
        this.f5623b = false;
        this.f5624c = 200;
        this.f5625d = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        this.f = new LinkedBlockingQueue();
        this.g = r3;
    }

    @Override // com.bytedance.applog.util.i
    public void putEvent(String r2, JSONArray r3) {
        a(new a(r2, r3));
    }

    public void putEvent(String r19, String r20, String r21, long r22, long r24, long r26, long r28, JSONObject r30) {
        if (r30 != null) goto L43;
    L7:
        JSONObject r12 = null;
    L8:
        if (r12 != null) goto L11;
        r12 = new JSONObject();
    L11:
        if ("event_v3".equals(r19) == false) goto L13;
        JSONObject r13 = new JSONObject();
        String r15 = "event_v3";
    L45:
        if ("event_v3".equals(r19) == true) goto L17;
        r13.put("category", r19);     // Catch: JSONException -> L41
        r13.put("tag", r20);     // Catch: JSONException -> L41
        if (TextUtils.isEmpty(r21) == true) goto L27;
        r13.put("label", r21);     // Catch: JSONException -> L41
    L27:
        if (r22 == 0) goto L30;
        r13.put("value", r22);     // Catch: JSONException -> L41
    L30:
        if (r24 == 0) goto L33;
        r13.put("ext_value", r24);     // Catch: JSONException -> L41
    L33:
        if (r26 <= 0) goto L35;
        r13.put("user_id", r26);     // Catch: JSONException -> L41
    L35:
        String r1 = this.g.o();     // Catch: JSONException -> L41
        if (TextUtils.isEmpty(r1) == true) goto L38;
        r13.put("user_unique_id", r1);     // Catch: JSONException -> L41
    L38:
        r13.put("session_id", this.g.u());     // Catch: JSONException -> L41
        r13.put("datetime", com.bytedance.applog.store.a.b(r28));     // Catch: JSONException -> L41
        goto L39
    L17:
        if (r12.has("nt") == false) goto L19;
        r13.put("nt", r12.optInt("nt"));     // Catch: JSONException -> L41
    L19:
        r12.remove("nt");     // Catch: JSONException -> L41
        r12.remove("_event_v3");     // Catch: JSONException -> L41
        if (r12.has("ab_sdk_version") == false) goto L22;
        r13.put("ab_sdk_version", r12.optString("ab_sdk_version"));     // Catch: JSONException -> L41
        r12.remove("ab_sdk_version");     // Catch: JSONException -> L41
    L22:
        r13.put("event", r20);     // Catch: JSONException -> L41
        r13.put("params", r12);     // Catch: JSONException -> L41
        r13.put("local_time_ms", r28);     // Catch: JSONException -> L41
    L39:
        JSONArray r2 = new JSONArray();
        r2.put(r13);
        a(new a(r15, r2));
        return;
    L13:
        r13 = r12;
        r15 = "event";
        goto L45
    L43:
        r12 = new JSONObject(r30.toString());     // Catch: JSONException -> L42
        goto L8
    }

    @Override // com.bytedance.applog.util.i
    public boolean isEnable() {
        return this.f5623b;
    }

    @Override // com.bytedance.applog.util.i
    public void setEventVerifyUrl(String r1) {
        f5622a = r1 + "/service/2/app_log_test/";
    }

    @Override // com.bytedance.applog.util.i
    public synchronized void setEnable(boolean r7, Context r8) {
        monitor-enter(this);
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        this.g.Z().b(6, "setEnable = {}", new Object[]{Boolean.valueOf(r7)});     // Catch: Throwable -> L29
        if (r9 != null) goto L6;
    L11:
        if (r7 == true) goto L21;
        BlockingQueue<a> r10 = this.f;     // Catch: Throwable -> L29
        monitor-enter(r10);     // Catch: Throwable -> L29
        this.f.clear();     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L21:
        if (this.f5623b != r7) goto L24;
        monitor-exit(this);
        return;
    L24:
        this.f5623b = r7;     // Catch: Throwable -> L29
        if (this.f5623b == false) goto L27;
        com.bytedance.applog.c.a.a().submit(this);     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);
        return;
    L6:
        if (this.f5625d != null) goto L11;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L10;
        r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
    L10:
        this.f5625d = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public void loginEtWithScheme(String r7, Context r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r7) == false) goto L14;
        this.g.Z().a(6, "login et", new RuntimeException("scheme is null"), new Object[0]);
        return;
    L14:
        Uri r10 = Uri.parse(r7);     // Catch: Throwable -> L9
        String r0 = r10.getQueryParameter("report_interval");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r0) == false) goto L16;
    L7:
        Uri.Builder r11 = Uri.parse(r10.getQueryParameter("callback_url")).buildUpon();     // Catch: Throwable -> L9
        r11.appendQueryParameter("app_id", this.g.j());     // Catch: Throwable -> L9
        r11.appendQueryParameter("device_id", this.g.l());     // Catch: Throwable -> L9
        r11.appendQueryParameter(HardwareInfo.KEY_HW_VENDOR_MODEL, Build.MODEL);     // Catch: Throwable -> L9
        final String r12 = r11.build().toString();     // Catch: Throwable -> L9
        com.bytedance.applog.c.a.b().submit(new AnonymousClass1(this, r12, r9));     // Catch: Throwable -> L9
        return;
    L16:
        setEventVerifyInterval(Long.parseLong(r0));     // Catch: NumberFormatException -> L13 Throwable -> L9
    L9:
        th = move-exception;
        this.g.Z().a(6, "login et", th, new Object[0]);
    }

    public void setEventVerifyInterval(long r3) {
        if (r3 < 0) goto L6;
        this.f5624c = r3;
        return;
    }

    public void setSpecialKeys(List<String> r3) {
        this.f5626e = new CopyOnWriteArrayList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.lang.Runnable
    public void run() {
    L3:
        int r3 = 0;
    L93:
        th = move-exception;
        this.g.Z().a(6, "out exception =", th, new Object[0]);
        return;
    L5:
        if (Thread.interrupted() == true) goto L6;
        if (this.f5623b == false) goto L138;
        JSONObject r4 = m.a(this.g.r());     // Catch: Throwable -> L93
        if (r4 == null) goto L100;
        if (r4.isNull("device_id") == true) goto L100;
        if (TextUtils.isEmpty(f5622a) == true) goto L100;
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f.take(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L93
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L93
        r7.add(r0);     // Catch: Throwable -> L93
        BlockingQueue<a> r8 = this.f;     // Catch: Throwable -> L93
        monitor-enter(r8);     // Catch: Throwable -> L93
        this.f.drainTo(r7);     // Catch: Throwable -> L87
        monitor-exit(r8);     // Catch: Throwable -> L87
        HashMap r1 = new HashMap();     // Catch: Throwable -> L93
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L93
    L23:
        if (r9.hasNext() == false) goto L103;
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L93
        if (r10 == null) goto L55;
        JSONArray r11 = r10.f5631b;     // Catch: Throwable -> L93
        if (r11 != null) goto L29;
    L54:
        r1.put(r10.f5630a, a((JSONArray) ZeusTransformUtils.preCheckCast(r1.get(r10.f5630a), JSONArray.class, "com.obric.aiagent.plugin"), r11));     // Catch: Throwable -> L93
        goto L55
    L29:
        if (r11.length() <= 0) goto L54;
        int r12 = r3;
    L32:
        if (r12 >= r11.length()) goto L54;
        JSONObject r13 = r11.optJSONObject(r12);     // Catch: Throwable -> L93
        if (r13 == null) goto L53;
        Iterator<String> r14 = r13.keys();     // Catch: Throwable -> L93
    L37:
        if (r14.hasNext() == false) goto L53;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r5) == true) goto L52;
        List<String> r6 = this.f5626e;     // Catch: Throwable -> L93
        if (r6 == null) goto L45;
        if (r6.contains(r5) == false) goto L45;
    L46:
        String r15 = r13.optString(r5);     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r15) == true) goto L52;
        if (r15.contains("?") == false) goto L52;
        f r16 = this.g.Z();     // Catch: Throwable -> L93
        Object[] r2 = new Object[1];     // Catch: Throwable -> L93
        r2[r3] = r15;     // Catch: Throwable -> L93
        r16.c(6, "original value = {}", r2);     // Catch: Throwable -> L93
        String r17 = Uri.encode(r15);     // Catch: Throwable -> L93
        this.g.Z().c(6, "encode value = {}", new Object[]{r17});     // Catch: Throwable -> L93
        r13.put(r5, r17);     // Catch: JSONException -> L97 Throwable -> L93
    L45:
        if (r5.contains("url") == true) goto L46;
    L52:
        r3 = 0;
    L53:
        r12 = r12 + 1;
        r3 = 0;
    L55:
        r3 = 0;
        goto L23
    L103:
        String r18 = this.g.a(this.f5625d, Uri.parse(f5622a).buildUpon().toString(), true, ar.f6144a);     // Catch: Throwable -> L77
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L77
        Iterator r20 = r1.entrySet().iterator();     // Catch: Throwable -> L77
    L58:
        if (r20.hasNext() == false) goto L62;
        Map.Entry r21 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L77
        if (r21 == null) goto L58;
        r19.put((String) ZeusTransformUtils.preCheckCast(r21.getKey(), String.class, "com.obric.aiagent.plugin"), r21.getValue());     // Catch: Throwable -> L77
        goto L58
    L62:
        k r22 = this.g.s();     // Catch: Throwable -> L77
        if (r22 != null) goto L98;
    L69:
        r19.put("header", r4);     // Catch: Throwable -> L77
        r19.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Throwable -> L77
        r19.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L77
        r19.put("time_sync", this.g.V().f5671a);     // Catch: Throwable -> L77
        byte[] r23 = r19.toString().getBytes("UTF-8");     // Catch: Throwable -> L77
        String r24 = null;
        if (this.g.k() == false) goto L74;
        JSONObject r25 = this.g.V().a(r18, r19);     // Catch: Throwable -> L77
        if (r25 == null) goto L75;
        r24 = r25.toString();     // Catch: Throwable -> L77
    L75:
        this.g.Z().c(6, "send event verify resp: {}", new Object[]{r24});     // Catch: Throwable -> L77
    L81:
        if (this.f5624c <= 0) goto L3;
        Thread.sleep(this.f5624c);     // Catch: InterruptedException -> L84 Throwable -> L93
    L84:
        e = move-exception;
        this.g.Z().a(6, "wait next event verify exception", e, new Object[0]);     // Catch: Throwable -> L93
        goto L3
    L74:
        r24 = this.g.q().a(r18, r23, "application/json; charset=utf-8");     // Catch: Throwable -> L77
        goto L75
    L98:
        r22.a(r4);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        this.g.Z().a(6, "send event verify", th, new Object[0]);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        this.g.Z().a(6, "send event verify", th, new Object[0]);     // Catch: Throwable -> L93
        goto L81
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L93
    L100:
        Thread.sleep(1000);     // Catch: InterruptedException -> L96 Throwable -> L93
        goto L3
    L138:
        return;
    L6:
        this.g.Z().e(6, "interrupted", new Object[0]);     // Catch: Throwable -> L93
    }

    private void a(a r8) {
        BlockingQueue<a> r0 = this.f;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f.size() < 1000) goto L7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f.poll(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        this.g.Z().d(6, "event item cache poll drop: {}", new Object[]{r1});     // Catch: Throwable -> L10
    L7:
        this.f.add(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
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
