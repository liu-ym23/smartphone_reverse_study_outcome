package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardCommentListSyncData;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardCommentListSyncDataModel;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.settings.SettingsConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getMessageBoardData")
public final class w4 extends w20.o1<w20.p9, GetMessageBoardDataResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f63699a;

    public static final class a {
    }

    static {
    }

    public w4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.p9 r112 = (w20.p9) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r100 = System.currentTimeMillis();
        List<String> r113 = r112.a();
        this.f63699a = r113;
        List<String> r114 = r113;
        boolean r101 = false;
        if (r114 != null) goto L5;
    L8:
        boolean r115 = true;
    L9:
        if (r115 == false) goto L11;
        finishWithFailure();
        return;
    L11:
        GetMessageBoardDataResultModel r116 = new GetMessageBoardDataResultModel();
        r116.c(new GetMessageBoardDataResultModel.a());
        r116.b(GetMessageBoardDataResultModel.Code.Success);
        nm1.e r102 = pm1.f.c();
        Observable<String> r103 = null;
        if (r102 == null) goto L16;
        ReplayDataContext r104 = r102.h(null);
        if (r104 == null) goto L16;
        com.bytedance.live.datacontext.j<Object> r105 = r104.getVsMsgBoardDataContext();
    L18:
        if ((r105 instanceof com.bytedance.live.datacontext.j) == true) goto L20;
        r105 = null;
    L20:
        if (r105 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.msgboard.a r106 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r105.getValue();
        if (r106 == null) goto L23;
    L28:
        com.bytedance.android.livesdk.chatroom.msgboard.a r107 = r106;
    L30:
        List<String> r108 = this.f63699a;
        if (r108 != null) goto L33;
    L36:
        boolean r109 = true;
    L37:
        if (r109 == true) goto L62;
        List<String> r117 = this.f63699a;
        if (r117 == null) goto L62;
        List<String> r118 = r117;
        if ((r118 instanceof Collection) == true) goto L43;
    L45:
        Iterator<T> r119 = r118.iterator();
    L47:
        if (r119.hasNext() == false) goto L55;
        String r120 = (String) r119.next();
        if (r120 == null) goto L54;
        if (Intrinsics.areEqual(StringsKt.trim(r120).toString(), "dressInfo") == false) goto L47;
        r101 = true;
        goto L55
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L55:
        if (r101 != true) goto L62;
        if (r107 == null) goto L58;
        Observable<List<String>> r121 = r107.getMessageBoardSelfComment();
    L59:
        if (r107 == null) goto L61;
        r103 = r107.getInteractDressInfo();
    L61:
        Observable r122 = Observable.mergeDelayError(r121, r103).doFinally(new x4(this, r116, r100, r112));
        com.bytedance.android.livesdk.chatroom.msgboard.a r123 = r107;
        r122.subscribe(new y4(this, r116, r123, r100, r112), new z4(this, r116, r123, r100, r112));
        return;
    L58:
        r121 = null;
        goto L59
    L43:
        if (r118.isEmpty() == false) goto L45;
    L62:
        if (r107 == null) goto L77;
        Observable<List<String>> r124 = r107.getMessageBoardSelfComment();
        if (r124 == null) goto L78;
        Observable<List<String>> r125 = r124.observeOn(AndroidSchedulers.mainThread());
        if (r125 == null) goto L79;
        Observable<List<String>> r126 = r125.doFinally(new a5(this, r116, r100, r112));
        if (r126 == null) goto L80;
        com.bytedance.android.livesdk.chatroom.msgboard.a r127 = r107;
        r126.subscribe(new b5(this, r116, r127, r100, r112), new c5(this, r116, r127, r100, r112));
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L33:
        if (r108.isEmpty() == true) goto L36;
        r109 = false;
    L23:
        RoomContext r128 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r128 == null) goto L29;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> r129 = r128.getVsMsgBoardDataContext();
        if (r129 == null) goto L29;
        r106 = r129.getValue();
    L29:
        r107 = null;
    L16:
        r105 = null;
        goto L18
    L5:
        if (r114.isEmpty() == true) goto L8;
        r115 = false;
        goto L9
    }

    public static final void j(w4 r100, GetMessageBoardDataResultModel r101, com.bytedance.android.livesdk.chatroom.msgboard.a r102, List r103) {
        r100.getClass();
        if (r103 == null) goto L61;
        Iterator r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L101;
        String r105 = (String) r104.next();
        String r106 = null;
        VSMsgBoardCommentListSyncData r107 = null;
        r107 = null;
        r107 = null;
        r107 = null;
        List<String> r108 = null;
        String r109 = null;
        String r110 = null;
        r110 = null;
        r106 = null;
        switch(r105.hashCode()) {
            case -1526972682: goto L53;
            case -851474765: goto L44;
            case -695505019: goto L37;
            case 182934705: goto L27;
            case 2103298973: goto L11;
            default: goto L6;
        };
    L11:
        if (r105.equals("commentList") == false) goto L6;
        GetMessageBoardDataResultModel.a r111 = r101.a();     // Catch: Exception -> L24
        if (r111 == null) goto L6;
        if (r102 == null) goto L22;
        com.bytedance.live.datacontext.j<VSMsgBoardCommentListSyncDataModel> r112 = r102.getCommentListDataSyncModel();     // Catch: Exception -> L24
        if (r112 == null) goto L22;
        VSMsgBoardCommentListSyncDataModel r113 = r112.getValue();     // Catch: Exception -> L24
        if (r113 == null) goto L22;
        dc2.c<VSMsgBoardCommentListSyncData> r114 = r113.getVsMsgBoardCommentListSyncData();     // Catch: Exception -> L24
        if (r114 == null) goto L22;
        r107 = r114.c();     // Catch: Exception -> L24
    L22:
        r111.a(JsonUtil.toJSONString(r107));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ALogger.e("GetMessageBoardDataMethod", e.getMessage());
        goto L6
    L27:
        if (r105.equals("selfCommentList") == false) goto L6;
        GetMessageBoardDataResultModel.a r115 = r101.a();     // Catch: Exception -> L34
        if (r115 == null) goto L6;
        if (r102 == null) goto L32;
        r108 = r102.getVsMsgSelfCommentData();     // Catch: Exception -> L34
    L32:
        r115.d(JsonUtil.toJSONString(r108));     // Catch: Exception -> L34
    L34:
        e = move-exception;
        ALogger.e("GetMessageBoardDataMethod", e.getMessage());
        goto L6
    L37:
        if (r105.equals("dressInfo") == false) goto L6;
        GetMessageBoardDataResultModel.a r116 = r101.a();
        if (r116 == null) goto L6;
        if (r102 == null) goto L42;
        r109 = r102.getVsMsgBoardDressInfo();
    L42:
        r116.b(r109);
        goto L6
    L44:
        if (r105.equals("likeRelation") == false) goto L6;
        GetMessageBoardDataResultModel.a r117 = r101.a();
        if (r117 == null) goto L6;
        if (r102 == null) goto L51;
        com.bytedance.live.datacontext.n<String> r118 = r102.getCommentLikeRelation();
        if (r118 == null) goto L51;
        r110 = r118.getValue();
    L51:
        r117.c(r110);
        goto L6
    L53:
        if (r105.equals("uiConfig") == false) goto L6;
        GetMessageBoardDataResultModel.a r119 = r101.a();
        if (r119 == null) goto L6;
        if (r102 == null) goto L60;
        com.bytedance.live.datacontext.j<String> r120 = r102.getExtra();
        if (r120 == null) goto L60;
        r106 = r120.getValue();
    L60:
        r119.e(r106);
        goto L6
    L101:
        return;
    }

    public static final void k(w4 r110, long r111, String r112, List r113) {
        r110.getClass();
        HashMap r114 = new HashMap();
        Map<String, String> r100 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (r100 == null) goto L5;
        r114.putAll(r100);
    L5:
        Episode r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L10;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L10;
        Room r104 = r103.getValue();
    L11:
        lm1.b r105 = pm1.f.d(null);
        if (r105 == null) goto L17;
        com.bytedance.live.datacontext.n<Episode> r106 = r105.getEpisode();
        if (r106 == null) goto L17;
        r101 = r106.getValue();
    L17:
        if (r104 == null) goto L25;
        Map<String, String> r107 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (r107 == null) goto L21;
        r114.putAll(r107);
    L21:
        Map<String, String> r108 = com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap();
        if (r108 == null) goto L24;
        r114.putAll(r108);
    L24:
        int r109 = ju2.f.M;
        r114.putAll(ju2.f.a.a(r104).b());
        r114.put(IPerformanceManager.Params.room_type, "live");
    L25:
        if (r101 == null) goto L27;
        int r115 = am2.a0.L;
        r114.putAll(am2.a0.a.a(r101).a());
        r114.putAll(new am2.b0().a());
        r114.put(IPerformanceManager.Params.room_type, "replay");
        r114.put(ShareConstants.REPLAY_ID, String.valueOf(r101.getIdExt()));
    L27:
        String r116 = "";
        if (r112 != null) goto L30;
        r112 = "";
    L30:
        r114.put(SettingsConstants.SETTINGS_UPDATE_FROM, r112);
        r114.put("request_jsb_duration", String.valueOf(System.currentTimeMillis() - r111));
        if (r113 == null) goto L36;
        String r117 = CollectionsKt.joinToString$default(r113, ",", null, null, 0, null, null, 62, null);
        if (r117 == null) goto L36;
        r116 = r117;
    L36:
        r114.put("keys", r116);
        com.bytedance.android.livesdk.log.u.l().h("live_vs_get_message_board_data", r114, new Object[0]);
        return;
    L10:
        r104 = null;
        goto L11
    }
}
