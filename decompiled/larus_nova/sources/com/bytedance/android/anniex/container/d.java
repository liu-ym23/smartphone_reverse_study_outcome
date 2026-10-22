package com.bytedance.android.anniex.container;

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
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import com.bytedance.android.anniex.container.popup.SheetBaseDialog;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.container.view.RadiusFrameLayout;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;
import y36.p;
import y36.r;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends AnnieXContainer implements ia.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f40356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ia.f.a f40357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DialogFragment f40358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Dialog f40359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f40360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f40361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f40362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f40363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f40364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ab.a f40365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ab.b f40366k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.anniex.container.ui.h f40367l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f40368m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f40369n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f40370o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f40371p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f40372q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f40373r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f40374s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f40375t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f40376u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f40377v;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f40378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f40379b;

        public b(WebView r100, d r101) {
            this.f40378a = r100;
            this.f40379b = r101;
        }

        public final void a() {
            WebView r100 = this.f40378a;
            if (r100 == null) goto L7;
            boolean r101 = true;
            if (r100.canGoBack() != true) goto L7;
        L8:
            com.bytedance.android.anniex.container.ui.h r102 = null;
            if (r101 == false) goto L15;
            com.bytedance.android.anniex.container.ui.h r103 = this.f40379b.f40367l;
            if (r103 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        L14:
            r102.f(this.f40379b.f40366k, 0);
            return;
        L13:
            r102 = r103;
            goto L14
        L15:
            com.bytedance.android.anniex.container.ui.h r104 = this.f40379b.f40367l;
            if (r104 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        L19:
            r102.f(this.f40379b.f40366k, 8);
            return;
        L18:
            r102 = r104;
        L7:
            r101 = false;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.bytedance.ies.bullet.core.kit.bridge.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f40380a;

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final String getName() {
            return "H5_halfFullStatusChange";
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final Object getParams() {
            return this.f40380a;
        }

        public c(JSONObject r100) {
            this.f40380a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b, ia.c
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
        Dialog r100 = this.f40359d;
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
        return this.f40368m;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ia.e
    public final void onStart() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        y();     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void r() {
        Dialog r100 = this.f40359d;
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.clearFlags(2);
    L7:
        Dialog r102 = this.f40359d;
        if (r102 == null) goto L13;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L14;
        r103.setDimAmount(0.0f);
        return;
    L14:
        return;
    }

    public final boolean s() {
        ab.a r100 = this.f40365j;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L15;
        ab.a r102 = this.f40365j;
        if (r102 != null) goto L12;
    L14:
        return false;
    L12:
        if (r102.y() != true) goto L14;
        return true;
    L15:
        ab.a r103 = this.f40365j;
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

    public final boolean t() {
        return com.bytedance.android.anniex.container.util.h.a(this.f40356a);
    }

    public final boolean w() {
        ab.a r100 = this.f40365j;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.n() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void x() {
        ab.a r100 = this.f40365j;
        if (r100 == null) goto L15;
        Dialog r101 = this.f40359d;
        if (r101 == null) goto L9;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.addFlags(2);
    L9:
        Dialog r103 = this.f40359d;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        Dialog r100 = this.f40359d;
        if (r100 != null) goto L5;
        return;
    L5:
        Window r101 = r100.getWindow();
        Boolean r102 = this.f40373r;
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L28;
        if (r101 == null) goto L28;
        ab.a r104 = this.f40365j;
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
        if (this.f40373r != null) goto L31;
        this.f40373r = r103;
        return;
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b
    public final void observerKeyboardStatusChange() {
        super.observerKeyboardStatusChange();
        Dialog r100 = this.f40359d;
        if (r100 == null) goto L6;
        SoftInputKt.d(r100, getOnSoftInputChangeListener$anniex_release());
        return;
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

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void parseSchema() {
        t36.d r100 = getBulletContext().f246437e;
        if (r100 == null) goto L9;
        Lazy<SchemaService> r101 = SchemaService.f248116f;
        SchemaService.a.a().getClass();
        ab.a r102 = (ab.a) SchemaService.d(r100, ab.a.class);
        this.f40365j = r102;
        if (r102 == null) goto L8;
        r102.f2401b = getContext();
    L8:
        SchemaService.a.a().getClass();
        this.f40366k = (ab.b) SchemaService.d(r100, ab.b.class);
    L9:
        BulletContext r103 = getBulletContext();
        Scenes r104 = Scenes.PopupFragment;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f246441i = r104;
        BulletContext r105 = getBulletContext();
        Components r106 = Components.DialogFragment;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f246442j = r106;
        getBulletContext().I = true;
        super.parseSchema();
    }

    public d(com.bytedance.android.anniex.base.builder.c r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        super(r100);
        this.f40356a = r100.e();
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        this.f40360e = -16777216;
        this.f40362g = true;
        this.f40363h = true;
        this.f40364i = true;
        this.f40371p = -1;
        this.f40375t = 1024;
        this.f40376u = 2048;
        this.f40377v = -1;
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
        setRootView(r210);
        if (r210 == null) goto L5;
        FrameLayout r100 = (FrameLayout) r210.findViewById(R.id.annie_x_container_view);
    L6:
        if (r100 != null) goto L8;
        r100 = new FrameLayout(this.f40356a);
    L8:
        setParentViewGroup(r100);
        Window r101 = this.f40356a.getWindow();
        this.f40375t = q(r101).getSystemUiVisibility();
        this.f40376u = r101.getAttributes().flags;
        this.f40377v = r101.getStatusBarColor();
        FragmentActivity r102 = this.f40356a;
        View r103 = getRootView();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f40367l = new com.bytedance.android.anniex.container.ui.h(r102, this, (ViewGroup) r103);
        initUi();
        ab.b r104 = this.f40366k;
        if (r104 == null) goto L35;
        Map<String, Map<Class<?>, Object>> r105 = x26.a.f562251a;
        w26.g r106 = (w26.g) x26.a.a(w26.g.class);
        if (r106 == null) goto L17;
        w26.e r107 = (w26.e) r106.n0(w26.e.class);
        if (r107 == null) goto L17;
        Boolean r108 = r107.A();
        if (r108 == null) goto L17;
        boolean r109 = r108.booleanValue();
    L19:
        if (r109 == true) goto L24;
        com.bytedance.android.anniex.container.ui.h r110 = this.f40367l;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r110 = null;
    L23:
        r110.d(r104);
    L24:
        com.bytedance.android.anniex.container.ui.h r111 = this.f40367l;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r111 = null;
    L27:
        Dialog r112 = this.f40359d;
        if (r112 == null) goto L30;
        Window r113 = r112.getWindow();
    L31:
        r111.c(r113, r104);
        com.bytedance.android.anniex.container.ui.h r114 = this.f40367l;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r114 = null;
    L34:
        r114.b(r104, getBid());
        goto L35
    L30:
        r113 = null;
    L17:
        r109 = true;
    L35:
        ab.a r115 = this.f40365j;
        if (r115 == null) goto L45;
        y36.a r116 = r115.f2411k;
        if (r116 == null) goto L42;
        Boolean r117 = (Boolean) r116.f565862b;
        if (r117 == null) goto L42;
        boolean r118 = r117.booleanValue();
    L43:
        if (r118 != true) goto L45;
        boolean r119 = true;
    L46:
        if (r119 == false) goto L50;
        View r120 = getRootView();
        if (r120 == null) goto L53;
        View r121 = (ImageView) r120.findViewById(R.id.annie_x_activity_close);
    L54:
        this.f40370o = r121;
        ab.a r122 = this.f40365j;
        if (r122 != null) goto L57;
    L59:
        boolean r123 = false;
    L60:
        if (r123 == false) goto L75;
        ab.b r124 = this.f40366k;
        if (r124 == null) goto L69;
        y36.a r125 = r124.f2433g;
        if (r125 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("showClosealways");
        r125 = null;
    L67:
        if (r125 == null) goto L69;
        boolean r126 = Intrinsics.areEqual(r125.f565862b, Boolean.TRUE);
    L70:
        if (r126 == true) goto L75;
        View r127 = this.f40370o;
        if (r127 == null) goto L75;
        r127.setAlpha(0.0f);
    L69:
        r126 = false;
    L75:
        ab.b r128 = this.f40366k;
        if (r128 == null) goto L92;
        y36.a r129 = r128.b();
        if (r129 == null) goto L92;
        Boolean r130 = (Boolean) r129.f565862b;
        if (r130 == null) goto L92;
        if (r130.booleanValue() == true) goto L85;
        r130 = null;
    L85:
        if (r130 == null) goto L92;
        r130.booleanValue();
        View r131 = this.f40370o;
        if (r131 == null) goto L90;
        r131.setVisibility(0);
    L90:
        if (r131 == null) goto L92;
        r131.setOnClickListener(new k(this));
    L92:
        ab.a r132 = this.f40365j;
        if (r132 != null) goto L95;
    L100:
        boolean r133 = true;
    L101:
        if (r133 == true) goto L110;
        ab.a r134 = this.f40365j;
        if (r134 != null) goto L105;
    L107:
        boolean r135 = false;
    L108:
        if (r135 == false) goto L110;
        v(true);
    L113:
        ab.a r136 = this.f40365j;
        if (r136 == null) goto L116;
        r136.e();
    L116:
        Resources r137 = getContext().getResources();
        int r138 = WindowDisplayMetricsOverride.apply(r137, r137.getDisplayMetrics()).widthPixels;
        com.bytedance.android.anniex.container.util.i r139 = com.bytedance.android.anniex.container.util.i.f40626a;
        int r140 = com.bytedance.android.anniex.container.util.i.c(this.f40356a).heightPixels;
        int r141 = r140 - getRealNavigationBarHeight();
        boolean r142 = t();
        if (r142 == true) goto L120;
        r140 = r141;
    L120:
        HybridLogger r143 = HybridLogger.f246343a;
        HybridLogger.m("AnnieXPopupContainer", "screenHeight: " + r140 + "; screenWidth: " + r138, null, null, 12);
        ab.a r144 = this.f40365j;
        if (r144 != null) goto L123;
    L154:
        Window r145 = this.f40356a.getWindow();
        if (r145 == null) goto L157;
        this.f40360e = r145.getStatusBarColor();
    L157:
        ab.a r146 = this.f40365j;
        if (r146 == null) goto L282;
        int r147 = r146.A();
        com.bytedance.android.anniex.container.util.i r148 = com.bytedance.android.anniex.container.util.i.f40626a;
        r146.G(RangesKt.coerceAtMost(r147, (int) r148.e(r138)));
        if (r146.v() <= 0) goto L163;
        if (r142 == true) goto L163;
        r146.E((int) r148.e((int) (((double) (r146.v() * r138)) / 375.0d)));
        HybridLogger.m("AnnieXPopupContainer", "rateHeight: " + r146.v() + "; screenWidth: " + r138 + " ; this.height1: " + r146.e(), null, null, 12);
    L163:
        if (r142 == true) goto L165;
    L167:
        if (r142 == false) goto L174;
        y36.a r149 = r146.f2418r;
        if (r149 == null) goto L171;
        boolean r150 = Intrinsics.areEqual(r149.f565862b, Boolean.TRUE);
    L172:
        if (r150 == false) goto L174;
    L179:
        if ((r146.e() + r146.l()) < ((int) r148.e(r140))) goto L182;
        r146.E(r146.e() - r146.l());
    L182:
        if (r146.f() <= 0) goto L185;
        if (r142 == true) goto L185;
        r146.E((int) r148.e((int) (r140 * (r146.f() / 100.0f))));
    L185:
        if (r142 == true) goto L190;
        if (r146.e() <= r140) goto L190;
        r146.E((int) r148.e(r140));
    L190:
        if (s() == false) goto L193;
        r146.E((int) r148.e(com.bytedance.android.anniex.container.util.i.c(this.f40356a).heightPixels - getRealNavigationBarHeight()));
    L193:
        if (r146.B() <= 0) goto L196;
        if (r142 == true) goto L196;
        r146.G((int) r148.e((int) (r138 * (r146.B() / 100.0f))));
    L196:
        y36.a r151 = r146.f2419s;
        if (r151 == null) goto L199;
        boolean r152 = Intrinsics.areEqual(r151.f565862b, Boolean.TRUE);
    L200:
        if (r152 == false) goto L204;
        if (r142 == false) goto L204;
        r146.G((int) r148.e(r146.k() + r140));
    L204:
        if (r146.e() > 0) goto L207;
        r146.E(450);
    L207:
        if (r146.A() > 0) goto L209;
        r146.G(300);
    L209:
        y36.a r153 = r146.R;
        if (r153 == null) goto L212;
        boolean r154 = Intrinsics.areEqual(r153.f565862b, Boolean.TRUE);
    L213:
        if (r154 == false) goto L216;
        r146.E(r146.e() + 48);
    L216:
        if (r146.w() == false) goto L238;
        int r155 = getRealNavigationBarHeight();
        if (r146.z() == false) goto L220;
        int r156 = com.bytedance.android.anniex.container.util.i.c(this.f40356a).heightPixels - r155;
    L221:
        r146.E(((int) r148.e(r156)) + 2);
        if (r146.x() <= 0) goto L231;
        float r157 = 1 - RangesKt.coerceAtMost(r146.x() / 100.0f, 1.0f);
        if (r146.z() == false) goto L226;
        r156 = r156 + r155;
    L226:
        float r158 = r156 * r157;
        if (r146.z() == false) goto L229;
        int r159 = r155 + 2;
    L230:
        r146.O = new y36.d(Integer.valueOf((int) r148.e((int) (r158 - r159))));
        goto L231
    L229:
        r159 = 0;
    L231:
        r r160 = r146.P;
        if (r160 == null) goto L236;
        Integer r161 = (Integer) r160.f565862b;
        if (r161 == null) goto L236;
        int r162 = r161.intValue();
    L237:
        this.f40361f = r162;
    L236:
        r162 = 1580077;
        goto L237
    L220:
        r156 = r148.d();
    L238:
        y36.a r163 = r146.S;
        if (r163 == null) goto L241;
        boolean r164 = Intrinsics.areEqual(r163.f565862b, Boolean.TRUE);
    L242:
        if (r164 == false) goto L252;
        if (t() == true) goto L252;
        ia.f.a r165 = this.f40357b;
        if (r165 != null) goto L248;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r165 = null;
    L248:
        Integer r166 = r165.f(MapsKt.emptyMap());
        if (r166 == null) goto L252;
        r146.E((int) (((double) r148.e(r166.intValue())) + 0.5d));
        r146.F = new y36.d(0);
        r146.G = new y36.d(0);
    L252:
        if (r146.q() >= 0) goto L255;
        r146.F(0);
    L255:
        if (r146.t() >= 0) goto L258;
        r146.F = new y36.d(0);
    L258:
        if (r146.u() >= 0) goto L261;
        r146.G = new y36.d(0);
    L261:
        if (r146.s() >= 0) goto L264;
        r146.I = new y36.d(0);
    L264:
        if (r146.r() >= 0) goto L266;
        r146.H = new y36.d(0);
    L266:
        if (r142 == false) goto L282;
        float r167 = RangesKt.coerceAtMost(r146.h(), 100) / 100.0f;
        float r168 = 0;
        if (r167 <= r168) goto L270;
        r146.E((int) r148.e((int) (r140 * r167)));
    L270:
        y36.j r169 = r146.f2416p;
        if (r169 == null) goto L275;
        Integer r170 = (Integer) r169.f565862b;
        if (r170 == null) goto L275;
        int r171 = r170.intValue();
    L276:
        float r172 = RangesKt.coerceAtMost(r171, 100) / 100.0f;
        if (r172 <= r168) goto L280;
        r146.G((int) r148.e((int) (r138 * r172)));
    L280:
        if (r146.i() <= 0) goto L282;
        r146.F(r146.i());
    L275:
        r171 = 0;
        goto L276
    L241:
        r164 = false;
        goto L242
    L212:
        r154 = false;
        goto L213
    L199:
        r152 = false;
        goto L200
    L171:
        r150 = false;
    L174:
        if (r146.d() != 80) goto L179;
        int r173 = (int) (r140 * 0.85f);
        if (r146.e() <= r148.e(r173)) goto L179;
        r146.E((int) r148.e(r173));
        HybridLogger.m("AnnieXPopupContainer", "screenHeight: " + r140 + "; screenWidth: " + r138 + " ; this.height2: " + r146.e(), null, null, 12);
        goto L179
    L165:
        if (r146.e() <= r140) goto L167;
        r146.E((int) r148.e(r140 - (r146.k() * 2)));
    L282:
        ab.a r174 = this.f40365j;
        if (r174 == null) goto L298;
        Dialog r175 = this.f40359d;
        if ((r175 instanceof SheetBaseDialog) == false) goto L287;
        SheetBaseDialog r176 = (SheetBaseDialog) r175;
    L288:
        if (r176 == null) goto L298;
        boolean r177 = r174.w();
        int r178 = r174.e();
        y36.d r179 = r174.O;
        if (r179 == null) goto L294;
        Integer r180 = (Integer) r179.f565862b;
        if (r180 == null) goto L294;
        int r181 = r180.intValue();
    L295:
        r176.f40505p = r177;
        if (r181 <= 0) goto L298;
        r176.f40506q = i16.c.f(r178 - r181, r176.getContext());
    L294:
        r181 = 0;
        goto L295
    L287:
        r176 = null;
    L298:
        Dialog r182 = this.f40359d;
        if (r182 == null) goto L303;
        Window r183 = r182.getWindow();
        if (r183 == null) goto L303;
        r183.addFlags(Integer.MIN_VALUE);
        r183.setStatusBarColor(0);
        r183.setNavigationBarColor(0);
    L303:
        HybridLogger.m("AnnieXPopupContainer", "===onCreateView: " + getUrl(), null, null, 12);
        return;
    L123:
        if (t() == false) goto L151;
        y36.a r184 = r144.f2418r;
        if (r184 == null) goto L127;
        boolean r185 = Intrinsics.areEqual(r184.f565862b, Boolean.TRUE);
    L128:
        if (r185 == true) goto L130;
        r144.F(8);
        r144.E((int) com.bytedance.android.anniex.container.util.i.f40626a.e(r140 - (r144.k() * 2)));
        r144.G(300);
    L130:
        y36.a r186 = r144.f2417q;
        if (r186 == null) goto L133;
        boolean r187 = Intrinsics.areEqual(r186.f565862b, Boolean.FALSE);
    L134:
        if (r187 == false) goto L137;
        r144.f2408h = Integer.valueOf(GravityCompat.END);
    L140:
        if (r144.j() <= 0) goto L143;
        r144.G(r144.j());
    L143:
        if (r144.g() <= 0) goto L146;
        r144.E(r144.g());
    L146:
        if (r144.h() <= 0) goto L148;
        r144.E((int) com.bytedance.android.anniex.container.util.i.f40626a.e((com.bytedance.android.anniex.container.util.i.c(this.f40356a).heightPixels * r144.h()) / 100));
    L148:
        r144.M = new y36.a(Boolean.FALSE);
        i16.c r188 = i16.c.f487996a;
        if (i16.c.d(getContext()) == false) goto L154;
        r144.W = new y36.d(Integer.valueOf(getRealNavigationBarHeight()));
        goto L154
    L137:
        if (r144.d() != 80) goto L140;
        r144.f2408h = Integer.valueOf(VideoPlayDataContext.PLAYING_GRAVITY);
        goto L140
    L133:
        r187 = false;
        goto L134
    L127:
        r185 = false;
        goto L128
    L151:
        i16.c r189 = i16.c.f487996a;
        if (i16.c.d(getContext()) == false) goto L154;
        r144.X = new y36.d(Integer.valueOf(getRealNavigationBarHeight()));
        goto L154
    L105:
        if (r134.c() != true) goto L107;
        r135 = true;
    L110:
        Dialog r190 = this.f40359d;
        if (r190 == null) goto L113;
        r190.hide();
        goto L113
    L95:
        if (r132.A() == 0) goto L97;
    L99:
        r133 = false;
        goto L101
    L97:
        if (r132.e() != 0) goto L99;
    L57:
        if (r122.w() != true) goto L59;
        r123 = true;
    L53:
        r121 = null;
        goto L54
    L50:
        View r191 = getRootView();
        if (r191 == null) goto L53;
        r121 = r191.findViewById(R.id.annie_x_activity_close_left);
    L42:
        r118 = true;
    L45:
        r119 = false;
        goto L46
    L5:
        r100 = null;
        goto L6
    }

    @Override // ia.g
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "statusBarBgColor");
        com.bytedance.android.anniex.container.ui.h r101 = this.f40367l;
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
        this.f40357b = r100;
        super.setUiComponent(r100);
    }

    @Override // ia.h
    public final boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "titleBarBgColor");
        com.bytedance.android.anniex.container.ui.h r101 = this.f40367l;
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
        com.bytedance.android.anniex.container.ui.h r102 = this.f40367l;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
    L8:
        r101.l();
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        com.bytedance.android.anniex.container.ui.h r103 = this.f40367l;
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
        ab.a r100 = this.f40365j;
        if (r100 == null) goto L7;
        y36.a r101 = r100.f2403c;
        if (r101 == null) goto L7;
        boolean r102 = Intrinsics.areEqual(r101.f565862b, Boolean.TRUE);
    L8:
        boolean r103 = true;
        if (r102 == false) goto L19;
        ia.f.a r104 = this.f40357b;
        Dialog r105 = null;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r104 = null;
    L13:
        Dialog r111 = r104.g(r110);
        if (r111 == null) goto L33;
        Window r106 = r111.getWindow();
        if (r106 == null) goto L18;
        r106.setBackgroundDrawable(new ColorDrawable(0));
        r106.addFlags(256);
    L18:
        r105 = r111;
    L33:
        this.f40359d = r105;
        ab.a r112 = this.f40365j;
        if (r112 == null) goto L36;
        r103 = r112.c();
    L36:
        v(r103);
        Dialog r113 = this.f40359d;
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.app.Dialog");
        return r113;
    L19:
        Context r107 = getContext();
        boolean r108 = t();
        boolean r114 = t();
        if (s() == false) goto L23;
        if (r114 == true) goto L23;
        boolean r109 = true;
    L24:
        Window r115 = this.f40356a.getWindow();
        if (r115 == null) goto L29;
        View r116 = q(r115);
        if (r116 == null) goto L29;
        int r117 = r116.getWidth();
    L30:
        r105 = new SheetBaseDialog(r107, r108, false, r109, false, r117);
        Window r118 = r105.getWindow();
        if (r118 == null) goto L33;
        r118.setBackgroundDrawable(new ColorDrawable(0));
        r118.addFlags(256);
    L29:
        r117 = 0;
    L23:
        r109 = r114;
    L7:
        r102 = false;
        goto L8
    }

    @Override // ia.f
    public final void m(boolean r100) {
        this.f40362g = r100;
    }

    @Override // ia.f
    public final void o(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        this.f40358c = r100;
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.e
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.m("AnnieXPopupContainer", "===onConfigurationChanged: " + getUrl(), null, null, 12);
        ab.a r102 = this.f40365j;
        if (r102 == null) goto L6;
        z(this.f40359d, r102.A(), r102.e(), r102.d());
        return;
    }

    @Override // ia.b, ia.c
    public final void onCreate(Bundle r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        DialogFragment r102 = null;
        HybridLogger.m("AnnieXPopupContainer", "===onCreate: " + getUrl(), null, null, 12);
        setContainerVisible(true);
        if (t() == false) goto L9;
        DialogFragment r103 = this.f40358c;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L8:
        r102.setStyle(1, R.style.annie_x_no_floating_dialog);
        return;
    L7:
        r102 = r103;
        goto L8
    L9:
        DialogFragment r104 = this.f40358c;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L13:
        r102.setStyle(1, R.style.annie_x_floating_dialog);
        return;
    L12:
        r102 = r104;
        goto L13
    }

    @Override // ia.f
    public final void onDismiss(DialogInterface r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        y36.a r102 = null;
        HybridLogger.m("AnnieXPopupContainer", "===onDismiss: " + getUrl(), null, null, 12);
        ab.b r103 = this.f40366k;
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
        ab.b r107 = this.f40366k;
        if (r107 == null) goto L17;
        y36.a r108 = r107.c();
        if (r108 == null) goto L17;
        r104 = Intrinsics.areEqual(r108.f565862b, Boolean.TRUE);
    L17:
        if (r104 == true) goto L18;
    L19:
        Window r109 = this.f40356a.getWindow();
        if (r109 == null) goto L25;
        int r110 = r109.getStatusBarColor();
        int r111 = this.f40360e;
        if (r110 == r111) goto L26;
        r109.setStatusBarColor(r111);
        return;
    L26:
        return;
    L25:
        return;
    L18:
        Window r112 = this.f40356a.getWindow();
        r112.clearFlags(Integer.MIN_VALUE);
        q(r112).setSystemUiVisibility(this.f40375t);
        r112.addFlags(this.f40376u);
        r112.setStatusBarColor(this.f40377v);
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
        HybridLogger.m("AnnieXPopupContainer", "===onShow: " + getUrl(), null, null, 12);
        if (t() == false) goto L10;
        Dialog r102 = this.f40359d;
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
        com.bytedance.android.anniex.container.ui.h r101 = this.f40367l;
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
        com.bytedance.android.anniex.container.ui.h r101 = this.f40367l;
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
        com.bytedance.android.anniex.container.ui.h r101 = this.f40367l;
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

    public final void u(int r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L4
        r101.put("status", r100);     // Catch: JSONException -> L4
        sendEvent(new c(r101));     // Catch: JSONException -> L4
        return;
    }

    public final void v(boolean r100) {
        DialogFragment r101 = this.f40358c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r101 = null;
    L5:
        r101.setCancelable(r100);
        Dialog r102 = this.f40359d;
        if (r102 == null) goto L9;
        r102.setCanceledOnTouchOutside(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.e
    public final void b(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        HybridLogger r100 = HybridLogger.f246343a;
        Integer r101 = null;
        HybridLogger.m("AnnieXPopupContainer", "===onViewCreated: " + getUrl(), null, null, 12);
        Dialog r102 = this.f40359d;
        if ((r102 instanceof SheetBaseDialog) == false) goto L5;
        SheetBaseDialog r103 = (SheetBaseDialog) r102;
    L6:
        if (r103 == null) goto L8;
        r103.f40504o = new e(this);
    L8:
        View r104 = getRootView();
        if (r104 == null) goto L11;
        r104.setOnClickListener(new f(this));
    L11:
        Dialog r105 = this.f40359d;
        if ((r105 instanceof SheetBaseDialog) == false) goto L14;
        SheetBaseDialog r106 = (SheetBaseDialog) r105;
    L15:
        if (r106 == null) goto L19;
        g r107 = new g(this);
        Intrinsics.checkNotNullParameter(r107, "bottomSheetPullUpProcessor");
        r106.f40503n = new com.bytedance.android.anniex.container.popup.a(r107, r106);
        SheetBaseBehavior<?> r108 = r106.f40495f;
        if (r108 == null) goto L19;
        Intrinsics.checkNotNull(r108);
        r108.f40489e = r106.f40503n;
    L19:
        ab.a r109 = this.f40365j;
        if (r109 != null) goto L22;
    L24:
        boolean r112 = false;
    L25:
        if (r112 == false) goto L27;
        u(1);
    L27:
        Dialog r113 = this.f40359d;
        if ((r113 instanceof SheetBaseDialog) == false) goto L30;
        SheetBaseDialog r114 = (SheetBaseDialog) r113;
    L31:
        if (r114 == null) goto L35;
        h r115 = new h(this);
        Intrinsics.checkNotNullParameter(r115, "bottomSheetSlideProcessor");
        r114.f40502m = new com.bytedance.android.anniex.container.popup.b(r115, r114);
        SheetBaseBehavior<?> r116 = r114.f40495f;
        if (r116 == null) goto L35;
        Intrinsics.checkNotNull(r116);
        r116.f40488d = r114.f40502m;
    L35:
        Dialog r117 = this.f40359d;
        if ((r117 instanceof SheetBaseDialog) == false) goto L38;
        SheetBaseDialog r118 = (SheetBaseDialog) r117;
    L39:
        if (r118 == null) goto L43;
        i r119 = new i(this);
        if (r118.f40501l.contains(r119) == true) goto L43;
        r118.f40501l.add(r119);
    L43:
        ab.a r120 = this.f40365j;
        if (r120 == null) goto L48;
        y36.a r121 = r120.R;
        if (r121 == null) goto L48;
        boolean r122 = Intrinsics.areEqual(r121.f565862b, Boolean.TRUE);
    L49:
        if (r122 == false) goto L55;
        View r123 = getRootView();
        if (r123 == null) goto L55;
        ImageView r124 = (ImageView) r123.findViewById(R.id.annie_x_dialog_btn_close);
        if (r124 == null) goto L55;
        r124.setVisibility(0);
        r124.setOnClickListener(new j(this));
    L55:
        Dialog r125 = this.f40359d;
        if (r125 == null) goto L58;
        Window r126 = r125.getWindow();
    L59:
        ab.a r127 = this.f40365j;
        if (r127 == null) goto L159;
        z(this.f40359d, r127.A(), r127.e(), r127.d());
        int r128 = r127.q();
        int r129 = r127.t();
        int r130 = r127.u();
        int r131 = r127.s();
        int r132 = r127.r();
        if (r128 <= 0) goto L68;
        float r133 = com.bytedance.android.anniex.container.util.i.f40626a.a(r128);
        HybridLogger.f("PopupLog", "setRadius: 窗口圆角 = " + r133 + GXTemplateKey.GAIAX_PX, null, 12);
        View r134 = getRootView();
        if (r134 == null) goto L73;
        RadiusFrameLayout r135 = (RadiusFrameLayout) r134.findViewById(R.id.annie_x_container_view);
        if (r135 == null) goto L73;
        r135.setRadius(r133);
    L73:
        if (r126 == null) goto L159;
        y36.a r136 = r127.Y;
        if (r136 == null) goto L79;
        Boolean r137 = (Boolean) r136.f565862b;
        if (r137 == null) goto L79;
        boolean r138 = r137.booleanValue();
    L80:
        if (r138 == true) goto L82;
        r126.setSoftInputMode(48);
    L82:
        WindowManager.LayoutParams r139 = r126.getAttributes();
        r139.width = -1;
        r139.height = -1;
        y36.a r140 = r127.f2425y;
        if (r140 == null) goto L85;
        boolean r141 = Intrinsics.areEqual(r140.f565862b, Boolean.TRUE);
    L86:
        if (r141 == true) goto L88;
        r139.windowAnimations = R.style.annie_x_popup_no_anim;
    L203:
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L101
        r126.setAttributes(r139);     // Catch: Throwable -> L101
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L104:
        if (w() == false) goto L106;
        x();
    L205:
        r r143 = r127.f2424x;     // Catch: Exception -> L131
        if (r143 == null) goto L128;
        Integer r144 = (Integer) r143.f565862b;     // Catch: Exception -> L131
        if (r144 == null) goto L128;
        int r145 = r144.intValue();     // Catch: Exception -> L131
    L129:
        r126.setBackgroundDrawable(new ColorDrawable(r145));     // Catch: Exception -> L131
    L134:
        if (r127.A() <= 0) goto L136;
        int r146 = com.bytedance.android.anniex.container.util.i.f40626a.a(r127.A() + r127.m());
    L137:
        r126.setLayout(r146, -1);
        if (s() == true) goto L140;
        r126.setFlags(1024, 1024);
    L140:
        ab.a r147 = this.f40365j;
        if (r147 != null) goto L143;
    L148:
        boolean r148 = true;
    L149:
        if (r148 == false) goto L152;
        r126.addFlags(32);
        r126.getAttributes().dimAmount = 0.0f;
    L152:
        if (r127.w() == false) goto L159;
        Dialog r149 = this.f40359d;
        m r150 = new m(this);
        if ((r149 instanceof SheetBaseDialog) == false) goto L156;
        SheetBaseDialog r151 = (SheetBaseDialog) r149;
    L157:
        if (r151 == null) goto L159;
        r151.f40500k = r150;
        goto L159
    L156:
        r151 = null;
        goto L157
    L143:
        if (r147.A() == 0) goto L145;
    L147:
        r148 = false;
        goto L149
    L145:
        if (r147.e() != 0) goto L147;
    L136:
        r146 = r127.A();
    L128:
        r145 = ColorProtector.parseColor("#00FFFFFF");     // Catch: Exception -> L131
    L131:
        e = move-exception;
        HybridLogger r152 = HybridLogger.f246343a;
        HybridLogger.i("AnnieXPopupContainer", "maskBgColor: " + e.getMessage(), null, 12);
        goto L134
    L106:
        ab.a r153 = this.f40365j;
        if (r153 == null) goto L120;
        y36.a r154 = r153.K;
        if (r154 == null) goto L111;
        boolean r155 = Intrinsics.areEqual(r154.f565862b, Boolean.TRUE);
    L112:
        if (r155 == true) goto L119;
        y36.a r156 = r153.L;
        if (r156 == null) goto L116;
        boolean r157 = Intrinsics.areEqual(r156.f565862b, Boolean.TRUE);
    L117:
        if (r157 == true) goto L119;
    L116:
        r157 = false;
    L119:
        boolean r158 = false;
    L121:
        if (r158 == false) goto L205;
        r();
        goto L205
    L111:
        r155 = false;
    L120:
        r158 = true;
    L101:
        th = move-exception;
        Result.Companion r159 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L104
    L88:
        if (com.bytedance.android.anniex.container.util.i.f40626a.getResources().getConfiguration().orientation != 2) goto L90;
        r139.windowAnimations = R.style.annie_x_popup_anim_horizontal;
        goto L203
    L90:
        y36.l r160 = r127.f2426z;
        if (r160 == null) goto L93;
        PopupType r161 = (PopupType) r160.f565862b;
    L95:
        if (r161 != PopupType.RIGHT) goto L97;
        r139.windowAnimations = R.style.annie_x_popup_anim_horizontal;
        goto L203
    L97:
        r139.windowAnimations = R.style.annie_x_popup_anim_vertical;
        goto L203
    L93:
        r161 = null;
        goto L95
    L85:
        r141 = false;
    L79:
        r138 = true;
        goto L80
    L68:
        com.bytedance.android.anniex.container.util.i r162 = com.bytedance.android.anniex.container.util.i.f40626a;
        float r163 = r162.a(r129);
        float r164 = r162.a(r130);
        float r165 = r162.a(r131);
        float r166 = r162.a(r132);
        HybridLogger.f("PopupLog", "setRadius: 窗口圆角 = (" + r163 + "px, " + r164 + "px, " + r165 + "px, " + r166 + "px)", null, 12);
        View r167 = getRootView();
        if (r167 == null) goto L73;
        RadiusFrameLayout r168 = (RadiusFrameLayout) r167.findViewById(R.id.annie_x_container_view);
        if (r168 == null) goto L73;
        r168.a(r163, r164, r165, r166);
    L159:
        ab.a r169 = this.f40365j;
        if (r169 != null) goto L162;
    L196:
        FrameLayout r170 = this.f40372q;
        if (r170 == null) goto L201;
        ViewGroup.LayoutParams r171 = r170.getLayoutParams();
        if (r171 == null) goto L201;
        r101 = Integer.valueOf(r171.height);
    L201:
        this.f40368m = r101;
        return;
    L162:
        if (r169.o() == false) goto L164;
    L165:
        y36.a r172 = r169.D;
        if (r172 == null) goto L170;
        Boolean r173 = (Boolean) r172.f565862b;
        if (r173 == null) goto L170;
        boolean r174 = r173.booleanValue();
    L171:
        if (r174 == true) goto L196;
        if (com.bytedance.android.anniex.container.util.h.a(this.f40356a) == true) goto L196;
        View r175 = r110.findViewById(R.id.annie_x_pull_down_close_indicator_container);
        p r176 = r169.B;
        if (r176 == null) goto L178;
        String r177 = (String) r176.f565862b;
        if (r177 == null) goto L178;
    L179:
        this.f40369n = r110.findViewById(R.id.annie_x_pull_down_close_indicator);
        if (r175 == null) goto L184;
        r175.setVisibility(0);
    L184:
        if (Intrinsics.areEqual("white", r177) == false) goto L189;
        View r178 = this.f40369n;
        if (r178 == null) goto L196;
        r178.setBackgroundResource(R.drawable.annie_x_bg_pull_down_close_indicator_light);
        goto L196
    L189:
        if (Intrinsics.areEqual("dark", r177) == false) goto L193;
        View r179 = this.f40369n;
        if (r179 == null) goto L196;
        r179.setBackgroundResource(R.drawable.annie_x_bg_pull_down_close_indicator_dark);
        goto L196
    L193:
        View r180 = this.f40369n;
        if (r180 == null) goto L196;
        r180.setBackgroundResource(R.drawable.annie_x_bg_pull_down_close_indicator_light);
    L178:
        r177 = "";
    L170:
        r174 = false;
        goto L171
    L164:
        if (r169.w() == false) goto L196;
    L58:
        r126 = null;
    L48:
        r122 = false;
        goto L49
    L38:
        r118 = null;
        goto L39
    L30:
        r114 = null;
        goto L31
    L22:
        if (r109.w() != true) goto L24;
        r112 = true;
        goto L25
    L14:
        r106 = null;
        goto L15
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void onWebPageFinish(WebView r100, String r101) {
        super.onWebPageFinish(r100, r101);
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;
        w26.g r103 = (w26.g) x26.a.a(w26.g.class);
        if (r103 == null) goto L9;
        w26.e r104 = (w26.e) r103.n0(w26.e.class);
        if (r104 == null) goto L9;
        Boolean r105 = r104.C();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        if (r106 == false) goto L12;
    L15:
        this.f40356a.runOnUiThread(new b(r100, this));
        return;
    L12:
        if (this.f40367l != null) goto L15;
        HybridLogger.p("AnnieXPopupContainer", "onWebPageFinish is called before statusBarAndNavImp initialized, skip UI update.", null, 12);
        return;
    L9:
        r106 = false;
        goto L10
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void onWebScrollChanged(int r100, int r101, int r102, int r103) {
        super.onWebScrollChanged(r100, r101, r102, r103);
        this.f40374s = r101;
        boolean r104 = true;
        if (r101 <= 0) goto L16;
        ab.a r105 = this.f40365j;
        if (r105 != null) goto L7;
    L9:
        boolean r106 = false;
    L10:
        if (r106 == false) goto L16;
        if (this.f40371p != 3) goto L14;
    L15:
        f(true);
        return;
    L14:
        if (s() == true) goto L15;
        return;
    L7:
        if (r105.b() != true) goto L9;
        r106 = true;
    L16:
        if (r101 != 0) goto L28;
        ab.a r107 = this.f40365j;
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

    public final void z(Dialog r110, int r111, int r112, int r113) {
        if (r110 == null) goto L29;
        Window r114 = r110.getWindow();
        if (r114 == null) goto L29;
        if (this.f40365j == null) goto L29;
        WindowManager.LayoutParams r100 = r114.getAttributes();
        r100.gravity = r113;
        if (r111 <= 0) goto L12;
        r100.width = com.bytedance.android.anniex.container.util.i.f40626a.a(r111);
    L12:
        ab.a r101 = this.f40365j;
        if (r101 != null) goto L15;
    L140:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L27
        r114.setAttributes(r100);     // Catch: Throwable -> L27
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L15:
        if (r101.C() <= 0) goto L18;
        r100.x = r101.C();
    L18:
        if (r101.D() <= 0) goto L21;
        r100.y = r101.D();
    L21:
        if (r101.B() <= 0) goto L140;
        if (com.bytedance.android.anniex.container.util.i.f40626a.getResources().getConfiguration().orientation == 2) goto L140;
        float r104 = r101.B() / 100.0f;
        i16.c r105 = i16.c.f487996a;
        r100.width = (int) (i16.c.j(this.f40356a) * r104);
    L29:
        View r115 = getRootView();
        ViewGroup.LayoutParams r106 = null;
        if (r115 == null) goto L32;
        FrameLayout r116 = (FrameLayout) r115.findViewById(R.id.annie_x_dialog_container_view);
    L33:
        this.f40372q = r116;
        if (r116 == null) goto L36;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
    L37:
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r118 = (RelativeLayout.LayoutParams) r117;
        if (r111 <= 0) goto L40;
        r111 = com.bytedance.android.anniex.container.util.i.f40626a.a(r111);
    L40:
        r118.width = r111;
        if (r112 <= 0) goto L43;
        r112 = com.bytedance.android.anniex.container.util.i.f40626a.a(r112);
    L43:
        r118.height = r112;
        ab.a r119 = this.f40365j;
        boolean r120 = true;
        if (r119 == null) goto L95;
        com.bytedance.android.anniex.container.util.i r107 = com.bytedance.android.anniex.container.util.i.f40626a;
        if (r107.getResources().getConfiguration().orientation == 2) goto L80;
        if (s() == false) goto L51;
        r118.height = com.bytedance.android.anniex.container.util.i.c(this.f40356a).heightPixels - getRealNavigationBarHeight();
    L89:
        if (r119.l() <= 0) goto L92;
        r118.bottomMargin = r107.a(r119.l() * 1.0f);
    L92:
        if (r119.m() <= 0) goto L95;
        r118.rightMargin = r107.a(r119.m() * 1.0f);
        goto L95
    L51:
        if (r119.z() == true) goto L61;
        if (r119.f() <= 0) goto L89;
        y36.a r108 = r119.S;
        if (r108 == null) goto L57;
        boolean r109 = Intrinsics.areEqual(r108.f565862b, Boolean.TRUE);
    L58:
        if (r109 == true) goto L89;
        r118.height = (int) (r107.d() * RangesKt.coerceAtMost(r119.f() / 100.0f, 1.0f));
        goto L89
    L57:
        r109 = false;
        goto L58
    L61:
        if (r119.f() <= 0) goto L89;
        float r121 = RangesKt.coerceAtMost(r119.f() / 100.0f, 1.0f);
        if (isPadOrFold() == false) goto L78;
        Map<String, Map<Class<?>, Object>> r122 = x26.a.f562251a;
        w26.g r123 = (w26.g) x26.a.a(w26.g.class);
        if (r123 == null) goto L71;
        w26.e r124 = (w26.e) r123.n0(w26.e.class);
        if (r124 == null) goto L71;
        Boolean r125 = r124.k0();
        if (r125 == null) goto L71;
        boolean r126 = r125.booleanValue();
    L72:
        if (r126 == false) goto L78;
        int r127 = com.bytedance.android.anniex.container.util.i.c(getContext()).heightPixels;
        i16.c r128 = i16.c.f487996a;
        Context r129 = getContext();
        Intrinsics.checkNotNullParameter(r129, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r130 = r128.getResources(r129);
        int r131 = r130.getIdentifier("status_bar_height", "dimen", "android");
        if (r131 <= 0) goto L76;
        int r132 = r130.getDimensionPixelSize(r131);
    L77:
        r118.height = (int) (((r127 - r132) - getRealNavigationBarHeight()) * r121);
        goto L89
    L76:
        r132 = 0;
    L71:
        r126 = true;
    L78:
        r118.height = (int) (com.bytedance.android.anniex.container.util.i.c(getContext()).heightPixels * r121);
        goto L89
    L80:
        if (r107.getResources().getConfiguration().orientation != 2) goto L89;
        if (r119.z() == true) goto L89;
        if (r119.f() <= 0) goto L89;
        y36.a r133 = r119.S;
        if (r133 == null) goto L89;
        Intrinsics.areEqual(r133.f565862b, Boolean.TRUE);
    L95:
        if (r113 != 0) goto L97;
    L108:
        r118.addRule(13);
    L109:
        FrameLayout r134 = this.f40372q;
        if (r134 == null) goto L113;
        r134.setLayoutParams(r118);
    L113:
        int r135 = r118.height;
        if (com.bytedance.ies.bullet.service.base.h.x() == false) goto L136;
        ab.a r136 = this.f40365j;
        if (r136 != null) goto L118;
    L120:
        boolean r137 = false;
    L121:
        if (r137 == false) goto L136;
        ab.a r138 = this.f40365j;
        if (r138 != null) goto L125;
    L127:
        r120 = false;
    L128:
        if (r120 == false) goto L136;
        View r139 = getRootView();
        if (r139 == null) goto L132;
        View r140 = r139.findViewById(R.id.annie_x_container_view);
    L133:
        if (r140 == null) goto L135;
        r106 = r140.getLayoutParams();
    L135:
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r141 = (FrameLayout.LayoutParams) r106;
        r141.height = r135;
        r140.setLayoutParams(r141);
        goto L136
    L132:
        r140 = null;
        goto L133
    L125:
        if (r138.w() == true) goto L127;
    L118:
        if (r136.d() != 80) goto L120;
        r137 = true;
    L136:
        FrameLayout r142 = this.f40372q;
        if (r142 == null) goto L142;
        r142.requestLayout();
        return;
    L142:
        return;
    L97:
        if ((r113 & 17) == 17) goto L108;
        if ((r113 & 80) != 80) goto L103;
        r118.addRule(12);
        r118.addRule(11);
        goto L109
    L103:
        if ((r113 & 5) != 5) goto L106;
        r118.addRule(11);
        goto L109
    L106:
        if ((r113 & GravityCompat.END) != 8388613) goto L109;
        r118.addRule(21);
        goto L109
    L36:
        r117 = null;
        goto L37
    L32:
        r116 = null;
        goto L33
    }
}
