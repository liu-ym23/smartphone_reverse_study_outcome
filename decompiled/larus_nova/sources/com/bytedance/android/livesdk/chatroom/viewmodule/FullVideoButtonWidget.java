package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.FullVideoButtonWidgetPaidUtil;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.lj;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.common.jato.views.JatoOptDrawableCache;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LiveOrientationControl, needDynamicControl = true, type = PlayerViewControl.Type.BOTTOM)
public class FullVideoButtonWidget extends LiveWidget implements Observer<KVData>, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, com.bytedance.android.live.room.api.visibilitycontrol.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f114943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f114944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f114945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f114946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f114947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f114948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f114949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f114950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f114951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f114952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f114953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f114954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f114955m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p0 f114956n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CompositeDisposable f114957o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Disposable f114958p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f114959q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f114960r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ObjectAnimator f114961s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f114962t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f114963u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public EntranceChecker f114964v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f114965w;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f114966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FullVideoButtonWidget f114967b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            if (this.f114966a == true) goto L6;
            this.f114967b.f114952j.setVisibility(8);
            return;
        }

        public a(FullVideoButtonWidget r100, boolean r101) {
            this.f114967b = r100;
            this.f114966a = r101;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_obs_full_video_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a161";
    }

    @Override // com.bytedance.android.live.room.api.visibilitycontrol.b
    public final boolean canControlByClearScreenService() {
        if (jc1.k.f(IVisibilityControlBrickService.class) != null) goto L5;
    L10:
        return true;
    L5:
        if (((IVisibilityControlBrickService) jc1.k.f(IVisibilityControlBrickService.class)).provideVisibilityControlService(this.dataCenter) == null) goto L10;
        if (((IVisibilityControlBrickService) jc1.k.f(IVisibilityControlBrickService.class)).provideVisibilityControlService(this.dataCenter).provideContext() == null) goto L10;
        return !((IVisibilityControlBrickService) jc1.k.f(IVisibilityControlBrickService.class)).provideVisibilityControlService(this.dataCenter).provideContext().enablePlayBackAbility();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        if (LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue().booleanValue() == false) goto L5;
        Aq(this.f114953k);
    L5:
        this.f114957o.clear();
        xq();
        this.dataCenter.removeObserver(this);
        ObjectAnimator r100 = this.f114961s;
        if (r100 == null) goto L8;
        r100.cancel();
        this.f114961s.removeAllListeners();
        this.f114961s = null;
    L8:
        RoomContext r101 = RoomContext.getShared(this.dataCenter);
        if (r101 == null) goto L11;
        r101.getCastScreenEntryDismissTimer().getValue().release();
    L11:
        hd0.c.f().e(this.f114956n);
        super.onDestroy();
        wq(0);
        this.f114963u = Integer.MIN_VALUE;
        WeakReference<View> r102 = FullVideoButtonWidgetPaidUtil.f114341c;
        if (r102 == null) goto L14;
        r102.clear();
    L14:
        Disposable r103 = FullVideoButtonWidgetPaidUtil.f114340b;
        if (r103 == null) goto L17;
        r103.dispose();
    L17:
        EntranceChecker r104 = this.f114964v;
        if (r104 == null) goto L21;
        r104.h();
        return;
    }

    public final void xq() {
        Disposable r100 = this.f114958p;
        if (r100 != null) goto L5;
    L7:
        Disposable r101 = this.f114959q;
        if (r101 != null) goto L10;
    L12:
        Disposable r102 = this.f114960r;
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.isDisposed() == true) goto L19;
        this.f114960r.dispose();
        return;
    L19:
        return;
    L10:
        if (r101.isDisposed() == true) goto L12;
        this.f114959q.dispose();
        goto L12
    L5:
        if (r100.isDisposed() == true) goto L7;
        this.f114958p.dispose();
        goto L7
    }

    public final boolean yq() {
        RoomContext.a r100 = RoomContext.Companion;
        DataCenter r101 = this.dataCenter;
        long r102 = this.f114943a;
        r100.getClass();
        RoomContext r103 = RoomContext.a.a(r101, r102);
        if (lj.f120685a.getValue().b() != 2) goto L10;
        if (r103 == null) goto L10;
        if (VSMediaUIConfigHelper.b(this.dataCenter) == true) goto L10;
        if (r103.isShowFullScreenUIByClickScreen().getValue() == null) goto L10;
        return !r103.isShowFullScreenUIByClickScreen().getValue().booleanValue();
    L10:
        return false;
    }

    public FullVideoButtonWidget() {
        this.f114944b = true;
        this.f114945c = false;
        this.f114946d = true;
        this.f114947e = false;
        this.f114948f = false;
        this.f114949g = false;
        this.f114950h = false;
        this.f114951i = true;
        this.f114953k = false;
        this.f114955m = false;
        this.f114957o = new CompositeDisposable();
        this.f114958p = null;
        this.f114959q = null;
        this.f114960r = null;
        this.f114961s = null;
        this.f114962t = 0;
        this.f114963u = Integer.MIN_VALUE;
        this.f114965w = true;
    }

    public final void Cq() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Room r100 = (Room) this.dataCenter.get("data_room", null);
        boolean r101 = zq(r100);
        int r102 = 0;
        if (r101 == true) goto L8;
    L27:
        boolean r103 = false;
    L28:
        this.f114946d = r103;
        if (this.f114952j.getVisibility() == 0) goto L31;
        boolean r104 = true;
    L32:
        StringBuilder r105 = new StringBuilder("isEnableSwitchLandscape:");
        r105.append(r101);
        r105.append("\tmIsVideoHorizontal:");
        r105.append(this.f114944b);
        r105.append("\t!mIsShowKeyboard:");
        r105.append(!this.f114945c);
        r105.append("\t!mIsInLinkMode:");
        r105.append(!this.f114947e);
        r105.append("\t!mIsInMultiLinkMode:");
        r105.append(!this.f114948f);
        r105.append("\tisShowEntrance:");
        r105.append(this.f114965w);
        r105.append("\t!mIsMediaIntroduceShowing:");
        r105.append(!this.f114950h);
        ALogger.i("FullButton", r105.toString());
        View r106 = this.f114952j;
        if (this.f114946d == true) goto L36;
        r102 = 8;
    L36:
        r106.setVisibility(r102);
        if (yq() == false) goto L39;
        this.f114952j.setVisibility(8);
    L39:
        if (r104 == true) goto L41;
    L43:
        if (r104 == true) goto L45;
        return;
    L45:
        if (yq() == false) goto L47;
        return;
    L47:
        if (this.f114946d == false) goto L54;
        DataCenter r107 = this.dataCenter;
        if (r107 == null) goto L55;
        com.bytedance.android.livesdk.castscreen.utils.f.b("screen_rotate_icon_show", r107, r100, new q0(this));
        return;
    L55:
        return;
    L54:
        return;
    L41:
        if (yq() == true) goto L43;
        ut1.h.c();
        goto L43
    L31:
        r104 = false;
        goto L32
    L8:
        if (this.f114944b == false) goto L27;
        if (this.f114945c == true) goto L27;
        if (this.f114947e == true) goto L27;
        if (this.f114948f == true) goto L27;
        if (this.f114965w == false) goto L27;
        if (this.f114950h == true) goto L27;
        ListenLiveStatus r108 = (ListenLiveStatus) this.dataCenter.get("cmd_change_listen_live_status", null);
        if (r108 != null) goto L22;
    L24:
        boolean r109 = false;
    L25:
        if (r109 == true) goto L27;
        r103 = true;
        goto L28
    L22:
        if (r108.isOpen() == false) goto L24;
        r109 = true;
        goto L25
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [com.bytedance.android.livesdk.chatroom.viewmodule.p0] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.f114952j = this.contentView.findViewById(R.id.full_video_button);
        this.f114954l = this.contentView.findViewById(R.id.full_video_button_pop);
        boolean r100 = true;
        com.bytedance.android.livesdk.r3.c(this.f114952j, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_label_full_video_button), true);
        this.dataCenter.observe("data_keyboard_status", this).observe("cmd_pk_state_change", this, true).observe("multi_anchor_sei_update", this, true).observe("multi_anchor_sei_close", this, true).observe("cmd_video_orientation_changed", this, true).observe("data_media_introduction_showing", this).observe("paid_live_paid_info_update", this).observe("data_feedback_bottombar_height", this).observe("cmd_change_listen_live_status", this);
        this.f114943a = ((Long) this.dataCenter.get("data_room_id")).longValue();
        this.f114952j.setOnClickListener(new n0(this));
        DataCenter r101 = this.dataCenter;
        Boolean r102 = Boolean.TRUE;
        this.f114951i = ((Boolean) r101.get("data_is_portrait", r102)).booleanValue();
        EntranceChecker r103 = this.f114964v;
        if (r103 == null) goto L5;
        r103.d();
        this.f114965w = this.f114964v.a(com.bytedance.android.live.room.api.screenrotation.entrance.c.f99124b);
        this.f114957o.add(this.f114964v.f99117b.f570051b.subscribe((Consumer<? super T>) new o0(this)));
    L5:
        this.f114956n = new p0(this);
        hd0.c.f().c(this.f114956n);
        RoomContext.a r104 = RoomContext.Companion;
        DataCenter r105 = this.dataCenter;
        long r106 = this.f114943a;
        r104.getClass();
        RoomContext r107 = RoomContext.a.a(r105, r106);
        Cq();
        if (VSMediaUIConfigHelper.b(this.dataCenter) == false) goto L8;
    L21:
        this.f114963u = Integer.MIN_VALUE;
        mk1.a r108 = FullVideoButtonWidgetPaidUtil.f114339a;
        FullVideoButtonWidgetPaidUtil.a(this.dataCenter, this.containerView);
        if (LiveInfraSettingKeys.LIVE_XML_AND_DRAWABLE_CACHE_CONFIG.getValue().a() == false) goto L27;
        int[] r109 = {R.drawable.ttlive_ic_full_video, R.drawable.ttlive_ic_full_video_disable, R.drawable.ttlive_ic_full_video_new, R.drawable.ttlive_ic_full_video_new_disable, R.drawable.ttlive_ic_full_video_auto_dismiss, R.drawable.ttlive_ic_full_video_style_one, R.drawable.ttlive_ic_full_video_style_two};
        JatoOptDrawableCache.preloadDrawableCache(this.context.getResources(), r109);     // Catch: Exception -> L26
    L27:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r110 = com.bytedance.android.livesdk.sharedpref.b.N;
        if (r110.getValue().booleanValue() == true) goto L35;
        if (((Boolean) this.dataCenter.get("data_longer_video_within_live_type", Boolean.FALSE)).booleanValue() == false) goto L33;
        TimeUnit r111 = TimeUnit.SECONDS;
        this.f114959q = Observable.timer(20, r111).observeOn(AndroidSchedulers.mainThread()).subscribe(new s0(this));
        this.f114960r = Observable.timer(25, r111).observeOn(AndroidSchedulers.mainThread()).subscribe(new t0(this));
        com.bytedance.android.livesdk.sharedpref.f.d(r110, Boolean.TRUE);
        goto L35
    L33:
        this.f114954l.setVisibility(8);
    L35:
        if (LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue().booleanValue() == true) goto L37;
        return;
    L37:
        if (zq((Room) this.dataCenter.get("data_room", null)) == true) goto L39;
    L41:
        r100 = false;
    L42:
        this.f114953k = r100;
        DataCenter r112 = this.dataCenter;
        if (r112 != null) goto L45;
    L47:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
        return;
    L45:
        if (RoomContext.getShared(r112) == null) goto L47;
        RoomContext.getShared(this.dataCenter).setLiveEnableSwitchLandscape(r100);
        return;
    L39:
        if (this.f114944b == false) goto L41;
    L8:
        if (com.bytedance.android.livesdk.utils.landscape.d.a() != 1) goto L10;
        boolean r113 = true;
    L11:
        if (r113 == false) goto L21;
        if (this.f114946d == true) goto L15;
    L20:
        ((ObservableSubscribeProxy) r107.isShowFullScreenUIByClickScreen().a().as(autoDispose())).subscribe(new u0(this));
        goto L21
    L15:
        if (r107.isShowFullScreenUIByClickScreen().getValue() == null) goto L17;
        r107.isShowFullScreenUIByClickScreen().setValue(r102);
    L17:
        final RoomContext r114 = RoomContext.getShared(this.dataCenter);
        if (r114 == null) goto L20;
        xq();
        this.f114958p = r114.getCastScreenEntryDismissTimer().getValue().a().observeOn(AndroidSchedulers.mainThread()).subscribe(new r0(r114));
        goto L20
    L10:
        r113 = false;
        goto L11
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        lj r100 = lj.f120685a;
        if (r100.getValue().b() != 2) goto L6;
        RoomContext.a r101 = RoomContext.Companion;
        DataCenter r102 = this.dataCenter;
        long r103 = this.f114943a;
        r101.getClass();
        RoomContext r104 = RoomContext.a.a(r102, r103);
        Bq(true);
        xq();
        this.f114958p = Observable.timer(r100.getValue().a(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new v0(r104));
        return;
    }

    public final void Aq(boolean r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 != null) goto L5;
    L12:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
        return;
    L5:
        if (RoomContext.getShared(r101) == null) goto L12;
        if (r100 == true) goto L8;
        return;
    L8:
        if (LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue().booleanValue() == true) goto L10;
        return;
    L10:
        if (RoomContext.getShared(this.dataCenter).isLiveLoggedEntraceSupport() == true) goto L16;
        com.bytedance.android.livesdk.log.u.l().sendLog("live_landscape_screen_enabled", null, new Object[]{new am2.x(), Room.class});
        RoomContext.getShared(this.dataCenter).setLiveLoggedEntraceSupport(true);
        return;
    }

    public final void Bq(boolean r100) {
        if (VSMediaUIConfigHelper.b(this.dataCenter) == false) goto L5;
        return;
    L5:
        ObjectAnimator r101 = this.f114961s;
        if (r101 == null) goto L11;
        if (r101.isRunning() != true) goto L11;
        this.f114961s.cancel();
    L11:
        if (r100 == false) goto L13;
        this.f114961s = ObjectAnimator.ofFloat(this.f114952j, "alpha", new float[]{0.0f, 1.0f});
    L14:
        this.f114961s.setDuration(500);
        this.f114961s.removeAllListeners();
        this.f114961s.addListener(new a(this, r100));
        this.f114961s.start();
        return;
    L13:
        this.f114961s = ObjectAnimator.ofFloat(this.f114952j, "alpha", new float[]{1.0f, 0.0f});
        goto L14
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        RoomContext.a r101 = RoomContext.Companion;
        DataCenter r102 = this.dataCenter;
        long r103 = this.f114943a;
        r101.getClass();
        RoomContext.a.a(r102, r103);
        return true;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (isViewValid() == false) goto L94;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getData() != null) goto L8;
        return;
    L8:
        if (isViewValid() == false) goto L107;
        String r102 = r101.getKey();
        r102.getClass();
        boolean r103 = false;
        byte r104 = -1;
        switch(r102.hashCode()) {
            case -1540323875: goto L46;
            case 61848565: goto L42;
            case 193203799: goto L38;
            case 262358348: goto L34;
            case 309908432: goto L30;
            case 1060055221: goto L26;
            case 1450672227: goto L22;
            case 1631824572: goto L18;
            case 1992738009: goto L14;
            default: goto L49;
        };
    L49:
        switch(r104) {
            case 0: goto L81;
            case 1: goto L77;
            case 2: goto L75;
            case 3: goto L72;
            case 4: goto L70;
            case 5: goto L68;
            case 6: goto L66;
            case 7: goto L52;
            case 8: goto L51;
            default: goto L108;
        };
    L51:
        this.f114955m = ((Boolean) r101.getData()).booleanValue();
        return;
    L52:
        this.f114944b = ((zg1.k3) r101.getData()).f571869a;
        Cq();
        if (LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue().booleanValue() == true) goto L55;
        return;
    L55:
        if (zq((Room) this.dataCenter.get("data_room", null)) == true) goto L57;
    L59:
        this.f114953k = r103;
        DataCenter r105 = this.dataCenter;
        if (r105 != null) goto L62;
    L64:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
    L65:
        Aq(this.f114953k);
        return;
    L62:
        if (RoomContext.getShared(r105) == null) goto L64;
        RoomContext.getShared(this.dataCenter).setLiveEnableSwitchLandscape(r103);
        goto L65
    L57:
        if (this.f114944b == false) goto L59;
        r103 = true;
        goto L59
    L66:
        wq(((Integer) r101.getData()).intValue());
        return;
    L70:
        this.f114950h = ((Boolean) r101.getData()).booleanValue();
        Cq();
        return;
    L75:
        Cq();
        return;
    L108:
        return;
    L68:
        if (this.f114964v != null) goto L101;
        this.f114945c = ((Boolean) r101.getData()).booleanValue();
        Cq();
        return;
    L101:
        return;
    L72:
        if (this.f114951i == false) goto L109;
        this.f114948f = false;
        Cq();
        return;
    L109:
        return;
    L77:
        if (this.f114951i == false) goto L110;
        this.f114948f = true;
        Cq();
        return;
    L110:
        return;
    L81:
        if (this.f114951i == false) goto L111;
        zg1.z0 r106 = (zg1.z0) r101.getData();
        if (r106 == null) goto L112;
        int r107 = r106.f572034a;
        if (r107 != 0) goto L89;
        this.f114947e = true;
    L92:
        Cq();
        return;
    L89:
        if (r107 != 1) goto L91;
        this.f114947e = false;
        goto L92
    L91:
        this.f114947e = ((ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class)).getControlServiceExternal().c();
        goto L92
    L112:
        return;
    L111:
        return;
    L14:
        if (r102.equals("has_group_purchase_business") == false) goto L49;
        r104 = 8;
        goto L49
    L18:
        if (r102.equals("cmd_video_orientation_changed") == false) goto L49;
        r104 = 7;
        goto L49
    L22:
        if (r102.equals("data_feedback_bottombar_height") == false) goto L49;
        r104 = 6;
        goto L49
    L26:
        if (r102.equals("data_keyboard_status") == false) goto L49;
        r104 = 5;
        goto L49
    L30:
        if (r102.equals("data_media_introduction_showing") == false) goto L49;
        r104 = 4;
        goto L49
    L34:
        if (r102.equals("multi_anchor_sei_close") == false) goto L49;
        r104 = 3;
        goto L49
    L38:
        if (r102.equals("cmd_change_listen_live_status") == false) goto L49;
        r104 = 2;
        goto L49
    L42:
        if (r102.equals("multi_anchor_sei_update") == false) goto L49;
        r104 = 1;
        goto L49
    L46:
        if (r102.equals("cmd_pk_state_change") == false) goto L49;
        r104 = 0;
        goto L49
    L107:
        return;
    }

    public final void wq(int r100) {
        View r101 = this.contentView;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVisibility() == 0) goto L7;
        return;
    L7:
        if (this.f114951i == true) goto L10;
        return;
    L10:
        if ((this.containerView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) this.containerView.getLayoutParams();
        if (this.f114963u != Integer.MIN_VALUE) goto L14;
        this.f114963u = r102.bottomMargin;
    L14:
        r102.bottomMargin = this.f114963u + r100;
        this.containerView.setLayoutParams(r102);
        return;
    }

    public final boolean zq(Room r100) {
        if (r100 != null) goto L5;
    L10:
        boolean r101 = true;
    L12:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).isPaidLive() == false) goto L15;
        return true;
    L15:
        return r101;
    L5:
        if (r100.getRoomAuthStatus() == null) goto L10;
        if (r100.getRoomAuthStatus().isEnableSwitchLandscape() == true) goto L10;
        r101 = false;
        goto L12
    }
}
