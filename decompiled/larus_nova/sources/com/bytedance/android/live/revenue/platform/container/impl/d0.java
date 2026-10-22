package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 extends wy0.a<com.bytedance.platform.aio.channel.js.model.e, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f91232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.platform.aio.channel.js.b f91233b;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f91232a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public d0(com.bytedance.platform.aio.channel.js.b<Object, Object> r100) {
        this.f91233b = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        com.bytedance.platform.aio.channel.js.model.e r102 = (com.bytedance.platform.aio.channel.js.model.e) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.e("RpcJsBridgeImpl", "receive message" + r102);
        this.f91232a = this.f91233b.invoke(r102).subscribe(new b0(this, r102), new c0(this));
    }
}
