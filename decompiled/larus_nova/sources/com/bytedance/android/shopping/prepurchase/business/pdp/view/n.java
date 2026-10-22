package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f182290a;

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.i
    public final int[] getLocationOnScreen() {
        int[] r100 = {0, 0};
        this.f182290a.getLocationOnScreen(r100);
        return r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.i
    public final int getHeight() {
        return this.f182290a.getHeight();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.i
    public final int getWidth() {
        return this.f182290a.getWidth();
    }

    public n(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f182290a = r100;
    }
}
