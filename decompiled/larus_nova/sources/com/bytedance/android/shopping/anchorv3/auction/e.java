package com.bytedance.android.shopping.anchorv3.auction;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuctionOfferRecordsViewModel f164481a;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    public e(AuctionOfferRecordsViewModel r100) {
        this.f164481a = r100;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 != 5) goto L6;
        this.f164481a.closePage();
        return;
    }
}
