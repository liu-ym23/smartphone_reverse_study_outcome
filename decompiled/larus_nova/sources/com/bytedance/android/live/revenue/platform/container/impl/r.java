package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.platform.aio.channel.RpcException;
import com.bytedance.platform.aio.channel.RpcExceptionMonitorLevel;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f91342a;

    public r(String r100) {
        this.f91342a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        m.a r111 = (m.a) r110;
        Intrinsics.checkNotNullParameter(r111, "it");
        com.bytedance.platform.aio.a r112 = r111.f91317a;
        if (r112 == null) goto L5;
        return r112;
    L5:
        String r113 = this.f91342a;
        RpcExceptionMonitorLevel r100 = RpcExceptionMonitorLevel.ERROR;
        Intrinsics.checkNotNullParameter("service_center_no_such_service", "category");
        Intrinsics.checkNotNullParameter(r113, "interfaceId");
        Intrinsics.checkNotNullParameter(r100, "errorLevel");
        throw new RpcException("service_center_no_such_service", "service " + r113 + " not found", com.bytedance.platform.aio.d.g(new Exception()), r100, null, 16, null);
    }
}
