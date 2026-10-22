package com.bytedance.crash.entity;

import com.bytedance.crash.o.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashBody.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f7456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Header f7457b;

    public a() {
        this.f7456a = new JSONObject();
        this.f7457b = new Header();
    }

    public Header a() {
        return this.f7457b;
    }

    public JSONObject b() {
        return this.f7456a.optJSONObject("header");
    }

    public JSONObject c() {
        return this.f7456a;
    }

    public void a(JSONObject r1) {
        this.f7456a = r1;
    }

    public a a(Header r3) {
        a("header", r3.b());
        this.f7457b = r3;
        return this;
    }

    public void a(String r1, Object r2) {
        l.a(this.f7456a, r1, r2);
    }

    @Deprecated
    public static void a(JSONObject r1, String r2, String r3, Object r4) {
        if (r1 != null) goto L4;
        return;
    L4:
        JSONObject r0 = r1.optJSONObject(r2);
        if (r0 != null) goto L7;
        r0 = new JSONObject();
        l.a(r1, r2, r0);
    L7:
        l.a(r0, r3, r4);
    }
}
