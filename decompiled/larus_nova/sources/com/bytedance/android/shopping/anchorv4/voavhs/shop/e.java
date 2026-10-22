package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4ShopAndStoreView f170116a;

    public e(AnchorV4ShopAndStoreView r100) {
        this.f170116a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f170116a.findViewById(R.id.anchor_v4_shop_live_or_douyin_view_holder);     // Catch: Throwable -> L7
        View r101 = this.f170116a.f170080f;     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveOrDouyinViewBackground");     // Catch: Throwable -> L7
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();     // Catch: Throwable -> L7
        r102.width = r100.getWidth();     // Catch: Throwable -> L7
        r102.height = r100.getWidth();     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        r101.setLayoutParams(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
