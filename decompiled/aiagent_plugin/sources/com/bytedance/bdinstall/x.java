package com.bytedance.bdinstall;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: GWorker.java */
/* JADX INFO: loaded from: classes.dex */
public class x extends ax {
    private final an f;
    private final long[] g;

    @Override // com.bytedance.bdinstall.ax, com.bytedance.bdinstall.k
    public void a(int r1) {
    }

    @Override // com.bytedance.bdinstall.ax, com.bytedance.bdinstall.k
    public void a(boolean r1) {
    }

    @Override // com.bytedance.bdinstall.ax, com.bytedance.bdinstall.k
    public String f() {
        return "GWorker";
    }

    @Override // com.bytedance.bdinstall.ax, com.bytedance.bdinstall.k
    public void g() {
    }

    @Override // com.bytedance.bdinstall.ax, com.bytedance.bdinstall.k
    public /* bridge */ /* synthetic */ boolean e() {
        return super.e();
    }

    x(an r3, com.bytedance.bdinstall.d.m r4, u r5, com.bytedance.bdinstall.appstate.a r6) {
        super(r3, r4, r5, (com.bytedance.bdinstall.appstate.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.bdinstall.appstate.a.class, "com.obric.aiagent.plugin"));
        this.g = new long[]{10000, 10000, 10000};
        this.f = r3;
    }

    @Override // com.bytedance.bdinstall.ax, com.bytedance.bdinstall.k
    public long[] c() {
        int r0 = i.f().e();
        if (r0 <= 0) goto L7;
        long r2 = r0;
        return new long[]{r2, r2, r2};
    L7:
        return this.g;
    }

    @Override // com.bytedance.bdinstall.ax, com.bytedance.bdinstall.k
    public long b() {
        return super.b();
    }

    @Override // com.bytedance.bdinstall.ax, com.bytedance.bdinstall.k
    public boolean d() {
        if (this.f6359c < this.g.length) goto L6;
        t.a("[egdi]  retry count has limited and stop worker");
        h();
        return true;
    L6:
        com.bytedance.bdinstall.e.a r1 = n();
        if (r1 != null) goto L22;
        return false;
    L22:
        String r2 = new JSONObject(r1.b()).optString("klink_egdi", "");     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r2) == false) goto L13;
        t.a("[egdi]  egdi is null");     // Catch: JSONException -> L19
        return false;
    L13:
        SharedPreferences r3 = this.f.v();     // Catch: JSONException -> L19
        SharedPreferences r5 = com.bytedance.bdinstall.j.j.a(this.f6357a, this.f);     // Catch: JSONException -> L19
        if (r3 == null) goto L16;
        r3.edit().putString("klink_egdi", r2).apply();     // Catch: JSONException -> L19
        t.a("[egdi]  egdi is cached to olad sp applog_stats");     // Catch: JSONException -> L19
    L16:
        if (r5 == null) goto L21;
        r5.edit().putString("klink_egdi", r2).apply();     // Catch: JSONException -> L19
        t.a("[egdi]  egdi is cached to global sp ug_install_settings_pref_aid");     // Catch: JSONException -> L19
    L21:
        return true;
    L19:
        e = move-exception;
        t.b("[egdi] " + e.getMessage(), e);
        goto L21
    }
}
