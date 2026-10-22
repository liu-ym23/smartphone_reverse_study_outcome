package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class b0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f43176a;

    public b0(d0 r100) {
        this.f43176a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        TextView r102 = (TextView) this.f43176a.Z().b(R.id.tv_sku_user_limit).f();
        if (jg.g.a(r101) == false) goto L10;
        r102.setVisibility(0);
        r102.setText(r101);
        if (this.f43176a.Z().b(R.id.tv_sku_stock).f().getVisibility() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L12;
        this.f43176a.Z().b(R.id.tv_sku_divider).f().setVisibility(0);
        return;
    L12:
        return;
    L7:
        r103 = false;
        goto L8
    L10:
        r102.setVisibility(8);
        this.f43176a.Z().b(R.id.tv_sku_divider).f().setVisibility(8);
    }
}
