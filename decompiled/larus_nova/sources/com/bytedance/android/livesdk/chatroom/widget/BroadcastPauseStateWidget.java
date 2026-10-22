package com.bytedance.android.livesdk.chatroom.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateEvent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateIntent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStatesAndAVResourceUtils;
import com.bytedance.android.live.broadcast.api.framework.service.ILiveRoomStatusService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.jf;
import com.bytedance.android.livesdk.config.tq0;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/BroadcastPauseStateWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BroadcastPauseStateWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f118459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveMode f118460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorPauseTipsView f118461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f118462d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BroadcastPauseStateWidget f118463a;

        public a(BroadcastPauseStateWidget r100) {
            this.f118463a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            if (this.f118463a.wq() == false) goto L6;
            this.f118463a.dataCenter.put("cmd_broadcast_game_live_recover_error", Boolean.TRUE);
            return;
        L6:
            ILiveRoomStatusService r111 = (ILiveRoomStatusService) va1.b.a.f553922a.a(ILiveRoomStatusService.class);
            if (LiveRoomStatesAndAVResourceUtils.c() == true) goto L9;
        L17:
            BroadcastPauseStateWidget r112 = this.f118463a;
            r112.getClass();
            zg1.m r100 = new zg1.m();
            r100.f571877a = 3;
            r112.dataCenter.put("data_broadcast_pause_state", r100);
            this.f118463a.containerView.setVisibility(8);
            ILinkServiceExternal r113 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
            if (r113 == null) goto L20;
            r113.notifyPauseStatus(3);
        L20:
            HashMap r114 = new HashMap();
            r114.put(IPerformanceManager.Params.is_anchor, "1");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_recover_button_click", r114, new Object[]{am2.x.class, Room.class});
            HashMap r115 = new HashMap();
            r115.put(IPerformanceManager.Params.is_anchor, "1");
            r115.put("over_type", "recover");
            this.f118463a.getClass();
            r115.put("duration", String.valueOf(0));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_suspend_over", r115, new Object[]{am2.x.class, Room.class});
            return;
        L9:
            if (this.f118463a.f118460b != LiveMode.SCREEN_RECORD) goto L17;
            if (r111 == null) goto L17;
            boolean r116 = r111.requestRoomStateUpdate(new zz.b(LiveRoomStateUpdateIntent.RESUME, LiveRoomStateUpdateEvent.User, "BroadcastPauseStateWidget.onLoad", "BroadcastPauseStateWidget", MapsKt.hashMapOf(new Pair[]{TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, "BroadcastPauseEvent")})));
            BroadcastPauseStateWidget r101 = this.f118463a;
            if (r116 == false) goto L16;
            r101.containerView.setVisibility(8);
            ILinkServiceExternal r117 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
            if (r117 == null) goto L20;
            r117.notifyPauseStatus(3);
            goto L20
        L16:
            r101.getClass();
            goto L20
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BroadcastPauseStateWidget f118464a;

        public b(BroadcastPauseStateWidget r100) {
            this.f118464a = r100;
        }

        public final void a() {
            BroadcastPauseStateWidget r100 = this.f118464a;
            if (r100.f118459a == true) goto L28;
            AnchorPauseTipsView r101 = r100.f118461c;
            if (r101 == null) goto L30;
            Object r102 = null;
            if (r101 == null) goto L10;
            ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        L11:
            if (r103 == null) goto L27;
            FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
            DataCenter r105 = this.f118464a.dataCenter;
            if (r105 == null) goto L21;
            Object r106 = r105.get("cmd_data_interact_public_screen_height_change", null);
            if ((r106 instanceof i32.a) == false) goto L18;
            r102 = r106;
        L18:
            i32.a r107 = (i32.a) r102;
            if (r107 == null) goto L21;
            int r108 = r107.f488090b + r107.f488089a;
        L22:
            r104.bottomMargin = (r108 - com.bytedance.android.live.core.utils.s1.f(74)) / 2;
            r104.rightMargin = com.bytedance.android.live.core.utils.s1.f(((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().m());
            AnchorPauseTipsView r109 = this.f118464a.f118461c;
            if (r109 == null) goto L29;
            r109.setLayoutParams(r104);
            return;
        L29:
            return;
        L21:
            r108 = 0;
            goto L22
        L27:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L10:
            r103 = null;
            goto L11
        L30:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public int getLayoutId() {
        return R.layout.ttlive_broadcast_voluntary_pause_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public String getSpm() {
        return "a100.a100.a180";
    }

    public static void xq() {
        HashMap r100 = new HashMap();
        r100.put(IPerformanceManager.Params.is_anchor, "1");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_recover_button_show", r100, new Object[]{am2.x.class, Room.class});
    }

    public final void Aq() {
        Integer r100 = (Integer) this.dataCenter.get("data_screen_orientation", 1);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.intValue() == 1) goto L8;
        return;
    L8:
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L13;
        r101.post(new b(this));
        return;
    }

    public final boolean wq() {
        Integer r100 = (Integer) this.dataCenter.get("cmd_broadcast_game_live_intercept_state", 0);
        if (r100 != null) goto L6;
    L7:
        return true;
    L6:
        if (r100.intValue() != 0) goto L7;
        return false;
    }

    public final void yq() {
        if (tq0.f121319a.getValue().a() == true) goto L6;
        return;
    L6:
        if (this.f118459a == true) goto L8;
        return;
    L8:
        String r100 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_broadcast_voluntary_pause_anchor_hint);
        String r101 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_broadcast_voluntary_pause_recover_live);
        Integer r102 = (Integer) this.dataCenter.get("cmd_broadcast_game_live_intercept_state", 0);
        if (wq() == false) goto L25;
        if (r102 != null) goto L13;
    L15:
        if (r102 != null) goto L18;
    L20:
        if (r102 == null) goto L25;
        if (r102.intValue() != 4) goto L25;
        r100 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_broadcast_voluntary_pause_anchor_hint);
        r101 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_broadcast_voluntary_pause_recover_live);
        goto L25
    L18:
        if (r102.intValue() != 3) goto L20;
        r100 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_broadcast_net_lost_pause_anchor_hint);
        r101 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_broadcast_net_lost_recover_live);
        goto L25
    L13:
        if (r102.intValue() != 1) goto L15;
        r100 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_broadcast_permission_lost_pause_anchor_hint);
        r101 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_broadcast_permission_lost_recover_live);
    L25:
        ((TextView) this.containerView.findViewById(R.id.pause_title_view)).setText(r100);
        ((TextView) this.containerView.findViewById(R.id.recover_live_view)).setText(r101);
    }

    public final void zq() {
        ((HSImageView) this.contentView.findViewById(R.id.pause_bg_view)).setVisibility(0);
        float r100 = UIUtils.getScreenWidth(this.context) / UIUtils.getScreenHeight(this.context);
        SettingKey<com.bytedance.android.livesdk.config.w0> r101 = h21.f120335c;
        com.bytedance.android.livesdk.config.w0 r102 = r101.getValue();
        Integer r103 = (Integer) this.dataCenter.get("data_screen_orientation", 1);
        String r104 = "";
        if (r103 != null) goto L6;
    L10:
        String r105 = r102.c();
        if (r105 == null) goto L14;
    L13:
        r104 = r105;
    L14:
        LiveMode r106 = this.f118460b;
        if (r106 != LiveMode.AUDIO) goto L22;
        Room r107 = (Room) this.dataCenter.get("data_room");
        if (r107 == null) goto L19;
        String r108 = r107.getOwnerUserIdString();
    L20:
        com.bytedance.android.livesdk.chatroom.utils.a1.r((HSImageView) this.contentView.findViewById(R.id.pause_bg_view), com.bytedance.android.livesdk.model.k.b(jf.f120520a.getValue(), r108), R.drawable.ttlive_bg_audio_live_placeholder);
        return;
    L19:
        r108 = "0";
        goto L20
    L22:
        boolean r109 = this.f118459a;
        if (r109 == false) goto L25;
    L36:
        if (r109 == false) goto L51;
        if (r101.getValue().a() == false) goto L40;
        ImageLoader.bindImage((HSImageView) this.contentView.findViewById(R.id.pause_bg_view), r104);
        return;
    L40:
        IUserService r110 = (IUserService) jc1.k.n(IUserService.class);
        py.k r111 = r110.user().b().getAvatarMedium();
        if (r111 != null) goto L48;
        String r112 = r110.user().b().getAvatarUrl();
        if (TextUtils.isEmpty(r112) == true) goto L48;
        ArrayList r113 = new ArrayList();
        if (r112 == null) goto L47;
        r113.add(r112);
    L47:
        r111 = new ImageModel(null, r113);
    L48:
        ImageLoader.bindImage((HSImageView) this.contentView.findViewById(R.id.pause_bg_view), r111, new l3(5, r100, null));
        return;
    L51:
        if (r101.getValue().a() == false) goto L53;
        ImageLoader.bindImage((HSImageView) this.contentView.findViewById(R.id.pause_bg_view), r104);
        return;
    L53:
        Room r114 = (Room) this.dataCenter.get("data_room");
        if (r114 == null) goto L69;
        User r115 = r114.mo8271getOwner();
        if (r115 == null) goto L70;
        py.k r116 = r115._avatarMedium;
        if (r116 != null) goto L62;
        String r117 = r115.getAvatarUrl();
        if (TextUtils.isEmpty(r117) == true) goto L62;
        ArrayList r118 = new ArrayList();
        Intrinsics.checkNotNull(r117);
        r118.add(r117);
        r116 = new ImageModel(null, r118);
    L62:
        ImageLoader.bindImage((HSImageView) this.contentView.findViewById(R.id.pause_bg_view), r116, new l3(5, r100, null));
        return;
    L70:
        return;
    L69:
        return;
    L25:
        if (r106 != LiveMode.SCREEN_RECORD) goto L27;
    L28:
        Room r119 = (Room) this.dataCenter.get("data_room");
        if (r102.a() == false) goto L31;
        ImageLoader.bindImage((HSImageView) this.contentView.findViewById(R.id.pause_bg_view), r104);
        return;
    L31:
        if (r119 == null) goto L65;
        py.k r120 = r119.getBackground();
        if (r120 == null) goto L66;
        ImageLoader.bindImage((HSImageView) this.contentView.findViewById(R.id.pause_bg_view), r120, new l3(5, r100, null));
        return;
    L66:
        return;
    L65:
        return;
    L27:
        if (r106 != LiveMode.THIRD_PARTY) goto L36;
    L6:
        if (r103.intValue() != 0) goto L10;
        r105 = r102.b();
        if (r105 != null) goto L13;
        goto L13
    }

    public BroadcastPauseStateWidget() {
        this.f118460b = LiveMode.VIDEO;
        this.f118462d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.dataCenter.removeObserver(this);
        this.containerView.setVisibility(0);
        this.f118462d.clear();
    }

    public final void eR(LiveMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f118460b = r100;
        if (this.f118459a == true) goto L6;
        Aq();
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (this.context != null) goto L5;
        return;
    L5:
        if (this.isViewValid == false) goto L110;
        String r102 = null;
        if (r101 == null) goto L10;
        String r103 = r101.getKey();
    L12:
        if (Intrinsics.areEqual(r103, "data_broadcast_pause_state") == false) goto L72;
        zg1.m r104 = (zg1.m) r101.getData();
        if (r104 == null) goto L16;
        Integer r105 = Integer.valueOf(r104.f571877a);
    L18:
        if (r105 != null) goto L21;
    L45:
        if (r105 != null) goto L48;
    L60:
        if (r105 != null) goto L63;
    L65:
        if (r105 != null) goto L68;
        return;
    L68:
        if (r105.intValue() == 7) goto L70;
        return;
    L70:
        if (wq() == false) goto L100;
        this.dataCenter.put("cmd_broadcast_game_live_recover_error", Boolean.TRUE);
        return;
    L100:
        return;
    L63:
        if (r105.intValue() != 3) goto L65;
        this.containerView.setVisibility(8);
        xs2.b.a().post(new zg1.h1(31));
        return;
    L48:
        if (r105.intValue() != 2) goto L60;
        yq();
        if (this.containerView.getVisibility() == 0) goto L55;
        this.containerView.setVisibility(0);
        ((LinearLayout) this.contentView.findViewById(R.id.broadcast_pause_anchor_card)).setVisibility(0);
        AnchorPauseTipsView r106 = this.f118461c;
        if (r106 == null) goto L54;
        r106.setVisibility(8);
    L54:
        zq();
        xq();
    L55:
        r104.getClass();
        if (0 >= 60) goto L58;
        ((TextView) this.contentView.findViewById(R.id.pause_countdown_view)).setTextColor(this.context.getResources().getColor(R.color.ttlive_broadcast_pause_countdown_highlight_color));
    L59:
        ((TextView) this.contentView.findViewById(R.id.pause_countdown_view)).setText(null);
        return;
    L58:
        ((TextView) this.contentView.findViewById(R.id.pause_countdown_view)).setTextColor(this.context.getResources().getColor(R.color.white));
        goto L59
    L21:
        if (r105.intValue() != 1) goto L45;
        this.containerView.setVisibility(0);
        if (this.f118459a == false) goto L27;
        yq();
        ((LinearLayout) this.contentView.findViewById(R.id.broadcast_pause_anchor_card)).setVisibility(0);
        AnchorPauseTipsView r107 = this.f118461c;
        if (r107 == null) goto L30;
        r107.setVisibility(8);
    L30:
        xs2.b.a().post(new zg1.h1(30));
        zq();
        xq();
        HashMap r108 = new HashMap();
        int r109 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r109, 32) == false) goto L33;
    L43:
        r108.put("interact_function", "chat_room");
    L44:
        r108.put("anchor_status", "suspend");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_suspend_reminder_show", r108, new Object[]{am2.x.class, Room.class});
        return;
    L33:
        if (gd0.v.a(r109, 8) == true) goto L43;
        if (gd0.v.a(r109, 2) == false) goto L39;
        r108.put("interact_function", "audience_connect");
        goto L44
    L39:
        if (gd0.v.a(r109, 4) == false) goto L41;
    L42:
        r108.put("interact_function", "anchor_connect");
        goto L44
    L41:
        if (gd0.v.a(r109, 64) == false) goto L44;
    L27:
        Aq();
        ((LinearLayout) this.contentView.findViewById(R.id.broadcast_pause_anchor_card)).setVisibility(8);
        AnchorPauseTipsView r110 = this.f118461c;
        if (r110 == null) goto L30;
        r110.setVisibility(0);
        goto L30
    L16:
        r105 = null;
        goto L18
    L72:
        if (r101 == null) goto L75;
        r102 = r101.getKey();
    L75:
        if (Intrinsics.areEqual(r102, "data_keyboard_status") == false) goto L102;
        zg1.m r111 = (zg1.m) this.dataCenter.get("data_broadcast_pause_state");
        if (r111 != null) goto L79;
        return;
    L79:
        if (r111.f571877a == 1) goto L81;
        return;
    L81:
        if (this.containerView.getVisibility() == 0) goto L83;
        return;
    L83:
        if (this.f118459a == true) goto L106;
        Boolean r112 = (Boolean) r101.getData();
        if (r112 != null) goto L87;
    L91:
        Aq();
        AnchorPauseTipsView r113 = this.f118461c;
        if (r113 == null) goto L109;
        r113.setVisibility(0);
        return;
    L109:
        return;
    L87:
        if (r112.booleanValue() == false) goto L91;
        AnchorPauseTipsView r114 = this.f118461c;
        if (r114 == null) goto L107;
        r114.setVisibility(8);
        return;
    L107:
        return;
    L106:
        return;
    L102:
        return;
    L10:
        r103 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        Boolean r101 = (Boolean) this.dataCenter.get("data_is_anchor", Boolean.FALSE);
        if (r101 == null) goto L5;
        this.f118459a = r101.booleanValue();
    L5:
        this.containerView.setVisibility(8);
        this.f118461c = (AnchorPauseTipsView) findViewById(R.id.broadcast_pause_audience_card);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.dataCenter.observe("data_broadcast_pause_state", this).observe("data_keyboard_status", this);
        ((TextView) this.contentView.findViewById(R.id.recover_live_view)).setOnClickListener(new a(this));
        if (this.f118459a == true) goto L13;
        zg1.m r101 = (zg1.m) this.dataCenter.get("data_broadcast_pause_state");
        if (r101 != null) goto L7;
    L11:
        this.containerView.setVisibility(8);
        goto L13
    L7:
        if (r101.f571877a != 1) goto L11;
        this.containerView.setVisibility(0);
        ((LinearLayout) this.contentView.findViewById(R.id.broadcast_pause_anchor_card)).setVisibility(8);
        AnchorPauseTipsView r102 = this.f118461c;
        if (r102 == null) goto L13;
        r102.setVisibility(0);
    L13:
        if (ho1.a.o(getComponentContext()) == false) goto L24;
        h70.b r103 = getComponentContext();
        if (r103 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r104 = ho1.a.c(r103);
        if (r104 == null) goto L26;
        PropertyOwner r105 = r104.getLoadState();
        if (r105 == null) goto L27;
        Disposable r106 = com.bytedance.android.livesdk.chatroom.ui.framework.b.e(r105, new AnonymousClass2(this));
        if (r106 == null) goto L28;
        RxUtilKt.c(r106, this.f118462d);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }
}
