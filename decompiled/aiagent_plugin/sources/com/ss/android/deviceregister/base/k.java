package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.zui.deviceidservice.IDeviceidInterface;

/* JADX INFO: compiled from: LenovoOaidImpl.java */
/* JADX INFO: loaded from: classes4.dex */
final class k extends c<IDeviceidInterface> {
    k() {
        super("com.zui.deviceidservice");
    }

    @Override // com.ss.android.deviceregister.base.c
    public ServiceBlockBinder.a<IDeviceidInterface, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.deviceregister.base.c
    public Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Intent r3 = new Intent();
        r3.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r3;
    }
}
