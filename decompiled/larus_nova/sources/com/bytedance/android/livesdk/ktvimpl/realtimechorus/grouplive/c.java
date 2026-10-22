package com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive;

import am2.x;
import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.mz;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Long> f146588c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f146589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f146590b;

    public static final class a {
    }

    public static final class b implements IMiddlewareHostSocial.ICommonInviteParams.IClickCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f146591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f146592b;

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial.ICommonInviteParams.IClickCallback
        public final void onInvite(List<IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact> r100) {
            ALogger.i("GroupLiveGameInviteUtils", "onInvite: " + r100);
            c r101 = this.f146591a;
            Context r102 = this.f146592b;
            r101.getClass();
            o r103 = m.i();
            if (r103 == null) goto L9;
            com.bytedance.live.datacontext.m<IRoom> r104 = r103.getRoom();
            if (r104 == null) goto L9;
            IRoom r105 = r104.getValue();
            if (r105 == null) goto L9;
            long r106 = r105.getRoomId();
        L10:
            if (r100 == null) goto L16;
            List<IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact> r107 = r100;
            ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
            Iterator<T> r109 = r107.iterator();
        L13:
            if (r109.hasNext() == false) goto L15;
            r108.add(((IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact) r109.next()).getUid());
            goto L13
        L15:
            String r110 = r108.toString();
        L17:
            ALogger.i("GroupLiveGameInviteUtils", "inviteFriends, roomId: " + r106 + ", toUserIds: " + r110);
            if (r110 == null) goto L24;
            if (r100 != null) goto L21;
        L23:
            RxUtilKt.i(((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).groupLiveChorusInviteFriend(r106, r110)).subscribe(d.f146593a, new e(r102));
            return;
        L21:
            if (r100.isEmpty() != true) goto L23;
        L24:
            ALogger.e("GroupLiveGameInviteUtils", "inviteFriends return, cause: toUserIds is null");
            return;
        L16:
            r110 = null;
        L9:
            r106 = 0;
            goto L10
        }

        public b(c r100, Context r101) {
            this.f146591a = r100;
            this.f146592b = r101;
        }
    }

    static {
        f146588c = new LinkedHashMap();
    }

    public c() {
        this.f146589a = mz.f120793a.getValue().getInviteInterceptIntervalInMills();
    }

    public final void a(Context r110, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((System.currentTimeMillis() - this.f146590b) >= 1000) goto L5;
        return;
    L5:
        this.f146590b = System.currentTimeMillis();
        com.bytedance.live.datacontext.m<IRoom> r100 = m.i().getRoom();
        if (r100 == null) goto L15;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L15;
        if (r101.getVisibilityRange() != 16) goto L15;
        if (je0.d.D() == true) goto L15;
        f2.c("仅支持房主邀请好友", 0);
        return;
    L15:
        IMiddlewareHostSocial r102 = (IMiddlewareHostSocial) k.n(IMiddlewareHostSocial.class);
        IMiddlewareHostSocial.ICommonInviteParams r103 = new IMiddlewareHostSocial.ICommonInviteParams();
        com.bytedance.live.datacontext.m<IRoom> r104 = m.i().getRoom();
        String r105 = "";
        if (r104 == null) goto L23;
        IRoom r106 = r104.getValue();
        if (r106 == null) goto L23;
        IAnchorData r107 = r106.getAnchorData();
        if (r107 == null) goto L23;
        String r108 = r107.getConversationId();
        if (r108 == null) goto L23;
    L24:
        com.bytedance.live.datacontext.m<IRoom> r109 = m.i().getRoom();
        if (r109 == null) goto L29;
        IRoom r111 = r109.getValue();
        if (r111 == null) goto L29;
        Integer r112 = Integer.valueOf(r111.getVisibilityRange());
    L31:
        if (r112 != null) goto L34;
    L36:
        if (r112 != null) goto L39;
    L41:
        String r113 = "";
    L42:
        r103.setContext(r110);
        r103.setInitHeight(Integer.valueOf((int) (((double) UIUtils.getScreenHeight(jc1.a.b())) * 0.8d)));
        r103.setScene(r113);
        r103.setSelectType(IMiddlewareHostSocial.ICommonInviteParams.ISelectTypeEnum.MULTI_SELECT_RIGHT);
        r103.setBottomBtnText("邀请合唱");
        HashMap r114 = new HashMap();
        r114.put("conversation_id", r108);
        Unit r115 = Unit.INSTANCE;
        r103.setExtMap(r114);
        HashMap r116 = new HashMap();
        com.bytedance.live.datacontext.m<IRoom> r117 = m.i().getRoom();
        if (r117 == null) goto L47;
        IRoom r118 = r117.getValue();
        if (r118 == null) goto L47;
        Integer r119 = Integer.valueOf(r118.getVisibilityRange());
    L48:
        if (r119 != null) goto L51;
    L53:
        if (r119 != null) goto L56;
    L58:
        r116.put("chat_type", r105);
        r116.put("conversation_id", r108);
        r116.put("live_type", ((IInteractService) k.n(IInteractService.class)).getLiveTypeForLog());
        r116.put("function_type2", ((IInteractService) k.n(IInteractService.class)).getFunctionTypeForLog());
        r116.put("anchor_id", je0.d.a());
        r116.put("room_id", String.valueOf(je0.d.a0()));
        r116.put("enter_from", "co_sing");
        r116.put("enter_method", "click_co_sing");
        r103.setMobMap(r116);
        long r120 = System.currentTimeMillis();
        ArrayList r121 = new ArrayList();
        Iterable r122 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList();
        String r123 = "GroupLiveGameInviteUtils";
        if (r122 == null) goto L73;
        Iterable r124 = r122;
        ArrayList r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10));
        Iterator r126 = r124.iterator();
    L62:
        if (r126.hasNext() == false) goto L72;
        ILinkPlayerInfoBridge r127 = (ILinkPlayerInfoBridge) r126.next();
        IBaseUser r128 = r127.getUser();
        if (r128 == null) goto L66;
        String r129 = r128.getUserId();
    L67:
        IBaseUser r130 = r127.getUser();
        if (r130 == null) goto L70;
        Intrinsics.checkNotNullParameter(r130, "$this$secUidExt");
        String r131 = r130.getCastSecUid();
    L71:
        r125.add(new IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact(r129, r131));
        goto L62
    L70:
        r131 = null;
        goto L71
    L66:
        r129 = null;
        goto L67
    L72:
        ALogger.i("GroupLiveGameInviteUtils", "getDisableInviteUserList, onlineUserList: " + r125);
        r121.addAll(r125);
    L73:
        Map<String, Long> r132 = f146588c;
        if (r132 == null) goto L90;
        LinkedHashMap r133 = new LinkedHashMap();
        Iterator r134 = ((LinkedHashMap) r132).entrySet().iterator();
    L77:
        if (r134.hasNext() == false) goto L85;
        Map.Entry r135 = (Map.Entry) r134.next();
        String r136 = r123;
        if ((r120 - ((Number) r135.getValue()).longValue()) >= this.f146589a) goto L81;
        boolean r137 = true;
    L82:
        if (r137 == false) goto L84;
        r133.put(r135.getKey(), r135.getValue());
    L84:
        r123 = r136;
        goto L77
    L81:
        r137 = false;
        goto L82
    L85:
        String r138 = r123;
        ArrayList r139 = new ArrayList(r133.size());
        Iterator r140 = r133.entrySet().iterator();
    L87:
        if (r140.hasNext() == false) goto L89;
        r139.add(new IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact((String) ((Map.Entry) r140.next()).getKey(), null));
        goto L87
    L89:
        String r141 = r138;
        ALogger.i(r141, "getDisableInviteUserList, inviteSuccessUserList: " + r139);
        r121.addAll(r139);
    L91:
        r103.setDisableUserList(r121);
        r103.setClickCallback(new b(this, r110));
        ALogger.i(r141, "showInvitePage，roomVisibilityRange: " + r112 + ", params: " + r103.getMobMap());
        Unit r142 = Unit.INSTANCE;
        r102.showNewInviteFriendActivity(r103);
        if (r210 == true) goto L106;
        j0 r143 = j0.l();
        HashMap r144 = new HashMap();
        if (gh0.a.d() == false) goto L96;
        String r145 = "anchor";
    L97:
        r144.put("user_type", r145);
        r143.sendLog("livesdk_chorus_end_panel_invite_click", r144, new Object[]{IRoom.class, x.class});
        return;
    L96:
        r145 = "guest";
        goto L97
    L106:
        return;
    L90:
        r141 = "GroupLiveGameInviteUtils";
        goto L91
    L56:
        if (17 != r119.intValue()) goto L58;
        r105 = "group";
        goto L58
    L51:
        if (16 != r119.intValue()) goto L53;
        r105 = BridgePrivilege.PRIVATE;
    L47:
        r119 = null;
        goto L48
    L39:
        if (17 != r112.intValue()) goto L41;
        r113 = IMiddlewareHostSocial.ICommonInviteParams.IChatSceneTypeEnum.GROUP_PLAY_GAME_INVITE.getValue();
        goto L42
    L34:
        if (16 != r112.intValue()) goto L36;
        r113 = IMiddlewareHostSocial.ICommonInviteParams.IChatSceneTypeEnum.SINGLE_PLAY_GAME_INVITE.getValue();
    L29:
        r112 = null;
    L23:
        r108 = "";
        goto L24
    }
}
