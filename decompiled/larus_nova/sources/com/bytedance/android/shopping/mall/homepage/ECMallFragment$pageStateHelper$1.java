package com.bytedance.android.shopping.mall.homepage;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallFragment$pageStateHelper$1 extends com.bytedance.android.shopping.api.mall.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f177380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ECMallFragment f177381c;

    @Override // com.bytedance.android.shopping.api.mall.b
    public final boolean a() {
        if (this.f177381c.f177286v3 == true) goto L5;
    L8:
        return false;
    L5:
        if (((Boolean) this.f177380b.getValue()).booleanValue() == false) goto L7;
        this.f177381c.getClass();
        goto L8
    L7:
        return true;
    }

    public ECMallFragment$pageStateHelper$1(ECMallFragment r100) {
        this.f177381c = r100;
        this.f177380b = LazyKt.lazy(ECMallFragment$pageStateHelper$1$visibilityStrictCheckEnable$2.INSTANCE);
    }
}
