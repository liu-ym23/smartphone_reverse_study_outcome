package com.bytedance.bdinstall;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CpDeviceTokenServiceImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class o extends a implements az.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f6385a;

    public o(an r4) {
        az.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r4.b(), "device_token", this);
    }

    @Override // com.bytedance.bdinstall.r
    public void a(String r1, u r2) {
        this.f6385a = r1;
    }

    @Override // com.bytedance.bdinstall.az.a
    public void a(String r1, String r2) {
        a(r1, null);
    }
}
