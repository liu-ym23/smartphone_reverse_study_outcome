package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpDnsResolveCall.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements Callable<Void> {
    private static final String TAG = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f8520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f8522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f8523e;
    private a.EnumC0192a f;
    private int g;
    private final WeakHandler h;

    static {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return call2();
    }

    f(String r2, String r3, d r4, a.EnumC0192a r5, WeakHandler r6) {
        this.f8522d = new ArrayList();
        this.f8523e = new ArrayList();
        this.g = 0;
        this.f8521c = r2;
        this.f8519a = r3;
        this.f8520b = r4;
        this.f = r5;
        this.h = r6;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        String[] r0 = this.f8521c.split(",");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        String r3 = r0[r2];
        this.f8522d.add(r3);
        this.f8523e.add(r3);
        r2 = r2 + 1;
        goto L3
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "Start httpdns resolve for host : " + this.f8522d);
    L8:
        String r4 = e.getService().d();
        if (e.getService().e().size() != 0) goto L12;
        this.f8520b.e();
    L12:
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.a.a(r4) == true) goto L14;
    L18:
        String r5 = null;
    L20:
        if (r5 == null) goto L22;
        b(r5);
        this.f8520b.e();
    L38:
        Iterator<String> r6 = this.f8522d.iterator();
    L40:
        if (r6.hasNext() == false) goto L42;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        this.f8520b.f(r7);
        this.f8520b.a(r7);
        goto L40
    L42:
        Message r8 = Message.obtain();
        r8.obj = this;
        r8.what = 3;
        Bundle r9 = new Bundle();
        r9.putStringArrayList("httpdns_completed_hosts", (ArrayList) ZeusTransformUtils.preCheckCast(this.f8523e, ArrayList.class, "com.obric.aiagent.plugin"));
        r8.setData(r9);
        this.h.sendMessage(r8);
        if (Logger.debug() == false) goto L45;
        Logger.d(TAG, "send message to collect result handler for host : " + this.f8523e);
    L45:
        return null;
    L22:
        Iterator<String> r10 = e.getService().e().iterator();
    L24:
        if (r10.hasNext() == false) goto L38;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.c.d(r11) == true) goto L32;
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.c.c(r11) == true) goto L32;
        if (Logger.debug() == false) goto L24;
        Logger.d(TAG, "httpdns backup domian hardcode ip: " + r11 + " is invalid");
    L32:
        String r12 = a(r11);
        if (r12 != null) goto L37;
        if (Logger.debug() == false) goto L24;
        Logger.d(TAG, "httpdns request failed use hardcode ip: " + r11 + " try next hardcode ip");
        goto L24
    L37:
        b(r12);
        goto L38
    L14:
        if (this.f8520b.c().get() >= 2) goto L18;
        r5 = a(r4);
        if (r5 != null) goto L20;
        this.f8520b.d();
        goto L20
    }

    private String a(String r6) {
        StringBuilder r0 = new StringBuilder();
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.d.b().get() == true) goto L5;
        this.g = 1;
    L5:
        r0.append("https://").append(r6).append("/q?host=").append(this.f8521c).append("&").append("aid=").append(e.getService().c().b()).append("&").append("okhttp_version=").append(this.f8519a).append("&").append("p=").append("android").append("&").append("source=").append("tt-ok").append("&").append("f=").append(this.g).append("&").append("reason=").append(this.f.ordinal() - 1);
        if (this.f8520b.a().get() >= 3) goto L9;
        r0.append("&").append("refresh_bkup_ip=").append("1");
        this.f8520b.b();
    L9:
        return com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.b.a(r0.toString(), r6);
    }

    private void b(String r4) {
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "parseHttpDnsResponse");
    L26:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L22
        if (this.f8522d.size() <= 1) goto L17;
        JSONArray r5 = r0.optJSONArray("dns");     // Catch: JSONException -> L22
        if (r5 != null) goto L13;
        return;
    L13:
        int r1 = 0;
    L15:
        if (r1 >= r5.length()) goto L18;
        a(r5.optJSONObject(r1));     // Catch: JSONException -> L22
        r1 = r1 + 1;     // Catch: JSONException -> L22
    L18:
        JSONArray r3 = r0.optJSONArray("httpdns_backup_ip");     // Catch: JSONException -> L22
        if (r3 == null) goto L29;
        e.getService().a(r3);     // Catch: JSONException -> L22
        return;
    L29:
        return;
    L17:
        a(r0);     // Catch: JSONException -> L22
    L23:
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "httpdns server returned a invalid json response.");
        return;
    }

    private void a(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r0 = r10.optString("host");
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "parseSingleHostHttpDnsResponse for host " + r0);
    L7:
        int r7 = r10.optInt("ttl");
        JSONArray r11 = r10.optJSONArray("ips");
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        if (r11 == null) goto L23;
        int r1 = 0;
    L11:
        if (r1 >= r11.length()) goto L23;
        String r2 = r11.optString(r1);
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.c.c(r2) == false) goto L16;
        r6.add(r2);
    L21:
        r1 = r1 + 1;
        goto L11
    L16:
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.c.d(r2) == false) goto L19;
        r5.add(r2);
        goto L21
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "httpdns server returned a invalid address: " + r2);
    L23:
        if (this.f8522d.contains(r0) == true) goto L25;
        return;
    L25:
        if (r5.size() <= 0) goto L27;
    L28:
        this.f8520b.a(r0, new a(r0, System.currentTimeMillis(), r5, r6, r7));
        this.f8520b.f(r0);
        this.f8522d.remove(r0);
        return;
    L27:
        if (r6.size() > 0) goto L28;
    }
}
