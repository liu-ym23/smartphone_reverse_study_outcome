package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.deviceidservice.IDeviceIdService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SamsungOaidImpl.java */
/* JADX INFO: loaded from: classes4.dex */
final class w extends c<IDeviceIdService> {
    w() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.ss.android.deviceregister.base.c
    public ServiceBlockBinder.a<IDeviceIdService, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.deviceregister.base.c
    public Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Intent r3 = new Intent();
        r3.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r3;
    }
}
