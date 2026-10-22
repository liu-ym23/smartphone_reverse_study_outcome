package com.bytedance.android.livesdk.chatroom;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.config.c51;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.ReplayInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LandscapeRootViewChangeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f105024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f105025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f105026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f105027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f105028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f105029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f105030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Room f105031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f105032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f105033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f105034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f105035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f105036m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f105037n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f105038o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f105039p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f105040q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f105041r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DataCenter f105042s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RoomContext f105043t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f105044u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f105045v;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeRootViewChangeManager f105046a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);
            int r101 = r100.what;
            LandscapeRootViewChangeManager r102 = this.f105046a;
            if (r101 != r102.f105024a) goto L17;
            com.bytedance.android.livesdk.chatroom.widget.m0 r103 = r102.f105043t.getRoomUISizeGetter().getValue();
            if (r103 == null) goto L8;
            Rect r104 = r103.c();
            if (r104 == null) goto L8;
        L9:
            r102.f105026c = r104;
            LandscapeRootViewChangeManager r105 = this.f105046a;
            r105.f105041r.getGlobalVisibleRect(r105.f105027d);
            if (this.f105046a.f105026c.isEmpty() == false) goto L12;
        L15:
            Message.obtain(this, this.f105046a.f105024a).sendToTarget();
            return;
        L12:
            if (this.f105046a.f105027d.isEmpty() == true) goto L15;
            Message.obtain(this, this.f105046a.f105025b).sendToTarget();
            return;
        L8:
            r104 = new Rect();
            goto L9
        L17:
            if (r101 == r102.f105025b) goto L19;
            return;
        L19:
            if (r102.f105026c.isEmpty() == false) goto L21;
        L25:
            boolean r106 = false;
        L26:
            if (r106 == false) goto L29;
            LandscapeRootViewChangeManager.a(this.f105046a);
            return;
        L29:
            if (this.f105046a.f105026c.isEmpty() == false) goto L31;
        L34:
            Message.obtain(this, this.f105046a.f105024a).sendToTarget();
            return;
        L31:
            if (this.f105046a.f105027d.isEmpty() == true) goto L34;
            Message.obtain(this, this.f105046a.f105025b).sendToTarget();
            return;
        L21:
            if (r102.f105027d.isEmpty() == true) goto L25;
            if (r102.f105028e == true) goto L25;
            r106 = true;
            goto L26
        }

        public a(LandscapeRootViewChangeManager r100, Looper r101) {
            this.f105046a = r100;
            super(r101);
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeRootViewChangeManager f105047a;

        public b(LandscapeRootViewChangeManager r100) {
            this.f105047a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (com.bytedance.android.live.core.utils.z.b(this.f105047a.f105042s).f66428b == true) goto L37;
            LandscapeRootViewChangeManager r100 = this.f105047a;
            if (r100.f105029f == false) goto L8;
            return;
        L8:
            if (r100.f105043t.getRoomUISizeGetter().getValue() != null) goto L12;
            Runnable r101 = this.f105047a.f105045v;
            if (r101 == null) goto L12;
            r101.run();
        L12:
            LandscapeRootViewChangeManager r102 = this.f105047a;
            com.bytedance.android.livesdk.chatroom.widget.m0 r103 = r102.f105043t.getRoomUISizeGetter().getValue();
            if (r103 == null) goto L16;
            Rect r104 = r103.c();
            if (r104 == null) goto L16;
        L17:
            r102.f105026c = r104;
            LandscapeRootViewChangeManager r105 = this.f105047a;
            r105.f105041r.getGlobalVisibleRect(r105.f105027d);
            Pair<Integer, Integer> r106 = this.f105047a.c();
            int r107 = r106.component1().intValue();
            int r108 = r106.component2().intValue();
            if (this.f105047a.f105026c.isEmpty() == false) goto L20;
            return;
        L20:
            if (this.f105047a.f105027d.isEmpty() == true) goto L39;
            LandscapeRootViewChangeManager r109 = this.f105047a;
            Rect r110 = r109.f105027d;
            if (r110.left != r107) goto L26;
            if (r110.right != r108) goto L26;
            return;
        L26:
            if (r109.f105026c.isEmpty() == false) goto L28;
        L32:
            boolean r111 = false;
        L33:
            if (r111 == false) goto L35;
            LandscapeRootViewChangeManager.a(this.f105047a);
            return;
        L35:
            LandscapeRootViewChangeManager r112 = this.f105047a;
            Message.obtain(r112.f105030g, r112.f105025b).sendToTarget();
            return;
        L28:
            if (r109.f105027d.isEmpty() == true) goto L32;
            if (r109.f105028e == true) goto L32;
            r111 = true;
            goto L33
        L39:
            return;
        L16:
            r104 = new Rect();
            goto L17
        }
    }

    public final boolean b() {
        this.f105028e = true;
        boolean r100 = com.bytedance.android.live.core.utils.z.b(this.f105042s).f66428b;
        int r101 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        if ((!r100) == true) goto L5;
    L47:
        this.f105028e = false;
        return false;
    L5:
        if (this.f105032i == null) goto L47;
        if (this.f105034k == true) goto L47;
        Rect r102 = g();
        if (this.f105033j == true) goto L30;
        Room r103 = this.f105031h;
        if (r103 == null) goto L30;
        if (r103.isOfficial() == true) goto L30;
        if (x6.f114304e == true) goto L30;
        if ((!com.bytedance.android.live.core.utils.z.b(this.f105042s).f66428b) == false) goto L30;
        if (this.f105032i == null) goto L30;
        if (this.f105037n == false) goto L28;
    L29:
        boolean r104 = true;
    L31:
        if (r104 == false) goto L45;
        Pair<Integer, Integer> r105 = c();
        int r106 = r105.component1().intValue();
        int r107 = r105.component2().intValue();
        Rect r108 = this.f105026c;
        int r109 = r106 - r108.left;
        int r110 = r108.right - r107;
        if (this.f105037n == false) goto L35;
        int r111 = (r108.width() - r109) - r110;
    L36:
        int r112 = r109 + r111;
        if (VrUtils.t(this.f105042s, false) == true) goto L43;
        ViewGroup.LayoutParams r113 = this.f105041r.getLayoutParams();
        if (r113 == null) goto L42;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        r114.leftMargin = r109;
        r114.rightMargin = r110;
        r114.width = r111;
        this.f105041r.setLayoutParams(r114);
        e(r109, r110);
        zg1.x0 r115 = new zg1.x0(r109, r112, r109, r110);
        onEvent(r115);
        this.f105043t.getLandscapeRootChange().setValue(r115);
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L43:
        this.f105028e = false;
        return true;
    L35:
        r111 = (h() * 16) / 9;
        goto L36
    L45:
        this.f105028e = false;
        return false;
    L28:
        if ((this.f105026c.width() / r102.height()) > 1.7777778f) goto L29;
    L30:
        r104 = false;
        goto L31
    }

    public final int f() {
        return ((Number) this.f105038o.getValue()).intValue();
    }

    public final Pair<Integer, Integer> c() {
        if (this.f105037n == false) goto L29;
        boolean r100 = false;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L11:
        if (r101 == false) goto L13;
    L15:
        int r102 = UtilityKotlinExtentionsKt.i(((c51) this.f105039p.getValue()).b());
        if (this.f105044u == false) goto L18;
        Pair r103 = TuplesKt.to(Integer.valueOf(this.f105036m), Integer.valueOf(this.f105036m));
    L27:
        int r104 = ((Number) r103.component1()).intValue();
        int r105 = ((Number) r103.component2()).intValue();
        return TuplesKt.to(Integer.valueOf(this.f105026c.left + r104), Integer.valueOf(this.f105026c.right - r105));
    L18:
        if (r100 == true) goto L20;
        r103 = TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r102));
        goto L27
    L20:
        if (((c51) this.f105039p.getValue()).a() == true) goto L23;
        r103 = TuplesKt.to(Integer.valueOf(f()), Integer.valueOf(f()));
        goto L27
    L23:
        if (e5.a() != 8) goto L25;
        r103 = TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(f()));
        goto L27
    L25:
        r103 = TuplesKt.to(Integer.valueOf(f()), Integer.valueOf(r102));
        goto L27
    L13:
        if (DigHoleScreenUtil.isDigHole(this.f105032i) == false) goto L15;
    L14:
        r100 = true;
        goto L15
    L10:
        if (DigHoleScreenUtil.isAllScreenForAndroidP(this.f105032i) == true) goto L14;
    L7:
        r101 = false;
        goto L8
    L29:
        Rect r106 = g();
        int r107 = (h() * 16) / 9;
        int r108 = (r106.left + r106.right) / 2;
        int r109 = r107 / 2;
        int r110 = r108 - r109;
        return TuplesKt.to(Integer.valueOf(r110), Integer.valueOf(r108 + r109));
    }

    public final Rect g() {
        com.bytedance.android.livesdk.chatroom.widget.m0 r100 = this.f105043t.getRoomUISizeGetter().getValue();
        if (r100 == null) goto L6;
        Rect r101 = r100.a();
        if (r101 == null) goto L6;
    L7:
        as0.a r102 = LivePlatformPlayerManager.b();
        if (r102 == null) goto L16;
        ILivePlayerClient r103 = r102.player();
        if (r103 == null) goto L16;
        Boolean r104 = r103.gameExtraRenderController().eventHub().getExtraRenderIsShow().getValue();
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == false) goto L14;
    L15:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L24;
        com.bytedance.android.livesdk.chatroom.widget.m0 r107 = this.f105043t.getRoomUISizeGetter().getValue();
        if (r107 == null) goto L22;
        Rect r108 = r107.e();
        if (r108 == null) goto L22;
    L23:
        r101.union(r108);
    L22:
        r108 = new Rect();
    L24:
        return r101;
    L14:
        if (Intrinsics.areEqual(r103.extraRenderController().eventHub().getExtraRenderIsShow().getValue(), r105) == true) goto L15;
    L16:
        r106 = false;
    L6:
        r101 = new Rect();
        goto L7
    }

    public final int h() {
        com.bytedance.android.livesdk.chatroom.widget.m0 r100 = this.f105043t.getRoomUISizeGetter().getValue();
        if (r100 == null) goto L6;
        Rect r101 = r100.a();
        if (r101 == null) goto L6;
    L7:
        com.bytedance.android.livesdk.chatroom.widget.m0 r102 = this.f105043t.getRoomUISizeGetter().getValue();
        if (r102 == null) goto L10;
        Pair<Integer, Integer> r103 = r102.d();
    L11:
        LiveLandSlideContext.Companion.getClass();
        if (LiveLandSlideContext.a.b() == false) goto L21;
        if (r103 == null) goto L21;
        if (g().height() == r103.getSecond().intValue()) goto L21;
        if (r103.getSecond().intValue() == 0) goto L21;
        return r103.getSecond().intValue();
    L21:
        return r101.height();
    L10:
        r103 = null;
    L6:
        r101 = new Rect();
        goto L7
    }

    public static final void a(LandscapeRootViewChangeManager r100) {
        if (r100.b() == false) goto L5;
        return;
    L5:
        if (DigHoleScreenUtil.isDigHole(r100.f105032i) == true) goto L7;
        return;
    L7:
        if (r100.f105035l == true) goto L15;
        View r101 = r100.f105041r;
        int r102 = UIUtils.getStatusBarHeight(r100.f105032i);
        if (x6.f114304e == true) goto L16;
        UIUtils.updateLayoutMargin(r101, r102, -3, -3, -3);
        return;
    L16:
        return;
    }

    public final void onEvent(zg1.x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((this.f105041r.getParent() instanceof ViewGroup) == true) goto L5;
        return;
    L5:
        ViewParent r101 = this.f105041r.getParent();
        if (r101 == null) goto L28;
        ((ViewGroup) r101).setClipChildren(false);
        ViewParent r102 = this.f105041r.getParent();
        if (r102 == null) goto L26;
        ((ViewGroup) r102).setClipToPadding(false);
        if (this.f105037n == true) goto L12;
        d(R.id.landscape_bottom_right_indicator_container, -3, UtilityKotlinExtentionsKt.i(14));
    L12:
        d(R.id.obs_barrage_layout, -r100.f571977c, -r100.f571978d);
        d(R.id.multi_anchor_container, -r100.f571977c, -r100.f571978d);
        Room r103 = this.f105031h;
        if (r103 != null) goto L15;
    L21:
        d(R.id.cast_screen_landscape_control_bg, -r100.f571977c, -r100.f571978d);
        LandscapeLiveMonitor.Companion.getClass();
        LandscapeLiveMonitor r104 = LandscapeLiveMonitor.a.b();
        if (r104 == null) goto L29;
        LandscapeLiveMonitor.access$onEndShowUI(r104);
        return;
    L29:
        return;
    L15:
        if (r103.isMergeVSRoom() == true) goto L21;
        Room r105 = this.f105031h;
        if (r105 == null) goto L21;
        if (r105.isMediaRoom() == true) goto L21;
        d(R.id.cast_tv_container, -r100.f571977c, -r100.f571978d);
        goto L21
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void e(int r100, int r101) {
        if ((this.f105041r.getParent() instanceof ViewGroup) == true) goto L5;
        return;
    L5:
        ViewParent r102 = this.f105041r.getParent();
        if (r102 == null) goto L10;
        ((ViewGroup) r102).post(new z(this, r100, r101));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void d(int r100, int r101, int r102) {
        View r103 = this.f105041r.findViewById(r100);
        if (x6.f114304e == true) goto L7;
        UIUtils.updateLayoutMargin(r103, r101, -3, r102, -3);
        return;
    }

    public LandscapeRootViewChangeManager(View r100, DataCenter r101, RoomContext r102, boolean r110, Runnable r111) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "dataContext");
        this.f105041r = r100;
        this.f105042s = r101;
        this.f105043t = r102;
        this.f105044u = r110;
        this.f105045v = r111;
        this.f105024a = -1;
        this.f105025b = -2;
        this.f105026c = new Rect();
        this.f105027d = new Rect();
        this.f105030g = new a(this, Looper.getMainLooper());
        Room r103 = (Room) r101.get("data_room");
        this.f105031h = r103;
        Boolean r104 = (Boolean) r101.get("data_is_anchor", Boolean.FALSE);
        boolean r112 = false;
        if (r104 == null) goto L5;
        boolean r105 = r104.booleanValue();
    L6:
        this.f105032i = this.f105041r.getContext();
        this.f105033j = com.bytedance.android.livesdk.utils.landscape.e.b(r105, r103) & com.bytedance.android.livesdk.utils.landscape.e.a(r103);
        if (r103 != null) goto L10;
    L48:
        boolean r106 = false;
    L50:
        this.f105034k = r106;
        this.f105036m = UtilityKotlinExtentionsKt.i(40);
        if (r103 == null) goto L66;
        if (r110 == true) goto L60;
        if (r103.isVrRoom() == true) goto L60;
        if (r103.isMergeVSRoom() == true) goto L60;
        if (r103.isMediaRoom() == true) goto L60;
    L62:
        boolean r107 = true;
    L64:
        if (r107 != true) goto L66;
        r112 = true;
    L60:
        if (dm2.b.f469220a.d() == false) goto L63;
        if (r110 == true) goto L62;
    L63:
        r107 = false;
    L66:
        r102.isOptLandscapeMargin().setValue(Boolean.valueOf(r112));
        Unit r108 = Unit.INSTANCE;
        this.f105037n = r112;
        this.f105038o = InfraKotlinExtsKt.mainThreadLazy(new LandscapeRootViewChangeManager$statusBarHeight$2(this));
        this.f105039p = InfraKotlinExtsKt.mainThreadLazy(LandscapeRootViewChangeManager$marginConfig$2.INSTANCE);
        this.f105040q = new b(this);
        return;
    L10:
        if (r103.isMediaRoom() == true) goto L12;
    L31:
        r106 = false;
    L33:
        if (r103.isMediaRoom() == false) goto L50;
        if (r103.getReplay() == false) goto L50;
        if (r103.getStatus() != 4) goto L50;
        if (TextUtils.isEmpty(r103.getVid()) == true) goto L42;
        r106 = true;
    L42:
        if (r103.getReplayInfo() == null) goto L50;
        if (TextUtils.isEmpty(r103.getVid()) == true) goto L46;
    L49:
        r106 = true;
        goto L50
    L46:
        if (TextUtils.isEmpty(((ReplayInfo) r103.getReplayInfo()).replayUrl) == true) goto L48;
    L12:
        if (r103.getReplay() == false) goto L31;
        if (r103.getStatus() != 2) goto L31;
        if (TextUtils.isEmpty(r103.getVid()) == true) goto L18;
    L21:
        r106 = true;
    L23:
        if (r103.getReplayInfo() == null) goto L33;
        if (TextUtils.isEmpty(r103.getVid()) == true) goto L27;
    L30:
        r106 = true;
        goto L33
    L27:
        if (TextUtils.isEmpty(((ReplayInfo) r103.getReplayInfo()).replayUrl) == false) goto L30;
        if (r103.getStreamCloseTime() <= 0) goto L31;
    L18:
        if (r103.getStreamCloseTime() > 0) goto L21;
        r106 = false;
        goto L23
    L5:
        r105 = false;
        goto L6
    }
}
