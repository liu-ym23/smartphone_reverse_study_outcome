package com.bytedance.vmsdk.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.vmsdk.a.a.a.f;
import com.bytedance.vmsdk.a.a.a.g;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ChromeDiscoveryHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.vmsdk.a.a.a.c {
    private static final String TAG = "ChromeDiscoveryHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.vmsdk.a.a.a.d f11724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f11725b;

    public b() {
        this.f11725b = new ArrayList();
    }

    public void a(com.bytedance.vmsdk.a.a.a.b r3) {
        r3.a(new com.bytedance.vmsdk.a.a.a.a("/json"), this);
        r3.a(new com.bytedance.vmsdk.a.a.a.a("/json/version"), this);
        r3.a(new com.bytedance.vmsdk.a.a.a.a("/json/list"), this);
    }

    public void a(d r3) {
        List<d> r0 = this.f11725b;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f11725b.contains(r3) == true) goto L7;
        this.f11725b.add(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void b(d r2) {
        List<d> r0 = this.f11725b;
        monitor-enter(r0);
        this.f11725b.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.vmsdk.a.a.a.c
    public boolean a(com.bytedance.vmsdk.a.a.d r3, f r4, g r5) {
        String r6 = r4.f11683d.getPath();
    L14:
        e = move-exception;
        r5.f11685c = 500;
        r5.f11686d = "Internal server error";
        r5.f11687e = com.bytedance.vmsdk.a.a.a.d.a(e.toString() + "\n", "text/plain");
        return true;
    L4:
        if ("/json/version".equals(r6) == false) goto L7;
        a(r5);     // Catch: JSONException -> L14
    L18:
        return true;
    L7:
        if ("/json".equals(r6) == false) goto L10;
        b(r5);     // Catch: JSONException -> L14
        goto L18
    L10:
        if ("/json/list".equals(r6) == false) goto L12;
        b(r5);     // Catch: JSONException -> L14
        goto L18
    L12:
        r5.f11685c = 501;     // Catch: JSONException -> L14
        r5.f11686d = "Not implemented";     // Catch: JSONException -> L14
        r5.f11687e = com.bytedance.vmsdk.a.a.a.d.a("No support for " + r6 + "\n", "text/plain");     // Catch: JSONException -> L14
        goto L18
    }

    private void a(g r4) {
        if (this.f11724a != null) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put("Browser", "VMSDK-Debugger");
        r0.put("Protocol-Version", "1.3");
        r0.put("Android-Package", com.bytedance.vmsdk.d.a.a());
        r0.put("V8-Version", "7.2.1");
        this.f11724a = com.bytedance.vmsdk.a.a.a.d.a(r0.toString(), "application/json");
    L5:
        a(r4, this.f11724a);
    }

    private void b(g r9) {
        JSONArray r0 = new JSONArray();
        List<d> r1 = this.f11725b;
        monitor-enter(r1);
        int r2 = 0;
    L14:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r2 >= this.f11725b.size()) goto L8;
        d r3 = (d) ZeusTransformUtils.preCheckCast(this.f11725b.get(r2), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L11
        r4.put("type", "page");     // Catch: Throwable -> L11
        r4.put(DBDefinition.TITLE, r3.a());     // Catch: Throwable -> L11
        r4.put(DbHelper.COL_ID, "" + r2);     // Catch: Throwable -> L11
        r4.put("description", "");     // Catch: Throwable -> L11
        r4.put("webSocketDebuggerUrl", "ws://" + r3.b());     // Catch: Throwable -> L11
        r4.put("devtoolsFrontendUrl", "/devtools/inspector.html?ws=" + r3.b());     // Catch: Throwable -> L11
        r0.put(r4);     // Catch: Throwable -> L11
        r2 = r2 + 1;     // Catch: Throwable -> L11
        goto L14
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L11
        a(r9, com.bytedance.vmsdk.a.a.a.d.a(r0.toString(), "application/json"));
    }

    private static void a(g r1, com.bytedance.vmsdk.a.a.a.d r2) {
        r1.f11685c = 200;
        r1.f11686d = "OK";
        r1.f11687e = r2;
    }
}
