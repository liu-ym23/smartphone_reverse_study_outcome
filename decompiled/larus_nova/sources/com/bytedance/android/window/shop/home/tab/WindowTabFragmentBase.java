package com.bytedance.android.window.shop.home.tab;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabFragmentBase;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabFragmentBase extends Fragment implements QViewModelOwner {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f188687g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public QUIManager f188688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.commerce.base.viewmodel.a f188689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final QLiveData<b> f188690f;

    public static final class a {
        public a() {
        }

        public static WindowTabFragmentBase a(String r100, String r101, long r102, boolean r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "categoryId");
            Intrinsics.checkNotNullParameter(r101, "categoryName");
            com.bytedance.android.window.shop.lifecycle.f r105 = com.bytedance.android.window.shop.lifecycle.c.a(r102);
            if (r105 == null) goto L5;
            r105.k();
        L5:
            WindowTabFragmentBase r106 = new WindowTabFragmentBase();
            Bundle r107 = new Bundle();
            r107.putInt("window_tab_type", r104);
            r107.putInt("SHOP_WINDOW_ITEM_TYPE", 100);
            r107.putString("window_tab_category_id", r100);
            r107.putString("window_tab_category_name", r101);
            r107.putLong("lifecycleMonitorId", r102);
            r107.putBoolean("window_tab_pre_create", r103);
            Unit r108 = Unit.INSTANCE;
            r106.setArguments(r107);
            return r106;
        }
    }

    static {
        new a();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner
    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        QUIManager r100 = this.f188688d;
        if (r100 == null) goto L5;
        r100.r(sp3.a.class);
    L5:
        super.onDestroy();
    }

    public WindowTabFragmentBase() {
        Function0<ViewModelProvider.Factory> r100 = new WindowTabFragmentBase$viewModel$2(this);
        final Function0<Fragment> r101 = new WindowTabFragmentBase$$special$$inlined$viewModels$1(this);
        this.f188689e = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(WindowTabViewModel.class), new WindowTabFragmentBase$$special$$inlined$viewModels$2(r101), r100);
        QLiveData<b> r102 = new QLiveData();
        r102.g(null);
        Unit r103 = Unit.INSTANCE;
        this.f188690f = r102;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 != null) goto L5;
    L7:
        Bundle r102 = getArguments();
        if (r102 == null) goto L11;
        String r103 = r102.getString("window_tab_category_id");
        if (r103 == null) goto L11;
    L12:
        Bundle r104 = getArguments();
        if (r104 == null) goto L16;
        String r105 = r104.getString("window_tab_category_name");
        if (r105 == null) goto L16;
    L17:
        Bundle r106 = getArguments();
        if (r106 == null) goto L20;
        int r107 = r106.getInt("window_tab_type");
    L21:
        ((WindowTabViewModel) this.f188689e.getValue()).setCategoryName(r105);
        ((WindowTabViewModel) this.f188689e.getValue()).prepareDataSource(r103, Integer.valueOf(r107));
    L22:
        Bundle r108 = getArguments();
        if (r108 == null) goto L29;
        long r109 = Long.valueOf(r108.getLong("lifecycleMonitorId")).longValue();
        com.bytedance.android.window.shop.lifecycle.f r110 = com.bytedance.android.window.shop.lifecycle.c.a(r109);
        if (r110 == null) goto L27;
        r110.l();
    L27:
        ((WindowTabViewModel) this.f188689e.getValue()).setLifecycleMonitorId(r109);
        return;
    L29:
        return;
    L20:
        r107 = 100;
    L16:
        r105 = "";
    L11:
        r103 = "-1";
        goto L12
    L5:
        if (r101.getBoolean("window_tab_pre_create") != true) goto L7;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        r100.putInt("SHOP_WINDOW_ITEM_TYPE", ((WindowTabViewModel) this.f188689e.getValue()).getShopWindowItemType().getType());
        super.onSaveInstanceState(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        QUIManager r102 = this.f188688d;
        if (r102 == null) goto L6;
        r102.c(sp3.a.class, null);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        QUIManager r103 = this.f188688d;
        if (r103 == null) goto L21;
        return r103.p();
    L21:
        View r104 = LayoutInflater.from(requireActivity()).inflate(R.layout.shopping_layout_fragment_tab_content_unpullable, null);     // Catch: Exception -> L9
    L10:
        this.f188688d = new QUIManager();
        Bundle r105 = getArguments();
        if (r105 != null) goto L13;
    L17:
        QUIManager r106 = this.f188688d;
        if (r106 == null) goto L20;
        com.bytedance.android.ec.window.base.utils.quick.d.a(r106, new sp3.a(r104, null), requireContext(), this);
    L20:
        return r104;
    L13:
        if (r105.getBoolean("window_tab_pre_create") != true) goto L17;
        QUIManager r107 = this.f188688d;
        if (r107 == null) goto L20;
        com.bytedance.android.ec.window.base.utils.quick.d.a(r107, new sp3.a(r104, this.f188690f), requireContext(), this);
    L9:
        Context r108 = requireContext();
        com.bytedance.android.ec.sdk.helper.c.f48117a.b("WINDOW", "window requireContext:" + r108.getClass());
        r104 = LayoutInflater.from(r108).inflate(R.layout.shopping_layout_fragment_tab_content_unpullable, null);
        goto L10
    }
}
