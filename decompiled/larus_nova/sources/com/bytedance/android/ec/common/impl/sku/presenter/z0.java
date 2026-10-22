package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class z0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f43332a;

    public z0(f1 r100) {
        this.f43332a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        TextView r101 = (TextView) this.f43332a.Z().b(R.id.tv_sku_select_spec).f();
        r101.setText((String) r100);
    }
}
