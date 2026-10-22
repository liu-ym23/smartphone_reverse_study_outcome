package com.bytedance.ai.debugscene;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.ai.debug.NativeDebugPanelType;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f36532a = null;

    public static final class a implements j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f36533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NativeDebugPanelType f36534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f36535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final k0 f36536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function0<Unit> f36537e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function0<Unit> f36538f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicBoolean f36539g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Handler f36540h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final BottomSheetDialog f36541i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final LinearLayout f36542j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final FrameLayout f36543k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final ProgressBar f36544l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final View f36545m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public LynxView f36546n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public volatile boolean f36547o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f36548p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f36549q;

        @Override // com.bytedance.ai.debugscene.j0
        public final void close() {
            if (this.f36539g.get() == false) goto L5;
            return;
        L5:
            Window r100 = this.f36541i.getWindow();
            if (r100 == null) goto L12;
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L14;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L14:
            if (this.f36541i.isShowing() == false) goto L30;
            if (r101 == null) goto L19;
            boolean r103 = true;
            if (r101.isAttachedToWindow() != true) goto L19;
        L20:
            if (r103 == false) goto L30;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L24
            c(this.f36541i);     // Catch: Throwable -> L24
            Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L34;
            com.bytedance.ai.utils.g.f37637a.w("AIDebugPanelPopupLauncher", "dismiss panel failed, fallback to release, type:" + this.f36534b + ", error:" + r106.getMessage());
            f();
            return;
        L34:
            return;
        L24:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L19:
            r103 = false;
        L30:
            com.bytedance.ai.utils.g.f37637a.i("AIDebugPanelPopupLauncher", "release panel directly because dialog window is detached, type:" + this.f36534b);
            f();
            return;
        L12:
            r101 = null;
            goto L14
        }

        /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.ai.debugscene.o0, java.lang.Object] */
        public final void e() {
            if (this.f36539g.get() == false) goto L5;
            return;
        L5:
            final int r100 = this.f36549q + 1;
            this.f36549q = r100;
            this.f36547o = false;
            this.f36544l.setVisibility(0);
            this.f36545m.setVisibility(8);
            LynxView r101 = this.f36546n;
            if (r101 == null) goto L8;
            this.f36543k.removeView(r101);
            r101.destroy();
        L8:
            this.f36546n = null;
            int r102 = b0.f36313a;
            NativeDebugPanelType r103 = this.f36534b;
            Intrinsics.checkNotNullParameter(r103, "type");
            int r104 = b0.a.f36314a[r103.ordinal()];
            if (r104 != 1) goto L11;
            final String r105 = "builtin://debugInstancePanel/template.js";
        L16:
            ExecutorService r106 = z0.f36569a;
            final Context r107 = this.f36533a.getApplicationContext();
            final ?? r108 = new o0(this, r100, r105);
            Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r105, "url");
            Intrinsics.checkNotNullParameter(r108, "callback");
            z0.f36569a.execute(new y0(r108, r105, r107));
            return;
        L11:
            if (r104 != 2) goto L14;
            r105 = "builtin://agentTracePanel/template.js";
            goto L16
        L14:
            throw new NoWhenBranchMatchedException();
        }

        public final void f() {
            if (this.f36539g.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f36549q++;
            this.f36547o = false;
            LynxView r100 = this.f36546n;
            if (r100 == null) goto L8;
            r100.destroy();
        L8:
            this.f36546n = null;
            this.f36543k.removeAllViews();
            com.bytedance.ai.utils.g.f37637a.i("AIDebugPanelPopupLauncher", "release raw Lynx panel, type:" + this.f36534b);
            this.f36538f.invoke();
        }

        public final void i() {
            Resources r100 = this.f36533a.getResources();
            float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).heightPixels;
            int r102 = (int) (0.9f * r101);
            int r103 = (int) (r101 * 0.6f);
            this.f36542j.setOrientation(1);
            LinearLayout r104 = this.f36542j;
            GradientDrawable r105 = new GradientDrawable();
            r105.setColor(-1);
            r105.setCornerRadii(new float[]{d(16.0f), d(16.0f), d(16.0f), d(16.0f), 0.0f, 0.0f, 0.0f, 0.0f});
            r104.setBackground(r105);
            LinearLayout r106 = this.f36542j;
            FrameLayout r107 = new FrameLayout(this.f36533a);
            View r108 = new View(this.f36533a);
            GradientDrawable r110 = new GradientDrawable();
            r110.setShape(0);
            r110.setCornerRadius(d(2.0f));
            r110.setColor(Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 199, 204));
            r108.setBackground(r110);
            r107.addView(r108, new FrameLayout.LayoutParams((int) d(36.0f), (int) d(4.0f), 17));
            r106.addView(r107, new LinearLayout.LayoutParams(-1, (int) d(12.0f)));
            this.f36542j.addView(this.f36543k, new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f36543k.addView(this.f36544l, new FrameLayout.LayoutParams(-2, -2, 17));
            this.f36543k.addView(this.f36545m, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout r109 = this.f36543k;
            FrameLayout r111 = new FrameLayout(this.f36533a);
            r111.setContentDescription(this.f36533a.getString(R.string.debug_scene_panel_close));
            r111.setClickable(true);
            r111.setOnClickListener(new p0(this));
            ImageView r112 = new ImageView(this.f36533a);
            GradientDrawable r113 = new GradientDrawable();
            r113.setShape(1);
            r113.setColor(Color.rgb(242, 243, 245));
            r112.setBackground(r113);
            r112.setScaleType(ImageView.ScaleType.CENTER);
            r112.setImageResource(R.drawable.ic_applet_close);
            r111.addView(r112, new FrameLayout.LayoutParams((int) d(36.0f), (int) d(36.0f), 17));
            FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams((int) d(44.0f), (int) d(44.0f), 8388661);
            r114.setMarginEnd((int) d(8.0f));
            r109.addView(r111, r114);
            this.f36545m.setVisibility(8);
            this.f36541i.setContentView(this.f36542j, new ViewGroup.LayoutParams(-1, r102));
            this.f36541i.setCancelable(true);
            this.f36541i.setCanceledOnTouchOutside(false);
            this.f36541i.setOnDismissListener(new l0(this));
            BottomSheetDialog r115 = this.f36541i;
            if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L14;
            DialogLancet.handleBlockedDialogShow(r115);
        L7:
            View r116 = this.f36541i.findViewById(R.id.design_bottom_sheet);
            if (r116 == null) goto L12;
            r116.getLayoutParams().height = r102;
            r116.setBackground(null);
            BottomSheetBehavior r117 = BottomSheetBehavior.from(r116);
            r117.setPeekHeight(r103);
            r117.setHideable(true);
            r117.setSkipCollapsed(false);
            r117.setState(4);
            r117.setBottomSheetCallback(new v0(this));
            e();
            com.bytedance.ai.utils.g.f37637a.i("AIDebugPanelPopupLauncher", "show raw Lynx panel, type:" + this.f36534b);
            return;
        L12:
            throw new IllegalStateException("Material bottom sheet view is unavailable".toString());
        L14:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L6:
            DialogLancet.beforeDialogShow(r115);
            r115.show();
            DialogLancet.afterDialogShow(r115);
            goto L7
        }

        public static void c(BottomSheetDialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L17;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        @Override // com.bytedance.ai.debugscene.j0
        public final boolean a(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (this.f36533a != r100) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.ai.debugscene.j0
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "launchParamsJson");
            if (this.f36547o == true) goto L6;
            this.f36548p = r100;
            return;
        L6:
            h(r100);
        }

        public final float d(float r100) {
            Resources r101 = this.f36533a.getResources();
            return r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        }

        public final void h(String r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
            LynxView r102 = this.f36546n;     // Catch: Throwable -> L8
            if (r102 == null) goto L5;
            r102.sendGlobalEvent("panel.launchParamsChanged", JavaOnlyArray.of(new Object[]{r100}));     // Catch: Throwable -> L8
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
        L6:
            Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
        L10:
            Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
            if (r105 == null) goto L16;
            com.bytedance.ai.utils.g.f37637a.e("AIDebugPanelPopupLauncher", "send panel params event failed, type:" + this.f36534b + ", error:" + r105.getMessage());
            return;
        L16:
            return;
        L5:
            r103 = null;
        L8:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        public final void j(Throwable r100) {
            this.f36547o = false;
            this.f36544l.setVisibility(8);
            this.f36545m.setVisibility(0);
            com.bytedance.ai.utils.g.f37637a.e("AIDebugPanelPopupLauncher", "render panel template failed, type:" + this.f36534b + ", error:" + r100.getMessage());
        }

        public final boolean g(String r100, String r110) {
            if (this.f36539g.get() == false) goto L5;
        L22:
            return false;
        L5:
            if (this.f36547o == false) goto L22;
            LynxView r101 = this.f36546n;
            if (r101 != null) goto L23;
            return false;
        L23:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
            r101.sendGlobalEvent(r100, JavaOnlyArray.of(new Object[]{r110}));     // Catch: Throwable -> L12
            com.bytedance.ai.utils.g.f37637a.d("AIDebugPanelPopupLauncher", "send panel event, type:" + this.f36534b + ", eventName:" + r100 + ", paramsLength:" + r110.length());     // Catch: Throwable -> L12
            Object r103 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L12
        L14:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L17;
            com.bytedance.ai.utils.g.f37637a.e("AIDebugPanelPopupLauncher", "send panel event failed, type:" + this.f36534b + ", eventName:" + r100 + ", paramsLength:" + r110.length() + ", error:" + r104.getMessage());
        L17:
            Boolean r105 = Boolean.FALSE;
            if (Result.m9455isFailureimpl(r103) == false) goto L21;
            r103 = r105;
        L21:
            return ((Boolean) r103).booleanValue();
        L12:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }

        @Override // com.bytedance.ai.debugscene.j0
        public final boolean sendEvent(final String r100, final String r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "paramsJson");
            if (this.f36539g.get() == false) goto L5;
        L13:
            com.bytedance.ai.utils.g.f37637a.w("AIDebugPanelPopupLauncher", "send panel event rejected, type:" + this.f36534b + ", eventName:" + r100 + ", loaded:" + this.f36547o + ", released:" + this.f36539g.get() + ", paramsLength:" + r101.length());
            return false;
        L5:
            if (this.f36547o == false) goto L13;
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
            this.f36533a.runOnUiThread(new m0(this, r100, r101));
            return true;
        L10:
            return g(r100, r101);
        }

        public a(Activity r100, NativeDebugPanelType r101, String r102, f0.b r103, d0 r104, e0 r105) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r102, "initialLaunchParamsJson");
            Intrinsics.checkNotNullParameter(r103, "messageDispatcher");
            Intrinsics.checkNotNullParameter(r104, "onLoaded");
            Intrinsics.checkNotNullParameter(r105, "onDismiss");
            this.f36533a = r100;
            this.f36534b = r101;
            this.f36535c = r102;
            this.f36536d = r103;
            this.f36537e = r104;
            this.f36538f = r105;
            this.f36539g = new AtomicBoolean(false);
            this.f36540h = new Handler(Looper.getMainLooper());
            this.f36541i = new BottomSheetDialog(r100);
            this.f36542j = new LinearLayout(r100);
            this.f36543k = new FrameLayout(r100);
            this.f36544l = new ProgressBar(r100);
            LinearLayout r106 = new LinearLayout(r100);
            r106.setOrientation(1);
            r106.setGravity(17);
            r106.setBackgroundColor(-1);
            TextView r107 = new TextView(r100);
            r107.setText(r100.getString(R.string.debug_scene_panel_load_failed));
            r107.setTextSize(16.0f);
            r107.setGravity(17);
            r107.setTextAlignment(4);
            r107.setTextColor(FakePickerAvatarCreator.DKGRAY);
            r106.addView(r107);
            TextView r108 = new TextView(r100);
            r108.setText(r100.getString(R.string.debug_scene_panel_retry));
            r108.setTextSize(16.0f);
            r108.setGravity(17);
            r108.setTextColor(-1);
            GradientDrawable r109 = new GradientDrawable();
            r109.setCornerRadius(d(8.0f));
            r109.setColor(Color.rgb(22, 100, 255));
            r108.setBackground(r109);
            r108.setOnClickListener(new n0(this));
            LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams((int) d(80.0f), (int) d(36.0f));
            r110.gravity = 1;
            r110.topMargin = (int) d(12.0f);
            Unit r111 = Unit.INSTANCE;
            r106.addView(r108, r110);
            this.f36545m = r106;
        }
    }

    static {
        f36532a = new w0();
    }

    public w0() {
    }

    public static j0 a(Activity r110, NativeDebugPanelType r111, String r112, f0.b r113, d0 r114, e0 r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "launchParamsJson");
        Intrinsics.checkNotNullParameter(r113, "messageDispatcher");
        Intrinsics.checkNotNullParameter(r114, "onLoaded");
        Intrinsics.checkNotNullParameter(r115, "onDismiss");
        Object r100 = null;
        if (r110.isFinishing() == false) goto L5;
    L21:
        com.bytedance.ai.utils.g.f37637a.e("AIDebugPanelPopupLauncher", "show panel failed because host Activity is unavailable");
        return null;
    L5:
        if (r110.isDestroyed() == true) goto L21;
        a r101 = new a(r110, r111, r112, r113, r114, r115);
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L10
        r101.i();     // Catch: Throwable -> L10
        Object r117 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L10
    L12:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L16;
        r101.f();
        com.bytedance.ai.utils.g.f37637a.e("AIDebugPanelPopupLauncher", "show panel failed, type:" + r111 + ", error:" + r118.getMessage());
    L16:
        if (Result.m9455isFailureimpl(r117) == true) goto L20;
        r100 = r117;
    L20:
        return (j0) r100;
    L10:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
