package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.matchpurchase.MatchPurchaseHelper;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchaseParams;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import q63.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/view/MatchPurchaseFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Landroid/content/Context;", "getContext", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchPurchaseFragment extends BottomSheetDialogFragment implements QViewModelOwner {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f165209g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.ec.core.arch.viewmodel.c f165210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final QUIManager f165211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f165212f;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchPurchaseFragment f165213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MatchPurchaseParams f165214b;

        public static final class a extends BottomSheetBehavior.BottomSheetCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BottomSheetBehavior f165215a;

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View r100, float r101) {
                Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            }

            public a(BottomSheetBehavior<FrameLayout> r100) {
                this.f165215a = r100;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View r100, int r101) {
                Intrinsics.checkNotNullParameter(r100, "bottomSheet");
                if (r101 != 1) goto L6;
                this.f165215a.setState(3);
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv3.matchpurchase.view.MatchPurchaseFragment$b$b, reason: collision with other inner class name */
        public static final class ViewOnTouchListenerC2512b implements View.OnTouchListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f165216a;

            public ViewOnTouchListenerC2512b(b r100) {
                this.f165216a = r100;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View r100, MotionEvent r101) {
                if (r101.getAction() != 0) goto L5;
                MatchPurchaseFragment r102 = this.f165216a.f165213a;
                int r103 = MatchPurchaseFragment.f165209g;
                ((MatchPurchaseGroupViewModel) r102.f165210d.getValue()).closeMatchPurchasePage();
            L5:
                r100.performClick();
                return false;
            }
        }

        public b(MatchPurchaseFragment r100, MatchPurchaseParams r101) {
            this.f165213a = r100;
            this.f165214b = r101;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            if (r100 == null) goto L15;
            BottomSheetDialog r101 = (BottomSheetDialog) r100;
            FrameLayout r102 = (FrameLayout) r101.findViewById(R.id.design_bottom_sheet);
            if (r102 == null) goto L10;
            n1.a r103 = n1.f45660i;
            MatchPurchaseParams r104 = this.f165214b;
            if (r104 == null) goto L8;
            Integer r105 = r104.getHeightPercent();
        L9:
            r103.getClass();
            int r106 = n1.a.a(r105, n1.a.b());
            r102.getLayoutParams().height = r106;
            r102.setLayoutParams(r102.getLayoutParams());
            MatchPurchaseFragment r107 = this.f165213a;
            BottomSheetBehavior r108 = BottomSheetBehavior.from(r102);
            r108.setPeekHeight(r106);
            r108.setSkipCollapsed(true);
            r108.setHideable(false);
            r108.setBottomSheetCallback(new a(r108));
            Unit r109 = Unit.INSTANCE;
            int r110 = MatchPurchaseFragment.f165209g;
            r107.getClass();
            goto L10
        L8:
            r105 = null;
        L10:
            View r111 = r101.findViewById(R.id.touch_outside);
            if (r111 == null) goto L16;
            r111.setOnTouchListener(new ViewOnTouchListenerC2512b(this));
            return;
        L16:
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (this.f165212f != null) goto L10;
        Context r100 = super.getContext();
        if (r100 == null) goto L7;
        Context r101 = th.a.e(r100, true);
    L8:
        this.f165212f = r101;
        goto L10
    L7:
        r101 = null;
    L10:
        return this.f165212f;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner
    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f165211e.r(f.class);
        Lazy r100 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L5;
        TrackCatcher.b("match_purchase");
    L5:
        super.onDestroy();
    }

    public MatchPurchaseFragment() {
        Function0<ViewModelProvider.Factory> r100 = new MatchPurchaseFragment$viewModel$2(this);
        final Function0<Fragment> r101 = new MatchPurchaseFragment$$special$$inlined$viewModels$1(this);
        this.f165210d = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(MatchPurchaseGroupViewModel.class), new MatchPurchaseFragment$$special$$inlined$viewModels$2(r101), r100);
        this.f165211e = new QUIManager();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        ((MatchPurchaseGroupViewModel) this.f165210d.getValue()).getRepository().a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Bundle r101 = getArguments();
        Serializable r102 = null;
        if (r101 == null) goto L5;
        Serializable r103 = r101.getSerializable("match_purchase_param");
    L7:
        if ((r103 instanceof MatchPurchaseParams) == false) goto L10;
        r102 = r103;
    L10:
        MatchPurchaseParams r104 = (MatchPurchaseParams) r102;
        Dialog r105 = getDialog();
        if (r105 == null) goto L13;
        r105.setOnShowListener(new b(this, r104));
    L13:
        this.f165211e.c(f.class, r104);
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        com.bytedance.android.ec.monitor.duration.d r101 = i.f47987a.get(MatchPurchaseHelper.f165132a);
        if (r101 == null) goto L5;
        r101.a("render_start");
    L5:
        setStyle(0, R.style.match_purchase_dialog_dim);
        Bundle r102 = getArguments();
        String r103 = null;
        if (r102 == null) goto L8;
        Serializable r104 = r102.getSerializable("match_purchase_param");
    L10:
        if ((r104 instanceof MatchPurchaseParams) == true) goto L12;
        r104 = null;
    L12:
        MatchPurchaseParams r105 = (MatchPurchaseParams) r104;
        BtmSDK r106 = BtmSDK.INSTANCE;
        if (r105 == null) goto L15;
        r103 = r105.getSourceBtmToken();
    L15:
        r106.registerBtmPageOnCreate(this, "a1.b08434", r103);
        ((MatchPurchaseGroupViewModel) this.f165210d.getValue()).setPageId(r106.getPageId(PageFinder.via(this)));
        return;
    L8:
        r104 = null;
        goto L10
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Context r101 = getContext();
        Intrinsics.checkNotNull(r101);
        return new FixedDialog(r101, getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ((MatchPurchaseGroupViewModel) this.f165210d.getValue()).getPageClosed().b(this, new e(this));
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void showNow(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if (r100.findFragmentByTag(r101) == null) goto L6;
        return;
    L6:
        Activity r102 = ECAppInfoService.f48114e.getCurrentActivity();     // Catch: Exception -> L16
        if (r102 != null) goto L9;
    L10:
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L16
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r103);     // Catch: Exception -> L16
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r103) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L14:
        super.showNow(r100, r101);     // Catch: Exception -> L16
        return;
    L25:
        return;
    L9:
        if (r102.isFinishing() != true) goto L10;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = getContext();
        if (r103 == null) goto L5;
        View r104 = th.a.c(r103, R.layout.shopping_layout_match_purchase_live, r101, false);
    L6:
        QUIManager r105 = this.f165211e;
        if (r104 == null) goto L14;
        r105.k(new f((ViewGroup) r104), th.a.e(requireContext(), true), this);
        Lazy r106 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.a("match_purchase");
    L12:
        return this.f165211e.p();
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r104 = null;
        goto L6
    }
}
