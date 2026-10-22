package com.bytedance.android.livesdk.interactivity.interactive.episode;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.landscape.e;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o82.f;
import vr1.j;
import vr1.o;
import vr1.u;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/episode/EpisodeInteractiveDialog;", "Landroid/app/Dialog;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroidx/fragment/app/FragmentActivity;", "h", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeInteractiveDialog extends Dialog implements Observer<KVData> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f137368l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f137369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f137370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f137371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f137372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Boolean, Unit> f137373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompositeDisposable f137374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f137375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FragmentActivity f137376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f137377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f137378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f137379k;

    public final void b() {
        FragmentActivity r100 = this.f137376h;
        IRoom r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.getRequestedOrientation());
    L6:
        int r103 = r102.intValue();
        boolean r104 = false;
        if (r103 != 0) goto L9;
    L30:
        int r105 = 0;
    L31:
        this.f137372d = r105;
        DataCenter r106 = this.f137377i;
        float r107 = 0.0f;
        if (r106 == null) goto L35;
        VideoViewParams r108 = (VideoViewParams) r106.get("live_render_view_params", null);
        if (r108 == null) goto L35;
    L36:
        DataCenter r109 = this.f137377i;
        if (r109 == null) goto L39;
        IRoom r110 = (IRoom) r109.get("data_room", null);
    L41:
        if (s1.F() == false) goto L43;
    L75:
        int r111 = 0;
        int r112 = 0;
    L76:
        DataCenter r113 = this.f137377i;
        if (r113 == null) goto L81;
        Boolean r114 = (Boolean) r113.get("data_vs_room_big_gift_combo_dialog_show", Boolean.FALSE);
        if (r114 == null) goto L81;
        boolean r115 = r114.booleanValue();
    L82:
        if (r115 == false) goto L87;
        Window r116 = getWindow();
        if (r116 == null) goto L86;
        r116.setType(1);
    L86:
        ALogger.w(this.f137369a, "isVSBigGiftDialogShowing true");
    L90:
        int r117 = f.f522349a;
        FragmentActivity r118 = this.f137376h;
        Window r119 = getWindow();
        DataCenter r120 = this.f137377i;
        int r121 = this.f137379k;
        ValueAnimator r122 = f.f522353e;
        if (r122 == null) goto L93;
        r122.cancel();
    L93:
        if (r122 == null) goto L95;
        r122.setInterpolator(new AccelerateDecelerateInterpolator());
    L95:
        if (r120 == null) goto L98;
        VideoViewParams r123 = (VideoViewParams) r120.get("live_render_view_params", null);
        if (r123 == null) goto L98;
    L100:
        if (PadConfigUtils.c() == false) goto L103;
        int r124 = s1.f(20.0f);
    L110:
        if (r119 == null) goto L190;
        f.f522349a = r111 + r124;
        f.f522350b = r112 + r124;
        f.f522352d = r121;
        m<Boolean> r125 = r.i().y(r120);
        if (r125 != null) goto L114;
    L116:
        int r126 = f.f522349a;
    L117:
        f.f522351c = r126;
        WindowManager.LayoutParams r127 = r119.getAttributes();
        if (r127 == null) goto L120;
        r127.x = f.f522351c;
    L120:
        WindowManager.LayoutParams r128 = r119.getAttributes();
        if (r128 == null) goto L189;
        if (r120 == null) goto L124;
        Boolean r129 = (Boolean) r120.get("data_is_portrait");
    L126:
        if (Intrinsics.areEqual(r129, Boolean.TRUE) == false) goto L177;
        int r130 = s1.k(R.dimen.ttlive_protrait_right_bottom_card_padding_bottom);
        if (PadConfigUtils.c() == false) goto L130;
        r130 = s1.k(R.dimen.ttlive_protrait_right_bottom_card_padding_bottom_match_pad);
    L130:
        ALogger.d("InteractiveDialogAnimController", "EpisodeInteractiveDialog get getPortraitY start get window diff");
        Rect r131 = new Rect();
        if (r118 == null) goto L135;
        View r132 = r118.findViewById(android.R.id.content);
        if (r132 == null) goto L135;
        r132.getGlobalVisibleRect(r131);
    L135:
        int r133 = s1.s(r118);
        int r134 = r131.bottom;
        if (r134 == 0) goto L139;
        if (r134 == r133) goto L139;
        int r135 = Math.abs(r133 - r134);
        r130 = r130 + r135;
        ALogger.d("InteractiveDialogAnimController", "EpisodeInteractiveDialog get getPortraitY add diff,diff=" + r135 + ",realScreenHeight = " + r133 + ",activityBottom = " + r131.bottom);
    L141:
        ALogger.d("InteractiveDialogAnimController", "EpisodeInteractiveDialog get getPortraitY=" + r130);
        u r136 = r.u(r120, null, 2);
        if (r136 == null) goto L152;
        Room r137 = r136.j0();
        if (r137 == null) goto L152;
        VSRoom r138 = (VSRoom) r137.castToOrNull(VSRoom.class);
        if (r138 == null) goto L152;
        EpisodeExtraInfo r139 = r138.getEpisodeExtra();
        if (r139 == null) goto L152;
        if (r139.getStyle() != 2) goto L152;
    L161:
        if (r120 == null) goto L176;
        m<Boolean> r140 = r.i().g(r120);
        if (r140 != null) goto L165;
    L167:
        if (r104 == false) goto L176;
        u r141 = r.u(r120, null, 2);
        if (r141 == null) goto L171;
        r107 = r141.y0();
    L171:
        f.f522354f = r130;
        f.f522355g = ((int) UtilityKotlinExtentionsKt.h(r107)) + r130;
        m<Boolean> r142 = r.i().y(r120);
        if (r142 == null) goto L176;
        if (r142.getValue().booleanValue() != true) goto L176;
        r130 = r130 + ((int) UtilityKotlinExtentionsKt.h(r107));
        goto L176
    L165:
        if (r140.getValue().booleanValue() != true) goto L167;
        r104 = true;
    L176:
        f.f522356h = r130;
    L188:
        r128.y = r130;
    L152:
        if (PadConfigUtils.c() == false) goto L176;
        u r143 = r.u(r120, null, 2);
        if (r143 == null) goto L158;
        n<PadOrientation> r144 = r143.w();
        if (r144 == null) goto L158;
        PadOrientation r145 = r144.getValue();
    L160:
        if (r145 != PadOrientation.LANDSCAPE) goto L176;
    L158:
        r145 = null;
    L139:
        if (r134 != r133) goto L141;
        ALogger.d("InteractiveDialogAnimController", "EpisodeInteractiveDialog get getPortraitY, activity same as realScreen");
        goto L141
    L177:
        IRoom r146 = h.f118195a;
        if (r120 == null) goto L182;
        Boolean r147 = (Boolean) r120.get("data_is_anchor", Boolean.FALSE);
        if (r147 == null) goto L182;
        r104 = r147.booleanValue();
    L182:
        if (r120 == null) goto L185;
        r101 = h.e(r120);
    L185:
        if (e.b(r104, r101) == false) goto L187;
        r130 = (s1.w() - f.f522352d) / 2;
        goto L188
    L187:
        r130 = (r123.f112570b - f.f522352d) / 2;
        goto L188
    L124:
        r129 = null;
    L189:
        r119.setAttributes(r119.getAttributes());
        ALogger.i("InteractiveDialogAnimController", "left:" + f.f522350b + "  right:" + f.f522349a + ' ');
        goto L190
    L114:
        if (r125.getValue().booleanValue() != true) goto L116;
        r126 = f.f522350b;
    L190:
        gr1.a r148 = jr1.c.a();
        if (r148 == null) goto L202;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r149 = r148.provideVSPlayerViewControlService(this.f137377i);
        if (r149 == null) goto L203;
        VSPlayerViewControlContext r150 = r149.provideContext();
        if (r150 == null) goto L204;
        m<Boolean> r151 = r150.getPlayerViewVisible();
        if (r151 == null) goto L205;
        Disposable r152 = i80.a.a(r151, this.f137373e);
        if (r152 == null) goto L206;
        RxUtilKt.c(r152, this.f137374f);
        return;
    L206:
        return;
    L205:
        return;
    L204:
        return;
    L203:
        return;
    L202:
        return;
    L103:
        if (s1.F() == false) goto L105;
        r124 = s1.f(12.0f);
        goto L110
    L105:
        if (r120 != null) goto L107;
    L109:
        r124 = s1.f(13.0f);
        goto L110
    L107:
        if (h.c(r120) != true) goto L109;
        r124 = s1.f(9.0f);
    L98:
        r123 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L100
    L87:
        Window r153 = getWindow();
        if (r153 == null) goto L90;
        r153.setType(1000);
    L81:
        r115 = false;
        goto L82
    L43:
        if (PadConfigUtils.c() == true) goto L75;
        DataCenter r154 = this.f137377i;
        IRoom r155 = h.f118195a;
        if (r154 == null) goto L49;
        Boolean r156 = (Boolean) r154.get("data_is_anchor", Boolean.FALSE);
        if (r156 == null) goto L49;
        boolean r157 = r156.booleanValue();
    L50:
        DataCenter r158 = this.f137377i;
        if (r158 == null) goto L53;
        IRoom r159 = h.e(r158);
    L54:
        boolean r160 = e.b(r157, r159);
        u r161 = r.u(this.f137377i, null, 2);
        if (r161 == null) goto L57;
        boolean r162 = r161.X();
    L58:
        if (r160 == false) goto L61;
        if (r162 == false) goto L61;
        r111 = (s1.f(200.0f) + this.f137372d) + 0;
    L62:
        if (r110 != null) goto L64;
    L74:
        r112 = r111;
        goto L76
    L64:
        if (r110.isMergeVSRoom() != true) goto L74;
        IRoomAuthStatus r163 = r110.getRoomAuthStatus();
        if (r163 != null) goto L68;
    L69:
        IRoomAuthStatus r164 = r110.getRoomAuthStatus();
        if (r164 == null) goto L74;
        if (r164.enableLandscapeQuickRecord() != true) goto L74;
    L73:
        r112 = (((int) s1.e(48.0f)) + ((int) s1.e(1.0f))) + r111;
        goto L76
    L68:
        if (r163.enableLandscapeQuickShot() == true) goto L73;
    L61:
        r111 = 0 + (((s1.t() - r108.f112569a) / 2) + this.f137372d);
        goto L62
    L57:
        r162 = false;
        goto L58
    L53:
        r159 = null;
    L49:
        r157 = false;
        goto L50
    L39:
        r110 = null;
    L35:
        r108 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L36
    L9:
        if (r103 != 8) goto L30;
        FragmentActivity r165 = this.f137376h;
        if (r165 == null) goto L20;
        Window r166 = r165.getWindow();
        if (r166 == null) goto L20;
        View r167 = r166.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L21;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r168 = ThreadMethodProxy.currentThread();
        if (r168 == com.larus.home.impl.utils.c.f346341a) goto L21;
        com.larus.home.impl.utils.c.a(r168, "getDecorView");
    L21:
        if (r167 == null) goto L26;
        int r169 = r167.getHeight();
        int r170 = r167.getWidth();
        int r171 = s1.r();
        int r172 = s1.t();
        if (r169 != r171) goto L25;
        if (r172 == r170) goto L26;
    L25:
        boolean r173 = true;
    L27:
        if (r173 == true) goto L30;
        r105 = s1.o();
    L26:
        r173 = false;
    L20:
        r167 = null;
        goto L21
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.f137374f.dispose();
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
    public final void show() {
        r.i().w(getWindow());
        DataCenter r100 = this.f137377i;
        if (r100 != null) goto L5;
    L25:
        DataCenter r101 = this.f137377i;
        if (r101 != null) goto L28;
    L32:
        b();
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L39;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L39:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L36:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        return;
    L28:
        if (h.d(r101, true) == true) goto L32;
        if (PadConfigUtils.c() == true) goto L32;
        r.i().j(this.f137377i, this.f137374f, new EpisodeInteractiveDialog$observeEvents$2(this));
        goto L32
    L5:
        if (h.d(r100, true) == false) goto L25;
        u r102 = r.u(this.f137377i, null, 2);
        if (r102 == null) goto L25;
        Room r103 = r102.j0();
        if (r103 == null) goto L25;
        VSRoom r104 = (VSRoom) r103.castToOrNull(VSRoom.class);
        if (r104 == null) goto L25;
        EpisodeExtraInfo r105 = r104.getEpisodeExtra();
        if (r105 == null) goto L25;
        if (r105.getStyle() != 2) goto L25;
        j r106 = r.i();
        if (r106 == null) goto L25;
        m<Boolean> r107 = r106.g(r100);
        if (r107 == null) goto L25;
        Observable<Boolean> r108 = r107.a();
        if (r108 == null) goto L25;
        Disposable r109 = r108.subscribe(new b(this));
        if (r109 == null) goto L25;
        RxUtilKt.c(r109, this.f137374f);
        goto L25
    }

    public final FragmentActivity getActivity() {
        return this.f137376h;
    }

    public static void a(boolean r100) {
        o r101 = r.l();
        Pair[] r102 = new Pair[1];
        if (r100 == false) goto L5;
        String r103 = "1";
    L6:
        r102[0] = TuplesKt.to("create_success", r103);
        r101.s("livesdk_flexinteract_view_init", MapsKt.mutableMapOf(r102), "live", "show", "live_detail");
        return;
    L5:
        r103 = "0";
        goto L6
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.f137376h.dispatchKeyEvent(r100);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        View r102 = this.f137370b;
        if (r102 == null) goto L6;
        r102.post(new c(this, r101));
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ALogger.d(this.f137369a, WidgetCostModule.TYPE_ON_CREATE);
        this.f137374f = new CompositeDisposable();
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.requestFeature(1);
        r101.setLayout(this.f137378j, this.f137379k);
        r101.setAttributes(r101.getAttributes());
        r101.setDimAmount(0.0f);
        r101.setGravity(VideoPlayDataContext.PLAYING_GRAVITY);
        r101.setFlags(32, 32);
        r101.setFlags(262144, 262144);
    L5:
        int r102 = 0;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        View r103 = LayoutInflater.from(this.f137376h).inflate(R.layout.ttlive_live_activity_episode_interaction_dialog, null, false);
        this.f137370b = r103;
        if (r103 == null) goto L71;
        setContentView(r103);
        if (this.f137371c == null) goto L70;
        FragmentActivity r104 = this.f137376h;
        if (r104 != null) goto L12;
    L14:
        View r105 = this.f137371c;
        if (r105 == null) goto L24;
        ViewParent r106 = r105.getParent();
        if (r106 == null) goto L24;
        if ((r106 instanceof ViewGroup) == true) goto L22;
        r106 = null;
    L22:
        if (r106 == null) goto L24;
        ((ViewGroup) r106).removeView(this.f137371c);
    L24:
        FrameLayout r107 = (FrameLayout) this.f137375g.getValue();
        if (r107 == null) goto L27;
        r102 = r107.getChildCount();
    L27:
        if (r102 <= 0) goto L31;
        FrameLayout r108 = (FrameLayout) this.f137375g.getValue();
        if (r108 == null) goto L31;
        r108.removeAllViews();
    L31:
        FrameLayout r109 = (FrameLayout) this.f137375g.getValue();
        if (r109 == null) goto L34;
        r109.addView(this.f137371c);
    L34:
        FrameLayout r110 = (FrameLayout) this.f137375g.getValue();
        if (r110 == null) goto L37;
        a1.p(r110, this.f137378j);
    L37:
        FrameLayout r111 = (FrameLayout) this.f137375g.getValue();
        if (r111 == null) goto L40;
        a1.k(r111, this.f137379k);
    L40:
        View r112 = this.f137371c;
        if (r112 == null) goto L43;
        a1.j(r112, 17);
    L43:
        DataCenter r113 = this.f137377i;
        if (r113 == null) goto L46;
        IRoom r114 = (IRoom) r113.get("data_room", null);
    L47:
        if (r114 == null) goto L59;
        DataCenter r115 = this.f137377i;
        if (r115 == null) goto L59;
        if (h.d(r115, true) != true) goto L59;
        View r116 = this.f137370b;
        if (r116 == null) goto L55;
        r116.setScaleX(1.07f);
    L55:
        View r117 = this.f137370b;
        if (r117 == null) goto L59;
        r117.setScaleY(1.07f);
    L59:
        if (PadConfigUtils.c() == false) goto L69;
        u r118 = r.u(this.f137377i, null, 2);
        if (r118 == null) goto L69;
        n<PadOrientation> r119 = r118.w();
        if (r119 == null) goto L69;
        Observable<sh6.b<PadOrientation>> r120 = r119.a();
        if (r120 == null) goto L69;
        Disposable r121 = r120.subscribe(new a(this));
        if (r121 == null) goto L69;
        RxUtilKt.c(r121, this.f137374f);
    L69:
        o82.h.b("EpisodeInteractiveDialog add hybridRootView complete");
        a(true);
        goto L71
    L46:
        r114 = null;
        goto L47
    L12:
        if (r104.isFinishing() != true) goto L14;
    L70:
        a(false);
    L71:
        List r122 = CollectionsKt.mutableListOf(new String[]{"data_live_screen_orientation_change"});
        if (r122 == null) goto L79;
        Iterator r123 = r122.iterator();
    L75:
        if (r123.hasNext() == false) goto L85;
        String r124 = (String) r123.next();
        DataCenter r125 = this.f137377i;
        if (r125 == null) goto L75;
        r125.observe(r124, this);
        goto L75
    L85:
        return;
    }

    public EpisodeInteractiveDialog(FragmentActivity r100, DataCenter r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100, R.style.ttlive_special_comb_dialog);
        this.f137376h = r100;
        this.f137377i = r101;
        this.f137378j = r102;
        this.f137379k = r103;
        this.f137369a = "EpisodeInteractiveDialog[" + hashCode() + ']';
        this.f137373e = new EpisodeInteractiveDialog$notify$1(this);
        this.f137374f = new CompositeDisposable();
        this.f137375g = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(new EpisodeInteractiveDialog$mEpisodeInteractiveContainer$2(this));
    }
}
