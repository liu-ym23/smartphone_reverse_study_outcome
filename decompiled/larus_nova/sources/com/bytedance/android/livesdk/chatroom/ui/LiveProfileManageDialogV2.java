package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.roommanage.AnchorManageAdminDataContext;
import com.bytedance.android.livesdk.chatroom.roommanage.permission.AnchorModifyAdminPermissionView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycle;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleObserver;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveProfileManageDialogV2 extends Dialog implements ILiveLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f112281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f112282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f112283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f112284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveDialogFragment f112285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HybridDialog f112286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f112287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.core.utils.rxutils.x f112288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Disposable> f112289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j7 f112290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i7 f112291k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Room f112292l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final User f112293m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f112294n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f112295o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f112296p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final UserProfileEvent f112297q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Bundle f112298r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f112299s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final User f112300t;

    public static final class a {
    }

    public interface b {
        void dismissDialog();

        void onClick(int r100);
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveProfileManageDialogV2 f112301a;

        public c(LiveProfileManageDialogV2 r100) {
            this.f112301a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            zg1.g1 r101 = (zg1.g1) r100;
            LiveProfileManageDialogV2 r102 = this.f112301a;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r104 == null) goto L16;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r103.getLooper()) goto L7;
            r103.post(DialogLancet.createDismissRunnable(r102));
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveProfileManageDialogV2 f112302a;

        public d(LiveProfileManageDialogV2 r100) {
            this.f112302a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveProfileManageDialogV2 r101 = this.f112302a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveProfileManageDialogV2 f112303a;

        public e(LiveProfileManageDialogV2 r100) {
            this.f112303a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveProfileManageDialogV2 r101 = this.f112303a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public final class f implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f112304a;

        public f(Function1 r100) {
            this.f112304a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f112304a.invoke(r100);
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f112282b = false;
        Iterator r100 = ((ArrayList) this.f112289i).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Disposable r101 = (Disposable) r100.next();
        if (r101.isDisposed() == true) goto L4;
        r101.dispose();
        goto L4
    L9:
        ((ArrayList) this.f112289i).clear();
        super.onDetachedFromWindow();
        Disposable r102 = this.f112287g;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        this.f112288h.dispose();
        ((ILiveLifecycle) jc1.k.n(ILiveLifecycle.class)).removeObserver(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.f112283c == false) goto L13;
        Object r100 = getContext().getSystemService("input_method");
        if (r100 == null) goto L12;
        InputMethodManager r101 = (InputMethodManager) r100;
        View r102 = this.f112281a;
        if (r102 == null) goto L9;
        IBinder r103 = r102.getWindowToken();
    L10:
        r101.hideSoftInputFromWindow(r103, 0);
        goto L13
    L9:
        r103 = null;
        goto L10
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L13:
        Handler r104 = DialogLancet.resolveDialogHandler(this);
        if (r104 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(this);
    L28:
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r105 != null) goto L31;
        return;
    L31:
        if (r105.isBroadcastMedia() != true) goto L66;
        com.bytedance.android.livesdk.log.g r106 = com.bytedance.android.livesdk.log.u.l();
        HashMap r107 = new HashMap();
        r107.put("live_type", "media");
        String r108 = "1";
        if (r105.getMediaReviewStatus().getValue().intValue() < 5) goto L35;
        Object r109 = "1";
    L36:
        r107.put("live_status", r109);
        if (com.bytedance.android.livesdk.sharedpref.b.L0.getValue().booleanValue() == false) goto L39;
        Object r110 = "1";
    L40:
        r107.put("replay_status", r110);
        RoomAuthStatus r111 = r105.getRoom().getValue().getRoomAuthStatus();
        if (r111 != null) goto L43;
    L45:
        Object r112 = "0";
    L46:
        r107.put("check_status", r112);
        if (com.bytedance.android.livesdk.sharedpref.b.V0.getValue().booleanValue() == false) goto L49;
        Object r113 = "1";
    L50:
        r107.put("gift_status", r113);
        if (com.bytedance.android.livesdk.sharedpref.b.G1.getValue().booleanValue() == false) goto L53;
        Object r114 = "1";
    L54:
        r107.put("comment_status", r114);
        if (com.bytedance.android.livesdk.sharedpref.b.H1.getValue().booleanValue() == true) goto L58;
        r108 = "0";
    L58:
        r107.put("share_status", r108);
        Unit r115 = Unit.INSTANCE;
        r106.sendLog("livesdk_anchor_inlive_setting_close", r107, new Object[0]);
        return;
    L53:
        r114 = "0";
        goto L54
    L49:
        r113 = "0";
        goto L50
    L43:
        if (r111.getEnableUserCard() != true) goto L45;
        r112 = "1";
        goto L46
    L39:
        r110 = "0";
        goto L40
    L35:
        r109 = "0";
        goto L36
    L66:
        return;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r116 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r116 == null) goto L27;
        com.bytedance.crash.d.d(r116, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L16:
        if (Looper.myLooper() == r104.getLooper()) goto L18;
        r104.post(DialogLancet.createDismissRunnable(this));
        goto L28
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f112282b = true;
        this.f112287g = xs2.b.a().b(zg1.g1.class).subscribe(new c(this));
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.i<Boolean> r101 = r100.isAnchor();
        if (r101 == null) goto L8;
        if (r101.getValue().booleanValue() == true) goto L8;
    L9:
        ((ILiveLifecycle) jc1.k.n(ILiveLifecycle.class)).addObserver(this);
        if (PadConfigUtils.c() == false) goto L13;
        Disposable r102 = xs2.b.a().b(com.bytedance.android.livesdk.event.f.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(new LiveProfileManageDialogV2$onAttachedToWindow$disposable$1(this)));
        ((ArrayList) this.f112289i).add(r102);
        return;
    L13:
        return;
    L8:
        Pair r103 = com.bytedance.live.datacontext.d.a(AnonymousClass2.INSTANCE);
        com.bytedance.live.datacontext.d.c((DataContext) r103.getFirst(), Reflection.getOrCreateKotlinClass(AnchorManageAdminDataContext.class));
        this.f112288h.b((Disposable) r103.getSecond());
        goto L9
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

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        super.cancel();
    }

    public static void a(LiveProfileManageDialogV2 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        Window r100 = getWindow();
        if (r100 == null) goto L5;
        r100.setGravity(80);
    L5:
        View r101 = null;
        if (PadConfigUtils.c() == false) goto L11;
        View r102 = getLayoutInflater().inflate(R.layout.ttlive_dialog_live_profile_setting_holder_hd, null);
        this.f112281a = r102;
        if (r102 == null) goto L28;
        setContentView(r102);
    L28:
        if (r100 == null) goto L37;
        r100.setLayout(-1, -1);
        if (this.f112295o == false) goto L37;
        r100.setSoftInputMode(18);
        View r103 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L36;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L36;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L36:
        r103.addOnLayoutChangeListener(this.f112291k);
    L37:
        findViewById(R.id.setting_view_outter).setOnClickListener(new e(this));
        ((LiveProfileManageViewPager) findViewById(R.id.setting_view_pager)).setAdapter(new LiveProfileManageViewPager.ProfileManageViewAdapter(this.f112295o, getContext(), getLayoutInflater(), this.f112290j, this.f112292l, this.f112293m, this.f112294n, this.f112296p, this.f112297q, this.f112298r));
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r105 == null) goto L44;
        com.bytedance.live.datacontext.i<Boolean> r106 = r105.isAnchor();
        if (r106 == null) goto L44;
        if (r106.getValue().booleanValue() == true) goto L44;
        boolean r107 = true;
    L45:
        if (r107 == false) goto L52;
        if (this.f112294n == false) goto L52;
        if (RoomPermissionContext.a.c(RoomPermissionContext.Companion) == false) goto L52;
        ((LiveProfileManageViewPager) findViewById(R.id.setting_view_pager)).j();
    L67:
        boolean r108 = true;
    L68:
        com.bytedance.android.livesdk.r3.c(findViewById(R.id.setting_view_outter), com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_label_close), r108);
        return;
    L52:
        if (this.f112299s == false) goto L67;
        LiveProfileManageViewPager r109 = (LiveProfileManageViewPager) findViewById(R.id.setting_view_pager);
        final User r111 = this.f112300t;
        final LiveProfileManageViewPager.ProfileManageViewAdapter r112 = r109.f112305a;
        if (r112 == null) goto L67;
        if (r111 == null) goto L67;
        r109.setCurrentItem(3, false);
        r109.k(r112.f());
        View r113 = r112.f();
        if ((r113 instanceof AnchorModifyAdminPermissionView) == false) goto L62;
        r101 = r113;
    L62:
        AnchorModifyAdminPermissionView r114 = (AnchorModifyAdminPermissionView) r101;
        if (r114 == null) goto L65;
        UtilityKotlinExtentionsKt.t(r114.f111491d);
        r108 = true;
        r114.f111496i = true;
    L66:
        r112.g(new LiveProfileManageViewPager$switchToAdminPrivilegePage$1(r111, r112));
        goto L68
    L65:
        r108 = true;
    L44:
        r107 = false;
        goto L45
    L11:
        if (this.f112295o == false) goto L13;
    L25:
        View r115 = getLayoutInflater().inflate(R.layout.ttlive_dialog_live_profile_setting_holder, null);
        this.f112281a = r115;
        if (r115 == null) goto L28;
        setContentView(r115);
        goto L28
    L13:
        if (this.f112294n == true) goto L25;
        if (this.f112296p == false) goto L25;
        View r116 = getLayoutInflater().inflate(R.layout.ttlive_dialog_live_profile_setting_holder_action, null);
        this.f112281a = r116;
        if (r116 == null) goto L19;
        setContentView(r116);
    L19:
        View r117 = this.f112281a;
        if (r117 == null) goto L24;
        View r118 = r117.findViewById(R.id.setting_view_outter_2);
        if (r118 == null) goto L24;
        r118.setOnClickListener(new d(this));
    L24:
        ((LiveProfileManageViewPager) findViewById(R.id.setting_view_pager)).setNeedUpdateHeightOnHorizontal(true);
        goto L28
    }

    public final void onEvent(com.bytedance.android.livesdk.event.f r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        a(this);
    }

    @Override // com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleObserver
    public final void onLifecycleEvent(ILiveLifecycleObserver.Event r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        if (isShowing() == true) goto L5;
        return;
    L5:
        if (r100 != ILiveLifecycleObserver.Event.EndSession) goto L9;
        a(this);
        return;
    }

    public LiveProfileManageDialogV2(Context r100, Room r101, User r102, boolean r103, boolean r104, boolean r105, UserProfileEvent r106, Bundle r110, boolean r111, User r112, int r113) {
        if ((r113 & 32) == 0) goto L6;
        r105 = true;
    L6:
        if ((r113 & 64) == 0) goto L9;
        r106 = null;
    L9:
        if ((r113 & 128) == 0) goto L12;
        r110 = Bundle.EMPTY;
    L12:
        if ((r113 & 256) == 0) goto L15;
        r111 = false;
    L15:
        if ((r113 & 512) == 0) goto L17;
        r112 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "bundle");
        if (r104 == false) goto L20;
        int r114 = R.style.ttlive_LiveProfileDialog;
    L21:
        super(r100, r114);
        this.f112292l = r101;
        this.f112293m = r102;
        this.f112294n = r103;
        this.f112295o = r104;
        this.f112296p = r105;
        this.f112297q = r106;
        this.f112298r = r110;
        this.f112299s = r111;
        this.f112300t = r112;
        Resources r107 = r100.getResources();
        this.f112284d = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).heightPixels;
        this.f112288h = new com.bytedance.android.live.core.utils.rxutils.x();
        this.f112289i = new ArrayList();
        this.f112290j = new j7(this);
        this.f112291k = new i7(this);
        return;
    L20:
        r114 = R.style.ttlive_LiveProfileDialog_Right;
        goto L21
    }
}
