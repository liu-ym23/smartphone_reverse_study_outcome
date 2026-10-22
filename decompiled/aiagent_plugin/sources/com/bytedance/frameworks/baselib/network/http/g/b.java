package com.bytedance.frameworks.baselib.network.http.g;

import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.retrofit2.ak;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestVertifyInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements com.bytedance.retrofit2.f.b {
    public b() {
    }

    private com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r2) {
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (r2.h() == false) goto L7;
        return r2;
    L7:
        return b(r2);
    }

    private com.bytedance.retrofit2.b.c b(com.bytedance.retrofit2.b.c r6) {
        String r5 = g.a(r6.b(), r6.i(), r6.p(), new Object[]{r6.d()});     // Catch: Throwable -> L4
        com.bytedance.retrofit2.b.c.a r0 = r6.m();     // Catch: Throwable -> L4
        r0.a(r5);     // Catch: Throwable -> L4
        return r0.b();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r6;
    }

    @Override // com.bytedance.retrofit2.d.b
    public ak a(com.bytedance.retrofit2.d.b.a r3) {
        com.bytedance.retrofit2.d.b.a r4 = (com.bytedance.retrofit2.d.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.d.b.a.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.b.c r2 = a(r4.a());
        if (com.bytedance.retrofit2.d.c.b() == false) goto L6;
        return r4.b(r2);
    L6:
        return r4.a(r2);
    }
}
