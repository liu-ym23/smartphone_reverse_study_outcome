package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {
    public String u;
    public String v;
    public String w;
    public String x;
    public long y;
    public long z;

    @Override // com.bytedance.applog.store.a
    String h() {
        return "event";
    }

    public b(String r3, String r4, String r5) {
        a(0);
        this.m = r3;
        this.u = r4;
        this.v = r5;
    }

    b() {
    }

    @Override // com.bytedance.applog.store.a
    public List<String> e() {
        List<String> r14 = super.e();
        ArrayList r0 = new ArrayList(r14.size());
        r0.addAll(r14);
        r0.addAll(Arrays.asList(new String[]{"category", "varchar", "tag", "varchar", "value", WsChannelMultiProcessSharedProvider.INT_TYPE, "ext_value", WsChannelMultiProcessSharedProvider.INT_TYPE, "params", "varchar", "label", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.store.a
    public int a(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.aiagent.plugin");
        int r0 = super.a(r6);
        int r1 = r0 + 1;
        this.u = r6.getString(r0);
        int r2 = r1 + 1;
        this.v = r6.getString(r1);
        int r3 = r2 + 1;
        this.y = r6.getLong(r2);
        int r4 = r3 + 1;
        this.z = r6.getLong(r3);
        int r7 = r4 + 1;
        this.x = r6.getString(r4);
        int r8 = r7 + 1;
        this.w = r6.getString(r7);
        return r8;
    }

    @Override // com.bytedance.applog.store.a
    public void a(ContentValues r6) {
        super.a(r6);
        r6.put("category", this.u);
        r6.put("tag", this.v);
        r6.put("value", Long.valueOf(this.y));
        r6.put("ext_value", Long.valueOf(this.z));
        if (com.bytedance.applog.a.b.f5495a == false) goto L5;
        r6.put("params", com.bytedance.applog.a.a.a(this.m, com.bytedance.applog.monitor.v3.i.f5807b, this.v, this.x));
    L6:
        r6.put("label", this.w);
        return;
    L5:
        r6.put("params", this.x);
        goto L6
    }

    @Override // com.bytedance.applog.store.a
    public void a(JSONObject r4) {
        super.a(r4);
        r4.put("tea_event_index", this.f5993c);
        r4.put("category", this.u);
        r4.put("tag", this.v);
        r4.put("value", this.y);
        r4.put("ext_value", this.z);
        r4.put("params", this.x);
        r4.put("label", this.w);
    }

    @Override // com.bytedance.applog.store.a
    public a b(JSONObject r7) {
        super.b(r7);
        this.f5993c = r7.optLong("tea_event_index", 0);
        this.u = r7.optString("category", null);
        this.v = r7.optString("tag", null);
        this.y = r7.optLong("value", 0);
        this.z = r7.optLong("ext_value", 0);
        this.x = r7.optString("params", null);
        this.w = r7.optString("label", null);
        return this;
    }

    @Override // com.bytedance.applog.store.a
    public JSONObject f() {
        if (TextUtils.isEmpty(this.x) == true) goto L5;
        JSONObject r0 = new JSONObject(this.x);
    L6:
        if (r0 != null) goto L8;
        r0 = new JSONObject();
    L8:
        r0.put("local_time_ms", this.f5992b);
        r0.put("tea_event_index", this.f5993c);
        r0.put("session_id", this.f5994d);
        c(r0);
        if (this.i == com.bytedance.common.utility.i.b.f6735a.a()) goto L12;
        r0.put("nt", this.i);
    L12:
        if (TextUtils.isEmpty(this.g) == true) goto L14;
        r0.put("user_unique_id", this.g);
    L14:
        r0.put("category", this.u);
        r0.put("tag", this.v);
        r0.put("value", this.y);
        r0.put("ext_value", this.z);
        r0.put("label", this.w);
        r0.put("datetime", this.n);
        if (TextUtils.isEmpty(this.h) == true) goto L18;
        r0.put("ab_sdk_version", this.h);
    L18:
        if (this.q <= 0) goto L21;
        r0.put("event_id", this.q);
    L21:
        if (this.r <= 0) goto L24;
        r0.put("monitor_id", String.valueOf(this.r));
    L24:
        if (this.s <= 0) goto L26;
        r0.put("event_stained", this.s);
    L26:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.applog.store.a
    public String m() {
        return "" + this.v + ", " + this.w;
    }

    @Override // com.bytedance.applog.store.a
    public String n() {
        return this.x;
    }
}
