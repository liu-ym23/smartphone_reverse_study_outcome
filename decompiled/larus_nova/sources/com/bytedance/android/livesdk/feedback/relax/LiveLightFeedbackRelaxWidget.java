package com.bytedance.android.livesdk.feedback.relax;

import am2.x;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.v4;
import com.bytedance.android.livesdk.feedback.light.context.FeedbackPublicScreenContext;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.relax.relaxframework.RelaxPage;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/relax/LiveLightFeedbackRelaxWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LiveLightFeedbackRelaxWidget extends RoomRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f124756f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.feedback.light.context.a f124757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d03.b<p> f124758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f124759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f124760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f124761e;

    public static final class a {
    }

    public static final class b<T> implements h80.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLightFeedbackRelaxWidget f124762a;

        public b(LiveLightFeedbackRelaxWidget r100) {
            this.f124762a = r100;
        }

        @Override // h80.a
        public final void accept(Object r100) {
            Room r101 = (Room) r100;
            com.bytedance.android.livesdk.feedback.light.context.a r102 = this.f124762a.f124757a;
            if (r102 == null) goto L10;
            com.bytedance.live.datacontext.i<ix1.a> r103 = r102.getFeedbackConfigService();
            if (r103 == null) goto L11;
            ix1.a r104 = r103.getValue();
            if (r104 == null) goto L12;
            r104.d();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
    }

    public void onChanged(KVData r100) {
    }

    public void xq(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
    }

    public abstract FeedbackPublicScreenContext yq();

    public void Aq() {
        int r100 = FeedbackMonitor.f124865a;
        FeedbackMonitor.Monitor r101 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackRelaxWidget", "page");
        r101.f124866a = "LiveLightFeedbackRelaxWidget";
        r101.c("initRelaxContainer");
        Pair[] r102 = new Pair[1];
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L7;
        Room r104 = z.o(r103);
        if (r104 == null) goto L7;
        String r105 = r104.getIdStr();
    L8:
        r102[0] = TuplesKt.to("roomId", r105);
        r101.b(r102);
        r101.d();
        return;
    L7:
        r105 = null;
        goto L8
    }

    public final void Bq() {
        if (this.f124758b != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.feedback.light.context.a r100 = this.f124757a;
        if (r100 == null) goto L95;
        com.bytedance.live.datacontext.n<? extends FeedItem> r101 = r100.getShowRoomFeedback();
        if (r101 == null) goto L96;
        FeedItem r102 = r101.getValue();
        if (r102 == null) goto L97;
        Room r103 = r102.getRoom();
        if (r103 == null) goto L98;
        FeedbackCard r104 = r103.mFeedbackCard;
        if (r104 == null) goto L100;
        long r105 = this.f124761e;
        long r106 = System.currentTimeMillis();
        if (1 <= r105) goto L20;
        return;
    L20:
        if (r106 <= r105) goto L99;
        LinkedHashMap r107 = new LinkedHashMap();
        com.bytedance.android.livesdk.log.filter.o r108 = u.l().c(x.class);
        if ((r108 instanceof n0) == true) goto L24;
        r108 = null;
    L24:
        n0 r109 = (n0) r108;
        String r110 = "";
        if (r109 == null) goto L30;
        Map<String, String> r111 = r109.f153291b;
        if (r111 == null) goto L30;
        String r112 = r111.get("enter_from_merge");
        if (r112 == null) goto L30;
    L31:
        r107.put("enter_from_merge", r112);
        if (r109 == null) goto L37;
        Map<String, String> r113 = r109.f153291b;
        if (r113 == null) goto L37;
        String r114 = r113.get("enter_method");
        if (r114 == null) goto L37;
    L38:
        r107.put("enter_method", r114);
        if (r109 == null) goto L44;
        Map<String, String> r115 = r109.f153291b;
        if (r115 == null) goto L44;
        String r116 = r115.get("action_type");
        if (r116 == null) goto L44;
    L45:
        r107.put("action_type", r116);
        Room r117 = z.o(this.dataCenter);
        if (r117 == null) goto L49;
        String r118 = r117.getIdStr();
        if (r118 == null) goto L49;
    L50:
        r107.put("room_id", r118);
        Room r119 = z.o(this.dataCenter);
        if (r119 == null) goto L56;
        User r120 = r119.mo8271getOwner();
        if (r120 == null) goto L56;
        String r121 = r120.getIdString();
        if (r121 == null) goto L56;
    L57:
        r107.put("anchor_id", r121);
        DataCenter r122 = this.dataCenter;
        if (r122 == null) goto L63;
        Room r123 = z.o(r122);
        if (r123 == null) goto L63;
        String r124 = r123.getRequestId();
        if (r124 == null) goto L63;
    L64:
        r107.put("request_id", r124);
        Long r125 = r104.feedbackId;
        if (r125 == null) goto L68;
        String r126 = String.valueOf(r125.longValue());
        if (r126 == null) goto L68;
    L69:
        r107.put("feedback_id", r126);
        r107.put("duration", String.valueOf(r106 - r105));
        Integer r127 = r104.getIndex();
        if (r127 == null) goto L73;
        String r128 = String.valueOf(r127.intValue());
        if (r128 == null) goto L73;
    L74:
        r107.put(ILiveRoomPlayFragmentConstant.ORDER_CENTER_DRAW_INDEX, r128);
        r107.put("flow_type", "room");
        String r129 = r104.getLogInfo();
        if (r129 != null) goto L77;
        r129 = "";
    L77:
        r107.put("question_text", r129);
        Integer r130 = r104.feedbackType;
        if (r130 != null) goto L81;
    L83:
        if (r130 != null) goto L86;
    L88:
        String r131 = "";
    L89:
        r107.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r131);
        r107.put("question_type", "single");
        String r132 = String.valueOf(((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiDataHolderExternal().getPkId());
        if (r132 == null) goto L93;
        r110 = r132;
    L93:
        r107.put("pk_id", r110);
        xq(r107);
        u.l().sendLog("livesdk_live_feedback_card_duration", r107, new Object[0]);
        this.f124761e = -1;
        return;
    L86:
        if (r130.intValue() != 6) goto L88;
        r131 = "live_banner_horizontal";
        goto L89
    L81:
        if (r130.intValue() != 5) goto L83;
        r131 = "bottom_bar";
    L73:
        r128 = "0";
    L68:
        r126 = "";
    L63:
        r124 = "";
    L56:
        r121 = "";
    L49:
        r118 = "";
    L44:
        r116 = "";
    L37:
        r114 = "";
    L30:
        r112 = "";
        goto L31
    L99:
        return;
    L100:
        return;
    L98:
        return;
    L97:
        return;
    L96:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        com.bytedance.android.livesdk.feedback.light.context.a r100 = this.f124757a;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.i<ix1.a> r101 = r100.getFeedbackConfigService();
        if (r101 == null) goto L9;
        ix1.a r102 = r101.getValue();
        if (r102 == null) goto L9;
        r102.c();
    L9:
        this.f124759c.clear();
        ViewGroup r103 = this.f124760d;
        if (r103 == null) goto L12;
        r103.removeAllViews();
        r103.setVisibility(8);
    L12:
        Bq();
        d03.b<p> r104 = this.f124758b;
        if (r104 == null) goto L18;
        RelaxPage r105 = r104.f466186a;
        if (r105 == null) goto L17;
        r105.a();
    L17:
        r104.f466187b = null;
        Logger.d("relax container", MapMonitorConst.EVENT_DESTROY);
    L18:
        this.f124758b = null;
        this.f124761e = -1;
        com.bytedance.android.livesdk.feedback.light.context.a r106 = this.f124757a;
        if (r106 == null) goto L21;
        r106.updateFeedbackCardShowingStatus(false);
        r106.getFeedbackConfigService().getValue().f();
    L21:
        this.f124760d = null;
    }

    public LiveLightFeedbackRelaxWidget() {
        this.f124759c = new CompositeDisposable();
        this.f124761e = -1;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r100) {
        onChanged((KVData) r100);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        View r101 = this.contentView;
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        this.f124760d = (ViewGroup) r101;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r100) {
        this.f124761e = -1;
        ViewGroup r101 = this.f124760d;
        if (r101 == null) goto L5;
        r101.removeAllViews();
        r101.setVisibility(8);
    L5:
        FeedbackPublicScreenContext r102 = yq();
        this.f124757a = r102;
        if (r102 == null) goto L8;
        r102.initFeedbackConfig(this.dataCenter);
    L8:
        com.bytedance.android.livesdk.feedback.light.context.a r103 = this.f124757a;
        if (r103 == null) goto L17;
        com.bytedance.live.datacontext.n<? extends FeedItem> r104 = r103.getShowRoomFeedback();
        FeedItem r105 = r104.getValue();
        if (r105 == null) goto L13;
        zq(r105);
    L13:
        RxUtilKt.c(r104.a().subscribe(new com.bytedance.android.livesdk.feedback.relax.b(this), i.f124801a), this.f124759c);
        RxUtilKt.c(r103.getOnJsCloseEvent().subscribe(new c(this)), this.f124759c);
        if (v4.f121418a.getValue().a() == false) goto L16;
        RxUtilKt.c(r103.getOnJsCloseClickEvent().subscribe(new d(this)), this.f124759c);
    L16:
        RxUtilKt.c(r103.getOnJsAutoCloseEvent().a().subscribe(new e(this)), this.f124759c);
        RxUtilKt.c(r103.getOnShowStartEvent().subscribe(new f(r103, this), j.f124802a), this.f124759c);
        RxUtilKt.c(r103.getOnHideEndEvent().subscribe(new g(this), h.f124800a), this.f124759c);
    L17:
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L20;
        r106.observe("DATA_IS_HIDE_INTERACTION", this);
    L20:
        runWithRoomEntered(new b(this));
    }

    public final void zq(FeedItem r100) {
        int r101 = FeedbackMonitor.f124865a;
        FeedbackMonitor.Monitor r102 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackRelaxWidget", "page");
        r102.f124866a = "LiveLightFeedbackRelaxWidget";
        r102.c("initRelaxAndShowFeedback");
        Pair[] r103 = new Pair[2];
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L7;
        Room r105 = z.o(r104);
        if (r105 == null) goto L7;
        String r106 = r105.getIdStr();
    L8:
        boolean r107 = false;
        r103[0] = TuplesKt.to("roomId", r106);
        Room r108 = r100.getRoom();
        if (r108 == null) goto L11;
        Long r109 = Long.valueOf(r108.f162599id);
    L12:
        r103[1] = TuplesKt.to("feedbackCard roomId", r109);
        r102.b(r103);
        r102.d();
        if (r100.getRoom().f162599id != z.o(this.dataCenter).f162599id) goto L15;
        r107 = true;
    L15:
        if (r107 == true) goto L18;
        r100 = null;
    L18:
        if (r100 == null) goto L21;
        Aq();
        return;
    L21:
        return;
    L11:
        r109 = null;
    L7:
        r106 = null;
        goto L8
    }

    public static final void wq(LiveLightFeedbackRelaxWidget r100, FeedbackCard.FeedbackStatus r101) {
        com.bytedance.android.livesdk.feedback.light.context.a r102 = r100.f124757a;
        if (r102 == null) goto L14;
        com.bytedance.live.datacontext.n<? extends FeedItem> r103 = r102.getShowRoomFeedback();
        if (r103 == null) goto L15;
        FeedItem r104 = r103.getValue();
        if (r104 == null) goto L16;
        Room r105 = r104.getRoom();
        if (r105 == null) goto L17;
        FeedbackCard r106 = r105.mFeedbackCard;
        if (r106 == null) goto L18;
        r106.updateFeedbackStatus(r101);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
