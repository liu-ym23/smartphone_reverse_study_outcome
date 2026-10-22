package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: Launch.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    public long u;
    public String v;
    public boolean w;
    public String x;
    public String y;

    @Override // com.bytedance.applog.store.a
    String h() {
        return "launch";
    }

    public f() {
    }

    @Override // com.bytedance.applog.store.a
    public List<String> e() {
        List<String> r12 = super.e();
        ArrayList r0 = new ArrayList(r12.size());
        r0.addAll(r12);
        r0.addAll(Arrays.asList(new String[]{"ver_name", "varchar", "ver_code", WsChannelMultiProcessSharedProvider.INT_TYPE, "last_session", "varchar", "is_background", WsChannelMultiProcessSharedProvider.INT_TYPE, "flat_params", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.store.a
    public int a(Cursor r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.aiagent.plugin");
        int r0 = super.a(r5);
        int r1 = r0 + 1;
        this.v = r5.getString(r0);
        int r2 = r1 + 1;
        this.u = r5.getLong(r1);
        int r3 = r2 + 1;
        this.x = r5.getString(r2);
        int r6 = r3 + 1;
        boolean r7 = true;
        if (r5.getInt(r3) == 1) goto L6;
        r7 = false;
    L6:
        this.w = r7;
        int r8 = r6 + 1;
        this.y = r5.getString(r6);
        return r8;
    }

    @Override // com.bytedance.applog.store.a
    public void a(ContentValues r3) {
        super.a(r3);
        r3.put("ver_name", this.v);
        r3.put("ver_code", Long.valueOf(this.u));
        r3.put("last_session", this.x);
        r3.put("is_background", Integer.valueOf(this.w ? 1 : 0));
        r3.put("flat_params", this.y);
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
        c(r0);
        if (TextUtils.isEmpty(this.g) == true) goto L6;
        r0.put("user_unique_id", this.g);
    L6:
        if (this.w == false) goto L8;
        r0.put("is_background", true);
    L8:
        r0.put("datetime", this.n);
        if (TextUtils.isEmpty(this.h) == true) goto L12;
        r0.put("ab_sdk_version", this.h);
    L12:
        if (TextUtils.isEmpty(this.x) == true) goto L15;
        r0.put("uuid_changed", true);
        r0.put("original_session_id", this.x);
    L15:
        if (this.q <= 0) goto L18;
        r0.put("event_id", this.q);
    L18:
        if (this.r <= 0) goto L21;
        r0.put("monitor_id", String.valueOf(this.r));
    L21:
        if (this.s <= 0) goto L24;
        r0.put("event_stained", this.s);
    L24:
        if (TextUtils.isEmpty(this.y) == false) goto L37;
    L36:
        return r0;
    L37:
        JSONObject r3 = new JSONObject(this.y);     // Catch: Throwable -> L34
        Iterator<String> r4 = r3.keys();     // Catch: Throwable -> L34
    L27:
        if (r4.hasNext() == false) goto L36;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (r0.has(r5) == false) goto L31;
        q().c(4, this.t, "Add params to launch conflict: {} - {}", new Object[]{r5, r3.opt(r5)});     // Catch: Throwable -> L34
        goto L27
    L31:
        r0.put(r5, r3.opt(r5));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        q().a(4, this.t, "Add flat params: {} to launch error", th, new Object[]{this.y});
        goto L36
    }

    @Override // com.bytedance.applog.store.a
    public a b(JSONObject r4) {
        q().d(4, this.t, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // com.bytedance.applog.store.a
    public String m() {
        if (this.w == false) goto L5;
        return "bg";
    L5:
        return "fg";
    }
}
