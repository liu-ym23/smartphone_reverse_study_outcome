package com.bytedance.applet.impl;

import com.bytedance.ai.bridge.service.OnPayOrderResultCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class f0 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnPayOrderResultCallback f191929a;

    public /* synthetic */ f0(OnPayOrderResultCallback r100) {
        this.f191929a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        OnPayOrderResultCallback r102 = this.f191929a;
        int r103 = ((Integer) r100).intValue();
        String r104 = (String) r101;
        if (r103 != 0) goto L5;
        r102.onSuccess();
    L16:
        return Unit.INSTANCE;
    L5:
        if (r103 != 1) goto L7;
        r102.onFailed("1", "Payment cancelled");
        goto L16
    L7:
        if (r103 != 2) goto L9;
        r102.onFailed("2", "Payment failed");
        goto L16
    L9:
        if (r103 == 3) goto L11;
        r102.onFailed("2", "Payment failed");
        goto L16
    L11:
        r102.onFailed("3", "Payment is being processed");
        goto L16
    }
}
