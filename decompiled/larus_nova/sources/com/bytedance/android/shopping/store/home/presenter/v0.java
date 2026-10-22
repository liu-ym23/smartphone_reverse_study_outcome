package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopLinkageHeaderVideoPresenter f184426a;

    public v0(ECShopLinkageHeaderVideoPresenter r100) {
        this.f184426a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L13;
        r101.booleanValue();
        View r102 = this.f184426a.A;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L8:
        if (r101.booleanValue() == false) goto L10;
        int r103 = R.drawable.shopping_ic_store_v3_live_sound_shut;
    L11:
        r102.setBackgroundResource(r103);
        return;
    L10:
        r103 = R.drawable.shopping_ic_store_v3_live_sound_open;
        goto L11
    }
}
