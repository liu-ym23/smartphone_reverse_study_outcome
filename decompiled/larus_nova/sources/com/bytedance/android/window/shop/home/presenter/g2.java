package com.bytedance.android.window.shop.home.presenter;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowTopInfoBarPresenter.b f188533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f188534b;

    public g2(ECWindowTopInfoBarPresenter.b r100, boolean r101) {
        this.f188533a = r100;
        this.f188534b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        ECWindowTopInfoBarPresenter r102 = this.f188533a.f188487a;
        int r103 = ECWindowTopInfoBarPresenter.f188478u;
        float r104 = r102.Y(r102.w().b(R.id.ec_shop_info_area_container_wrapper).f().getHeight());
        View r105 = this.f188533a.f188487a.f188481o;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L5:
        r105.setAlpha(r104);
        View r106 = this.f188533a.f188487a.f188481o;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L8:
        int r107 = 0;
        if (r104 <= 0) goto L11;
        int r108 = 0;
    L12:
        r106.setVisibility(r108);
        View r109 = this.f188533a.f188487a.f188480n;
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("topBarContainer");
    L15:
        com.bytedance.android.ec.window.base.utils.c.d(r109, new ColorDrawable(0));
        if (this.f188534b == false) goto L26;
        float r110 = this.f188533a.f188487a.Z(com.bytedance.android.shopping.extensions.b.b(74));
        ImageView r111 = this.f188533a.f188487a.f188485s;
        if (r111 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("enterLiveHint");
    L21:
        if (r110 <= 0.1d) goto L24;
        r107 = 8;
    L24:
        r111.setVisibility(r107);
        return;
    L26:
        return;
    L11:
        r108 = 8;
        goto L12
    }
}
