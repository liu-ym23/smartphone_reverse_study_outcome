package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.utils.k4;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/widget/LiveStandardSheetDialog;", "Lcom/bytedance/android/livesdk/pannel/SheetBaseDialog;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveStandardSheetDialog extends SheetBaseDialog {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f161089u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f161090v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f161091w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f161092x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f161093y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f161094z;

    public static final class a implements com.bytedance.android.livesdk.pannel.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog.m f161095a;

        @Override // com.bytedance.android.livesdk.pannel.f
        public final boolean a(MotionEvent r100) {
            return false;
        }

        @Override // com.bytedance.android.livesdk.pannel.f
        public final boolean disableDragDown() {
            return this.f161095a.disableDragDown();
        }

        public a(LiveBottomSheetDialog.m r100) {
            this.f161095a = r100;
        }

        @Override // com.bytedance.android.livesdk.pannel.f
        public final boolean shouldInterceptSlide(int r100) {
            return this.f161095a.shouldInterceptSlide(r100);
        }
    }

    public final boolean Q0() {
        if (j40.p0.f497279a.getValue().booleanValue() == false) goto L13;
        Configuration r100 = com.bytedance.android.live.core.utils.s1.getResources().getConfiguration();
        if (FoldScreenUtils.f() == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L13;
        return true;
    L7:
        if (FoldScreenUtils.b(com.bytedance.android.live.core.utils.s1.getContext(), r100) != 0) goto L9;
        r101 = true;
    L13:
        if (this.f154354s == false) goto L18;
        if (((Boolean) this.f161089u.getValue()).booleanValue() == false) goto L18;
    L19:
        return true;
    L18:
        if (this.f161093y == true) goto L19;
        return false;
    }

    public final void R0() {
        if (this.f154353r == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L15;
        View r101 = findViewById(R.id.ttlive_bottom_sheet_container);
        View r102 = findViewById(R.id.ttlive_coordinator);
        if (r101 == null) goto L12;
        r101.setFitsSystemWindows(false);
    L12:
        if (r102 == null) goto L16;
        r102.setFitsSystemWindows(false);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (PadConfigUtils.c() == true) goto L7;
        r100 = true;
        goto L8
    }

    public final void T0() {
        View r100 = this.f161090v;
        Integer r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof CoordinatorLayout.LayoutParams) == true) goto L9;
        r102 = null;
    L9:
        CoordinatorLayout.LayoutParams r103 = (CoordinatorLayout.LayoutParams) r102;
        if (r103 == null) goto L23;
        Rect r104 = k4.c(getContext());
        if (this.f161093y == false) goto L16;
        if (r104 == null) goto L16;
        r101 = Integer.valueOf(r104.width());
    L16:
        if (r101 == null) goto L18;
        int r105 = r101.intValue();
    L19:
        ((ViewGroup.MarginLayoutParams) r103).width = r105;
        ((ViewGroup.MarginLayoutParams) r103).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r103).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = 0;
        r103.setAnchorId(-1);
        r103.anchorGravity = 0;
        View r106 = this.f161090v;
        if (r106 == null) goto L24;
        r106.requestLayout();
        return;
    L24:
        return;
    L18:
        r105 = -1;
        goto L19
    L23:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void U0() {
        View r100 = this.f161090v;
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof CoordinatorLayout.LayoutParams) == false) goto L10;
        r101 = r102;
    L10:
        CoordinatorLayout.LayoutParams r103 = (CoordinatorLayout.LayoutParams) r101;
        if (r103 != null) goto L13;
        return;
    L13:
        if (this.f161094z == false) goto L15;
        int r104 = -2;
    L16:
        ((ViewGroup.MarginLayoutParams) r103).width = r104;
        ((ViewGroup.MarginLayoutParams) r103).topMargin = P0(20);
        ((ViewGroup.MarginLayoutParams) r103).rightMargin = P0(20);
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = P0(20);
        r103.setAnchorId(R.id.ttlive_touch_outside);
        r103.anchorGravity = 85;
        View r105 = this.f161090v;
        if (r105 == null) goto L21;
        r105.requestLayout();
        return;
    L21:
        return;
    L15:
        r104 = P0(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        goto L16
    L5:
        r102 = null;
        goto L7
    }

    public final void O0() {
        if (Q0() == true) goto L5;
        return;
    L5:
        boolean r100 = S0();
        if (this.f161092x == r100) goto L18;
        this.f161092x = r100;
        if (r100 == false) goto L13;
        Window r101 = getWindow();
        if (r101 == null) goto L12;
        r101.setWindowAnimations(R.style.ttlive_standard_dialog_bottom_anim);
    L12:
        T0();
        return;
    L13:
        Window r102 = getWindow();
        if (r102 == null) goto L16;
        r102.setWindowAnimations(R.style.ttlive_standard_dialog_right_anim);
    L16:
        U0();
        return;
    }

    public final boolean S0() {
        if (Q0() == true) goto L5;
        return false;
    L5:
        Rect r100 = k4.c(getContext());
        if (r100 == null) goto L8;
        r100.width();
    L8:
        if (r100 == null) goto L10;
        r100.height();
    L10:
        Resources r101 = getContext().getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        Resources r103 = getContext().getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        if (r100 != null) goto L13;
        return false;
    L13:
        FoldScreenUtils.a();
        if (r100.width() > P0(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS))) goto L16;
    L19:
        return true;
    L16:
        if (FoldScreenUtils.a() == 1) goto L18;
        return false;
    L18:
        if (this.f161093y == true) goto L19;
        return false;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        SheetBaseDialog.I0(this);     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.livesdk.e.b().d();
        com.bytedance.android.livesdk.f.d().f();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.e.b().a();
        com.bytedance.android.livesdk.f.d().a();
        if (this.f154354s == true) goto L20;
        Context r100 = getContext();
        if (r100 == null) goto L20;
        Resources r101 = r100.getResources();
        if (r101 == null) goto L20;
        Configuration r102 = r101.getConfiguration();
        if (r102 == null) goto L20;
        if (r102.orientation != 2) goto L20;
        Window r103 = getWindow();
        if (r103 == null) goto L20;
        t8.d(r103);
    L20:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog
    public void M0(View r100) {
        if (this.f161094z == false) goto L9;
        if (r100 == null) goto L9;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L9;
        r101.width = -2;
    L9:
        if (Q0() == false) goto L23;
        if (r100 != null) goto L13;
    L15:
        this.f161091w = k4.e(getContext());
        O0();
        if ((r100 instanceof ViewGroup) == true) goto L18;
        r100 = null;
    L18:
        ViewGroup r102 = (ViewGroup) r100;
        if (r102 == null) goto L22;
        r102.addView(new g1(this, getContext()), 0, new ViewGroup.LayoutParams(0, 0));
        return;
    L22:
        return;
    L13:
        if (r100.getId() != R.id.ttlive_design_bottom_sheet) goto L15;
        this.f161090v = r100;
        goto L15
    }

    public final int P0(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
    L5:
        Resources r102 = getContext().getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    L4:
        r101 = 0;
        goto L5
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
    }

    @Deprecated(message = "用来兼容老版本的")
    public final void setBottomSheetSlideProcessor(LiveBottomSheetDialog.m r100) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheetSlideProcessor");
        com.bytedance.android.livesdk.pannel.c r101 = new com.bytedance.android.livesdk.pannel.c(this, new a(r100));
        this.f154342g = r101;
        SheetBaseBehavior<?> r102 = this.f154336a;
        if (r102 == null) goto L6;
        r102.f154334d = r101;
        return;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.setContentView(r100);
        R0();
        View r101 = findViewById(R.id.ttlive_touch_outside);
        if (r101 == null) goto L6;
        r3.c(r101, "关闭", true);
        return;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        super.setContentView(r100);
        R0();
        View r101 = findViewById(R.id.ttlive_touch_outside);
        if (r101 == null) goto L6;
        r3.c(r101, "关闭", true);
        return;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.setContentView(r100, r101);
        R0();
        View r102 = findViewById(R.id.ttlive_touch_outside);
        if (r102 == null) goto L6;
        r3.c(r102, "关闭", true);
        return;
    }

    public LiveStandardSheetDialog(Context r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (PadConfigUtils.c() == true) goto L7;
        if (r103 == true) goto L7;
        boolean r105 = false;
    L8:
        super(r100, r101, r105, r102);
        this.f161093y = r103;
        this.f161094z = r104;
        this.f161089u = LazyKt.lazy(LiveStandardSheetDialog$adaptPadMultiWinEnable$2.INSTANCE);
        this.f161091w = k4.e(r100);
        if (Q0() == false) goto L18;
        Window r106 = getWindow();
        if (r106 != null) goto L13;
        return;
    L13:
        if (S0() == false) goto L15;
        int r107 = R.style.ttlive_standard_dialog_bottom_anim;
    L16:
        r106.setWindowAnimations(r107);
        return;
    L15:
        r107 = R.style.ttlive_standard_dialog_right_anim;
        goto L16
    L18:
        return;
    L7:
        r105 = true;
        goto L8
    }

    public /* synthetic */ LiveStandardSheetDialog(Context r100, boolean r110, boolean r111, boolean r112, boolean r113, int r114) {
        if ((r114 & 4) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r114 & 8) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r114 & 16) == 0) goto L13;
        boolean r103 = false;
    L14:
        this(r100, r110, r101, r102, r103);
        return;
    L13:
        r103 = r113;
        goto L14
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
