package com.bytedance.android.livesdk.pannel;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
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
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/SheetBaseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "panel_release"}, k = 1, mv = {1, 4, 0})
public class SheetBaseDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SheetBaseBehavior<?> f154336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f154337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f154338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f154339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f154340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SheetBaseBehavior.b f154341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.pannel.f f154342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.livesdk.pannel.e f154343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.livesdk.pannel.d f154344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.pannel.a f154345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f154346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f154347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RadiusLayout f154348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f154349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f154350o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final on2.a f154351p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f154352q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f154353r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f154354s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f154355t;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.pannel.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseDialog f154356a;

        @Override // com.bytedance.android.livesdk.pannel.e
        public final boolean a() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.pannel.e
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.pannel.e
        public final boolean c() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.pannel.e
        public final boolean d() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.pannel.e
        public final boolean f(MotionEvent r100) {
            return false;
        }

        @Override // com.bytedance.android.livesdk.pannel.e
        public final boolean e() {
            return !this.f154356a.f154338c;
        }

        public b(SheetBaseDialog r100) {
            this.f154356a = r100;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.pannel.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseDialog f154357a;

        @Override // com.bytedance.android.livesdk.pannel.f
        public final /* synthetic */ boolean a(MotionEvent r100) {
            return false;
        }

        @Override // com.bytedance.android.livesdk.pannel.f
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }

        @Override // com.bytedance.android.livesdk.pannel.f
        public final boolean disableDragDown() {
            SheetBaseDialog r100 = this.f154357a;
            if (r100.f154338c == true) goto L5;
        L8:
            return true;
        L5:
            if (r100.f154354s == true) goto L8;
            return false;
        }

        public c(SheetBaseDialog r100) {
            this.f154357a = r100;
        }
    }

    public static final class d implements SheetBaseBehavior.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseDialog f154358a;

        public d(SheetBaseDialog r100) {
            this.f154358a = r100;
        }

        @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior.b
        public final void a(View r100, int r101) {
            if (r101 != 5) goto L5;
            this.f154358a.L0(CloseType.PullDown);
        L5:
            SheetBaseBehavior.b r102 = this.f154358a.f154341f;
            if (r102 == null) goto L9;
            r102.a(r100, r101);
            return;
        }

        @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior.b
        public final void b(View r100, float r101) {
            SheetBaseBehavior.b r102 = this.f154358a.f154341f;
            if (r102 == null) goto L6;
            r102.b(r100, r101);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseDialog f154359a;

        public e(SheetBaseDialog r100) {
            this.f154359a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f154359a.L0(CloseType.MaskClick);
        }
    }

    public static final class f implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f154360a = null;

        static {
            f154360a = new f();
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

    public void M0(View r100) {
    }

    private final boolean shouldWindowCloseOnTouchOutside() {
        if (this.f154340e == true) goto L6;
        TypedArray r100 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.f154339d = r100.getBoolean(0, true);
        r100.recycle();
        this.f154340e = true;
    L6:
        return this.f154339d;
    }

    public final void N0() {
        RadiusLayout r100 = this.f154348m;
        on2.a r101 = this.f154351p;
        if (r101 == null) goto L8;
        int r102 = pn2.a.f529957a;
        GradientDrawable r103 = new GradientDrawable();
        r103.setColor(r101.f524334a);
        float r104 = r101.f524335b;
        r103.setCornerRadii(new float[]{r104, r104, r104, r104, 0.0f, 0.0f, 0.0f, 0.0f});
        if (r100 == null) goto L9;
        r100.setBackground(r103);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.f154337b == true) goto L5;
    L12:
        com.bytedance.android.livesdk.pannel.d r100 = this.f154344i;
        if (r100 == null) goto L21;
        r100.a();
        com.bytedance.android.livesdk.pannel.d r101 = this.f154344i;
        if (r101 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        r101.b(false, CloseType.UnKnown);
        return;
    L21:
        return;
    L5:
        if (isShowing() == false) goto L12;
        if (shouldWindowCloseOnTouchOutside() == false) goto L12;
        com.bytedance.android.livesdk.pannel.a r102 = this.f154345j;
        if (r102 == null) goto L11;
        r102.I2(new AnonymousClass1(this));
        return;
    L11:
        super.cancel();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        L0(CloseType.SystemBack);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        SheetBaseBehavior<?> r100 = this.f154336a;
        if (r100 == null) goto L13;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        r100.setState(3);
        if (this.f154346k == false) goto L14;
        SheetBaseBehavior<?> r101 = this.f154336a;
        if (r101 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r101.setState(4);
        return;
    L14:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        I0(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
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

    public static final /* synthetic */ void J0(SheetBaseDialog r100) {
        super.cancel();
    }

    public final void L0(CloseType r100) {
        if (this.f154337b == true) goto L5;
    L12:
        com.bytedance.android.livesdk.pannel.d r101 = this.f154344i;
        if (r101 == null) goto L15;
        r101.a();
    L15:
        com.bytedance.android.livesdk.pannel.d r102 = this.f154344i;
        if (r102 == null) goto L22;
        if (r100 == null) goto L23;
        r102.b(shouldWindowCloseOnTouchOutside(), r100);
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (isShowing() == false) goto L12;
        if (shouldWindowCloseOnTouchOutside() == false) goto L12;
        com.bytedance.android.livesdk.pannel.a r103 = this.f154345j;
        if (r103 == null) goto L11;
        r103.I2(new SheetBaseDialog$cancelWithCloseType$1(this));
        return;
    L11:
        super.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f154354s == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L23;
        Window r102 = getWindow();
        if (r102 == null) goto L13;
        r102.addFlags(Integer.MIN_VALUE);
    L13:
        Window r103 = getWindow();
        if (r103 == null) goto L16;
        r103.clearFlags(67108864);
    L16:
        Window r104 = getWindow();
        if (r104 == null) goto L19;
        r104.setStatusBarColor(0);
    L19:
        Window r105 = getWindow();
        if (r105 == null) goto L24;
        r105.clearFlags(1024);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        if (this.f154355t == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f154344i == null) goto L36;
        boolean r101 = true;
        if (1 != r100.getAction()) goto L36;
        Context r102 = getContext();
        int r103 = (int) r100.getX();
        int r104 = (int) r100.getY();
        int r105 = ViewConfiguration.get(r102).getScaledWindowTouchSlop();
        if (getWindow() == null) goto L27;
        Window r106 = getWindow();
        if (r106 == null) goto L16;
        View r107 = r106.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L17;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r108 = ThreadMethodProxy.currentThread();
        if (r108 == com.larus.home.impl.utils.c.f346341a) goto L17;
        com.larus.home.impl.utils.c.a(r108, "getDecorView");
    L17:
        if (r107 == null) goto L27;
        int r109 = -r105;
        if (r103 < r109) goto L27;
        if (r104 < r109) goto L27;
        if (r103 > (r107.getWidth() + r105)) goto L27;
        if (r104 > (r107.getHeight() + r105)) goto L27;
        r101 = false;
        goto L27
    L16:
        r107 = null;
    L27:
        if (r101 == false) goto L36;
        com.bytedance.android.livesdk.pannel.d r110 = this.f154344i;
        if (r110 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        shouldWindowCloseOnTouchOutside();
        r110.a();
        com.bytedance.android.livesdk.pannel.d r111 = this.f154344i;
        if (r111 != null) goto L34;
        Intrinsics.throwNpe();
    L34:
        r111.b(shouldWindowCloseOnTouchOutside(), CloseType.MaskClick);
    L36:
        return super.onTouchEvent(r100);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.f154337b == r100) goto L10;
        this.f154337b = r100;
        SheetBaseBehavior<?> r101 = this.f154336a;
        if (r101 == null) goto L11;
        if (r101 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        r101.f154331a = r100;
        return;
    L11:
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.f154339d = r100;
        this.f154340e = true;
        View r101 = this.f154350o;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r100 == true) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
        r101.setImportantForAccessibility(1);
        r101.setFocusable(true);
        return;
    L17:
        r101.setImportantForAccessibility(2);
        r101.setFocusable(false);
        return;
    L12:
        if (this.f154349n == true) goto L14;
        r102 = true;
        goto L15
    L5:
        if (this.f154337b == true) goto L7;
        this.f154337b = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100) {
        super.setContentView(wrapInBottomSheet(0, r100, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int r100) {
        super.setContentView(wrapInBottomSheet(r100, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
        super.setContentView(wrapInBottomSheet(0, r100, r101));
    }

    private final View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r110) {
        if (this.f154354s == false) goto L6;
        View r102 = View.inflate(getContext(), com.larus.nova.R.layout.ttlive_standard_design_right_sheet_dialog_hd, null);
    L9:
        CoordinatorLayout r103 = (CoordinatorLayout) r102.findViewById(com.larus.nova.R.id.ttlive_coordinator);
        if (r100 == 0) goto L13;
        if (r101 != null) goto L13;
        r101 = getLayoutInflater().inflate(r100, r103, false);
    L13:
        RadiusLayout r104 = (RadiusLayout) r103.findViewById(com.larus.nova.R.id.ttlive_design_bottom_sheet);
        this.f154348m = r104;
        if (this.f154354s == false) goto L20;
        if (r104 == null) goto L17;
        r104.setRoundDp(8);
    L17:
        RadiusLayout r105 = this.f154348m;
        if (r105 == null) goto L20;
        r105.setMaxHeight((int) pn2.c.a(getContext(), 700));
    L20:
        int r106 = SheetBaseBehavior.f154330f;
        RadiusLayout r107 = this.f154348m;
        if (r107 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof CoordinatorLayout.LayoutParams) == false) goto L96;
        CoordinatorLayout.Behavior r109 = ((CoordinatorLayout.LayoutParams) r108).getBehavior();
        if ((r109 instanceof SheetBaseBehavior) == false) goto L94;
        SheetBaseBehavior<?> r111 = (SheetBaseBehavior) r109;
        this.f154336a = r111;
        if (r111 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        r111.f154332b = this.f154352q;
        SheetBaseBehavior<?> r112 = this.f154336a;
        if (r112 != null) goto L33;
        Intrinsics.throwNpe();
    L33:
        r112.f154331a = this.f154337b;
        boolean r113 = true;
        if (this.f154346k == false) goto L42;
        SheetBaseBehavior<?> r114 = this.f154336a;
        if (r114 != null) goto L38;
        Intrinsics.throwNpe();
    L38:
        r114.setPeekHeight(this.f154347l);
        SheetBaseBehavior<?> r115 = this.f154336a;
        if (r115 != null) goto L41;
        Intrinsics.throwNpe();
    L41:
        r115.f154333c = false;
    L46:
        SheetBaseBehavior<?> r116 = this.f154336a;
        if (r116 != null) goto L49;
        Intrinsics.throwNpe();
    L49:
        r116.f154334d = this.f154342g;
        SheetBaseBehavior<?> r117 = this.f154336a;
        if (r117 != null) goto L52;
        Intrinsics.throwNpe();
    L52:
        r117.f154335e = this.f154343h;
        if (r110 != null) goto L72;
        if (r101 != null) goto L57;
        Intrinsics.throwNpe();
    L57:
        if (r101.getLayoutParams() == null) goto L62;
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(r101.getLayoutParams());
        r118.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        RadiusLayout r119 = this.f154348m;
        if (r119 != null) goto L61;
        Intrinsics.throwNpe();
    L61:
        r119.addView(r101, r118);
    L76:
        M0(this.f154348m);
        View r120 = r103.findViewById(com.larus.nova.R.id.ttlive_touch_outside);
        r120.setOnClickListener(new e(this));
        this.f154350o = r120;
        RadiusLayout r121 = this.f154348m;
        if (r121 != null) goto L79;
        Intrinsics.throwNpe();
    L79:
        ViewCompat.setAccessibilityDelegate(r121, new AnonymousClass4(this));
        RadiusLayout r122 = this.f154348m;
        if (r122 != null) goto L82;
        Intrinsics.throwNpe();
    L82:
        r122.setOnTouchListener(f.f154360a);
        if (this.f154354s == false) goto L85;
    L88:
        if (r113 == false) goto L92;
        r102.setFitsSystemWindows(false);
        r103.setFitsSystemWindows(false);
        RadiusLayout r123 = this.f154348m;
        if (r123 == null) goto L92;
        r123.setFitsSystemWindows(false);
    L92:
        return r102;
    L85:
        if (this.f154355t == true) goto L88;
        r113 = false;
        goto L88
    L62:
        Window r124 = getWindow();
        if (r124 == null) goto L68;
        WindowManager.LayoutParams r125 = r124.getAttributes();
        RadiusLayout r126 = this.f154348m;
        if (r126 != null) goto L67;
        Intrinsics.throwNpe();
    L67:
        r126.addView(r101, new FrameLayout.LayoutParams(r125.width, r125.height, r125.gravity));
        goto L76
    L68:
        RadiusLayout r127 = this.f154348m;
        if (r127 != null) goto L71;
        Intrinsics.throwNpe();
    L71:
        r127.addView(r101);
        goto L76
    L72:
        RadiusLayout r128 = this.f154348m;
        if (r128 != null) goto L75;
        Intrinsics.throwNpe();
    L75:
        r128.addView(r101, r110);
        goto L76
    L42:
        SheetBaseBehavior<?> r129 = this.f154336a;
        if (r129 != null) goto L45;
        Intrinsics.throwNpe();
    L45:
        r129.f154333c = true;
        goto L46
    L94:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L96:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    L6:
        if (this.f154353r == false) goto L8;
        r102 = View.inflate(getContext(), com.larus.nova.R.layout.ttlive_standard_design_right_sheet_dialog, null);
        goto L9
    L8:
        r102 = View.inflate(getContext(), com.larus.nova.R.layout.ttlive_standard_design_bottom_sheet_dialog, null);
        goto L9
    }

    public SheetBaseDialog(Context r100, boolean r101, boolean r102, boolean r103) {
        if (((Boolean) SettingUtil.getValue("", "live_panel_enable_appcompattheme", Boolean.TYPE, Boolean.TRUE)).booleanValue() == false) goto L10;
        r100.getClass();
        int r104 = pn2.b.f529958a;
        if (r102 == false) goto L7;
        int r105 = com.larus.nova.R.style.ttlive_standard_dialog_hd_theme;
    L16:
        super(r100, r105);
        this.f154353r = r101;
        this.f154354s = r102;
        this.f154355t = r103;
        this.f154337b = true;
        this.f154338c = true;
        this.f154339d = true;
        this.f154342g = new c(this);
        this.f154343h = new b(this);
        this.f154347l = (int) pn2.c.a(r100, 484);
        on2.a.f524333c.getClass();
        this.f154351p = new on2.a(r100.getResources().getColor(com.larus.nova.R.color.ttlive_dialog_standard_bg), (int) pn2.c.a(r100, 8));
        this.f154352q = new d(this);
        return;
    L7:
        if (r101 == false) goto L9;
        r105 = com.larus.nova.R.style.ttlive_standard_dialog_right_theme;
        goto L16
    L9:
        r105 = com.larus.nova.R.style.ttlive_standard_dialog_bottom_theme;
        goto L16
    L10:
        r100.getClass();
        int r106 = pn2.b.f529958a;
        if (r102 == false) goto L13;
        r105 = com.larus.nova.R.style.ttlive_standard_dialog_hd_theme_appcompat;
        goto L16
    L13:
        if (r101 == false) goto L15;
        r105 = com.larus.nova.R.style.ttlive_standard_dialog_right_theme_appcompat;
        goto L16
    L15:
        r105 = com.larus.nova.R.style.ttlive_standard_dialog_bottom_theme_appcompat;
        goto L16
    }
}
