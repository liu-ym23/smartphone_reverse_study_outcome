package com.bytedance.android.live.revenue.platform.container.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class n0 implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.platform.aio.channel.js.b f91321a;

    public n0(com.bytedance.platform.aio.channel.js.c r100) {
        this.f91321a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        com.bytedance.platform.aio.channel.js.b r100 = this.f91321a;
        KProperty[] r101 = e0.f91243a;
        Intrinsics.checkNotNullParameter(r100, "$this$convertToStatefulMethod");
        return new d0(r100);
    }
}
