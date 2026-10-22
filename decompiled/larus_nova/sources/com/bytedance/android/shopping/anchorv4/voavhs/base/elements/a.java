package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CouponButtonElementViewV2 f167870a;

    public a(CouponButtonElementViewV2 r100) {
        this.f167870a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        TextWithOneIconElementView r109 = this.f167870a.f167832b;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L7;
        LinearLayout.LayoutParams r111 = (LinearLayout.LayoutParams) r110;
        r111.height = this.f167870a.f167833c.getHeight();
        Unit r112 = Unit.INSTANCE;
        r109.setLayoutParams(r111);
        this.f167870a.f167833c.removeOnLayoutChangeListener(this);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
