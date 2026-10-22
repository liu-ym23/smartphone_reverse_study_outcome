package com.bytedance.android.livesdk.livecommerce.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import bh2.d;
import bh2.f;
import bh2.g;
import bh2.h;
import bh2.i;
import bh2.j;
import bh2.k;
import bh2.l;
import bh2.m;
import bh2.n;
import bh2.o;
import bh2.p;
import bh2.q;
import bh2.r;
import bh2.s;
import bh2.t;
import bh2.u;
import bh2.v;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.e;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;
import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.z;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ECBaseDialogFragment<VM extends ViewModel> extends DialogFragment implements View.OnClickListener, ECBottomDialog.b, z {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f147646h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f147647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f147648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f147649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VM f147650g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECBaseDialogFragment f147651a;

        @Override // java.lang.Runnable
        public final void run() {
            ECBaseDialogFragment.S90(this.f147651a);     // Catch: Throwable -> L4 Exception -> L10
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        }

        public a(ECBaseDialogFragment r100) {
            this.f147651a = r100;
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f147652a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(Runnable r100) {
            this.f147652a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            Runnable r101 = this.f147652a;
            if (r101 == null) goto L6;
            r101.run();
            return;
        }
    }

    public interface c<T> {
        void a(e r100);
    }

    public void X90() {
    }

    public int Y90() {
        return 2;
    }

    public void aa0(Bundle r100) {
    }

    public void da0() {
    }

    public void ea0() {
    }

    public void fa0() {
    }

    public void ga0(String r100) {
    }

    public abstract int getLayoutId();

    public boolean ha0() {
        return this instanceof ECBindCouponFragment;
    }

    public ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -1);
        r100.topMargin = (int) (ECDisplayUtils.a(getContext()) * 0.26999998f);
        return r100;
    }

    public final ECBottomDialog Z90() {
        return (ECBottomDialog) super.getDialog();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (Z90() != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L10;
        return;
    L10:
        U90(Y90(), new a(this));
        return;
    L5:
        if (Z90().isShowing() == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment
    public final /* bridge */ /* synthetic */ Dialog getDialog() {
        return Z90();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        W90(new g(this));
        RealRoomController r100 = ControllerCenter.c(null, null);
        Intrinsics.checkNotNullParameter(this, "listener");
        if (EComABUtils.isLiveListMemoryLeakSwitch() == false) goto L6;
        ((ArrayList) r100.F).remove(this);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        W90(new f(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        W90(new d(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        W90(new k(this));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        W90(new bh2.b(this));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        W90(new j(this));
    }

    public ECBaseDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        S90(this);     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.z
    public void onLiveEnd() {
        T90(this);
    }

    public static void S90(DialogFragment r100) {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void T90(ECBaseDialogFragment r100) {
        r100.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog.b
    public void Nc(ECBottomDialog.a r100) {
        U90(Y90(), new n(r100));
    }

    public VM V90(Fragment r100) {
        Type r101 = r100.getClass().getGenericSuperclass();     // Catch: Throwable -> L6
        if ((r101 instanceof ParameterizedType) == false) goto L12;
        return (VM) ViewModelProviders.of(r100).get((Class) ((ParameterizedType) r101).getActualTypeArguments()[0]);
    L12:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void W90(final c<e> r100) {
        e r101 = this.f147649f;
        if (r101 == null) goto L5;
        r100.a(r101);
        return;
    L5:
        int r102 = ECSdk.f48106a;
        ECSdk.b(IAdapterService.class, new bh2.c(this, r100));
    }

    public ECBottomDialog ca0(Bundle r100) {
        if (ha0() == false) goto L5;
        ECBottomDialog r101 = new ECBottomDialog(getActivity(), R.style.ECTransparentDialogStyle);
    L6:
        r101.f147710a = this;
        return r101;
    L5:
        r101 = new ECBottomDialog(getActivity(), R.style.ECDialogStyle);
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r110) {
        super.onActivityCreated(r110);
        aa0(getArguments());
        X90();
        ECBaseViewModel r111 = (VM) V90(this);
        this.f147650g = r111;
        if (r111 == null) goto L8;
        if ((r111 instanceof ECBaseViewModel) == false) goto L8;
        ECBaseViewModel r112 = r111;
        r112.getToastString().observe(this, new o(this));
        r112.getToastInt().observe(this, new p(this));
        r112.getSuccessIconToast().observe(this, new q());
        r112.getFailedIconToast().observe(this, new r());
        r112.getLoadingData().observe(this, new s(this));
        r112.getLoadingFinishData().observe(this, new t(this));
        r112.getLoadingErrorData().observe(this, new u(this));
        r112.getPermissionDeniedData().observe(this, new v(this));
        r112.getFinishActivity().observe(this, new m(this));
    L8:
        if (this.f147650g == null) goto L32;
        Window r113 = Z90().getWindow();
        if (r113 != null) goto L12;
    L19:
        Window r114 = Z90().getWindow();
        if (r114 == null) goto L22;
        r114.setSoftInputMode(48);
    L22:
        int r115 = Y90();
        if (r115 != 3) goto L26;
        TranslateAnimation r116 = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
    L29:
        if (r116 == null) goto L31;
        r116.setDuration(200);
        this.f147647d.startAnimation(r116);
    L31:
        RealRoomController r117 = ControllerCenter.c(null, null);
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r117.F).add(this);
        goto L32
    L26:
        if (r115 != 2) goto L28;
        r116 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        goto L29
    L28:
        r116 = null;
        goto L29
    L12:
        if (getContext() == null) goto L19;
        WindowManager.LayoutParams r100 = r113.getAttributes();
        r100.width = -1;
        r100.height = -1;
        r113.setAttributes(r100);
        r113.setGravity(80);
        View r101 = r113.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L18;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L18:
        r101.setPadding(0, 0, 0, 0);
        r113.setBackgroundDrawableResource(android.R.color.transparent);
        r113.setWindowAnimations(R.style.ECBaseDialogFragmentAnimation);
    L32:
        W90(new l(this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        if (r100 != this.f147648e) goto L6;
        T90(this);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        W90(new h(this));
    }

    @Override // androidx.fragment.app.DialogFragment
    public /* bridge */ /* synthetic */ Dialog onCreateDialog(Bundle r100) {
        return ca0(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        super.onDismiss(r100);     // Catch: Throwable -> L5
        W90(new i(this));     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void U90(int r110, Runnable r111) {
        if (r110 != 3) goto L6;
        TranslateAnimation r112 = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
    L9:
        if (r112 == null) goto L11;
        r112.setDuration(200);
        r112.setAnimationListener(new b(r111));
        r112.setFillAfter(true);
        this.f147647d.startAnimation(r112);
        return;
    L11:
        r111.run();
        return;
    L6:
        if (r110 != 2) goto L8;
        r112 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        goto L9
    L8:
        r112 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        W90(new bh2.e(this));
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Fragment r102 = r100.findFragmentByTag(r101);     // Catch: Exception -> L12
        if (r102 == null) goto L6;
        r100.beginTransaction().remove(r102).commitAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L6:
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L12
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r103);     // Catch: Exception -> L12
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r103) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L10:
        super.show(r100, r101);     // Catch: Exception -> L12
        return;
    L19:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f147648e = (FrameLayout) th.a.c(getActivity(), R.layout.ec_fragment_root_layout, r101, false);
        View r103 = th.a.c(getActivity(), getLayoutId(), this.f147648e, false);
        this.f147647d = r103;
        r103.setClickable(true);
        View r104 = this.f147647d;
        this.f147648e.addView(r104, ba0());
        this.f147648e.setOnClickListener(this);
        return this.f147648e;
    }
}
