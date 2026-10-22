package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class h0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f43230a;

    public h0(i0 r100) {
        this.f43230a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        TextView r102 = (TextView) this.f43230a.Z().b(R.id.tv_sku_user_limit).f();
        if (jg.g.a(r101) == false) goto L5;
        r102.setVisibility(0);
        r102.setText(r101);
        return;
    L5:
        r102.setVisibility(8);
    }
}
