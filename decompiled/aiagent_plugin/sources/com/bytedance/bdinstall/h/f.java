package com.bytedance.bdinstall.h;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeviceParamProviderCreator.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends e {
    public static void b(Context r2, u r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        k r0 = a(r5, r3, r4);
        if (r3.b() == true) goto L5;
        com.bytedance.bdinstall.g.a r6 = new c(r5, r0);
    L6:
        com.bytedance.bdinstall.g.c r7 = (com.bytedance.bdinstall.g.c) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.c.class, r4.b()), com.bytedance.bdinstall.g.c.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L9;
        r6 = (com.bytedance.bdinstall.g.a) ZeusTransformUtils.preCheckCast(r7.a(com.bytedance.bdinstall.g.a.class, r6), com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin");
    L9:
        com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.a.class, r6, r4.b());
        return;
    L5:
        r6 = new g(r5, r0);
        goto L6
    }
}
