package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.window.shop.repository.vo.ShopComponentResponseVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;

/* JADX INFO: loaded from: classes14.dex */
public final class s0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f188627a;

    public s0(t0 r100) {
        this.f188627a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = ((ShopComponentResponseVO) r100).getExtraSchema();
        if (com.bytedance.android.shopping.extensions.k.c(r101) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L14;
        t0 r102 = this.f188627a;
        if (r102.f188633m != null) goto L10;
        r102.f188633m = new PthreadTimer("ECWindowExtraAibilityPresenter$openExtraSchema$1");
    L10:
        t0 r103 = this.f188627a;
        r103.f188634n = new r0(r101, this);
        t0 r104 = this.f188627a;
        Timer r105 = r104.f188633m;
        if (r105 == null) goto L15;
        r105.schedule(r104.f188634n, 500);
        return;
    L15:
        return;
    }
}
