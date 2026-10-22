package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.platform.aio.ServiceHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f0 implements com.bytedance.platform.aio.channel.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevenueJsDriver f91251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.platform.aio.c f91252b;

    @Override // com.bytedance.platform.aio.channel.d
    public final void onRegister(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        this.f91252b.a(r100, this.f91251a);
        jy0.b.d("RevenueJsDriver", "onRegister" + r100);
    }

    public f0(RevenueJsDriver r100, ServiceHub r101) {
        this.f91251a = r100;
        this.f91252b = r101;
    }
}
