package com.bytedance.android.anniex.container.popup;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anniex.container.view.LimitedHeightFrameLayout;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.h;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w26.g;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetBaseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class SheetBaseDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f40491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f40492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f40493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SheetBaseBehavior<?> f40495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f40496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f40497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f40498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f40499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SheetBaseBehavior.b f40500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<SheetBaseBehavior.b> f40501l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.anniex.container.popup.e f40502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.android.anniex.container.popup.d f40503n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.anniex.container.popup.c f40504o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f40505p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f40506q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LimitedHeightFrameLayout f40507r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f40508s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f40509t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f40510u;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.anniex.container.popup.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseDialog f40511a;

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean a() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean c() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean d() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean e() {
            return !this.f40511a.f40497h;
        }

        public b(SheetBaseDialog r100) {
            this.f40511a = r100;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean f(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return false;
        }
    }

    public static final class c implements com.bytedance.android.anniex.container.popup.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseDialog f40512a;

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean shouldInterceptSlide(int r100) {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean disableDragDown() {
            SheetBaseDialog r100 = this.f40512a;
            if (r100.f40497h == true) goto L5;
        L8:
            return true;
        L5:
            if (r100.f40491b == true) goto L8;
            return false;
        }

        public c(SheetBaseDialog r100) {
            this.f40512a = r100;
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean a(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return false;
        }
    }

    public static final class d implements SheetBaseBehavior.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseDialog f40513a;

        public d(SheetBaseDialog r100) {
            this.f40513a = r100;
        }

        @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
        public final void a(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            if (r101 != 5) goto L5;
            this.f40513a.J0(PopupCloseType.PULL_DOWN);
        L5:
            SheetBaseBehavior.b r102 = this.f40513a.f40500k;
            if (r102 == null) goto L8;
            Intrinsics.checkNotNull(r102);
            r102.a(r100, r101);
        L8:
            Iterator<SheetBaseBehavior.b> r103 = this.f40513a.f40501l.iterator();
        L10:
            if (r103.hasNext() == false) goto L12;
            r103.next().a(r100, r101);
            goto L10
        }

        @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
        public final void b(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            SheetBaseBehavior.b r102 = this.f40513a.f40500k;
            if (r102 == null) goto L5;
            r102.b(r100, r101);
        L5:
            Iterator<SheetBaseBehavior.b> r103 = this.f40513a.f40501l.iterator();
        L7:
            if (r103.hasNext() == false) goto L9;
            r103.next().b(r100, r101);
            goto L7
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseDialog f40514a;

        public e(SheetBaseDialog r100) {
            this.f40514a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f40514a.J0(PopupCloseType.CLICK_MASK);
        }
    }

    public static final class f implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f40515a = null;

        static {
            f40515a = new f();
        }

        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.f40496g == true) goto L5;
    L9:
        com.bytedance.android.anniex.container.popup.c r100 = this.f40504o;
        if (r100 == null) goto L14;
        Intrinsics.checkNotNull(r100);
        r100.a();
        com.bytedance.android.anniex.container.popup.c r101 = this.f40504o;
        Intrinsics.checkNotNull(r101);
        r101.b(false, PopupCloseType.UNKNOWN);
        return;
    L14:
        return;
    L5:
        if (isShowing() == false) goto L9;
        if (shouldWindowCloseOnTouchOutside() == false) goto L9;
        super.cancel();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        J0(PopupCloseType.SYSTEM_BACK);
    }

    public final boolean shouldWindowCloseOnTouchOutside() {
        if (this.f40499j == true) goto L6;
        TypedArray r100 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.f40498i = r100.getBoolean(0, true);
        r100.recycle();
        this.f40499j = true;
    L6:
        return this.f40498i;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        SheetBaseBehavior<?> r100 = this.f40495f;
        if (r100 == null) goto L8;
        Intrinsics.checkNotNull(r100);
        r100.setState(3);
        if (this.f40505p == false) goto L9;
        SheetBaseBehavior<?> r101 = this.f40495f;
        Intrinsics.checkNotNull(r101);
        r101.setState(4);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        I0(this);
    }

    @Override // android.app.Dialog
    public final void hide() {
        super.hide();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onStop() {
        super.onStop();
    }

    public static void I0(AppCompatDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void J0(PopupCloseType r100) {
        if (this.f40496g == true) goto L5;
    L9:
        com.bytedance.android.anniex.container.popup.c r101 = this.f40504o;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNull(r101);
        r101.a();
    L12:
        com.bytedance.android.anniex.container.popup.c r102 = this.f40504o;
        if (r102 == null) goto L18;
        if (r100 == null) goto L19;
        Intrinsics.checkNotNull(r102);
        r102.b(shouldWindowCloseOnTouchOutside(), r100);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (isShowing() == false) goto L9;
        if (shouldWindowCloseOnTouchOutside() == false) goto L9;
        super.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f40491b == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L24;
        Window r102 = getWindow();
        if (r102 == null) goto L13;
        r102.addFlags(Integer.MIN_VALUE);
    L13:
        Window r103 = getWindow();
        if (r103 == null) goto L16;
        r103.clearFlags(67108864);
    L16:
        Window r104 = getWindow();
        if (r104 == null) goto L20;
        r104.setStatusBarColor(0);
    L20:
        Window r105 = getWindow();
        if (r105 == null) goto L25;
        r105.clearFlags(1024);
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (this.f40492c == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // android.app.Dialog
    public final void onRestoreInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "savedInstanceState");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (h.J() == false) goto L6;
        r100.remove("android:dialogShowing");     // Catch: Throwable -> L8
        r100.remove("android:dialogHierarchy");     // Catch: Throwable -> L8
    L6:
        super.onRestoreInstanceState(r100);     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L16;
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.g("SheetBaseDialog", "onRestoreInstanceState error====" + r103.getMessage(), null, null);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f40504o == null) goto L31;
        boolean r101 = true;
        if (1 != r100.getAction()) goto L31;
        Context r102 = getContext();
        int r103 = (int) r100.getX();
        int r104 = (int) r100.getY();
        int r105 = ViewConfiguration.get(r102).getScaledWindowTouchSlop();
        if (getWindow() == null) goto L28;
        Window r106 = getWindow();
        if (r106 == null) goto L16;
        View r107 = r106.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L17;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r108 = ThreadMethodProxy.currentThread();
        if (r108 == com.larus.home.impl.utils.c.f346341a) goto L17;
        com.larus.home.impl.utils.c.a(r108, "getDecorView");
    L17:
        if (r107 == null) goto L28;
        int r109 = -r105;
        if (r103 < r109) goto L28;
        if (r104 < r109) goto L28;
        if (r103 > (r107.getWidth() + r105)) goto L28;
        if (r104 > (r107.getHeight() + r105)) goto L28;
        r101 = false;
        goto L28
    L16:
        r107 = null;
    L28:
        if (r101 == false) goto L31;
        com.bytedance.android.anniex.container.popup.c r110 = this.f40504o;
        Intrinsics.checkNotNull(r110);
        shouldWindowCloseOnTouchOutside();
        r110.a();
        com.bytedance.android.anniex.container.popup.c r111 = this.f40504o;
        Intrinsics.checkNotNull(r111);
        r111.b(shouldWindowCloseOnTouchOutside(), PopupCloseType.CLICK_MASK);
    L31:
        return super.onTouchEvent(r100);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.f40496g == r100) goto L7;
        this.f40496g = r100;
        SheetBaseBehavior<?> r101 = this.f40495f;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r101);
        r101.f40485a = r100;
    L7:
        if (r100 == true) goto L28;
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;
        g r103 = (g) x26.a.a(g.class);
        if (r103 == null) goto L15;
        w26.e r104 = (w26.e) r103.n0(w26.e.class);
        if (r104 == null) goto L15;
        Boolean r105 = r104.M();
        if (r105 == null) goto L15;
        boolean r106 = r105.booleanValue();
    L16:
        if (r106 == false) goto L29;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L22
        SheetBaseBehavior<?> r108 = this.f40495f;     // Catch: Throwable -> L22
        if (r108 == null) goto L20;
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L22
        r108.f40485a = true;     // Catch: Throwable -> L22
    L20:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Result.m9452exceptionOrNullimpl(r109);
        return;
    L22:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L29:
        return;
    L15:
        r106 = true;
        goto L16
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.f40498i = r100;
        this.f40499j = true;
        View r101 = this.f40509t;
        if (r101 != null) goto L10;
        return;
    L10:
        if (h.g() == false) goto L19;
        if (r100 == true) goto L13;
    L15:
        boolean r102 = false;
    L16:
        if (r102 == false) goto L18;
        r101.setImportantForAccessibility(1);
        r101.setFocusable(true);
        return;
    L18:
        r101.setImportantForAccessibility(2);
        r101.setFocusable(false);
        return;
    L13:
        if (this.f40508s == true) goto L15;
        r102 = true;
        goto L16
    L19:
        if (r100 == false) goto L21;
        r101.setImportantForAccessibility(1);
        r101.setFocusable(true);
        return;
    L21:
        r101.setImportantForAccessibility(2);
        r101.setFocusable(false);
        return;
    L5:
        if (this.f40496g == true) goto L7;
        this.f40496g = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.setContentView(wrapInBottomSheet(0, r100, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        super.setContentView(wrapInBottomSheet(r100, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.setContentView(wrapInBottomSheet(0, r100, r101));
    }

    public final View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r110) {
        Unit r102 = null;
        if (this.f40493d == false) goto L8;
        if (this.f40494e < i16.c.f(480, getContext())) goto L8;
        View r103 = View.inflate(getContext(), com.larus.nova.R.layout.annie_x_dialog_bottom_sheet, null);
    L16:
        CoordinatorLayout r104 = (CoordinatorLayout) r103.findViewById(com.larus.nova.R.id.annie_x_bottom_sheet_coordinator);
        if (r100 == 0) goto L20;
        if (r101 != null) goto L20;
        r101 = getLayoutInflater().inflate(r100, r104, false);
    L20:
        LimitedHeightFrameLayout r105 = (LimitedHeightFrameLayout) r104.findViewById(com.larus.nova.R.id.annie_x_bottom_sheet);
        this.f40507r = r105;
        if (this.f40491b == true) goto L23;
    L27:
        int r106 = SheetBaseBehavior.f40484f;
        LimitedHeightFrameLayout r107 = this.f40507r;
        Intrinsics.checkNotNull(r107);
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof CoordinatorLayout.LayoutParams) == false) goto L76;
        CoordinatorLayout.Behavior r109 = ((CoordinatorLayout.LayoutParams) r108).getBehavior();
        if ((r109 instanceof SheetBaseBehavior) == false) goto L74;
        SheetBaseBehavior<?> r111 = (SheetBaseBehavior) r109;
        this.f40495f = r111;
        Intrinsics.checkNotNull(r111);
        r111.f40486b = this.f40510u;
        SheetBaseBehavior<?> r112 = this.f40495f;
        Intrinsics.checkNotNull(r112);
        r112.f40485a = this.f40496g;
        boolean r113 = true;
        if (this.f40505p == false) goto L34;
        SheetBaseBehavior<?> r114 = this.f40495f;
        Intrinsics.checkNotNull(r114);
        r114.setPeekHeight(this.f40506q);
        SheetBaseBehavior<?> r115 = this.f40495f;
        Intrinsics.checkNotNull(r115);
        r115.f40487c = false;
    L35:
        SheetBaseBehavior<?> r116 = this.f40495f;
        Intrinsics.checkNotNull(r116);
        r116.f40488d = this.f40502m;
        SheetBaseBehavior<?> r117 = this.f40495f;
        Intrinsics.checkNotNull(r117);
        r117.f40489e = this.f40503n;
        if (r110 != null) goto L45;
        Intrinsics.checkNotNull(r101);
        if (r101.getLayoutParams() == null) goto L40;
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(r101.getLayoutParams());
        r118.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        LimitedHeightFrameLayout r119 = this.f40507r;
        Intrinsics.checkNotNull(r119);
        r119.addView(r101, r118);
    L46:
        LimitedHeightFrameLayout r120 = this.f40507r;
        if (r120 == null) goto L57;
        if (this.f40491b == false) goto L57;
        if (this.f40493d == true) goto L57;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if ((r121 instanceof CoordinatorLayout.LayoutParams) == false) goto L55;
        CoordinatorLayout.LayoutParams r122 = (CoordinatorLayout.LayoutParams) r121;
        ((ViewGroup.MarginLayoutParams) r122).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r122).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams) r122).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r122).bottomMargin = 0;
    L55:
        r120.setMaxHeight(0);
        r121.width = -2;
        r120.setLayoutParams(r121);
    L57:
        if (h.g() == false) goto L61;
        this.f40508s = true;
        View r123 = this.f40509t;
        if (r123 == null) goto L61;
        r123.setFocusable(false);
        r123.setImportantForAccessibility(2);
    L61:
        View r124 = r104.findViewById(com.larus.nova.R.id.annie_x_bottom_sheet_outside);
        r124.setOnClickListener(new e(this));
        this.f40509t = r124;
        LimitedHeightFrameLayout r125 = this.f40507r;
        Intrinsics.checkNotNull(r125);
        ViewCompat.setAccessibilityDelegate(r125, new AnonymousClass4(this));
        LimitedHeightFrameLayout r126 = this.f40507r;
        Intrinsics.checkNotNull(r126);
        r126.setOnTouchListener(f.f40515a);
        if (this.f40491b == false) goto L64;
    L67:
        if (r113 == false) goto L72;
        r103.setFitsSystemWindows(false);
        r104.setFitsSystemWindows(false);
        LimitedHeightFrameLayout r127 = this.f40507r;
        if (r127 == null) goto L72;
        r127.setFitsSystemWindows(false);
    L72:
        return r103;
    L64:
        if (this.f40492c == true) goto L67;
        r113 = false;
        goto L67
    L40:
        Window r128 = getWindow();
        if (r128 == null) goto L43;
        WindowManager.LayoutParams r129 = r128.getAttributes();
        LimitedHeightFrameLayout r130 = this.f40507r;
        Intrinsics.checkNotNull(r130);
        r130.addView(r101, new FrameLayout.LayoutParams(r129.width, r129.height, r129.gravity));
        r102 = Unit.INSTANCE;
    L43:
        if (r102 != null) goto L46;
        LimitedHeightFrameLayout r131 = this.f40507r;
        Intrinsics.checkNotNull(r131);
        r131.addView(r101);
        goto L46
    L45:
        LimitedHeightFrameLayout r132 = this.f40507r;
        Intrinsics.checkNotNull(r132);
        r132.addView(r101, r110);
        goto L46
    L34:
        SheetBaseBehavior<?> r133 = this.f40495f;
        Intrinsics.checkNotNull(r133);
        r133.f40487c = true;
        goto L35
    L74:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L76:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    L23:
        if (this.f40493d == true) goto L27;
        if (r105 == null) goto L27;
        r105.setMaxHeight(i16.c.f(700, getContext()));
    L8:
        if (this.f40491b == false) goto L13;
        if (this.f40493d == true) goto L13;
        r103 = View.inflate(getContext(), com.larus.nova.R.layout.annie_x_dialog_right_sheet_hd, null);
    L13:
        if (this.f40490a == false) goto L15;
        r103 = View.inflate(getContext(), com.larus.nova.R.layout.annie_x_dialog_right_sheet, null);
        goto L16
    L15:
        r103 = View.inflate(getContext(), com.larus.nova.R.layout.annie_x_dialog_bottom_sheet, null);
        goto L16
    }

    public SheetBaseDialog(Context r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r106 = com.bytedance.android.anniex.container.popup.f.f40521a;
        super(r100, com.larus.nova.R.style.annie_x_standard_dialog_bottom_theme_appcompat);
        this.f40490a = r101;
        this.f40491b = r102;
        this.f40492c = r103;
        this.f40493d = r104;
        this.f40494e = r105;
        this.f40496g = true;
        this.f40497h = true;
        this.f40498i = true;
        this.f40501l = new ArrayList();
        this.f40502m = new c(this);
        this.f40503n = new b(this);
        this.f40506q = i16.c.f(484, r100);
        this.f40510u = new d(this);
    }
}
