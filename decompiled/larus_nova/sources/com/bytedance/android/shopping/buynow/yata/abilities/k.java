package com.bytedance.android.shopping.buynow.yata.abilities;

import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f171298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f171299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f171300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BuyNowFragment f171301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BuyNowViewModel f171302e;

    public k(BuyNowFragment r100, BuyNowViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        this.f171301d = r100;
        this.f171302e = r101;
        this.f171298a = 3;
        this.f171299b = new AtomicBoolean(false);
        this.f171300c = new AtomicBoolean(false);
    }
}
