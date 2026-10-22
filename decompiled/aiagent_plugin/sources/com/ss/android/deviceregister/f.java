package com.ss.android.deviceregister;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeviceRegisterInitiator.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {
    public static void a(Context r2, boolean r3, com.ss.android.deviceregister.base.j r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.ss.android.deviceregister.base.j r10 = (com.ss.android.deviceregister.base.j) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.deviceregister.base.j.class, "com.obric.aiagent.plugin");
        g.b(r3);
        g.a(r10);
        g.c(r5);
        g.a(r6);
        g.a(r9, r7, r8);
    }
}
