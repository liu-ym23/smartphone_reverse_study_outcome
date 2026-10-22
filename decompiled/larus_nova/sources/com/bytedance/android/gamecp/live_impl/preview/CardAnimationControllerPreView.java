package com.bytedance.android.gamecp.live_impl.preview;

import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.android.gamecp.common.model.ShowCardResult;
import com.bytedance.android.gamecp.common.setting.config.l2;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.z;
import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceCardType;
import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceShowType;
import com.bytedance.android.gamecp.host_api.model.j;
import com.bytedance.android.gamecp.live_impl.GamePromoteDataContext;
import com.bytedance.android.gamecp.live_impl.GamePromoteRoomController;
import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.android.gamecp.live_impl.animation.CardAnimationEvent;
import com.bytedance.android.gamecp.live_impl.card.GamePromoteCardLogger;
import com.bytedance.android.gamecp.live_impl.card.p;
import com.bytedance.android.gamecp.live_impl.timer.GameCardShowTimer;
import com.bytedance.android.gamecp.live_impl.toolbar.AudienceToolbarView;
import com.bytedance.android.gamecp.live_impl.utils.IntroduceCardDataUtils;
import com.bytedance.android.gamecp.live_impl.utils.l;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.common.utility.Logger;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.a1;
import wu.g1;
import wu.q3;
import wu.t3;
import wu.u2;
import wu.v2;
import wu.x1;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class CardAnimationControllerPreView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.live_impl.preview.d f57893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f57894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GameCardShowTimer f57895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f57896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<AudienceToolbarView> f57897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<p> f57898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GamePromoteDataContext f57899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function2<? super Boolean, ? super Boolean, Unit> f57900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<ILiveRoomViewHandler> f57901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedList<CardAnimationEvent> f57902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CardAnimationEvent f57903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CompositeDisposable f57904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f57905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f57906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f57907o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Boolean f57908p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f57909q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f57910r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f57911s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f57912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ILiveRoomControllerProvider.ProviderSource f57913u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f57914v;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardAnimationControllerPreView f57915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f57916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.gamecp.host_api.model.introducecard.g f57917c;

        public a(CardAnimationControllerPreView r100, int r101, com.bytedance.android.gamecp.host_api.model.introducecard.g r102) {
            this.f57915a = r100;
            this.f57916b = r101;
            this.f57917c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            GamePromoteDataContext r102 = this.f57915a.f57899g;
            boolean r103 = true;
            if (r102 != null) goto L5;
        L7:
            CardAnimationControllerPreView r104 = this.f57915a;
            com.bytedance.android.gamecp.host_api.model.introducecard.g r105 = this.f57917c;
            String r106 = r105.gameId;
            if (r106 != null) goto L10;
            r106 = "";
        L10:
            int r107 = r105.f57384d;
            r104.getClass();
            if (r107 != IntroduceCardType.GAME.getType()) goto L38;
            xr.f r108 = (xr.f) s.a(xr.f.class);
            if (r108 == null) goto L25;
            String r109 = r108.Y1();
            if (r109 == null) goto L25;
            if (r109.length() <= 0) goto L20;
            boolean r110 = true;
        L21:
            if (r110 == false) goto L25;
            if (Intrinsics.areEqual(r109, r106) == false) goto L25;
        L36:
            r103 = false;
            goto L38
        L20:
            r110 = false;
        L25:
            int r111 = a1.f561277a.getValue().d();
            if (r111 == 2) goto L38;
            if (r111 == 3) goto L38;
            if (r108 == null) goto L36;
            Set<String> r112 = r108.getDownloadingGames();
            if (r112 == null) goto L36;
            if (CollectionsKt.contains(r112, r106) == true) goto L36;
        L38:
            if (r103 == true) goto L40;
            Logger.d("game-promote", "讲解卡已展示 " + this.f57916b + " 秒， 但它正在下载中或暂停中，不自动隐藏, item=" + this.f57917c.gameName);
            return;
        L40:
            Logger.d("game-promote", "讲解卡已展示 " + this.f57916b + " 秒，超时自动隐藏, item=" + this.f57917c.gameName);
            CardAnimationControllerPreView.f(this.f57915a, "timeout", null, null, null, 30);
            return;
        L5:
            if (r102.isCleared() != true) goto L7;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardAnimationControllerPreView f57918a;

        public b(CardAnimationControllerPreView r100) {
            this.f57918a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L11;
            Disposable r101 = this.f57918a.f57909q;
            if (r101 == null) goto L7;
            r101.dispose();
        L7:
            CompositeDisposable r102 = this.f57918a.f57904l;
            if (r102 == null) goto L12;
            r102.dispose();
            return;
        L12:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardAnimationControllerPreView f57919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.gamecp.host_api.model.introducecard.g f57920b;

        public c(CardAnimationControllerPreView r100, com.bytedance.android.gamecp.host_api.model.introducecard.g r101) {
            this.f57919a = r100;
            this.f57920b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (Intrinsics.areEqual((Boolean) sh6.c.b((sh6.b) r100), Boolean.TRUE) == false) goto L6;
            Logger.i("game-promote", this.f57919a.f57911s + '-' + this.f57919a.f57912t + '-' + this.f57919a.f57913u + " delayAndHide invoke.");
            this.f57919a.b(this.f57920b, true);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f57921a = null;

        static {
            f57921a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            hv.b r102 = hv.d.f487273a;
        }
    }

    public final p c() {
        WeakReference<p> r100 = this.f57898f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public final ILiveRoomViewHandler d() {
        WeakReference<ILiveRoomViewHandler> r100 = this.f57901i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public final boolean e() {
        if (g1.f561313a.getValue().b() == false) goto L6;
        return this.f57906n;
    L6:
        if (this.f57905m == true) goto L8;
    L10:
        return false;
    L8:
        if (this.f57906n == false) goto L10;
        return true;
    }

    public final boolean g() {
        GamePromoteRoomController r100 = e.a(this.f57911s, this.f57912t, this.f57913u);
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.f57743i);
    L6:
        if (r101 != null) goto L10;
        return true;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public final boolean i() {
        if (this.f57908p.booleanValue() == false) goto L9;
        RoomContext.a r100 = RoomContext.Companion;
        String r101 = this.f57911s;
        String r102 = this.f57912t;
        String r103 = this.f57913u.name();
        r100.getClass();
        RoomContext r104 = RoomContext.a.b(r101, r102, r103);
        if (r104 == null) goto L9;
        if (r104.isCleanMode() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void j() {
        GamePromoteDataContext r100 = this.f57899g;
        if (r100 != null) goto L5;
    L11:
        WeakReference<p> r101 = this.f57898f;
        String r102 = null;
        int r103 = 0;
        if (r101 == null) goto L33;
        p r104 = r101.get();
        if (r104 == null) goto L33;
        CardAnimationEvent r105 = this.f57903k;
        if (r105 == null) goto L18;
        String r106 = r105.f57777p;
    L20:
        if (Intrinsics.areEqual(r106, "manual_close") == false) goto L26;
        r104.r(true);
        RoomContext.a r107 = RoomContext.Companion;
        String r108 = this.f57911s;
        String r109 = this.f57912t;
        String r110 = this.f57913u.name();
        r107.getClass();
        RoomContext r111 = RoomContext.a.b(r108, r109, r110);
        if (r111 == null) goto L26;
        m<Boolean> r112 = r111.getManualCloseGameCard();
        if (r112 == null) goto L26;
        r112.setValue(Boolean.TRUE);
    L26:
        r104.f(false);
        Disposable r113 = this.f57909q;
        if (r113 == null) goto L29;
        r113.dispose();
    L29:
        this.f57909q = null;
        Disposable r114 = this.f57910r;
        if (r114 == null) goto L32;
        r114.dispose();
    L32:
        this.f57910r = null;
        goto L33
    L18:
        r106 = null;
    L33:
        CardAnimationEvent r115 = this.f57903k;
        GamePromoteDataContext r116 = this.f57899g;
        if (r116 == null) goto L38;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r117 = r116.getIntroduceCardItem();
        if (r117 == null) goto L38;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r118 = r117.getValue();
    L40:
        if (r118 == null) goto L52;
        if (r118.f57386f != IntroduceShowType.AUTO) goto L44;
        boolean r119 = true;
    L45:
        if (r119 != true) goto L52;
        JSONObject r120 = new JSONObject();
        r120.put("game_id", com.bytedance.android.gamecp.common.utils.s.a(r118));
        r120.put(EventConstants.ExtraJson.GAME_NAME, com.bytedance.android.gamecp.common.utils.s.b(r118));
        if (r115 == null) goto L49;
        String r121 = r115.f57777p;
    L50:
        r120.put("hide_reason", r121);
        Unit r122 = Unit.INSTANCE;
        yr.c.e("explain_card_auto_card_hide", r120.toString());
        goto L52
    L49:
        r121 = null;
        goto L50
    L44:
        r119 = false;
    L52:
        if (nw.a.a(e.b(this.f57913u)) == false) goto L71;
        if (r118 != null) goto L55;
    L62:
        if (r118 == null) goto L71;
        if (r118.f57386f != IntroduceShowType.MANUAL) goto L66;
        boolean r123 = true;
    L67:
        if (r123 != true) goto L71;
        GamePromoteDataContext r124 = this.f57899g;
        if (r124 == null) goto L71;
        r124.setLastManualFinishTime(System.currentTimeMillis());
        goto L71
    L66:
        r123 = false;
        goto L67
    L55:
        if (r118.f57386f != IntroduceShowType.AUTO) goto L57;
        boolean r125 = true;
    L58:
        if (r125 != true) goto L62;
        GamePromoteDataContext r126 = this.f57899g;
        if (r126 == null) goto L71;
        r126.setLastAutoFinishTime(System.currentTimeMillis());
        goto L71
    L57:
        r125 = false;
    L71:
        if (r118 != null) goto L73;
    L82:
        String r127 = "";
        if (r118 != null) goto L85;
    L110:
        if (r118 != null) goto L112;
    L117:
        JSONObject r128 = new JSONObject();
        if (r118 == null) goto L121;
        String r129 = r118.gameName;
        if (r129 == null) goto L121;
    L122:
        r128.put(EventConstants.ExtraJson.GAME_NAME, r129);
        if (r118 == null) goto L126;
        String r130 = r118.gameId;
        if (r130 == null) goto L126;
    L127:
        r128.put("game_id", r130);
        if (r115 == null) goto L131;
        r102 = r115.f57777p;
    L131:
        if (Intrinsics.areEqual(r102, "manual_close") == false) goto L133;
        String r131 = "1";
    L134:
        r128.put("active", r131);
        if (r115 == null) goto L140;
        String r132 = r115.f57777p;
        if (r132 == null) goto L140;
        r127 = r132;
    L140:
        r128.put("hide_reason", r127);
        if (r118 == null) goto L143;
        r103 = r118.f57384d;
    L143:
        r128.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r103);
        Unit r133 = Unit.INSTANCE;
        yr.c.e("explain_card_dismiss", r128.toString());
        return;
    L133:
        r131 = "0";
    L126:
        r130 = "";
    L121:
        r129 = "";
        goto L122
    L112:
        if (r118.f57384d != IntroduceCardType.PROP.getType()) goto L117;
        if (r115 == null) goto L115;
        String r134 = r115.f57777p;
    L116:
        GamePromoteCardLogger.c(r118, Intrinsics.areEqual(r134, "manual_close") ? 1 : 0);
        goto L117
    L115:
        r134 = null;
        goto L116
    L85:
        if (r118.f57384d != IntroduceCardType.GAME.getType()) goto L87;
    L90:
        boolean r135 = true;
    L91:
        if (r135 != true) goto L110;
        if (r115 == null) goto L94;
        String r136 = r115.f57777p;
    L96:
        if (Intrinsics.areEqual(r136, "manual_close") == false) goto L109;
        String r137 = GamePromoteCardLogger.f57827c;
        String r138 = r115.f57778q;
        GamePromoteDataContext r139 = this.f57899g;
        if (r139 == null) goto L104;
        m<Boolean> r140 = r139.getCardShowWhenEnter();
        if (r140 == null) goto L104;
        Boolean r141 = r140.getValue();
        if (r141 == null) goto L104;
        r141.booleanValue();
    L104:
        Intrinsics.checkNotNullParameter(r118, "cardItem");
        Intrinsics.checkNotNullParameter(r138, "downloadStatus");
        long r142 = 0;
        if (GamePromoteCardLogger.f57825a <= 0) goto L107;
        r142 = (System.currentTimeMillis() - GamePromoteCardLogger.f57825a) / ((long) 1000);
    L108:
        Map<String, String> r143 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, com.bytedance.android.gamecp.common.utils.s.b(r118)), TuplesKt.to("game_id", com.bytedance.android.gamecp.common.utils.s.a(r118)), TuplesKt.to("user_id", com.bytedance.android.gamecp.host_api.a.b().getUserService().getCurUserId()), TuplesKt.to("duration", String.valueOf(r142)), TuplesKt.to("show_type", r118.f57386f.getType()), TuplesKt.to("download_status", r138)});
        com.bytedance.android.gamecp.host_api.a.b().getLiveService().putFunctionTypeToLogMap(r143, com.bytedance.android.gamecp.host_api.a.b().getLiveService().getCurrentScene());
        GamePromoteCardLogger.f57827c = "";
        int r144 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g("livesdk_game_promote_user_ad_duration", r143, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG});
        goto L117
    L107:
        Logger.e("game-promote", "讲解卡开始展示时间戳错误");
        goto L108
    L109:
        GamePromoteCardLogger.a(r118);
        goto L117
    L94:
        r136 = null;
        goto L96
    L87:
        if (r118.f57384d == IntroduceCardType.RESERVE.getType()) goto L90;
        r135 = false;
        goto L91
    L73:
        if (r118.f57386f != IntroduceShowType.TIMER) goto L75;
        boolean r145 = true;
    L76:
        if (r145 != true) goto L82;
        JSONObject r146 = new JSONObject();
        r146.put("game_id", com.bytedance.android.gamecp.common.utils.s.a(r118));
        r146.put(EventConstants.ExtraJson.GAME_NAME, com.bytedance.android.gamecp.common.utils.s.b(r118));
        if (r115 == null) goto L80;
        String r147 = r115.f57777p;
    L81:
        r146.put("hide_reason", r147);
        Unit r148 = Unit.INSTANCE;
        yr.c.e("explain_card_timer_hide", r146.toString());
        goto L82
    L80:
        r147 = null;
        goto L81
    L75:
        r145 = false;
    L38:
        r118 = null;
        goto L40
    L5:
        if (r100.isCleared() == true) goto L11;
        GamePromoteDataContext r149 = this.f57899g;
        if (r149 == null) goto L11;
        m<Boolean> r150 = r149.getIntroduceCardVisible();
        if (r150 == null) goto L11;
        r150.setValue(Boolean.FALSE);
        goto L11
    }

    public final void l() {
        UtilityKotlinExtentionsKt.g(0, false, false, new CardAnimationControllerPreView$onCardUnLoad$1(this), 7);
    }

    public final void n() {
        UtilityKotlinExtentionsKt.g(0, false, false, new CardAnimationControllerPreView$onToolbarUnload$1(this), 7);
    }

    public final void t() {
        CardAnimationEvent r100 = this.f57903k;
        boolean r101 = false;
        if (r100 == null) goto L15;
        if ((System.currentTimeMillis() - r100.f57768g) >= q3.f561375a.getValue().a()) goto L8;
        LocalTestManager.a(new Class[]{uv.a.class});
        return;
    L8:
        LocalTestManager.a(new Class[]{uv.a.class});
        JSONObject r102 = new JSONObject();
        if (r100.f57765d == false) goto L11;
        String r103 = "1";
    L12:
        r102.put("show", r103);
        Unit r104 = Unit.INSTANCE;
        yr.c.e("explain_card_queue_event_timeout", r102.toString());
        m(true);
        return;
    L11:
        r103 = "0";
        goto L12
    L15:
        if (this.f57902j.isEmpty() == false) goto L18;
    L36:
        CardAnimationEvent r105 = this.f57902j.pollFirst();
        Object r106 = "";
        q("explain_card_queue_poll", r105, "");
        if (r105 != null) goto L39;
        return;
    L39:
        r105.c(CardAnimationEvent.State.DEQUEUE);
        LocalTestManager.a(new Class[]{uv.a.class});
        this.f57903k = r105;
        r105.f57768g = System.currentTimeMillis();
        q("explain_card_queue_task_begin", this.f57903k, "");
        GamePromoteDataContext r107 = this.f57899g;
        String r108 = null;
        if (r107 == null) goto L44;
        m<Boolean> r109 = r107.getIntroduceCardVisible();
        if (r109 == null) goto L44;
        Boolean r110 = r109.getValue();
    L45:
        boolean r111 = r105.f57765d;
        if (Intrinsics.areEqual(r110, Boolean.FALSE) == false) goto L49;
        if (r111 == true) goto L49;
        Logger.i("game-promote", "讲解卡事件结束：cardVisible=" + r110 + " ,show=" + r111 + ' ');
        m(true);
        return;
    L49:
        CardAnimationEvent r112 = this.f57903k;
        if (r112 != null) goto L53;
        Logger.i("game-promote", "讲解卡事件结束：mCurEvent==null.");
        m(true);
        return;
    L53:
        if (r112.f57765d == false) goto L102;
        WeakReference<p> r113 = this.f57898f;
        if (r113 == null) goto L57;
        p r114 = r113.get();
    L58:
        if (r114 != null) goto L61;
        Logger.i("game-promote", "讲解卡事件结束：widget == null");
        m(true);
    L109:
        StringBuilder r115 = new StringBuilder("讲解卡动画 动画开始执行 show = ");
        r115.append(r112.f57765d);
        r115.append(" name = ");
        CardAnimationEvent r116 = this.f57903k;
        if (r116 == null) goto L114;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r117 = r116.f57767f;
        if (r117 == null) goto L114;
        r108 = com.bytedance.android.gamecp.common.utils.s.b(r117);
    L114:
        r115.append(r108);
        Logger.i("game-promote", r115.toString());
        CardAnimationEvent r118 = this.f57903k;
        if (r118 == null) goto L120;
        r118.c(CardAnimationEvent.State.ANIMATION_TASK_START);
        return;
    L120:
        return;
    L61:
        if (g1.f561313a.getValue().b() == false) goto L72;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r119 = r112.f57767f;
        if (r119 == null) goto L72;
        if (r119.f57387g != true) goto L72;
        if (r119.f57386f != IntroduceShowType.RULE) goto L69;
        boolean r120 = true;
    L70:
        if (r120 == true) goto L72;
        r101 = true;
        goto L72
    L69:
        r120 = false;
    L72:
        yr.c.e("CardLoadOpt", "provideWidget need skip：" + r101);
        if (r101 == true) goto L75;
        r114.o();
    L75:
        com.bytedance.android.gamecp.host_api.model.introducecard.g r121 = r112.f57767f;
        if (r121 != null) goto L78;
        Logger.i("game-promote", "讲解卡事件结束：event.introduceCardItem == null");
        m(true);
        goto L109
    L78:
        GamePromoteDataContext r122 = this.f57899g;
        if (r122 != null) goto L81;
    L87:
        String r123 = r112.f57776o;
        JSONObject r124 = new JSONObject();
        String r125 = r121.gameName;
        if (r125 != null) goto L90;
        r125 = "";
    L90:
        r124.put(EventConstants.ExtraJson.GAME_NAME, r125);
        String r126 = r121.gameId;
        if (r126 != null) goto L93;
        r126 = "";
    L93:
        r124.put("game_id", r126);
        r124.put("change_from", r123);
        r124.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r121.f57384d);
        GamePromoteDataContext r127 = this.f57899g;
        if (r127 == null) goto L101;
        m<Boolean> r128 = r127.getIntroduceCardVisible();
        if (r128 == null) goto L101;
        Boolean r129 = r128.getValue();
        if (r129 == null) goto L101;
        r106 = r129;
    L101:
        r124.put("card_visible", r106);
        Unit r130 = Unit.INSTANCE;
        yr.c.e("explain_card_data_update", r124.toString());
        goto L109
    L81:
        if (r122.isCleared() == true) goto L87;
        GamePromoteDataContext r131 = this.f57899g;
        if (r131 == null) goto L87;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r132 = r131.getIntroduceCardItem();
        if (r132 == null) goto L87;
        r132.setValue(r121);
        goto L87
    L57:
        r114 = null;
        goto L58
    L102:
        GamePromoteDataContext r133 = this.f57899g;
        if (r133 == null) goto L107;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r134 = r133.getIntroduceCardItem();
        if (r134 == null) goto L107;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r135 = r134.getValue();
    L108:
        r112.f57767f = r135;
    L107:
        r135 = null;
    L44:
        r110 = null;
        goto L45
    L18:
        if (this.f57902j.getFirst().f57765d == false) goto L26;
        GamePromoteDataContext r136 = this.f57899g;
        if (r136 == null) goto L36;
        m<Boolean> r137 = r136.getIntroduceCardVisible();
        if (r137 == null) goto L36;
        if (r137.getValue().booleanValue() != true) goto L36;
        Logger.i("game-promote", "事件队列-" + this.f57902j.size() + ",在第一个事件前加一个隐藏事件");
        LinkedList<CardAnimationEvent> r138 = this.f57902j;
        CardAnimationEvent r139 = new CardAnimationEvent(this);
        r139.f57765d = false;
        Unit r140 = Unit.INSTANCE;
        r138.addFirst(r139);
        goto L36
    L26:
        GamePromoteDataContext r141 = this.f57899g;
        if (r141 == null) goto L36;
        m<Boolean> r142 = r141.getIntroduceCardVisible();
        if (r142 == null) goto L36;
        if (r142.getValue().booleanValue() == true) goto L36;
        CardAnimationEvent r143 = this.f57902j.pollFirst();
        if (r143 == null) goto L35;
        r143.c(CardAnimationEvent.State.EVENT_END);
    L35:
        q("explain_card_queue_poll", r143, "hide event when hide");
        LocalTestManager.a(new Class[]{uv.a.class});
        goto L36
    }

    public final ShowCardResult a(com.bytedance.android.gamecp.host_api.model.introducecard.g r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        int r101 = r100.f57384d;
        Intrinsics.checkNotNullParameter(r100, "$this$getIntroduceConfigByType");
        ArrayList<j> r102 = null;
        Map<String, l2> r103 = wu.l2.f561344a.getValue();     // Catch: Exception -> L8
        if (r103 == null) goto L10;
        l2 r104 = r103.get(String.valueOf(r101));     // Catch: Exception -> L8
    L12:
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r104, "$this$enable");
        boolean r105 = Intrinsics.areEqual(r104.a(), Boolean.TRUE);
    L16:
        if (r105 == true) goto L29;
        if (r100.f57384d != IntroduceCardType.MINIGAME.getType()) goto L27;
        RoomContext.a r106 = RoomContext.Companion;
        String r107 = this.f57911s;
        String r108 = this.f57912t;
        String r109 = this.f57913u.name();
        r106.getClass();
        RoomContext r110 = RoomContext.a.b(r107, r108, r109);
        if (r110 == null) goto L25;
        m<ArrayList<j>> r111 = r110.getSimplePromoteList();
        if (r111 == null) goto L25;
        r102 = r111.getValue();
    L25:
        if (l.j(r102) == false) goto L29;
        LocalTestManager.a(new Class[]{uv.a.class});
        return ShowCardResult.SETTGING_DISABLE;
    L27:
        LocalTestManager.a(new Class[]{uv.a.class});
        return ShowCardResult.SETTGING_DISABLE;
    L29:
        if (com.bytedance.android.gamecp.host_api.a.b().getLiveService().hasFullWatchRight() == true) goto L32;
        LocalTestManager.a(new Class[]{uv.a.class});
        return ShowCardResult.PAID_LIVE_RIGHT;
    L32:
        return ShowCardResult.SUCCESS;
    L14:
        r105 = true;
    L10:
        r104 = null;
    L8:
        e = move-exception;
        yr.c.b("GameIntroduceCardItemExt", String.valueOf(e));
        goto L10
    }

    public final boolean h(String r100) {
        int r101 = r100.hashCode();
        if (r101 == (-1313911455)) goto L23;
        if (r101 == (-1051345857)) goto L8;
        return true;
    L8:
        if (r100.equals("manual_close") == false) goto L26;
        GamePromoteDataContext r102 = this.f57899g;
        if (r102 == null) goto L14;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r103 = r102.getIntroduceCardItem();
        if (r103 == null) goto L14;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r104 = r103.getValue();
    L15:
        if (r104 != null) goto L17;
    L24:
        return false;
    L17:
        if (r104.f57386f != IntroduceShowType.AUTO) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == true) goto L24;
        return true;
    L19:
        r105 = false;
    L14:
        r104 = null;
        goto L15
    L26:
        return true;
    L23:
        if (r100.equals("timeout") == true) goto L24;
        return true;
    }

    public final void m(boolean r100) {
        q("explain_card_queue_task_end", this.f57903k, "");
        CardAnimationEvent r101 = this.f57903k;
        if (r101 == null) goto L5;
        r101.c(CardAnimationEvent.State.EVENT_END);
    L5:
        this.f57903k = null;
        if (r100 == false) goto L9;
        t();
        return;
    }

    public final void o(final CardAnimationEvent r100) {
        if (e() == false) goto L5;
    L8:
        this.f57900h = null;
        r100.f57769h = SystemClock.elapsedRealtime();
        UtilityKotlinExtentionsKt.g(0, true, false, new CardAnimationControllerPreView$continueExecuteShowAnimationEvent$1(this, r100), 5);
        return;
    L5:
        if (g() == true) goto L8;
        final long r101 = SystemClock.elapsedRealtime();
        LocalTestManager.a(new Class[]{uv.a.class});
        this.f57900h = new CardAnimationControllerPreView$postAnimationEvent$2(this, r100, r101);
    }

    public final void b(com.bytedance.android.gamecp.host_api.model.introducecard.g r100, boolean r101) {
        Disposable r102 = null;
        if (x1.f561415a.getValue().booleanValue() == false) goto L24;
        RoomContext.a r103 = RoomContext.Companion;
        String r104 = this.f57911s;
        String r105 = this.f57912t;
        String r106 = this.f57913u.name();
        r103.getClass();
        RoomContext r107 = RoomContext.a.b(r104, r105, r106);
        if (r107 == null) goto L9;
        m<Boolean> r108 = r107.getHasGetIntroduceCardEnterData();
        if (r108 == null) goto L9;
        Boolean r109 = r108.getValue();
    L11:
        if (Intrinsics.areEqual(r109, Boolean.TRUE) == false) goto L13;
        return;
    L13:
        RoomContext r110 = RoomContext.a.b(this.f57911s, this.f57912t, this.f57913u.name());
        if (r110 == null) goto L24;
        m<Boolean> r111 = r110.getHasGetIntroduceCardEnterData();
        if (r111 == null) goto L24;
        Observable<Boolean> r112 = r111.a();
        if (r112 == null) goto L24;
        Disposable r113 = r112.subscribe(new b(this));
        if (r113 == null) goto L24;
        CompositeDisposable r114 = this.f57904l;
        if (r114 == null) goto L24;
        r114.add(r113);
    L9:
        r109 = null;
    L24:
        Disposable r115 = this.f57909q;
        if (r115 == null) goto L27;
        r115.dispose();
    L27:
        this.f57909q = null;
        Disposable r116 = this.f57910r;
        if (r116 == null) goto L30;
        r116.dispose();
    L30:
        this.f57910r = null;
        if (e.b(this.f57913u) == false) goto L49;
        if (r101 == true) goto L49;
        RoomContext.a r117 = RoomContext.Companion;
        String r118 = this.f57911s;
        String r119 = this.f57912t;
        String r120 = this.f57913u.name();
        r117.getClass();
        RoomContext r121 = RoomContext.a.b(r118, r119, r120);
        if (r121 == null) goto L38;
        n<Boolean> r122 = r121.isInResumeStatus();
        if (r122 == null) goto L38;
        Boolean r123 = r122.getValue();
    L40:
        if ((!Intrinsics.areEqual(r123, Boolean.TRUE)) == false) goto L49;
        if (r121 == null) goto L47;
        n<Boolean> r124 = r121.isInResumeStatus();
        if (r124 == null) goto L47;
        Observable<sh6.b<Boolean>> r125 = r124.a();
        if (r125 == null) goto L47;
        r102 = r125.subscribe(new c(this, r100));
    L47:
        this.f57910r = r102;
        return;
    L38:
        r123 = null;
    L49:
        RoomContext.a r126 = RoomContext.Companion;
        String r127 = this.f57911s;
        String r128 = this.f57912t;
        String r129 = this.f57913u.name();
        r126.getClass();
        RoomContext r130 = RoomContext.a.b(r127, r128, r129);
        if (cs.a.a() == false) goto L54;
        t3 r131 = t3.f561393a;
        if (r131.getValue().d() == false) goto L54;
        long r132 = r131.getValue().a();
    L61:
        int r133 = (int) r132;
        yr.b.b(4, "game-promote", "讲解卡限制时长 = " + r133 + " 秒, item=" + com.bytedance.android.gamecp.common.utils.s.b(r100));
        if (r133 > 0) goto L65;
        Logger.d("game-promote", "讲解卡不限制时长, item=" + r100.gameName);
        return;
    L65:
        CompositeDisposable r134 = this.f57904l;
        if (r134 == null) goto L68;
        r102 = Observable.timer(r133, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r133, r100), d.f57921a);
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r102, r134);
    L68:
        this.f57909q = r102;
        return;
    L54:
        if (r130 == null) goto L60;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.s> r135 = r130.getUserIntroCardDisplayConfig();
        if (r135 == null) goto L60;
        com.bytedance.android.gamecp.host_api.model.introducecard.s r136 = r135.getValue();
        if (r136 == null) goto L60;
        r132 = r136.displayDuration;
    L60:
        r132 = 60;
        goto L61
    }

    public static void p(String r100, com.bytedance.android.gamecp.host_api.model.introducecard.g r101, String r102) {
        JSONObject r103 = new JSONObject();
        if (r101 == null) goto L9;
        r103.put(EventConstants.ExtraJson.GAME_NAME, com.bytedance.android.gamecp.common.utils.s.b(r101));
        if (com.bytedance.android.gamecp.common.utils.s.c(r101) == false) goto L7;
        String r104 = "1";
    L8:
        r103.put("reverse_status", r104);
        r103.put("game_id", com.bytedance.android.gamecp.common.utils.s.a(r101));
        r103.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r101.f57384d);
        goto L9
    L7:
        r104 = "0";
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
        r103.put("reason", r102);
    L17:
        Unit r106 = Unit.INSTANCE;
        yr.c.e(r100, r103.toString());
        return;
    L11:
        if (r102.length() == 0) goto L14;
        r105 = false;
        goto L15
    }

    public static void q(String r100, CardAnimationEvent r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        JSONObject r103 = new JSONObject();
        com.bytedance.android.gamecp.host_api.model.introducecard.g r104 = r101.f57767f;
        String r105 = "";
        if (r104 == null) goto L8;
        String r106 = r104.gameName;
        if (r106 == null) goto L8;
    L9:
        r103.put(EventConstants.ExtraJson.GAME_NAME, r106);
        com.bytedance.android.gamecp.host_api.model.introducecard.g r107 = r101.f57767f;
        if (r107 == null) goto L15;
        String r108 = r107.gameId;
        if (r108 == null) goto L15;
        r105 = r108;
    L15:
        r103.put("game_id", r105);
        com.bytedance.android.gamecp.host_api.model.introducecard.g r109 = r101.f57767f;
        boolean r110 = false;
        if (r109 == null) goto L18;
        int r111 = r109.f57384d;
    L19:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r111);
        String r112 = "1";
        if (r101.f57765d == false) goto L22;
        Object r113 = "1";
    L23:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW, r113);
        r103.put("update_from", r101.f57776o);
        r103.put("unique_key", r101.f57784w.f57912t + '-' + r101.f57784w.f57913u);
        if (r102 != null) goto L26;
    L27:
        r110 = true;
    L28:
        if (r110 == true) goto L31;
        r103.put("reason", r102);
    L31:
        if (r101.f57766e == 11) goto L34;
        r112 = "0";
    L34:
        r103.put("need_animation", r112);
        Unit r114 = Unit.INSTANCE;
        yr.c.e(r100, r103.toString());
        return;
    L26:
        if (r102.length() != 0) goto L28;
    L22:
        r113 = "0";
        goto L23
    L18:
        r111 = 0;
    L8:
        r106 = "";
        goto L9
    }

    public static /* synthetic */ void r(CardAnimationControllerPreView r100, String r101, CardAnimationEvent r102) {
        r100.getClass();
        q(r101, r102, "");
    }

    public final void k(p r100, GamePromoteDataContext r101, ILiveRoomViewHandler r102) {
        Logger.i("game-promote", "onCardLoad  " + this.f57912t + '-' + this.f57913u);
        if (g1.f561313a.getValue().b() == true) goto L5;
    L7:
        this.f57914v.a(true);
        this.f57898f = new WeakReference(r100);
        this.f57899g = r101;
        this.f57901i = new WeakReference(r102);
        this.f57906n = true;
        Function2<? super Boolean, ? super Boolean, Unit> r103 = this.f57900h;
        if (r103 == null) goto L11;
        Unit r104 = r103.invoke(Boolean.valueOf(this.f57905m), Boolean.TRUE);
        return;
    L11:
        return;
    L5:
        if (this.f57904l != null) goto L7;
        this.f57904l = new CompositeDisposable();
        goto L7
    }

    public CardAnimationControllerPreView(String r100, String r101, ILiveRoomControllerProvider.ProviderSource r102, f r103) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "observer");
        this.f57911s = r100;
        this.f57912t = r101;
        this.f57913u = r102;
        this.f57914v = r103;
        this.f57893a = new com.bytedance.android.gamecp.live_impl.preview.d(this);
        this.f57894b = new g(this);
        this.f57895c = new GameCardShowTimer(this);
        this.f57896d = LazyKt.lazy(CardAnimationControllerPreView$exitRoomOpt$2.INSTANCE);
        com.bytedance.android.gamecp.live_impl.preview.d r104 = this.f57893a;
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f57928a.add(new WeakReference(r104));
        g r105 = this.f57894b;
        Intrinsics.checkNotNullParameter(r105, "observer");
        r103.f57928a.add(new WeakReference(r105));
        this.f57902j = new LinkedList();
        this.f57907o = v2.f561404a.getValue();
        this.f57908p = u2.f561398a.getValue();
    }

    public static void f(final CardAnimationControllerPreView r110, String r111, String r112, Boolean r113, Boolean r210, int r211) {
        com.bytedance.android.gamecp.host_api.model.introducecard.g r100 = null;
        if ((r211 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        Boolean r102 = Boolean.TRUE;
    L11:
        if ((r211 & 8) == 0) goto L13;
        Boolean r103 = Boolean.FALSE;
    L14:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "cardHideReason");
        if (r110.h(r111) == false) goto L17;
        r110.f57895c.f();
    L17:
        GamePromoteDataContext r104 = r110.f57899g;
        if (r104 == null) goto L22;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r105 = r104.getIntroduceCardItem();
        if (r105 == null) goto L22;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r106 = r105.getValue();
    L23:
        p("explain_card_dismiss", r106, r111);
        int r107 = 0;
        switch(r111.hashCode()) {
            case -1387910758: goto L55;
            case -1313911455: goto L43;
            case -1051345857: goto L30;
            case -531067948: goto L27;
            default: goto L67;
        };
    L27:
        if (r111.equals("im_close_game") == false) goto L67;
    L56:
        GamePromoteDataContext r108 = r110.f57899g;
        if (r108 == null) goto L59;
        String r109 = r108.getActiveType();
    L61:
        if (UtilsKt.c(r109) == true) goto L67;
        GamePromoteDataContext r114 = r110.f57899g;
        if (r114 == null) goto L67;
        r114.setActiveType(GamePromoteDataContext.ACTION_TYPE_ANCHOR_CLOSE_CARD);
        r114.setActive(false);
        HashMap<String, String> r115 = GamecpTracker.f56755a;
        GamecpTracker.J(r114.generateDurationMap());
        goto L67
    L59:
        r109 = null;
        goto L61
    L30:
        if (r111.equals("manual_close") == false) goto L67;
        GamePromoteDataContext r116 = r110.f57899g;
        if (r116 == null) goto L67;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r117 = r116.getIntroduceCardItem();
        if (r117 == null) goto L67;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r118 = r117.getValue();
        if (r118 == null) goto L67;
        if (r118.f57384d != IntroduceCardType.RESERVE.getType()) goto L67;
        GamePromoteDataContext r119 = r110.f57899g;
        if (r119 == null) goto L67;
        r119.setManualClose(true);
        goto L67
    L43:
        if (r111.equals("timeout") == false) goto L67;
        GamePromoteDataContext r120 = r110.f57899g;
        if (r120 == null) goto L47;
        String r121 = r120.getActiveType();
    L49:
        if (UtilsKt.c(r121) == true) goto L67;
        GamePromoteDataContext r122 = r110.f57899g;
        if (r122 == null) goto L67;
        r122.setActiveType(GamePromoteDataContext.ACTION_TYPE_AUTO_DISAPPEAR);
        r122.setActive(false);
        HashMap<String, String> r123 = GamecpTracker.f56755a;
        GamecpTracker.J(r122.generateDurationMap());
        goto L67
    L47:
        r121 = null;
        goto L49
    L55:
        if (r111.equals("im_close_reserve") == true) goto L56;
    L67:
        if (((Boolean) r110.f57896d.getValue()).booleanValue() == false) goto L78;
        if (Intrinsics.areEqual("icon_hide", r111) == false) goto L78;
        GamePromoteDataContext r124 = r110.f57899g;
        if (r124 == null) goto L78;
        m<Boolean> r125 = r124.getIntroduceCardVisible();
        if (r125 == null) goto L78;
        if (r125.getValue().booleanValue() == true) goto L78;
        yr.c.e("explain_card_dismiss", "小手柄组件卸载且无讲解卡展示");
        return;
    L78:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == true) goto L80;
    L126:
        Logger.i("game-promote", "讲解卡关闭 receive lynx callback,reason=" + r111 + ",isFromLynx = " + r103 + ' ' + r110.f57912t + '-' + r110.f57913u);
        if (((Boolean) r110.f57896d.getValue()).booleanValue() == false) goto L129;
    L137:
        final CardAnimationEvent r126 = new CardAnimationEvent(r110);
        r126.f57765d = false;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r126.f57777p = r111;
        if (x1.f561415a.getValue().booleanValue() == false) goto L145;
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L142;
        int r127 = 11;
    L143:
        r126.f57766e = r127;
        goto L145
    L142:
        r127 = 12;
    L145:
        if (r101 != null) goto L147;
        r101 = "";
    L147:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r126.f57778q = r101;
        r126.f57775n = null;
        if (r110.h(r111) == false) goto L150;
    L170:
        GamePromoteDataContext r128 = r110.f57899g;
        if (r128 == null) goto L175;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r129 = r128.getIntroduceCardItem();
        if (r129 == null) goto L175;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r130 = r129.getValue();
    L176:
        boolean r131 = com.bytedance.android.gamecp.common.track.c.f56779a;
        String r132 = r110.f57911s;
        if (r130 == null) goto L179;
        String r133 = r130.gameId;
    L180:
        Logger.d("GameTrackerForDownload", "onPromoteCardHide:roomId=" + r132 + ",gameId=" + r133);
        if (com.bytedance.android.gamecp.common.track.c.f56779a == false) goto L204;
        if (r132 != null) goto L185;
    L188:
        boolean r134 = true;
    L189:
        if (r134 == true) goto L204;
        if (r133 != null) goto L192;
    L195:
        boolean r135 = true;
    L196:
        if (r135 == true) goto L204;
        com.bytedance.android.gamecp.common.track.c.a r136 = com.bytedance.android.gamecp.common.track.c.b(r132 + '_' + r133);
        r136.f56786e = false;
        if (r136.f56782a == 0) goto L204;
        if (r136.f56787f == 0) goto L204;
        r136.f56788g += SystemClock.elapsedRealtime() - r136.f56787f;
        r136.f56787f = 0;
        goto L204
    L192:
        if (r133.length() == 0) goto L195;
        r135 = false;
        goto L196
    L185:
        if (r132.length() == 0) goto L188;
        r134 = false;
    L204:
        if (r110.e() == true) goto L237;
        GamePromoteDataContext r137 = r110.f57899g;
        if (r137 == null) goto L210;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r138 = r137.getIntroduceCardItem();
        if (r138 == null) goto L210;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r139 = r138.getValue();
    L211:
        p("explain_card_dismiss", r139, r111.concat(" and hasInit=false"));
        GamePromoteDataContext r140 = r110.f57899g;
        if (r140 != null) goto L214;
    L232:
        p r141 = r110.c();
        if (r141 == null) goto L244;
        ILiveRoomViewHandler r142 = r110.d();
        if (r142 == null) goto L245;
        r142.requestDismiss(r141);
        return;
    L245:
        return;
    L244:
        return;
    L214:
        if (r140.isCleared() == true) goto L232;
        GamePromoteDataContext r143 = r110.f57899g;
        if (r143 == null) goto L232;
        m<Boolean> r144 = r143.getIntroduceCardVisible();
        if (r144 == null) goto L232;
        if (r144.getValue().booleanValue() != true) goto L232;
        r110.f57903k = r126;
        GamePromoteDataContext r145 = r110.f57899g;
        if (r145 == null) goto L226;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r146 = r145.getIntroduceCardItem();
        if (r146 == null) goto L226;
        r100 = r146.getValue();
    L226:
        r126.f57767f = r100;
        GamePromoteDataContext r147 = r110.f57899g;
        if (r147 == null) goto L231;
        m<Boolean> r148 = r147.getCloseCardDirectly();
        if (r148 == null) goto L231;
        r148.setValue(Boolean.TRUE);
    L231:
        r110.j();
        r110.m(true);
    L210:
        r139 = null;
        goto L211
    L237:
        r110.o(r126);
        return;
    L179:
        r133 = null;
    L175:
        r130 = null;
        goto L176
    L150:
        if (r111.hashCode() != (-1313911455)) goto L170;
        if (r111.equals("timeout") == false) goto L170;
        GamePromoteDataContext r149 = r110.f57899g;
        if (r149 == null) goto L159;
        m<com.bytedance.android.gamecp.host_api.model.introducecard.g> r150 = r149.getIntroduceCardItem();
        if (r150 == null) goto L159;
        final com.bytedance.android.gamecp.host_api.model.introducecard.g r151 = r150.getValue();
    L160:
        RoomContext.a r152 = RoomContext.Companion;
        String r153 = r110.f57911s;
        String r154 = r110.f57912t;
        String r155 = r110.f57913u.name();
        r152.getClass();
        boolean r156 = com.bytedance.android.gamecp.live_impl.timer.c.a(RoomContext.a.b(r153, r154, r155));
        if (r156 == true) goto L163;
    L166:
        if (r156 == true) goto L168;
        String r157 = "定时器开关未打开";
    L169:
        p("explain_card_timer_show_failed", r151, r157);
        goto L170
    L168:
        r157 = "定时器已开启,勿重复开启";
        goto L169
    L163:
        if (r110.f57895c.f57931a == true) goto L166;
        if (r151 == null) goto L170;
        p("explain_card_timer_start", r151, "");
        r126.f57775n = new CardAnimationControllerPreView$startTimer$$inlined$let$lambda$1(r151, r110, r126);
    L159:
        r151 = null;
        goto L160
    L129:
        if (Intrinsics.areEqual("icon_hide", r111) == false) goto L137;
        GamePromoteDataContext r158 = r110.f57899g;
        if (r158 == null) goto L137;
        m<Boolean> r159 = r158.getIntroduceCardVisible();
        if (r159 == null) goto L137;
        if (r159.getValue().booleanValue() == true) goto L137;
        yr.c.e("explain_card_dismiss", "小手柄组件卸载且无讲解卡展示");
        return;
    L80:
        if (x1.f561415a.getValue().booleanValue() == true) goto L126;
        GamePromoteDataContext r160 = r110.f57899g;
        switch(r111.hashCode()) {
            case -1387910758: goto L100;
            case -1313911455: goto L97;
            case -531067948: goto L94;
            case -530783419: goto L91;
            case 735206456: goto L88;
            case 735484794: goto L85;
            default: goto L102;
        };
    L102:
        if (r160 == null) goto L113;
        String r161 = r160.getActiveType();
        int r162 = r161.hashCode();
        if (r162 == (-1662794083)) goto L118;
        if (r162 == (-30165644)) goto L115;
        if (r162 == 1919805572) goto L112;
    L120:
        r107 = 5;
    L121:
        Logger.i("game-promote", "讲解卡关闭   send event to lynx ,reason=" + r111 + "，reason_int=" + r107 + " , " + r110.f57912t + '-' + r110.f57913u + '}');
        WeakReference<p> r163 = r110.f57898f;
        if (r163 == null) goto L240;
        p r164 = r163.get();
        if (r164 == null) goto L241;
        r164.b(r107);
        return;
    L241:
        return;
    L240:
        return;
    L112:
        if (r161.equals(GamePromoteDataContext.ACTION_TYPE_USER_CLOSE) == false) goto L120;
    L115:
        if (r161.equals(GamePromoteDataContext.ACTION_TYPE_LEAVE_LIVE) == false) goto L120;
        r107 = 3;
        goto L121
    L118:
        if (r161.equals(GamePromoteDataContext.ACTION_TYPE_ANCHOR_CLOSE_LIVE) == false) goto L120;
        r107 = 4;
    L113:
        r107 = 2;
        goto L121
    L85:
        if (r111.equals("im_close_mini_play") == false) goto L102;
    L101:
        r107 = 1;
        goto L121
    L88:
        if (r111.equals("im_close_mini_game") == false) goto L102;
    L91:
        if (r111.equals("im_close_prop") == false) goto L102;
    L94:
        if (r111.equals("im_close_game") == false) goto L102;
    L97:
        if (r111.equals("timeout") == false) goto L102;
    L100:
        if (r111.equals("im_close_reserve") == false) goto L102;
    L22:
        r106 = null;
        goto L23
    L13:
        r103 = r210;
        goto L14
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }

    public static void s(CardAnimationControllerPreView r100, com.bytedance.android.gamecp.host_api.model.introducecard.g r101, String r102, Boolean r110, String r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        r110 = Boolean.TRUE;
    L5:
        String r103 = "android";
        if ((r112 & 8) == 0) goto L8;
        r111 = "android";
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "updateFrom");
        String r104 = null;
        if (r100.f57906n == false) goto L11;
    L21:
        GamePromoteDataContext r113 = r100.f57899g;
        boolean r105 = false;
        if (r113 == null) goto L24;
        r113.setActive(false);
        r113.setActiveType("");
        ((LinkedHashMap) GamecpTracker.f56757c).clear();
    L24:
        CardAnimationEvent r114 = new CardAnimationEvent(r100);
        r114.f57765d = true;
        r114.f57764c = r101.f57384d;
        String r106 = com.bytedance.android.gamecp.common.utils.s.a(r101);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r114.f57763b = r106;
        if (r111 == null) goto L28;
        r103 = r111;
    L28:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r114.f57774m = r103;
        r114.f57767f = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r114.f57776o = r102;
        int r115 = IntroduceCardDataUtils.f58020a;
        int r116 = 12;
        if (IntroduceCardDataUtils.f(r102) == false) goto L32;
        r114.f57766e = 12;
    L37:
        r114.f57775n = null;
        Unit r107 = Unit.INSTANCE;
        r100.o(r114);
        boolean r108 = com.bytedance.android.gamecp.common.track.c.f56779a;
        String r109 = r100.f57911s;
        String r117 = r101.gameId;
        Logger.d("GameTrackerForDownload", "onPromoteCardShow:roomId=" + r109 + ",gameId=" + r117);
        if (com.bytedance.android.gamecp.common.track.c.f56779a == false) goto L54;
        if (r109 != null) goto L42;
    L45:
        boolean r118 = true;
    L46:
        if (r118 == true) goto L54;
        if (r117 != null) goto L49;
    L50:
        r105 = true;
    L51:
        if (r105 == true) goto L54;
        com.bytedance.android.gamecp.common.track.c.a r119 = com.bytedance.android.gamecp.common.track.c.b(r109 + '_' + r117);
        r119.f56786e = true;
        r119.f56787f = SystemClock.elapsedRealtime();
        goto L54
    L49:
        if (r117.length() != 0) goto L51;
    L42:
        if (r109.length() == 0) goto L45;
        r118 = false;
    L54:
        LruCache<String, String> r120 = z.f57329a;
        String r121 = r101.gameId;
        Intrinsics.checkNotNullParameter(r101, "$this$getGamePkgName");
        String r122 = r101.f57383c;     // Catch: Exception -> L70
        if (r122 == null) goto L67;
        JSONObject r123 = new JSONObject(r122).optJSONObject("game_info");     // Catch: Exception -> L70
        if (r123 == null) goto L66;
        JSONObject r124 = r123.optJSONObject("download_info");     // Catch: Exception -> L70
        if (r124 == null) goto L66;
        JSONObject r125 = r124.optJSONObject("android_info");     // Catch: Exception -> L70
        if (r125 == null) goto L66;
        String r126 = r125.optString("download_extra");     // Catch: Exception -> L70
        if (r126 == null) goto L66;
        r104 = new JSONObject(r126).optString("pkg_name");     // Catch: Exception -> L70
    L66:
        if (r104 == null) goto L67;
    L68:
        yr.c.a("IncrementPkgUtils", "讲解卡设置gameId : " + r101.gameId + ", pkgName " + r104);
        Unit r127 = Unit.INSTANCE;
        z.a(r121, r104, "");
        return;
    L67:
        r104 = "";
        goto L68
    L32:
        if (x1.f561415a.getValue().booleanValue() == false) goto L37;
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L36;
        r116 = 11;
    L36:
        r114.f57766e = r116;
        goto L37
    L11:
        if (Intrinsics.areEqual(r102, "card_update_from_im") == false) goto L21;
        ILiveRoomController r128 = com.bytedance.android.gamecp.live_impl.d.f57892d.b(r100.f57911s, r100.f57912t, r100.f57913u);
        if ((r128 instanceof GamePromoteRoomController) == true) goto L15;
        r128 = null;
    L15:
        GamePromoteRoomController r129 = (GamePromoteRoomController) r128;
        if (r129 == null) goto L18;
        p r130 = r129.f57739e;
    L19:
        if (r130 == null) goto L21;
        r130.h();
        goto L21
    L18:
        r130 = null;
        goto L19
    }
}
