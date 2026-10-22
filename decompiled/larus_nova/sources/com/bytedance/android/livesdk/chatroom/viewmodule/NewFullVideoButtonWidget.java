package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.FullVideoButtonWidgetPaidUtil;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.lj;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomFullVideoBtn;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
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
public class NewFullVideoButtonWidget extends LiveWidget implements Observer<KVData>, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, com.bytedance.android.live.room.api.visibilitycontrol.b {
    public EntranceChecker A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f114992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f114993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f114994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f114995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f114996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f114997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f114998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f114999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f115000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f115001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f115002k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f115003l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f115004m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f115005n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f115006o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f115007p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f115008q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h2 f115009r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f115010s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Disposable f115011t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Disposable f115012u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Disposable f115013v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ObjectAnimator f115014w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f115015x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f115016y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f115017z;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f115018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NewFullVideoButtonWidget f115019b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            if (this.f115018a == true) goto L6;
            this.f115019b.f115006o.setVisibility(8);
            return;
        }

        public a(NewFullVideoButtonWidget r100, boolean r101) {
            this.f115019b = r100;
            this.f115018a = r101;
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

    public final boolean Aq() {
        RoomContext.a r100 = RoomContext.Companion;
        DataCenter r101 = this.dataCenter;
        long r102 = this.f114992a;
        r100.getClass();
        RoomContext r103 = RoomContext.a.a(r101, r102);
        if (lj.f120685a.getValue().b() != 2) goto L10;
        if (r103 == null) goto L10;
        if (zq(this.dataCenter) == true) goto L10;
        if (r103.isShowFullScreenUIByClickScreen().getValue() == null) goto L10;
        return !r103.isShowFullScreenUIByClickScreen().getValue().booleanValue();
    L10:
        return false;
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
        Cq(this.f114995d);
    L5:
        this.f115010s.clear();
        yq();
        this.dataCenter.removeObserver(this);
        ObjectAnimator r100 = this.f115014w;
        if (r100 == null) goto L8;
        r100.cancel();
        this.f115014w.removeAllListeners();
        this.f115014w = null;
    L8:
        RoomContext r101 = RoomContext.getShared(this.dataCenter);
        if (r101 == null) goto L11;
        r101.getCastScreenEntryDismissTimer().getValue().release();
    L11:
        hd0.c.f().e(this.f115009r);
        super.onDestroy();
        xq(0);
        this.f115016y = Integer.MIN_VALUE;
        WeakReference<View> r102 = FullVideoButtonWidgetPaidUtil.f114341c;
        if (r102 == null) goto L14;
        r102.clear();
    L14:
        Disposable r103 = FullVideoButtonWidgetPaidUtil.f114340b;
        if (r103 == null) goto L17;
        r103.dispose();
    L17:
        EntranceChecker r104 = this.A;
        if (r104 == null) goto L21;
        r104.h();
        return;
    }

    public final void yq() {
        Disposable r100 = this.f115011t;
        if (r100 != null) goto L5;
    L7:
        Disposable r101 = this.f115012u;
        if (r101 != null) goto L10;
    L12:
        Disposable r102 = this.f115013v;
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.isDisposed() == true) goto L19;
        this.f115013v.dispose();
        return;
    L19:
        return;
    L10:
        if (r101.isDisposed() == true) goto L12;
        this.f115012u.dispose();
        goto L12
    L5:
        if (r100.isDisposed() == true) goto L7;
        this.f115011t.dispose();
        goto L7
    }

    public NewFullVideoButtonWidget() {
        this.f114994c = true;
        this.f114995d = false;
        this.f114996e = false;
        this.f114997f = true;
        this.f114998g = false;
        this.f114999h = false;
        this.f115000i = false;
        this.f115001j = false;
        this.f115002k = false;
        this.f115003l = true;
        this.f115004m = false;
        this.f115005n = false;
        this.f115008q = false;
        this.f115010s = new CompositeDisposable();
        this.f115011t = null;
        this.f115012u = null;
        this.f115013v = null;
        this.f115014w = null;
        this.f115015x = 0;
        this.f115016y = Integer.MIN_VALUE;
        this.f115017z = false;
        this.B = true;
    }

    public final void Gq() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Room r100 = (Room) this.dataCenter.get("data_room", null);
        boolean r101 = Bq(r100);
        int r102 = 0;
        if (r101 == true) goto L8;
    L28:
        boolean r103 = false;
    L29:
        this.f114997f = r103;
        if (this.f115006o.getVisibility() == 0) goto L32;
        boolean r104 = true;
    L33:
        StringBuilder r105 = new StringBuilder("isEnableSwitchLandscape:");
        r105.append(r101);
        r105.append("\tmIsVideoHorizontal:");
        r105.append(this.f114994c);
        r105.append("\t!mIsShowKeyboard:");
        r105.append(!this.f114996e);
        r105.append("\t!mIsInLinkMode:");
        r105.append(!this.f114998g);
        r105.append("\t!mIsInMultiLinkMode:");
        r105.append(!this.f114999h);
        r105.append("\tisShowEntrance:");
        r105.append(this.B);
        r105.append("\tmIsMultiFoldFlatState:");
        r105.append(this.f115005n);
        r105.append("\t!mIsMediaIntroduceShowing:");
        r105.append(!this.f115002k);
        ALogger.i("FullButton", r105.toString());
        HSImageView r106 = this.f115006o;
        if (this.f114997f == true) goto L37;
        r102 = 8;
    L37:
        r106.setVisibility(r102);
        if (Aq() == false) goto L40;
        this.f115006o.setVisibility(8);
    L40:
        if (r104 == true) goto L42;
    L44:
        if (r104 == true) goto L46;
        return;
    L46:
        if (Aq() == false) goto L48;
        return;
    L48:
        if (this.f114997f == false) goto L55;
        DataCenter r107 = this.dataCenter;
        if (r107 == null) goto L56;
        com.bytedance.android.livesdk.castscreen.utils.f.b("screen_rotate_icon_show", r107, r100, new e2(this));
        return;
    L56:
        return;
    L55:
        return;
    L42:
        if (Aq() == true) goto L44;
        ut1.h.c();
        goto L44
    L32:
        r104 = false;
        goto L33
    L8:
        if (this.f114994c == false) goto L28;
        if (this.f114996e == true) goto L28;
        if (this.f114998g == false) goto L16;
        if (this.f115017z == false) goto L28;
    L16:
        if (this.f114999h == false) goto L22;
        IRoom r108 = this.f114993b;
        if (r108 == null) goto L28;
        if (r108.getStreamType() != LiveMode.SCREEN_RECORD) goto L28;
    L22:
        if (this.B == false) goto L28;
        if (this.f115005n == true) goto L28;
        if (this.f115002k == true) goto L28;
        r103 = true;
        goto L29
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [com.bytedance.android.livesdk.chatroom.viewmodule.h2] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.f115006o = (HSImageView) this.contentView.findViewById(R.id.full_video_button);
        this.f115007p = this.contentView.findViewById(R.id.full_video_button_pop);
        boolean r100 = true;
        com.bytedance.android.livesdk.r3.c(this.f115006o, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_label_full_video_button), true);
        this.dataCenter.observe("data_keyboard_status", this).observe("cmd_pk_state_change", this, true).observe("multi_anchor_sei_update", this, true).observe("multi_anchor_sei_close", this, true).observe("cmd_video_orientation_changed", this, true).observe("data_media_introduction_showing", this).observe("paid_live_paid_info_update", this).observe("data_feedback_bottombar_height", this).observe("cmd_multi_state_change", this);
        this.dataCenter.observe("data_pc_landscape_linkmic", this);
        this.f114992a = ((Long) this.dataCenter.get("data_room_id")).longValue();
        this.f115006o.setOnClickListener(new f2(this));
        DataCenter r101 = this.dataCenter;
        Boolean r102 = Boolean.TRUE;
        this.f115003l = ((Boolean) r101.get("data_is_portrait", r102)).booleanValue();
        EntranceChecker r103 = this.A;
        if (r103 == null) goto L5;
        r103.d();
        this.B = this.A.a(com.bytedance.android.live.room.api.screenrotation.entrance.c.f99124b);
        this.f115010s.add(this.A.f99117b.f570051b.subscribe((Consumer<? super T>) new g2(this)));
    L5:
        zg1.u1 r104 = (zg1.u1) this.dataCenter.get("cmd_multi_state_change");
        if (r104 != null) goto L8;
    L10:
        this.f115009r = new h2(this);
        hd0.c.f().c(this.f115009r);
        RoomContext.a r105 = RoomContext.Companion;
        DataCenter r106 = this.dataCenter;
        long r107 = this.f114992a;
        r105.getClass();
        RoomContext r108 = RoomContext.a.a(r106, r107);
        if (r108 == null) goto L16;
        if (r108.getRoom() == null) goto L16;
        this.f114993b = r108.getRoom().getValue();
    L16:
        if (LiveInfraSettingKeys.LIVE_MULTI_DEVICE_BLOCK_FULL_SCREEN_MODE.getValue().booleanValue() == false) goto L24;
        boolean r109 = com.bytedance.android.livesdk.chatroom.utils.e1.b();
        this.f115004m = r109;
        if (r109 == true) goto L20;
    L22:
        boolean r110 = false;
    L23:
        this.f115005n = r110;
        goto L24
    L20:
        if (com.bytedance.android.livesdk.chatroom.utils.e1.c() == false) goto L22;
        r110 = true;
    L24:
        Gq();
        if (zq(this.dataCenter) == false) goto L27;
    L40:
        this.f115016y = Integer.MIN_VALUE;
        mk1.a r111 = FullVideoButtonWidgetPaidUtil.f114339a;
        FullVideoButtonWidgetPaidUtil.a(this.dataCenter, this.containerView);
        if (LiveInfraSettingKeys.LIVE_XML_AND_DRAWABLE_CACHE_CONFIG.getValue().a() == false) goto L46;
        int[] r112 = {R.drawable.ttlive_ic_full_video_new, R.drawable.ttlive_ic_full_video_new_disable};
        JatoOptDrawableCache.preloadDrawableCache(this.context.getResources(), r112);     // Catch: Exception -> L45
    L46:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r113 = com.bytedance.android.livesdk.sharedpref.b.N;
        if (r113.getValue().booleanValue() == true) goto L54;
        if (((Boolean) this.dataCenter.get("data_longer_video_within_live_type", Boolean.FALSE)).booleanValue() == false) goto L52;
        TimeUnit r114 = TimeUnit.SECONDS;
        this.f115012u = Observable.timer(20, r114).observeOn(AndroidSchedulers.mainThread()).subscribe(new j2(this));
        this.f115013v = Observable.timer(25, r114).observeOn(AndroidSchedulers.mainThread()).subscribe(new k2(this));
        com.bytedance.android.livesdk.sharedpref.f.d(r113, Boolean.TRUE);
        goto L54
    L52:
        this.f115007p.setVisibility(8);
    L54:
        if (LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue().booleanValue() == true) goto L56;
        return;
    L56:
        if (Bq((Room) this.dataCenter.get("data_room", null)) == true) goto L58;
    L60:
        r100 = false;
    L61:
        this.f114995d = r100;
        DataCenter r115 = this.dataCenter;
        if (r115 != null) goto L64;
    L66:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
        return;
    L64:
        if (RoomContext.getShared(r115) == null) goto L66;
        RoomContext.getShared(this.dataCenter).setLiveEnableSwitchLandscape(r100);
        return;
    L58:
        if (this.f114994c == false) goto L60;
    L27:
        if (com.bytedance.android.livesdk.utils.landscape.d.a() != 1) goto L29;
        boolean r116 = true;
    L30:
        if (r116 == false) goto L40;
        if (this.f114997f == true) goto L34;
    L39:
        ((ObservableSubscribeProxy) r108.isShowFullScreenUIByClickScreen().a().as(autoDispose())).subscribe(new l2(this));
        goto L40
    L34:
        if (r108.isShowFullScreenUIByClickScreen().getValue() == null) goto L36;
        r108.isShowFullScreenUIByClickScreen().setValue(r102);
    L36:
        final RoomContext r117 = RoomContext.getShared(this.dataCenter);
        if (r117 == null) goto L39;
        yq();
        this.f115011t = r117.getCastScreenEntryDismissTimer().getValue().a().observeOn(AndroidSchedulers.mainThread()).subscribe(new i2(r117));
        goto L39
    L29:
        r116 = false;
        goto L30
    L8:
        if (this.f115003l == false) goto L10;
        Eq(r104);
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        lj r100 = lj.f120685a;
        if (r100.getValue().b() != 2) goto L6;
        RoomContext.a r101 = RoomContext.Companion;
        DataCenter r102 = this.dataCenter;
        long r103 = this.f114992a;
        r101.getClass();
        RoomContext r104 = RoomContext.a.a(r102, r103);
        Fq(true);
        yq();
        this.f115011t = Observable.timer(r100.getValue().a(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m2(r104));
        return;
    }

    public static boolean zq(DataCenter r100) {
        Room r101 = (Room) r100.get("data_room", null);
        if (r101 == null) goto L12;
        RoomPlatformComponentsData r102 = r101.roomPlatformComponentsData;
        if (r102 != null) goto L7;
        return true;
    L7:
        if (r102.getFullVideoBtn() != null) goto L9;
        return true;
    L9:
        if (r101.roomPlatformComponentsData.getFullVideoBtn().getShowType() != RoomFullVideoBtn.FullVideoBtnShowType.is_AUTO_DISMISS.getType()) goto L16;
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public final boolean Bq(Room r100) {
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

    public final void Cq(boolean r100) {
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

    public final void Eq(zg1.u1 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f571951f != 1) goto L7;
        this.f114999h = true;
    L9:
        if (r100.f571958m == false) goto L11;
        this.f115017z = true;
        this.f114999h = false;
    L12:
        Gq();
        return;
    L11:
        this.f115017z = false;
        goto L12
    L7:
        this.f114999h = false;
        goto L9
    }

    public final void Fq(boolean r100) {
        if (zq(this.dataCenter) == false) goto L5;
        return;
    L5:
        ObjectAnimator r101 = this.f115014w;
        if (r101 == null) goto L11;
        if (r101.isRunning() != true) goto L11;
        this.f115014w.cancel();
    L11:
        if (r100 == false) goto L13;
        this.f115014w = ObjectAnimator.ofFloat(this.f115006o, "alpha", new float[]{0.0f, 1.0f});
    L14:
        this.f115014w.setDuration(500);
        this.f115014w.removeAllListeners();
        this.f115014w.addListener(new a(this, r100));
        this.f115014w.start();
        return;
    L13:
        this.f115014w = ObjectAnimator.ofFloat(this.f115006o, "alpha", new float[]{1.0f, 0.0f});
        goto L14
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        RoomContext.a r101 = RoomContext.Companion;
        DataCenter r102 = this.dataCenter;
        long r103 = this.f114992a;
        r101.getClass();
        RoomContext.a.a(r102, r103);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (isViewValid() == false) goto L88;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getData() != null) goto L8;
        return;
    L8:
        if (isViewValid() == false) goto L101;
        String r102 = r101.getKey();
        r102.getClass();
        boolean r103 = true;
        byte r104 = -1;
        switch(r102.hashCode()) {
            case -1540323875: goto L42;
            case -1091008631: goto L38;
            case 192996530: goto L34;
            case 309908432: goto L30;
            case 1060055221: goto L26;
            case 1450672227: goto L22;
            case 1631824572: goto L18;
            case 1992738009: goto L14;
            default: goto L45;
        };
    L45:
        switch(r104) {
            case 0: goto L76;
            case 1: goto L70;
            case 2: goto L68;
            case 3: goto L67;
            case 4: goto L65;
            case 5: goto L63;
            case 6: goto L48;
            case 7: goto L47;
            default: goto L102;
        };
    L47:
        this.f115008q = ((Boolean) r101.getData()).booleanValue();
        return;
    L48:
        this.f114994c = ((zg1.k3) r101.getData()).f571869a;
        Gq();
        if (LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue().booleanValue() == true) goto L51;
        return;
    L51:
        if (Bq((Room) this.dataCenter.get("data_room", null)) == true) goto L53;
    L55:
        r103 = false;
    L56:
        this.f114995d = r103;
        DataCenter r105 = this.dataCenter;
        if (r105 != null) goto L59;
    L61:
        ALogger.i("LandscapeButtonWidget", "dataCenter || RoomContext is null");
    L62:
        Cq(this.f114995d);
        return;
    L59:
        if (RoomContext.getShared(r105) == null) goto L61;
        RoomContext.getShared(this.dataCenter).setLiveEnableSwitchLandscape(r103);
        goto L62
    L53:
        if (this.f114994c == false) goto L55;
    L63:
        xq(((Integer) r101.getData()).intValue());
        return;
    L67:
        this.f115002k = ((Boolean) r101.getData()).booleanValue();
        Gq();
        return;
    L68:
        this.f115001j = ((Boolean) r101.getData()).booleanValue();
        wq(((Integer) hd0.c.f().f481009b).intValue());
        return;
    L102:
        return;
    L65:
        if (this.A != null) goto L95;
        this.f114996e = ((Boolean) r101.getData()).booleanValue();
        Gq();
        return;
    L95:
        return;
    L70:
        if (this.f115003l == true) goto L73;
        return;
    L73:
        if (r101.getData() == null) goto L99;
        Eq((zg1.u1) r101.getData());
        return;
    L99:
        return;
    L76:
        if (this.f115003l == false) goto L104;
        zg1.z0 r106 = (zg1.z0) r101.getData();
        if (r106 == null) goto L105;
        int r107 = r106.f572034a;
        if (r107 != 0) goto L84;
        this.f114998g = true;
        this.f115017z = r106.f572036c;
    L86:
        Gq();
        return;
    L84:
        if (r107 != 1) goto L86;
        this.f114998g = false;
        this.f115017z = false;
        goto L86
    L105:
        return;
    L104:
        return;
    L14:
        if (r102.equals("has_group_purchase_business") == false) goto L45;
        r104 = 7;
        goto L45
    L18:
        if (r102.equals("cmd_video_orientation_changed") == false) goto L45;
        r104 = 6;
        goto L45
    L22:
        if (r102.equals("data_feedback_bottombar_height") == false) goto L45;
        r104 = 5;
        goto L45
    L26:
        if (r102.equals("data_keyboard_status") == false) goto L45;
        r104 = 4;
        goto L45
    L30:
        if (r102.equals("data_media_introduction_showing") == false) goto L45;
        r104 = 3;
        goto L45
    L34:
        if (r102.equals("data_pc_landscape_linkmic") == false) goto L45;
        r104 = 2;
        goto L45
    L38:
        if (r102.equals("cmd_multi_state_change") == false) goto L45;
        r104 = 1;
        goto L45
    L42:
        if (r102.equals("cmd_pk_state_change") == false) goto L45;
        r104 = 0;
        goto L45
    L101:
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (this.f115004m == false) goto L6;
        this.f115005n = com.bytedance.android.livesdk.chatroom.utils.e1.c();
        Gq();
        return;
    }

    public final void wq(int r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L25;
        Room r102 = (Room) r101.get("data_room", null);
        if (r102 == null) goto L23;
        RoomPlatformComponentsData r103 = r102.roomPlatformComponentsData;
        if (r103 == null) goto L23;
        if (r103.getFullVideoBtn() == null) goto L23;
        if (r102.roomPlatformComponentsData.getFullVideoBtn().getShow() == RoomFullVideoBtn.FullVideoBtnShow.is_Close.getType()) goto L23;
        if (r100 != 0) goto L19;
        if (r102.roomPlatformComponentsData.getFullVideoBtn().getIcon() != null) goto L17;
        ImageLoader.bindDrawableResource(this.f115006o, R.drawable.ttlive_ic_full_video_new);
    L22:
        this.f115006o.setVisibility(0);
        return;
    L17:
        com.bytedance.android.livesdk.chatroom.utils.a1.x(this.f115006o, r102.roomPlatformComponentsData.getFullVideoBtn().getIcon(), (int) t6.a(this.context, 36.0f), (int) t6.a(this.context, 36.0f), R.drawable.ttlive_ic_full_video_new);
        goto L22
    L19:
        if (r102.roomPlatformComponentsData.getFullVideoBtn().getIcon() != null) goto L21;
        ImageLoader.bindDrawableResource(this.f115006o, R.drawable.ttlive_ic_full_video_new_disable);
        goto L22
    L21:
        com.bytedance.android.livesdk.chatroom.utils.a1.x(this.f115006o, r102.roomPlatformComponentsData.getFullVideoBtn().getDisableIcon(), (int) t6.a(this.context, 36.0f), (int) t6.a(this.context, 36.0f), R.drawable.ttlive_ic_full_video_new_disable);
    L23:
        this.f115006o.setVisibility(8);
        return;
    }

    public final void xq(int r100) {
        View r101 = this.contentView;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVisibility() == 0) goto L7;
        return;
    L7:
        if (this.f115003l == true) goto L10;
        return;
    L10:
        if ((this.containerView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) this.containerView.getLayoutParams();
        if (this.f115016y != Integer.MIN_VALUE) goto L14;
        this.f115016y = r102.bottomMargin;
    L14:
        r102.bottomMargin = this.f115016y + r100;
        this.containerView.setLayoutParams(r102);
        return;
    }
}
