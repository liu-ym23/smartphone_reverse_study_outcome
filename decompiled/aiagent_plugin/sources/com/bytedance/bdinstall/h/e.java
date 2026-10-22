package com.bytedance.bdinstall.h;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CommonDeviceParamProviderCreator.java */
/* JADX INFO: loaded from: classes.dex */
class e {
    static k a(Context r2, u r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3.b() == false) goto L6;
        String r6 = com.bytedance.bdinstall.j.j.a("dp", r3);
    L11:
        if (r4.C() == false) goto L13;
        r6 = r6 + "_local";
    L13:
        k r0 = new k();
        r0.a(r6 + ".dat");
        r0.a(r3.a(r4));
        r0.b(r4.F());
        r0.a(r4.C());
        r0.a(r4.H(), com.bytedance.bdinstall.j.j.a("", r3));
        r0.c(r4.O());
        r0.a(r4);
        return r0;
    L6:
        if (r4.o() == false) goto L8;
        String r7 = "device_parameters";
    L9:
        r6 = com.bytedance.bdinstall.j.j.a(r7, r3);
        goto L11
    L8:
        r7 = "device_parameters_" + r4.a();
        goto L9
    }
}
