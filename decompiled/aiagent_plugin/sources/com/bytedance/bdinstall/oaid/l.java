package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OaidFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class l {
    static k a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.BRAND.equals("Pico") == false) goto L7;
        return new r();
    L7:
        if (com.bytedance.bdinstall.j.p.s() == false) goto L11;
        return new q(new t());
    L11:
        if (com.bytedance.bdinstall.j.p.t() == false) goto L15;
        if (t.a() == false) goto L15;
    L17:
        return new t();
    L15:
        if (com.bytedance.bdinstall.j.p.u() == true) goto L17;
        if (p.a() == false) goto L23;
        return new p(r3);
    L23:
        if (com.bytedance.bdinstall.j.p.m() == false) goto L29;
        if (com.bytedance.bdinstall.j.p.n() == false) goto L29;
        com.bytedance.bdinstall.t.a("honor# old honor oaid");
        return new e();
    L29:
        if (com.bytedance.bdinstall.j.p.m() == false) goto L35;
        if (com.bytedance.bdinstall.j.p.n() == true) goto L35;
        com.bytedance.bdinstall.t.a("honor# new honor oaid");
        return new f();
    L35:
        if (com.bytedance.bdinstall.j.p.C() == false) goto L39;
        return new e();
    L39:
        if (com.bytedance.bdinstall.j.p.x() == false) goto L43;
        return new q();
    L43:
        if (com.bytedance.bdinstall.j.p.w() == false) goto L47;
        return new h();
    L47:
        if (Build.VERSION.SDK_INT <= 28) goto L70;
        if (com.bytedance.bdinstall.j.p.y() == false) goto L53;
        return new s();
    L53:
        if (com.bytedance.bdinstall.j.p.A() == false) goto L57;
        return new i();
    L57:
        if (com.bytedance.bdinstall.j.p.z() == false) goto L61;
        return new g();
    L61:
        if (com.bytedance.bdinstall.j.p.B() == true) goto L63;
        d r0 = new d(r3);
        if (r0.b(r3) == false) goto L68;
        return r0;
    L68:
        return new c();
    L63:
        return new a();
    L70:
        if (com.bytedance.bdinstall.j.p.o() == false) goto L72;
        return null;
    L72:
        if (e.a(r3) == true) goto L74;
        return null;
    L74:
        return new e();
    }
}
