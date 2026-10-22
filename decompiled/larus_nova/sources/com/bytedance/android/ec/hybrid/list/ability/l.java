package com.bytedance.android.ec.hybrid.list.ability;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.list.view.WrapHeightDraweeView;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements vn.a.InterfaceC8022a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46995a;

    public l(String r100) {
        this.f46995a = r100;
    }

    @Override // vn.a.InterfaceC8022a
    public final void a(View r100) {
        if ((r100 instanceof FrameLayout) == false) goto L14;
        FrameLayout r101 = (FrameLayout) r100;
        if (r101.getChildCount() != 0) goto L8;
        WrapHeightDraweeView r102 = new WrapHeightDraweeView(r101.getContext());
        r102.setImageURI(this.f46995a);
        Unit r103 = Unit.INSTANCE;
        r101.addView(r102, new ViewGroup.LayoutParams(-1, -2));
        return;
    L8:
        if ((r101.getChildAt(0) instanceof WrapHeightDraweeView) == false) goto L16;
        View r104 = r101.getChildAt(0);
        if (r104 == null) goto L13;
        ((WrapHeightDraweeView) r104).setImageURI(this.f46995a);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.hybrid.list.view.WrapHeightDraweeView");
    L16:
        return;
    }
}
