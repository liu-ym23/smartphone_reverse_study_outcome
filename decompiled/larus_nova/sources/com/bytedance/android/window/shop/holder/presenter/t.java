package com.bytedance.android.window.shop.holder.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t extends ECWindowHolderBaseFragmentPresenter {
    public t(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r101 = com.bytedance.android.window.shop.lifecycle.c.f189233a;
        com.bytedance.android.window.shop.lifecycle.f r102 = com.bytedance.android.window.shop.lifecycle.c.a(d0().getShopParam().getLifecycleMonitorId());
        if (r102 == null) goto L6;
        r102.u();
        return;
    }
}
