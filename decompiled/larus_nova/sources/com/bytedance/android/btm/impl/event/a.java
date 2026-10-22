package com.bytedance.android.btm.impl.event;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.model.j;
import com.bytedance.android.btm.api.model.k;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.bytedance.android.btm.api.inner.d {
    public a() {
    }

    @Override // com.bytedance.android.btm.api.inner.d
    public void onEventV1(j r100) {
        BtmHostDependManager r101 = BtmHostDependManager.F;
        r101.getClass();
        zc.c r102 = (zc.c) BtmHostDependManager.f41937e.getValue(r101, BtmHostDependManager.f41933a[3]);
        if (r102 == null) goto L6;
        r102.onEventV1(r100);
        return;
    }

    @Override // com.bytedance.android.btm.api.inner.d
    public void onEventV3(k r100) {
        BtmHostDependManager r101 = BtmHostDependManager.F;
        r101.getClass();
        zc.c r102 = (zc.c) BtmHostDependManager.f41937e.getValue(r101, BtmHostDependManager.f41933a[3]);
        if (r102 == null) goto L6;
        r102.onEventV3(r100);
        return;
    }
}
