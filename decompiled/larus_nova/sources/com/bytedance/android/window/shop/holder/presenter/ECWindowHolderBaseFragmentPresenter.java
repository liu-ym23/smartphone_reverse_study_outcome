package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ECWindowHolderBaseFragmentPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f187994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f187995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f187996h;

    public final ECWindowViewModel d0() {
        return (ECWindowViewModel) this.f187995g.getValue();
    }

    public final LifecycleOwner e0() {
        ECWindowDialogFragment r100 = (ECWindowDialogFragment) this.f187996h.getValue();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return ECQuickUtilKt.a(Y());
    }

    public View h0() {
        View r100 = this.f187994f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return a0();
    }

    public ECWindowHolderBaseFragmentPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f187995g = LazyKt.lazy(new ECWindowHolderBaseFragmentPresenter$viewModel$2(this));
        this.f187996h = LazyKt.lazy(new ECWindowHolderBaseFragmentPresenter$dialogFragment$2(this));
    }
}
