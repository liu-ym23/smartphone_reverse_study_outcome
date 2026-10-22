package com.bytedance.reparo.c;

import android.app.Application;
import com.bytedance.reparo.IReparoConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: SecondaryService.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a(Application r2, final IReparoConfig r3, ScheduledExecutorService r4) {
        final Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        ScheduledExecutorService r6 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r4, ScheduledExecutorService.class, "com.obric.aiagent.plugin");
        com.bytedance.reparo.core.a.a.a.a(com.bytedance.reparo.core.a.b.d.a(r5), com.bytedance.reparo.core.a.b.d.b(r5));
        e.a(r5);
        c.a();
        f.a(r5, r6);
        g.a(r5, r3);
        com.bytedance.reparo.core.e.c.a(new AnonymousClass1());
        r6.execute(new AnonymousClass2(r5, r3));
        h.a(r5, r6);
    }
}
