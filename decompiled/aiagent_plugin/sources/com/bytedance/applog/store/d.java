package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventV3.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    protected String u;
    protected boolean v;
    protected String w;
    public String x;

    @Override // com.bytedance.applog.store.a
    String h() {
        return "eventv3";
    }

    public void r() {
    }

    public d(String r1, String r2, boolean r3, String r4) {
        this.m = r1;
        this.w = r2;
        this.v = r3;
        this.u = r4;
        com.bytedance.applog.c r5 = com.bytedance.applog.b.b(r1);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.K() == null) goto L9;
        this.x = String.valueOf(r5.K());
        return;
    }

    public d(String r1, String r2) {
        this.m = r1;
        this.w = r2;
    }

    @Override // com.bytedance.applog.store.a
    public List<String> e() {
        List<String> r10 = super.e();
        ArrayList r0 = new ArrayList(r10.size());
        r0.addAll(r10);
        r0.addAll(Arrays.asList(new String[]{"event", "varchar", "params", "varchar", "is_bav", WsChannelMultiProcessSharedProvider.INT_TYPE, "disable_personalization", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.store.a
    public int a(Cursor r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.aiagent.plugin");
        int r0 = super.a(r5);
        int r1 = r0 + 1;
        this.w = r5.getString(r0);
        int r2 = r1 + 1;
        this.u = r5.getString(r1);
        int r3 = r2 + 1;
        boolean r6 = true;
        if (r5.getInt(r2) == 1) goto L6;
        r6 = false;
    L6:
        this.v = r6;
        int r7 = r3 + 1;
        this.x = r5.getString(r3);
        return r7;
    }

    @Override // com.bytedance.applog.store.a
    public void a(ContentValues r8) {
        super.a(r8);
        r8.put("event", this.w);
        if (this.v == false) goto L11;
        if (this.u != null) goto L11;
        r();     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        q().a(4, this.t, "write db failed", e, new Object[0]);
    L11:
        if (com.bytedance.applog.a.b.f5495a == false) goto L13;
        r8.put("params", com.bytedance.applog.a.a.a(this.m, com.bytedance.applog.monitor.v3.i.f5806a, this.w, this.u));
    L14:
        r8.put("is_bav", Integer.valueOf(this.v ? 1 : 0));
        r8.put("disable_personalization", this.x);
        return;
    L13:
        r8.put("params", this.u);
        goto L14
    }

    @Override // com.bytedance.applog.store.a
    public void a(JSONObject r3) {
        super.a(r3);
        r3.put("event", this.w);
        if (this.v == true) goto L5;
    L7:
        r3.put("params", this.u);
        r3.put("is_bav", this.v);
        r3.put("disable_personalization", this.x);
        return;
    L5:
        if (this.u != null) goto L7;
        r();
        goto L7
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
        r0.put("event", this.w);
        if (this.v == false) goto L9;
        r0.put("is_bav", 1);
    L9:
        if (TextUtils.isEmpty(this.u) == true) goto L12;
        r0.put("params", new JSONObject(this.u));
    L12:
        if (this.i == com.bytedance.common.utility.i.b.f6735a.a()) goto L14;
        r0.put("nt", this.i);
    L14:
        r0.put("datetime", this.n);
        if (TextUtils.isEmpty(this.h) == true) goto L18;
        r0.put("ab_sdk_version", this.h);
    L18:
        if (TextUtils.isEmpty(this.x) == true) goto L21;
        r0.put("disable_personalization", Integer.valueOf(this.x));
    L21:
        if (this.q <= 0) goto L24;
        r0.put("event_id", this.q);
    L24:
        if (this.r <= 0) goto L27;
        r0.put("monitor_id", String.valueOf(this.r));
    L27:
        if (this.s <= 0) goto L29;
        r0.put("event_stained", this.s);
    L29:
        return r0;
    }

    @Override // com.bytedance.applog.store.a
    public a b(JSONObject r4) {
        super.b(r4);
        this.w = r4.optString("event", null);
        this.u = r4.optString("params", null);
        this.v = r4.optBoolean("is_bav", false);
        this.x = r4.optString("disable_personalization", null);
        return this;
    }

    @Override // com.bytedance.applog.store.a
    public String m() {
        return this.w;
    }

    public String s() {
        return this.w;
    }

    @Override // com.bytedance.applog.store.a
    public String n() {
        return this.u;
    }

    public void a(com.bytedance.applog.priority.a r3) {
        if (r3 == null) goto L5;
        this.o = r3.a(this.w, this.u);
        return;
    }

    public void c(String r1) {
        this.u = r1;
    }
}
