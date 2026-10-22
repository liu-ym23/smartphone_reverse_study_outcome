package com.bytedance.android.shopping.store.shopfeed.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.ec.core.arch.viewmodel.b;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.shopping.store.shopfeed.ECShopInnerFlowShareHelper;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/fragment/AbsShopFeedFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsShopFeedFragment extends Fragment implements QViewModelOwner {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final QUIManager f186168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f186169e;

    public abstract int S90();

    public abstract String T90();

    public abstract Class<? extends QUIModule> U90();

    public abstract QUIModule V90(View r100);

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner
    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public AbsShopFeedFragment() {
        this.f186168d = new QUIManager();
        Function0<ViewModelProvider.Factory> r100 = new AbsShopFeedFragment$viewModel$2(this);
        final Function0<Fragment> r101 = new AbsShopFeedFragment$$special$$inlined$viewModels$1(this);
        this.f186169e = b.a(this, Reflection.getOrCreateKotlinClass(ECShopFeedViewModel.class), new AbsShopFeedFragment$$special$$inlined$viewModels$2(r101), r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f186168d.r(U90());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        int r100 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L7;
        com.bytedance.sdk.xbridge.cn.ui.utils.a.h(r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Lazy r101 = BtmSDKWrapper.f41960a;
        String r102 = T90();
        Bundle r103 = getArguments();
        if (r103 == null) goto L5;
        String r104 = r103.getString(PhotoEnterModel.SOURCE_BTM_TOKEN);
    L6:
        BtmSDKWrapper.b(this, r102, r104);
        Context r105 = getContext();
        if (r105 == null) goto L10;
        ((ECShopFeedViewModel) this.f186169e.getValue()).initParam(getArguments(), r105, this instanceof ECShopInnerFlowFragment);
        ((ECShopFeedViewModel) this.f186169e.getValue()).setShareHelper(new ECShopInnerFlowShareHelper(this));
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f186168d.c(U90(), null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = th.a.c(requireContext(), R.layout.ec_shop_feed_fragment, null, false);
        View r104 = r103.findViewById(R.id.ec_shop_feed_root);
        if (r104 == null) goto L5;
        r104.setBackgroundColor(S90());
    L5:
        pn.b.a(this.f186168d, V90(r103), requireContext(), this);
        return this.f186168d.p();
    }
}
