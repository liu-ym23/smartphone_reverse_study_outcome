package com.ss.android.deviceregister.a;

import android.content.Context;
import com.bytedance.common.utility.j;
import com.ss.android.deviceregister.base.v;
import com.ss.android.deviceregister.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RealRegisterServiceController.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends e {
    public d(Context r3, boolean r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public String a() {
        return this.f37332b.e();
    }

    public JSONArray b() {
        return this.f37332b.f();
    }

    public String[] c() {
        return this.f37332b.d();
    }

    public String d() {
        return this.f37332b.c();
    }

    @Override // com.ss.android.deviceregister.a.e
    public void a(String r6, String r7) {
        if (j.a(r6) == true) goto L24;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        String r1 = i();     // Catch: Exception -> L21
        if (g.f() == true) goto L19;
        String r2 = this.f37332b.e();     // Catch: Exception -> L21
        String r3 = this.f37332b.c();     // Catch: Exception -> L21
        if (j.a(r2) == true) goto L10;
        r0.put("udid", r2);     // Catch: Exception -> L21
    L10:
        if (j.a(r3) == true) goto L13;
        r0.put("serial_number", r3);     // Catch: Exception -> L21
    L13:
        if (v.f() == false) goto L19;
        String[] r4 = this.f37332b.d();     // Catch: Exception -> L21
        if (r4 == null) goto L19;
        if (r4.length <= 0) goto L19;
        r0.put("sim_serial_number", Arrays.toString(r4));     // Catch: Exception -> L21
    L19:
        Object r5 = this.f37332b.a();     // Catch: Exception -> L21
        r0.put("old_id", r6);     // Catch: Exception -> L21
        r0.put("new_id", r7);     // Catch: Exception -> L21
        r0.put("openudid", r1);     // Catch: Exception -> L21
        r0.put("clientudid", r5);     // Catch: Exception -> L21
        a("did_change", r0);     // Catch: Exception -> L21
        return;
    L25:
        return;
    }
}
