package com.bytedance.android.shopping.new_cart.components;

import android.content.Context;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.new_cart.container.CartDialogFragment;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends a implements ECCartErrorView.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECCartErrorView f178824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f178825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewStub f178826d;

    @Override // com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView.a
    public final void a() {
        bg3.a r100 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.g(this.f178820a.f178934d, "ErrorView-onRetry", "", MapsKt.emptyMap());
        CartViewModel.doQuery$default(this.f178820a.f178934d, true, "reload", null, 4, null);
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView.a
    public final void b() {
        bg3.a r100 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.g(this.f178820a.f178934d, "ErrorView-onAdvice", "", MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        if (this.f178824b != null) goto L8;
        com.bytedance.android.shopping.new_cart.utils.a.f179359c.d("initErrorView", new c(this));
        ECCartErrorView r100 = this.f178824b;
        if (r100 == null) goto L9;
        r100.setCallback(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView.a
    public final void onBack() {
        bg3.a r100 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.g(this.f178820a.f178934d, "ErrorView-onBack", "", MapsKt.emptyMap());
        Context r101 = e();
        Fragment r102 = null;
        if ((r101 instanceof NewCartActivity) == true) goto L5;
        r101 = null;
    L5:
        NewCartActivity r103 = (NewCartActivity) r101;
        if (r103 == null) goto L8;
        r103.finish();
    L8:
        Fragment r104 = this.f178820a.f178936f;
        if ((r104 instanceof CartDialogFragment) == false) goto L12;
        r102 = r104;
    L12:
        CartDialogFragment r105 = (CartDialogFragment) r102;
        if (r105 == null) goto L23;
        r105.dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r106 = DialogFragmentLancet.sLastShowStack;
        if (r106 == null) goto L24;
        com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L24:
        return;
    }

    public d(CartObjectContainer r100, ViewStub r101) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        super(r100);
        this.f178826d = r101;
    }
}
