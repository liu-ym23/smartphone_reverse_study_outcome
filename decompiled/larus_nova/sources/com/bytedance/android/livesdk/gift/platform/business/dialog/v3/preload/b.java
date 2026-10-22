package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements AsyncLayoutInflater.OnInflateFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftPanelViewPreloadService f128183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GiftPanelPreloadView f128184b;

    public b(GiftPanelViewPreloadService r100, GiftPanelPreloadView r101) {
        this.f128183a = r100;
        this.f128184b = r101;
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final /* synthetic */ void onCancel(int r100) {
        AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        GiftPanelViewPreloadService r103 = this.f128183a;
        if (r103.f128165c == true) goto L5;
        return;
    L5:
        GiftPanelPreloadViewModel r104 = r103.f128168f;
        if (r104 == null) goto L9;
        r104.putView(this.f128184b, r100);
        return;
    }
}
