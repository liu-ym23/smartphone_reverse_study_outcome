package com.bytedance.android.anniex.lite.container;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import com.bytedance.android.anniex.container.popup.SheetBaseDialog;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.container.view.RadiusFrameLayout;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;
import y36.r;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXFlowPopupContainer extends AnnieXLiteContainer implements ia.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f40810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ia.f.a f40811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DialogFragment f40812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f40813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Dialog f40814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f40815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f40816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f40817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f40818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f40819j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f40820k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f40821l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.anniex.container.ui.h f40822m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f40823n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f40824o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f40825p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f40826q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FrameLayout f40827r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f40828s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Boolean f40829t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f40830u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f40831v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f40832w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f40833x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f40834y;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.anniex.base.lifecycle.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnieXFlowPopupContainer f40835a;

        public b(AnnieXFlowPopupContainer r100) {
            this.f40835a = r100;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void i(String r100, ia.c r101) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            super.i(r100, r101);
            AnnieXFlowPopupContainer r102 = this.f40835a;
            View r103 = r102.getKitView();
            if (r103 != null) goto L5;
            return;
        L5:
            if ((r103 instanceof WebView) == false) goto L9;
            r102.f40810a.runOnUiThread(new h(r103, r102));
            return;
        }
    }

    public static final class c implements com.bytedance.ies.bullet.core.kit.bridge.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f40836a;

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final String getName() {
            return "H5_halfFullStatusChange";
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final Object getParams() {
            return this.f40836a;
        }

        public c(JSONObject r100) {
            this.f40836a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$observerKeyboardStatusChange$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(Object r100) {
            super(1, r100, AnnieXFlowPopupContainer.class, "onSoftInputChange", "onSoftInputChange(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
            invoke(r100.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r100) {
            ((AnnieXFlowPopupContainer) this.receiver).onSoftInputChange(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final String getViewType() {
        return "popup";
    }

    @Override // ia.h
    public final void k(boolean r100) {
    }

    @Override // ia.g
    public final void n(boolean r100) {
    }

    @Override // ia.e
    public final void onActivityCreated(Bundle r100) {
    }

    @Override // ia.e
    public final void onActivityResult(int r100, int r101, Intent r102) {
    }

    @Override // ia.e
    public final void onDestroy() {
    }

    @Override // ia.e
    public final void onPause() {
    }

    @Override // ia.f
    public final Integer i() {
        Dialog r100 = this.f40814e;
        Integer r101 = null;
        if ((r100 instanceof SheetBaseDialog) == false) goto L5;
        SheetBaseDialog r102 = (SheetBaseDialog) r100;
    L6:
        if (r102 == null) goto L12;
        if (r102.f40505p == false) goto L10;
        r101 = Integer.valueOf(r102.f40506q);
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return this.f40823n;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ia.e
    public final void onStart() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        z();     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final ab.a r() {
        return (ab.a) this.f40820k.getValue();
    }

    public final ab.b s() {
        return (ab.b) this.f40821l.getValue();
    }

    public final void t() {
        Dialog r100 = this.f40814e;
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.clearFlags(2);
    L7:
        Dialog r102 = this.f40814e;
        if (r102 == null) goto L13;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L14;
        r103.setDimAmount(0.0f);
        return;
    L14:
        return;
    }

    public final boolean v() {
        return com.bytedance.android.anniex.container.util.h.a(this.f40810a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z() {
        Dialog r100 = this.f40814e;
        if (r100 != null) goto L5;
        return;
    L5:
        Window r101 = r100.getWindow();
        Boolean r102 = this.f40829t;
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L28;
        if (r101 == null) goto L28;
        ab.a r104 = r();
        if (r104 == null) goto L28;
        WindowManager.LayoutParams r105 = r101.getAttributes();
        y36.a r106 = r104.f2425y;
        if (r106 == null) goto L13;
        boolean r107 = Intrinsics.areEqual(r106.f565862b, r103);
    L14:
        if (r107 == true) goto L16;
    L26:
        r101.setAttributes(r105);
        goto L28
    L16:
        if (com.bytedance.android.anniex.container.util.i.f40626a.getResources().getConfiguration().orientation != 2) goto L18;
        r105.windowAnimations = R.style.annie_x_popup_no_enter_anim_horizontal;
        goto L26
    L18:
        y36.l r108 = r104.f2426z;
        if (r108 == null) goto L21;
        PopupType r109 = (PopupType) r108.f565862b;
    L23:
        if (r109 != PopupType.RIGHT) goto L25;
        r105.windowAnimations = R.style.annie_x_popup_no_enter_anim_horizontal;
        goto L26
    L25:
        r105.windowAnimations = R.style.annie_x_popup_no_enter_anim_vertical;
        goto L26
    L21:
        r109 = null;
        goto L23
    L13:
        r107 = false;
    L28:
        if (this.f40829t != null) goto L31;
        this.f40829t = r103;
        return;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b
    public final void observerKeyboardStatusChange() {
        if (com.bytedance.ies.bullet.service.base.h.o0() == false) goto L7;
        Dialog r100 = this.f40814e;
        if (r100 == null) goto L9;
        SoftInputKt.d(r100, new AnonymousClass1(this));
        return;
    L9:
        return;
    L7:
        super.observerKeyboardStatusChange();
    }

    @Override // ia.e
    public final void onResume() {
        enterForeground();
        if (AnnieXContainerManager.isTopContainer(this) == false) goto L6;
        onVisibleChange(true, Boolean.TRUE);
        return;
    }

    @Override // ia.e
    public final void onStop() {
        enterBackground();
        onVisibleChange(false, Boolean.TRUE);
    }

    public final boolean u() {
        ab.a r100 = r();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L15;
        ab.a r102 = r();
        if (r102 != null) goto L12;
    L14:
        return false;
    L12:
        if (r102.y() != true) goto L14;
        return true;
    L15:
        ab.a r103 = r();
        if (r103 == null) goto L18;
        int r104 = r103.f();
    L20:
        if (RangesKt.coerceAtMost(r104 / 100.0f, 1.0f) < 1.0f) goto L14;
        return true;
    L18:
        r104 = 0;
        goto L20
    L5:
        if (r100.w() != true) goto L7;
        r101 = true;
        goto L8
    }

    public final boolean x() {
        ab.a r100 = r();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.n() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void y() {
        ab.a r100 = r();
        if (r100 == null) goto L15;
        Dialog r101 = this.f40814e;
        if (r101 == null) goto L9;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.addFlags(2);
    L9:
        Dialog r103 = this.f40814e;
        if (r103 == null) goto L16;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L17;
        r104.setDimAmount(r100.n());
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final Scenes getScenes() {
        return Scenes.PopupFragment;
    }

    public AnnieXFlowPopupContainer(com.bytedance.android.anniex.base.builder.c r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        super(r100);
        this.f40810a = r100.e();
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        this.f40815f = -16777216;
        this.f40817h = true;
        this.f40818i = true;
        this.f40819j = true;
        this.f40820k = LazyKt.lazy(new AnnieXFlowPopupContainer$annieXPopupModel$2(this));
        this.f40821l = LazyKt.lazy(new AnnieXFlowPopupContainer$annieXStatusAndNavModel$2(this));
        this.f40826q = -1;
        this.f40828s = new b(this);
        this.f40832w = 1024;
        this.f40833x = 2048;
        this.f40834y = -1;
    }

    public static View q(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.e
    public final void a(View r210) {
        this.f40813d = r210;
        if (r210 == null) goto L5;
        FrameLayout r100 = (FrameLayout) r210.findViewById(R.id.annie_x_container_view);
    L6:
        if (r100 != null) goto L8;
        r100 = new FrameLayout(this.f40810a);
    L8:
        setParentViewGroup(r100);
        Window r101 = this.f40810a.getWindow();
        this.f40832w = q(r101).getSystemUiVisibility();
        this.f40833x = r101.getAttributes().flags;
        this.f40834y = r101.getStatusBarColor();
        FragmentActivity r102 = this.f40810a;
        View r103 = this.f40813d;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f40822m = new com.bytedance.android.anniex.container.ui.h(r102, this, (ViewGroup) r103);
        initUi();
        ab.b r104 = s();
        if (r104 == null) goto L21;
        com.bytedance.android.anniex.container.ui.h r105 = this.f40822m;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r105 = null;
    L13:
        Dialog r106 = this.f40814e;
        if (r106 == null) goto L16;
        Window r107 = r106.getWindow();
    L17:
        r105.c(r107, r104);
        com.bytedance.android.anniex.container.ui.h r108 = this.f40822m;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r108 = null;
    L20:
        r108.b(r104, getBid());
        goto L21
    L16:
        r107 = null;
    L21:
        ab.a r109 = r();
        if (r109 == null) goto L31;
        y36.a r110 = r109.f2411k;
        if (r110 == null) goto L28;
        Boolean r111 = (Boolean) r110.f565862b;
        if (r111 == null) goto L28;
        boolean r112 = r111.booleanValue();
    L29:
        if (r112 != true) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L36;
        View r114 = this.f40813d;
        if (r114 == null) goto L39;
        View r115 = (ImageView) r114.findViewById(R.id.annie_x_activity_close);
    L40:
        this.f40825p = r115;
        ab.a r116 = r();
        if (r116 != null) goto L43;
    L45:
        boolean r117 = false;
    L46:
        if (r117 == false) goto L61;
        ab.b r118 = s();
        if (r118 == null) goto L55;
        y36.a r119 = r118.f2433g;
        if (r119 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("showClosealways");
        r119 = null;
    L53:
        if (r119 == null) goto L55;
        boolean r120 = Intrinsics.areEqual(r119.f565862b, Boolean.TRUE);
    L56:
        if (r120 == true) goto L61;
        View r121 = this.f40825p;
        if (r121 == null) goto L61;
        r121.setAlpha(0.0f);
    L55:
        r120 = false;
    L61:
        ab.b r122 = s();
        if (r122 == null) goto L78;
        y36.a r123 = r122.b();
        if (r123 == null) goto L78;
        Boolean r124 = (Boolean) r123.f565862b;
        if (r124 == null) goto L78;
        if (r124.booleanValue() == true) goto L71;
        r124 = null;
    L71:
        if (r124 == null) goto L78;
        r124.booleanValue();
        View r125 = this.f40825p;
        if (r125 == null) goto L76;
        r125.setVisibility(0);
    L76:
        if (r125 == null) goto L78;
        r125.setOnClickListener(new g(this));
    L78:
        ab.a r126 = r();
        if (r126 != null) goto L81;
    L86:
        boolean r127 = true;
    L87:
        if (r127 == true) goto L101;
        ab.a r128 = r();
        if (r128 != null) goto L91;
    L93:
        boolean r129 = false;
    L94:
        if (r129 == false) goto L101;
        DialogFragment r130 = this.f40812c;
        if (r130 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r130 = null;
    L98:
        r130.setCancelable(true);
        Dialog r131 = this.f40814e;
        if (r131 == null) goto L104;
        r131.setCanceledOnTouchOutside(true);
    L104:
        ab.a r132 = r();
        if (r132 == null) goto L107;
        r132.e();
    L107:
        Resources r133 = getContext().getResources();
        int r134 = WindowDisplayMetricsOverride.apply(r133, r133.getDisplayMetrics()).widthPixels;
        com.bytedance.android.anniex.container.util.i r135 = com.bytedance.android.anniex.container.util.i.f40626a;
        int r136 = com.bytedance.android.anniex.container.util.i.c(this.f40810a).heightPixels;
        i16.c r137 = i16.c.f487996a;
        int r138 = r136 - r137.h(this.f40810a);
        boolean r139 = v();
        if (r139 == true) goto L111;
        r136 = r138;
    L111:
        HybridLogger r140 = HybridLogger.f246343a;
        HybridLogger.m("AnnieXFlowPopupContainer", "screenHeight: " + r136 + "; screenWidth: " + r134, null, null, 12);
        ab.a r141 = r();
        if (r141 != null) goto L114;
    L145:
        Window r142 = this.f40810a.getWindow();
        if (r142 == null) goto L148;
        this.f40815f = r142.getStatusBarColor();
    L148:
        ab.a r143 = r();
        if (r143 == null) goto L274;
        int r144 = r143.A();
        com.bytedance.android.anniex.container.util.i r145 = com.bytedance.android.anniex.container.util.i.f40626a;
        r143.G(RangesKt.coerceAtMost(r144, (int) r145.e(r134)));
        if (r143.v() <= 0) goto L154;
        if (r139 == true) goto L154;
        r143.E((int) r145.e((int) (((double) (r143.v() * r134)) / 375.0d)));
        HybridLogger.m("AnnieXFlowPopupContainer", "rateHeight: " + r143.v() + "; screenWidth: " + r134 + " ; this.height1: " + r143.e(), null, null, 12);
    L154:
        if (r139 == true) goto L156;
    L158:
        if (r139 == false) goto L165;
        y36.a r146 = r143.f2418r;
        if (r146 == null) goto L162;
        boolean r147 = Intrinsics.areEqual(r146.f565862b, Boolean.TRUE);
    L163:
        if (r147 == false) goto L165;
    L170:
        if ((r143.e() + r143.l()) < ((int) r145.e(r136))) goto L173;
        r143.E(r143.e() - r143.l());
    L173:
        if (r143.f() <= 0) goto L176;
        if (r139 == true) goto L176;
        r143.E((int) r145.e((int) (r136 * (r143.f() / 100.0f))));
    L176:
        if (r139 == true) goto L181;
        if (r143.e() <= r136) goto L181;
        r143.E((int) r145.e(r136));
    L181:
        if (u() == false) goto L184;
        r143.E((int) r145.e(com.bytedance.android.anniex.container.util.i.c(this.f40810a).heightPixels - r137.h(this.f40810a)));
    L184:
        if (r143.B() <= 0) goto L187;
        if (r139 == true) goto L187;
        r143.G((int) r145.e((int) (r134 * (r143.B() / 100.0f))));
    L187:
        y36.a r148 = r143.f2419s;
        if (r148 == null) goto L190;
        boolean r149 = Intrinsics.areEqual(r148.f565862b, Boolean.TRUE);
    L191:
        if (r149 == false) goto L195;
        if (r139 == false) goto L195;
        r143.G((int) r145.e(r143.k() + r136));
    L195:
        if (r143.e() > 0) goto L198;
        r143.E(450);
    L198:
        if (r143.A() > 0) goto L200;
        r143.G(300);
    L200:
        y36.a r150 = r143.R;
        if (r150 == null) goto L203;
        boolean r151 = Intrinsics.areEqual(r150.f565862b, Boolean.TRUE);
    L204:
        if (r151 == false) goto L207;
        r143.E(r143.e() + 48);
    L207:
        if (r143.w() == false) goto L229;
        int r152 = r137.h(getContext());
        if (r143.z() == false) goto L211;
        int r153 = com.bytedance.android.anniex.container.util.i.c(this.f40810a).heightPixels - r152;
    L212:
        r143.E(((int) r145.e(r153)) + 2);
        if (r143.x() <= 0) goto L222;
        float r154 = 1 - RangesKt.coerceAtMost(r143.x() / 100.0f, 1.0f);
        if (r143.z() == false) goto L217;
        r153 = r153 + r152;
    L217:
        float r155 = r153 * r154;
        if (r143.z() == false) goto L220;
        int r156 = r152 + 2;
    L221:
        r143.O = new y36.d(Integer.valueOf((int) r145.e((int) (r155 - r156))));
        goto L222
    L220:
        r156 = 0;
    L222:
        r r157 = r143.P;
        if (r157 == null) goto L227;
        Integer r158 = (Integer) r157.f565862b;
        if (r158 == null) goto L227;
        int r159 = r158.intValue();
    L228:
        this.f40816g = r159;
    L227:
        r159 = 1580077;
        goto L228
    L211:
        r153 = r145.d();
    L229:
        y36.a r160 = r143.S;
        if (r160 == null) goto L232;
        boolean r161 = Intrinsics.areEqual(r160.f565862b, Boolean.TRUE);
    L233:
        if (r161 == false) goto L243;
        if (v() == true) goto L243;
        ia.f.a r162 = this.f40811b;
        if (r162 != null) goto L239;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r162 = null;
    L239:
        Integer r163 = r162.f(MapsKt.emptyMap());
        if (r163 == null) goto L243;
        r143.E((int) (((double) r145.e(r163.intValue())) + 0.5d));
        r143.F = new y36.d(0);
        r143.G = new y36.d(0);
    L243:
        if (r143.q() >= 0) goto L246;
        r143.F(0);
    L246:
        if (r143.t() >= 0) goto L249;
        r143.F = new y36.d(0);
    L249:
        if (r143.u() >= 0) goto L252;
        r143.G = new y36.d(0);
    L252:
        if (r143.s() >= 0) goto L255;
        r143.I = new y36.d(0);
    L255:
        if (r143.r() >= 0) goto L257;
        r143.H = new y36.d(0);
    L257:
        if (r139 == false) goto L274;
        float r164 = RangesKt.coerceAtMost(r143.h(), 100) / 100.0f;
        float r165 = 0;
        if (r164 <= r165) goto L261;
        r143.E((int) r145.e((int) (r136 * r164)));
    L261:
        y36.j r166 = r143.f2416p;
        if (r166 == null) goto L266;
        Integer r167 = (Integer) r166.f565862b;
        if (r167 == null) goto L266;
        int r168 = r167.intValue();
    L267:
        float r169 = RangesKt.coerceAtMost(r168, 100) / 100.0f;
        if (r169 <= r165) goto L271;
        r143.G((int) r145.e((int) (r134 * r169)));
    L271:
        if (r143.i() <= 0) goto L274;
        r143.F(r143.i());
    L266:
        r168 = 0;
        goto L267
    L232:
        r161 = false;
        goto L233
    L203:
        r151 = false;
        goto L204
    L190:
        r149 = false;
        goto L191
    L162:
        r147 = false;
    L165:
        if (r143.d() != 80) goto L170;
        int r170 = (int) (r136 * 0.85f);
        if (r143.e() <= r145.e(r170)) goto L170;
        r143.E((int) r145.e(r170));
        HybridLogger.m("AnnieXFlowPopupContainer", "screenHeight: " + r136 + "; screenWidth: " + r134 + " ; this.height2: " + r143.e(), null, null, 12);
        goto L170
    L156:
        if (r143.e() <= r136) goto L158;
        r143.E((int) r145.e(r136 - (r143.k() * 2)));
    L274:
        if (r() == null) goto L291;
        ab.a r171 = r();
        if (r171 == null) goto L291;
        Dialog r172 = this.f40814e;
        if ((r172 instanceof SheetBaseDialog) == false) goto L280;
        SheetBaseDialog r173 = (SheetBaseDialog) r172;
    L281:
        if (r173 == null) goto L291;
        boolean r174 = r171.w();
        int r175 = r171.e();
        y36.d r176 = r171.O;
        if (r176 == null) goto L287;
        Integer r177 = (Integer) r176.f565862b;
        if (r177 == null) goto L287;
        int r178 = r177.intValue();
    L288:
        r173.f40505p = r174;
        if (r178 <= 0) goto L291;
        r173.f40506q = i16.c.f(r175 - r178, r173.getContext());
    L287:
        r178 = 0;
        goto L288
    L280:
        r173 = null;
    L291:
        Dialog r179 = this.f40814e;
        if (r179 == null) goto L296;
        Window r180 = r179.getWindow();
        if (r180 == null) goto L296;
        r180.addFlags(Integer.MIN_VALUE);
        r180.setStatusBarColor(0);
        r180.setNavigationBarColor(0);
    L296:
        HybridLogger.m("AnnieXFlowPopupContainer", "===onCreateView: " + getUrl(), null, null, 12);
        return;
    L114:
        if (v() == false) goto L143;
        y36.a r181 = r141.f2418r;
        if (r181 == null) goto L118;
        boolean r182 = Intrinsics.areEqual(r181.f565862b, Boolean.TRUE);
    L119:
        if (r182 == true) goto L121;
        r141.F(8);
        r141.E((int) com.bytedance.android.anniex.container.util.i.f40626a.e(r136 - (r141.k() * 2)));
        r141.G(300);
    L121:
        y36.a r183 = r141.f2417q;
        if (r183 == null) goto L124;
        boolean r184 = Intrinsics.areEqual(r183.f565862b, Boolean.FALSE);
    L125:
        if (r184 == false) goto L128;
        r141.f2408h = Integer.valueOf(GravityCompat.END);
    L131:
        if (r141.j() <= 0) goto L134;
        r141.G(r141.j());
    L134:
        if (r141.g() <= 0) goto L137;
        r141.E(r141.g());
    L137:
        if (r141.h() <= 0) goto L139;
        r141.E((int) com.bytedance.android.anniex.container.util.i.f40626a.e((com.bytedance.android.anniex.container.util.i.c(this.f40810a).heightPixels * r141.h()) / 100));
    L139:
        r141.M = new y36.a(Boolean.FALSE);
        if (i16.c.d(getContext()) == false) goto L145;
        r141.W = new y36.d(Integer.valueOf(r137.h(getContext())));
        goto L145
    L128:
        if (r141.d() != 80) goto L131;
        r141.f2408h = Integer.valueOf(VideoPlayDataContext.PLAYING_GRAVITY);
        goto L131
    L124:
        r184 = false;
        goto L125
    L118:
        r182 = false;
        goto L119
    L143:
        if (i16.c.d(getContext()) == false) goto L145;
        r141.X = new y36.d(Integer.valueOf(r137.h(getContext())));
        goto L145
    L91:
        if (r128.c() != true) goto L93;
        r129 = true;
    L101:
        Dialog r185 = this.f40814e;
        if (r185 == null) goto L104;
        r185.hide();
        goto L104
    L81:
        if (r126.A() == 0) goto L83;
    L85:
        r127 = false;
        goto L87
    L83:
        if (r126.e() != 0) goto L85;
    L43:
        if (r116.w() != true) goto L45;
        r117 = true;
    L39:
        r115 = null;
        goto L40
    L36:
        View r186 = this.f40813d;
        if (r186 == null) goto L39;
        r115 = r186.findViewById(R.id.annie_x_activity_close_left);
    L28:
        r112 = true;
    L31:
        r113 = false;
        goto L32
    L5:
        r100 = null;
        goto L6
    }

    @Override // ia.g
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "statusBarBgColor");
        com.bytedance.android.anniex.container.ui.h r101 = this.f40822m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r101 = null;
    L5:
        r101.g(r100);
        return true;
    }

    @Override // ia.f
    public final void d(ia.f.a r100) {
        Intrinsics.checkNotNullParameter(r100, "popupComponent");
        this.f40811b = r100;
        super.setUiComponent(r100);
    }

    @Override // ia.h
    public final boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "titleBarBgColor");
        com.bytedance.android.anniex.container.ui.h r101 = this.f40822m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r101 = null;
    L5:
        r101.e(r100);
        return true;
    }

    @Override // ia.h
    public final void f(boolean r100) {
        com.bytedance.android.anniex.container.ui.h r101 = null;
        if (r100 == false) goto L9;
        com.bytedance.android.anniex.container.ui.h r102 = this.f40822m;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
    L8:
        r101.l();
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        com.bytedance.android.anniex.container.ui.h r103 = this.f40822m;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
    L13:
        r101.a();
        return;
    L12:
        r101 = r103;
        goto L13
    }

    @Override // ia.f
    public final Dialog h(Bundle r110) {
        ab.a r100 = r();
        if (r100 == null) goto L7;
        y36.a r101 = r100.f2403c;
        if (r101 == null) goto L7;
        boolean r102 = Intrinsics.areEqual(r101.f565862b, Boolean.TRUE);
    L8:
        DialogFragment r103 = null;
        boolean r104 = true;
        if (r102 == false) goto L19;
        ia.f.a r105 = this.f40811b;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r105 = null;
    L13:
        Dialog r111 = r105.g(r110);
        if (r111 == null) goto L18;
        Window r106 = r111.getWindow();
        if (r106 == null) goto L27;
        r106.setBackgroundDrawable(new ColorDrawable(0));
        r106.addFlags(256);
    L27:
        this.f40814e = r111;
        ab.a r112 = r();
        if (r112 == null) goto L30;
        r104 = r112.c();
    L30:
        DialogFragment r113 = this.f40812c;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L34:
        r103.setCancelable(r104);
        Dialog r114 = this.f40814e;
        if (r114 == null) goto L37;
        r114.setCanceledOnTouchOutside(r104);
    L37:
        Dialog r115 = this.f40814e;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.app.Dialog");
        return r115;
    L33:
        r103 = r113;
        goto L34
    L18:
        r111 = null;
        goto L27
    L19:
        Context r107 = getContext();
        boolean r108 = v();
        boolean r109 = v();
        if (u() == false) goto L23;
        if (r109 == true) goto L23;
        boolean r116 = true;
    L24:
        r111 = new SheetBaseDialog(r107, r108, false, r116, false, 0);
        Window r117 = r111.getWindow();
        if (r117 == null) goto L27;
        r117.setBackgroundDrawable(new ColorDrawable(0));
        r117.addFlags(256);
    L23:
        r116 = r109;
    L7:
        r102 = false;
        goto L8
    }

    @Override // ia.f
    public final void m(boolean r100) {
        this.f40817h = r100;
    }

    @Override // ia.f
    public final void o(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        this.f40812c = r100;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.e
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.m("AnnieXFlowPopupContainer", "===onConfigurationChanged: " + getUrl(), null, null, 12);
        ab.a r102 = r();
        if (r102 == null) goto L6;
        A(this.f40814e, r102.A(), r102.e(), r102.d());
        return;
    }

    @Override // ia.b, ia.c
    public final void onCreate(Bundle r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        DialogFragment r102 = null;
        HybridLogger.m("AnnieXFlowPopupContainer", "onCreate: " + getUrl(), null, null, 12);
        com.bytedance.android.anniex.container.b r103 = getLifecycleDispatcher();
        b r104 = this.f40828s;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r103.f40349a.add(r104);
        setContainerVisible(true);
        if (v() == false) goto L9;
        DialogFragment r105 = this.f40812c;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L8:
        r102.setStyle(1, R.style.annie_x_no_floating_dialog);
        return;
    L7:
        r102 = r105;
        goto L8
    L9:
        DialogFragment r106 = this.f40812c;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L13:
        r102.setStyle(1, R.style.annie_x_floating_dialog);
        return;
    L12:
        r102 = r106;
        goto L13
    }

    @Override // ia.f
    public final void onDismiss(DialogInterface r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        y36.a r102 = null;
        HybridLogger.m("AnnieXFlowPopupContainer", "===onDismiss: " + getUrl(), null, null, 12);
        ab.b r103 = s();
        boolean r104 = false;
        if (r103 == null) goto L10;
        y36.a r105 = r103.f2430d;
        if (r105 == null) goto L7;
        r102 = r105;
    L8:
        if (r102 == null) goto L10;
        boolean r106 = Intrinsics.areEqual(r102.f565862b, Boolean.TRUE);
    L11:
        if (r106 == true) goto L18;
        ab.b r107 = s();
        if (r107 == null) goto L17;
        y36.a r108 = r107.c();
        if (r108 == null) goto L17;
        r104 = Intrinsics.areEqual(r108.f565862b, Boolean.TRUE);
    L17:
        if (r104 == true) goto L18;
    L19:
        Window r109 = this.f40810a.getWindow();
        if (r109 == null) goto L25;
        int r110 = r109.getStatusBarColor();
        int r111 = this.f40815f;
        if (r110 == r111) goto L26;
        r109.setStatusBarColor(r111);
        return;
    L26:
        return;
    L25:
        return;
    L18:
        Window r112 = this.f40810a.getWindow();
        r112.clearFlags(Integer.MIN_VALUE);
        q(r112).setSystemUiVisibility(this.f40832w);
        r112.addFlags(this.f40833x);
        r112.setStatusBarColor(this.f40834y);
        goto L19
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("hideStatusBar");
    L10:
        r106 = false;
        goto L11
    }

    @Override // ia.f
    public final void onShow(DialogInterface r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.m("AnnieXFlowPopupContainer", "===onShow: " + getUrl(), null, null, 12);
        if (v() == false) goto L10;
        Dialog r102 = this.f40814e;
        if (r102 == null) goto L11;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L12;
        r103.clearFlags(8);
        q(r103).setSystemUiVisibility(5894);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // ia.h
    public final boolean p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "titleColor");
        com.bytedance.android.anniex.container.ui.h r101 = this.f40822m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r101 = null;
    L5:
        r101.k(r100);
        return true;
    }

    @Override // ia.g
    public final boolean setStatusFontMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "statusFontMode");
        com.bytedance.android.anniex.container.ui.h r101 = this.f40822m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r101 = null;
    L5:
        r101.i(r100);
        return true;
    }

    @Override // ia.h
    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        com.bytedance.android.anniex.container.ui.h r101 = this.f40822m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r101 = null;
    L5:
        r101.j(r100);
    }

    @Override // ia.e
    public final void setUserVisibleHint(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        onVisibleChange(r100, Boolean.FALSE);
        return;
    L4:
        if (getContainerVisible() == false) goto L6;
        setContainerVisible(false);
        goto L6
    }

    public final void w(int r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L4
        r101.put("status", r100);     // Catch: JSONException -> L4
        sendEvent(new c(r101));     // Catch: JSONException -> L4
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.e
    public final void b(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        HybridLogger r112 = HybridLogger.f246343a;
        Integer r100 = null;
        HybridLogger.m("AnnieXFlowPopupContainer", "===onViewCreated: " + getUrl(), null, null, 12);
        Dialog r113 = this.f40814e;
        if ((r113 instanceof SheetBaseDialog) == false) goto L5;
        SheetBaseDialog r114 = (SheetBaseDialog) r113;
    L6:
        if (r114 == null) goto L8;
        r114.f40504o = new com.bytedance.android.anniex.lite.container.a(this);
    L8:
        View r115 = this.f40813d;
        if (r115 == null) goto L11;
        r115.setOnClickListener(new com.bytedance.android.anniex.lite.container.b(this));
    L11:
        Dialog r116 = this.f40814e;
        if ((r116 instanceof SheetBaseDialog) == false) goto L14;
        SheetBaseDialog r117 = (SheetBaseDialog) r116;
    L15:
        if (r117 == null) goto L19;
        com.bytedance.android.anniex.lite.container.c r101 = new com.bytedance.android.anniex.lite.container.c(this);
        Intrinsics.checkNotNullParameter(r101, "bottomSheetPullUpProcessor");
        r117.f40503n = new com.bytedance.android.anniex.container.popup.a(r101, r117);
        SheetBaseBehavior<?> r102 = r117.f40495f;
        if (r102 == null) goto L19;
        Intrinsics.checkNotNull(r102);
        r102.f40489e = r117.f40503n;
    L19:
        ab.a r118 = r();
        boolean r103 = true;
        if (r118 != null) goto L22;
    L24:
        boolean r119 = false;
    L25:
        if (r119 == false) goto L27;
        w(1);
    L27:
        Dialog r120 = this.f40814e;
        if ((r120 instanceof SheetBaseDialog) == false) goto L30;
        SheetBaseDialog r121 = (SheetBaseDialog) r120;
    L31:
        if (r121 == null) goto L35;
        d r104 = new d(this);
        Intrinsics.checkNotNullParameter(r104, "bottomSheetSlideProcessor");
        r121.f40502m = new com.bytedance.android.anniex.container.popup.b(r104, r121);
        SheetBaseBehavior<?> r105 = r121.f40495f;
        if (r105 == null) goto L35;
        Intrinsics.checkNotNull(r105);
        r105.f40488d = r121.f40502m;
    L35:
        Dialog r122 = this.f40814e;
        if ((r122 instanceof SheetBaseDialog) == false) goto L38;
        SheetBaseDialog r123 = (SheetBaseDialog) r122;
    L39:
        if (r123 == null) goto L43;
        e r106 = new e(this);
        if (r123.f40501l.contains(r106) == true) goto L43;
        r123.f40501l.add(r106);
    L43:
        ab.a r124 = r();
        if (r124 == null) goto L48;
        y36.a r125 = r124.R;
        if (r125 == null) goto L48;
        boolean r126 = Intrinsics.areEqual(r125.f565862b, Boolean.TRUE);
    L49:
        if (r126 == false) goto L55;
        View r127 = this.f40813d;
        if (r127 == null) goto L55;
        ImageView r128 = (ImageView) r127.findViewById(R.id.annie_x_dialog_btn_close);
        if (r128 == null) goto L55;
        r128.setVisibility(0);
        r128.setOnClickListener(new f(this));
    L55:
        Dialog r129 = this.f40814e;
        if (r129 == null) goto L58;
        Window r130 = r129.getWindow();
    L59:
        ab.a r107 = r();
        if (r107 == null) goto L158;
        A(this.f40814e, r107.A(), r107.e(), r107.d());
        if (r107.q() <= 0) goto L68;
        float r108 = com.bytedance.android.anniex.container.util.i.f40626a.a(r107.q());
        View r109 = this.f40813d;
        if (r109 == null) goto L73;
        RadiusFrameLayout r131 = (RadiusFrameLayout) r109.findViewById(R.id.annie_x_container_view);
        if (r131 == null) goto L73;
        r131.setRadius(r108);
    L73:
        if (r130 == null) goto L158;
        y36.a r132 = r107.Y;
        if (r132 == null) goto L79;
        Boolean r133 = (Boolean) r132.f565862b;
        if (r133 == null) goto L79;
        boolean r134 = r133.booleanValue();
    L80:
        if (r134 == true) goto L82;
        r130.setSoftInputMode(48);
    L82:
        WindowManager.LayoutParams r135 = r130.getAttributes();
        r135.width = -1;
        r135.height = -1;
        y36.a r136 = r107.f2425y;
        if (r136 == null) goto L85;
        boolean r137 = Intrinsics.areEqual(r136.f565862b, Boolean.TRUE);
    L86:
        if (r137 == true) goto L88;
        r135.windowAnimations = R.style.annie_x_popup_no_anim;
    L202:
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L101
        r130.setAttributes(r135);     // Catch: Throwable -> L101
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L104:
        if (x() == false) goto L106;
        y();
    L204:
        r r139 = r107.f2424x;     // Catch: Exception -> L131
        if (r139 == null) goto L128;
        Integer r140 = (Integer) r139.f565862b;     // Catch: Exception -> L131
        if (r140 == null) goto L128;
        int r141 = r140.intValue();     // Catch: Exception -> L131
    L129:
        r130.setBackgroundDrawable(new ColorDrawable(r141));     // Catch: Exception -> L131
    L134:
        if (r107.A() <= 0) goto L136;
        int r142 = com.bytedance.android.anniex.container.util.i.f40626a.a(r107.A() + r107.m());
    L137:
        r130.setLayout(r142, -1);
        if (u() == true) goto L140;
        r130.setFlags(1024, 1024);
    L140:
        ab.a r143 = r();
        if (r143 != null) goto L143;
    L148:
        if (r103 == false) goto L151;
        r130.addFlags(32);
        r130.getAttributes().dimAmount = 0.0f;
    L151:
        if (r107.w() == false) goto L158;
        Dialog r144 = this.f40814e;
        j r145 = new j(this);
        if ((r144 instanceof SheetBaseDialog) == false) goto L155;
        SheetBaseDialog r146 = (SheetBaseDialog) r144;
    L156:
        if (r146 == null) goto L158;
        r146.f40500k = r145;
        goto L158
    L155:
        r146 = null;
        goto L156
    L143:
        if (r143.A() == 0) goto L145;
    L147:
        r103 = false;
        goto L148
    L145:
        if (r143.e() != 0) goto L147;
    L136:
        r142 = r107.A();
    L128:
        r141 = ColorProtector.parseColor("#00FFFFFF");     // Catch: Exception -> L131
    L131:
        e = move-exception;
        HybridLogger r147 = HybridLogger.f246343a;
        HybridLogger.i("AnnieXFlowPopupContainer", "maskBgColor: " + e.getMessage(), null, 12);
        goto L134
    L106:
        ab.a r148 = r();
        if (r148 == null) goto L120;
        y36.a r149 = r148.K;
        if (r149 == null) goto L111;
        boolean r150 = Intrinsics.areEqual(r149.f565862b, Boolean.TRUE);
    L112:
        if (r150 == true) goto L119;
        y36.a r151 = r148.L;
        if (r151 == null) goto L116;
        boolean r152 = Intrinsics.areEqual(r151.f565862b, Boolean.TRUE);
    L117:
        if (r152 == true) goto L119;
    L116:
        r152 = false;
    L119:
        boolean r153 = false;
    L121:
        if (r153 == false) goto L204;
        t();
        goto L204
    L111:
        r150 = false;
    L120:
        r153 = true;
    L101:
        th = move-exception;
        Result.Companion r154 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L104
    L88:
        if (com.bytedance.android.anniex.container.util.i.f40626a.getResources().getConfiguration().orientation != 2) goto L90;
        r135.windowAnimations = R.style.annie_x_popup_anim_horizontal;
        goto L202
    L90:
        y36.l r155 = r107.f2426z;
        if (r155 == null) goto L93;
        PopupType r156 = (PopupType) r155.f565862b;
    L95:
        if (r156 != PopupType.RIGHT) goto L97;
        r135.windowAnimations = R.style.annie_x_popup_anim_horizontal;
        goto L202
    L97:
        r135.windowAnimations = R.style.annie_x_popup_anim_vertical;
        goto L202
    L93:
        r156 = null;
        goto L95
    L85:
        r137 = false;
    L79:
        r134 = true;
        goto L80
    L68:
        com.bytedance.android.anniex.container.util.i r157 = com.bytedance.android.anniex.container.util.i.f40626a;
        float r158 = r157.a(r107.t());
        float r159 = r157.a(r107.u());
        float r160 = r157.a(r107.s());
        float r161 = r157.a(r107.r());
        View r162 = this.f40813d;
        if (r162 == null) goto L73;
        RadiusFrameLayout r163 = (RadiusFrameLayout) r162.findViewById(R.id.annie_x_container_view);
        if (r163 == null) goto L73;
        r163.a(r158, r159, r160, r161);
    L158:
        ab.a r164 = r();
        if (r164 != null) goto L161;
    L195:
        FrameLayout r165 = this.f40827r;
        if (r165 == null) goto L200;
        ViewGroup.LayoutParams r166 = r165.getLayoutParams();
        if (r166 == null) goto L200;
        r100 = Integer.valueOf(r166.height);
    L200:
        this.f40823n = r100;
        return;
    L161:
        if (r164.o() == false) goto L163;
    L164:
        y36.a r167 = r164.D;
        if (r167 == null) goto L169;
        Boolean r168 = (Boolean) r167.f565862b;
        if (r168 == null) goto L169;
        boolean r169 = r168.booleanValue();
    L170:
        if (r169 == true) goto L195;
        if (com.bytedance.android.anniex.container.util.h.a(this.f40810a) == true) goto L195;
        View r170 = r110.findViewById(R.id.annie_x_pull_down_close_indicator_container);
        y36.p r171 = r164.B;
        if (r171 == null) goto L177;
        String r172 = (String) r171.f565862b;
        if (r172 == null) goto L177;
    L178:
        this.f40824o = r110.findViewById(R.id.annie_x_pull_down_close_indicator);
        if (r170 == null) goto L183;
        r170.setVisibility(0);
    L183:
        if (Intrinsics.areEqual("white", r172) == false) goto L188;
        View r173 = this.f40824o;
        if (r173 == null) goto L195;
        r173.setBackgroundResource(R.drawable.annie_x_bg_pull_down_close_indicator_light);
        goto L195
    L188:
        if (Intrinsics.areEqual("dark", r172) == false) goto L192;
        View r174 = this.f40824o;
        if (r174 == null) goto L195;
        r174.setBackgroundResource(R.drawable.annie_x_bg_pull_down_close_indicator_dark);
        goto L195
    L192:
        View r175 = this.f40824o;
        if (r175 == null) goto L195;
        r175.setBackgroundResource(R.drawable.annie_x_bg_pull_down_close_indicator_light);
    L177:
        r172 = "";
    L169:
        r169 = false;
        goto L170
    L163:
        if (r164.w() == false) goto L195;
    L58:
        r130 = null;
    L48:
        r126 = false;
        goto L49
    L38:
        r123 = null;
        goto L39
    L30:
        r121 = null;
        goto L31
    L22:
        if (r118.w() != true) goto L24;
        r119 = true;
        goto L25
    L14:
        r117 = null;
        goto L15
    L5:
        r114 = null;
        goto L6
    }

    public final void A(Dialog r100, int r101, int r110, int r111) {
        if (r100 == null) goto L29;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L29;
        if (r() == null) goto L29;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.gravity = r111;
        if (r101 <= 0) goto L12;
        r103.width = com.bytedance.android.anniex.container.util.i.f40626a.a(r101);
    L12:
        ab.a r104 = r();
        if (r104 != null) goto L15;
    L115:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L27
        r102.setAttributes(r103);     // Catch: Throwable -> L27
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L15:
        if (r104.C() <= 0) goto L18;
        r103.x = r104.C();
    L18:
        if (r104.D() <= 0) goto L21;
        r103.y = r104.D();
    L21:
        if (r104.B() <= 0) goto L115;
        if (com.bytedance.android.anniex.container.util.i.f40626a.getResources().getConfiguration().orientation == 2) goto L115;
        float r107 = r104.B() / 100.0f;
        i16.c r108 = i16.c.f487996a;
        r103.width = (int) (i16.c.j(this.f40810a) * r107);
    L29:
        View r109 = this.f40813d;
        ViewGroup.LayoutParams r112 = null;
        if (r109 == null) goto L32;
        FrameLayout r113 = (FrameLayout) r109.findViewById(R.id.annie_x_dialog_container_view);
    L33:
        this.f40827r = r113;
        if (r113 == null) goto L36;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
    L37:
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r115 = (RelativeLayout.LayoutParams) r114;
        if (r101 <= 0) goto L40;
        r101 = com.bytedance.android.anniex.container.util.i.f40626a.a(r101);
    L40:
        r115.width = r101;
        if (r110 <= 0) goto L43;
        r110 = com.bytedance.android.anniex.container.util.i.f40626a.a(r110);
    L43:
        r115.height = r110;
        ab.a r116 = r();
        boolean r117 = true;
        if (r116 == null) goto L70;
        com.bytedance.android.anniex.container.util.i r118 = com.bytedance.android.anniex.container.util.i.f40626a;
        if (r118.getResources().getConfiguration().orientation == 2) goto L64;
        if (u() == false) goto L51;
        r115.height = com.bytedance.android.anniex.container.util.i.c(this.f40810a).heightPixels - i16.c.f487996a.h(this.f40810a);
        goto L64
    L51:
        if (r116.z() == true) goto L61;
        if (r116.f() <= 0) goto L64;
        y36.a r119 = r116.S;
        if (r119 == null) goto L57;
        boolean r120 = Intrinsics.areEqual(r119.f565862b, Boolean.TRUE);
    L58:
        if (r120 == true) goto L64;
        r115.height = (int) (r118.d() * RangesKt.coerceAtMost(r116.f() / 100.0f, 1.0f));
        goto L64
    L57:
        r120 = false;
        goto L58
    L61:
        if (r116.f() <= 0) goto L64;
        r115.height = (int) (com.bytedance.android.anniex.container.util.i.c(getContext()).heightPixels * RangesKt.coerceAtMost(r116.f() / 100.0f, 1.0f));
    L64:
        if (r116.l() <= 0) goto L67;
        r115.bottomMargin = r118.a(r116.l() * 1.0f);
    L67:
        if (r116.m() <= 0) goto L70;
        r115.rightMargin = r118.a(r116.m() * 1.0f);
    L70:
        if (r111 != 0) goto L72;
    L83:
        r115.addRule(13);
    L84:
        FrameLayout r121 = this.f40827r;
        if (r121 == null) goto L88;
        r121.setLayoutParams(r115);
    L88:
        int r122 = r115.height;
        if (com.bytedance.ies.bullet.service.base.h.x() == false) goto L111;
        ab.a r123 = r();
        if (r123 != null) goto L93;
    L95:
        boolean r124 = false;
    L96:
        if (r124 == false) goto L111;
        ab.a r125 = r();
        if (r125 != null) goto L100;
    L102:
        r117 = false;
    L103:
        if (r117 == false) goto L111;
        View r126 = this.f40813d;
        if (r126 == null) goto L107;
        View r127 = r126.findViewById(R.id.annie_x_container_view);
    L108:
        if (r127 == null) goto L110;
        r112 = r127.getLayoutParams();
    L110:
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r128 = (FrameLayout.LayoutParams) r112;
        r128.height = r122;
        r127.setLayoutParams(r128);
        goto L111
    L107:
        r127 = null;
        goto L108
    L100:
        if (r125.w() == true) goto L102;
    L93:
        if (r123.d() != 80) goto L95;
        r124 = true;
    L111:
        FrameLayout r129 = this.f40827r;
        if (r129 == null) goto L117;
        r129.requestLayout();
        return;
    L117:
        return;
    L72:
        if ((r111 & 17) == 17) goto L83;
        if ((r111 & 80) != 80) goto L78;
        r115.addRule(12);
        r115.addRule(11);
        goto L84
    L78:
        if ((r111 & 5) != 5) goto L81;
        r115.addRule(11);
        goto L84
    L81:
        if ((r111 & GravityCompat.END) != 8388613) goto L84;
        r115.addRule(21);
        goto L84
    L36:
        r114 = null;
        goto L37
    L32:
        r113 = null;
        goto L33
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final void onWebScrollChanged(int r100, int r101, int r102, int r103) {
        super.onWebScrollChanged(r100, r101, r102, r103);
        this.f40830u = r101;
        boolean r104 = true;
        if (r101 <= 0) goto L16;
        ab.a r105 = r();
        if (r105 != null) goto L7;
    L9:
        boolean r106 = false;
    L10:
        if (r106 == false) goto L16;
        if (this.f40826q != 3) goto L14;
    L15:
        f(true);
        return;
    L14:
        if (u() == true) goto L15;
        return;
    L7:
        if (r105.b() != true) goto L9;
        r106 = true;
    L16:
        if (r101 != 0) goto L28;
        ab.a r107 = r();
        if (r107 != null) goto L20;
    L22:
        r104 = false;
    L23:
        if (r104 == false) goto L29;
        f(false);
        return;
    L29:
        return;
    L20:
        if (r107.b() != true) goto L22;
    }
}
