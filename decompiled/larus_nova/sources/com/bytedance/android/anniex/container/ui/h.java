package com.bytedance.android.anniex.container.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputMode;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.gyf.barlibrary.FlymeOSStatusBarFontUtils;
import com.gyf.barlibrary.OSUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import y36.r;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f40571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ia.c f40572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f40573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f40574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f40575e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f40576a;

        public b(h r100) {
            this.f40576a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f40576a.f40572b.goBack();
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f40577a;

        public c(h r100) {
            this.f40577a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f40577a.f40572b.close();
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f40578a;

        public d(h r100) {
            this.f40578a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f40578a.f40572b.goBack();
        }
    }

    static {
    }

    public final void a() {
        HybridLogger.m("StatusBarAndNavImp", "hide navigation bar", null, null, 12);
        View r100 = this.f40573c.findViewById(R.id.annie_x_title_bar);
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        View r101 = this.f40573c.findViewById(R.id.annie_x_title_placeholder);
        if (r101 == null) goto L11;
        r101.setVisibility(8);
        return;
    }

    public final void l() {
        HybridLogger.m("StatusBarAndNavImp", "show navigation bar", null, null, 12);
        View r100 = this.f40573c.findViewById(R.id.annie_x_title_bar);
        if (r100 == null) goto L6;
        r100.setVisibility(0);
    L6:
        View r101 = this.f40573c.findViewById(R.id.annie_x_title_placeholder);
        if (r101 == null) goto L11;
        r101.setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(ab.b r110) {
        Intrinsics.checkNotNullParameter(r110, "uiModel");
        String r100 = null;
        HybridLogger.m("StatusBarAndNavImp", "===init status bar===", null, null, 12);
        y36.a r101 = r110.f2430d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("hideStatusBar");
        r101 = null;
    L6:
        Boolean r102 = (Boolean) r101.f565862b;
        boolean r103 = false;
        if (r102 == null) goto L9;
        boolean r104 = r102.booleanValue();
    L10:
        T r105 = r110.c().f565862b;
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r106) == true) goto L20;
        y36.a r107 = r110.f2441o;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("shouldFullScreen");
        r107 = null;
    L17:
        if (Intrinsics.areEqual(r107.f565862b, r106) == true) goto L20;
        boolean r108 = false;
    L21:
        com.bytedance.ies.bullet.service.sdk.param.a r109 = r110.f2437k;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("statusFontMode");
        r109 = null;
    L25:
        String r111 = r109.a();
        if (r111 != null) goto L28;
        r111 = "light";
    L28:
        Activity r112 = this.f40571a;
        y36.a r113 = r110.f2446t;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("isHostLight");
        r113 = null;
    L32:
        Boolean r114 = (Boolean) r113.f565862b;
        if (r114 == null) goto L35;
        boolean r115 = r114.booleanValue();
    L36:
        r r116 = r110.f2435i;
        if (r116 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarBgColor");
        r116 = null;
    L40:
        Integer r117 = (Integer) r116.f565862b;
        if (r112 != null) goto L43;
        HybridLogger.i("StatusBarAndNavImp", "setStatusBarStyle: activity is null", null, 12);
    L56:
        if (r104 == false) goto L91;
        Activity r118 = this.f40571a;
        int r119 = com.bytedance.android.anniex.container.util.f.f40621a;
        int r120 = com.bytedance.android.anniex.container.util.j.f40627a;
        if (r118 != null) goto L60;
    L85:
        if (r103 == false) goto L87;
        int r121 = com.bytedance.android.anniex.container.util.j.f40627a;
        com.bytedance.android.anniex.container.util.j.b(this.f40571a, r111);
        goto L91
    L87:
        int r122 = com.bytedance.android.anniex.container.util.j.f40627a;
        Activity r123 = this.f40571a;
        if (r123 == null) goto L91;
        r123.getWindow().setFlags(1024, 1024);
        Intrinsics.checkNotNullParameter(r123, "activity");
        r123.getWindow().setStatusBarColor(r123.getResources().getColor(android.R.color.transparent));
        goto L91
    L60:
        if (Build.VERSION.SDK_INT < 28) goto L72;
        View r124 = r118.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L96;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r125 = ThreadMethodProxy.currentThread();
        if (r125 == com.larus.home.impl.utils.c.f346341a) goto L96;
        com.larus.home.impl.utils.c.a(r125, "getDecorView");
    L96:
        Object r126 = r124.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(r124, new Object[0]);     // Catch: Exception -> L70
        Object r127 = r126.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(r126, new Object[0]);     // Catch: Exception -> L70
        Object r128 = r127.getClass().getMethod("getBoundingRects", new Class[0]).invoke(r127, new Object[0]);     // Catch: Exception -> L70
        Intrinsics.checkNotNull(r128, "null cannot be cast to non-null type kotlin.collections.List<android.graphics.Rect>");     // Catch: Exception -> L70
        if (((List) r128).size() <= 0) goto L72;
        boolean r129 = true;
    L73:
        if (r129 == false) goto L94;
    L84:
        r103 = true;
        goto L85
    L94:
        Resources r130 = r118.getResources();     // Catch: Exception -> L81
        int r131 = r130.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");     // Catch: Exception -> L81
        if (r131 <= 0) goto L77;
        r100 = r130.getString(r131);     // Catch: Exception -> L81
    L77:
        if (r100 == null) goto L82;
        if (TextUtils.isEmpty(r100) == true) goto L82;
        boolean r132 = true;
    L83:
        if (r132 == false) goto L85;
    L82:
        r132 = false;
    L70:
        e = move-exception;
        e.printStackTrace();
    L72:
        r129 = false;
    L91:
        if (r108 == false) goto L98;
        int r133 = com.bytedance.android.anniex.container.util.j.f40627a;
        com.bytedance.android.anniex.container.util.j.b(this.f40571a, r111);
        return;
    L98:
        return;
    L43:
        if (r115 == false) goto L46;
        com.bytedance.android.anniex.container.util.g.g(r112);
        com.bytedance.android.anniex.container.util.g.c(r112);
        int r134 = b46.l.f17550a;
        b46.l.e(r112, ColorProtector.parseColor("white"));
        goto L56
    L46:
        if (Intrinsics.areEqual("light", r111) == false) goto L49;
        com.bytedance.android.anniex.container.util.g.f(r112);
        com.bytedance.android.anniex.container.util.g.c(r112);
    L54:
        if (r117 == null) goto L56;
        int r135 = b46.l.f17550a;
        b46.l.e(r112, r117.intValue());
        goto L56
    L49:
        if (Intrinsics.areEqual("dark", r111) == false) goto L54;
        com.bytedance.android.anniex.container.util.g.g(r112);
        if (r104 == true) goto L54;
        if (r108 == true) goto L54;
        com.bytedance.android.anniex.container.util.g.c(r112);
        goto L54
    L35:
        r115 = false;
    L20:
        r108 = true;
        goto L21
    L9:
        r104 = false;
        goto L10
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "navBarColor");
        HybridLogger.m("StatusBarAndNavImp", "set navigation bar color", null, null, 12);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        View r102 = this.f40573c.findViewById(R.id.annie_x_title_bar);     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.setBackgroundColor(Color.parseColor(r100));     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.i("StatusBarAndNavImp", "setNavBarColor :" + r105.getMessage(), null, 12);
        return;
    L17:
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "statusBarColor");
        HybridLogger.m("StatusBarAndNavImp", "===set status bar color===", null, null, 12);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        int r102 = b46.l.f17550a;     // Catch: Throwable -> L5
        b46.l.e(this.f40571a, Color.parseColor(r100));     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.i("StatusBarAndNavImp", "setStatusBarColor :" + r104.getMessage(), null, 12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "statusFontMode");
        HybridLogger.m("StatusBarAndNavImp", "===set status font mode===", null, null, 12);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r100, "dark") == false) goto L6;
        boolean r102 = true;
    L7:
        Activity r103 = this.f40571a;     // Catch: Throwable -> L9
        h(r103, r103.getWindow(), r102);     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.i("StatusBarAndNavImp", "setStatusFontMode :" + r105.getMessage(), null, 12);
        return;
    L17:
        return;
    L6:
        Intrinsics.areEqual(r100, "light");     // Catch: Throwable -> L9
        r102 = false;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        HybridLogger.m("StatusBarAndNavImp", "set title", null, null, 12);
        TextView r101 = (TextView) this.f40573c.findViewById(R.id.annie_x_title_text);
        if (r101 == null) goto L7;
        r101.setText(r100);
        return;
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "titleColor");
        HybridLogger.m("StatusBarAndNavImp", "set title color", null, null, 12);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        TextView r102 = (TextView) this.f40573c.findViewById(R.id.annie_x_title_text);     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.setTextColor(Color.parseColor(r100));     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.i("StatusBarAndNavImp", "setTitleColor :" + r105.getMessage(), null, 12);
        return;
    L17:
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(ab.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uiModel");
        Intrinsics.checkNotNullParameter(r101, "bid");
        this.f40574d = this.f40573c.findViewById(R.id.annie_x_activity_back);
        ImageView r102 = (ImageView) this.f40573c.findViewById(R.id.annie_x_activity_share);
        y36.a r103 = r100.f2445s;
        Boolean r104 = null;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("closePositionRight");
        r103 = null;
    L7:
        if (Intrinsics.areEqual(r103.f565862b, Boolean.TRUE) == false) goto L9;
        View r105 = this.f40573c.findViewById(R.id.annie_x_activity_close);
    L10:
        this.f40575e = r105;
        if (Intrinsics.areEqual(r100.getType().f565862b, "fullscreen") == false) goto L30;
        y36.a r106 = r100.f2442p;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("showBack");
        r106 = null;
    L16:
        Boolean r107 = (Boolean) r106.f565862b;
        if (r107 == null) goto L30;
        if (r107.booleanValue() == true) goto L22;
        r107 = null;
    L22:
        if (r107 == null) goto L30;
        r107.booleanValue();
        View r108 = this.f40574d;
        if (r108 == null) goto L27;
        r108.setVisibility(0);
    L27:
        View r109 = this.f40574d;
        if (r109 == null) goto L30;
        r109.setOnClickListener(new b(this));
    L30:
        y36.d r110 = r100.f2444r;
        if (r110 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("iconTheme");
        r110 = null;
    L34:
        Integer r111 = (Integer) r110.f565862b;
        boolean r112 = true;
        if (r111 != null) goto L38;
    L45:
        Boolean r113 = (Boolean) r100.b().f565862b;
        if (r113 != null) goto L48;
    L63:
        y36.a r114 = r100.f2443q;
        if (r114 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("enableShare");
        r114 = null;
    L67:
        Boolean r115 = (Boolean) r114.f565862b;
        if (r115 != null) goto L70;
        return;
    L70:
        if (r115.booleanValue() == false) goto L72;
        r104 = r115;
    L72:
        if (r104 == null) goto L76;
        r104.booleanValue();
        r102.setVisibility(0);
        return;
    L76:
        return;
    L48:
        if (r113.booleanValue() == true) goto L50;
    L52:
        r112 = false;
    L53:
        if (r112 == true) goto L56;
        r113 = null;
    L56:
        if (r113 == null) goto L63;
        r113.booleanValue();
        View r116 = this.f40575e;
        if (r116 == null) goto L61;
        r116.setVisibility(0);
    L61:
        if (r116 == null) goto L63;
        r116.setOnClickListener(new c(this));
        goto L63
    L50:
        if (Intrinsics.areEqual(r101, "webcast") == false) goto L52;
    L38:
        if (r111.intValue() != 1) goto L45;
        View r117 = this.f40575e;
        if ((r117 instanceof ImageView) == false) goto L42;
        ImageView r118 = (ImageView) r117;
    L43:
        if (r118 == null) goto L45;
        r118.setImageResource(R.drawable.annie_x_title_bar_close_with_bg);
        goto L45
    L42:
        r118 = null;
        goto L43
    L9:
        r105 = this.f40573c.findViewById(R.id.annie_x_activity_close_left);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Window r100, ab.b r101) {
        Intrinsics.checkNotNullParameter(r101, "uiModel");
        y36.a r102 = r101.f2427a;
        y36.n r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r102 = null;
    L6:
        T r104 = r102.f565862b;
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == false) goto L11;
        HybridLogger.m("StatusBarAndNavImp", "disable input scroll", null, null, 12);
        if (r100 == null) goto L20;
        r100.setSoftInputMode(48);
    L20:
        if ((this.f40572b instanceof ia.d) == false) goto L45;
        Map<String, Map<Class<?>, Object>> r106 = x26.a.f562251a;
        w26.g r107 = (w26.g) x26.a.a(w26.g.class);
        if (r107 == null) goto L28;
        w26.e r108 = (w26.e) r107.n0(w26.e.class);
        if (r108 == null) goto L28;
        Boolean r109 = r108.l0();
        if (r109 == null) goto L28;
        boolean r110 = r109.booleanValue();
    L29:
        if (r110 == false) goto L46;
        y36.a r111 = r101.f2427a;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r111 = null;
    L35:
        if (Intrinsics.areEqual(r111.f565862b, r105) == true) goto L47;
        y36.n r112 = r101.f2434h;
        if (r112 == null) goto L39;
        r103 = r112;
    L41:
        if (r103.f565862b != 0) goto L48;
        if (r100 == null) goto L49;
        r100.setSoftInputMode(16);
        return;
    L49:
        return;
    L48:
        return;
    L39:
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        goto L41
    L47:
        return;
    L46:
        return;
    L28:
        r110 = true;
        goto L29
    L45:
        return;
    L11:
        HybridLogger.m("StatusBarAndNavImp", "use soft input mode", null, null, 12);
        y36.n r113 = r101.f2434h;
        if (r113 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        r113 = null;
    L15:
        SoftInputMode r114 = (SoftInputMode) r113.f565862b;
        if (r114 == null) goto L20;
        if (r100 == null) goto L20;
        r100.setSoftInputMode(r114.getSystemValue());
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(ab.b r100, int r101) {
        Boolean r102 = null;
        if (r100 == null) goto L7;
        y36.p r103 = r100.getType();
        if (r103 == null) goto L7;
        String r104 = (String) r103.f565862b;
    L9:
        if (Intrinsics.areEqual(r104, "popup") == false) goto L57;
        y36.a r105 = r100.f2442p;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("showBack");
        r105 = null;
    L14:
        int r106 = 0;
        if (Intrinsics.areEqual(r105.f565862b, Boolean.FALSE) == true) goto L28;
        y36.a r107 = r100.f2445s;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("closePositionRight");
        r107 = null;
    L21:
        T r108 = r107.f565862b;
        Boolean r109 = Boolean.TRUE;
        if (Intrinsics.areEqual(r108, r109) == false) goto L24;
        boolean r110 = Intrinsics.areEqual(r100.b().f565862b, r109);
    L25:
        if (r110 == true) goto L28;
        if (r101 != 0) goto L28;
        r106 = 8;
        goto L28
    L24:
        r110 = false;
    L28:
        Boolean r111 = (Boolean) r100.b().f565862b;
        if (r111 != null) goto L31;
    L39:
        y36.a r112 = r100.f2442p;
        if (r112 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("showBack");
        r112 = null;
    L43:
        Boolean r113 = (Boolean) r112.f565862b;
        if (r113 != null) goto L46;
        return;
    L46:
        if (r113.booleanValue() == false) goto L48;
        r102 = r113;
    L48:
        if (r102 == null) goto L59;
        r102.booleanValue();
        View r114 = this.f40574d;
        if (r114 == null) goto L53;
        r114.setVisibility(r101);
    L53:
        View r115 = this.f40574d;
        if (r115 == null) goto L60;
        r115.setOnClickListener(new d(this));
        return;
    L60:
        return;
    L59:
        return;
    L31:
        if (r111.booleanValue() == true) goto L34;
        r111 = null;
    L34:
        if (r111 == null) goto L39;
        r111.booleanValue();
        View r116 = this.f40575e;
        if (r116 == null) goto L39;
        r116.setVisibility(r106);
        goto L39
    L57:
        return;
    L7:
        r104 = null;
        goto L9
    }

    public h(Activity r100, ia.c r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "rootView");
        this.f40571a = r100;
        this.f40572b = r101;
        this.f40573c = r102;
    }

    public static void h(Activity r100, Window r101, boolean r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L23
        if (r100 == null) goto L22;
        if (r101 != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 30) goto L15;
        WindowInsetsController r104 = r101.getInsetsController();     // Catch: Throwable -> L23
        if (r104 == null) goto L15;
        if (r102 == true) goto L13;
        r104.setSystemBarsAppearance(0, 8);     // Catch: Throwable -> L23
        goto L15
    L13:
        r104.setSystemBarsAppearance(8, 8);     // Catch: Throwable -> L23
    L15:
        if (OSUtils.isMIUI6Later() == false) goto L18;
        b46.l.d(r102, r101);     // Catch: Throwable -> L23
    L18:
        if (OSUtils.isFlymeOS4Later() == false) goto L20;
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(r100, r102);     // Catch: Throwable -> L23
    L20:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L32;
        HybridLogger r107 = HybridLogger.f246343a;
        HybridLogger.i("StatusBarAndNavImp", "setStatusBarMode:" + r106.getMessage(), null, 12);
        return;
    L32:
        return;
    L22:
        return;
    L23:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }
}
