package com.bytedance.android.livesdk.room.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.widgets.y;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.android.livesdk.config.yk;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.k3;
import com.bytedance.android.livesdk.log.z;
import com.bytedance.android.livesdk.performance.j0;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdk.user.m;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdkapi.commerce.param.IExternalRoomLogger;
import com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomScene;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession;
import com.bytedance.android.livesdkapi.room.handler.enterroom.PreviewReportBuilder;
import com.bytedance.android.livesdkapi.room.handler.enterroom.PreviewReportData;
import com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.livesdk.preview.merge.MergeDataContext;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import jc1.j;
import jc1.k;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z51.e;
import zg1.e0;
import zg1.m2;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ILiveRoomFunctionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<Boolean> f157657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e<Boolean> f157658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f157659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MergeDataContext f157660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f157661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f157662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f157663g;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.room.handler.a$a, reason: collision with other inner class name */
    public static final class C2414a {
    }

    public static final class b implements ILivePreviewBusinessSession {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ILiveEnterRoomScene.RoomFunction f157664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DataCenter f157665b;

        @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession
        public final DataCenter getDataCenter() {
            return this.f157665b;
        }

        @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession
        public final ILiveEnterRoomScene getScene() {
            return this.f157664a;
        }

        public b(a r100) {
            this.f157664a = ILiveEnterRoomScene.RoomFunction.INSTANCE;
            this.f157665b = r100.f157663g;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final boolean isLinkmic() {
        Integer r100 = (Integer) this.f157663g.get("data_link_state", 0);     // Catch: Exception -> L37
        if (r100 != null) goto L7;
    L33:
        if (v.a(r100.intValue(), 64) == false) goto L35;
    L36:
        return true;
    L35:
        if (v.a(r100.intValue(), 4) == true) goto L36;
        return false;
    L7:
        if (r100.intValue() != 0) goto L33;
        ILinkServiceExternal r101 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);     // Catch: Exception -> L37
        if (r101 == null) goto L11;
        Long r102 = Long.valueOf(r101.getRevLinkControlLoadTs());     // Catch: Exception -> L37
    L12:
        if (r102 == null) goto L33;
        if (r102.longValue() != 0) goto L33;
        String r103 = (String) this.f157663g.get("data_first_frame_sei", "");     // Catch: Exception -> L37
        Map<String, Long> r104 = com.bytedance.android.live.core.utils.z.o(this.f157663g).getLinkMap();     // Catch: Exception -> L37
        if (r104 == null) goto L19;
        Long r105 = r104.get(String.valueOf(1));     // Catch: Exception -> L37
    L20:
        if (r105 != null) goto L30;
        Map<String, Long> r106 = com.bytedance.android.live.core.utils.z.o(this.f157663g).getLinkMap();     // Catch: Exception -> L37
        if (r106 == null) goto L24;
        Long r107 = r106.get(String.valueOf(7));     // Catch: Exception -> L37
    L25:
        if (r107 != null) goto L30;
        if (StringsKt.contains$default(r103, "\\\"ver\\\":2,", false, 2, null) == true) goto L30;
        if (StringsKt.contains$default(r103, "\\\"ver\\\":6", false, 2, null) == true) goto L30;
        return false;
    L24:
        r107 = null;
    L30:
        return true;
    L19:
        r105 = null;
        goto L20
    L11:
        r102 = null;
    L37:
        e = move-exception;
        ALogger.e("Error parsing json", e);
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void onPurchasingIntentionAction() {
        ALogger.d("LiveRoomFunctionHandler", "onPurchasingIntentionAction");
        xs2.b.a().post(new m2());
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final Observable<Boolean> previewCompResumeEvent() {
        return this.f157658b.a();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final Observable<Boolean> previewCompShowEvent() {
        return this.f157657a.a();
    }

    public a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f157663g = r100;
        int r101 = e.f570057c;
        this.f157657a = new e(null);
        this.f157658b = new e(Boolean.FALSE);
        this.f157659c = new CompositeDisposable();
        this.f157662f = new b(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void enterRoom(ILiveEnterRoomCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ILiveEnterRoomParams r101 = r100.getEnterParams(this.f157662f);
        String r102 = r101.getEnterKey().getName();
        Bundle r103 = r101.getBusinessBundle();
        String r104 = r101.getClickMethod();
        Bundle r105 = r101.getFirstRoomLogParams();
        Map<String, String> r106 = r101.getCommonLogParams();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        ALogger.i("SimpleLiveRoomFunctionHandler", "businesskey:" + r101.getEnterKey().getName() + "\tbusinessBundle:" + r103 + "\tfirstRoomLogParams:" + r105 + "\tcommonLogParams:" + r106);
    L5:
        r100.onBeforeEnterRoom(this.f157662f);
        enterRoom(r102, r103, r104, r105, r106);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final ViewGroup getLiveContentViewGroup(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        return (ViewGroup) r100.findViewById(R.id.parent_view);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler
    public final <T extends IExternalRoomLogger> T getLogger(Class<T> r110) {
        Intrinsics.checkNotNullParameter(r110, "loggerClass");
        if (Intrinsics.areEqual(r110, ILivePromotionActionListener.class) == false) goto L29;
        if (this.f157661e != null) goto L23;
        Room r111 = (Room) this.f157663g.get("data_room");
        boolean r100 = c1.b(this.f157663g);
        boolean r101 = c1.c(this.f157663g);
        DataCenter r102 = this.f157663g;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        DataCenter r104 = this.f157663g;
        int r105 = x1.f159205a;
        c1.d(r104);
        Map<String, String> r106 = c1.e(this.f157663g);
        Map<String, String> r107 = c1.f(this.f157663g);
        DataCenter r108 = this.f157663g;
        if (r108 == null) goto L17;
        Map r109 = (Map) r108.get("live_hybrid_ad_log_extra_map", new HashMap());
        if (r109 == null) goto L17;
    L18:
        Map r112 = r109;
        Map<String, String> r113 = x1.a(this.f157663g);
        if (r111 == null) goto L21;
        Long r114 = Long.valueOf(r111.f162599id);
    L22:
        this.f157661e = new z(r100, r101, r103, r106, r107, r112, r113, r114);
        goto L23
    L21:
        r114 = null;
    L17:
        r109 = new HashMap();
        goto L18
    L9:
        if (((Boolean) r102.get("enter_from_hybrid_ad", Boolean.FALSE)).booleanValue() == false) goto L11;
        r103 = true;
    L23:
        z r115 = this.f157661e;
        if (r115 == null) goto L27;
        return r115;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L29:
        return (T) j.a(new Object(), r110);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void startVBoost(int r100) {
        if (r100 != 0) goto L5;
        cu2.c.a(3, k3.f142264a.getValue().mTimeoutOpenCommerceList);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void takeLiveRoomScreenshot(ConfigObserver<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "bitmapObserver");
        this.f157663g.put("cmd_screenshot_live_room", r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    /* JADX INFO: renamed from: getLogger, reason: collision with other method in class */
    public final <T extends com.bytedance.android.livesdkapi.room.logger.IExternalRoomLogger> T mo8269getLogger(Class<T> r110) {
        Intrinsics.checkNotNullParameter(r110, "loggerClass");
        if (Intrinsics.areEqual(r110, com.bytedance.android.livesdkapi.room.logger.ILivePromotionActionListener.class) == false) goto L29;
        if (this.f157661e != null) goto L23;
        Room r111 = (Room) this.f157663g.get("data_room");
        boolean r100 = c1.b(this.f157663g);
        boolean r101 = c1.c(this.f157663g);
        DataCenter r102 = this.f157663g;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        DataCenter r104 = this.f157663g;
        int r105 = x1.f159205a;
        c1.d(r104);
        Map<String, String> r106 = c1.e(this.f157663g);
        Map<String, String> r107 = c1.f(this.f157663g);
        DataCenter r108 = this.f157663g;
        if (r108 == null) goto L17;
        Map r109 = (Map) r108.get("live_hybrid_ad_log_extra_map", new HashMap());
        if (r109 == null) goto L17;
    L18:
        Map r112 = r109;
        Map<String, String> r113 = x1.a(this.f157663g);
        if (r111 == null) goto L21;
        Long r114 = Long.valueOf(r111.f162599id);
    L22:
        this.f157661e = new z(r100, r101, r103, r106, r107, r112, r113, r114);
        goto L23
    L21:
        r114 = null;
    L17:
        r109 = new HashMap();
        goto L18
    L9:
        if (((Boolean) r102.get("enter_from_hybrid_ad", Boolean.FALSE)).booleanValue() == false) goto L11;
        r103 = true;
    L23:
        z r115 = this.f157661e;
        if (r115 == null) goto L27;
        return r115;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L29:
        return (T) j.a(new Object(), r110);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void fullDialogHoverStateChange(int r100, boolean r101) {
        if (r100 != 1) goto L5;
    L12:
        boolean r102 = true;
    L13:
        e0 r103 = new e0(r102);
        if (yk.f121696a.getValue().booleanValue() == false) goto L24;
        ALogger.i("SimpleLiveRoomFunctionHandler", "fullDialogHoverStateChange new state:" + r100 + ", translucent:" + r101);
        switch(r100) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L25;
        };
    L18:
        xs2.b.a().post(new y(true, 4));
        xs2.b.a().post(new y(true, 8));
        goto L25
    L19:
        xs2.b.a().post(new y(false, 4));
        xs2.b.a().post(new y(false, 8));
        goto L25
    L20:
        xs2.b.a().post(new y(false, 4));
        goto L25
    L21:
        xs2.b.a().post(new y(false, 8));
        goto L25
    L22:
        xs2.b.a().post(new y(true, 8));
        goto L25
    L23:
        xs2.b.a().post(new y(true, 4));
    L25:
        DataCenter r104 = this.f157663g;
        if (r104 == null) goto L28;
        Integer r105 = Integer.valueOf(r104.hashCode());
    L29:
        LayerEventDispatcher r106 = o70.c.a(r105);
        if (r106 == null) goto L33;
        r106.b(r103);
        return;
    L33:
        return;
    L28:
        r105 = null;
        goto L29
    L24:
        ALogger.i("SimpleLiveRoomFunctionHandler", "fullDialogHoverStateChange old state:" + r100 + ", translucent:" + r101);
        xs2.b.a().post(r103);
        goto L25
    L5:
        if (r100 == 2) goto L12;
        if (r100 == 3) goto L12;
        if (r100 == 6) goto L12;
        r102 = false;
        goto L13
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final boolean insertLegalMessage(long r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "content");
        if (com.bytedance.android.live.core.utils.z.o(this.f157663g).f162599id == r100) goto L5;
        return false;
    L5:
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, this.f157663g, 0, 2);
        if (r101 == null) goto L15;
        h r102 = i.c(r101);
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.j<l> r103 = r102.getPublicScreenContext();
        if (r103 == null) goto L15;
        l r104 = r103.getValue();
        if (r104 == null) goto L15;
        int r105 = s.f133517k;
        r104.insertMessage(s.b.b(PublicScreenConfig$MessageModelType.COMMERCE_NOTICE, r110, null, false, true, null, 484));
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler
    public final Observable<IBaseUser> login(Context r100, com.bytedance.android.livesdk.user.l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        return ((f) TTLiveSDKContext.getHostService()).h().login(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final Observable<? extends IBaseUser> loginIn(Context r100, com.bytedance.android.livesdk.user.l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        return login(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void onPermissionChange(int r100, boolean r101) {
        if (r100 != 0) goto L4;
        p2 r102 = (p2) this.f157663g.get("data_live_mini_app_commerce_status", new p2());
        boolean r103 = !r101;
        r102.f116653b = r103;
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L11;
        r104.getUser().getValue().setEnableShowCommerceSale(r103);
    L11:
        this.f157663g.put("data_live_mini_app_commerce_status", r102);
        return;
    L4:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L7;
        return;
    L7:
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void sendLogger(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "logExtra");
        MergeDataContext r102 = this.f157660d;
        if (r102 == null) goto L15;
        Function2<String, HashMap<String, String>, Unit> r103 = r102.getPreviewMobAction();
        if (r103 != null) goto L7;
        return;
    L7:
        if ((r101 instanceof HashMap) == true) goto L9;
        Map<String, String> r104 = null;
    L10:
        HashMap<String, String> r105 = (HashMap) r104;
        if (r105 != null) goto L13;
        r105 = new HashMap(r101);
    L13:
        Unit r106 = r103.invoke(r100, r105);
        return;
    L9:
        r104 = r101;
        goto L10
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void fullDialogHoverStateChange(boolean r100, boolean r101) {
        if (r100 == false) goto L4;
        fullDialogHoverStateChange(1, r101);
        return;
    L4:
        fullDialogHoverStateChange(4, r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void sendLogger(String r100, Function1<? super PreviewReportBuilder, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "builder");
        PreviewReportBuilder r102 = new PreviewReportBuilder(this.f157663g);
        r101.invoke(r102);
        PreviewReportData r103 = r102.build();
        r103.setDataCenter(r103.getDataCenter());
        sendLogger(r100, r103.getReportMap());
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void detachWindow(Activity r100, String r101, Window r102) {
        j0.g().d(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final boolean insertLegalMessage(long r100, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "content");
        if (com.bytedance.android.live.core.utils.z.o(this.f157663g).f162599id == r100) goto L5;
        return false;
    L5:
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, this.f157663g, 0, 2);
        if (r101 == null) goto L15;
        h r102 = i.c(r101);
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.j<l> r103 = r102.getPublicScreenContext();
        if (r103 == null) goto L15;
        l r104 = r103.getValue();
        if (r104 == null) goto L15;
        int r105 = s.f133517k;
        r104.insertMessage(s.b.b(PublicScreenConfig$MessageModelType.COMMERCE_NOTICE, r110, null, false, r111, PSMessageAction.SYSTEM, 356));
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void toFullScreen(Activity r100, String r101, Window r102) {
        j0.g().i(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void toHalfScreen(Activity r100, String r101, Window r102) {
        j0.g().j(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void attachWindow(Activity r100, String r101, Window r102, Function2<? super Boolean, ? super Integer, Unit> r103) {
        j0.g().b(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler, com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final Observable<FollowPair> follow(Context r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userId");
        return ((f) TTLiveSDKContext.getHostService()).h().h(new com.bytedance.android.livesdk.user.b.C2427b().c(r101).b(r102).h(r103).d());
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void jetDanmaku(String r100, long r110, String r111, String r112) {
        this.f157663g.put("data_live_ecom_message", new k32.b(r100, r110, r111, r112));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler, com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final Observable<FollowPair> unFollow(Context r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userId");
        com.bytedance.android.livesdk.user.f r104 = ((f) TTLiveSDKContext.getHostService()).h();
        m.b r105 = (m.b) ((m.b) ((m.b) new m.b().c(r101)).b(r102)).f(r103);
        r105.getClass();
        return r104.i(new m(r105));
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void enterRoom(String r100, Bundle r101, String r110, Bundle r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r100, "businesskey");
        Intrinsics.checkNotNullParameter(r101, "businessBundle");
        Intrinsics.checkNotNullParameter(r110, "clickMethod");
        MergeDataContext r102 = this.f157660d;
        if (r102 == null) goto L8;
        Function5<String, Bundle, String, Bundle, Map<String, String>, Unit> r103 = r102.getMergeEnterAction();
        if (r103 == null) goto L9;
        Unit r104 = r103.invoke(r100, r101, r110, r111, r112);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler
    public final void onCouponMessage(int r110, long r111, String r112, int r113, long r114) {
        this.f157663g.put("DATA_COMMERCE_ECOM_MESSAGE", new com.bytedance.android.livesdk.commerce.coupon.a(r110, r111, r112, r113, r114));
    }
}
