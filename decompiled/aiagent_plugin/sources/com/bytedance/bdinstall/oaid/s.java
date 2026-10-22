package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SamsungOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class s extends b<IDeviceIdService> {
    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "Samsung";
    }

    s() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public ServiceBlockBinder.a<IDeviceIdService, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Intent r3 = new Intent();
        r3.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r3;
    }
}
