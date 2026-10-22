package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends DynamicFactor<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f123160b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "version_name";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        f123160b = new h();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String b() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L6;
        String r101 = r100.getVersionName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public h() {
    }
}
