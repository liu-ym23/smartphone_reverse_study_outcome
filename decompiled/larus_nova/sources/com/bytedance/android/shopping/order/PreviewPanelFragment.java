package com.bytedance.android.shopping.order;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.sdk.helper.o;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.common.utility.UIUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/order/PreviewPanelFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewPanelFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f179622y = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.order.a f179623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f179624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f179625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f179626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f179627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f179628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f179629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f179630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Button f179631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VideoHolder f179632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f179633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f179634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f179635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ECStatusView f179636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f179637r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f179638s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f179639t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PreviewPanelViewModel f179640u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public tl.a f179641v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public cg3.g f179642w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Context f179643x;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewPanelFragment f179644a;

        public b(PreviewPanelFragment r100) {
            this.f179644a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dialog r100 = this.f179644a.getDialog();     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            Window r101 = r100.getWindow();     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.setWindowAnimations(R.style.commerce_dialog_dim_non_enter_animation);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f179645a;

        public c(BottomSheetBehavior r100) {
            this.f179645a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f179645a.setState(5);
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        PreviewPanelViewModel r100 = this.f179640u;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        Integer r101 = r100.getPanelState().getValue();
        if (r101 != null) goto L9;
    L10:
        com.bytedance.android.shopping.order.a r102 = this.f179623d;
        if (r102 == null) goto L13;
        r102.b();
    L13:
        ECStatusView r103 = this.f179636q;
        if (r103 == null) goto L16;
        r103.a();
    L16:
        Function0<Unit> r104 = this.f179624e;
        if (r104 == null) goto L19;
        Unit r105 = r104.invoke();
    L19:
        this.f179624e = null;
        PreviewPanelViewModel r106 = this.f179640u;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r106.unbind();
        VideoHolder r107 = this.f179632m;
        if (r107 == null) goto L27;
        PlayerBlock r108 = r107.f164878g;
        if (r108 == null) goto L27;
        r108.B();
    L27:
        super.onDestroyView();
        return;
    L9:
        if (r101.intValue() == 1) goto L13;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        VideoHolder r100 = this.f179632m;
        if (r100 == null) goto L7;
        PlayerBlock r101 = r100.f164878g;
        if (r101 == null) goto L7;
        int r102 = PlayerBlock.T;
        r101.C(false);
    L7:
        super.onPause();
    }

    public PreviewPanelFragment() {
        this.f179625f = "";
        this.f179626g = CollectionsKt.emptyList();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        View r100 = getView();     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        r100.postDelayed(new b(this), 300);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        ViewGroup.LayoutParams r101 = null;
        if ((r100 instanceof BottomSheetDialog) == true) goto L5;
        r100 = null;
    L5:
        BottomSheetDialog r102 = (BottomSheetDialog) r100;
        if (r102 == null) goto L12;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L12;
        View r104 = r103.findViewById(R.id.design_bottom_sheet);
        if (r104 == null) goto L12;
        r104.setBackgroundDrawable(new ColorDrawable(0));
    L12:
        if (r102 == null) goto L16;
        AppCompatDelegate r105 = r102.getDelegate();
        if (r105 == null) goto L16;
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.design_bottom_sheet);
    L17:
        if (r106 == null) goto L29;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof CoordinatorLayout.LayoutParams) == false) goto L22;
        r101 = r107;
    L22:
        CoordinatorLayout.LayoutParams r108 = (CoordinatorLayout.LayoutParams) r101;
        if (r108 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r108).height = (int) UIUtils.dip2Px(getContext(), 537.0f);
    L25:
        r106.setLayoutParams(r108);
        BottomSheetBehavior r109 = BottomSheetBehavior.from(r106);
        r109.setPeekHeight((int) UIUtils.dip2Px(getContext(), 537.0f));
        r109.setState(3);
        View r110 = this.f179629j;
        if (r110 == null) goto L30;
        r110.setOnClickListener(new c(r109));
        return;
    L30:
        return;
    L29:
        return;
    L16:
        r106 = null;
        goto L17
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        Dialog r101 = getDialog();
        if (r101 == null) goto L5;
        r101.requestWindowFeature(1);
    L5:
        super.onCreate(r100);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Context r101 = getContext();
        Intrinsics.checkNotNull(r101);
        return new BottomSheetDialog(r101);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FragmentActivity r102 = getActivity();
        Intrinsics.checkNotNull(r102);
        this.f179640u = (PreviewPanelViewModel) ViewModelProviders.of(r102).get(PreviewPanelViewModel.class);
        if (r100 == null) goto L14;
        this.f179629j = r100.findViewById(R.id.close_panel_btn);
        this.f179630k = (FrameLayout) r100.findViewById(R.id.preview_video_holder);
        this.f179631l = (Button) r100.findViewById(R.id.law_hint_agree_but);
        this.f179633n = (TextView) r100.findViewById(R.id.video_title);
        this.f179634o = (TextView) r100.findViewById(R.id.video_content);
        this.f179636q = (ECStatusView) r100.findViewById(R.id.load_status_icon);
        Context r103 = getContext();
        if (r103 == null) goto L10;
        ECStatusView r104 = this.f179636q;
        if (r104 == null) goto L10;
        r104.b(r103, null, null);
    L10:
        this.f179637r = r100.findViewById(R.id.logo);
        this.f179638s = r100.findViewById(R.id.default_bg);
        this.f179639t = r100.findViewById(R.id.comment_content_first_line);
        PreviewPanelViewModel r105 = this.f179640u;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        r105.init();
    L14:
        PreviewPanelViewModel r106 = this.f179640u;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r106.getPanelState().observe(this, new d(this));
        PreviewPanelViewModel r107 = this.f179640u;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r107.getShareInfoVOState().observe(this, new e(this));
        Button r108 = this.f179631l;
        if (r108 == null) goto L23;
        r108.setOnClickListener(new PreviewPanelFragment$initSubscribe$3(this));
    L23:
        ECStatusView r109 = this.f179636q;
        if (r109 == null) goto L26;
        r109.c();
    L26:
        this.f179624e = o.f48129a.a(getContext(), this.f179626g, this.f179625f, new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = getContext();
        if (r103 != null) goto L7;
        return null;
    L7:
        return th.a.c(r103, R.layout.ec_commerce_anchor_v3_preview_panel_layout, r101, false);
    }
}
