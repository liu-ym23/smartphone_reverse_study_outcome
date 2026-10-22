package com.bytedance.apm6.consumer.slardar.d.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DowngradeDataStorage.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5120a;

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.f5120a != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f5120a != null) goto L8;
        this.f5120a = r4.getSharedPreferences("monitor_downgrade", 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    public void a(c r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.f5120a == null) goto L13;
        JSONObject r5 = r4.a();
        if (r5 == null) goto L14;
        String r0 = r5.toString();
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L10;
        com.bytedance.apm6.util.c.b.b("APM-Downgrade", "DowngradeData-save-" + r0);
    L10:
        this.f5120a.edit().putString("rule", r5.toString()).apply();
        return;
    L14:
        return;
    }

    public c a() {
        String r6 = this.f5120a.getString("rule", null);
        if (r6 != null) goto L14;
    L13:
        return null;
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L5:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L7;
        com.bytedance.apm6.util.c.b.b("APM-Downgrade", "DowngradeData-load-" + r6);     // Catch: JSONException -> L11
    L7:
        c r7 = c.a(new JSONObject(r6));     // Catch: JSONException -> L11
        if (System.currentTimeMillis() >= r7.f5121a) goto L13;
        return r7;
    }
}
