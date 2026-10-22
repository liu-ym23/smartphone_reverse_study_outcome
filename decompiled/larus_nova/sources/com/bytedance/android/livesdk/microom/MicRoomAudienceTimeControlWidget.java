package com.bytedance.android.livesdk.microom;

import am2.x;
import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.room.LiveRoomCacheManager;
import com.bytedance.android.livesdk.config.fc1;
import com.bytedance.android.livesdk.config.q;
import com.bytedance.android.livesdk.config.setting.r;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.tg;
import com.bytedance.android.livesdk.microom.api.MicRoomApi;
import com.bytedance.android.livesdk.microom.enhance.MicRoomStatusViewModel;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import qm2.s;
import qm2.t;
import rj0.m;
import vlc.l;
import zg1.h1;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/microom/MicRoomAudienceTimeControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MicRoomAudienceTimeControlWidget extends LiveRecyclableWidget implements l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f153745f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f153746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f153747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Room f153748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f153749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f153750e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MicRoomAudienceTimeControlWidget f153751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficialChannelInfo f153752b;

        public b(MicRoomAudienceTimeControlWidget r100, OfficialChannelInfo r101) {
            this.f153751a = r100;
            this.f153752b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            MicRoomAudienceTimeControlWidget r102 = this.f153751a;
            OfficialChannelInfo r103 = this.f153752b;
            int r104 = MicRoomAudienceTimeControlWidget.f153745f;
            r102.Aq(r103, false);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f153753a = null;

        static {
            f153753a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = MicRoomAudienceTimeControlWidget.f153745f;
            ALogger.e("MicRoomAudienceTimeControlWidget", ((Throwable) r100).getMessage());
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MicRoomAudienceTimeControlWidget f153754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f153755b;

        public d(MicRoomAudienceTimeControlWidget r100, Room r101) {
            this.f153754a = r100;
            this.f153755b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            int r102 = MicRoomAudienceTimeControlWidget.f153745f;
            ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: trick count down.");
            MicRoomStatusViewModel.a r103 = MicRoomStatusViewModel.Companion;
            DataCenter r104 = this.f153754a.dataCenter;
            r103.getClass();
            MicRoomStatusViewModel.a.a(r104).setNextRoomInfo(this.f153755b);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f153756a = null;

        static {
            f153756a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = MicRoomAudienceTimeControlWidget.f153745f;
            ALogger.e("MicRoomAudienceTimeControlWidget", ((Throwable) r100).getMessage());
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MicRoomAudienceTimeControlWidget f153757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f153758b;

        public f(MicRoomAudienceTimeControlWidget r100, boolean r101) {
            this.f153757a = r100;
            this.f153758b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            Long r100 = (Long) r210;
            MicRoomAudienceTimeControlWidget r101 = this.f153757a;
            boolean r102 = this.f153758b;
            int r103 = MicRoomAudienceTimeControlWidget.f153745f;
            r101.getClass();
            ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: realJumpToNextRoom nextRoomId = " + r101.f153747b);
            IInteractService r104 = (IInteractService) jc1.k.f(IInteractService.class);
            IUserService r105 = (IUserService) jc1.k.f(IUserService.class);
            if (r105 == null) goto L7;
            com.bytedance.android.livesdk.user.f r106 = r105.user();
            if (r106 == null) goto L7;
            IUser r107 = r106.b();
        L9:
            if ((r107 instanceof User) == true) goto L11;
            r107 = null;
        L11:
            User r108 = (User) r107;
            if (r101.f153747b != 0) goto L23;
            Intrinsics.checkNotNull(r104);
            if (r108 == null) goto L17;
            String r109 = r108.getIdString();
            if (r109 == null) goto L17;
        L19:
            if (r104.isMicRoomHost(r109) == false) goto L21;
        L22:
            xs2.b.a().post(new h1(51));
            return;
        L21:
            if (q.f121019a.getValue().booleanValue() == true) goto L23;
        L17:
            r109 = "";
        L23:
            Bundle r110 = new Bundle();
            boolean r111 = true;
            if (r102 == false) goto L36;
            o r112 = u.l().c(x.class);
            if (r112.getMap().containsKey("enter_from_merge") == false) goto L28;
            String r113 = r112.getMap().get("enter_from_merge");
        L30:
            if (r112.getMap().containsKey("enter_method") == false) goto L32;
            String r114 = r112.getMap().get("enter_method");
        L33:
            r110.putString("enter_from_merge", r113);
            r110.putString("enter_method", r114);
            r110.putBoolean(ILiveRoomPlayFragmentConstant.MIC_ROOM_BLOCK, true);
            IMicRoomService r115 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
            if (r115 == null) goto L48;
            r115.setMicRoomJumpType(IMicRoomService.CAROUSEL_TO_NON_CAROUSEL_AUTO);
        L48:
            IMicRoomService r116 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
            if (r116 == null) goto L51;
            String r117 = r116.getMicRoomJumpType();
        L52:
            r110.putString(ILiveRoomPlayFragmentConstant.EXTRA_MIC_ROOM_JUMP_TYPE, r117);
            r110.putString("action_type", "draw");
            r110.putBoolean(ILiveRoomPlayFragmentConstant.IS_MIC_ROOM_REFRESH, true);
            ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: realJumpToNextRoom post event, next room = " + r101.f153747b);
            long r118 = r101.f153747b;
            if (r118 != 0) goto L57;
            Room r119 = r101.f153746a;
            if (r119 == null) goto L57;
            r118 = r119.getRoomId();
        L57:
            JumpToOtherRoomEvent r120 = new JumpToOtherRoomEvent(r118, r110);
            r120.sameRoomRefresh = true;
            r120.jumpSource = "jump_source_mic_room";
            r120.isMicRoomJump = true;
            r120.source = "sourceJumpToOtherMicRoomAudienceTimeControllerW";
            Lazy r121 = LiveRoomCacheManager.f110559d;
            LiveRoomCacheManager.a.a().d(r101.f153747b);
            if (r102 == true) goto L112;
            LinkedHashMap r122 = new LinkedHashMap();
            r122.put("room_id", String.valueOf(r101.f153747b));
            r122.put("enter_from_merge", "live_detail");
            r122.put("enter_method", "carousel");
            r122.put("action_type", "draw");
            r122.put(IPerformanceManager.Params.room_type, "carousel");
            r122.put("user_type", "carousel_audience");
            Room r123 = r101.f153746a;
            if (r123 == null) goto L64;
            OfficialChannelInfo r124 = r123.officialChannelInfo;
            if (r124 == null) goto L64;
            Long r125 = Long.valueOf(r124.getBackupRoomId());
        L65:
            r122.put("carousel_room_id", String.valueOf(r125));
            Room r126 = r101.f153746a;
            if (r126 == null) goto L68;
            r122.put("visibility_range", String.valueOf(r126.getVisibilityRange()));
        L68:
            Room r127 = r101.f153746a;
            if (r127 == null) goto L76;
            OfficialChannelInfo r128 = r127.officialChannelInfo;
            if (r128 == null) goto L76;
            IBaseUser r129 = r128.getChannelUser();
            if (r129 == null) goto L76;
            String r130 = r129.getUserId();
            if (r130 == null) goto L76;
        L77:
            r122.put("channel_uid", r130);
            Room r131 = r101.f153748c;
            if (r131 == null) goto L83;
            String r132 = r131.getOwnerUserIdString();
            if (r132 == null) goto L83;
            String r133 = r132;
        L84:
            r122.put("anchor_id", r133);
            Room r134 = r101.f153746a;
            if (r134 == null) goto L87;
            RoomExtra r135 = r134.getExtra();
        L88:
            if (r135 == null) goto L102;
            Room r136 = r101.f153746a;
            if (r136 == null) goto L95;
            RoomExtra r137 = r136.getExtra();
            if (r137 == null) goto L95;
            if (r137.getXiguaUid() == 0) goto L102;
        L95:
            Room r138 = r101.f153746a;
            if (r138 == null) goto L100;
            RoomExtra r139 = r138.getExtra();
            if (r139 == null) goto L100;
            Long r140 = Long.valueOf(r139.getXiguaUid());
        L101:
            r122.put(ILiveRoomPlayFragmentConstant.EXTRA_XIGUA_UID, String.valueOf(r140));
        L100:
            r140 = null;
        L102:
            Room r141 = r101.f153746a;
            if (r141 != null) goto L105;
        L106:
            if (r141 == null) goto L108;
            Long r142 = Long.valueOf(r141.appId);
        L109:
            r122.put(ILiveRoomPlayFragmentConstant.EXTRA_APP_ID, String.valueOf(r142));
        L110:
            u.l().sendLog("livesdk_live_show", r122, new Object[]{PadLoggerData.class});
            goto L112
        L108:
            r142 = null;
            goto L109
        L105:
            if (r141.appId == 0) goto L110;
        L87:
            r135 = null;
        L83:
            r133 = "";
        L76:
            r130 = "";
        L64:
            r125 = null;
        L112:
            if (fc1.f120191a.getValue().booleanValue() == false) goto L142;
            Room r143 = r101.f153748c;
            if (r143 == null) goto L127;
            long r144 = r143.f162599id;
            if (r144 != 0) goto L118;
        L120:
            boolean r145 = false;
        L121:
            if (r145 == true) goto L124;
            r143 = null;
        L124:
            if (r143 == null) goto L127;
            ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: start pre pull stream player");
            ILivePlayerClient r146 = LivePlatformPlayerManager.a(r143.f162599id, false);
            if (r146 == null) goto L127;
            Room r147 = null;
            r146.stream(new LiveRequest.Builder().streamData(r143.getMultiStreamData()).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r143.getStreamType())).resolution(ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r143, false, true, 2, null)).build(), null);
            r146.mute("MicRoomAudienceTimeControlWidget.prePullStream");
        L130:
            Room r148 = r101.f153748c;
            if (r148 == null) goto L142;
            if (r148.f162599id != 0) goto L136;
            r111 = false;
        L136:
            if (r111 == false) goto L138;
            r147 = r148;
        L138:
            if (r147 == null) goto L142;
            ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: put pre pull stream data");
            r110.putLong(ILiveRoomPlayFragmentConstant.MIC_ROOM_PRE_PULL_ROOM_ID, r147.f162599id);
            if (r147.getMultiStreamData() == null) goto L142;
            yt2.a.g(r110, ILiveRoomPlayFragmentConstant.EXTRA_PULL_STREAM_DATA, r147.getMultiStreamData());
            goto L142
        L118:
            if (r144 == r143.officialChannelUid) goto L120;
            r145 = true;
        L127:
            r147 = null;
        L142:
            r101.dataCenter.put("cmd_mic_room_jump", Boolean.TRUE);
            xs2.b.a().post(r120);
            return;
        L51:
            r117 = null;
            goto L52
        L32:
            r114 = "";
            goto L33
        L28:
            r113 = "";
            goto L30
        L36:
            r110.putString("enter_from_merge", "live_detail");
            r110.putString("enter_method", "carousel");
            r110.putString("enter_from", "carousel");
            r110.putString("source", "carousel");
            IMicRoomService r149 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
            if (r149 == null) goto L39;
            r149.setMicRoomJumpType(IMicRoomService.CAROUSEL_ANCHOR_CHANGE_AUTO);
        L39:
            if (r104 == null) goto L48;
            m r150 = r104.getVideoTalkService();
            if (r150 == null) goto L48;
            if (r108 == null) goto L48;
            if (r104.isMicRoomHost(r108.getIdString()) == false) goto L48;
            if (r150.C(false, r108.getIdString()) == false) goto L48;
            IInteractService.micRoomHostStateMap.put(ILiveRoomPlayFragmentConstant.IS_HOST_AUTO_APPLY, Integer.valueOf(hd0.c.f().f484576g));
        L7:
            r107 = null;
            goto L9
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f153759a = null;

        static {
            f153759a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = MicRoomAudienceTimeControlWidget.f153745f;
            ALogger.e("MicRoomAudienceTimeControlWidget", ((Throwable) r100).getMessage());
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MicRoomAudienceTimeControlWidget f153760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficialChannelInfo f153761b;

        public h(MicRoomAudienceTimeControlWidget r100, OfficialChannelInfo r101) {
            this.f153760a = r100;
            this.f153761b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Response r100 = (Response) r110;
            MicRoomAudienceTimeControlWidget r101 = this.f153760a;
            if (r100 == null) goto L7;
            com.bytedance.android.livesdk.microom.api.model.b r102 = (com.bytedance.android.livesdk.microom.api.model.b) r100.data;
            if (r102 == null) goto L7;
            long r103 = r102.roomId;
        L13:
            r101.f153747b = r103;
            MicRoomAudienceTimeControlWidget r104 = this.f153760a;
            com.bytedance.android.livesdk.microom.api.model.b r105 = (com.bytedance.android.livesdk.microom.api.model.b) r100.data;
            r104.f153748c = r105.nextRoom;
            if (Long.valueOf(r105.startTimeStamp) == null) goto L20;
            com.bytedance.android.livesdk.microom.api.model.b r106 = (com.bytedance.android.livesdk.microom.api.model.b) r100.data;
            if (r106 != null) goto L18;
        L19:
            long r107 = r106.startTimeStamp;
        L21:
            int r108 = MicRoomAudienceTimeControlWidget.f153745f;
            ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: requestNextRoom: data start: " + ((com.bytedance.android.livesdk.microom.api.model.b) r100.data).startTimeStamp + ", info end: " + this.f153761b.getEndTimeStamp());
            StringBuilder r109 = new StringBuilder("mic room: requestNextRoom: next room: ");
            r109.append(((com.bytedance.android.livesdk.microom.api.model.b) r100.data).roomId);
            r109.append(", current room: ");
            Room r111 = this.f153760a.f153746a;
            if (r111 == null) goto L24;
            Long r112 = Long.valueOf(r111.f162599id);
        L25:
            r109.append(r112);
            r109.append('}');
            ALogger.d("MicRoomAudienceTimeControlWidget", r109.toString());
            StringBuilder r113 = new StringBuilder("mic room: requestNextRoom: pull stream optimize: ");
            r113.append(fc1.f120191a.getValue());
            r113.append(", real room id: ");
            Room r114 = ((com.bytedance.android.livesdk.microom.api.model.b) r100.data).nextRoom;
            if (r114 == null) goto L28;
            String r115 = r114.getIdStr();
        L29:
            r113.append(r115);
            ALogger.d("MicRoomAudienceTimeControlWidget", r113.toString());
            StringBuilder r116 = new StringBuilder("mic room: requestNextRoom: real room stream url id: ");
            Room r117 = ((com.bytedance.android.livesdk.microom.api.model.b) r100.data).nextRoom;
            if (r117 == null) goto L34;
            StreamUrl r118 = r117.getStreamUrl();
            if (r118 == null) goto L34;
            Long r119 = Long.valueOf(r118.getId());
        L35:
            r116.append(r119);
            ALogger.d("MicRoomAudienceTimeControlWidget", r116.toString());
            long r120 = r107 - (com.bytedance.android.livesdk.utils.ntp.e.a() / ((long) 1000));
            this.f153760a.getClass();
            if (r.a().booleanValue() == false) goto L61;
            com.bytedance.android.livesdk.user.f r121 = ((IUserService) jc1.k.n(IUserService.class)).user();
            if (r121 == null) goto L40;
            IUser r122 = r121.b();
        L41:
            IInteractService r123 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r123 == null) goto L47;
            if (r122 == null) goto L45;
            String r124 = r122.getIdString();
        L46:
            Boolean r125 = Boolean.valueOf(r123.isMicRoomHost(r124));
        L48:
            long r126 = 1;
            if (Intrinsics.areEqual(r125, Boolean.TRUE) == true) goto L52;
            r126 = Random.Default.nextLong(1, Math.max(2, this.f153760a.wq(this.f153761b)));
        L52:
            long r127 = Math.max(r120, 0) + r126;
            MicRoomAudienceTimeControlWidget r128 = this.f153760a;
            r128.yq(r127, r128.f153748c);
            Room r129 = this.f153760a.f153748c;
            if (r129 == null) goto L55;
            User r130 = r129.mo8271getOwner();
        L56:
            if (r130 == null) goto L60;
            MicRoomAudienceTimeControlWidget r131 = this.f153760a;
            long r132 = r131.f153750e;
            if (r127 <= r132) goto L60;
            long r133 = r127 - r132;
            ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: center count down after " + r133);
            r131.f153749d.add(Observable.timer(r133, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new qm2.r(r131), s.f533863a));
        L60:
            long r134 = r126;
        L62:
            this.f153760a.Bq(r120, this.f153761b, false, r134);
            return;
        L55:
            r130 = null;
            goto L56
        L45:
            r124 = null;
            goto L46
        L47:
            r125 = null;
            goto L48
        L40:
            r122 = null;
            goto L41
        L61:
            r134 = 0;
        L34:
            r119 = null;
            goto L35
        L28:
            r115 = null;
            goto L29
        L24:
            r112 = null;
            goto L25
        L18:
            if (r106.startTimeStamp != 0) goto L19;
        L20:
            r107 = this.f153761b.getEndTimeStamp();
        L7:
            Room r135 = r101.f153746a;
            if (r135 == null) goto L12;
            OfficialChannelInfo r136 = r135.officialChannelInfo;
            if (r136 == null) goto L12;
            r103 = r136.getBackupRoomId();
        L12:
            r103 = 0;
            goto L13
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MicRoomAudienceTimeControlWidget f153762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficialChannelInfo f153763b;

        public i(MicRoomAudienceTimeControlWidget r100, OfficialChannelInfo r101) {
            this.f153762a = r100;
            this.f153763b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            int r100 = MicRoomAudienceTimeControlWidget.f153745f;
            ALogger.e("MicRoomAudienceTimeControlWidget", "mic room: request next room failed. use backup id. msg = " + ((Throwable) r110).getMessage());
            MicRoomAudienceTimeControlWidget r111 = this.f153762a;
            Room r101 = r111.f153746a;
            if (r101 == null) goto L7;
            OfficialChannelInfo r102 = r101.officialChannelInfo;
            if (r102 == null) goto L7;
            long r103 = r102.getBackupRoomId();
        L8:
            r111.f153747b = r103;
            long r104 = this.f153763b.getEndTimeStamp();
            StringBuilder r112 = new StringBuilder("mic room: requestNextRoom: next room: ");
            r112.append(this.f153762a.f153747b);
            r112.append(", current room: ");
            Room r105 = this.f153762a.f153746a;
            if (r105 == null) goto L11;
            Long r106 = Long.valueOf(r105.f162599id);
        L12:
            r112.append(r106);
            r112.append('}');
            ALogger.d("MicRoomAudienceTimeControlWidget", r112.toString());
            this.f153762a.Bq(r104 - (com.bytedance.android.livesdk.utils.ntp.e.a() / ((long) 1000)), this.f153763b, false, 0);
            return;
        L11:
            r106 = null;
        L7:
            r103 = 0;
            goto L8
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MicRoomAudienceTimeControlWidget f153764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficialChannelInfo f153765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f153766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f153767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Boolean f153768e;

        public j(MicRoomAudienceTimeControlWidget r100, OfficialChannelInfo r101, boolean r102, long r103, Boolean r104) {
            this.f153764a = r100;
            this.f153765b = r101;
            this.f153766c = r102;
            this.f153767d = r103;
            this.f153768e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            MicRoomAudienceTimeControlWidget r102 = this.f153764a;
            OfficialChannelInfo r103 = this.f153765b;
            boolean r104 = this.f153766c;
            long r105 = this.f153767d;
            int r106 = MicRoomAudienceTimeControlWidget.f153745f;
            r102.zq(r103, r104, r105);
            if (this.f153768e.booleanValue() == true) goto L6;
            f2.b(R.string.ttlive_mic_room_official_jump, 0);
            return;
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f153769a = null;

        static {
            f153769a = new k();
        }

        public k() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = MicRoomAudienceTimeControlWidget.f153745f;
            ALogger.e("MicRoomAudienceTimeControlWidget", ((Throwable) r100).getMessage());
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    static {
    }

    public MicRoomAudienceTimeControlWidget() {
        this.f153749d = new CompositeDisposable();
        this.f153750e = 5;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.f153749d.clear();
        this.f153747b = 0;
        this.f153748c = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        Room r111 = (Room) this.dataCenter.get("data_room", null);
        this.f153746a = r111;
        if (r111 == null) goto L5;
        OfficialChannelInfo r112 = r111.officialChannelInfo;
    L6:
        this.f153747b = 0;
        this.f153748c = null;
        vlc.d r100 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        if (r100 == null) goto L9;
        r100.addMessageListener(MessageType.OFFICIAL_CHANNEL_MODIFY_MESSAGE.getIntType(), this);
    L9:
        IMicRoomService r101 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        StringBuilder r102 = new StringBuilder("mic room: load audience widget. isLoyalAudience = ");
        if (r101 == null) goto L12;
        Boolean r103 = Boolean.valueOf(r101.isLoyalAudience());
    L13:
        r102.append(r103);
        ALogger.d("MicRoomAudienceTimeControlWidget", r102.toString());
        StringBuilder r104 = new StringBuilder("mic room: currentRoomId = ");
        Room r105 = this.f153746a;
        if (r105 == null) goto L16;
        Long r106 = Long.valueOf(r105.f162599id);
    L17:
        r104.append(r106);
        r104.append(", anchorid: ");
        Room r107 = this.f153746a;
        if (r107 == null) goto L20;
        String r108 = r107.getOwnerUserIdString();
    L21:
        r104.append(r108);
        r104.append(", officialUid:");
        Room r109 = this.f153746a;
        if (r109 == null) goto L28;
        OfficialChannelInfo r113 = r109.officialChannelInfo;
        if (r113 == null) goto L28;
        IBaseUser r114 = r113.getChannelUser();
        if (r114 == null) goto L28;
        String r115 = r114.getIdString();
    L29:
        r104.append(r115);
        r104.append(", backupRoomId: ");
        Room r116 = this.f153746a;
        if (r116 == null) goto L34;
        OfficialChannelInfo r117 = r116.officialChannelInfo;
        if (r117 == null) goto L34;
        Long r118 = Long.valueOf(r117.getBackupRoomId());
    L35:
        r104.append(r118);
        ALogger.d("MicRoomAudienceTimeControlWidget", r104.toString());
        xq(r112);
        if (r112 == null) goto L43;
        vlc.d r119 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        long r120 = (r112.getEndTimeStamp() - (com.bytedance.android.livesdk.utils.ntp.e.a() / ((long) 1000))) - ((long) 60);
        ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: send message duration = " + r120);
        if (r120 <= 0) goto L44;
        this.f153749d.add(Observable.timer(r120, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(r119), qm2.u.f533865a));
        return;
    L44:
        return;
    L43:
        return;
    L34:
        r118 = null;
    L28:
        r115 = null;
        goto L29
    L20:
        r108 = null;
        goto L21
    L16:
        r106 = null;
        goto L17
    L12:
        r103 = null;
        goto L13
    L5:
        r112 = null;
        goto L6
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        OfficialChannelInfo r101 = null;
        if ((r100 instanceof tg) == true) goto L5;
        tlc.d r102 = null;
    L7:
        if (((tg) r102) == null) goto L18;
        ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: receive OChannelModifyMessage");
        Room r103 = this.f153746a;
        if (r103 == null) goto L13;
        OfficialChannelInfo r104 = r103.officialChannelInfo;
        if (r104 == null) goto L13;
        r104.setEndTimeStamp(((tg) r100).getEndTimeStamp());
    L13:
        this.f153749d.clear();
        Room r105 = this.f153746a;
        if (r105 == null) goto L16;
        r101 = r105.officialChannelInfo;
    L16:
        xq(r101);
        return;
    L18:
        return;
    L5:
        r102 = r100;
        goto L7
    }

    public final long wq(OfficialChannelInfo r110) {
        Object r100 = null;
        if (r110 == null) goto L5;
        Map<Long, Long> r101 = r110.getDelayEnterTime();
    L7:
        if (r101 == null) goto L33;
        if (r110.getDelayEnterTime().isEmpty() == true) goto L33;
        Object r102 = this.dataCenter.get("data_member_count");
        if (r102 != null) goto L14;
        r102 = 0;
    L14:
        int r103 = ((Number) r102).intValue();
        Iterator r104 = CollectionsKt.sorted(CollectionsKt.toList(r110.getDelayEnterTime().keySet())).iterator();
    L16:
        if (r104.hasNext() == false) goto L23;
        Object r105 = r104.next();
        if (r103 > ((Number) r105).longValue()) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L16;
        r100 = r105;
        goto L23
    L20:
        r106 = false;
    L23:
        Long r107 = (Long) r100;
        if (r107 == null) goto L31;
        Long r111 = r110.getDelayEnterTime().get(Long.valueOf(r107.longValue()));
        if (r111 == null) goto L29;
        return r111.longValue();
    L29:
        return 30;
    L31:
        return 30;
    L33:
        return 30;
    L5:
        r101 = null;
        goto L7
    }

    public final void xq(OfficialChannelInfo r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (((IMicRoomService) jc1.k.n(IMicRoomService.class)).disableReEnterRoomForLinkGuest() == false) goto L8;
        return;
    L8:
        if (r.a().booleanValue() == false) goto L10;
        int r100 = 60;
    L11:
        long r101 = r110.getEndTimeStamp() - (com.bytedance.android.livesdk.utils.ntp.e.a() / ((long) 1000));
        int r102 = Random.Default.nextInt(r100, (int) (((long) r100) + Math.max(1, r110.getMaxNextTime())));
        ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: control to next: duration: " + r101 + ", threshold: " + r102);
        long r103 = (long) r102;
        if (r101 > r103) goto L14;
        ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: control to next: duration < threshold");
        Aq(r110, true);
        return;
    L14:
        ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: control to next: duration > threshold");
        this.f153749d.add(Observable.timer(r101 - r103, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r110), c.f153753a));
        return;
    L10:
        r100 = 30;
        goto L11
    }

    public final void Aq(OfficialChannelInfo r110, boolean r111) {
        IMicRoomService r100 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        boolean r101 = ((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(((IUserService) jc1.k.n(IUserService.class)).user().n());
        Room r102 = this.f153746a;
        Boolean r103 = null;
        if (r102 == null) goto L7;
        OfficialChannelInfo r104 = r102.officialChannelInfo;
        if (r104 == null) goto L7;
        Long r105 = Long.valueOf(r104.getBackupRoomId());
    L8:
        Room r106 = this.f153746a;
        if (r106 == null) goto L11;
        Long r107 = Long.valueOf(r106.f162599id);
    L12:
        boolean r108 = Intrinsics.areEqual(r105, r107);
        StringBuilder r109 = new StringBuilder("mic room: requestNextRoom: isLoyalAudience = ");
        if (r100 == null) goto L15;
        r103 = Boolean.valueOf(r100.isLoyalAudience());
    L15:
        r109.append(r103);
        r109.append(", isHost = ");
        r109.append(r101);
        ALogger.d("MicRoomAudienceTimeControlWidget", r109.toString());
        long r112 = 0;
        if (r100 != null) goto L18;
    L27:
        MicRoomApi r113 = (MicRoomApi) com.bytedance.android.live.network.c.b().e(MicRoomApi.class);
        IBaseUser r114 = r110.getChannelUser();
        String r115 = "0";
        if (r114 == null) goto L31;
        String r116 = r114.getIdString();
        if (r116 == null) goto L31;
    L32:
        Room r117 = this.f153746a;
        if (r117 == null) goto L38;
        String r118 = r117.getOwnerUserIdString();
        if (r118 == null) goto L38;
        r115 = r118;
    L38:
        Observable<Response<com.bytedance.android.livesdk.microom.api.model.b>> r119 = r113.getNextRoomData(r116, r115).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        if (r111 == false) goto L41;
        r119 = r119.delay(Random.Default.nextLong(0, Math.max(1, wq(r110))), TimeUnit.SECONDS);
    L41:
        this.f153749d.add(r119.subscribe(new h(this, r110), new i(this, r110)));
        return;
    L31:
        r116 = "0";
        goto L32
    L18:
        if (r100.isLoyalAudience() != true) goto L27;
        if (r101 == true) goto L27;
        if (r108 == true) goto L27;
        Room r120 = this.f153746a;
        if (r120 == null) goto L24;
        r112 = r120.f162599id;
    L24:
        this.f153747b = r112;
        long r121 = r110.getEndTimeStamp() - (com.bytedance.android.livesdk.utils.ntp.e.a() / ((long) 1000));
        Bq(r121, r110, true, 0);
        if (r.a().booleanValue() == false) goto L43;
        yq(r121, this.f153746a);
        return;
    L43:
        return;
    L11:
        r107 = null;
    L7:
        r105 = null;
        goto L8
    }

    public final void yq(long r100, Room r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.mo8271getOwner() == null) goto L10;
        long r102 = 60;
        if (r100 <= r102) goto L11;
        long r103 = r100 - r102;
        ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: start to trick count down after " + r103);
        this.f153749d.add(Observable.timer(r103, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r101), e.f153756a));
        return;
    L11:
        return;
    }

    public final void zq(OfficialChannelInfo r100, boolean r101, long r110) {
        com.bytedance.android.livesdk.user.f r102 = ((IUserService) jc1.k.n(IUserService.class)).user();
        Boolean r103 = null;
        String r104 = null;
        if (r102 == null) goto L5;
        IUser r105 = r102.b();
    L6:
        IInteractService r106 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r106 == null) goto L11;
        if (r105 == null) goto L10;
        r104 = r105.getIdString();
    L10:
        r103 = Boolean.valueOf(r106.isMicRoomHost(r104));
    L11:
        boolean r107 = Intrinsics.areEqual(r103, Boolean.TRUE);
        long r108 = 1;
        if (r107 == true) goto L16;
        r108 = Random.Default.nextLong(1, Math.max(2, wq(r100)));
    L16:
        if (r.a().booleanValue() == true) goto L18;
    L20:
        r110 = r108;
    L21:
        ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: scheduleJumpToNextRoom: jump delay = " + r110);
        if (this.f153747b != 0) goto L24;
        f2.b(R.string.ttlive_mic_room_end_to_anchor_room, 1);
    L24:
        this.f153749d.add(Observable.timer(r110, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r101), g.f153759a));
        return;
    L18:
        if (r110 <= 0) goto L20;
    L5:
        r105 = null;
        goto L6
    }

    public final void Bq(long r100, OfficialChannelInfo r110, boolean r111, long r112) {
        Boolean r101 = (Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE);
        ALogger.d("MicRoomAudienceTimeControlWidget", "mic room: scheduleJumpToNextRoom: duration = " + r100);
        if (r100 > 0) goto L6;
        zq(r110, r111, r112);
        return;
    L6:
        this.f153749d.add(Observable.timer(r100, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r110, r111, r112, r101), k.f153769a));
    }
}
