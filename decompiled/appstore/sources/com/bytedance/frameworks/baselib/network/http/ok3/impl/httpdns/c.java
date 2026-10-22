package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t4.d;

/* JADX INFO: loaded from: classes.dex */
public class c implements Callable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7405i = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f7407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f7409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f7410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DnsRecord.CacheStaleReason f7411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakHandler f7413h;

    static {
    }

    public c(String r10, String r11, a r12, DnsRecord.CacheStaleReason r13, WeakHandler r14) {
        this.f7409d = new ArrayList();
        this.f7410e = new ArrayList();
        this.f7412g = 0;
        this.f7408c = r10;
        this.f7406a = r11;
        this.f7407b = r12;
        this.f7411f = r13;
        this.f7413h = r14;
    }

    public Void a() {
        String[] r10 = this.f7408c.split(",");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        String r13 = r10[r12];
        this.f7409d.add(r13);
        this.f7410e.add(r13);
        r12 = r12 + 1;
        goto L3
    L5:
        Logger.d(f7405i, "Start httpdns resolve for host : " + this.f7409d);
        String r14 = b.q().i();
        if (b.q().j().size() != 0) goto L9;
        this.f7407b.z();
    L9:
        if (t4.a.a(r14) == true) goto L11;
    L15:
        String r15 = null;
    L16:
        if (r15 == null) goto L18;
        c(r15);
        this.f7407b.z();
    L30:
        Iterator r16 = this.f7409d.iterator();
    L32:
        if (r16.hasNext() == false) goto L34;
        String r17 = (String) r16.next();
        this.f7407b.u(r17);
        this.f7407b.s(r17);
        goto L32
    L34:
        Message r18 = Message.obtain();
        r18.obj = this;
        r18.what = 3;
        Bundle r19 = new Bundle();
        r19.putStringArrayList("httpdns_completed_hosts", (ArrayList) this.f7410e);
        r18.setData(r19);
        this.f7413h.sendMessage(r18);
        Logger.d(f7405i, "send message to collect result handler for host : " + this.f7410e);
        return null;
    L18:
        Iterator r20 = b.q().j().iterator();
    L20:
        if (r20.hasNext() == false) goto L30;
        String r21 = (String) r20.next();
        if (t4.c.c(r21) == true) goto L26;
        if (t4.c.d(r21) == true) goto L26;
        Logger.d(f7405i, "httpdns backup domian hardcode ip: " + r21 + " is invalid");
    L26:
        String r22 = b(r21);
        if (r22 != null) goto L29;
        Logger.d(f7405i, "httpdns request failed use hardcode ip: " + r21 + " try next hardcode ip");
        goto L20
    L29:
        c(r22);
        goto L30
    L11:
        if (this.f7407b.j().get() >= 2) goto L15;
        r15 = b(r14);
        if (r15 != null) goto L16;
        this.f7407b.b();
        goto L16
    }

    public final String b(String r10) {
        StringBuilder r11 = new StringBuilder();
        if (d.b().get() == true) goto L5;
        this.f7412g = 1;
    L5:
        r11.append("https://");
        r11.append(r10);
        r11.append("/q?host=");
        r11.append(this.f7408c);
        r11.append("&");
        r11.append("aid=");
        r11.append(b.q().h().getAppId());
        r11.append("&");
        r11.append("okhttp_version=");
        r11.append(this.f7406a);
        r11.append("&");
        r11.append("p=");
        r11.append("android");
        r11.append("&");
        r11.append("source=");
        r11.append("tt-ok");
        r11.append("&");
        r11.append("f=");
        r11.append(this.f7412g);
        r11.append("&");
        r11.append("reason=");
        r11.append(this.f7411f.ordinal() - 1);
        if (this.f7407b.h().get() >= 3) goto L9;
        r11.append("&");
        r11.append("refresh_bkup_ip=");
        r11.append("1");
        this.f7407b.A();
    L9:
        return t4.b.a(r11.toString(), r10);
    }

    public final void c(String r10) {
        Logger.d(f7405i, "parseHttpDnsResponse");
    L20:
        Logger.d(f7405i, "httpdns server returned a invalid json response.");
        return;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return;
    L6:
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L20
        if (this.f7409d.size() <= 1) goto L15;
        JSONArray r12 = r11.optJSONArray("dns");     // Catch: JSONException -> L20
        if (r12 != null) goto L11;
        return;
    L11:
        int r13 = 0;
    L13:
        if (r13 >= r12.length()) goto L16;
        d(r12.optJSONObject(r13));     // Catch: JSONException -> L20
        r13 = r13 + 1;     // Catch: JSONException -> L20
    L16:
        JSONArray r14 = r11.optJSONArray("httpdns_backup_ip");     // Catch: JSONException -> L20
        if (r14 == null) goto L25;
        b.q().C(r14);     // Catch: JSONException -> L20
        return;
    L25:
        return;
    L15:
        d(r11);     // Catch: JSONException -> L20
        goto L16
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return a();
    }

    public final void d(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r11 = r10.optString("host");
        Logger.d(f7405i, "parseSingleHostHttpDnsResponse for host " + r11);
        int r12 = r10.optInt("ttl");
        JSONArray r13 = r10.optJSONArray("ips");
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        if (r13 == null) goto L18;
        int r16 = 0;
    L8:
        if (r16 >= r13.length()) goto L18;
        String r17 = r13.optString(r16);
        if (t4.c.d(r17) == false) goto L13;
        r15.add(r17);
    L16:
        r16 = r16 + 1;
        goto L8
    L13:
        if (t4.c.c(r17) == false) goto L15;
        r14.add(r17);
        goto L16
    L15:
        Logger.d(f7405i, "httpdns server returned a invalid address: " + r17);
    L18:
        if (this.f7409d.contains(r11) == true) goto L20;
        return;
    L20:
        if (r14.size() <= 0) goto L22;
    L23:
        this.f7407b.a(r11, new DnsRecord(r11, System.currentTimeMillis(), r14, r15, r12));
        this.f7407b.u(r11);
        this.f7409d.remove(r11);
        return;
    L22:
        if (r15.size() > 0) goto L23;
    }
}
