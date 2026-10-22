package com.bytedance.android.shopping.anchorv4.voavhs.car;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f168085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f168086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnchorV4CarAddressView f168087c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        float r100 = this.f168085a / this.f168086b;
        AnchorV4CarAddressView.a(this.f168087c).setPivotX(0.0f);
        AnchorV4CarAddressView.a(this.f168087c).setPivotY(0.0f);
        AnchorV4CarAddressView.a(this.f168087c).setScaleX(r100);
        AnchorV4CarAddressView.a(this.f168087c).setScaleY(r100);
        AnchorV4CarAddressView.a(this.f168087c).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        float r101 = r100 * AnchorV4CarAddressView.a(this.f168087c).getMeasuredHeight();
        LinearLayout r102 = AnchorV4CarAddressView.a(this.f168087c);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.height = (int) r101;
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
    }

    public c(int r100, int r101, AnchorV4CarAddressView r102) {
        this.f168085a = r100;
        this.f168086b = r101;
        this.f168087c = r102;
    }
}
