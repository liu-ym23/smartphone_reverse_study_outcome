package com.bytedance.android.shopping.anchorv3.view;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.adapter.BrandQualificationPicsAdapter;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormat;
import com.bytedance.common.utility.UIUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/BrandQualificationDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BrandQualificationDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f165501i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f165502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f165503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f165504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ProductFormat f165505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BrandQualificationPicsAdapter f165506h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BrandQualificationDialog f165507a;

        public b(BrandQualificationDialog r100) {
            this.f165507a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dialog r100 = this.f165507a.getDialog();     // Catch: Throwable -> L8
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

    static {
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
        if (r106 == null) goto L27;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof CoordinatorLayout.LayoutParams) == false) goto L22;
        r101 = r107;
    L22:
        CoordinatorLayout.LayoutParams r108 = (CoordinatorLayout.LayoutParams) r101;
        if (r108 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r108).height = (int) UIUtils.dip2Px(getContext(), 570.0f);
    L25:
        r106.setLayoutParams(r108);
        BottomSheetBehavior r109 = BottomSheetBehavior.from(r106);
        r109.setPeekHeight((int) UIUtils.dip2Px(getContext(), 570.0f));
        r109.setState(3);
        return;
    L27:
        return;
    L16:
        r106 = null;
        goto L17
    }

    public BrandQualificationDialog() {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        FragmentActivity r101 = getActivity();
        Intrinsics.checkNotNull(r101);
        BottomSheetDialog r102 = new BottomSheetDialog(r101, R.style.BottomSheetDialog);
        r102.requestWindowFeature(1);
        return r102;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (r100 == null) goto L35;
        this.f165502d = (Button) r100.findViewById(R.id.anchor_v3_btn_brand_qualification_complete);
        this.f165503e = (TextView) r100.findViewById(R.id.anchor_v3_tv_brand_title);
        this.f165504f = (RecyclerView) r100.findViewById(R.id.anchor_v3_rv_qualification_pics);
        this.f165506h = new BrandQualificationPicsAdapter();
        RecyclerView r102 = this.f165504f;
        if (r102 == null) goto L8;
        r102.setLayoutManager(new LinearLayoutManager(getContext()));
    L8:
        RecyclerView r103 = this.f165504f;
        if (r103 == null) goto L11;
        r103.setAdapter(this.f165506h);
    L11:
        ProductFormat r104 = this.f165505g;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mData");
    L14:
        String r105 = r104.getType();
        if (r105 == null) goto L19;
        boolean r106 = true;
        if (r105.equals("0") != true) goto L19;
    L20:
        TextView r107 = this.f165503e;
        if (r107 == null) goto L26;
        if (r106 == false) goto L24;
        String r108 = com.bytedance.android.shopping.extensions.j.c(R.string.commerce_anchor_v3_official_operated_shop);
    L25:
        r107.setText(r108);
        goto L26
    L24:
        r108 = com.bytedance.android.shopping.extensions.j.c(R.string.commerce_anchor_v3_agent_operated_shop);
    L26:
        BrandQualificationPicsAdapter r109 = this.f165506h;
        if (r109 == null) goto L35;
        ProductFormat r110 = this.f165505g;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mData");
    L31:
        List<ECUrlModel> r111 = r110.getPicUrls();
        ArrayList r112 = new ArrayList();
        if (r111 == null) goto L34;
        r112.addAll(r111);
    L34:
        r109.f164428a = r112;
        r109.notifyDataSetChanged();
    L19:
        r106 = false;
    L35:
        Button r113 = this.f165502d;
        if (r113 == null) goto L39;
        r113.setOnClickListener(new y(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = getContext();
        if (r103 != null) goto L7;
        return null;
    L7:
        return th.a.c(r103, R.layout.ec_commerce_anchor_v3_brand_qualification_dialog, r101, false);
    }
}
