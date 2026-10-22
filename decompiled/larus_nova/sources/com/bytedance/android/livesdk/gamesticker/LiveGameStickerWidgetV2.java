package com.bytedance.android.livesdk.gamesticker;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.f;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.k;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.o;
import com.bytedance.android.livesdk.gamesticker.layoutstrategy.LiveGameStickerLayoutStrategy;
import com.bytedance.android.livesdk.gamesticker.layoutstrategy.LiveUniversalLayoutStrategy;
import com.bytedance.android.livesdk.gamesticker.layoutstrategy.e;
import com.bytedance.android.livesdk.gamesticker.layoutstrategy.h;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.GameRoomStickerOprMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOrientation;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.camera_export.CameraParam;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/LiveGameStickerWidgetV2;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGameStickerWidgetV2 extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.gamestickerv2.c f125523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveGameStickerLayoutStrategy f125524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f125525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f125526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f125527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f125528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f125529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GameStickerOrientation f125530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Room f125531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f125532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f125533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f125534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f125535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f125536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Fragment f125537o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f125538p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f125539q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Bundle f125540r;

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGameStickerWidgetV2 f125541a;

        public a(LiveGameStickerWidgetV2 r100) {
            this.f125541a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if ((r100 instanceof GameRoomStickerOprMessage) == false) goto L10;
            GameRoomStickerOprMessage r101 = (GameRoomStickerOprMessage) r100;
            long r102 = r101.baseMessage.roomId;
            LiveGameStickerWidgetV2 r103 = this.f125541a;
            if (r102 != r103.f125539q) goto L11;
            r103.Bq("onMessage");
            LiveGameStickerWidgetV2 r104 = this.f125541a;
            r104.f125527e = true;
            r104.Cq(LivePlatformPlayerManager.a(r104.f125539q, false));
            this.f125541a.wq(SetsKt.setOf(Integer.valueOf(r101.getStickerType())));
            f r105 = f.f106346a;
            k.f106354b.dispatch(this.f125541a.zq(), r101);
            return;
        L11:
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGameStickerWidgetV2 f125542a;

        public b(LiveGameStickerWidgetV2 r100) {
            this.f125542a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            LiveGameStickerWidgetV2 r102 = this.f125542a;
            r102.Cq(LivePlatformPlayerManager.a(r102.f125539q, false));
            com.bytedance.android.livesdk.chatroom.gamestickerv2.c r103 = this.f125542a.f125523a;
            if (r103 == null) goto L6;
            r103.setFirstFrameState(r101.booleanValue());
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGameStickerWidgetV2 f125543a;

        public c(LiveGameStickerWidgetV2 r100) {
            this.f125543a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            this.f125543a.Bq("onSei");
            f r101 = f.f106346a;
            k r102 = k.f106354b;
            String r103 = this.f125543a.zq();
            r102.dispatch(r103, (String) r100);
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_game_live_sticker_container;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final void Aq() {
        if (this.f125523a != null) goto L6;
        xq();
    L6:
        if (this.f125532j == true) goto L10;
        Fragment r100 = this.f125537o;
        if (r100 == null) goto L10;
        f.f106346a.initDataContext(r100, this, GameStickerScene.ENTER);
        this.f125532j = true;
    L10:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r101 = this.f125523a;
        if (r101 == null) goto L16;
        String r102 = this.f125530h.name();
        Room r103 = this.f125531i;
        GameStickerOrientation r104 = this.f125530h;
        long r105 = this.f125540r.getLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, -1);
        if (r105 > 0) goto L15;
        r105 = System.currentTimeMillis();
    L15:
        r101.onPageVisibilityChange(r102, r103, true, r104, r105);
    L16:
        Bq("loadSticker");
        ILivePlayerClient r106 = LivePlatformPlayerManager.a(this.f125539q, false);
        if (r106 != null) goto L19;
        return;
    L19:
        if (this.f125524b != null) goto L25;
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r107 = this.f125523a;
        if (r107 == null) goto L25;
        Bq("attachLayoutStrategy");
        LiveGameStickerLayoutStrategy r108 = new LiveGameStickerLayoutStrategy(this.f125539q, this, r106, this.dataCenter);
        this.f125524b = r108;
        Intrinsics.checkNotNullParameter(r107, "viewProxy");
        r108.f125671h = r107;
        r108.a(LynxViewpagerItem.BIND_ON_ATTACH);
    L25:
        if (this.f125529g == true) goto L31;
        Bq("observePlayerFirstFrame");
        this.f125529g = true;
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r109 = this.f125523a;
        if (r109 == null) goto L30;
        r109.setFirstFrameState(Intrinsics.areEqual(r106.getEventHub().getFirstFrame().getValue(), Boolean.TRUE));
    L30:
        r106.getEventHub().getFirstFrame().observe(this, this.f125534l);
    L31:
        Cq(r106);
    }

    public final void Fq() {
        Bq("unLoadSticker");
        ILivePlayerClient r100 = LivePlatformPlayerManager.a(this.f125539q, false);
        if (r100 == null) goto L10;
        Bq("removeSeiObserver " + this.f125526d);
        this.f125526d = false;
        IRoomEventHub r101 = r100.getEventHub();
        if (r101 == null) goto L9;
        MutableLiveData<String> r102 = r101.getSeiUpdate();
        if (r102 == null) goto L9;
        r102.removeObserver(this.f125535m);
    L9:
        this.f125529g = false;
        Bq("removePlayerFirstFrameObserver");
        r100.getEventHub().getFirstFrame().removeObserver(this.f125534l);
    L10:
        Bq("detachLayoutStrategy");
        LiveGameStickerLayoutStrategy r103 = this.f125524b;
        if (r103 == null) goto L16;
        r103.a("detach");
        if (((Boolean) r103.f125664a.getValue()).booleanValue() == false) goto L15;
        ((LiveUniversalLayoutStrategy) r103.f125670g.getValue()).detach();
        goto L16
    L15:
        ((h) r103.f125665b.getValue()).detach();
        ((e) r103.f125666c.getValue()).detach();
    L16:
        this.f125524b = null;
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r104 = this.f125523a;
        if (r104 == null) goto L19;
        r104.unbindTask();
    L19:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r105 = this.f125523a;
        if (r105 == null) goto L22;
        r105.detachView();
    L22:
        this.f125523a = null;
        Bq("view proxy detach");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Bq("onUnload");
        Fq();
        f r100 = f.f106346a;
        k.f106354b.recycle(zq());
    }

    public final void xq() {
        Bq("view proxy attach");
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r100 = (com.bytedance.android.livesdk.chatroom.gamestickerv2.c) f.f106346a.buildContainerViewProxy(this.context, zq(), GameStickerScene.ENTER);
        this.f125523a = r100;
        View r101 = this.contentView;
        if (r101 == null) goto L15;
        r100.attachView((ViewGroup) r101);
        Room r102 = this.f125531i;
        if (r102 == null) goto L8;
        Set<Integer> r103 = r102.getGameStickerTypes();
        if (r103 == null) goto L8;
    L9:
        Set<Integer> r104 = CollectionsKt.toMutableSet(r103);
        r104.addAll(o.f106358b.get(zq()));
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r105 = this.f125523a;
        if (r105 == null) goto L12;
        r105.f106298k = !r104.isEmpty();
    L12:
        ALogger.i("LiveGameStickerWidgetV2", this.f125539q + " stickerTypes:" + r104);
        wq(r104);
        return;
    L8:
        r103 = SetsKt.emptySet();
        goto L9
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final String zq() {
        return String.valueOf(this.f125539q);
    }

    public final void Bq(String r100) {
        ALogger.d("LiveGameStickerWidgetV2", this.f125539q + " live " + r100);
    }

    public final void Cq(ILivePlayerClient r100) {
        if (this.f125526d == false) goto L5;
        return;
    L5:
        if (this.f125528f == false) goto L31;
        f r101 = f.f106346a;
        boolean r102 = true;
        if ((!o.f106358b.get(zq()).isEmpty()) == false) goto L10;
    L11:
        if (r100 == null) goto L15;
        IRoomEventHub r103 = r100.getEventHub();
        if (r103 == null) goto L15;
        MutableLiveData<String> r104 = r103.getSeiUpdate();
    L16:
        if (r104 != null) goto L19;
        r102 = false;
    L19:
        this.f125526d = r102;
        k r105 = k.f106354b;
        String r106 = zq();
        if (r104 == null) goto L23;
        String r107 = r104.getValue();
        if (r107 == null) goto L23;
    L24:
        r105.dispatch(r106, r107);
        if (r104 == null) goto L27;
        r104.observe(this, this.f125535m);
    L27:
        Bq("observeSei " + this.f125526d);
        return;
    L23:
        r107 = "";
    L15:
        r104 = null;
        goto L16
    L10:
        if (this.f125527e == true) goto L11;
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        Boolean r101 = this.f125533k;
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();
        Room r103 = this.f125531i;
        if (r103 != null) goto L7;
        return;
    L7:
        Eq(r102, r103, CameraParam.TYPE_SYSTEM_CAMERA);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        Bq(WidgetCostModule.TYPE_ON_LOAD);
        this.f125528f = false;
        this.f125527e = false;
        this.f125529g = false;
        xq();
    }

    public final void wq(Set<Integer> r100) {
        f r101 = f.f106346a;
        o.f106358b.cache(zq(), r100);
        if (r100.isEmpty() == true) goto L13;
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r102 = this.f125523a;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.hasTask() == true) goto L16;
        Bq("obtain task and bind task " + r100);
        IGameStickerTask r103 = k.f106354b.obtainTask(GameStickerScene.ENTER, zq(), r100);
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r104 = this.f125523a;
        if (r104 == null) goto L15;
        r104.bindTask(r103);
        return;
    L15:
        return;
    L16:
        return;
    }

    public final void yq(boolean r100) {
        View r101 = this.f125538p.findViewById(R.id.sticker_container);
        View r102 = this.f125538p.findViewById(R.id.player_view_container);
        if ((!Intrinsics.areEqual(r102.getParent(), r101.getParent())) == false) goto L5;
        return;
    L5:
        if ((r101.getParent() instanceof ViewGroup) == false) goto L18;
        ViewParent r103 = r101.getParent();
        if (r103 == null) goto L16;
        ViewGroup r104 = (ViewGroup) r103;
        int r105 = r104.indexOfChild(r102);
        r104.removeView(r101);
        if (r100 == false) goto L12;
        int r106 = r105 + 1;
    L13:
        r104.addView(r101, r106);
        Bq("changeStickerViewIndex isPortrait:" + r100 + ", player Index:" + r105 + " sticker Index:" + r106);
        return;
    L12:
        r106 = r105 - 1;
        goto L13
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void Eq(boolean r100, Room r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, "source");
        Bq("on " + r102 + " ConfigurationChanged isPortrait:" + r100);     // Catch: Exception -> L17
        this.f125531i = r101;     // Catch: Exception -> L17
        if (Intrinsics.areEqual(r102, IHostPlugin.ENTER_FROM_LINKMIC_TYPE) == false) goto L6;
        this.f125533k = Boolean.valueOf(r100);     // Catch: Exception -> L17
    L6:
        yq(r100);     // Catch: Exception -> L17
        if (r100 == false) goto L9;
        GameStickerOrientation r103 = GameStickerOrientation.VERTICAL;     // Catch: Exception -> L17
    L10:
        this.f125530h = r103;     // Catch: Exception -> L17
        Aq();     // Catch: Exception -> L17
        this.f125528f = true;     // Catch: Exception -> L17
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r104 = this.f125523a;     // Catch: Exception -> L17
        if (r104 == null) goto L13;
        r104.onOrientationChanged(!r100 ? 1 : 0);     // Catch: Exception -> L17
    L13:
        LiveGameStickerLayoutStrategy r105 = this.f125524b;     // Catch: Exception -> L17
        if (r105 == null) goto L22;
        r105.b(r100);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L9:
        r103 = GameStickerOrientation.LANDSCAPE;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ALogger.e("LiveGameStickerWidgetV2", "onConfigurationChanged", e);
    }

    public LiveGameStickerWidgetV2(Fragment r100, View r101, long r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r103, "args");
        this.f125537o = r100;
        this.f125538p = r101;
        this.f125539q = r102;
        this.f125540r = r103;
        this.f125530h = GameStickerOrientation.VERTICAL;
        this.f125534l = new b(this);
        this.f125535m = new c(this);
        this.f125536n = new a(this);
    }
}
