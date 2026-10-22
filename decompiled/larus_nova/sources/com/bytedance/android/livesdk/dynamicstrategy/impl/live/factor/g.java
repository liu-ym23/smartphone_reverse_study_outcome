package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f123158b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "version_code";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        f123158b = new g();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L9;
        String r101 = r100.getVersionCode();
        if (r101 == null) goto L9;
        Integer r102 = StringsKt.toIntOrNull(r101);
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L11:
        return Integer.valueOf(r103);
    L9:
        r103 = 0;
        goto L11
    }

    public g() {
    }
}
