package com.bytedance.android.live.room.widget;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.ILiveExperienceProxyService;
import com.bytedance.android.live.room.api.rank.IAudienceWidget;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.UnLoginFeatureUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.n3;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/widget/LandscapeRankInfoWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/live/room/api/rank/IAudienceWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lzg1/n3;", "event", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeRankInfoWidget extends MiddlewareRoomRecyclableWidget implements IAudienceWidget, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IRoom f100402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public da1.c f100403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f100404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f100405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f100406e;

    public static final class a {
    }

    public static final class b<T> implements h80.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeRankInfoWidget f100407a;

        public b(LandscapeRankInfoWidget r100) {
            this.f100407a = r100;
        }

        @Override // h80.a
        public final void accept(Object r100) {
            IRoom r101 = (IRoom) r100;
            LandscapeRankInfoWidget r102 = this.f100407a;
            r102.f100402a = r101;
            r102.wq(r101);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeRankInfoWidget f100408a;

        public c(LandscapeRankInfoWidget r100) {
            this.f100408a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = SystemClock.uptimeMillis();
            long r102 = r101 - com.bytedance.android.live.room.util.f.f100392a;
            com.bytedance.android.live.room.util.f.f100392a = r101;
            if (r102 <= 500) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L36;
            LandscapeRankInfoWidget r104 = this.f100408a;
            if (r104.f100405d == true) goto L11;
            return;
        L11:
            if (UnLoginFeatureUtils.INSTANCE.disableUserListWhenUnLogin(r104.f100402a) == false) goto L27;
            IMiddlewareUserService r105 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
            if (r105 == null) goto L18;
            com.bytedance.android.livesdk.user.e r106 = r105.user();
            if (r106 == null) goto L18;
            if (r106.isLogin() == true) goto L27;
        L18:
            IMiddlewareUserService r107 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
            if (r107 == null) goto L37;
            com.bytedance.android.livesdk.user.e r108 = r107.user();
            if (r108 == null) goto L38;
            Context r109 = r104.context;
            l.a r110 = new l.a();
            r110.f158689e = "live_detail";
            r110.f158690f = "click_live_rank";
            Observable<IBaseUser> r111 = r108.login(r109, new l(r110));
            if (r111 == null) goto L39;
            ObservableSource r112 = r111.compose(r104.getAutoUnbindTransformer());
            if (r112 == null) goto L40;
            r112.subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L40:
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L27:
            DataCenter r113 = r104.dataCenter;
            if (r113 == null) goto L34;
            IRoom r114 = a0.n(r113);
            if (r114 == null) goto L34;
            ILiveExperienceProxyService r115 = (ILiveExperienceProxyService) k.f(ILiveExperienceProxyService.class);
            if (r115 == null) goto L34;
            r115.showUserDialog(-1, r104.context, r104.dataCenter, r114);
        L34:
            r104.dataCenter.put("cmd_show_landscape_rank_info_dialog", new Object());
            int r116 = com.bytedance.android.live.room.util.a.f100383a;
            com.bytedance.android.live.room.util.a.a(r104.f100402a);
            return;
        L36:
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_landscape_rank_info_exp;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a263";
    }

    @Override // com.bytedance.android.live.room.api.rank.IAudienceWidget
    public final void ii(List<x71.a> r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        da1.c r100 = this.f100403b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLiveWatchUserPresenter");
    L5:
        r100.detachView();
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L8;
        r101.removeObserver(this);
    L8:
        this.f100406e.clear();
    }

    public LandscapeRankInfoWidget() {
        this.f100405d = true;
        this.f100406e = new CompositeDisposable();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (isViewValid() == false) goto L32;
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getKey();
    L8:
        boolean r104 = true;
        if (r103 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L34;
        if (r101 == null) goto L19;
        r102 = r101.getKey();
    L19:
        if (r102 != null) goto L22;
        return;
    L22:
        if (r102.hashCode() == 146203553) goto L25;
        return;
    L25:
        if (r102.equals("cmd_enable_click_online") == false) goto L33;
        if (r101 == null) goto L30;
        Boolean r106 = (Boolean) r101.getData();
        if (r106 == null) goto L30;
        r104 = r106.booleanValue();
    L30:
        this.f100405d = r104;
        ALogger.i("LiveRoomAudienceWidget", "cmd  enableClickOnline is :  " + this.f100405d);
        return;
    L33:
        return;
    L34:
        return;
    L11:
        if (r103.length() == 0) goto L14;
        r105 = false;
        goto L15
    L7:
        r103 = null;
        goto L8
    }

    public final void onEvent(n3 r100) {
        r r101 = z51.a.e(this.dataCenter);
        if (r101 != null) goto L5;
    L7:
        View r102 = this.contentView;
        if (r102 == null) goto L16;
        if (r100 != null) goto L11;
    L13:
        int r103 = 0;
    L14:
        r102.setVisibility(r103);
        return;
    L11:
        if (r100.f571889a != true) goto L13;
        r103 = 8;
        goto L14
    L16:
        return;
    L5:
        if (r101.isInVrLandscape(this.dataCenter) == true) goto L7;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        da1.c r101 = new da1.c();
        this.f100403b = r101;
        r101.f467655e = this.f100404c;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        this.f100402a = (IRoom) this.dataCenter.get("data_room");
        Object r111 = this.dataCenter.get("log_enter_live_source");
        String r100 = "";
        if (r111 != null) goto L5;
        r111 = "";
    L5:
        String r112 = (String) r111;
        Context r113 = this.context;
        if (r113 == null) goto L86;
        FragmentActivity r114 = (FragmentActivity) r113;
        DataCenter r115 = this.dataCenter;
        if (r115 == null) goto L10;
        this.f100404c = ((Boolean) r115.get("data_is_anchor", Boolean.FALSE)).booleanValue();
    L10:
        da1.c r116 = this.f100403b;
        if (r116 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mLiveWatchUserPresenter");
    L13:
        r116.c0(this);
        DataCenter r117 = this.dataCenter;
        if (r117 == null) goto L16;
        r117.observe("cmd_enable_click_online", this);
    L16:
        r r118 = z51.a.e(this.dataCenter);
        if (r118 != null) goto L19;
    L21:
        wq(this.f100402a);
        runWithRoomEntered(new b(this));
        r r119 = z51.a.e(this.dataCenter);
        if (r119 != null) goto L24;
    L38:
        View r120 = this.contentView;
        if (r120 == null) goto L41;
        TextView r121 = (TextView) r120.findViewById(R.id.tv_online_visitor);
    L42:
        if (r121 == null) goto L45;
        r121.setOnClickListener(new c(this));
    L45:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.dataCenter) == false) goto L87;
        IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r101 == null) goto L55;
        o r102 = IRoomContextService.a.a(r101, null, 0, 3);
        if (r102 == null) goto L55;
        n<z70.b> r103 = r102.getTemplateContext();
        if (r103 == null) goto L55;
        z70.b r104 = r103.getValue();
        if (r104 == null) goto L55;
        boolean r105 = r104.c("user_count");
    L56:
        if (r105 == true) goto L87;
        IRoomContextService r106 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r106 == null) goto L64;
        o r107 = IRoomContextService.a.a(r106, null, 0, 3);
        if (r107 == null) goto L64;
        if (r107.H2() != true) goto L64;
        float r108 = 20.0f;
    L65:
        if (r121 == null) goto L87;
        a1.m(r121, s1.f(r108));
    L64:
        r108 = 28.0f;
    L55:
        r105 = false;
    L87:
        String[] r122 = {"money", "fans", "nothing", "room_money"};     // Catch: Exception -> L82
        Pair[] r109 = new Pair[3];     // Catch: Exception -> L82
        IRoom r123 = this.f100402a;     // Catch: Exception -> L82
        if (r123 == null) goto L73;
        IBaseUser r124 = r123.getOwner();     // Catch: Exception -> L82
        if (r124 == null) goto L73;
        String r125 = r124.getIdString();     // Catch: Exception -> L82
        if (r125 == null) goto L73;
    L74:
        r109[0] = TuplesKt.to("anchor_id", r125);     // Catch: Exception -> L82
        IRoom r126 = this.f100402a;     // Catch: Exception -> L82
        if (r126 == null) goto L80;
        String r127 = r126.getIdStr();     // Catch: Exception -> L82
        if (r127 == null) goto L80;
        r100 = r127;
    L80:
        r109[1] = TuplesKt.to("room_id", r100);     // Catch: Exception -> L82
        r109[2] = TuplesKt.to("rank_type", r122[3]);     // Catch: Exception -> L82
        ((IHostLog) k.n(IHostLog.class)).logV3("livesdk_live_room_info", MapsKt.mapOf(r109));     // Catch: Exception -> L82
        return;
    L73:
        r125 = "";
    L82:
        e = move-exception;
        Logger.throwException(e);
        return;
    L41:
        r121 = null;
        goto L42
    L24:
        if (r119.isInVrLandscape(this.dataCenter) != true) goto L38;
        View r128 = this.contentView;
        if (r128 == null) goto L38;
        IRoomContextService r129 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r129 == null) goto L36;
        o r130 = IRoomContextService.a.a(r129, null, 0, 3);
        if (r130 == null) goto L36;
        m<Boolean> r131 = r130.A1();
        if (r131 == null) goto L36;
        if (r131.getValue().booleanValue() != true) goto L36;
        int r132 = 8;
    L37:
        r128.setVisibility(r132);
    L36:
        r132 = 0;
        goto L37
    L19:
        if (r118.isInVrLandscape(this.dataCenter) != true) goto L21;
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(this.dataCenter).b(n3.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.widget.a(new LandscapeRankInfoWidget$initEvents$1(this))), this.f100406e);
        goto L21
    L86:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void wq(IRoom r100) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L11;
        IRoomAuthStatus r101 = r100.getRoomAuthStatus();
        if (r101 == null) goto L11;
        boolean r102 = true;
        if (r101.isEnableUpRightStatsFloatingLayer() != true) goto L11;
    L12:
        this.f100405d = r102;
        da1.c r103 = this.f100403b;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mLiveWatchUserPresenter");
    L15:
        if (r103 == null) goto L28;
        Long r104 = null;
        if ((r100 instanceof Room) == true) goto L19;
        IRoom r105 = null;
    L20:
        Room r106 = (Room) r105;
        if (r106 == null) goto L23;
        RoomViewStats r107 = r106.viewStats;
    L24:
        if (r100 == null) goto L26;
        r104 = Long.valueOf(r100.getRoomId());
    L26:
        r103.k0(r107, r104);
        return;
    L23:
        r107 = null;
        goto L24
    L19:
        r105 = r100;
        goto L20
    L28:
        return;
    L11:
        r102 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.room.api.rank.IAudienceWidget
    public final void sn(boolean r100, long r101, String r102, String r103) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        View r104 = this.contentView;
        if (r104 == null) goto L8;
        TextView r105 = (TextView) r104.findViewById(R.id.tv_online_visitor);
    L9:
        if (r100 == false) goto L11;
    L19:
        if (r105 == null) goto L21;
        r105.setVisibility(8);
    L21:
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L30;
        r106.put("data_member_count_str", r103);
        r106.put("data_room_pcu", Long.valueOf(r101));
        int r107 = com.bytedance.android.live.room.util.b.f100384a;
        Intrinsics.checkNotNullParameter(r106, "dataCenter");
        w71.a r108 = z51.a.b(r106);
        if (r108 == null) goto L26;
        r108.updateRoomDynamicMemberCount(r101);
    L26:
        Intrinsics.checkNotNullParameter(r106, "dataCenter");
        w71.a r109 = z51.a.b(r106);
        if (r109 == null) goto L31;
        r109.setShareCountText(r103);
        return;
    L31:
        return;
    L30:
        return;
    L11:
        if (TextUtils.isEmpty(r103) == true) goto L19;
        if (r105 == null) goto L15;
        r105.setVisibility(0);
    L15:
        if (r103 == null) goto L21;
        if (r105 == null) goto L18;
        r105.setText(r103);
    L18:
        r3.c(r105, r103, true);
        goto L21
    L8:
        r105 = null;
        goto L9
    }
}
