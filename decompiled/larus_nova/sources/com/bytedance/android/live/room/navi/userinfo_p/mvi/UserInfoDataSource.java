package com.bytedance.android.live.room.navi.userinfo_p.mvi;

import am2.u;
import am2.x;
import am2.y;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.userinfo_p.utils.c;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdk.utils.b3;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.n;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l81.l;
import l81.q;
import m91.d;
import org.json.JSONObject;
import z91.i;
import zg1.k1;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/mvi/UserInfoDataSource;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoDataSource implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f100054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f100055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f100056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f100057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f100058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f100059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f100060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m91.c f100061h;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoDataSource f100062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f100063b;

        public a(UserInfoDataSource r100, Context r101) {
            this.f100062a = r100;
            this.f100063b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IFollowPair r101 = (IFollowPair) r100;
            if (r3.l(this.f100063b) == false) goto L5;
            r3.q(this.f100063b, s1.B(R.string.live_room_follow_success_talkback));
        L5:
            UserInfoDataSource r102 = this.f100062a;
            Context r103 = r102.f100061h.getContext();
            String r104 = null;
            if ((r103 instanceof FragmentActivity) == true) goto L8;
            r103 = null;
        L8:
            FragmentActivity r105 = (FragmentActivity) r103;
            INavigationProxyService r106 = (INavigationProxyService) k.f(INavigationProxyService.class);
            if (r106 == null) goto L16;
            l r107 = r106.getLivePushPermissionHelper();
            if (r107 == null) goto L16;
            IRoom r108 = r102.f100061h.getRoom();
            if (r108 == null) goto L15;
            r104 = r108.getOwnerUserIdString();
        L15:
            r107.W(r105, r104);
        L16:
            UserInfoDataSource.a(this.f100062a, r101);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoDataSource f100064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f100065b;

        public b(UserInfoDataSource r100, Context r101) {
            this.f100064a = r100;
            this.f100065b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (this.f100064a.f100061h.a() == false) goto L7;
            ExceptionUtils.handleException(this.f100065b, r101);
            return;
        }
    }

    public UserInfoDataSource(d r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        this.f100061h = r100;
        this.f100054a = "UserInfoDataSource";
        this.f100055b = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(boolean r210) {
        if (this.f100061h.a() == true) goto L5;
        return;
    L5:
        e r100 = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user();
        String r101 = "live_detail";
        if (r100.isLogin() == true) goto L9;
        Bundle r102 = new Bundle();
        r102.putString("enter_from", "live_detail");
        r102.putString("action_type", "follow");
        r102.putString("source", "live");
        r102.putString(VSConstants.KEY_V1_SOURCE, "follow");
        this.f100059f = true;
        Context r103 = this.f100061h.getContext();
        com.bytedance.android.livesdk.user.l.a r104 = new com.bytedance.android.livesdk.user.l.a();
        r104.f158685a = CoreSettingUtil.getLoginPromptForFollow();
        r104.f158686b = CoreSettingUtil.getLoginImageForFollow();
        r104.f158689e = "live_detail";
        r104.f158691g = "follow";
        r104.f158688d = "live";
        r104.f158687c = 1;
        r100.login(r103, new com.bytedance.android.livesdk.user.l(r104)).subscribe(new h());
        return;
    L9:
        Context r105 = this.f100061h.getContext();
        if (r105 != null) goto L13;
        return;
    L13:
        if ((r105 instanceof FragmentActivity) == true) goto L15;
        Context r106 = null;
    L16:
        FragmentActivity r107 = (FragmentActivity) r106;
        if (r107 == null) goto L19;
        ((IMiddlewareHostApp) k.n(IMiddlewareHostApp.class)).checkAndShowGuide(r107, "live", r105.getResources().getString(R.string.live_room_push_dialog_tips_live));
    L19:
        IRoom r108 = this.f100061h.getRoom();
        if (r108 != null) goto L22;
        return;
    L22:
        IBaseUser r110 = r108.getOwner();
        if (r110 != null) goto L25;
        return;
    L25:
        if (r210 == false) goto L74;
        c r111 = this.f100060g;
        if (r111 == null) goto L72;
        IRoom r112 = r111.f100157c;
        if (c1.b(r111.f100156b) == false) goto L52;
        if (r112 == null) goto L32;
        IBaseUser r109 = r112.getOwner();
    L33:
        if (r109 == null) goto L52;
        JSONObject r113 = new JSONObject();
        IBaseUser r114 = r112.getOwner();     // Catch: Exception -> L41
        if (r114 == null) goto L38;
        String r115 = r114.getIdString();     // Catch: Exception -> L41
    L39:
        r113.put("anchor_id", String.valueOf(r115));     // Catch: Exception -> L41
        r113.put("room_id", String.valueOf(r112.getId()));     // Catch: Exception -> L41
    L43:
        ILiveDouPlusService r116 = (ILiveDouPlusService) k.n(ILiveDouPlusService.class);
        HashMap r117 = new HashMap();
        r117.put("ad_extra_data", r113.toString());
        Map<String, String> r118 = c1.e(r111.f100156b);
        if (r118 != null) goto L46;
    L49:
        r116.logEvent(true, "live_ad", "follow", r117);
        goto L52
    L46:
        if (r118.isEmpty() == true) goto L49;
        r117.putAll(r118);
        goto L49
    L38:
        r115 = null;
    L41:
        e = move-exception;
        ALogger.e(r111.f100155a, "logDouPlusOnWannaFollow", e);
        goto L43
    L32:
        r109 = null;
    L52:
        if (c1.c(r111.f100156b) == false) goto L71;
        if (r112 == null) goto L55;
        IBaseUser r119 = r112.getOwner();
    L56:
        if (r119 == null) goto L71;
        JSONObject r120 = new JSONObject();
        IBaseUser r121 = r112.getOwner();     // Catch: Exception -> L64
        if (r121 == null) goto L61;
        String r122 = r121.getIdString();     // Catch: Exception -> L64
    L62:
        r120.put("anchor_id", String.valueOf(r122));     // Catch: Exception -> L64
        r120.put("room_id", String.valueOf(r112.getId()));     // Catch: Exception -> L64
    L66:
        ILiveDouPlusService r123 = (ILiveDouPlusService) k.n(ILiveDouPlusService.class);
        HashMap r124 = new HashMap();
        r124.put("ad_extra_data", r120.toString());
        Map<String, String> r125 = c1.f(r111.f100156b);
        if (r125.isEmpty() == true) goto L70;
        r124.putAll(r125);
    L70:
        r123.logEvent(true, "live_ad", "follow", r124);
        b3.a(r111.f100156b, r120);
        goto L71
    L61:
        r122 = null;
    L64:
        e = move-exception;
        ALogger.e(r111.f100155a, "logDouPlusOnWannaFollow", e);
        goto L66
    L55:
        r119 = null;
    L71:
        int r126 = x1.f159205a;
    L73:
        com.bytedance.android.livesdk.user.b.a r127 = new com.bytedance.android.livesdk.user.d.c().c(r110.getIdString());
        r108.getRequestId();
        com.bytedance.android.livesdk.user.d.c r128 = (com.bytedance.android.livesdk.user.d.c) r127.e();
        r128.e();
        com.bytedance.android.livesdk.user.d.c r129 = (com.bytedance.android.livesdk.user.d.c) ((com.bytedance.android.livesdk.user.d.c) r128.g("live")).h(r108.getId());
        r108.getLabels();
        r129.e();
        com.bytedance.android.livesdk.user.d.c r130 = (com.bytedance.android.livesdk.user.d.c) r129.f(j.b(LiveFollowScene.FANS_CLUB_MESSAGE));
        r130.getClass();
        Observable<? extends IFollowPair> r131 = r100.e(new com.bytedance.android.livesdk.user.d(r130)).observeOn(AndroidSchedulers.mainThread());
        UserInfoDataSource r132 = this;
        RxUtilKt.c(r131.subscribe(new a(r132, r105), new b(r132, r105)), r132.f100055b);
    L75:
        q r133 = ((INavigationProxyService) k.n(INavigationProxyService.class)).getRechargeServiceExternal();
        if (r133 == null) goto L81;
        RechargeCurrentCacheData r134 = r133.getCurrentRechargeCacheDataObject();
        if (r134 == null) goto L81;
        r134.setFollowed(true);
    L81:
        if (r210 == false) goto L152;
        IRoom r135 = r132.f100061h.getRoom();     // Catch: Exception -> L143
        HashMap r136 = new HashMap();     // Catch: Exception -> L143
        r136.put("growth_deepevent", String.valueOf(1));     // Catch: Exception -> L143
        if (((IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class)).isPlayingGame() == false) goto L87;
        Object r137 = "1";
    L88:
        r136.put("is_gaming", r137);     // Catch: Exception -> L143
        if (r135 == null) goto L91;
        LiveMode r138 = r135.getStreamType();     // Catch: Exception -> L143
    L92:
        int r139 = h1.f66189a;     // Catch: Exception -> L143
        r136.put("live_type", i1.a(r138));     // Catch: Exception -> L143
        r136.putAll(h1.a(r135));     // Catch: Exception -> L143
        if (r135 == null) goto L97;
        if (r135.getAutoCover() != 0) goto L97;
    L104:
        if (b6.X.getValue().booleanValue() == false) goto L106;
        Object r140 = "1";
    L107:
        r136.put("is_screen_clear", r140);     // Catch: Exception -> L143
        INavigationProxyService r141 = (INavigationProxyService) k.f(INavigationProxyService.class);     // Catch: Exception -> L143
        if (r141 == null) goto L112;
        l81.a r142 = r141.getAudienceGameContext();     // Catch: Exception -> L143
        if (r142 == null) goto L112;
        Long r143 = r142.getCurrentGameId();     // Catch: Exception -> L143
    L113:
        INavigationProxyService r144 = (INavigationProxyService) k.f(INavigationProxyService.class);     // Catch: Exception -> L143
        if (r144 == null) goto L118;
        l81.a r145 = r144.getAudienceGameContext();     // Catch: Exception -> L143
        if (r145 == null) goto L118;
        String r146 = r145.getCurrentGameName();     // Catch: Exception -> L143
    L119:
        if (r143 == null) goto L122;
        if (r146 == null) goto L122;
        r136.put("game_id", String.valueOf(r143.longValue()));     // Catch: Exception -> L143
        r136.put(EventConstants.ExtraJson.GAME_NAME, r146);     // Catch: Exception -> L143
    L122:
        r136.put("connection_type", ((n) k.n(n.class)).getLinkConnectionType());     // Catch: Exception -> L143
        l81.h r147 = ((INavigationProxyService) k.n(INavigationProxyService.class)).getLinkServiceExternal();     // Catch: Exception -> L143
        if (r147 == null) goto L126;
        String r148 = r147.getLinkAnchorCount();     // Catch: Exception -> L143
        if (r148 == null) goto L126;
    L127:
        r136.put("anchor_cnt", r148);     // Catch: Exception -> L143
        com.bytedance.android.livesdk.chatroom.o r149 = z51.a.h(r132.f100061h.getDataCenter(), 2);     // Catch: Exception -> L143
        if (r149 == null) goto L137;
        m<Boolean> r150 = r149.isCleanMode();     // Catch: Exception -> L143
        if (r150 != null) goto L132;
    L134:
        boolean r151 = false;
    L135:
        if (r151 == false) goto L137;
        com.bytedance.android.livesdk.chatroom.o r152 = r149;
    L138:
        r136.put("if_clear_mode", "1");     // Catch: Exception -> L143
        if (r152 != null) goto L141;
        r136.put("if_clear_mode", "0");     // Catch: Exception -> L143
        Unit r153 = Unit.INSTANCE;     // Catch: Exception -> L143
    L141:
        j0 r154 = j0.l();     // Catch: Exception -> L143
        x r155 = new x();     // Catch: Exception -> L143
        r155.f4349a = "live_interact";     // Catch: Exception -> L143
        r155.f4350b = r101;     // Catch: Exception -> L143
        r154.sendLog("livesdk_follow", r136, new Object[]{u.class, new FollowLog("live", r110.getIdString(), 1), r155, IRoom.class, y.class, am2.n.f(), am2.q.class});     // Catch: Exception -> L143
        return;
    L132:
        if (r150.getValue().booleanValue() != true) goto L134;
        r151 = true;
    L137:
        r152 = null;
    L126:
        r148 = "";
    L118:
        r146 = null;
    L112:
        r143 = null;
        goto L113
    L106:
        r140 = "0";
    L97:
        if (r135 != null) goto L99;
    L101:
        String r156 = "other";
    L102:
        r136.put(ILiveRoomPlayFragmentConstant.EXTRA_COVER_TYPE, r156);     // Catch: Exception -> L143
        goto L104
    L99:
        if (r135.getAutoCover() != 1) goto L101;
        r156 = "autocover";
        goto L102
    L91:
        r138 = null;
        goto L92
    L87:
        r137 = "0";
    L143:
        e = move-exception;
        Logger.e(r132.f100054a, e.toString());
        return;
    L152:
        return;
    L72:
        r101 = "live_detail";
        goto L73
    L74:
        r132 = this;
        r101 = "live_detail";
        goto L75
    L15:
        r106 = r105;
        goto L16
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (this.f100061h.a() == false) goto L41;
        if (r101 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L50;
        String r102 = r101.getKey();
        if (r102.hashCode() == 506917167) goto L12;
        return;
    L12:
        if (r102.equals("data_login_event") == false) goto L43;
        k1 r103 = (k1) r101.getData();
        if (r103 == null) goto L52;
        IRoom r104 = this.f100061h.getRoom();
        if (r104 == null) goto L53;
        DataCenter r105 = this.f100061h.getDataCenter();
        if (r105 != null) goto L23;
        return;
    L23:
        if (r103.f571866a == false) goto L44;
        l81.u r106 = ((INavigationProxyService) k.n(INavigationProxyService.class)).getUserService();
        if (r106 == null) goto L45;
        IBaseUser r107 = r104.getOwner();
        if (r107 == null) goto L30;
        String r108 = r107.getIdString();
        if (r108 == null) goto L30;
    L31:
        Single<BaseResponse<IBaseUser, UserExtra>> r109 = r106.r(r108);
        if (r109 == null) goto L46;
        Single<BaseResponse<IBaseUser, UserExtra>> r110 = r109.observeOn(AndroidSchedulers.mainThread());
        if (r110 == null) goto L47;
        Single<R> r111 = r110.map(i.f570987a);
        if (r111 == 0) goto L48;
        Disposable r112 = r111.subscribe(new z91.j(this, r105), z91.k.f570990a);
        if (r112 == null) goto L49;
        RxUtilKt.c(r112, this.f100055b);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L30:
        r108 = "0";
        goto L31
    L45:
        return;
    L44:
        return;
    L53:
        return;
    L52:
        return;
    L43:
        return;
    L50:
        return;
    }

    public static final void a(UserInfoDataSource r100, IFollowPair r101) {
        if (r100.f100061h.a() == false) goto L23;
        if (r101 == null) goto L26;
        IRoom r102 = r100.f100061h.getRoom();
        if (r102 == null) goto L27;
        DataCenter r103 = r100.f100061h.getDataCenter();
        aa1.a r104 = r100.f100061h.b();
        IBaseUser r105 = r102.getOwner();
        if (r105 == null) goto L13;
        r105.setFollowStatus(r101.getFollowStatus());
    L13:
        if (r101.getFollowStatus() == 0) goto L15;
        boolean r106 = true;
    L16:
        r103.put("data_is_followed", Boolean.valueOf(r106));
        if (r101.getFollowStatus() != 0) goto L20;
        r104.getMiddleVm().sendAction(new z91.c());
        r100.f100057d = false;
        return;
    L20:
        if (r100.f100057d == true) goto L25;
        r104.getMiddleVm().sendAction(new z91.d());
        r100.f100057d = true;
        return;
    L25:
        return;
    L15:
        r106 = false;
        goto L16
    L27:
        return;
    L26:
        return;
    }
}
