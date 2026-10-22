package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel$initPanelAndHide$3;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.s;
import com.bytedance.android.live.broadcastgame.opengame.runtime.t;
import com.bytedance.android.live.broadcastgame.opengame.runtime.u;
import com.bytedance.android.live.broadcastgame.opengame.service.CommercialService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameService;
import com.bytedance.android.live.broadcastgame.opengame.view.PanelTopRightButtonView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.config.be0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPanel extends Dialog implements h, s<i> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f60630u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f60631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f60632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f60633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f60634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f60635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f60636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f60637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PanelTopRightButtonView f60638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f60639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f60640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f60641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f60642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ShowTipsHelper f60643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DialogInterface.OnDismissListener f60644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f60645o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnClickListener f60646p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PluginContext f60647q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f60648r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PanelType f60649s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final /* synthetic */ t<i> f60650t;

    public static final class a {
    }

    public interface b {
        void isLandscape();
    }

    public static final class c extends ViewOutlineProvider {
        public c() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r100 == null) goto L7;
            float r102 = s1.e(12.0f);
            Rect r103 = new Rect();
            r100.getGlobalVisibleRect(r103);
            Rect r104 = new Rect(0, 0, r103.right - r103.left, (int) ((r103.bottom - r103.top) + r102));
            if (r101 == null) goto L8;
            r101.setRoundRect(r104, r102);
            return;
        L8:
            return;
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenPanel f60651a;

        public d(OpenPanel r100) {
            this.f60651a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            this.f60651a.getClass();
            OpenPanel r101 = this.f60651a;
            i r102 = r101.f60650t.f60846b;
            if (r102 == null) goto L5;
            r102.b();
        L5:
            ((ArrayList) r101.f60650t.f60845a).clear();
            DialogInterface.OnDismissListener r103 = this.f60651a.f60644n;
            if (r103 == null) goto L8;
            r103.onDismiss(r100);
        L8:
            this.f60651a.f60643m.a();
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f60652a = null;

        static {
            f60652a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenPanel f60653a;

        public f(OpenPanel r100) {
            this.f60653a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ViewGroup r101 = this.f60653a.f60633c;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
        L5:
            r101.setVisibility(8);
            this.f60653a.h();
            View.OnClickListener r102 = this.f60653a.f60646p;
            if (r102 == null) goto L9;
            r102.onClick(r100);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void F() {
        if (be0.f119861a.getValue().booleanValue() == false) goto L7;
        Window r100 = getWindow();
        if (r100 == null) goto L10;
        r100.setLayout(-1, this.f60649s.getHeight());
    L10:
        Window r101 = getWindow();
        if (r101 == null) goto L13;
        r101.setBackgroundDrawable(new ColorDrawable());
    L13:
        V(true);
        return;
    L7:
        Window r102 = getWindow();
        if (r102 == null) goto L10;
        r102.setLayout(-1, -2);
        goto L10
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        i r100 = this.f60650t.f60846b;
        if (r100 == null) goto L6;
        r100.onPanelCancel();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final List<i> getListeners() {
        return this.f60650t.f60845a;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void h() {
        UtilityKotlinExtentionsKt.s(0, false, false, new OpenPanel$showDoubleBallLoading$1(this), 7);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final ViewGroup h0() {
        ViewGroup r100 = this.f60637g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L5:
        return r100;
    }

    @Override // android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void hide() {
        if (this.f60641k == false) goto L7;
        this.f60641k = false;
        this.f60643m.a();
        UtilityKotlinExtentionsKt.s(100, false, false, new OpenPanel$fakeHide$1(this), 6);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void i() {
        UtilityKotlinExtentionsKt.s(0, false, false, new OpenPanel$hideDoubleBallLoading$1(this), 7);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void init() {
        int r100 = q.f60744a;
        q.f("OpenPanel", new Object[]{"init panel"});
        create();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        i r100 = this.f60650t.f60846b;
        if (r100 == null) goto L6;
        r100.onBackPressed();
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        ValueAnimator r100 = this.f60642l;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final Context J() {
        return getContext();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void L0() {
        i();
        ViewGroup r100 = this.f60633c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
    L5:
        UtilityKotlinExtentionsKt.w(r100);
        TextView r101 = this.f60636f;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L8:
        UtilityKotlinExtentionsKt.w(r101);
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
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
    }

    @Override // android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final boolean isShowing() {
        if (super.isShowing() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f60641k == false) goto L7;
        return true;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        this.f60648r.isLandscape();
    }

    @Override // android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void show() {
        Window r100 = getWindow();
        if (r100 == null) goto L13;
        final WindowManager.LayoutParams r101 = r100.getAttributes();
        if (r101 == null) goto L13;
        r101.width = -1;
        View r102 = this.f60631a;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L9:
        Function0<Unit> r103 = new OpenPanel$show$$inlined$let$lambda$1(r101, this);
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L13;
        r103.invoke();
    L13:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(this);
    L18:
        if (this.f60641k == true) goto L21;
        this.f60641k = true;
        UtilityKotlinExtentionsKt.s(100, false, false, new OpenPanel$restoreFakeHide$1(this), 6);
    L21:
        this.f60643m.b();
        TrackMiniGameService.a r104 = TrackMiniGameService.f60990g;
        String r105 = String.valueOf(this.f60647q.f60809m.f61075a);
        PluginContext r106 = this.f60647q;
        boolean r107 = r106.f60811o;
        RoomContext r108 = RoomContext.a.c(RoomContext.Companion, r106.f60805i, 0, 2);
        if (r108 == null) goto L28;
        m<Room> r109 = r108.getRoom();
        if (r109 == null) goto L28;
        Room r110 = r109.getValue();
        if (r110 == null) goto L28;
        String r111 = r110.getOwnerUserIdString();
    L29:
        String r112 = String.valueOf(r111);
        String r113 = ((IUserService) jc1.k.n(IUserService.class)).user().b().getIdString();
        String r114 = String.valueOf(this.f60647q.f60809m.f61082h);
        PluginContext r115 = this.f60647q;
        String r116 = r115.f60809m.b(r115.f60811o);
        String r117 = ((BootInfoService) this.f60647q.o(BootInfoService.class)).e();
        PluginContext r118 = this.f60647q;
        if (r118 == null) goto L34;
        com.bytedance.android.live.broadcastgame.opengame.t r119 = r118.f60809m;
        if (r119 == null) goto L34;
        String r120 = r119.f61083i;
    L35:
        r104.getClass();
        TrackMiniGameService.a.c(r105, r107, r112, r113, r114, r116, r117, r120);
        return;
    L34:
        r120 = null;
    L28:
        r111 = null;
        goto L29
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L16:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L18
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final Window v0() {
        return getWindow();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final OpenPanelType c() {
        return OpenPanelType.OPEN_PANEL;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final ViewGroup getContentView() {
        return this.f60632b;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final PanelType getPanelType() {
        return this.f60649s;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.bytedance.android.live.broadcastgame.opengame.panel.i, java.lang.Object] */
    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void C(i r100) {
        i r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f60650t.f60846b = r101;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void K(boolean r100) {
        PanelTopRightButtonView r101 = this.f60638h;
        if (r101 == null) goto L6;
        r101.setTopRightTheme(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void M(int r100) {
        if (r100 != 0) goto L8;
        ViewGroup r101 = this.f60639i;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L7:
        UIUtils.setViewVisibility(r101, 0);
        return;
    L8:
        ViewGroup r102 = this.f60639i;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L11:
        UIUtils.setViewVisibility(r102, 8);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void V(boolean r100) {
        if (r100 == false) goto L8;
        View r101 = this.f60631a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L7:
        r101.setBackground(s1.m(R.drawable.ttlive_bg_open_platform_hybrid_content));
        return;
    L8:
        View r102 = this.f60631a;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r102.setBackground(new ColorDrawable(-16777216));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void addTopMessageView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup r101 = this.f60639i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L5:
        r101.addView(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void addTopRightBtnView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f60638h = (PanelTopRightButtonView) r100;
        ViewGroup r101 = this.f60637g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L5:
        r101.addView(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void i1(boolean r100) {
        if (r100 == false) goto L4;
        View r101 = findViewById(R.id.hybrid_content);
        FrameLayout r102 = (FrameLayout) r101;
        r102.setClipToOutline(true);
        r102.setOutlineProvider(new c());
        Unit r103 = Unit.INSTANCE;
        this.f60632b = (ViewGroup) r101;
        return;
    L4:
        ViewGroup r104 = this.f60632b;
        if (r104 == null) goto L7;
        r104.setClipToOutline(false);
    L7:
        ViewGroup r105 = this.f60632b;
        if (r105 == null) goto L12;
        r105.setOutlineProvider(null);
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = q.f60744a;
        q.f("OpenPanel", new Object[]{WidgetCostModule.TYPE_ON_CREATE});
        Window r102 = getWindow();
        if (r102 == null) goto L5;
        r102.setLayout(-1, -2);
        r102.setGravity(80);
        r102.setFlags(512, 512);
    L5:
        setContentView(R.layout.ttlive_open_platform_panel);
        this.f60631a = findViewById(R.id.game_interact_panel_layout);
        r(this.f60649s);
        i1(true);
        TextView r103 = (TextView) findViewById(R.id.statusBtn);
        this.f60633c = (ViewGroup) findViewById(R.id.loading_status_layout);
        this.f60634d = (LiveDoubleColorBallAnimationView) findViewById(R.id.double_ball_loading_view);
        ViewGroup r104 = (ViewGroup) findViewById(R.id.double_ball_loading_view_background);
        this.f60635e = r104;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("doubleBallLoadingLayoutBg");
    L8:
        r104.setOnClickListener(e.f60652a);
        TextView r105 = (TextView) findViewById(R.id.retry_btn);
        this.f60636f = r105;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L11:
        r105.setOnClickListener(new f(this));
        ViewGroup r106 = (ViewGroup) findViewById(R.id.top_right_btn_view);
        this.f60637g = r106;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L14:
        r106.setVisibility(8);
        ViewGroup r107 = (ViewGroup) findViewById(R.id.top_message_container);
        this.f60639i = r107;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L17:
        r107.setVisibility(8);
        h();
        super.setOnDismissListener(this.f60645o);
        i r108 = this.f60650t.f60846b;
        if (r108 == null) goto L21;
        r108.a();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void p(int r100) {
        if (r100 != 0) goto L8;
        ViewGroup r101 = this.f60637g;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L7:
        UIUtils.setViewVisibility(r101, 0);
        return;
    L8:
        ViewGroup r102 = this.f60637g;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L11:
        UIUtils.setViewVisibility(r102, 8);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void r(PanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f60649s = r100;
        CommercialService r101 = (CommercialService) this.f60647q.o(CommercialService.class);
        PanelType r102 = this.f60649s;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f60929a = r102;
        int r103 = r100.getHeight();
        View r104 = this.f60631a;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, r103);
        r105.gravity = 17;
        Unit r106 = Unit.INSTANCE;
        r104.setLayoutParams(r105);
        if (be0.f119861a.getValue().booleanValue() == false) goto L11;
        Window r107 = getWindow();
        if (r107 == null) goto L12;
        r107.setLayout(-1, r103);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void registerListener(i r100) {
        i r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f60650t.registerListener(r101);
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r100) {
        this.f60644n = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void u0(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "background");
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new BitmapDrawable(r101.getContext().getResources(), r100));
    L5:
        View r102 = this.f60631a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        r102.setBackground(null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void z(LiveBasePluginWithPanel$initPanelAndHide$3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        this.f60646p = r100;
    }

    public OpenPanel(PluginContext r100, b r101, PanelType r102) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r102, "panelType");
        super(r100.getContext(), R.style.ttlive_open_platform_panel_dialog);
        this.f60650t = new t();
        this.f60647q = r100;
        this.f60648r = r101;
        this.f60649s = r102;
        u.a(this, i.class);
        this.f60640j = 80;
        this.f60643m = new ShowTipsHelper(r100, new OpenPanel$showTipsHelper$1(this), new OpenPanel$showTipsHelper$2(this));
        this.f60645o = new d(this);
    }

    public static final void a(final OpenPanel r100, int r101, int r102, final boolean r103) {
        ValueAnimator r104 = r100.f60642l;
        if (r104 != null) goto L5;
    L9:
        r100.f60642l = ValueAnimator.ofInt(new int[]{1, 60});
        IntEvaluator r105 = new IntEvaluator();
        ValueAnimator r106 = r100.f60642l;
        if (r106 == null) goto L12;
        r106.addUpdateListener(new OpenPanel$performPanelAnimation$1(r100, r105, r101, r102));
    L12:
        View r107 = r100.f60631a;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L15:
        Function0<Unit> r108 = new OpenPanel$performPanelAnimation$2(r100, r103);
        if (ViewCompat.isAttachedToWindow(r107) == false) goto L18;
        r108.invoke();
    L18:
        ValueAnimator r109 = r100.f60642l;
        if (r109 == null) goto L21;
        r109.setInterpolator(new AccelerateDecelerateInterpolator());
    L21:
        ValueAnimator r110 = r100.f60642l;
        if (r110 == null) goto L27;
        ValueAnimator r111 = r110.setDuration(200);
        if (r111 == null) goto L28;
        r111.start();
        return;
    L28:
        return;
    L27:
        return;
    L5:
        if (r104.isRunning() != true) goto L9;
        ValueAnimator r112 = r100.f60642l;
        if (r112 == null) goto L9;
        r112.cancel();
        goto L9
    }
}
