package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends DynamicFactor<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f123150b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "device_id";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        f123150b = new c();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Long b() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L9;
        String r101 = r100.getServerDeviceId();
        if (r101 == null) goto L9;
        Long r102 = StringsKt.toLongOrNull(r101);
        if (r102 == null) goto L9;
        long r103 = r102.longValue();
    L11:
        return Long.valueOf(r103);
    L9:
        r103 = 0;
        goto L11
    }

    public c() {
    }
}
