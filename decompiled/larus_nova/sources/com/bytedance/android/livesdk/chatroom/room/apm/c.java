package com.bytedance.android.livesdk.chatroom.room.apm;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.setting.y6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.status.api.IAggregateService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.player.State;
import com.bytedance.android.livesdk.utils.v6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.model.LiveStreamType;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSpmLogger;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.view.IRenderView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements q81.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f110689j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q81.a.C7298a f110690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f110691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f110692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f110693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ILivePlayerClient f110694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f110695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f110696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LifecycleOwner f110697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f110698i;

    public static final class a {
        public a() {
        }

        public static void a(String r110, c r111) {
            HashMap r100 = new HashMap();
            MiddlewareRoomContext r101 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
            if (r101 == null) goto L7;
            com.bytedance.live.datacontext.m<Room> r102 = r101.getRoom();
            if (r102 == null) goto L7;
            Room r103 = r102.getValue();
        L8:
            r100.put("type", "0");
            String r104 = "";
            switch(r110.hashCode()) {
                case 49: goto L27;
                case 50: goto L24;
                case 51: goto L21;
                case 52: goto L18;
                case 53: goto L15;
                case 54: goto L12;
                default: goto L95;
            };
        L95:
            String r105 = "";
        L30:
            r100.put("feature_desc", r105);
            r100.put("feature", r110);
            r100.put("user_id", v6.b().n());
            if (r111 == null) goto L33;
            Long r106 = Long.valueOf(r111.f110698i);
        L34:
            r100.put("room_id", String.valueOf(r106));
            if (r103 == null) goto L38;
            String r107 = r103.getOwnerUserIdString();
            if (r107 == null) goto L38;
        L39:
            r100.put("anchor_id", r107);
            com.bytedance.android.livesdk.log.filter.o r108 = j0.l().c(am2.x.class);
            if (r108 == null) goto L49;
            String r109 = r108.getMap().get("enter_from_merge");
            if (r109 != null) goto L44;
            r109 = "";
        L44:
            r100.put("enter_from_merge", r109);
            String r112 = r108.getMap().get("enter_method");
            if (r112 == null) goto L48;
            r104 = r112;
        L48:
            r100.put("enter_method", r104);
        L49:
            IAggregateService r113 = (IAggregateService) jc1.k.f(IAggregateService.class);
            if (r113 == null) goto L54;
            JSONObject r114 = r113.getPlayerStatsLog();
            if (r114 == null) goto L54;
            r100.put(IPerformanceManager.Stream.stream_cdn_ip, r114.optString("cdn_ip:"));
            r100.put(IPerformanceManager.Stream.stream_cdn_play_url, r114.optString("url:"));
        L54:
            j0.l().sendLog("livesdk_room_not_render_monitor", r100, new Object[0]);
            if (r103 == null) goto L64;
            if (r103.isPaidRoom() != true) goto L64;
            LinkedHashMap r115 = new LinkedHashMap();
            r115.putAll(r100);
            r115.put(VrBgLogData.KEY_IS_PREVIEW, "0");
            PaidLiveData r116 = r103.getPaidLiveData();
            if (r116 == null) goto L61;
            Long r117 = r116.getKeepAliveTime();
        L62:
            r115.put("keep_alive_time", String.valueOf(r117));
            j0.l().sendLog("livesdk_paidlive_not_render_monitor", r115, new Object[0]);
            goto L64
        L61:
            r117 = null;
        L64:
            if (CollectionsKt.listOf(new String[]{"3", "4"}).contains(r110) == false) goto L83;
            if (r111 == null) goto L83;
            ILivePlayerClient r118 = r111.f110694e;
            if (r118 == null) goto L83;
            IPlayerLogger r119 = r118.logger();
            if (r119 == null) goto L83;
            int r120 = r110.hashCode();
            if (r120 == 51) goto L79;
            if (r120 == 52) goto L76;
        L81:
            String r121 = "error";
        L82:
            r119.feedbackException("black_screen", r121, null);
            goto L83
        L76:
            if (r110.equals("4") == false) goto L81;
            r121 = "abnormal_stop";
            goto L82
        L79:
            if (r110.equals("3") == false) goto L81;
            r121 = "abnormal_cover";
        L83:
            if (r111 == null) goto L96;
            q81.a.C7298a r122 = r111.f110690a;
            if (r122 == null) goto L97;
            MutableLiveData<String> r123 = r122.f532020b;
            if (r123 == null) goto L98;
            r123.setValue(r110);
            return;
        L98:
            return;
        L97:
            return;
        L96:
            return;
        L38:
            r107 = "0";
            goto L39
        L33:
            r106 = null;
            goto L34
        L12:
            if (r110.equals("6") == false) goto L29;
            r105 = "surface没有ready";
            goto L30
        L29:
            r105 = "";
            goto L30
        L15:
            if (r110.equals("5") == false) goto L90;
            r105 = "拉流失败(not prepared)";
            goto L30
        L90:
            r105 = "";
            goto L30
        L18:
            if (r110.equals("4") == false) goto L91;
            r105 = "当前直播间对应的播放器被异常关闭/释放";
            goto L30
        L91:
            r105 = "";
            goto L30
        L21:
            if (r110.equals("3") == false) goto L92;
            r105 = "播放器被遮挡";
            goto L30
        L92:
            r105 = "";
            goto L30
        L24:
            if (r110.equals("2") == false) goto L93;
            r105 = "实际播放器与业务维护当前播放器不一致";
            goto L30
        L93:
            r105 = "";
            goto L30
        L27:
            if (r110.equals("1") == false) goto L94;
            r105 = "播放器没有被添加到根布局中";
            goto L30
        L94:
            r105 = "";
        L7:
            r103 = null;
            goto L8
        }
    }

    @Override // q81.a
    public final void reset() {
        this.f110693d = true;
    }

    static {
        f110689j = new a();
    }

    @Override // q81.a
    public final void a() {
        LifecycleOwner r100 = this.f110697h;
        if (r100 == null) goto L7;
        this.f110690a.f532019a.observe(r100, new g(this));
        return;
    }

    @Override // q81.a
    public final void e() {
        if (this.f110691b == true) goto L6;
        f110689j.getClass();
        a.a("1", this);
        return;
    }

    @Override // q81.a
    public final void f() {
        q81.a.C7298a r100 = this.f110690a;
        if (r100 == null) goto L8;
        MutableLiveData<Boolean> r101 = r100.f532019a;
        if (r101 == null) goto L9;
        r101.setValue(Boolean.TRUE);
        return;
    L9:
        return;
    }

    @Override // q81.a
    public final q81.a.C7298a getEventHub() {
        return this.f110690a;
    }

    @Override // q81.a
    public final void b(ILivePlayerClient r100) {
        if ((r100 instanceof ILivePlayerClient) == true) goto L5;
        r100 = null;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        this.f110694e = r100;
        LifecycleOwner r101 = this.f110697h;
        if (r101 != null) goto L10;
        return;
    L10:
        IRoomEventHub r102 = r100.getEventHub();
        if (r102 == null) goto L15;
        MutableLiveData<Boolean> r103 = r102.getStartPullStream();
        if (r103 == null) goto L15;
        r103.observe(r101, new d(this));
    L15:
        ILivePlayerClient r104 = this.f110694e;
        if (r104 == null) goto L22;
        IRoomEventHub r105 = r104.getEventHub();
        if (r105 == null) goto L22;
        MutableLiveData<Boolean> r106 = r105.getStopped();
        if (r106 == null) goto L22;
        r106.observe(r101, new e(this));
    L22:
        ILivePlayerClient r107 = this.f110694e;
        if (r107 == null) goto L30;
        IRoomEventHub r108 = r107.getEventHub();
        if (r108 == null) goto L31;
        MutableLiveData<Boolean> r109 = r108.getReleased();
        if (r109 == null) goto L32;
        r109.observe(r101, new f(this));
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // q81.a
    public final void g(boolean r100) {
        this.f110695f = r100;
        if (r100 == false) goto L6;
        this.f110696g = System.currentTimeMillis();
        return;
    }

    public c(LifecycleOwner r100, long r101) {
        this.f110697h = r100;
        this.f110698i = r101;
        this.f110690a = new q81.a.C7298a();
        this.f110693d = true;
    }

    @Override // q81.a
    public final void d(RoomSession r110, AbsLivePlayerView r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        ViewParent r100 = null;
        if ((r111 instanceof AbsLivePlayerView) == true) goto L7;
        r111 = null;
    L7:
        if (r111 != null) goto L10;
        return;
    L10:
        if (((PlayerConfig) LivePlatformPlayerManager.f85447f.getValue()).getFixExBlackScreen() == true) goto L12;
        return;
    L12:
        as0.a r101 = LivePlatformPlayerManager.c(r110.getRoomId(), r110.isPseudo());
        if (r101.player() != null) goto L35;
        r101.g(r110.getFirstShow());
        ILivePlayerClient r102 = r101.player();
        if (r102 == null) goto L19;
        IPlayerLogger r103 = r102.logger();
        if (r103 == null) goto L19;
        ILivePlayerSpmLogger.DefaultImpls.logLifeCycle$default(r103, "try to fix black screen!", null, false, 6, null);
    L19:
        r110.getEventHub().getStartPull().setValue(Boolean.FALSE);
        View r112 = r111.getRenderView().getSelfView();
        if ((!Intrinsics.areEqual(r112.getParent(), r111)) == true) goto L23;
        r112 = null;
    L23:
        if (r112 == null) goto L33;
        ViewParent r104 = r112.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L28;
        r100 = r104;
    L28:
        ViewGroup r105 = (ViewGroup) r100;
        if (r105 == null) goto L31;
        r105.removeView(r112);
    L31:
        r111.addView(r112);
    L33:
        if (r111.getRenderView().getVisibility() != 8) goto L35;
        r111.getRenderView().setVisibility(0);
    L35:
        PlayerInnerDrawerConfig r113 = y6.f65465a.getValue();
        if (r101.k() == false) goto L38;
        return;
    L38:
        if (r111.getRenderView().getVisibility() == 8) goto L40;
        return;
    L40:
        if (r113.getLivePlayerSearchResumeBlackScreenFix() == false) goto L45;
        r111.getRenderView().setVisibility(0);
        return;
    }

    @Override // q81.a
    public final void c(final ILivePlayerClient r100, gs0.c r101, View r110, View r111) {
        Boolean r102 = null;
        if ((r100 instanceof ILivePlayerClient) == true) goto L5;
        r100 = null;
    L5:
        if (r100 != null) goto L8;
        return;
    L8:
        if ((r101 instanceof gs0.c) == true) goto L10;
        r101 = null;
    L10:
        if (r101 != null) goto L13;
        return;
    L13:
        if (this.f110693d == true) goto L15;
        return;
    L15:
        if ((!Intrinsics.areEqual(r100, r100)) == false) goto L17;
        return;
    L17:
        if (this.f110695f == true) goto L19;
        return;
    L19:
        if ((System.currentTimeMillis() - this.f110696g) >= 1500) goto L22;
        return;
    L22:
        if ((!Intrinsics.areEqual(r100.context().getUseScene().toString(), "inner_draw")) == false) goto L24;
        return;
    L24:
        this.f110693d = false;
        f110689j.getClass();
        if (this.f110692c == true) goto L35;
        ILivePlayerClient r103 = this.f110694e;
        if (r103 == null) goto L29;
        State r104 = r103.getCurrentState();
    L31:
        if ((r104 instanceof State.Stopped) == false) goto L33;
    L34:
        a.a("4", this);
    L51:
        if (r101.R8() == null) goto L66;
        IRenderView r105 = r100.getRenderView();
        if (r105 == null) goto L55;
        ViewParent r106 = r105.getParent();
    L56:
        if (r106 == null) goto L66;
        IRenderView r107 = r100.getRenderView();
        if (r107 == null) goto L61;
        ViewParent r108 = r107.getParent();
    L63:
        if ((!Intrinsics.areEqual(r108, r101.R8())) == false) goto L66;
        a.a("2", this);
        goto L66
    L61:
        r108 = null;
        goto L63
    L55:
        r106 = null;
    L66:
        if (r100.getLifecycleOwner() == null) goto L113;
        IRoomEventHub r109 = r100.getEventHub();
        if ((r109 instanceof IRoomEventHub) == true) goto L71;
        r109 = null;
    L71:
        if (r109 == null) goto L75;
        MutableLiveData<Boolean> r112 = r109.getPlaying();
        if (r112 == null) goto L75;
        Boolean r113 = r112.getValue();
    L76:
        Boolean r114 = Boolean.TRUE;
        if (Intrinsics.areEqual(r113, r114) == false) goto L97;
        if (r111 != null) goto L80;
    L81:
        if (r110 == null) goto L97;
        if (r110.getVisibility() != 0) goto L97;
    L84:
        ILivePlayerClient r115 = this.f110694e;
        if (r115 == null) goto L87;
        Object r116 = r115.getLiveMode();
    L89:
        if (r116 == LiveStreamType.AUDIO) goto L97;
        ILivePlayerClient r117 = this.f110694e;
        if (r117 == null) goto L93;
        Object r118 = r117.getLiveMode();
    L95:
        if (r118 == LiveStreamType.UNDEFINED) goto L97;
        a.a("3", this);
        goto L97
    L93:
        r118 = null;
        goto L95
    L87:
        r116 = null;
        goto L89
    L80:
        if (r111.getVisibility() == 0) goto L84;
    L97:
        IRoomEventHub r119 = r100.getEventHub();
        if ((r119 instanceof IRoomEventHub) == true) goto L100;
        r119 = null;
    L100:
        if (r119 == null) goto L105;
        MutableLiveData<Boolean> r120 = r119.getPlayPrepared();
        if (r120 == null) goto L105;
        r102 = r120.getValue();
    L105:
        if (Intrinsics.areEqual(r102, r114) == false) goto L111;
        UtilityKotlinExtentionsKt.s(0, false, false, new BlackScreenMonitor$tryCheckPlayerSurface$1(this, r100), 7);
        return;
    L111:
        return;
    L75:
        r113 = null;
        goto L76
    L113:
        return;
    L33:
        if ((r104 instanceof State.Released) == false) goto L51;
    L29:
        r104 = null;
        goto L31
    L35:
        ILivePlayerClient r121 = this.f110694e;
        if (r121 == null) goto L38;
        IRoomEventHub r122 = r121.getEventHub();
    L40:
        if ((r122 instanceof IRoomEventHub) == true) goto L42;
        r122 = null;
    L42:
        if (r122 == null) goto L46;
        MutableLiveData<Boolean> r123 = r122.getPlayPrepared();
        if (r123 == null) goto L46;
        Boolean r124 = r123.getValue();
    L48:
        if (Intrinsics.areEqual(r124, Boolean.FALSE) == false) goto L51;
        a.a("5", this);
    L46:
        r124 = null;
        goto L48
    L38:
        r122 = null;
        goto L40
    }
}
