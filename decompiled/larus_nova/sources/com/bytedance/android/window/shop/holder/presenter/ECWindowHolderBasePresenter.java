package com.bytedance.android.window.shop.holder.presenter;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ECWindowHolderBasePresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f187997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f187998f;

    public final ECWindowViewModel D() {
        return (ECWindowViewModel) this.f187997e.getValue();
    }

    public final LifecycleOwner E() {
        ECWindowDialogFragment r100 = (ECWindowDialogFragment) this.f187998f.getValue();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return ECQuickUtilKt.a(u());
    }

    public ECWindowHolderBasePresenter() {
        this.f187997e = LazyKt.lazy(new ECWindowHolderBasePresenter$viewModel$2(this));
        this.f187998f = LazyKt.lazy(new ECWindowHolderBasePresenter$dialogFragment$2(this));
    }
}
