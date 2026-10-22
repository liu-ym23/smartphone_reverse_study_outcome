package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f123153b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "app_id";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        f123153b = new e();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L5;
        int r101 = r100.appId();
    L7:
        return Integer.valueOf(r101);
    L5:
        r101 = -1;
        goto L7
    }

    public e() {
    }
}
