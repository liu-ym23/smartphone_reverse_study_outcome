package com.bytedance.android.livesdk.feedback.light;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.v4;
import com.bytedance.android.livesdk.feedback.light.context.FeedbackPublicScreenContext;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/light/LiveLightFeedbackWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LiveLightFeedbackWidget extends RoomRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f124707f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.feedback.light.context.a f124708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HybridCard f124709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f124710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f124711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f124712e;

    public static final class a {
    }

    public static final class b<T> implements h80.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLightFeedbackWidget f124713a;

        public b(LiveLightFeedbackWidget r100) {
            this.f124713a = r100;
        }

        @Override // h80.a
        public final void accept(Object r100) {
            Room r101 = (Room) r100;
            com.bytedance.android.livesdk.feedback.light.context.a r102 = this.f124713a.f124708a;
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

    public abstract void Cq(HybridCard r100);

    public void onChanged(KVData r100) {
    }

    public void xq(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
    }

    public void yq(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
    }

    public abstract FeedbackPublicScreenContext zq();

    public final void Bq() {
        if (this.f124709b != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.feedback.light.context.a r100 = this.f124708a;
        if (r100 == null) goto L95;
        n<? extends FeedItem> r101 = r100.getShowRoomFeedback();
        if (r101 == null) goto L96;
        FeedItem r102 = r101.getValue();
        if (r102 == null) goto L97;
        Room r103 = r102.getRoom();
        if (r103 == null) goto L98;
        FeedbackCard r104 = r103.mFeedbackCard;
        if (r104 == null) goto L100;
        long r105 = this.f124712e;
        long r106 = System.currentTimeMillis();
        if (1 <= r105) goto L20;
        return;
    L20:
        if (r106 <= r105) goto L99;
        LinkedHashMap r107 = new LinkedHashMap();
        o r108 = u.l().c(x.class);
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
        this.f124712e = -1;
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
        com.bytedance.android.livesdk.feedback.light.context.a r100 = this.f124708a;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.i<ix1.a> r101 = r100.getFeedbackConfigService();
        if (r101 == null) goto L9;
        ix1.a r102 = r101.getValue();
        if (r102 == null) goto L9;
        r102.c();
    L9:
        this.f124710c.clear();
        ViewGroup r103 = this.f124711d;
        if (r103 == null) goto L12;
        r103.removeAllViews();
        r103.setVisibility(8);
    L12:
        Bq();
        HybridCard r104 = this.f124709b;
        if (r104 == null) goto L15;
        r104.release();
    L15:
        this.f124709b = null;
        this.f124712e = -1;
        com.bytedance.android.livesdk.feedback.light.context.a r105 = this.f124708a;
        if (r105 == null) goto L18;
        r105.updateFeedbackCardShowingStatus(false);
        r105.getFeedbackConfigService().getValue().f();
    L18:
        this.f124711d = null;
    }

    public LiveLightFeedbackWidget() {
        this.f124710c = new CompositeDisposable();
        this.f124712e = -1;
    }

    public final void Aq(FeedItem r110) {
        int r100 = FeedbackMonitor.f124865a;
        FeedbackMonitor.Monitor r101 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r101.f124866a = "LiveLightFeedbackWidget";
        r101.c("initLynxAndShowFeedback");
        Pair[] r102 = new Pair[2];
        DataCenter r103 = this.dataCenter;
        HybridCard r104 = null;
        if (r103 == null) goto L7;
        Room r105 = z.o(r103);
        if (r105 == null) goto L7;
        String r106 = r105.getIdStr();
    L8:
        r102[0] = TuplesKt.to("roomId", r106);
        Room r107 = r110.getRoom();
        if (r107 == null) goto L11;
        Long r108 = Long.valueOf(r107.f162599id);
    L12:
        r102[1] = TuplesKt.to("feedbackCard roomId", r108);
        r101.b(r102);
        r101.d();
        if (r110.getRoom().f162599id != z.o(this.dataCenter).f162599id) goto L15;
        boolean r109 = true;
    L16:
        if (r109 == true) goto L19;
        r110 = null;
    L19:
        if (r110 == null) goto L109;
        FeedbackMonitor.Monitor r111 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r111.f124866a = "LiveLightFeedbackWidget";
        r111.c("initLynxContainer");
        Pair[] r112 = new Pair[1];
        DataCenter r113 = this.dataCenter;
        if (r113 == null) goto L25;
        Room r114 = z.o(r113);
        if (r114 == null) goto L25;
        String r115 = r114.getIdStr();
    L26:
        r112[0] = TuplesKt.to("roomId", r115);
        r111.b(r112);
        r111.d();
        com.bytedance.android.livesdk.feedback.light.context.a r116 = this.f124708a;
        if (r116 == null) goto L31;
        String r117 = r116.getLynxUrl();
        if (r117 == null) goto L31;
        String r118 = Eq(r117);
    L32:
        com.bytedance.android.livesdk.feedback.light.context.a r119 = this.f124708a;
        if (r119 == null) goto L37;
        String r120 = r119.getWebUrl();
        if (r120 == null) goto L37;
        String r121 = Eq(r120);
    L38:
        Uri r122 = com.bytedance.android.livesdk.feedback.b.a(r118, r121);
        if (r122 == null) goto L107;
        HybridCard r123 = ((IBrowserService) jc1.k.n(IBrowserService.class)).getHybridCard(this.context, r122, -1, new k(this));
        if (r123 == null) goto L107;
        r123.setJSBridgeListener(new j(this));
        o r124 = u.l().c(x.class);
        if ((r124 instanceof n0) == true) goto L45;
        r124 = null;
    L45:
        n0 r125 = (n0) r124;
        HashMap r126 = new HashMap();
        com.bytedance.android.livesdk.feedback.light.context.a r127 = this.f124708a;
        if (r127 == null) goto L54;
        n<? extends FeedItem> r128 = r127.getShowRoomFeedback();
        if (r128 == null) goto L54;
        FeedItem r129 = r128.getValue();
        if (r129 == null) goto L54;
        Room r130 = r129.getRoom();
        if (r130 == null) goto L54;
        FeedbackCard r131 = r130.mFeedbackCard;
    L55:
        String r132 = "";
        if (r131 == null) goto L59;
        String r133 = GsonProtectorUtils.toJson(GsonHelper.get(), r131);
        if (r133 == null) goto L59;
    L60:
        r126.put("feedbackData", r133);
        r126.put("room_id", String.valueOf(z.o(this.dataCenter).f162599id));
        if (r125 == null) goto L66;
        Map<String, String> r134 = r125.f153291b;
        if (r134 == null) goto L66;
        String r135 = r134.get("enter_from_merge");
        if (r135 == null) goto L66;
    L67:
        r126.put("enter_from_merge", r135);
        if (r125 == null) goto L73;
        Map<String, String> r136 = r125.f153291b;
        if (r136 == null) goto L73;
        String r137 = r136.get("enter_method");
        if (r137 == null) goto L73;
    L74:
        r126.put("enter_method", r137);
        if (r125 == null) goto L80;
        Map<String, String> r138 = r125.f153291b;
        if (r138 == null) goto L80;
        String r139 = r138.get("action_type");
        if (r139 == null) goto L80;
    L81:
        r126.put("action_type", r139);
        String r140 = z.o(this.dataCenter).getRequestId();
        if (r140 != null) goto L84;
        r140 = "";
    L84:
        r126.put("request_id", r140);
        User r141 = z.o(this.dataCenter).mo8271getOwner();
        if (r141 == null) goto L87;
        String r142 = r141.getIdStr();
    L88:
        r126.put("anchor_id", String.valueOf(r142));
        r126.put("flow_type", "room");
        if (r131 == null) goto L92;
        String r143 = r131.getLogInfo();
        if (r143 == null) goto L92;
    L93:
        r126.put("question_text", r143);
        r126.put("question_type", "single");
        if (r131 == null) goto L99;
        Integer r144 = r131.getIndex();
        if (r144 == null) goto L99;
        String r145 = String.valueOf(r144.intValue());
        if (r145 == null) goto L99;
    L100:
        r126.put(ILiveRoomPlayFragmentConstant.ORDER_CENTER_DRAW_INDEX, r145);
        ILiveFeedbackService r146 = (ILiveFeedbackService) jc1.k.f(ILiveFeedbackService.class);
        if (r146 == null) goto L106;
        String r147 = r146.getRecentRoomIds();
        if (r147 == null) goto L106;
        r132 = r147;
    L106:
        r126.put("recent_room_ids", r132);
        r126.put("pk_id", Long.valueOf(((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiDataHolderExternal().getPkId()));
        yq(r126);
        r123.load(null, r126);
        Unit r148 = Unit.INSTANCE;
        r104 = r123;
    L99:
        r145 = "0";
    L92:
        r143 = "";
        goto L93
    L87:
        r142 = null;
    L80:
        r139 = "";
    L73:
        r137 = "";
    L66:
        r135 = "";
    L59:
        r133 = "";
    L54:
        r131 = null;
    L107:
        this.f124709b = r104;
        return;
    L37:
        r121 = null;
    L31:
        r118 = null;
    L25:
        r115 = null;
        goto L26
    L109:
        return;
    L15:
        r109 = false;
        goto L16
    L11:
        r108 = null;
    L7:
        r106 = null;
        goto L8
    }

    public final String Eq(String r100) {
        Uri.Builder r101 = UriProtector.parse(r100).buildUpon();     // Catch: Exception -> L4
        Context r102 = this.context;     // Catch: Exception -> L4
        int r103 = com.bytedance.android.livesdk.feedback.utils.a.f124868a;     // Catch: Exception -> L4
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Exception -> L4
        return r101.appendQueryParameter("fullscreen", String.valueOf(true)).toString();
    L4:
        e = move-exception;
        ALogger.e("LiveLightFeedbackWidget", "url append params faild.", e);
        return null;
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
        this.f124711d = (ViewGroup) r101;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r100) {
        this.f124712e = -1;
        ViewGroup r101 = this.f124711d;
        if (r101 == null) goto L5;
        r101.removeAllViews();
        r101.setVisibility(8);
    L5:
        FeedbackPublicScreenContext r102 = zq();
        this.f124708a = r102;
        if (r102 == null) goto L8;
        r102.initFeedbackConfig(this.dataCenter);
    L8:
        com.bytedance.android.livesdk.feedback.light.context.a r103 = this.f124708a;
        if (r103 == null) goto L17;
        n<? extends FeedItem> r104 = r103.getShowRoomFeedback();
        FeedItem r105 = r104.getValue();
        if (r105 == null) goto L13;
        Aq(r105);
    L13:
        RxUtilKt.c(r104.a().subscribe(new com.bytedance.android.livesdk.feedback.light.a(this), h.f124729a), this.f124710c);
        RxUtilKt.c(r103.getOnJsCloseEvent().subscribe(new com.bytedance.android.livesdk.feedback.light.b(this)), this.f124710c);
        if (v4.f121418a.getValue().a() == false) goto L16;
        RxUtilKt.c(r103.getOnJsCloseClickEvent().subscribe(new c(this)), this.f124710c);
    L16:
        RxUtilKt.c(r103.getOnJsAutoCloseEvent().a().subscribe(new d(this)), this.f124710c);
        RxUtilKt.c(r103.getOnShowStartEvent().subscribe(new e(r103, this), i.f124734a), this.f124710c);
        RxUtilKt.c(r103.getOnHideEndEvent().subscribe(new f(this), g.f124728a), this.f124710c);
    L17:
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L20;
        r106.observe("DATA_IS_HIDE_INTERACTION", this);
    L20:
        runWithRoomEntered(new b(this));
    }

    public static final void wq(LiveLightFeedbackWidget r100, FeedbackCard.FeedbackStatus r101) {
        com.bytedance.android.livesdk.feedback.light.context.a r102 = r100.f124708a;
        if (r102 == null) goto L14;
        n<? extends FeedItem> r103 = r102.getShowRoomFeedback();
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
