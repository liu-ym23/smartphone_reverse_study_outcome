package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class n1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f43261a;

    public n1(s1 r100) {
        this.f43261a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SkuInfoVO r101 = (SkuInfoVO) r100;
        s1 r102 = this.f43261a;
        if (r101 == null) goto L5;
        SkuInstallmentItemInfo r103 = r101.getInstallmentInfo();
    L6:
        r102.h0(r103, true);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
