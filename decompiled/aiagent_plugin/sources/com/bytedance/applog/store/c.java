package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventMisc.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    private String u;
    private String v;

    @Override // com.bytedance.applog.store.a
    String h() {
        return "event_misc";
    }

    public c(String r1, String r2, JSONObject r3) {
        this.v = r2;
        this.u = r3.toString();
        this.m = r1;
    }

    @Override // com.bytedance.applog.store.a
    public List<String> e() {
        List<String> r3 = super.e();
        ArrayList r0 = new ArrayList(r3.size());
        r0.addAll(r3);
        r0.addAll(Arrays.asList(new String[]{"params", "varchar", "log_type", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.store.a
    public int a(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.aiagent.plugin");
        int r0 = super.a(r4);
        int r1 = r0 + 1;
        this.u = r4.getString(r0);
        int r2 = r1 + 1;
        this.v = r4.getString(r1);
        return r2;
    }

    @Override // com.bytedance.applog.store.a
    public void a(ContentValues r6) {
        super.a(r6);
        if (com.bytedance.applog.a.b.f5495a == false) goto L5;
        r6.put("params", com.bytedance.applog.a.a.a(this.m, com.bytedance.applog.monitor.v3.i.f5808c, this.v, this.u));
    L6:
        r6.put("log_type", this.v);
        return;
    L5:
        r6.put("params", this.u);
        goto L6
    }

    @Override // com.bytedance.applog.store.a
    public void a(JSONObject r3) {
        super.a(r3);
        r3.put("params", this.u);
        r3.put("log_type", this.v);
    }

    @Override // com.bytedance.applog.store.a
    public JSONObject f() {
        JSONObject r0 = new JSONObject();
        r0.put("local_time_ms", this.f5992b);
        r0.put("tea_event_index", this.f5993c);
        r0.put("session_id", this.f5994d);
        c(r0);
        if (TextUtils.isEmpty(this.g) == true) goto L5;
        r0.put("user_unique_id", this.g);
    L5:
        r0.put("log_type", this.v);
        JSONObject r3 = new JSONObject(this.u);     // Catch: Exception -> L14
        Iterator<String> r4 = r3.keys();     // Catch: Exception -> L14
    L7:
        if (r4.hasNext() == false) goto L17;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        Object r6 = r3.get(r5);     // Catch: Exception -> L14
        if (r0.opt(r5) == null) goto L12;
        q().c(4, this.t, "misc event exists key already!", new Object[0]);     // Catch: Exception -> L14
    L12:
        r0.put(r5, r6);     // Catch: Exception -> L14
    L17:
        if (this.q <= 0) goto L20;
        r0.put("event_id", this.q);
    L20:
        if (this.r <= 0) goto L23;
        r0.put("monitor_id", String.valueOf(this.r));
    L23:
        if (this.s <= 0) goto L25;
        r0.put("event_stained", this.s);
    L25:
        return r0;
    L14:
        e = move-exception;
        q().a(4, "parse misc event params failed", e, new Object[0]);
        goto L17
    }

    @Override // com.bytedance.applog.store.a
    public a b(JSONObject r3) {
        super.b(r3);
        this.u = r3.optString("params", null);
        this.v = r3.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.applog.store.a
    public String m() {
        return "param:" + this.u + " logType:" + this.v;
    }

    @Override // com.bytedance.applog.store.a
    public String n() {
        return this.u;
    }

    public String r() {
        return this.v;
    }
}
