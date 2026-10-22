package com.bytedance.android.annie.container.dialog;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.android.annie.dialog.NoMarginSheetBaseDialog;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.param.p;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.m;
import com.bytedance.android.annie.util.t;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/container/dialog/BaseDialogFragment;", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "Landroid/content/DialogInterface$OnShowListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseDialogFragment extends HybridDialog implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f39240r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f39241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PopupHybridParamVoNew f39242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HybridFragment f39243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f39245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f39246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f39247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f39248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f39249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<HybridDialog.a> f39250m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p f39251n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f39252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f39253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f39254q;

    public static final class a {
    }

    static {
    }

    public abstract void ba0();

    public abstract AnnieFragment ea0(PopupHybridParamVoNew r100);

    public abstract void ia0(String r100);

    public abstract void ja0(Bundle r100);

    public abstract void oa0();

    public final void ca0() {
        PopupHybridParamVoNew r100 = this.f39242e;
        if (r100 == null) goto L14;
        if (r100 == null) goto L15;
        Dialog r101 = getDialog();
        if ((r101 instanceof SheetBaseDialog) == false) goto L8;
        SheetBaseDialog r102 = (SheetBaseDialog) r101;
    L9:
        if (r102 == null) goto L16;
        boolean r103 = r100.S2();
        int r104 = r100.getHeight();
        int r105 = r100.v3();
        r102.f154346k = r103;
        if (r105 <= 0) goto L17;
        r102.f154347l = (int) pn2.c.a(r102.getContext(), r104 - r105);
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r102 = null;
        goto L9
    L15:
        return;
    }

    public final int fa0() {
        p r100 = this.f39251n;
        if (r100 == null) goto L6;
        return r100.f39718d;
    L6:
        return t.f40076a.e(getActivity());
    }

    public final int ga0() {
        p r100 = this.f39251n;
        if (r100 != null) goto L10;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L9;
        return UIUtils.getScreenWidth(r101);
    L9:
        return com.bytedance.android.annie.util.p.f40070a.e();
    L10:
        return r100.f39715a.widthPixels;
    }

    public final boolean ha0() {
        p r100 = this.f39251n;
        if (r100 == null) goto L14;
        int r101 = r100.f39716b;
        if (r101 != 0) goto L7;
    L12:
        return true;
    L7:
        if (r101 == 8) goto L12;
        if (r101 == 6) goto L12;
        return false;
    L14:
        return m.a(getActivity());
    }

    public final boolean isFullScreen() {
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L5;
    L9:
        PopupHybridParamVoNew r100 = this.f39242e;
        if (r100 != null) goto L12;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == false) goto L21;
        PopupHybridParamVoNew r102 = this.f39242e;
        if (r102 != null) goto L19;
        return false;
    L19:
        if (r102.x3() != true) goto L29;
    L20:
        return true;
    L29:
        return false;
    L21:
        PopupHybridParamVoNew r103 = this.f39242e;
        if (r103 == null) goto L24;
        int r104 = r103.U2();
    L26:
        if (RangesKt.coerceAtMost(r104 / 100.0f, 1.0f) >= 1.0f) goto L20;
        return false;
    L24:
        r104 = 0;
        goto L26
    L12:
        if (r100.S2() != true) goto L14;
        r101 = true;
        goto L15
    L5:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522318c == false) goto L7;
    L8:
        return false;
    L7:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522319d == false) goto L9;
        goto L8
    }

    public final boolean na0() {
        PopupHybridParamVoNew r100 = this.f39242e;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return true;
    L7:
        if ((r100.T2() & 80) != 80) goto L9;
        boolean r101 = true;
    L11:
        if (r100.r3() == false) goto L19;
        if (r101 == true) goto L14;
    L16:
        return false;
    L14:
        if (r100.s3() == true) goto L16;
        return true;
    L19:
        return true;
    L9:
        r101 = false;
        goto L11
    }

    public BaseDialogFragment() {
        this.f39241d = new LinkedHashMap();
        this.f39244g = -16777216;
        this.f39247j = true;
        this.f39248k = true;
        this.f39249l = true;
        this.f39250m = new ArrayList();
        this.f39252o = LazyKt.lazy(BaseDialogFragment$changeConfigDialogTime$2.INSTANCE);
        this.f39254q = true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        if (getFragmentManager() == null) goto L13;
        super.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L14;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        if (getFragmentManager() == null) goto L13;
        super.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L14;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public final void ma0() {
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.addFlags(Integer.MIN_VALUE);
    L7:
        Dialog r102 = getDialog();
        if (r102 == null) goto L12;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L12;
        r103.clearFlags(67108864);
    L12:
        Dialog r104 = getDialog();
        Window r105 = null;
        if (r104 == null) goto L15;
        Window r106 = r104.getWindow();
    L17:
        if (r106 == null) goto L21;
        r106.setStatusBarColor(0);
    L21:
        if (AnnieConfigSettingKeys.ENABLE_ANNIE_DIALOG_NAVIGATION_BAR_COLOR_SET.a().booleanValue() == false) goto L34;
        Dialog r107 = getDialog();
        if (r107 == null) goto L27;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L27;
        r108.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L27:
        Dialog r109 = getDialog();
        if (r109 == null) goto L30;
        r105 = r109.getWindow();
    L30:
        if (r105 == null) goto L35;
        r105.setNavigationBarColor(0);
        return;
    L35:
        return;
    L34:
        return;
    L15:
        r106 = null;
        goto L17
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        k.c(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f39241d.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Application r100 = com.bytedance.android.annie.ng.g.f39669a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L6;
        return;
    L6:
        if (AnnieConfigSettingKeys.ENABLE_FIX_TRANSITION_ANIM.a().booleanValue() == false) goto L39;
        Dialog r100 = getDialog();
        if (r100 == null) goto L10;
        Window r101 = r100.getWindow();
    L12:
        if (Intrinsics.areEqual(this.f39253p, Boolean.TRUE) == false) goto L34;
        if (r101 == null) goto L34;
        this.f39253p = Boolean.FALSE;
        PopupHybridParamVoNew r102 = this.f39242e;
        if (r102 == null) goto L34;
        WindowManager.LayoutParams r103 = r101.getAttributes();
        if (r102.g3() == true) goto L19;
    L37:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L27
        r101.setAttributes(r103);     // Catch: Throwable -> L27
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L32;
        b8.a r107 = b8.a.f17992a;
        b8.a.a(new b8.b("BaseDialogFragment", LogLevel.ERROR, r106, null, 8), true);
    L32:
        Result.m9448boximpl(r105);
    L27:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L19:
        if (com.bytedance.android.annie.util.p.f40070a.getResources().getConfiguration().orientation != 2) goto L21;
        r103.windowAnimations = R.style.annie_dialog_no_enter_anim_horizontal;
        goto L37
    L21:
        PopupHybridParamVoNew r109 = this.f39242e;
        Intrinsics.checkNotNull(r109);
        if (TextUtils.equals(r109.j3(), "right") == false) goto L24;
        r103.windowAnimations = R.style.annie_dialog_no_enter_anim_horizontal;
        goto L37
    L24:
        r103.windowAnimations = R.style.annie_dialog_no_enter_anim_vertical;
    L34:
        if (this.f39253p != null) goto L40;
        this.f39253p = Boolean.TRUE;
        return;
    L40:
        return;
    L10:
        r101 = null;
        goto L12
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final IHybridComponent getHybridComponent() {
        return this.f39243f;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void T90(HybridDialog.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f39250m).add(r100);
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void U90(boolean r100) {
        setCancelable(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L6;
        r101.setCanceledOnTouchOutside(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void V90(boolean r100) {
        this.f39248k = r100;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void W90(boolean r100) {
        this.f39247j = r100;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void Y90(boolean r100) {
        com.bytedance.android.annie.scheme.helper.a.d(this.f39242e, AppConstants.BUNDLE_PULL_DOWN_CLOSE, Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void Z90(boolean r100) {
        PopupHybridParamVoNew r101 = this.f39242e;
        boolean r102 = true;
        int r103 = 0;
        if (r101 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L44;
        HybridFragment r105 = this.f39243f;
        if ((r105 instanceof AnnieFragment) == false) goto L12;
        AnnieFragment r106 = (AnnieFragment) r105;
    L13:
        if (r106 == null) goto L45;
        IHybridComponent r107 = r106.getMAnnieCard();
        if (r107 != null) goto L17;
    L19:
        boolean r108 = false;
    L21:
        if (r108 == false) goto L36;
        FragmentParamVoNew r109 = r106.f39273e;
        if (r109 != null) goto L25;
    L27:
        r102 = false;
    L28:
        if (r102 == false) goto L36;
        View r110 = r106.f39279i;
        if (r110 == null) goto L47;
        if (r100 == true) goto L35;
        r103 = 8;
    L35:
        r110.setVisibility(r103);
        return;
    L47:
        return;
    L25:
        if (r109.W1() != true) goto L27;
    L36:
        View r111 = r106.f39280j;
        if (r111 == null) goto L48;
        if (r100 == true) goto L42;
        r103 = 8;
    L42:
        r111.setVisibility(r103);
        return;
    L48:
        return;
    L17:
        if (r107.canGoBack() != true) goto L19;
        r108 = true;
        goto L21
    L45:
        return;
    L12:
        r106 = null;
        goto L13
    L44:
        return;
    L5:
        if (r101.S2() != true) goto L7;
        r104 = true;
        goto L8
    }

    public final View aa0(int r100) {
        if (this.f39241d != null) goto L5;
        this.f39241d = new LinkedHashMap();
    L5:
        View r101 = this.f39241d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        Integer r104 = Integer.valueOf(r100);
        this.f39241d.put(r104, r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final int da0(float r100) {
        p r101 = this.f39251n;
        if (r101 == null) goto L6;
        return (int) ((r100 * r101.f39715a.density) + 0.5f);
    L6:
        return com.bytedance.android.annie.util.p.f40070a.a(r100);
    }

    public final <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) Annie.getService(r100, ((AnnieDialog) this).getBizKey());
    }

    public final void ka0(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("status", r100);     // Catch: JSONException -> L5
        sendJsEvent("H5_halfFullStatusChange", r101);     // Catch: JSONException -> L5
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r110) {
        super.onActivityCreated(r110);
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L6;
        return;
    L6:
        if (((Boolean) this.f39252o.getValue()).booleanValue() == true) goto L8;
        ma0();
    L8:
        Dialog r100 = getDialog();
        if (r100 == null) goto L11;
        Window r101 = r100.getWindow();
    L12:
        PopupHybridParamVoNew r102 = this.f39242e;
        if (r102 == null) goto L94;
        qa0(getDialog(), r102.getWidth(), r102.getHeight(), r102.T2());
        FrameLayout r103 = (FrameLayout) aa0(R.id.realHybridContainer);
        if (r103 == null) goto L17;
        r103.post(new g(r102, this));
    L17:
        if (r101 == null) goto L94;
        PopupHybridParamVoNew r104 = this.f39242e;
        if (r104 == null) goto L86;
        if (r104.C3() == true) goto L23;
        r101.setSoftInputMode(48);
    L23:
        WindowManager.LayoutParams r105 = r101.getAttributes();
        if (r104.g3() == false) goto L36;
        p r106 = this.f39251n;
        if (r106 == null) goto L28;
        int r107 = r106.f39719e;
    L30:
        if (r107 != 2) goto L33;
        r105.windowAnimations = R.style.annie_dialog_bottom_popup_anim_horizontal;
    L105:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L39
        r101.setAttributes(r105);     // Catch: Throwable -> L39
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        boolean r112 = true;
        if (r111 == null) goto L45;
        b8.a r113 = b8.a.f17992a;
        b8.a.a(new b8.b("BaseDialogFragment", LogLevel.ERROR, r111, null, 8), true);
    L45:
        if (r104.e3() <= 0) goto L48;
        r101.addFlags(2);
        r101.setDimAmount(r104.e3());
    L50:
        String r114 = r104.f3();
        if (r114 != null) goto L53;
    L55:
        boolean r115 = false;
    L56:
        if (r115 == false) goto L62;
        r101.setBackgroundDrawable(new ColorDrawable(Color.parseColor(r104.f3())));     // Catch: Exception -> L59
    L59:
        e = move-exception;
        b8.a r116 = b8.a.f17992a;
        b8.a.a(new b8.b("BaseDialogFragment", LogLevel.ERROR, e, null, 8), true);
    L62:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522318c == false) goto L66;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.f39661a.f522314j == true) goto L66;
    L74:
        PopupHybridParamVoNew r117 = this.f39242e;
        if (r117 != null) goto L78;
    L83:
        if (r112 == false) goto L86;
        r101.addFlags(32);
        r101.getAttributes().dimAmount = 0.0f;
        goto L86
    L78:
        if (r117.getWidth() == 0) goto L80;
    L82:
        r112 = false;
        goto L83
    L80:
        if (r117.getHeight() != 0) goto L82;
    L66:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522319d == true) goto L74;
        if (r104.getWidth() <= 0) goto L70;
        int r118 = da0(r104.getWidth() + r104.getMarginRight());
    L71:
        r101.setLayout(r118, -1);
        if (isFullScreen() == true) goto L74;
        r101.setFlags(1024, 1024);
        goto L74
    L70:
        r118 = r104.getWidth();
        goto L71
    L53:
        if ((!StringsKt.isBlank(r114)) != true) goto L55;
        r115 = true;
        goto L56
    L48:
        if (na0() == false) goto L50;
        r101.clearFlags(6);
        r101.setDimAmount(0.0f);
    L39:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L33:
        if (TextUtils.equals(r104.j3(), "right") == false) goto L35;
        r105.windowAnimations = R.style.annie_dialog_bottom_popup_anim_horizontal;
        goto L105
    L35:
        r105.windowAnimations = R.style.annie_dialog_bottom_popup_anim_vertical;
        goto L105
    L28:
        r107 = com.bytedance.android.annie.util.p.f40070a.getResources().getConfiguration().orientation;
        goto L30
    L36:
        r105.windowAnimations = R.style.annie_dialog_no_anim;
    L86:
        if (r102.S2() == false) goto L94;
        Dialog r120 = getDialog();
        i r121 = new i(this);
        if ((r120 instanceof SheetBaseDialog) == false) goto L90;
        SheetBaseDialog r122 = (SheetBaseDialog) r120;
    L91:
        if (r122 == null) goto L94;
        r122.f154341f = r121;
        goto L94
    L90:
        r122 = null;
    L94:
        if (getShowsDialog() == true) goto L96;
    L103:
        this.f39251n = null;
        return;
    L96:
        if (AnnieConfigSettingKeys.ENABLE_WEAK_DIALOG_LISTENER.a().booleanValue() == false) goto L100;
        Dialog r123 = getDialog();
        if (r123 == null) goto L103;
        int r124 = t7.a.f544855a;
        r123.setOnShowListener(new t7.b(this));
        goto L103
    L100:
        Dialog r125 = getDialog();
        if (r125 == null) goto L103;
        r125.setOnShowListener(this);
        goto L103
    L11:
        r101 = null;
        goto L12
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        if (r100 == null) goto L5;
        r100.remove("android:support:fragments");
    L5:
        if (r100 == null) goto L7;
        r100.remove("android:fragments");
    L7:
        if (r100 == null) goto L11;
        Bundle r101 = r100.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (r101 == null) goto L11;
        r101.remove("android:support:fragments");
    L11:
        super.onCreate(r100);
        if (AnnieConfigSettingKeys.ENABLE_REUSE_SCREEN_SIZE_PARAMS.a().booleanValue() == false) goto L15;
        this.f39251n = new p(getActivity());
    L15:
        if (com.bytedance.android.annie.ng.g.f39675g == false) goto L52;
        Bundle r102 = getArguments();
        Unit r103 = null;
        if (r102 == null) goto L30;
        Parcelable r104 = r102.getParcelable("hybrid_pop_vo_new");
        if ((r104 instanceof PopupHybridParamVoNew) == false) goto L28;
        PopupHybridParamVoNew r105 = (PopupHybridParamVoNew) r104;
    L29:
        this.f39242e = r105;
        ja0(r102);
        goto L30
    L28:
        r105 = null;
    L30:
        PopupHybridParamVoNew r106 = this.f39242e;
        if (r106 == null) goto L35;
        String r107 = r106.o();
        if (r107 != null) goto L36;
        r107 = r106.f39814b;
    L36:
        if (r107 == null) goto L38;
        k.b(r107, this);
        r103 = Unit.INSTANCE;
    L38:
        if (r103 != null) goto L46;
        dismissAllowingStateLoss();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r108 = DialogFragmentLancet.sLastShowStack;
        if (r108 == null) goto L46;
        com.bytedance.crash.d.d(r108, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L46:
        if ((!ha0()) == false) goto L48;
        setStyle(1, R.style.annie_ShowWebDialog);
        return;
    L48:
        setStyle(1, R.style.annie_ShowNotFloatingWebDialog);
        return;
    L35:
        r107 = null;
        goto L36
    L52:
        dismissAllowingStateLoss();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r109 = DialogFragmentLancet.sLastShowStack;
        if (r109 == null) goto L54;
        com.bytedance.crash.d.d(r109, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        if (com.bytedance.android.annie.ng.g.f39675g == false) goto L5;
        Context r101 = getContext();
        boolean r102 = true;
        if (r101 == null) goto L35;
        PopupHybridParamVoNew r103 = this.f39242e;
        boolean r104 = false;
        if (r103 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == true) goto L16;
    L22:
        boolean r106 = m.a((Activity) r101);
        boolean r107 = com.bytedance.android.annie.ng.g.b().f39658b.f522318c;
        if (getContext() == null) goto L34;
        boolean r108 = ha0();
        if (isFullScreen() == false) goto L31;
        if (r108 == true) goto L31;
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522318c == true) goto L31;
    L33:
        r104 = true;
    L31:
        if (AnnieConfigSettingKeys.HYBRID_LANDSCAPE_IS_FULLSCREEN.a().booleanValue() == false) goto L34;
        if (r108 == true) goto L33;
    L34:
        Dialog r109 = new NoMarginSheetBaseDialog(r101, r106, r107, r104);
    L36:
        if (r109 == null) goto L43;
        PopupHybridParamVoNew r110 = this.f39242e;
        if (r110 == null) goto L40;
        r102 = r110.P2();
    L40:
        setCancelable(r102);
        r109.setCanceledOnTouchOutside(r102);
        return r109;
    L43:
        return super.onCreateDialog(r100);
    L16:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522318c == true) goto L22;
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522319d == true) goto L22;
        r109 = super.onCreateDialog(r100);
        Window r111 = r109.getWindow();
        if (r111 == null) goto L36;
        r111.setBackgroundDrawable(new ColorDrawable(0));
        r111.addFlags(65792);
        goto L36
    L11:
        if (r103.N2() != true) goto L13;
        r105 = true;
        goto L14
    L35:
        r109 = null;
        goto L36
    L5:
        return super.onCreateDialog(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r100);     // Catch: Throwable -> L9
        Iterator r101 = ((ArrayList) this.f39250m).iterator();     // Catch: Throwable -> L9
    L4:
        if (r101.hasNext() == false) goto L7;
        ((HybridDialog.a) r101.next()).onDismiss();     // Catch: Throwable -> L9
        goto L4
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public void onShow(DialogInterface r100) {
        Iterator<T> r101 = this.f39250m.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((HybridDialog.a) r101.next()).onShow();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L6;
        return;
    L6:
        if (((Boolean) this.f39252o.getValue()).booleanValue() == true) goto L8;
        oa0();
        ca0();
    L8:
        Dialog r102 = getDialog();
        if ((r102 instanceof SheetBaseDialog) == false) goto L11;
        SheetBaseDialog r103 = (SheetBaseDialog) r102;
    L12:
        if (r103 == null) goto L14;
        r103.f154344i = new c(this);
    L14:
        ConstraintLayout r104 = (ConstraintLayout) aa0(R.id.hybridContainer);
        if (r104 == null) goto L17;
        r104.setOnClickListener(new d(this));
    L17:
        Dialog r105 = getDialog();
        if ((r105 instanceof SheetBaseDialog) == false) goto L20;
        SheetBaseDialog r106 = (SheetBaseDialog) r105;
    L21:
        if (r106 == null) goto L25;
        com.bytedance.android.livesdk.pannel.b r107 = new com.bytedance.android.livesdk.pannel.b(r106, new e(this));
        r106.f154343h = r107;
        SheetBaseBehavior<?> r108 = r106.f154336a;
        if (r108 == null) goto L25;
        r108.f154335e = r107;
    L25:
        PopupHybridParamVoNew r109 = this.f39242e;
        if (r109 != null) goto L28;
    L30:
        boolean r110 = false;
    L31:
        if (r110 == false) goto L33;
        ka0(1);
    L33:
        Dialog r111 = getDialog();
        if ((r111 instanceof SheetBaseDialog) == false) goto L36;
        SheetBaseDialog r112 = (SheetBaseDialog) r111;
    L37:
        if (r112 == null) goto L41;
        com.bytedance.android.livesdk.pannel.c r113 = new com.bytedance.android.livesdk.pannel.c(r112, new f(this, r112));
        r112.f154342g = r113;
        SheetBaseBehavior<?> r114 = r112.f154336a;
        if (r114 == null) goto L41;
        r114.f154334d = r113;
    L41:
        PopupHybridParamVoNew r115 = this.f39242e;
        if (r115 != null) goto L44;
    L52:
        PopupHybridParamVoNew r116 = this.f39242e;
        Intrinsics.checkNotNull(r116);
        AnnieFragment r117 = ea0(r116);
        ia0("create annie fragment succeed and add it");
        this.f39243f = r117;
        b r118 = new b(this);
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "l");
        r117.N = r118;
        FragmentTransaction r119 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r119, r117, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.realHybridContainer) == true) goto L56;
        r119 = r119.replace(R.id.realHybridContainer, r117);
    L56:
        r119.commitAllowingStateLoss();
        return;
    L44:
        if (r115.y3() == false) goto L52;
        ImageView r120 = (ImageView) aa0(R.id.ivBottomClose);
        if (r120 == null) goto L49;
        r120.setVisibility(0);
    L49:
        ImageView r121 = (ImageView) aa0(R.id.ivBottomClose);
        if (r121 == null) goto L52;
        r121.setOnClickListener(new h(this));
        goto L52
    L36:
        r112 = null;
        goto L37
    L28:
        if (r109.S2() != true) goto L30;
        r110 = true;
        goto L31
    L20:
        r106 = null;
        goto L21
    L11:
        r103 = null;
        goto L12
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        if (r100.isDestroyed() == false) goto L7;
        this.f39254q = false;     // Catch: Throwable -> L14
        return;
    L7:
        r100.beginTransaction().remove(this).commit();     // Catch: Throwable -> L14
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L14
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r103);     // Catch: Throwable -> L14
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r103) == false) goto L21;
    L12:
        this.f39254q = true;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L24;
        this.f39254q = false;
        int r106 = x8.a.f562881a;
        x8.a.b("BaseDialogFragment", "===show():" + r105.getMessage() + "===", false);
        return;
    L24:
        return;
    L21:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20 Throwable -> L14
    L11:
        super.show(r100, r101);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L6;
        return null;
    L6:
        ba0();
        if (((Boolean) this.f39252o.getValue()).booleanValue() == false) goto L9;
        oa0();
        ca0();
        ma0();
    L9:
        View r103 = r100.inflate(R.layout.annie_dialog, r101, false);
        this.f39246i = r103;
        return r103;
    }

    public final void pa0(int r110, int r111, int r112) {
        FrameLayout r100 = (FrameLayout) aa0(R.id.realHybridContainer);
        DisplayMetrics r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L6:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int r103 = r112 & 80;
        if (r103 == 80) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
    L25:
        if (r110 <= 0) goto L27;
        r110 = da0(r110);
    L27:
        r102.width = r110;
    L28:
        if (r111 <= 0) goto L30;
        r111 = com.bytedance.android.annie.util.p.f40070a.a(r111);
    L30:
        r102.height = r111;
        PopupHybridParamVoNew r113 = this.f39242e;
        if (r113 == null) goto L81;
        if (getContext() == null) goto L65;
        com.bytedance.android.annie.util.p r114 = com.bytedance.android.annie.util.p.f40070a;
        if (r114.getResources().getConfiguration().orientation == 2) goto L65;
        if (isFullScreen() == false) goto L48;
        p r115 = this.f39251n;
        if (r115 == null) goto L45;
        DisplayMetrics r116 = r115.f39717c;
        if (r116 == null) goto L43;
        r101 = r116;
    L44:
        if (r101 == null) goto L45;
    L46:
        r102.height = r101.heightPixels - fa0();
        goto L65
    L43:
        Intrinsics.throwUninitializedPropertyAccessException("realDisplayMetrics");
    L45:
        r101 = com.bytedance.android.annie.util.p.c(getActivity());
        goto L46
    L48:
        if (r113.A3() == true) goto L62;
        if (r113.U2() <= 0) goto L65;
        if (r113.z3() == 1) goto L65;
        float r106 = RangesKt.coerceAtMost(r113.U2() / 100.0f, 1.0f);
        p r107 = this.f39251n;
        if (r107 == null) goto L56;
        int r117 = r107.f39715a.heightPixels;
    L60:
        r102.height = (int) (r117 * r106);
        goto L65
    L56:
        FragmentActivity r108 = getActivity();
        if (r108 == null) goto L59;
        r117 = UIUtils.getScreenHeight(r108);
        goto L60
    L59:
        r117 = r114.d();
        goto L60
    L62:
        if (r113.U2() <= 0) goto L65;
        r102.height = (int) (com.bytedance.android.annie.util.p.c(getContext()).heightPixels * RangesKt.coerceAtMost(r113.U2() / 100.0f, 1.0f));
    L65:
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L81;
        if (r113.getMarginBottom() <= 0) goto L70;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r102)).bottomMargin = com.bytedance.android.annie.util.p.f40070a.a(r113.getMarginBottom() * 1.0f);
    L70:
        if (r113.getMarginRight() <= 0) goto L73;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r102)).rightMargin = com.bytedance.android.annie.util.p.f40070a.a(r113.getMarginRight() * 1.0f);
    L73:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522319d == false) goto L81;
        if (r113.getMarginBottom() != 0) goto L78;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r102)).bottomMargin = 0;
    L78:
        if (r113.getMarginRight() != 0) goto L81;
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r102;
        ((ViewGroup.MarginLayoutParams) r118).rightMargin = 0;
        r118.setMarginEnd(0);
    L81:
        if (r112 != 0) goto L83;
    L87:
        ConstraintSet r119 = new ConstraintSet();
        r119.clone((ConstraintLayout) aa0(R.id.hybridContainer));
        r119.connect(R.id.realHybridContainer, 3, 0, 3);
        r119.applyTo((ConstraintLayout) aa0(R.id.hybridContainer));
    L88:
        FrameLayout r120 = (FrameLayout) aa0(R.id.realHybridContainer);
        if (r120 == null) goto L92;
        r120.setLayoutParams(r102);
    L92:
        FrameLayout r121 = (FrameLayout) aa0(R.id.realHybridContainer);
        if (r121 == null) goto L96;
        r121.requestLayout();
        return;
    L96:
        return;
    L83:
        if ((r112 & 17) == 17) goto L87;
        if (r103 != 80) goto L88;
        ConstraintSet r122 = new ConstraintSet();
        r122.clone((ConstraintLayout) aa0(R.id.hybridContainer));
        r122.clear(R.id.realHybridContainer, 3);
        r122.applyTo((ConstraintLayout) aa0(R.id.hybridContainer));
        goto L88
    L20:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522318c == false) goto L24;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.f39661a.f522314j == false) goto L25;
    L24:
        if (AnnieConfigSettingKeys.ENABLE_FIX_SCREEN_WIDTH.a().booleanValue() == false) goto L28;
    L14:
        if (AnnieConfigSettingKeys.ANNIE_DELETE_DIALOG_VERTIAL_BOTTOM_USE.a().booleanValue() == true) goto L17;
        r105 = false;
        goto L18
    L9:
        if (ha0() == true) goto L11;
        r104 = true;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final void qa0(Dialog r110, int r111, int r112, int r113) {
        if (r110 == null) goto L49;
        Window r114 = r110.getWindow();
        if (r114 == null) goto L49;
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522318c == false) goto L11;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.f39661a.f522314j == false) goto L49;
    L11:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522319d == true) goto L49;
        if (this.f39242e == null) goto L49;
        WindowManager.LayoutParams r100 = r114.getAttributes();
        r100.gravity = r113;
        boolean r101 = false;
        if ((r113 & 80) == 80) goto L17;
    L19:
        boolean r102 = false;
    L20:
        if (r102 == true) goto L22;
    L23:
        r101 = true;
    L24:
        if (r111 <= 0) goto L27;
        if (r101 == false) goto L27;
        r100.width = com.bytedance.android.annie.util.p.f40070a.a(r111);
    L27:
        PopupHybridParamVoNew r103 = this.f39242e;
        if (r103 != null) goto L30;
    L51:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L44
        r114.setAttributes(r100);     // Catch: Throwable -> L44
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r115);
        if (r105 == null) goto L49;
        b8.a r116 = b8.a.f17992a;
        b8.a.a(new b8.b("BaseDialogFragment", LogLevel.ERROR, r105, null, 8), true);
    L44:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L30:
        if (r103.D3() <= 0) goto L33;
        r100.x = r103.D3();
    L33:
        if (r103.E3() <= 0) goto L36;
        r100.y = r103.E3();
    L36:
        if (r103.B3() <= 0) goto L51;
        if (getContext() == null) goto L51;
        if (com.bytedance.android.annie.util.p.f40070a.getResources().getConfiguration().orientation == 2) goto L51;
        r100.width = (int) (ga0() * (r103.B3() / 100.0f));
        goto L51
    L22:
        if (AnnieConfigSettingKeys.ANNIE_DELETE_DIALOG_VERTIAL_BOTTOM_USE.a().booleanValue() == false) goto L24;
    L17:
        if (ha0() == true) goto L19;
        r102 = true;
    L49:
        pa0(r111, r112, r113);
        com.bytedance.android.annie.scheme.helper.a.d(this.f39242e, "preset_width_px", Integer.valueOf(com.bytedance.android.annie.util.p.f40070a.a(r111)));
    }

    public final void la0(String r100, int r101, int r102, int r103, int r110, BaseHybridParamVoNew.HybridType r111) {
        Intrinsics.checkNotNullParameter(r111, "type");
        ia0("update dialog prop, url:" + r100 + ", width: " + r101 + ", height: " + r102 + ", radius: " + r103);
        if (getDialog() == null) goto L72;
        Dialog r104 = getDialog();
        String r105 = null;
        if (r104 == null) goto L7;
        Window r106 = r104.getWindow();
    L8:
        if (r106 == null) goto L76;
        Dialog r107 = getDialog();
        if (r107 != null) goto L13;
    L17:
        Dialog r108 = getDialog();
        if (r108 == null) goto L20;
        Window r109 = r108.getWindow();
    L21:
        if (r109 == null) goto L27;
        r109.clearFlags(32);
        if (na0() == false) goto L25;
        r109.clearFlags(6);
        r109.setDimAmount(0.0f);
        goto L27
    L25:
        r109.getAttributes().dimAmount = 0.6f;
    L27:
        if (getActivity() != null) goto L29;
        return;
    L29:
        PopupHybridParamVoNew r112 = this.f39242e;
        if (r112 == null) goto L73;
        boolean r113 = false;
        if (r111 == BaseHybridParamVoNew.HybridType.LYNX) goto L53;
        if (r100 != null) goto L35;
    L38:
        boolean r114 = true;
    L39:
        if (r114 == true) goto L74;
        HybridFragment r115 = this.f39243f;
        if (r115 == null) goto L43;
        View r116 = r115.getHybridView();
    L45:
        if ((r116 instanceof WebView) == false) goto L47;
        WebView r117 = (WebView) r116;
    L48:
        if (r117 == null) goto L51;
        r105 = r117.getUrl();
    L51:
        if (Intrinsics.areEqual(r100, r105) == true) goto L53;
        return;
    L47:
        r117 = null;
        goto L48
    L43:
        r116 = null;
        goto L45
    L74:
        return;
    L35:
        if (StringsKt.isBlank(r100) == true) goto L38;
        r114 = false;
    L53:
        if (r112.y3() == false) goto L55;
        r102 = r102 + 48;
    L55:
        HybridFragment r118 = this.f39243f;
        if (r118 == null) goto L59;
        r118.setRadius(da0(r103));
    L59:
        if (m.a(getActivity()) == true) goto L61;
        pa0(r101, r102, r112.T2());
    L61:
        if (r110 != 1) goto L63;
    L66:
        r113 = true;
    L67:
        U90(r113);
        return;
    L63:
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522318c == false) goto L67;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.f39661a.f522314j == true) goto L67;
    L73:
        return;
    L20:
        r109 = null;
        goto L21
    L13:
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L70;
        DialogLancet.handleBlockedDialogShow(r107);
        goto L17
    L70:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L69
    L16:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
        goto L17
    L76:
        return;
    L7:
        r106 = null;
        goto L8
    }
}
