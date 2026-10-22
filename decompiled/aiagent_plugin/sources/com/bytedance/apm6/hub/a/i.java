package com.bytedance.apm6.hub.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SlardarHandlerConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements com.bytedance.apm6.consumer.slardar.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f5414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f5415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f5416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f5417e;
    String f;
    String g;
    String h;
    String i;
    private volatile com.bytedance.apm6.consumer.slardar.a.a j;
    private JSONObject k;

    static /* synthetic */ void a(i r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public i() {
        this.f5413a = "report_setting";
        this.f5414b = "enable_encrypt";
        this.f5415c = "hosts";
        this.f5416d = "apm6_once_max_size_kb";
        this.f5417e = "apm6_uploading_interval";
        this.f = "enable_report_internal_exception";
        this.g = "log_reserve_days";
        this.h = "log_max_size_mb";
        this.i = "compress_type";
        b();
    }

    public i(JSONObject r2) {
        this.f5413a = "report_setting";
        this.f5414b = "enable_encrypt";
        this.f5415c = "hosts";
        this.f5416d = "apm6_once_max_size_kb";
        this.f5417e = "apm6_uploading_interval";
        this.f = "enable_report_internal_exception";
        this.g = "log_reserve_days";
        this.h = "log_max_size_mb";
        this.i = "compress_type";
        this.k = r2;
        b();
    }

    private void b() {
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    private void a(JSONObject r14, boolean r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        JSONObject r16 = com.bytedance.apm6.util.e.a(r14, "general", "slardar_api_settings", this.f5413a);
        if (r16 != null) goto L7;
        return;
    L7:
        List<String> r1 = a(r16.optJSONArray(this.f5415c));
        ArrayList r2 = new ArrayList();
        String r4 = null;
        if (com.bytedance.apm6.util.f.a(r1) == true) goto L17;
        Iterator<String> r3 = r1.iterator();
        String r5 = null;
    L11:
        if (r3.hasNext() == false) goto L18;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        r2.add("https://" + r6 + "/monitor/collect/batch/");
        if (r4 != null) goto L15;
        r4 = "https://" + r6 + "/monitor/collect/c/exception";
    L15:
        if (r5 != null) goto L11;
        r5 = "https://" + r6 + "/monitor/collect/c/trace_collect";
    L18:
        boolean r7 = true;
        boolean r8 = r16.optBoolean(this.f5414b, true);
        long r9 = r16.optLong(this.f5416d, -1) * 1024;
        long r10 = r16.optLong(this.f5417e, -1) * 1000;
        if (com.bytedance.apm6.util.e.b(r14, "general", this.f) == 1) goto L22;
        r7 = false;
    L22:
        com.bytedance.apm6.consumer.slardar.a.a r11 = new com.bytedance.apm6.consumer.slardar.a.a();
        r11.a(r2);
        r11.a(r4);
        r11.b(r5);
        r11.a(r9);
        r11.a(r8);
        r11.b(r10);
        r11.b(r7);
        JSONObject r12 = this.k;
        if (r12 == null) goto L25;
        r11.d(r12.optInt("max_size_mb_today", -1));
    L25:
        r11.a(r16.optInt(this.i, 2));
        JSONObject r17 = r14.optJSONObject("general");
        if (r17 == null) goto L30;
        JSONObject r18 = r17.optJSONObject("cleanup");
        if (r18 == null) goto L30;
        r11.b(r18.optInt(this.h, 80));
        r11.c(r18.optInt(this.g, 5));
    L30:
        this.j = r11;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L33;
        com.bytedance.apm6.util.c.b.a("APM-Config", "received reportSetting=" + r16);
        com.bytedance.apm6.util.c.b.a("APM-Config", "parsed SlardarHandlerConfig=" + this.j);
    L33:
        com.bytedance.apm6.foundation.a.b.a(r7);
        com.bytedance.apm6.foundation.a.b.a(r4);
        com.bytedance.apm6.consumer.slardar.e.a().a(a());
        return;
    L17:
        r5 = null;
        goto L18
    }

    private static List<String> a(JSONArray r6) {
        if (r6 == null) goto L20;
    L15:
        e = move-exception;
        com.bytedance.apm6.util.c.b.b("APM-Setting", "parse setting host malformedurl exception", e);
    L17:
        e = move-exception;
        com.bytedance.apm6.util.c.b.b("APM-Setting", "parse setting host json exception", e);
        goto L20
    L5:
        if (r6.length() <= 0) goto L20;
        ArrayList r1 = new ArrayList(2);     // Catch: MalformedURLException -> L15 JSONException -> L17
        int r2 = r6.length();     // Catch: MalformedURLException -> L15 JSONException -> L17
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L14;
        String r4 = new URL(r6.getString(r3)).getHost();     // Catch: MalformedURLException -> L15 JSONException -> L17
        if (TextUtils.isEmpty(r4) == true) goto L13;
        if (r4.indexOf(46) <= 0) goto L13;
        r1.add(r4);     // Catch: MalformedURLException -> L15 JSONException -> L17
    L13:
        r3 = r3 + 1;
        goto L7
    L14:
        return r1;
    L20:
        return Collections.emptyList();
    }

    @Override // com.bytedance.apm6.consumer.slardar.a.b
    public com.bytedance.apm6.consumer.slardar.a.a a() {
        return this.j;
    }
}
