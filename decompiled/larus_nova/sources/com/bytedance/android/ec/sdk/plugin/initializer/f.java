package com.bytedance.android.ec.sdk.plugin.initializer;

import com.bytedance.android.ec.core.abtest.ECSettingsConfig;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends com.bytedance.android.ec.sdk.initalizer.a {
    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        return Boxing.boxBoolean(true);
    }

    public f() {
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        boolean r101 = com.bytedance.android.ec.core.abtest.h.f43644a;
        com.bytedance.android.ec.core.abtest.h.f43644a = true;
        ECSettingsConfig r102 = com.bytedance.android.ec.core.abtest.h.b();
        if (r102 == null) goto L16;
        if (r102.getPreloadEnable() != true) goto L16;
        com.bytedance.android.ec.core.abtest.g r103 = new com.bytedance.android.ec.core.abtest.g(System.currentTimeMillis());
        ECSettingsConfig r104 = com.bytedance.android.ec.core.abtest.h.b();
        if (r104 == null) goto L12;
        long r105 = r104.getDelayInitDuration();
        if (r105 <= 0) goto L12;
        Lazy r106 = UIUtils.f45548a;
        UIUtils.c().postDelayed(new com.bytedance.android.ec.core.abtest.f(r103), r105);
    L12:
        int r107 = ECSdk.f48106a;
        s83.g r108 = (s83.g) ECSdk.a(s83.g.class);
        if (r108 == null) goto L16;
        r108.v(r103);
    L16:
        return Unit.INSTANCE;
    }
}
