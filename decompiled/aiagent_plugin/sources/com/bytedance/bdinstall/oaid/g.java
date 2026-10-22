package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDeviceidInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LenovoOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class g extends b<IDeviceidInterface> {
    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "Lenovo";
    }

    g() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public ServiceBlockBinder.a<IDeviceidInterface, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Intent r3 = new Intent();
        r3.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r3;
    }
}
