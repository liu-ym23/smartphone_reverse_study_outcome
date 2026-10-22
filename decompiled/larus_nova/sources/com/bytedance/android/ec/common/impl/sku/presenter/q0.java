package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class q0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f43272a;

    public q0(s0 r100) {
        this.f43272a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        s0 r102 = this.f43272a;
        r102.getClass();
        if (r101 != null) goto L6;
    L10:
        Integer r103 = com.bytedance.android.ec.core.utils.s.b("#FF3B52");
        if (r103 == null) goto L16;
        int r104 = r103.intValue();
        r102.j0(r104);
        r102.l0(r104);
        return;
    L16:
        return;
    L6:
        if (r101.intValue() != 2) goto L10;
        Integer r105 = com.bytedance.android.ec.core.utils.s.b("#9E2DF5");
        if (r105 == null) goto L14;
        int r106 = r105.intValue();
        r102.j0(r106);
        r102.l0(r106);
        return;
    }
}
