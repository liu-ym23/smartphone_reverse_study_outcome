package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.lynx.react.bridge.JavaOnlyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements com.bytedance.platform.aio.channel.js.a {
    public c() {
    }

    @Override // com.bytedance.platform.aio.channel.js.a
    public final void a(String r100, com.bytedance.platform.aio.channel.js.c r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
    }

    @Override // com.bytedance.platform.aio.channel.js.a
    public final void b(com.bytedance.platform.aio.channel.js.model.e r100) {
        Intrinsics.checkNotNullParameter("rpcChannelMessage", "eventName");
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.platform.aio.channel.js.a
    public final void c(String r100, com.bytedance.platform.aio.channel.js.c r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
    }

    @Override // com.bytedance.platform.aio.channel.js.a
    public final void d(JavaOnlyMap r100) {
        Intrinsics.checkNotNullParameter("rpcChannelMessageV2", "eventName");
        Intrinsics.checkNotNullParameter(r100, "data");
    }
}
