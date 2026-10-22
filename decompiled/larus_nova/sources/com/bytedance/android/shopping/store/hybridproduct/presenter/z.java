package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class z<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSliceProductFilterPresenter f185405a;

    public z(ShopSliceProductFilterPresenter r100) {
        this.f185405a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) r100, r101) == false) goto L9;
        com.bytedance.android.ec.store.repository.vo.k r102 = this.f185405a.f185281i;
        if (r102 == null) goto L14;
        Map<String, Object> r103 = r102.f185017d;
        if (r103 == null) goto L14;
        r103.put("select_panel_has_select", r101);
    L14:
        this.f185405a.d0();
        return;
    L9:
        com.bytedance.android.ec.store.repository.vo.k r104 = this.f185405a.f185281i;
        if (r104 == null) goto L14;
        Map<String, Object> r105 = r104.f185017d;
        if (r105 == null) goto L14;
        r105.put("select_panel_has_select", Boolean.FALSE);
        goto L14
    }
}
