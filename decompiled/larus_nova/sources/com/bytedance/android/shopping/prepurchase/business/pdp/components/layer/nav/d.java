package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f181243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IAction f181244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f181245c;

    public d(FrameLayout r100, IAction r101, e r102) {
        this.f181243a = r100;
        this.f181244b = r101;
        this.f181245c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f181245c.f181254i.invoke(this.f181243a, this.f181244b);
    }
}
