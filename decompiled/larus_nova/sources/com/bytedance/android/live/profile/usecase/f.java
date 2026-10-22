package com.bytedance.android.live.profile.usecase;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.c0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameDataChannelConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements ut0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f86999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f87000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Integer> f87001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.profile.usecase.a f87002d;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f87003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NewProfileUser f87004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DataCenter f87005c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f87006d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ps0.b f87007e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f87008f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ NewProfileUser f87009g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f87010h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f87011i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ IRoom f87012j;

        public b(f r100, NewProfileUser r101, DataCenter r102, Context r103, ps0.b r104, String r105, NewProfileUser r106, String r107, String r108, IRoom r110, String r111) {
            this.f87003a = r100;
            this.f87004b = r101;
            this.f87005c = r102;
            this.f87006d = r103;
            this.f87007e = r104;
            this.f87008f = r105;
            this.f87009g = r106;
            this.f87010h = r107;
            this.f87011i = r108;
            this.f87012j = r110;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r110, int r111) {
            boolean r112 = com.bytedance.android.live.revenue.core.util.h.f91037a;
            RechargeCurrentCacheData r113 = ((com.bytedance.android.live.recharge.k) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class)).getCurrentRechargeCacheDataObject();
            boolean r100 = false;
            if (r113 == null) goto L5;
            r113.setFollowed(false);
        L5:
            r110.dismiss();
            if (this.f87004b.followInfo != null) goto L8;
            return;
        L8:
            DataCenter r114 = this.f87005c;
            if (r114 == null) goto L29;
            NewProfileTrackUseCase r101 = this.f87003a.f87002d.getLogUseCase();
            Context r102 = this.f87006d;
            ps0.b r103 = this.f87007e;
            String r104 = this.f87008f;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r114, "mDataCenter");
            Intrinsics.checkNotNullParameter(r103, "room");
            Intrinsics.checkNotNullParameter(r104, "userId");
            if ((!Intrinsics.areEqual(r104, r103.getOwnerUserIdStr())) == true) goto L29;
            if (c1.b(r114) == false) goto L22;
            JSONObject r105 = new JSONObject();
            r105.put("anchor_id", r103.getOwnerUserIdStr().toString());     // Catch: JSONException -> L18
            r105.put("room_id", r103.getId());     // Catch: JSONException -> L18
        L20:
            ILiveDouPlusService r106 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
            os0.c r107 = new os0.c();
            r107.a(r105);
            r107.b(c1.e(r114));
            r106.logEvent(true, "live_ad", "follow_cancel", r107.f526492a);
        L18:
            e = move-exception;
            e.printStackTrace();
        L22:
            if (c1.c(r114) == false) goto L29;
            JSONObject r108 = new JSONObject();
            r108.put("anchor_id", r103.getOwnerUserIdStr().toString());     // Catch: JSONException -> L26
            r108.put("room_id", r103.getId());     // Catch: JSONException -> L26
        L28:
            ILiveDouPlusService r109 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
            os0.c r115 = new os0.c();
            r115.a(r108);
            r115.b(c1.f(r114));
            r109.logEvent(true, "live_ad", "follow_cancel", r115.f526492a);
        L26:
            e = move-exception;
            e.printStackTrace();
        L29:
            NewProfileTrackUseCase r116 = this.f87003a.f87002d.getLogUseCase();
            boolean r117 = !this.f87009g.isFollowing();
            c0 r118 = this.f87009g.followInfo;
            if (r118 != null) goto L32;
        L34:
            r116.w(r117, r100, this.f87010h, this.f87011i);
            f r119 = this.f87003a;
            Object r120 = this.f87006d;
            this.f87004b.followInfo.getFollowStatus();
            String r121 = this.f87008f;
            long r122 = this.f87007e.getId();
            r119.getClass();
            if ((r120 instanceof Fragment) == false) goto L37;
            Activity r123 = ((Fragment) r120).getActivity();
        L39:
            if ((r120 instanceof Activity) == false) goto L41;
            r123 = (Activity) r120;
        L41:
            if (r123 == null) goto L57;
            com.bytedance.android.livesdk.user.m.c r124 = (com.bytedance.android.livesdk.user.m.c) new com.bytedance.android.livesdk.user.m.c().c(r121);
            r124.d();
            com.bytedance.android.livesdk.user.m.c r125 = r124.f(r122);
            UserProfileEvent r126 = r119.f87002d.getUserProfileEvent();
            if (r126 == null) goto L47;
            HashMap<String, String> r127 = r126.getExtraFollowParams();
            if (r127 == null) goto L47;
        L48:
            com.bytedance.android.livesdk.user.m.c r128 = r125.e(r127);
            r128.getClass();
            Disposable r129 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().A(new com.bytedance.android.livesdk.user.m(r128)).subscribe(new j(r119), k.f87018a);
            if (r129 == null) goto L56;
            r r130 = r119.f87002d.getNewProfileRequestManager();
            r130.getClass();
            Intrinsics.checkNotNullParameter(r129, "disposable");
            r130.f87052a.add(r129);
            return;
        L56:
            return;
        L47:
            r127 = com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_DEFAULT);
            goto L48
        L57:
            return;
        L37:
            r123 = null;
            goto L39
        L32:
            if (r118.getFollowStatus() != 3) goto L34;
            r100 = true;
            goto L34
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f87013a = null;

        static {
            f87013a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    static {
    }

    @Override // ut0.b
    public final MutableLiveData b() {
        return this.f87001c;
    }

    public f(com.bytedance.android.live.profile.usecase.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileViewModel");
        this.f87002d = r100;
        this.f87001c = new MutableLiveData();
    }

    @Override // ut0.b
    public final void a(int r100) {
        if (r100 == 0) goto L4;
    L6:
        this.f87002d.getTargetUser().setFollowStatus(r100);
        if (this.f87002d.loadUserSuccess() == false) goto L10;
        this.f87001c.postValue(Integer.valueOf(r100));
        return;
    L10:
        return;
    L4:
        if (this.f87000b == false) goto L6;
        r100 = 3;
        goto L6
    }

    @Override // ut0.b
    public final void c(boolean r100) {
        ALogger.i(NewProfileInfoViewModel.TAG, "init_user_follow_back=" + r100);
        this.f87000b = r100;
    }

    @Override // ut0.b
    public final void d(Context r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "clickPosition");
        Intrinsics.checkNotNullParameter(r112, "mFromSource");
        NewProfileUser r100 = this.f87002d.getTargetUser();
        q r101 = this.f87002d.getPageTypeUseCase();
        ps0.b r102 = this.f87002d.getRoom();
        String r103 = this.f87002d.getTargetUser().baseProfileInfo.getIdStr();
        DataCenter r104 = this.f87002d.getRoomDataCenter();
        IRoom r113 = this.f87002d.getLiveRoom();
        if (r101.f87045c == false) goto L7;
        String r105 = "live_anchor_c_audience";
    L5:
        String r114 = r105;
        if (r100.isFollowing() == true) goto L123;
        if (r104 == null) goto L45;
        this.f87002d.getLogUseCase().getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "mDataCenter");
        Intrinsics.checkNotNullParameter(r102, "room");
        Intrinsics.checkNotNullParameter(r103, "userId");
        if ((!Intrinsics.areEqual(r103, r102.getOwnerUserIdStr())) == true) goto L45;
        if (c1.b(r104) == false) goto L32;
        JSONObject r106 = new JSONObject();
        r106.put("anchor_id", r102.getOwnerUserIdStr().toString());     // Catch: JSONException -> L28
        r106.put("room_id", r102.getId());     // Catch: JSONException -> L28
    L30:
        os0.b.c().getLiveRoomEventParamUtils().handleLiveAdExtraData(r106);
        ILiveDouPlusService r107 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
        os0.c r115 = new os0.c();
        r115.a(r106);
        r115.b(c1.e(r104));
        r107.logEvent(true, "live_ad", "follow", r115.f526492a);
    L28:
        e = move-exception;
        e.printStackTrace();
    L32:
        if (c1.c(r104) == false) goto L43;
        JSONObject r108 = new JSONObject();
        IBaseUser r109 = r102.getOwner();     // Catch: JSONException -> L40
        if (r109 == null) goto L37;
        String r116 = r109.getIdString();     // Catch: JSONException -> L40
    L38:
        r108.put("anchor_id", r116);     // Catch: JSONException -> L40
        r108.put("room_id", String.valueOf(r102.getId()));     // Catch: JSONException -> L40
    L42:
        os0.b.c().getLiveRoomEventParamUtils().handleLiveAdExtraData(r108);
        ILiveDouPlusService r117 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
        os0.c r118 = new os0.c();
        r118.a(r108);
        r118.b(c1.f(r104));
        boolean r119 = true;
        r117.logEvent(true, "live_ad", "follow", r118.f526492a);
    L44:
        int r120 = x1.f159205a;
    L46:
        NewProfileTrackUseCase r121 = this.f87002d.getLogUseCase();
        boolean r122 = r100.isFollowing() ^ r119;
        c0 r123 = r100.followInfo;
        if (r123 != null) goto L49;
    L51:
        boolean r124 = false;
    L52:
        r121.w(r122, r124, r112, r111);
        NewProfileTrackUseCase r125 = this.f87002d.getLogUseCase();
        r125.getClass();
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L109
        IRoom r127 = r125.f86987g.getRoom().b();     // Catch: Throwable -> L109
        if ((r127 instanceof IRoom) == true) goto L56;
        IRoom r128 = null;
    L57:
        IRoom r129 = r128;     // Catch: Throwable -> L109
        if (r129 == null) goto L111;
        ICommunityMainRoom r130 = (ICommunityMainRoom) r129.castTo(ICommunityMainRoom.class);     // Catch: Throwable -> L109
        if (r130 == null) goto L111;
        IRoomGameData r131 = r130.getRoomGameData();     // Catch: Throwable -> L109
        if (r131 == null) goto L111;
        IRoomGameDataChannelConfig r132 = r131.getRoomGameDataChannelConfig();     // Catch: Throwable -> L109
        if (r132 == null) goto L111;
        String r133 = r132.getGameId();     // Catch: Throwable -> L109
        if (r133 != null) goto L69;
    L72:
        boolean r134 = true;
    L73:
        if (r134 == true) goto L111;
        String r135 = r132.getFusionTagId();     // Catch: Throwable -> L109
        if (r135 != null) goto L77;
    L80:
        boolean r136 = true;
    L81:
        if (r136 == true) goto L111;
        if ((!Intrinsics.areEqual(r125.f86987g.getTargetUser().baseProfileInfo.getIdStr(), r129.getAnchorId())) == true) goto L111;
        HashMap r137 = new HashMap();     // Catch: Throwable -> L109
        String r138 = r132.getGameId();     // Catch: Throwable -> L109
        String r139 = "";
        if (r138 != null) goto L90;
        r138 = "";
    L90:
        r137.put("game_id", r138);     // Catch: Throwable -> L109
        r137.put("action_type", "follow");     // Catch: Throwable -> L109
        String r140 = am2.n.f().c();     // Catch: Throwable -> L109
        if (r140 != null) goto L94;
    L99:
        String r141 = "0";
    L100:
        r137.put("is_ads", r141);     // Catch: Throwable -> L109
        String r142 = r129.getAnchorId();     // Catch: Throwable -> L109
        if (r142 != null) goto L103;
        r142 = "";
    L103:
        r137.put("host_id", r142);     // Catch: Throwable -> L109
        r137.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, String.valueOf(r129.getId()));     // Catch: Throwable -> L109
        r137.put("scene", "0");     // Catch: Throwable -> L109
        String r143 = r129.getRequestId();     // Catch: Throwable -> L109
        if (r143 == null) goto L107;
        r139 = r143;
    L107:
        r137.put("req_id", r139);     // Catch: Throwable -> L109
        os0.b.c().getIHostGameCP().a(r137);     // Catch: Throwable -> L109
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L109
        goto L111
    L94:
        if (r140.length() != 0) goto L96;
        boolean r144 = true;
    L97:
        if (r144 == true) goto L99;
        r141 = "1";
        goto L100
    L96:
        r144 = false;
        goto L97
    L77:
        if (r135.length() == 0) goto L80;
        r136 = false;
        goto L81
    L69:
        if (r133.length() == 0) goto L72;
        r134 = false;
    L111:
        r102.getRequestId();
        long r145 = r102.getId();
        r102.getLabels();
        if (this.f86999a == true) goto L135;
        this.f86999a = true;
        com.bytedance.android.livesdk.user.b.c r146 = (com.bytedance.android.livesdk.user.b.c) new com.bytedance.android.livesdk.user.b.c().c(r103).e();
        r146.e();
        com.bytedance.android.livesdk.user.b.c r147 = r146.g(r114).h(r145);
        r147.e();
        UserProfileEvent r148 = this.f87002d.getUserProfileEvent();
        if (r148 == null) goto L118;
        HashMap<String, String> r149 = r148.getExtraFollowParams();
        if (r149 == null) goto L118;
    L119:
        com.bytedance.android.livesdk.user.b.c r150 = r147.f(r149);
        r150.getClass();
        Disposable r151 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().B(new com.bytedance.android.livesdk.user.b(r150)).subscribe(new g(this), new h(this), new i(this));
        if (r151 == null) goto L133;
        r r152 = this.f87002d.getNewProfileRequestManager();
        r152.getClass();
        Intrinsics.checkNotNullParameter(r151, "disposable");
        r152.f87052a.add(r151);
        return;
    L133:
        return;
    L118:
        r149 = com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_DEFAULT);
        goto L119
    L135:
        return;
    L56:
        r128 = r127;
    L109:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L111
    L49:
        if (r123.getFollowStatus() != 3) goto L51;
        r124 = true;
        goto L52
    L37:
        r116 = null;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L43:
        r119 = true;
    L45:
        r119 = true;
        goto L46
    L123:
        if (Intrinsics.areEqual("anchor_recommend", r111) == false) goto L125;
        return;
    L125:
        z0.a().getClass();
        x0.b r154 = z0.b(r110);
        r154.l(R.string.ttlive_live_profile_un_follow_title);
        r154.i(0, R.string.ttlive_ok, new b(this, r100, r104, r110, r102, r103, r100, r112, r111, r113, r114));
        r154.i(1, R.string.ttlive_cancel, c.f87013a);
        r154.n();
        return;
    L7:
        if (r101.f87044b == false) goto L10;
        r105 = "live_audience_c_anchor";
        goto L5
    L10:
        if (r101.f87046d == false) goto L13;
        r105 = "right_anchor";
        goto L5
    L13:
        if (r101.f87047e == false) goto L15;
        r105 = LinkRoomFightContext.TAG;
        goto L5
    L15:
        r105 = "live_audience_c_audience";
        goto L5
    }
}
