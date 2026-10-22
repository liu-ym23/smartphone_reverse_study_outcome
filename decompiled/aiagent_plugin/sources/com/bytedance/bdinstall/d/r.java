package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocaleDeviceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends m {
    public r(Context r3, an r4, com.bytedance.bdinstall.u r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.bytedance.bdinstall.d.m
    public void c() {
        super.c();
        if (this.f6226b.o() == false) goto L5;
        boolean r0 = com.bytedance.bdinstall.i.e().b();
    L6:
        if (r0 == false) goto L9;
        com.bytedance.bdinstall.oaid.j.a(this.f6225a).a();
        return;
    L9:
        return;
    L5:
        r0 = com.bytedance.bdinstall.i.a(String.valueOf(this.f6226b.a())).k().b();
        goto L6
    }

    @Override // com.bytedance.bdinstall.d.m
    public void a() {
        super.a();
        if (this.f6226b.O() == false) goto L5;
        return;
    L5:
        if (this.f6226b.P() == true) goto L7;
        return;
    L7:
        if (com.bytedance.bdinstall.j.p.E() == true) goto L9;
    L12:
        com.bytedance.bdinstall.w.b(this.f6226b.b(), new k(this.f6226b));
        return;
    L9:
        if (com.bytedance.bdinstall.j.p.a(this.f6225a) == false) goto L12;
        com.bytedance.bdinstall.t.a("target r, not clean");
    }
}
