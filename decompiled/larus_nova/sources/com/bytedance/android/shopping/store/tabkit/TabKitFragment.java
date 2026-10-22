package com.bytedance.android.shopping.store.tabkit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.extensions.m;
import com.bytedance.android.shopping.store.tabkit.container.BottomSheetTransparentActivity;
import com.bytedance.android.shopping.store.tabkit.container.TabKitActivity;
import com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior;
import com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetFragment;
import com.bytedance.android.shopping.store.tabkit.container.TabKitCompactActivity;
import com.bytedance.android.shopping.store.tabkit.container.TabKitDialogFragment;
import com.bytedance.android.shopping.store.tabkit.container.TabKitFoldFragment;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.tabkit.view.PadAdapterFrameLayout;
import com.bytedance.android.shopping.store.utils.o;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lcom/bytedance/android/shopping/store/tabkit/f;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TabKitFragment extends Fragment implements QViewModelOwner, f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f186463h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TabKitViewModel f186464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Window f186465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TabKitPresenter f186466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f186467g;

    public static final class a {
        public static void a(Context r110, Class r111, Bundle r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "tabKitFragmentClass");
            Serializable r100 = r112.getSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS);
            Context r101 = null;
            if ((r100 instanceof TabKitRouterParams) == true) goto L5;
            r100 = null;
        L5:
            TabKitRouterParams r102 = (TabKitRouterParams) r100;
            if (r102 == null) goto L8;
            Integer r103 = r102.getPageModal();
        L9:
            boolean r104 = true;
            if (r103 != null) goto L13;
        L18:
            dm.a.a("TabKitFragment").i("open tabkit full-page, enable lite: " + r113);
            if (r113 == false) goto L52;
            boolean r114 = TabKitDialogFragment.f186703j;
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "tabKitFragmentClazz");
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L47
            long r106 = r112.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);     // Catch: Throwable -> L47
            Map<Long, TabkitFirstFramePref> r107 = ok3.a.f523622e;     // Catch: Throwable -> L47
            TabkitFirstFramePref r108 = ok3.a.C7061a.a(r106);     // Catch: Throwable -> L47
            if (r108 == null) goto L25;
            TabkitFramePref.recordTime$default(r108, "t_route_lite_page_start", null, 2, null);     // Catch: Throwable -> L47
        L25:
            if ((r110 instanceof FragmentActivity) == false) goto L28;
            r101 = r110;
        L28:
            FragmentActivity r109 = (FragmentActivity) r101;     // Catch: Throwable -> L47
            if (r109 == null) goto L49;
            FragmentManager r115 = r109.getSupportFragmentManager();     // Catch: Throwable -> L47
            if (r115 == null) goto L49;
            String r116 = UUID.randomUUID().toString();     // Catch: Throwable -> L47
            TabKitDialogFragment r117 = new TabKitDialogFragment();     // Catch: Throwable -> L47
            Bundle r118 = new Bundle();     // Catch: Throwable -> L47
            r118.putSerializable("tabkit_fragment_clazz", r111);     // Catch: Throwable -> L47
            r118.putBundle("biz_arguments", r112);     // Catch: Throwable -> L47
            r118.putString("key_tabkit_root_fragment_id", r116);     // Catch: Throwable -> L47
            Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L47
            r117.setArguments(r118);     // Catch: Throwable -> L47
            com.bytedance.android.shopping.store.tabkit.container.i.a("show fragment now, unique id: " + r116);     // Catch: Throwable -> L47
            if (TabKitDialogFragment.f186703j == false) goto L41;
            LandscapeRestrictionOperation r120 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Throwable -> L47
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r117, "tabkit_dialog_fragment", r120);     // Catch: Throwable -> L47
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r115, r117, r120) == false) goto L59;
        L50:
            if (r104 == true) goto L62;
            int r121 = TabKitActivity.f186653e;
            TabKitActivity.a.a(r110, r111, r112);
            return;
        L62:
            return;
        L59:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54 Throwable -> L47
        L40:
            r117.showNow(r115, "tabkit_dialog_fragment");     // Catch: Throwable -> L47
            goto L50
        L41:
            LandscapeRestrictionOperation r122 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L47
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r117, "tabkit_dialog_fragment", r122);     // Catch: Throwable -> L47
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r115, r117, r122) == true) goto L50;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55 Throwable -> L47
        L45:
            r117.show(r115, "tabkit_dialog_fragment");     // Catch: Throwable -> L47
        L49:
            r104 = false;
        L47:
            th = move-exception;
            Result.Companion r123 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L49
        L52:
            int r124 = TabKitActivity.f186653e;
            TabKitActivity.a.a(r110, r111, r112);
            return;
        L13:
            if (r103.intValue() != 1) goto L18;
            int r125 = BottomSheetTransparentActivity.f186647e;
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "tabKitFragmentClass");
            long r126 = r112.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
            Map<Long, TabkitFirstFramePref> r127 = ok3.a.f523622e;
            TabkitFirstFramePref r128 = ok3.a.C7061a.a(r126);
            if (r128 == null) goto L17;
            TabkitFramePref.recordTime$default(r128, "t_route_activity_start", null, 2, null);
        L17:
            Intent r129 = new Intent(r110, BottomSheetTransparentActivity.class);
            r129.putExtra("tabkit_fragment_clazz", r111);
            r129.putExtra("biz_arguments", r112);
            Unit r130 = Unit.INSTANCE;
            r110.startActivity(r129);
            return;
        L8:
            r103 = null;
            goto L9
        }
    }

    static {
    }

    public Integer tv() {
        return null;
    }

    public ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public TabKitFragment() {
        this.f186466f = new TabKitPresenter(this);
        this.f186467g = 1.0f;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final void Ju() {
        Fragment r100 = getParentFragment();
        if ((r100 instanceof TabKitBottomSheetFragment) == true) goto L5;
        r100 = null;
    L5:
        TabKitBottomSheetFragment r101 = (TabKitBottomSheetFragment) r100;
        if (r101 == null) goto L11;
        r101.f186643i = false;
        TabKitBottomSheetBehavior<View> r102 = r101.f186638d;
        if (r102 == null) goto L12;
        r102.setHideable(false);
        return;
    L12:
        return;
    }

    public void S90() {
        Mc().W(2);
    }

    public void finish() {
        if ((getActivity() instanceof TabKitActivity) == false) goto L5;
    L41:
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L56;
        r100.finish();
        return;
    L56:
        return;
    L5:
        if ((getActivity() instanceof TabKitCompactActivity) == true) goto L41;
        if ((getParentFragment() instanceof TabKitBottomSheetFragment) == false) goto L21;
        Fragment r101 = getParentFragment();
        if (r101 == null) goto L19;
        ((TabKitBottomSheetFragment) r101).dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L49;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L49:
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetFragment");
    L21:
        if ((getParentFragment() instanceof TabKitDialogFragment) == false) goto L34;
        Fragment r103 = getParentFragment();
        if (r103 == null) goto L32;
        ((TabKitDialogFragment) r103).dismissAllowingStateLoss();     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L51;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L51:
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.container.TabKitDialogFragment");
    L34:
        if ((getParentFragment() instanceof TabKitFoldFragment) == false) goto L53;
        nj.d r105 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r105 == null) goto L54;
        getActivity();
        TabKitViewModel r106 = this.f186464d;
        if (r106 == null) goto L40;
        r106.getFoldType();
    L40:
        r105.m();
        return;
    L54:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final void jC() {
        Fragment r100 = getParentFragment();
        if ((r100 instanceof TabKitBottomSheetFragment) == true) goto L5;
        r100 = null;
    L5:
        TabKitBottomSheetFragment r101 = (TabKitBottomSheetFragment) r100;
        if (r101 == null) goto L11;
        r101.f186644j = false;
        TabKitBottomSheetBehavior<View> r102 = r101.f186638d;
        if (r102 == null) goto L12;
        r102.f186662e = false;
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Mc().unbind();
        Configuration r100 = getResources().getConfiguration();
        r100.fontScale = this.f186467g;
        Resources r101 = requireActivity().getResources();
        Resources r102 = requireActivity().getResources();
        r101.updateConfiguration(r100, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public TabKitPresenter Mc() {
        return this.f186466f;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final TabKitViewModel getTabKitViewModel() {
        return this.f186464d;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final void ay(boolean r100) {
        Window r101 = this.f186465e;
        if (r101 == null) goto L6;
        m.a(r101, r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        TabKitViewModel r101 = (TabKitViewModel) new ViewModelProvider(this, o6()).get(TabKitViewModel.class);
        this.f186464d = r101;
        if (r101 == null) goto L6;
        r101.prepare(getArguments());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        TabKitViewModel r101 = this.f186464d;
        if (r101 == null) goto L5;
        r101.init(getArguments());
    L5:
        Configuration r102 = getResources().getConfiguration();
        this.f186467g = r102.fontScale;
        r102.fontScale = o.f186937a;
        Resources r103 = requireActivity().getResources();
        Resources r104 = requireActivity().getResources();
        r103.updateConfiguration(r102, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()));
        cl.d.f24079a.getClass();
        cl.d r105 = cl.d.a.b();
        if (r105 == null) goto L9;
        r105.n();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Mc().J(null, r100, null);
        TabKitViewModel r102 = this.f186464d;
        if (r102 == null) goto L10;
        TabKitRouterParams r103 = r102.getRouterParams();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.getEnableGrey() != true) goto L12;
        int r104 = com.bytedance.android.ec.hybrid.list.a.f46933a;
        com.bytedance.android.ec.hybrid.list.a.b(getView());
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.f
    public final void z5(int r100, boolean r101) {
        Fragment r102 = getParentFragment();
        if ((r102 instanceof TabKitBottomSheetFragment) == true) goto L5;
        r102 = null;
    L5:
        TabKitBottomSheetFragment r103 = (TabKitBottomSheetFragment) r102;
        if (r103 != null) goto L9;
        return;
    L9:
        if (r100 != 1) goto L11;
        r103.X90(1);
        return;
    L11:
        r103.X90(2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Mc().getClass();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        TabKitViewModel r103 = this.f186464d;
        if (r103 == null) goto L5;
        r103.clearFragments();
    L5:
        ShoppingAsyncInflater.a r104 = ShoppingAsyncInflater.f45268e;
        Context r105 = requireContext();
        r104.getClass();
        boolean r106 = false;
        View r107 = ShoppingAsyncInflater.a.a(r105).aU(R.layout.ec_tabkit_fragment_h5, r101, false);
        PadAdapterFrameLayout r108 = new PadAdapterFrameLayout(r100.getContext(), null, 6, 0);
        r108.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TabKitViewModel r109 = this.f186464d;
        if (r109 == null) goto L12;
        TabKitRouterParams r110 = r109.getRouterParams();
        if (r110 == null) goto L12;
        if (r110.getEnablePadAdapter() != true) goto L12;
        r106 = true;
    L12:
        r108.setEnablePadAdapter(r106);
        TabKitViewModel r111 = this.f186464d;
        if (r111 == null) goto L17;
        TabKitRouterParams r112 = r111.getRouterParams();
        if (r112 == null) goto L17;
        r108.setRatio(r112.getPadRatio());
    L17:
        r108.addView(r107);
        return r108;
    }
}
