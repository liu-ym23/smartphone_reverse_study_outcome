package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: Terminate.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends a {
    public Integer A;
    public String B;
    public long u;
    public long v;
    public String w;
    public Integer x;
    public String y;
    public String z;

    @Override // com.bytedance.applog.store.a
    public List<String> e() {
        return null;
    }

    @Override // com.bytedance.applog.store.a
    String h() {
        return "terminate";
    }

    public i() {
    }

    @Override // com.bytedance.applog.store.a
    public int a(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.aiagent.plugin");
        q().d(4, this.t, "read db not implemented", new Object[0]);
        return 0;
    }

    @Override // com.bytedance.applog.store.a
    public void a(ContentValues r4) {
        q().d(4, this.t, "write db not implemented", new Object[0]);
    }

    @Override // com.bytedance.applog.store.a
    public void a(JSONObject r4) {
        q().d(4, this.t, "write ipc not implemented", new Object[0]);
    }

    @Override // com.bytedance.applog.store.a
    public JSONObject f() {
        JSONObject r0 = new JSONObject();
        r0.put("local_time_ms", this.f5992b);
        r0.put("tea_event_index", this.f5993c);
        r0.put("session_id", this.f5994d);
        r0.put("stop_timestamp", this.v / 1000);
        r0.put("duration", this.u / 1000);
        r0.put("datetime", this.n);
        c(r0);
        if (TextUtils.isEmpty(this.g) == true) goto L6;
        r0.put("user_unique_id", this.g);
    L6:
        if (TextUtils.isEmpty(this.h) == true) goto L9;
        r0.put("ab_sdk_version", this.h);
    L9:
        if (TextUtils.isEmpty(this.w) == true) goto L13;
        r0.put("uuid_changed", true);
        if (TextUtils.equals(this.w, this.f5994d) == true) goto L13;
        r0.put("original_session_id", this.w);
    L13:
        Integer r1 = this.x;
        if (r1 == null) goto L17;
        r0.put("session_type", r1);
    L17:
        if (TextUtils.isEmpty(this.z) == true) goto L20;
        r0.put("from_session", this.z);
    L20:
        if (TextUtils.isEmpty(this.y) == true) goto L22;
        r0.put("to_session", this.y);
    L22:
        Integer r2 = this.A;
        if (r2 == null) goto L26;
        r0.put("bg_session", r2);
    L26:
        if (this.q <= 0) goto L29;
        r0.put("event_id", this.q);
    L29:
        if (this.r <= 0) goto L32;
        r0.put("monitor_id", String.valueOf(this.r));
    L32:
        if (this.s <= 0) goto L35;
        r0.put("event_stained", this.s);
    L35:
        if (TextUtils.isEmpty(this.B) == false) goto L48;
    L47:
        return r0;
    L48:
        JSONObject r3 = new JSONObject(this.B);     // Catch: Throwable -> L45
        Iterator<String> r4 = r3.keys();     // Catch: Throwable -> L45
    L38:
        if (r4.hasNext() == false) goto L47;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        if (r0.has(r5) == false) goto L42;
        q().c(4, this.t, "Add flat params to terminate conflict: {} - {}", new Object[]{r5, r3.opt(r5)});     // Catch: Throwable -> L45
        goto L38
    L42:
        r0.put(r5, r3.opt(r5));     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        q().a(4, this.t, "Add params to terminate error", th, new Object[0]);
        goto L47
    }

    @Override // com.bytedance.applog.store.a
    public a b(JSONObject r5) {
        q().d(4, this.t, "read ipc not implemented", new Object[0]);
        return this;
    }

    @Override // com.bytedance.applog.store.a
    public String m() {
        return String.valueOf(this.u);
    }
}
