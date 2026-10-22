package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.core.data.LoadingStatus;
import com.bytedance.android.ec.core.widget.StatusView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class p2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t2 f43270a;

    public p2(t2 r100) {
        this.f43270a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        StatusView r101 = (StatusView) this.f43270a.Z().b(R.id.sv_sku_status_view).f();
        LoadingStatus r102 = ((rg.b) r100).f537664a;
        int r103 = n2.f43262a[r102.ordinal()];
        if (r103 != 1) goto L5;
        this.f43270a.Z().b(R.id.ll_sku_panel_container).f().setVisibility(4);
        r101.showLoading();
        return;
    L5:
        if (r103 != 2) goto L7;
        this.f43270a.Z().b(R.id.ll_sku_panel_container).f().setVisibility(0);
        r101.reset();
        return;
    L7:
        if (r103 != 3) goto L15;
        r101.setVisibility(0);
        r101.setECStatus(2);
        return;
    }
}
