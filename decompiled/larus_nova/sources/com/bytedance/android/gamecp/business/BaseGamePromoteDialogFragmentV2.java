package com.bytedance.android.gamecp.business;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.gamecp.common.utils.y0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/BaseGamePromoteDialogFragmentV2;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGamePromoteDialogFragmentV2 extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f51700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f51701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f51702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f51703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f51704h;

    public static final class a implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGamePromoteDialogFragmentV2 f51705a;

        public a(BaseGamePromoteDialogFragmentV2 r100) {
            this.f51705a = r100;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r110) {
            BaseGamePromoteDialogFragmentV2 r100 = this.f51705a;
            if (r110 == null) goto L50;
            BottomSheetDialog r111 = (BottomSheetDialog) r110;
            int[] r101 = r100.f51703g;
            FrameLayout r102 = (FrameLayout) r111.findViewById(R.id.design_bottom_sheet);
            if (r102 == null) goto L45;
            r102.setBackgroundResource(R.color.transparent);
            BottomSheetBehavior<FrameLayout> r103 = BottomSheetBehavior.from(r102);
            r103.setSkipCollapsed(true);
            r103.setState(3);
            int r104 = 0;
            if (r100.f51700d == false) goto L9;
            r103.setHideable(true);
            r103.setPeekHeight(r101[1]);
        L10:
            r103.setBottomSheetCallback(new c(r103, r100));
            Unit r105 = Unit.INSTANCE;
            r100.f51702f = r103;
            if ((r102.getParent() instanceof CoordinatorLayout) == false) goto L45;
            if ((r102.getParent().getParent() instanceof FrameLayout) == false) goto L45;
            ViewParent r106 = r102.getParent();
            if (r106 == null) goto L44;
            CoordinatorLayout r107 = (CoordinatorLayout) r106;
            ViewGroup.LayoutParams r108 = r107.getLayoutParams();
            if (r108 == null) goto L42;
            FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r108;
            ViewParent r112 = r107.getParent();
            if (r112 == null) goto L40;
            FrameLayout r113 = (FrameLayout) r112;
            if (r100.f51700d == true) goto L27;
            r109.width = y0.b(393.0f);
            r109.height = r101[3];
            r109.gravity = GravityCompat.END;
            Resources r114 = y0.getResources();
            int r115 = r114.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
            if (r115 == 0) goto L25;
            int r116 = r114.getDimensionPixelSize(r115);
        L26:
            r113.setPadding(0, 0, 0, r116);
        L38:
            r107.setLayoutParams(r109);
            goto L45
        L25:
            r116 = 0;
            goto L26
        L27:
            r109.width = r101[0];
            int r117 = r101[1];
            if (r117 != (-1)) goto L30;
        L36:
            r109.height = r117;
        L37:
            r109.gravity = 80;
            goto L38
        L30:
            if (r117 == (-2)) goto L36;
            Resources r118 = y0.getResources();
            int r119 = r118.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
            if (r119 == 0) goto L35;
            r104 = r118.getDimensionPixelSize(r119);
        L35:
            r109.height = r117 - r104;
            goto L37
        L40:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        L42:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L44:
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        L9:
            r103.setHideable(false);
            r103.setPeekHeight(y0.f());
        L45:
            View r120 = r111.findViewById(R.id.touch_outside);
            if (r120 == null) goto L51;
            r120.setOnTouchListener(d.f52292a);
            return;
        L51:
            return;
        L50:
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGamePromoteDialogFragmentV2 f51706a;

        public b(BaseGamePromoteDialogFragmentV2 r100) {
            this.f51706a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            du.a r101 = (du.a) r100;
            this.f51706a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L12;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public BaseGamePromoteDialogFragmentV2() {
        this.f51700d = !com.bytedance.android.gamecp.common.utils.p0.a();
        this.f51701e = new CompositeDisposable();
        this.f51703g = new int[]{-1, -2, y0.b(393.0f), -1};
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        BottomSheetBehavior<FrameLayout> r100 = this.f51702f;
        if (r100 == null) goto L6;
        r100.setBottomSheetCallback(null);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        this.f51701e.add(jv.a.a().c(du.a.class).subscribe(new b(this)));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        if (this.f51701e.isDisposed() == true) goto L6;
        this.f51701e.dispose();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L6;
        r101.setOnShowListener(new a(this));
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        if (this.f51700d == false) goto L7;
        Context r101 = getContext();
        if (r101 == null) goto L10;
        r101.setTheme(R.style.gamecp_common_bottom_dialog_no_full_screen);
    L10:
        super.onCreate(r100);
        return;
    L7:
        Context r102 = getContext();
        if (r102 == null) goto L10;
        r102.setTheme(R.style.gamecp_game_promote_common_right_dialog);
        goto L10
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (com.bytedance.android.gamecp.common.utils.p0.a() == false) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setType(1000);
    L7:
        int[] r103 = this.f51703g;
        if (this.f51700d == false) goto L15;
        Window r104 = r101.getWindow();
        if (r104 == null) goto L12;
        r104.setLayout(y0.g(), r103[1]);
    L12:
        Window r105 = r101.getWindow();
        if (r105 == null) goto L21;
        r105.setGravity(80);
    L21:
        return r101;
    L15:
        Window r106 = r101.getWindow();
        if (r106 == null) goto L18;
        r106.setLayout(r103[2], r103[3]);
    L18:
        Window r107 = r101.getWindow();
        if (r107 == null) goto L21;
        r107.setGravity(GravityCompat.END);
        goto L21
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f51704h = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_game_promote_base_dialog_main, r101, false);
        LayoutInflater r103 = LayoutInflater.from(getContext());
        int r104 = getLayoutId();
        View r105 = this.f51704h;
        if (r105 == null) goto L5;
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.fl_game_promote_base_dialog_content);
    L6:
        r103.inflate(r104, r106, true);
        initView();
        View r107 = this.f51704h;
        Intrinsics.checkNotNull(r107);
        return r107;
    L5:
        r106 = null;
        goto L6
    }
}
