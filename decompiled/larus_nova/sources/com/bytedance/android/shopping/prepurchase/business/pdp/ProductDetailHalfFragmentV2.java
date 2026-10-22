package com.bytedance.android.shopping.prepurchase.business.pdp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.anchorv3.utils.b0;
import com.bytedance.android.shopping.anchorv4.helper.t;
import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.prepurchase.arch.container.component.ServiceRegistryImpl;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.android.shopping.utils.y;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import n83.m;
import vg3.i0;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/ProductDetailHalfFragmentV2;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/android/shopping/anchorv4/containers/h;", "Lp83/g;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductDetailHalfFragmentV2 extends AppCompatDialogFragment implements com.bytedance.android.shopping.anchorv4.containers.h, p83.g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f181015m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f181016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f181017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> f181018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImmersionBar f181019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f181020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f181021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PdpRecoveryCompat f181022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.container.intf.a f181023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f181024l;

    public final class a extends AppCompatDialog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProductDetailHalfFragmentV2 f181025a;

        @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
        public final void onCreate(Bundle r100) {
            ProductDetailHalfFragmentV2 r101 = this.f181025a;
            int r102 = ProductDetailHalfFragmentV2.f181015m;
            ImmersionBar r103 = null;
            Window r104 = null;
            if (r101.getShowsDialog() == false) goto L19;
            Dialog r105 = r101.getDialog();
            if (r105 == null) goto L9;
            Window r106 = r105.getWindow();
            if (r106 == null) goto L9;
            r106.setBackgroundDrawableResource(R.color.commerce_color_00000000);
        L9:
            Dialog r107 = r101.getDialog();
            if (r107 == null) goto L12;
            r107.setOnDismissListener(r101);
        L12:
            Dialog r108 = r101.getDialog();
            if (r108 == null) goto L15;
            r108.setOnKeyListener(new h(r101));
        L15:
            int r109 = b0.f165303a;
            Dialog r110 = r101.getDialog();
            if (r110 == null) goto L18;
            r104 = r110.getWindow();
        L18:
            b0.a(r104);
        L23:
            r101.U90(true);
            super.onCreate(r100);
            return;
        L19:
            FragmentActivity r111 = r101.getActivity();
            if (r111 == null) goto L22;
            r103 = ImmersionBar.with(r111);
        L22:
            r101.f181019g = r103;
            goto L23
        }

        public a(ProductDetailHalfFragmentV2 r100, FragmentActivity r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f181025a = r100;
            super(r101, r102);
        }
    }

    public static final class b implements com.bytedance.android.shopping.prepurchase.arch.container.intf.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FragmentActivity f181026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProductDetailHalfFragmentV2 f181027b;

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final void H() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
            this.f181027b.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
        L9:
            Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
            if (r102 == null) goto L27;
            com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r103 = this.f181027b.f181018f;
            if (r103 == null) goto L28;
            com.bytedance.android.shopping.prepurchase.arch.container.f<STATE, PdpDataStore> r104 = r103.f180695d;
            if (r104 == 0) goto L29;
            com.bytedance.android.shopping.prepurchase.arch.container.intf.i r105 = r104.f180778d;
            if (r105 == null) goto L30;
            r105.ensureNotReachHere(r102);
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r106 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r106 == null) goto L9;
            com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L13
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final Window f7() {
            Dialog r100 = this.f181027b.getDialog();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getWindow();
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final FragmentManager g7() {
            return this.f181027b.getChildFragmentManager();
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final ViewGroup getContainerView() {
            View r100 = this.f181027b.getView();
            if (r100 == null) goto L7;
            return (ViewGroup) r100;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public FragmentActivity getContext() {
            if (this.f181026a != null) goto L9;
            Context r100 = this.f181027b.getContext();
            if ((r100 instanceof FragmentActivity) == true) goto L7;
            r100 = null;
        L7:
            this.f181026a = (FragmentActivity) r100;
        L9:
            return this.f181026a;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final com.bytedance.android.shopping.prepurchase.arch.container.intf.a i7() {
            ProductDetailHalfFragmentV2 r100 = this.f181027b;
            if (r100.f181023k != null) goto L16;
            com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r101 = r100.f181018f;
            if (r101 == null) goto L14;
            com.bytedance.android.shopping.prepurchase.arch.container.d<STATE, PdpDataStore> r102 = r101.f180694c;
            if (r102 != 0) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        L9:
            og3.b<STATE> r103 = r102.f180770d;
            if (r103 == 0) goto L14;
            e r104 = (e) r103.f523188b;
            if (r104 == null) goto L14;
            boolean r105 = r104.f181849b.f181035a;
        L15:
            int r106 = y.f187160a;
            int r107 = y.e(null, Boolean.valueOf(r105), 1);
            int r108 = k1.j(this.f181027b.getContext());
            int r109 = j56.a.b(this.f181027b.getContext());
            int r110 = k1.g();
            ProductDetailHalfFragmentV2 r111 = this.f181027b;
            r111.f181023k = new com.bytedance.android.shopping.prepurchase.arch.container.intf.a(r107, r108, r109, r110);
        L14:
            r105 = false;
        L16:
            com.bytedance.android.shopping.prepurchase.arch.container.intf.a r112 = this.f181027b.f181023k;
            Intrinsics.checkNotNull(r112);
            return r112;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final Object k7() {
            return this.f181027b;
        }

        public b(ProductDetailHalfFragmentV2 r100) {
            this.f181027b = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final void e(boolean r100) {
            this.f181027b.U90(r100);
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.h
    public final void J1() {
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r100 = this.f181018f;
        if (r100 == null) goto L12;
        ServiceRegistryImpl r101 = r100.f180693b;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L7:
        if (r101 == null) goto L13;
        vg3.g r102 = (vg3.g) r101.getService(vg3.g.class);
        if (r102 == null) goto L14;
        r102.W0();
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.f
    public final View N() {
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r100 = this.f181018f;
        if (r100 == null) goto L11;
        ServiceRegistryImpl r101 = r100.f180693b;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L7:
        if (r101 == null) goto L11;
        i0 r102 = (i0) r101.getService(i0.class);
        if (r102 == null) goto L11;
        return r102.N();
    L11:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.h
    public final String getSessionId() {
        PdpRecoveryCompat r100 = this.f181022j;
        if (r100 == null) goto L7;
        AnchorV4Param r101 = r100.f181014a;
        if (r101 == null) goto L7;
        return r101.getSessionId();
    L7:
        return null;
    }

    public ProductDetailHalfFragmentV2() {
        this.f181024l = new b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ImmersionBar r100 = this.f181019g;
        if (r100 == null) goto L6;
        r100.destroy();
    L6:
        if (this.f181020h == false) goto L8;
        return;
    L8:
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r101 = this.f181018f;
        if (r101 == null) goto L15;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r102 = r101.f180692a;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L13:
        r102.c(Lifecycle.Event.ON_DESTROY);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r100 = this.f181018f;
        if (r100 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r101 = r100.f180692a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r101.c(Lifecycle.Event.ON_PAUSE);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r100 = this.f181018f;
        if (r100 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r101 = r100.f180692a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r101.c(Lifecycle.Event.ON_RESUME);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r100 = this.f181018f;
        if (r100 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r101 = r100.f180692a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r101.c(Lifecycle.Event.ON_START);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r100 = this.f181018f;
        if (r100 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r101 = r100.f180692a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r101.c(Lifecycle.Event.ON_STOP);
        return;
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void T90(ProductDetailHalfFragmentV2 r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void U90(boolean r100) {
        if (getShowsDialog() == false) goto L9;
        Dialog r101 = getDialog();
        if (r101 == null) goto L17;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L18;
        com.bytedance.android.shopping.extensions.m.a(r102, r100);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        ImmersionBar r103 = this.f181019g;
        if (r103 == null) goto L20;
        ImmersionBar r104 = r103.reset();
        if (r104 == null) goto L21;
        ImmersionBar r105 = r104.statusBarDarkFont(r100);
        if (r105 == null) goto L22;
        r105.init();
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        this.f181023k = null;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r101 = this.f181018f;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Lazy r101 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L5;
        TrackCatcher.a(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L5:
        Bundle r102 = getArguments();
        Serializable r103 = null;
        if (r102 == null) goto L8;
        Serializable r104 = r102.getSerializable("param_key");
    L10:
        if ((r104 instanceof AnchorV4Param) == false) goto L13;
        r103 = r104;
    L13:
        AnchorV4Param r105 = (AnchorV4Param) r103;
        if (r105 != null) goto L17;
        this.f181020h = true;
        T90(this);
        return;
    L17:
        PdpRecoveryCompat r106 = new PdpRecoveryCompat(r105);
        if (r100 != null) goto L20;
    L23:
        Unit r107 = Unit.INSTANCE;
        this.f181022j = r106;
        setStyle(0, R.style.prepurchase_arch_panel_style_dialog);
        return;
    L20:
        if (r106.a(r100) == true) goto L23;
        this.f181020h = true;
        T90(this);
        return;
    L8:
        r104 = null;
        goto L10
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        return new a(this, requireActivity(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L18
        super.onDismiss(r100);     // Catch: Throwable -> L18
        i r101 = this.f181021i;     // Catch: Throwable -> L18
        if (r101 == null) goto L13;
        Dialog r102 = getDialog();     // Catch: Throwable -> L18
        if (r102 == null) goto L13;
        Window r103 = r102.getWindow();     // Catch: Throwable -> L18
        if (r103 == null) goto L13;
        View r104 = S90(r103);     // Catch: Throwable -> L18
        if (r104 == null) goto L13;
        ViewTreeObserver r105 = r104.getViewTreeObserver();     // Catch: Throwable -> L18
        if (r105 == null) goto L13;
        r105.removeOnPreDrawListener(r101);     // Catch: Throwable -> L18
    L13:
        this.f181021i = null;     // Catch: Throwable -> L18
        Function0<Unit> r106 = this.f181017e;     // Catch: Throwable -> L18
        if (r106 == null) goto L16;
        Unit r107 = r106.invoke();     // Catch: Throwable -> L18
    L16:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L18:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        PdpRecoveryCompat r101 = this.f181022j;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Bundle r112 = getArguments();
        if (r112 != null) goto L5;
        r112 = r111;
    L5:
        boolean r100 = false;
        if (r112 != null) goto L8;
    L10:
        boolean r101 = false;
    L11:
        PdpRecoveryCompat r113 = this.f181022j;
        if (r113 != null) goto L14;
        this.f181020h = true;
        T90(this);
        return;
    L14:
        AnchorV4Param r102 = r113.f181014a;
        og3.c r114 = new og3.c(Biz.PDP, r102.getSessionId(), new og3.a(r102.getNativeParams().getSourceBtmToken()));
        LinkedHashMap<String, u> r103 = t.f166991a;
        String r104 = r102.getSessionId();
        Intrinsics.checkNotNullParameter(r104, "sessionId");
        u r105 = t.f166991a.remove(r104);
        com.bytedance.android.shopping.prepurchase.arch.container.b r106 = new com.bytedance.android.shopping.prepurchase.arch.container.b(r114);
        m r107 = this.f181016d;
        if (r111 == null) goto L17;
        boolean r108 = true;
    L18:
        g r115 = new g(r102, r101, r105, r107, r108);
        Intrinsics.checkNotNullParameter(r115, "factory");
        r106.f180732d = r115;
        b r116 = this.f181024l;
        Intrinsics.checkNotNullParameter(r116, "delegate");
        r106.f180733e = r116;
        if (r111 == null) goto L21;
        r100 = true;
    L21:
        d r117 = new d(r100);
        Intrinsics.checkNotNullParameter(r117, "service");
        r106.f180729a = r117;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r118 = new com.bytedance.android.shopping.prepurchase.arch.container.a(r106.a());
        this.f181018f = r118;
        r118.c();
        return;
    L17:
        r108 = false;
        goto L18
    L8:
        if (r112.getBoolean("is_split_screen", false) != true) goto L10;
        r101 = true;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        CompatFrameLayout r103 = new CompatFrameLayout(r100.getContext(), null, 6, 0);
        r103.setId(R.id.rootview);
        Dialog r104 = getDialog();
        if (r104 == null) goto L7;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L7;
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = null;
        this.f181021i = new i(r105, r106);
        S90(r105).getViewTreeObserver().addOnPreDrawListener(this.f181021i);
    L7:
        return r103;
    }
}
