package com.ss.android.deviceregister;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MigrateDetectorHelper.java */
/* JADX INFO: loaded from: classes4.dex */
final class r {
    static void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        q r0 = new q(r4);
        if (r0.b() == false) goto L5;
        j.b(r4);
        com.ss.android.deviceregister.a.a.a r1 = h.a(r4);
        com.ss.android.deviceregister.base.v.b(r1.b());
        r1.b("openudid");
        r1.b("clientudid");
        r1.b("serial_number");
        r1.b("sim_serial_number");
        r1.b("udid");
        r1.b("udid_list");
        r1.b("device_id");
        g.b(r4, "clearMigrationInfo");
    L5:
        r0.a();
    }
}
