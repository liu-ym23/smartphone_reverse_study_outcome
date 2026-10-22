package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.live.wallet.model.OrderParamsKey;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class l<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164255b;

    @Override // m33.a
    public final String d() {
        return this.f164255b;
    }

    public l(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164255b = "selfFaceAuth";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Map<String, Object> r101 = r100.a();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get(OrderParamsKey.KEY_SDK_PARAM);
    L7:
        if ((r103 instanceof Map) == false) goto L11;
        r102 = r103;
    L11:
        if (((Map) r102) != null) goto L13;
        MapsKt.emptyMap();
    L13:
        boolean r104 = ECServiceManager.f42805a;
        ((s83.g) ECServiceManager.c(s83.g.class)).h0();
        return;
    L5:
        r103 = null;
        goto L7
    }
}
