package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: OpInstallOptionsHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class at implements ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private an f6149b;

    /* JADX INFO: compiled from: OpInstallOptionsHelper.java */
    interface a {
        void a(am r1, String r2);
    }

    at(Context r3) {
        this.f6148a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public void a(an r1) {
        this.f6149b = r1;
    }

    void a() {
        an r0 = this.f6149b;
        if (r0 != null) goto L5;
        return;
    L5:
        i.a(String.valueOf(r0.a())).a(true, this);
    }

    void a(Context r3, a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        final a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        if (this.f6149b != null) goto L5;
        return;
    L5:
        az.a(r5).a(this.f6149b.b(), "install_info", new AnonymousClass1(this, r6));
    }

    @Override // com.bytedance.bdinstall.ag
    public void a(am r5) {
        if (this.f6149b != null) goto L5;
        return;
    L5:
        String r6 = r5.i().toString();
        if (this.f6149b.f6119b == false) goto L8;
        this.f6148a.getSharedPreferences("ug_install_op_pref", 0).edit().putString("install_info", r6).apply();
    L8:
        az.a(this.f6148a).a(this.f6149b.b(), "install_info", r6);
    }

    am b() {
        String r1 = this.f6148a.getSharedPreferences("ug_install_op_pref", 0).getString("install_info", null);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r1) == true) goto L6;
    L8:
        return am.g(r1);
    L6:
        if (ba.b() == false) goto L8;
        r1 = c();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private String c() {
        HashMap r1 = new HashMap();
        SharedPreferences r2 = this.f6148a.getSharedPreferences("applog_stats", 0);     // Catch: Exception -> L5
        SharedPreferences r6 = this.f6148a.getSharedPreferences("snssdk_openudid", 0);     // Catch: Exception -> L5
        r1.put("did", r2.getString("device_id", null));     // Catch: Exception -> L5
        r1.put(WsConstants.KEY_INSTALL_ID, r2.getString("install_id", null));     // Catch: Exception -> L5
        r1.put("client_udid", r6.getString("clientudid", null));     // Catch: Exception -> L5
        r1.put("openudid", r6.getString("openudid", null));     // Catch: Exception -> L5
        t.a("offset_did offset installinfo is " + r1);     // Catch: Exception -> L5
    L8:
        return r1.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
