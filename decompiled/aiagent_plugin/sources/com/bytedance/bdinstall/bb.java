package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VerifyTicketWorker.java */
/* JADX INFO: loaded from: classes.dex */
class bb extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final an f6199e;
    private final u f;
    private final com.bytedance.bdinstall.d.m g;
    private final Map<String, String> h;
    private final com.bytedance.bdinstall.b.d i;

    @Override // com.bytedance.bdinstall.k
    public boolean a() {
        return true;
    }

    @Override // com.bytedance.bdinstall.k
    public long b() {
        return 0;
    }

    @Override // com.bytedance.bdinstall.k
    public boolean e() {
        return true;
    }

    @Override // com.bytedance.bdinstall.k
    public String f() {
        return "ticketGuard";
    }

    bb(an r4, u r5, com.bytedance.bdinstall.d.m r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        this.f6199e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r8;
        this.i = com.bytedance.bdinstall.j.e.a().e(r4.a());
    }

    @Override // com.bytedance.bdinstall.k
    public void a(int r1) {
        this.i.a(r1);
    }

    @Override // com.bytedance.bdinstall.k
    public void g() {
        Map<String, Long> r0 = this.g.q().b();
        if (r0.size() <= 0) goto L5;
        this.i.a(r0);
    L5:
        com.bytedance.bdinstall.j.e.d(this.f6199e);
    }

    @Override // com.bytedance.bdinstall.k
    public void a(boolean r1) {
        this.i.b(!r1 ? 1 : 0);
    }

    @Override // com.bytedance.bdinstall.k
    public long[] c() {
        return ax.f6156e;
    }

    @Override // com.bytedance.bdinstall.k
    public boolean d() {
        boolean r0 = false;
        JSONObject r4 = n();     // Catch: Exception -> L14
        String r3 = Uri.parse(this.f.a().c()).buildUpon().appendQueryParameter("req_id", com.bytedance.bdinstall.j.o.a()).build().toString();     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4.optString("device_id")) == false) goto L6;
    L8:
        boolean r7 = false;
    L9:
        r0 = d.b(this.f6199e.c(), i.f().a(), r3, r4, this.f6199e.B(), this.f6199e.K(), r7, this.g.q().a(r3, (String) ZeusTransformUtils.preCheckCast(this.h.get("ts_sign"), String.class, "com.obric.aiagent.plugin"), this.g.d().optString("klink_eii"), false));     // Catch: Exception -> L14
        if (r0 == false) goto L12;
        h();     // Catch: Exception -> L14
    L12:
        t.a("TicketGuard# [after verify] response result " + r0);     // Catch: Exception -> L14
    L16:
        return r0;
    L6:
        if (TextUtils.isEmpty(r4.optString("install_id")) == true) goto L8;
        r7 = true;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private JSONObject n() {
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        JSONObject r9 = this.g.d();     // Catch: JSONException -> L6
        r6.put("device_id", r9.optString("device_id"));     // Catch: JSONException -> L6
        r6.put("installation_id", r9.optString("install_id"));     // Catch: JSONException -> L6
        r6.put("app_id", r9.optString(WsConstants.KEY_APP_ID));     // Catch: JSONException -> L6
        r6.put(WsConstants.KEY_APP_VERSION, r9.optString(WsConstants.KEY_APP_VERSION));     // Catch: JSONException -> L6
        r6.put("sdk_version", r9.optString("sdk_version"));     // Catch: JSONException -> L6
        r7.put("klink_edi", r9.optString("klink_edi"));     // Catch: JSONException -> L6
        r7.put("klink_eii", r9.optString("klink_eii"));     // Catch: JSONException -> L6
        r5.put("basic_context", r6);     // Catch: JSONException -> L6
        r5.put("security_context", r7);     // Catch: JSONException -> L6
        t.a("TicketGuard# [before verify] doVerify request body is " + r5);
        return r5;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
