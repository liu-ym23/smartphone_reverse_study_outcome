package com.bytedance.android.ec.opt.prerender;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/opt/prerender/PrerenderDialog;", "Landroidx/appcompat/app/AppCompatDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class PrerenderDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f48067r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f48068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f48069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f48070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f48071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f48072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f48073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f48074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f48075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f48076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f48077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f48078k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f48079l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f48080m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f48081n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f48082o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f48083p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f48084q;

    public static final class a {
    }

    public interface b {
        void Tl();

        void ue();
    }

    public interface c {
        void Oj();
    }

    public interface d {
        void P90();

        void eN();

        void fg();
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f48086a = null;

        static {
            f48086a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    static {
    }

    public final void M0() {
        this.f48075h = 2;
        I0(this);
        super.hide();
    }

    public final void L0() {
        Runnable r100 = this.f48072e;
        if (r100 == null) goto L5;
        this.f48068a.removeCallbacks(r100);
    L5:
        this.f48072e = null;
        Runnable r101 = this.f48073f;
        if (r101 == null) goto L8;
        this.f48068a.removeCallbacks(r101);
    L8:
        this.f48073f = null;
        this.f48074g = null;
        this.f48071d = false;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.f48075h != 3) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        L0();
        this.f48075h = 3;
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(this);
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r102 == null) goto L22;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L11:
        if (Looper.myLooper() == r101.getLooper()) goto L13;
        r101.post(DialogLancet.createDismissRunnable(this));
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // android.app.Dialog
    public final void hide() {
        if (this.f48071d == false) goto L7;
        this.f48074g = 2;
        return;
    L7:
        if (isShowing() == false) goto L26;
        this.f48075h = 2;
        if (this.f48078k != (-1)) goto L17;
        super.hide();
        b r100 = this.f48080m;
        if (r100 == null) goto L13;
        r100.Tl();
    L13:
        b r101 = this.f48080m;
        if (r101 == null) goto L27;
        r101.ue();
        return;
    L27:
        return;
    L17:
        if (this.f48071d == true) goto L29;
        this.f48071d = true;
        super.hide();
        b r102 = this.f48080m;
        if (r102 == null) goto L21;
        r102.Tl();
    L21:
        Runnable r103 = this.f48073f;
        if (r103 == null) goto L24;
        this.f48068a.removeCallbacks(r103);
    L24:
        com.bytedance.android.ec.opt.prerender.a r104 = new com.bytedance.android.ec.opt.prerender.a(this);
        this.f48073f = r104;
        this.f48068a.postDelayed(r104, this.f48079l);
        return;
    L29:
        return;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        if (this.f48075h == 1) goto L5;
    L7:
        return false;
    L5:
        if (super.isShowing() == false) goto L7;
        return true;
    }

    @Override // android.app.Dialog
    public final void show() {
        boolean r100 = this.f48071d;
        if (r100 == false) goto L6;
        this.f48074g = 1;
        return;
    L6:
        int r101 = this.f48075h;
        boolean r102 = false;
        if (r101 != 2) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L17:
        this.f48075h = 1;
        if (this.f48078k != (-1)) goto L28;
        d r104 = this.f48081n;
        if (r104 == null) goto L22;
        r104.eN();
    L22:
        I0(this);
        d r105 = this.f48081n;
        if (r105 == null) goto L25;
        r105.fg();
    L25:
        d r106 = this.f48081n;
        if (r106 == null) goto L37;
        r106.P90();
        return;
    L37:
        return;
    L28:
        if (r100 == true) goto L39;
        this.f48071d = true;
        d r107 = this.f48081n;
        if (r107 == null) goto L32;
        r107.eN();
    L32:
        I0(this);
        d r108 = this.f48081n;
        if (r108 == null) goto L35;
        r108.fg();
    L35:
        com.bytedance.android.ec.opt.prerender.b r109 = new com.bytedance.android.ec.opt.prerender.b(this);
        this.f48072e = r109;
        this.f48068a.postDelayed(r109, this.f48079l);
        return;
    L39:
        return;
    L12:
        if (r101 != 3) goto L14;
        r102 = true;
    L14:
        if (r102 == true) goto L17;
        return;
    L9:
        r103 = false;
        goto L10
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        if (this.f48077j == false) goto L7;
        hide();
        return;
    L7:
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r101 == null) goto L21;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L10:
        if (Looper.myLooper() == r100.getLooper()) goto L12;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    public static void I0(AppCompatDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        super.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final void J0(PrerenderDialog r100) {
        Integer r101 = r100.f48074g;
        r100.f48074g = null;
        if (r101 != null) goto L6;
    L12:
        if (r101 != null) goto L15;
        return;
    L15:
        if (r101.intValue() != 2) goto L23;
        r100.hide();
        return;
    L23:
        return;
    L6:
        if (r101.intValue() != 1) goto L12;
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L11:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if (this.f48084q == false) goto L5;
    L9:
        r110.setOnClickListener(e.f48086a);
        int r100 = getContext().getResources().getDimensionPixelSize(getContext().getResources().getIdentifier("status_bar_height", "dimen", "android"));     // Catch: Error -> L12
    L13:
        ((FrameLayout) this.f48069b.getValue()).addView(r110, new FrameLayout.LayoutParams(-1, this.f48070c, 80));
        setCancelable(false);
        Window r101 = getWindow();
        if (r101 != null) goto L16;
        return;
    L16:
        if (this.f48083p != 0) goto L18;
        Resources r102 = getContext().getResources();
        r101.setContentView((FrameLayout) this.f48069b.getValue(), new ViewGroup.LayoutParams(-1, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).heightPixels - r100));
        r101.setLayout(-1, -2);
    L63:
        r101.setGravity(80);
        View r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L68;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L68;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L68:
        r103.setPadding(0, 0, 0, 0);
        r101.setBackgroundDrawableResource(R.color.transparent);
        r101.setSoftInputMode(48);
        int r111 = this.f48078k;
        if (r111 == (-1)) goto L75;
        r101.setWindowAnimations(r111);
        return;
    L75:
        return;
    L18:
        if (this.f48084q == false) goto L20;
        r101.setContentView((FrameLayout) this.f48069b.getValue(), new ViewGroup.LayoutParams(-1, -1));
        goto L63
    L20:
        Context r105 = getContext();
        ECDisplayUtils.ScreenType r106 = ECDisplayUtils.f48064a;
        ECDisplayUtils.ScreenType r107 = ECDisplayUtils.ScreenType.UNKNOWN;
        char r108 = 1;
        if (r106 == r107) goto L26;
        if (ECDisplayUtils.f48064a == ECDisplayUtils.ScreenType.FULL_SCREEN) goto L45;
    L46:
        boolean r109 = false;
    L47:
        if (r109 == true) goto L49;
        int r112 = ECDisplayUtils.a(r105);
    L61:
        r101.setLayout(-1, r112 - r100);
        r101.setContentView((FrameLayout) this.f48069b.getValue(), new ViewGroup.LayoutParams(-1, -1));
        goto L63
    L49:
        if (r105 != null) goto L51;
        r112 = ECDisplayUtils.a(r105);
        goto L61
    L51:
        if (r105.getResources().getConfiguration().orientation != 1) goto L54;
        r108 = 0;
    L54:
        if (ECDisplayUtils.f48065b[r108] != null) goto L59;
        WindowManager r113 = (WindowManager) r105.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r113 != null) goto L58;
        r112 = ECDisplayUtils.a(r105);
        goto L61
    L58:
        Display r114 = r113.getDefaultDisplay();
        Point r115 = new Point();
        r114.getRealSize(r115);
        ECDisplayUtils.f48065b[r108] = r115;
    L59:
        r112 = ECDisplayUtils.f48065b[r108].y;
    L45:
        r109 = true;
        goto L47
    L26:
        if (Build.VERSION.SDK_INT <= 21) goto L41;
        if (r105 == null) goto L29;
        WindowManager r116 = (WindowManager) r105.getSystemService(LiveEndPageData.TAG_WINDOW);
    L30:
        if (r116 == null) goto L41;
        Display r117 = r116.getDefaultDisplay();
        Point r118 = new Point();
        r117.getRealSize(r118);
        int r119 = r118.x;
        int r120 = r118.y;
        if (r119 >= r120) goto L34;
        float r121 = r119;
        float r122 = r120;
    L36:
        if ((r122 / r121) < 1.97f) goto L38;
        ECDisplayUtils.ScreenType r123 = ECDisplayUtils.ScreenType.FULL_SCREEN;
    L39:
        ECDisplayUtils.f48064a = r123;
        goto L41
    L38:
        r123 = ECDisplayUtils.ScreenType.NORMAL_SCREEN;
        goto L39
    L34:
        float r124 = r120;
        r122 = r119;
        r121 = r124;
        goto L36
    L29:
        r116 = null;
    L41:
        if (ECDisplayUtils.f48064a != r107) goto L44;
        ECDisplayUtils.f48064a = ECDisplayUtils.ScreenType.NORMAL_SCREEN;
    L44:
        if (ECDisplayUtils.f48064a != ECDisplayUtils.ScreenType.FULL_SCREEN) goto L46;
    L12:
        r100 = 48;
        goto L13
    L5:
        if (this.f48070c > 0) goto L9;
        throw new Exception("[Django] >> content height is 0");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    @Deprecated(message = "AsyncInflate", replaceWith = @ReplaceWith(expression = "setContentView(view: View)", imports = {}))
    public final void setContentView(int r100) {
        throw new Exception("请使用 setContentView(view: View)，在外部使用 AsyncInflate 初始化布局。");
    }

    public PrerenderDialog(final Context r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f48083p = r101;
        this.f48084q = r102;
        this.f48068a = new Handler(Looper.getMainLooper());
        int r103 = xl.a.f564431a;
        this.f48069b = LazyKt.lazy(new PrerenderDialog$container$2(this, r100));
        this.f48075h = 3;
        this.f48078k = -1;
        this.f48079l = 300;
    }
}
