package com.bytedance.android.live.recharge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.recharge.adapter.CustomRecommendPriceAdapter;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.core.keyboard.LiveRechargeKeyBoardView;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.recharge.utils.RechargeMonitorService;
import com.bytedance.android.live.recharge.view.BalanceExchangeView;
import com.bytedance.android.live.recharge.viewmodel.CustomRechargeViewModel;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.common.utility.Lists;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.videoshop.context.VideoContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/recharge/CustomRechargeDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/recharge/adapter/CustomRecommendPriceAdapter$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomRechargeDialogFragment extends LiveDialogFragment implements CustomRecommendPriceAdapter.a {
    public static final /* synthetic */ int G = 0;
    public CustomRecommendPriceAdapter A;
    public long B;
    public long C;
    public boolean D;
    public int E;
    public long F;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f89537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CustomRechargeViewModel f89538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RechargeDialogContext f89539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.live.recharge.model.d f89540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DialogInterface.OnDismissListener f89541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IRoom f89542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f89543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f89544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f89545l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f89546m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f89547n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public EditText f89548o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f89549p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RecyclerView f89550q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LiveRechargeKeyBoardView f89551r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f89552s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LoadingStatusView f89553t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f89554u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ImageView f89555v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BalanceExchangeView f89556w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f89557x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ToggleButton f89558y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public xv0.c f89559z;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int T90() {
        RechargeDialogContext r100 = this.f89539f;
        if (r100 == null) goto L11;
        a0 r101 = r100.getRepository();
        if (r101 == null) goto L11;
        PropertyOwner r102 = r101.f89621y;
        if (r102 == null) goto L11;
        if (((Boolean) r102.f64752a).booleanValue() != true) goto L11;
        return 1;
    L11:
        return 0;
    }

    public CustomRechargeDialogFragment() {
        this.f89540g = com.bytedance.android.live.recharge.model.d.f90011p;
        this.f89546m = e4.a();
    }

    public final void S90() {
        if (PadConfigUtils.c() == false) goto L5;
        return;
    L5:
        Dialog r100 = getDialog();
        if (r100 == null) goto L22;
        Window r101 = r100.getWindow();
        if (r101 != null) goto L10;
        return;
    L10:
        if (isVertical() == false) goto L20;
        r101.setGravity(80);
        r101.setLayout(-1, -2);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = s1.y();
        r102.height = s1.w() - s1.A();
        r101.setAttributes(r102);
        View r103 = getView();
        if (r103 != null) goto L14;
        return;
    L14:
        if ((r103.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L19;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        r105.height = s1.w() - s1.A();
        r103.setLayoutParams(r105);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        return;
    L20:
        int r106 = s1.w();
        WindowManager.LayoutParams r107 = r101.getAttributes();
        r107.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        r101.setLayout(r106, r106);
        r101.setAttributes(r107);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f89541h = null;
    }

    public final void W90(List<Long> r100) {
        List<Long> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L14;
        RecyclerView r103 = this.f89550q;
        if (r103 == null) goto L27;
        ViewUtilsKt.f(r103);
        return;
    L27:
        return;
    L14:
        RecyclerView r104 = this.f89550q;
        if (r104 == null) goto L17;
        ViewUtilsKt.f(r104);
    L17:
        CustomRecommendPriceAdapter r105 = this.A;
        if (r105 != null) goto L20;
    L23:
        CustomRecommendPriceAdapter r106 = this.A;
        if (r106 == null) goto L28;
        r106.notifyDataSetChanged();
        return;
    L28:
        return;
    L20:
        if (Lists.isEmpty(r100) == true) goto L23;
        r105.f89623a = r100;
        goto L23
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.recharge.adapter.CustomRecommendPriceAdapter.a
    public final void Yq(long r100) {
        int r101 = (int) (r100 / 100.0f);
        EditText r102 = this.f89548o;
        if (r102 == null) goto L5;
        r102.setText(Editable.Factory.getInstance().newEditable(String.valueOf(r101)));
    L5:
        EditText r103 = this.f89548o;
        if (r103 == null) goto L14;
        if (r103 == null) goto L11;
        Editable r104 = r103.getText();
        if (r104 == null) goto L11;
        int r105 = r104.length();
    L12:
        r103.setSelection(r105);
        return;
    L11:
        r105 = 0;
        goto L12
    }

    public final void Z90(long r100) {
        long r101 = this.B;
        if (r100 < r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r100 = r101;
    L9:
        RechargeDialogContext r103 = this.f89539f;
        if (r103 == null) goto L18;
        a0 r104 = r103.getRepository();
        if (r104 == null) goto L18;
        PropertyOwner r105 = r104.C;
        if (r105 == null) goto L18;
        com.bytedance.android.live.recharge.deal.i r106 = (com.bytedance.android.live.recharge.deal.i) r105.f64752a;
        if (r106 == null) goto L18;
        com.bytedance.android.live.recharge.deal.d r107 = com.bytedance.android.live.recharge.deal.j.a(r106, r100, false, 6);
    L19:
        if (r107 == null) goto L21;
        long r108 = (long) (r107.f89713i * r100);
    L22:
        if (r107 == null) goto L24;
        int r109 = r107.f89708d;
    L26:
        if (r102 == true) goto L28;
        Y90(s1.C(R.string.ttlive_custom_charge_tip_normal, new Object[]{e4.a(), Long.valueOf((long) (this.B / 100.0f)), Long.valueOf(r108 + ((long) r109)), r3.b()}), s1.h(R.color.ttlive_custom_recahrge_tip_color), false);
        return;
    L28:
        if (r109 <= 0) goto L30;
        Y90(s1.C(R.string.ttlive_custom_charge_tip_bold_giving, new Object[]{Long.valueOf(((long) r109) + r108), r3.b(), Integer.valueOf(r109)}), s1.h(R.color.ttlive_custom_recahrge_tip_color_black), true);
        return;
    L30:
        Y90(s1.C(R.string.ttlive_custom_charge_tip_bold, new Object[]{Long.valueOf(r108), r3.b()}), s1.h(R.color.ttlive_custom_recahrge_tip_color_black), true);
        return;
    L24:
        r109 = 0;
        goto L26
    L21:
        r108 = 0;
    L18:
        r107 = null;
        goto L19
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L5;
        r101.setCanceledOnTouchOutside(true);
    L5:
        S90();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (FoldScreenUtils.f() == true) goto L5;
        return;
    L5:
        if (((Boolean) com.bytedance.android.live.recharge.util.g.f90435f.getValue(null, com.bytedance.android.live.recharge.util.g.f90430a[4])).booleanValue() == false) goto L41;
        ALogger.i("RechargeDialogFragmentV2", "custom recharge panel adapt for fold screen, device : " + FoldScreenUtils.d());
        S90();
        LiveRechargeKeyBoardView r101 = this.f89551r;
        Context r102 = getContext();
        if (r101 == null) goto L42;
        if (r102 == null) goto L43;
        View r103 = LayoutInflater.from(r102).inflate(R.layout.ttlive_recharge_keyboard_view, null);
        if ((r103 instanceof LiveRechargeKeyBoardView) == true) goto L12;
        r103 = null;
    L12:
        LiveRechargeKeyBoardView r104 = (LiveRechargeKeyBoardView) r103;
        View r105 = this.f89537d;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L16:
        if ((r105 instanceof ViewGroup) == true) goto L18;
        r105 = null;
    L18:
        ViewGroup r106 = (ViewGroup) r105;
        if (r106 == null) goto L21;
        Integer r107 = Integer.valueOf(r106.indexOfChild(r101));
    L22:
        ViewGroup.LayoutParams r108 = r101.getLayoutParams();
        if (r108 == null) goto L39;
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams((ConstraintLayout.LayoutParams) r108);
        if (r106 == null) goto L27;
        r106.removeView(r101);
    L27:
        if (r104 == null) goto L29;
        Intrinsics.checkNotNullParameter(r101, "other");
        r104.setDoneLabel(r101.f90246h);
        r104.setShowFastPayment(r101.f90249k);
    L29:
        r101.f90248j = null;
        if (r106 == null) goto L35;
        if (r107 == null) goto L33;
        int r110 = r107.intValue();
    L34:
        r106.addView(r104, r110, r109);
        goto L35
    L33:
        r110 = -1;
    L35:
        this.f89551r = r104;
        xv0.c r111 = this.f89559z;
        if (r111 == null) goto L44;
        r111.b(r104, this.f89548o);
        return;
    L44:
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L21:
        r107 = null;
        goto L22
    L43:
        return;
    L42:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        RechargeDialogContext r101 = this.f89539f;
        if (r101 == null) goto L5;
        boolean r102 = r101.isVertical();
    L6:
        setVertical(r102);
        if (isVertical() == false) goto L9;
        int r103 = R.style.ttlive_CommonBottomDialog;
    L10:
        setStyle(1, r103);
        if (isVertical() == true) goto L36;
        com.bytedance.android.live.revenue.core.util.j.a r104 = com.bytedance.android.live.revenue.core.util.j.C0;
        n01.a r105 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r104.a(), n01.a.class);
        if (r105 != null) goto L15;
    L16:
        if (r105 != null) goto L18;
    L19:
        n01.a r106 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r104.a(), n01.a.class);
        if (r106 == null) goto L22;
        r106.a1();
    L22:
        if (r105 != null) goto L24;
    L25:
        if (r105 != null) goto L27;
    L29:
        xs2.b.a().post(new HorizontalPlayEvent(1, HorizontalPlayEvent.SOURCE_FOR_LIVE_RECHARGE, new x2(this.f89544k, this.f89545l)));
        this.f89541h = null;
        setOnDismissListener(null);
        dismissAllowingStateLoss();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r107 = DialogFragmentLancet.sLastShowStack;
        if (r107 == null) goto L36;
        com.bytedance.crash.d.d(r107, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L36
    L27:
        if (r105.b1() != true) goto L29;
    L28:
        VideoContext.n0(getContext()).l0();
        goto L29
    L24:
        if (r105.Fm() == true) goto L28;
    L18:
        if (r105.i3() == true) goto L22;
    L15:
        if (r105.p4() == true) goto L22;
    L36:
        com.bytedance.android.live.recharge.trace.g r108 = com.bytedance.android.live.recharge.trace.f.f90392a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_CUSTOM_RECHARGE, new HashMap());
        return;
    L9:
        r103 = R.style.ttlive_CommonRightDialog;
        goto L10
    L5:
        r102 = true;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        DialogInterface.OnDismissListener r101 = this.f89541h;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.onDismiss(r100);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void U90(final com.bytedance.android.live.recharge.deal.d r100, final boolean r101) {
        ToggleButton r102 = this.f89558y;
        if (r102 != null) goto L5;
    L7:
        c9 r103 = com.bytedance.android.live.recharge.util.h.d(requireContext(), new CustomRechargeDialogFragment$preBuyDiamond$1(this, r100, r101), CustomRechargeDialogFragment$preBuyDiamond$2.INSTANCE);
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        return;
    L5:
        if (r102.isChecked() != true) goto L7;
        V90(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V90(com.bytedance.android.live.recharge.deal.d r210, boolean r211) {
        if (r210 != null) goto L6;
        Y90(s1.C(R.string.ttlive_custom_reach_min_recharge, new Object[]{e4.a(), Long.valueOf((long) (this.B / 100.0f))}), s1.h(R.color.ttlive_custom_recahrge_tip_color_highlight), false);
        return;
    L6:
        HashMap r100 = new HashMap();
        int r101 = com.bytedance.android.live.recharge.utils.m.f90492a;
        com.bytedance.android.live.recharge.utils.m.b(r100, this.f89540g, new Object[]{rw0.b.class});
        r100.put("event_module", "customized");
        RechargeDialogContext r102 = this.f89539f;
        if (r102 == null) goto L10;
        Map<String, String> r103 = r102.getReportExtraInfo("livesdk_recharge_page_pay_click");
        if (r103 == null) goto L10;
    L11:
        r100.putAll(r103);
        Context r104 = getContext();
        RechargeDialogContext r105 = this.f89539f;
        if (r105 == null) goto L14;
        com.bytedance.android.live.recharge.model.d r106 = r105.getMDialogEntranceParams();
    L15:
        if (r211 == false) goto L19;
        LoadingStatusView r107 = this.f89553t;
        if (r107 == null) goto L19;
        int r108 = r107.getHeight();
    L20:
        boolean r110 = com.bytedance.android.live.recharge.combinedpay.a.a();
        RechargeDialogContext r109 = this.f89539f;
        if (r109 == null) goto L29;
        a0 r111 = r109.getRepository();
        if (r111 == null) goto L29;
        PropertyOwner r112 = r111.f89599c;
        if (r112 == null) goto L29;
        Long r113 = (Long) r112.f64752a;
        if (r113 == null) goto L29;
        long r114 = r113.longValue();
    L30:
        Order r115 = com.bytedance.android.live.recharge.service.e.b(r210, r104, r100, r106, r211, r108, true, r110, r114, null, null, 7680);
        RechargeDialogContext r116 = this.f89539f;
        if (r116 == null) goto L35;
        com.bytedance.live.datacontext.n<Order> r117 = r116.getOrder();
        if (r117 == null) goto L35;
        r117.setValue(r115);
    L35:
        int r118 = r210.i();
        HashMap r119 = new HashMap();
        r119.put("is_first_recharge", String.valueOf(T90()));
        r119.put("given_scores", String.valueOf(r210.f89708d));
        RechargeDialogContext r120 = this.f89539f;
        if (r120 == null) goto L44;
        a0 r121 = r120.getRepository();
        if (r121 == null) goto L44;
        PropertyOwner r122 = r121.f89617u;
        if (r122 == null) goto L44;
        if (((Boolean) r122.f64752a).booleanValue() != true) goto L44;
        Object r123 = "1";
    L45:
        r119.put("is_integration_recharge", r123);
        RechargeDialogContext r124 = this.f89539f;
        String r125 = "";
        if (r124 == null) goto L49;
        String r126 = r124.getDescription(r210);
        if (r126 == null) goto L49;
    L50:
        r119.put("deal_badge", r126);
        com.bytedance.android.live.recharge.utils.m.b(r119, this.f89540g, new Object[]{rw0.b.class, rw0.f.class});
        RechargeDialogContext r127 = this.f89539f;
        if (r127 == null) goto L54;
        Map<String, String> r128 = r127.getReportExtraInfo("livesdk_recharge_page_pay_click");
        if (r128 == null) goto L54;
    L55:
        r119.putAll(r128);
        RechargeDialogContext r129 = this.f89539f;
        if (r129 == null) goto L82;
        a0 r130 = r129.getRepository();
        if (r130 == null) goto L82;
        PropertyOwner r131 = r130.f89601e;
        if (r131 == null) goto L82;
        if (((Boolean) r131.f64752a).booleanValue() != true) goto L82;
        BalanceExchangeView r132 = this.f89556w;
        if (r132 != null) goto L66;
    L81:
        r119.put("if_deduction", "0");
        goto L82
    L66:
        if (r132.getSelectStatus() != true) goto L81;
        r119.put("if_deduction", "1");
        long r133 = r210.f89707c;
        RechargeDialogContext r134 = this.f89539f;
        if (r134 == null) goto L76;
        a0 r135 = r134.getRepository();
        if (r135 == null) goto L76;
        PropertyOwner r136 = r135.f89609m;
        if (r136 == null) goto L76;
        ExchangeInfo r137 = (ExchangeInfo) r136.f64752a;
        if (r137 == null) goto L76;
        int r138 = r137.getExchangeBalance();
    L78:
        if (r138 < r133) goto L80;
        r119.put("deduction_amt", String.valueOf(r133 / ((long) 10)));
        goto L82
    L80:
        r119.put("deduction_amt", String.valueOf(r138 / 10));
    L76:
        r138 = 0;
    L82:
        r119.put("accept_recharge_agreement", "1");
        RechargeDialogContext r139 = this.f89539f;
        if (r139 == null) goto L88;
        String r140 = r139.getTwoFactoryAuthVerifyInfo();
        if (r140 == null) goto L88;
        r125 = r140;
    L88:
        r119.put("two_factory_auth_verify_info", r125);
        RechargeDialogContext r141 = this.f89539f;
        if (r141 == null) goto L91;
        r141.setTwoFactoryAuthVerifyInfo(null);
    L91:
        com.bytedance.android.live.recharge.utils.m.m(String.valueOf(r118), "customized", String.valueOf(r210.f89707c), r119, this.f89540g);
        int r142 = com.bytedance.android.live.recharge.utils.o.f90493a;
        com.bytedance.android.live.recharge.utils.o.b(true, RechargeMonitorService.TTLIVE_CHARGE_PAGE_CLICK, MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("event_module", "customized"), TuplesKt.to("request_page", "live_detail")})), null);
        RechargeDialogContext r143 = this.f89539f;
        if (r143 == null) goto L100;
        com.bytedance.live.datacontext.n<ex0.a> r144 = r143.getRechargePanelScope();
        if (r144 == null) goto L100;
        ex0.a r145 = r144.getValue();
        if (r145 == null) goto L100;
        com.bytedance.android.live.recharge.service.f r146 = (com.bytedance.android.live.recharge.service.f) com.bytedance.android.scope.m.f163449e.d(r145, com.bytedance.android.live.recharge.service.f.class);
        if (r146 == null) goto L100;
        r146.f90364e = System.currentTimeMillis();
    L100:
        this.f89541h = null;
        dismiss();     // Catch: Exception -> L103
        return;
    L103:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r147 = DialogFragmentLancet.sLastShowStack;
        if (r147 == null) goto L110;
        com.bytedance.crash.d.d(r147, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L110:
        return;
    L54:
        r128 = MapsKt.emptyMap();
    L49:
        r126 = "";
    L44:
        r123 = "0";
    L29:
        r114 = -1;
    L19:
        r108 = 0;
        goto L20
    L14:
        r106 = null;
    L10:
        r103 = MapsKt.emptyMap();
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X90(long r110, boolean r210) {
        RechargeDialogContext r100 = this.f89539f;
        int r101 = -1;
        Integer r102 = null;
        if (r100 == null) goto L94;
        a0 r103 = r100.getRepository();
        if (r103 == null) goto L94;
        PropertyOwner r104 = r103.f89601e;
        if (r104 == null) goto L94;
        if (((Boolean) r104.f64752a).booleanValue() != true) goto L94;
        LiveRechargeKeyBoardView r105 = this.f89551r;
        if (r105 == null) goto L134;
        RechargeDialogContext r111 = this.f89539f;
        if (r111 == null) goto L21;
        a0 r112 = r111.getRepository();
        if (r112 == null) goto L21;
        PropertyOwner r113 = r112.f89609m;
        if (r113 == null) goto L21;
        ExchangeInfo r114 = (ExchangeInfo) r113.f64752a;
        if (r114 == null) goto L21;
        int r115 = r114.getExchangeBalance();
    L22:
        RechargeDialogContext r116 = this.f89539f;
        if (r116 == null) goto L29;
        com.bytedance.android.live.recharge.model.d r117 = r116.getMDialogEntranceParams();
        if (r117 == null) goto L29;
        com.bytedance.android.live.recharge.model.f r118 = r117.f90022k;
        if (r118 == null) goto L29;
        Integer r119 = Integer.valueOf(r118.f90032c);
    L30:
        RechargeDialogContext r120 = this.f89539f;
        if (r120 == null) goto L37;
        com.bytedance.android.live.recharge.model.d r121 = r120.getMDialogEntranceParams();
        if (r121 == null) goto L37;
        com.bytedance.android.live.recharge.model.f r122 = r121.f90022k;
        if (r122 == null) goto L37;
        r101 = r122.f90030a;
    L37:
        if (r210 == false) goto L85;
        RechargeDialogContext r106 = this.f89539f;
        if (r106 == null) goto L84;
        a0 r107 = r106.getRepository();
        if (r107 == null) goto L84;
        PropertyOwner r108 = r107.f89609m;
        if (r108 == null) goto L84;
        ExchangeInfo r109 = (ExchangeInfo) r108.f64752a;
        if (r109 == null) goto L84;
        if (((int) r110) != 0) goto L50;
        String r123 = this.f89546m;
    L93:
        r105.setDoneLabel(r123);
        return;
    L50:
        if (r109.getExchangeBalance() < r110) goto L72;
        com.bytedance.android.live.recharge.utils.c r124 = (com.bytedance.android.live.recharge.utils.c) com.bytedance.android.live.recharge.utils.j.f90479p.getValue(null, com.bytedance.android.live.recharge.utils.j.f90464a[13]);
        if (r124.getType() != 0) goto L62;
        if (r119 != null) goto L56;
    L60:
        r123 = s1.C(R.string.ttlive_recharge_with_price_exchange_enough_custom, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r110)});
        goto L93
    L56:
        if (r119.intValue() != 1) goto L60;
        if (r110 < (((long) r101) * 10)) goto L60;
        r123 = s1.B(R.string.ttlive_custom_exchange_pay_with_vip);
        goto L93
    L62:
        if (r124.getType() != 1) goto L65;
        r123 = s1.C(R.string.ttlive_recharge_with_price_exchange_enough_optimize_custom, new Object[]{com.bytedance.android.live.recharge.utils.q.b(1), com.bytedance.android.live.recharge.utils.q.b(r110 - 1)});
        goto L93
    L65:
        if (r124.getType() == 2) goto L67;
        r123 = this.f89546m;
        goto L93
    L67:
        if ((r110 / 10) <= r124.a()) goto L69;
        r123 = s1.C(R.string.ttlive_recharge_with_price_exchange_enough_optimize_custom, new Object[]{com.bytedance.android.live.recharge.utils.q.b(1), com.bytedance.android.live.recharge.utils.q.b(r110 - 1)});
        goto L93
    L69:
        r123 = s1.C(R.string.ttlive_recharge_with_price_exchange_enough_custom, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r110)});
        goto L93
    L72:
        if (r109.getExchangeBalance() > 0) goto L74;
    L83:
        r123 = this.f89546m;
        goto L93
    L74:
        if (r109.getExchangeBalance() >= r110) goto L83;
        if (r119 != null) goto L78;
    L82:
        r123 = s1.C(R.string.ttlive_custom_balance_recharge_exchange, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r110), com.bytedance.android.live.recharge.utils.q.b(r109.getExchangeBalance())});
        goto L93
    L78:
        if (r119.intValue() != 1) goto L82;
        if (r110 < (((long) r101) * 10)) goto L82;
        r123 = s1.C(R.string.ttlive_custom_combine_pay_with_vip, new Object[]{com.bytedance.android.live.recharge.utils.q.b(r110 - ((long) r115))});
    L84:
        r123 = this.f89546m;
        goto L93
    L85:
        if (r119 != null) goto L88;
    L92:
        r123 = this.f89546m;
        goto L93
    L88:
        if (r119.intValue() != 1) goto L92;
        if ((((long) r115) + r110) < (((long) r101) * 10)) goto L92;
        r123 = s1.C(R.string.ttlive_custom_recharge_vip, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r110)});
    L29:
        r119 = null;
    L21:
        r115 = 0;
        goto L22
    L134:
        return;
    L94:
        RechargeDialogContext r125 = this.f89539f;
        if (r125 == null) goto L101;
        com.bytedance.android.live.recharge.model.d r126 = r125.getMDialogEntranceParams();
        if (r126 == null) goto L101;
        com.bytedance.android.live.recharge.model.f r127 = r126.f90022k;
        if (r127 == null) goto L101;
        r102 = Integer.valueOf(r127.f90032c);
    L101:
        if (r102 != null) goto L104;
    L130:
        LiveRechargeKeyBoardView r128 = this.f89551r;
        if (r128 == null) goto L140;
        r128.setDoneLabel(this.f89546m);
        return;
    L140:
        return;
    L104:
        if (r102.intValue() != 1) goto L130;
        RechargeDialogContext r129 = this.f89539f;
        if (r129 == null) goto L112;
        com.bytedance.android.live.recharge.model.d r130 = r129.getMDialogEntranceParams();
        if (r130 == null) goto L112;
        com.bytedance.android.live.recharge.model.f r131 = r130.f90022k;
        if (r131 == null) goto L112;
        r101 = r131.f90030a;
    L112:
        RechargeDialogContext r132 = this.f89539f;
        if (r132 == null) goto L121;
        a0 r133 = r132.getRepository();
        if (r133 == null) goto L121;
        PropertyOwner r134 = r133.f89611o;
        if (r134 == null) goto L121;
        Long r135 = (Long) r134.f64752a;
        if (r135 == null) goto L121;
        long r136 = r135.longValue();
    L122:
        Long.signum(r136);
        if (((r136 * 10) + r110) < (((long) r101) * 10)) goto L127;
        LiveRechargeKeyBoardView r137 = this.f89551r;
        if (r137 == null) goto L136;
        r137.setDoneLabel(s1.C(R.string.ttlive_custom_recharge_vip, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r110)}));
        return;
    L136:
        return;
    L127:
        LiveRechargeKeyBoardView r138 = this.f89551r;
        if (r138 == null) goto L138;
        r138.setDoneLabel(this.f89546m);
        return;
    L138:
        return;
    L121:
        r136 = 0;
        goto L122
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        com.bytedance.android.live.recharge.model.d r112 = this.f89540g;
        this.f89543j = r112.f90014c;
        this.f89544k = r112.f90013b;
        this.f89545l = r112.f90019h;
        View r113 = this.f89537d;
        if (r113 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        this.f89547n = r113.findViewById(R.id.close_view);
        View r114 = this.f89537d;
        if (r114 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L8:
        TextView r115 = (TextView) r114.findViewById(R.id.money_unit);
        if (r115 == null) goto L11;
        r115.setText(s1.C(R.string.ttlive_live_recharge_money, new Object[]{e4.a()}));
    L11:
        View r116 = this.f89537d;
        if (r116 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L14:
        this.f89548o = (EditText) r116.findViewById(R.id.custom_input);
        View r117 = this.f89537d;
        if (r117 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L17:
        this.f89549p = (TextView) r117.findViewById(R.id.tip_text);
        View r118 = this.f89537d;
        if (r118 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L20:
        TextView r119 = (TextView) r118.findViewById(R.id.diamond_title);
        if (r119 == null) goto L23;
        r119.setText(s1.C(R.string.ttlive_input_recharge_diamond_num, new Object[]{r3.c()}));
    L23:
        View r120 = this.f89537d;
        if (r120 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L26:
        this.f89550q = (RecyclerView) r120.findViewById(R.id.suggestion_deals_container);
        View r121 = this.f89537d;
        if (r121 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L29:
        this.f89551r = (LiveRechargeKeyBoardView) r121.findViewById(R.id.custom_keyboard);
        View r122 = this.f89537d;
        if (r122 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L32:
        this.f89552s = (TextView) r122.findViewById(R.id.protocol);
        View r123 = this.f89537d;
        if (r123 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L35:
        this.f89553t = (LoadingStatusView) r123.findViewById(R.id.status_view);
        View r124 = this.f89537d;
        if (r124 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L38:
        this.f89554u = (TextView) r124.findViewById(R.id.other_pay);
        View r125 = this.f89537d;
        if (r125 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L41:
        this.f89555v = (ImageView) r125.findViewById(R.id.fastpay_other_pay_arrow);
        View r126 = this.f89537d;
        if (r126 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L44:
        this.f89556w = (BalanceExchangeView) r126.findViewById(R.id.custom_exchange_view);
        List<Long> r100 = null;
        if (this.D == false) goto L70;
        RecyclerView r127 = this.f89550q;
        if (r127 == null) goto L50;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
    L51:
        if (r128 == null) goto L55;
        r128.width = s1.f(231.0f);
        RecyclerView r101 = this.f89550q;
        if (r101 == null) goto L55;
        r101.setLayoutParams(r128);
    L55:
        LiveRechargeKeyBoardView r129 = this.f89551r;
        if (r129 == null) goto L58;
        r129.setShowFastPayment(true);
    L58:
        LiveRechargeKeyBoardView r130 = this.f89551r;
        if (r130 == null) goto L61;
        r130.setDoneLabel(s1.C(R.string.ttlive_fast_recharge, new Object[]{e4.a()}));
    L61:
        TextView r131 = this.f89554u;
        if (r131 == null) goto L64;
        r131.setVisibility(0);
    L64:
        ImageView r132 = this.f89555v;
        if (r132 == null) goto L67;
        r132.setVisibility(0);
    L67:
        TextView r133 = this.f89554u;
        if (r133 == null) goto L70;
        r133.setOnClickListener(new f(this));
        goto L70
    L50:
        r128 = null;
    L70:
        TextView r134 = this.f89552s;
        if (r134 == null) goto L73;
        r134.setAlpha(0.0f);
    L73:
        TextView r135 = this.f89552s;
        if (r135 == null) goto L76;
        r135.setOnClickListener(null);
    L76:
        View r136 = this.f89537d;
        if (r136 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L79:
        LinearLayoutCompat r137 = (LinearLayoutCompat) r136.findViewById(R.id.recharge_security_container);
        if (r137 == null) goto L82;
        r137.setVisibility(0);
    L82:
        View r138 = this.f89537d;
        if (r138 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L85:
        TextView r139 = (TextView) r138.findViewById(R.id.recharge_security_protocol);
        this.f89557x = r139;
        if (r139 == null) goto L88;
        r139.setVisibility(0);
    L88:
        TextView r140 = this.f89557x;
        if (r140 == null) goto L91;
        r140.setMovementMethod(LinkMovementMethod.getInstance());
    L91:
        View r141 = this.f89537d;
        if (r141 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L94:
        ToggleButton r142 = (ToggleButton) r141.findViewById(R.id.recharge_security_toggle_btn);
        this.f89558y = r142;
        if (r142 == null) goto L97;
        r142.setVisibility(0);
    L97:
        SpannableStringBuilder r143 = com.bytedance.android.live.recharge.util.h.c(requireContext(), s1.B(R.string.ttlive_charge_security_protocal_left_text), s1.B(R.string.ttlive_charge_security_protocal_right_text), s1.C(R.string.ttlive_charge_security_protocal_text, new Object[]{r3.c(), this.f89546m}), s1.B(R.string.ttlive_charge_security_protocal_tip_text));
        TextView r144 = this.f89557x;
        if (r144 == null) goto L100;
        r144.setText(r143);
    L100:
        ToggleButton r145 = this.f89558y;
        if (r145 == null) goto L111;
        RechargeDialogContext r146 = this.f89539f;
        if (r146 == null) goto L109;
        PropertyOwner<Boolean> r147 = r146.isAcceptAgreement();
        if (r147 == null) goto L109;
        if (r147.f64752a.booleanValue() != true) goto L109;
        boolean r148 = true;
    L110:
        r145.setChecked(r148);
    L109:
        r148 = false;
    L111:
        ToggleButton r149 = this.f89558y;
        if (r149 == null) goto L114;
        r149.setOnClickListener(new g(this));
    L114:
        RechargeDialogContext r150 = this.f89539f;
        if (r150 == null) goto L155;
        a0 r151 = r150.getRepository();
        if (r151 == null) goto L155;
        PropertyOwner r152 = r151.f89601e;
        if (r152 == null) goto L155;
        if (((Boolean) r152.f64752a).booleanValue() != true) goto L155;
        BalanceExchangeView r153 = this.f89556w;
        if (r153 == null) goto L125;
        r153.setVisibility(0);
    L125:
        BalanceExchangeView r154 = this.f89556w;
        if (r154 == null) goto L128;
        r154.setOnSelectListener(new e(this));
    L128:
        BalanceExchangeView r155 = this.f89556w;
        if (r155 == null) goto L131;
        String r102 = this.f89543j;
        String r103 = this.f89544k;
        r155.f90529g = r102;
        r155.f90530h = r103;
    L131:
        if (r155 == null) goto L133;
        r155.b(this.E, "custom_recharge");
    L133:
        RechargeDialogContext r156 = this.f89539f;
        if (r156 == null) goto L158;
        a0 r157 = r156.getRepository();
        if (r157 == null) goto L158;
        PropertyOwner r158 = r157.f89609m;
        if (r158 == null) goto L158;
        ExchangeInfo r159 = (ExchangeInfo) r158.f64752a;
        if (r159 == null) goto L158;
        BalanceExchangeView r104 = this.f89556w;
        if (r104 == null) goto L158;
        int r105 = r159.getRebateLimit();
        int r160 = r159.getGiftAmount();
        if (r105 <= 0) goto L152;
        if (r160 <= 0) goto L152;
        TextView r161 = r104.f90526d;
        if (r161 == null) goto L149;
        r161.setVisibility(0);
    L149:
        TextView r162 = r104.f90526d;
        if (r162 == null) goto L158;
        r162.setText(s1.C(R.string.ttlive_balance_exchange_tip, new Object[]{com.bytedance.android.live.recharge.utils.q.a(((Long) Integer.valueOf(r105)).longValue() * 10), String.valueOf(r160)}));
    L152:
        TextView r163 = r104.f90526d;
        if (r163 == null) goto L158;
        r163.setVisibility(8);
    L158:
        X90(0, com.bytedance.android.live.recharge.combinedpay.a.a());
        View r164 = this.f89547n;
        if (r164 == null) goto L161;
        r164.setOnClickListener(new com.bytedance.android.live.recharge.a(this));
    L161:
        this.f89538e = (CustomRechargeViewModel) ViewModelProviders.of(this).get(CustomRechargeViewModel.class);
        RechargeDialogContext r165 = this.f89539f;
        if (r165 == null) goto L168;
        a0 r166 = r165.getRepository();
        if (r166 == null) goto L168;
        PropertyOwner r167 = r166.f89603g;
        if (r167 == null) goto L168;
        List<com.bytedance.android.live.recharge.deal.d> r168 = (List) r167.f64752a;
    L169:
        CustomRechargeViewModel r169 = this.f89538e;
        if (r169 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L172:
        r169.getCustomChargeDeals().setValue(r168);
        List<com.bytedance.android.live.recharge.deal.d> r170 = r168;
        this.B = com.bytedance.android.live.recharge.deal.e.c(r170);
        this.C = com.bytedance.android.live.recharge.deal.e.b(r170);
        CustomRechargeViewModel r171 = this.f89538e;
        if (r171 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L175:
        r171.getInputMoney().observe(this, new b(this));
        CustomRechargeViewModel r172 = this.f89538e;
        if (r172 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L178:
        r172.getSelectedCustomDeal().observe(this, new c(this));
        CustomRechargeViewModel r173 = this.f89538e;
        if (r173 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L181:
        r173.getCustomDealTips().observe(this, new d(this));
        CustomRechargeViewModel r174 = this.f89538e;
        if (r174 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L184:
        xv0.c r175 = new xv0.c(r174, this.f89539f);
        this.f89559z = r175;
        r175.b(this.f89551r, this.f89548o);
        xv0.c r176 = this.f89559z;
        if (r176 == null) goto L187;
        r176.f565142b = RechargeFacadeUtilsKt.a().f();
    L187:
        com.bytedance.android.live.revenue.core.util.j.a r177 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r178 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r177.a(), yz0.k.class);
        if (r178 == null) goto L190;
        IRoom r179 = r178.getRoom();
    L191:
        this.f89542i = r179;
        CustomRecommendPriceAdapter r180 = new CustomRecommendPriceAdapter();
        this.A = r180;
        Intrinsics.checkNotNullParameter(this, "listener");
        r180.f89624b = this;
        RecyclerView r181 = this.f89550q;
        if (r181 == null) goto L194;
        r181.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L194:
        RecyclerView r182 = this.f89550q;
        if (r182 == null) goto L197;
        r182.setAdapter(this.A);
    L197:
        RechargeDialogContext r183 = this.f89539f;
        if (r183 == null) goto L204;
        a0 r184 = r183.getRepository();
        if (r184 == null) goto L204;
        PropertyOwner r185 = r184.f89605i;
        if (r185 == null) goto L204;
        r100 = (List) r185.f64752a;
    L204:
        W90(r100);
        Z90(0);
        EditText r186 = this.f89548o;
        if (r186 == null) goto L207;
        r186.setHint(s1.C(R.string.ttlive_input_recharge_money_hint, new Object[]{Long.valueOf((long) (this.B / 100.0f))}));
    L207:
        n01.a r187 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r177.a(), n01.a.class);
        if (r187 != null) goto L210;
    L212:
        boolean r188 = false;
    L214:
        if (r188 == false) goto L218;
        com.bytedance.android.live.revenue.core.a r189 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r189 == null) goto L242;
        int r106 = com.bytedance.android.live.recharge.utils.m.f90492a;
        com.bytedance.android.live.recharge.utils.m.p(r189, "customized_recharge_show", "customized", Integer.valueOf(T90()), this.f89540g);
        return;
    L242:
        return;
    L218:
        HashMap r190 = new HashMap();
        RechargeDialogContext r107 = this.f89539f;
        String r108 = "1";
        if (r107 == null) goto L227;
        a0 r109 = r107.getRepository();
        if (r109 == null) goto L227;
        PropertyOwner r191 = r109.f89617u;
        if (r191 == null) goto L227;
        if (((Boolean) r191.f64752a).booleanValue() != true) goto L227;
        Object r192 = "1";
    L228:
        r190.put("is_integration_recharge", r192);
        r190.put("is_first_recharge", String.valueOf(T90()));
        RechargeDialogContext r193 = this.f89539f;
        if (r193 == null) goto L239;
        com.bytedance.android.live.recharge.model.d r194 = r193.getMDialogEntranceParams();
        if (r194 == null) goto L239;
        com.bytedance.android.live.recharge.model.f r195 = r194.f90022k;
        if (r195 == null) goto L239;
        if (r195.f90032c != 1) goto L239;
        RechargeDialogContext r196 = this.f89539f;
        Intrinsics.checkNotNull(r196);
        if (r196.getMDialogEntranceParams().f90015d == 0) goto L239;
    L240:
        r190.put("is_vipopen_package", r108);
        int r197 = com.bytedance.android.live.recharge.utils.m.f90492a;
        com.bytedance.android.live.recharge.utils.m.b(r190, this.f89540g, new Object[]{rw0.f.class});
        com.bytedance.android.live.recharge.utils.m.g("livesdk_customized_recharge_show", "", "customized", r190, this.f89540g);
        return;
    L239:
        r108 = "0";
    L227:
        r192 = "0";
        goto L228
    L210:
        if (r187.a1() != true) goto L212;
        r188 = true;
        goto L214
    L190:
        r179 = null;
    L168:
        r168 = null;
    L155:
        BalanceExchangeView r198 = this.f89556w;
        if (r198 == null) goto L158;
        r198.setVisibility(8);
        goto L158
    }

    public final void Y90(String r100, int r101, boolean r102) {
        TextView r103 = this.f89549p;
        if (r103 == null) goto L5;
        r103.setTextColor(r101);
    L5:
        TextView r104 = this.f89549p;
        if (r104 == null) goto L8;
        r104.setText(r100);
    L8:
        if (r102 == false) goto L12;
        TextView r105 = this.f89549p;
        if (r105 == null) goto L16;
        r105.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L16:
        return;
    L12:
        TextView r106 = this.f89549p;
        if (r106 == null) goto L18;
        r106.setTypeface(Typeface.DEFAULT);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_dialog_recharge_custom, r101, false);
        this.f89537d = r103;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        return r103;
    }
}
