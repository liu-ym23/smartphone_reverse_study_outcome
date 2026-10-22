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

/* JADX INFO: compiled from: Page.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    public long u;
    public String v;
    public String w;
    public int x;
    public String y;
    public String z;

    @Override // com.bytedance.applog.store.a
    String h() {
        return "page";
    }

    public h() {
    }

    @Override // com.bytedance.applog.store.a
    public List<String> e() {
        List<String> r14 = super.e();
        ArrayList r0 = new ArrayList(r14.size());
        r0.addAll(r14);
        r0.addAll(Arrays.asList(new String[]{"page_key", "varchar", "refer_page_key", "varchar", "duration", WsChannelMultiProcessSharedProvider.INT_TYPE, "is_back", WsChannelMultiProcessSharedProvider.INT_TYPE, "last_session", "varchar", "flat_params", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.store.a
    public int a(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.aiagent.plugin");
        int r0 = super.a(r6);
        int r1 = r0 + 1;
        this.w = r6.getString(r0);
        int r2 = r1 + 1;
        this.v = r6.getString(r1);
        int r3 = r2 + 1;
        this.u = r6.getLong(r2);
        int r4 = r3 + 1;
        this.x = r6.getInt(r3);
        int r7 = r4 + 1;
        this.y = r6.getString(r4);
        int r8 = r7 + 1;
        this.z = r6.getString(r7);
        return r8;
    }

    @Override // com.bytedance.applog.store.a
    public void a(ContentValues r3) {
        super.a(r3);
        r3.put("page_key", this.w);
        r3.put("refer_page_key", this.v);
        r3.put("duration", Long.valueOf(this.u));
        r3.put("is_back", Integer.valueOf(this.x));
        r3.put("last_session", this.y);
        r3.put("flat_params", this.z);
    }

    @Override // com.bytedance.applog.store.a
    public void a(JSONObject r4) {
        super.a(r4);
        r4.put("page_key", this.w);
        r4.put("refer_page_key", this.v);
        r4.put("duration", this.u);
        r4.put("is_back", this.x);
    }

    @Override // com.bytedance.applog.store.a
    public a b(JSONObject r4) {
        super.b(r4);
        this.w = r4.optString("page_key", null);
        this.v = r4.optString("refer_page_key", null);
        this.u = r4.optLong("duration", 0);
        this.x = r4.optInt("is_back", 0);
        return this;
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
        r0.put("event", "bav2b_page");
        r0.put("is_bav", 1);
        r0.put("params", t());
        r0.put("datetime", this.n);
        if (this.q <= 0) goto L8;
        r0.put("event_id", this.q);
    L8:
        return r0;
    }

    private JSONObject t() {
        JSONObject r0 = new JSONObject();
        r0.put("page_key", this.w);
        r0.put("refer_page_key", this.v);
        r0.put("is_back", this.x);
        r0.put("duration", this.u);
        return r0;
    }

    public boolean r() {
        if (this.u != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s() {
        return this.w.contains(":");
    }

    @Override // com.bytedance.applog.store.a
    public String m() {
        return this.w + ", " + this.u;
    }
}
