package com.bytedance.bdinstall.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VerifyMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.bytedance.bdinstall.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Long> f6192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6194d;

    public d() {
        this.f6191a = 0;
        this.f6193c = 0;
        this.f6194d = 0;
    }

    public int c() {
        return this.f6193c;
    }

    public void a(int r1) {
        this.f6193c = r1;
    }

    public int d() {
        return this.f6194d;
    }

    public void b(int r1) {
        this.f6194d = r1;
    }

    public void c(int r1) {
        this.f6191a = r1;
    }

    public void a(Map<String, Long> r3) {
        this.f6192b = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public int e() {
        return this.f6191a;
    }

    @Override // com.bytedance.bdinstall.a.a.c
    public JSONObject a() {
        JSONObject r6 = new JSONObject();
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(this.f6192b.get("ticket_init"), Long.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L5
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(this.f6192b.get("get_ticket"), Long.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L5
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(this.f6192b.get("ticket_handle_response"), Long.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L5
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(this.f6192b.get("ticket_decrypt"), Long.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L5
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(this.f6192b.get("consumer_ticket"), Long.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L5
        r6.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r6.put("result", d());     // Catch: JSONException -> L5
        r6.put("retry_count", c());     // Catch: JSONException -> L5
        r6.put("decrypt_code", e());     // Catch: JSONException -> L5
        r6.put("ticket_init", r7);     // Catch: JSONException -> L5
        r6.put("get_ticket", r8);     // Catch: JSONException -> L5
        r6.put("ticket_handle_response", r9);     // Catch: JSONException -> L5
        r6.put("ticket_decrypt", r10);     // Catch: JSONException -> L5
        r6.put("consumer_ticket", r5);     // Catch: JSONException -> L5
        r6.put("ticket_total_time", (((r7.longValue() + r8.longValue()) + r9.longValue()) + r10.longValue()) + r5.longValue());     // Catch: JSONException -> L5
    L7:
        return r6;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.bytedance.bdinstall.a.a.c
    public void b() {
        this.f6191a = 0;
        this.f6193c = 0;
        this.f6194d = 0;
        this.f6192b = null;
    }
}
