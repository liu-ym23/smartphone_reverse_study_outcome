package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import android.widget.CheckBox;
import com.bytedance.android.shopping.anchorv3.matchpurchase.MatchPurchaseHelper;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes12.dex */
public final class v<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f165170a;

    public v(x r100) {
        this.f165170a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (MatchPurchaseHelper.a() == false) goto L6;
        ((CheckBox) this.f165170a.Z().b(R.id.cb_select_all_or_none).f()).setChecked(r101.booleanValue());
        return;
    }
}
