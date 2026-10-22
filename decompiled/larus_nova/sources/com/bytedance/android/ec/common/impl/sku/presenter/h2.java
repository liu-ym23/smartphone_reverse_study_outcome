package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import com.bytedance.android.ec.core.widget.StatusView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class h2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m2 f43232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f43233b;

    public h2(m2 r100, Ref.ObjectRef r101) {
        this.f43232a = r100;
        this.f43233b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        rg.b r101 = (rg.b) r100;
        StatusView r102 = (StatusView) this.f43232a.Z().b(R.id.sv_sku_status_view).f();
        int r103 = g2.f43228a[r101.f537664a.ordinal()];
        if (r103 != 1) goto L5;
        this.f43232a.Z().b(R.id.ll_sku_panel_container).f().setVisibility(4);
        r102.showLoading();
        return;
    L5:
        if (r103 != 2) goto L7;
        this.f43232a.Z().b(R.id.ll_sku_panel_container).f().setVisibility(0);
        r102.reset();
        return;
    L7:
        if (r103 != 3) goto L39;
        this.f43232a.Z().b(R.id.ll_sku_panel_container).f().setVisibility(4);
        if (r101.f537665b != 0) goto L12;
    L23:
        View r104 = (View) this.f43233b.element;
        if (r104 == null) goto L28;
        View r105 = r104.findViewById(R.id.tv_ec_common_refresh);
        if (r105 == null) goto L28;
        r105.setVisibility(0);
    L28:
        View r106 = (View) this.f43233b.element;
        if (r106 == null) goto L33;
        View r107 = r106.findViewById(R.id.tv_ec_common_refresh_description);
        if (r107 == null) goto L33;
        r107.setVisibility(0);
    L33:
        r102.setVisibility(0);
        r102.setECStatus(2);
        return;
    L12:
        if (com.bytedance.android.ec.core.abtest.d.v().contains(Double.valueOf(r101.f537665b)) == false) goto L23;
        View r108 = (View) this.f43233b.element;
        if (r108 == null) goto L18;
        View r109 = r108.findViewById(R.id.tv_ec_common_refresh);
        if (r109 == null) goto L18;
        r109.setVisibility(8);
    L18:
        View r110 = (View) this.f43233b.element;
        if (r110 == null) goto L33;
        View r111 = r110.findViewById(R.id.tv_ec_common_refresh_description);
        if (r111 == null) goto L33;
        r111.setVisibility(8);
        goto L33
    }
}
