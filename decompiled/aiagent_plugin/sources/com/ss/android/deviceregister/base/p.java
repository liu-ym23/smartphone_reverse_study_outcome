package com.ss.android.deviceregister.base;

import android.content.Context;
import android.os.Build;
import com.ss.android.common.util.ToolUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OaidFactory.java */
/* JADX INFO: loaded from: classes4.dex */
final class p {
    static o a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (com.ss.android.deviceregister.c.e.o() == false) goto L7;
        return new u(new x());
    L7:
        if (x.a() == false) goto L11;
        return new x();
    L11:
        if (s.a() == false) goto L15;
        return new s();
    L15:
        if (com.ss.android.deviceregister.c.e.j() == false) goto L21;
        if (com.ss.android.deviceregister.c.e.k() == false) goto L21;
        com.ss.android.deviceregister.o.b("honor# ", "old honor oaid");
        return new g();
    L21:
        if (com.ss.android.deviceregister.c.e.j() == false) goto L27;
        if (com.ss.android.deviceregister.c.e.k() == true) goto L27;
        com.ss.android.deviceregister.o.b("honor# ", "new honor oaid");
        return new h();
    L27:
        if (com.ss.android.deviceregister.c.e.i() == false) goto L31;
        return new g();
    L31:
        if (com.ss.android.deviceregister.c.e.r() == false) goto L35;
        return new u();
    L35:
        if (com.ss.android.deviceregister.c.e.q() == false) goto L39;
        return new l();
    L39:
        if (Build.VERSION.SDK_INT <= 28) goto L62;
        if (com.ss.android.deviceregister.c.e.s() == false) goto L45;
        return new w();
    L45:
        if (com.ss.android.deviceregister.c.e.u() == false) goto L49;
        return new m();
    L49:
        if (com.ss.android.deviceregister.c.e.t() == false) goto L53;
        return new k();
    L53:
        if (com.ss.android.deviceregister.c.e.v() == true) goto L55;
        e r0 = new e(r3);
        if (r0.b(r3) == false) goto L60;
        return r0;
    L60:
        return new d();
    L55:
        return new a();
    L62:
        if (ToolUtils.b() == false) goto L64;
        return null;
    L64:
        if (g.a(r3) == true) goto L66;
        return null;
    L66:
        return new g();
    }
}
