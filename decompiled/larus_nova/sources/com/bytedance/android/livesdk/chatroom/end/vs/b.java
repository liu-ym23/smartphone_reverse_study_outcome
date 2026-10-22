package com.bytedance.android.livesdk.chatroom.end.vs;

import am2.x;
import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import fq1.d;
import fq1.p;
import j40.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends g<wg1.a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f106190a;

    public b(a r100) {
        this.f106190a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(wg1.a r110, CallContext r111) {
        wg1.a r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r111, "p1");
        StringBuilder r101 = new StringBuilder("vsOpenLiveRoom-");
        IRoom r102 = r100.recommendRoom;
        String r103 = "null";
        if (r102 == null) goto L5;
        Object r104 = Long.valueOf(r102.getId());
    L6:
        r101.append(r104);
        r101.append('-');
        IRoom r105 = r100.recommendRoom;
        if (r105 == null) goto L9;
        String r106 = r105.getIdStr();
    L10:
        r101.append(r106);
        ALogger.i("EndPageHybridHelper", r101.toString());
        IRoom r107 = r100.recommendRoom;     // Catch: Exception -> L26
        r107.setId(CastLongProtector.parseLong(r107.getIdStr()));     // Catch: Exception -> L26
        IRoom r108 = r100.endRoom;     // Catch: Exception -> L26
        r108.setId(CastLongProtector.parseLong(r108.getIdStr()));     // Catch: Exception -> L26
        Episode r109 = r100.episode;     // Catch: Exception -> L26
        if (r109 == null) goto L27;
        String r112 = r109.idStr;     // Catch: Exception -> L26
        if (r112 == null) goto L27;
        if (r112.length() <= 0) goto L18;
        boolean r113 = true;
    L19:
        if (r113 != true) goto L27;
        Episode r114 = r100.episode;     // Catch: Exception -> L26
        r114.setId(CastLongProtector.parseLong(r114.idStr));     // Catch: Exception -> L26
        String r115 = r100.episode.idStr;     // Catch: Exception -> L26
        if (r115 == null) goto L24;
        r103 = r115;
    L24:
        ALogger.i("EndPageHybridHelper", "vsOpenEpisode-".concat(r103));     // Catch: Exception -> L26
        goto L27
    L18:
        r113 = false;
    L27:
        Function0<Boolean> r116 = this.f106190a.f106188d;
        if (r116 != null) goto L30;
    L32:
        a r117 = this.f106190a;
        Episode r118 = r100.episode;
        IRoom r119 = r100.recommendRoom;
        IRoom r120 = r100.endRoom;
        boolean r121 = r100.isRoomInList;
        r117.getClass();
        if (r119 != null) goto L36;
        return null;
    L36:
        if (r118 == null) goto L45;
        String r122 = r118.idStr;
        if (r122 == null) goto L45;
        if (r122.length() <= 0) goto L42;
        boolean r123 = true;
    L43:
        if (r123 != true) goto L45;
        f2.c("该节目暂时无法播放", 0);
        ALogger.e("EndPageHybridHelper", "go to vs video room");
    L92:
        p.a().d("live_end");
        DataCenter r124 = r117.f106185a;
        if (r124 == null) goto L103;
        Object r125 = r124.get("is_embedded_live_room");
        if (r125 != null) goto L98;
        r125 = Boolean.FALSE;
    L98:
        if (((Boolean) r125).booleanValue() != true) goto L104;
        r.f().o();
        return null;
    L104:
        return null;
    L103:
        return null;
    L42:
        r123 = false;
    L45:
        Bundle r126 = new Bundle();
        r126.putString("enter_from", "live_end");
        r126.putString("log_pb", r119.getLog_pb());
        r126.putString("request_id", r119.getRequestId());
        r126.putString("enter_from_merge", "live_end");
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LOG_PB, r119.getLog_pb());
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_REQUEST_ID, r119.getRequestId());
        r126.putString("enter_method", "live_cover");
        r.d().a(r126, r117.f106185a);
        String r127 = a.a("enter_from_merge", j0.l().c(x.class));
        String r128 = a.a("enter_method", j0.l().c(x.class));
        Bundle r129 = p.a().g(r117.f106186b);
        String r130 = "";
        if (Intrinsics.areEqual(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, r127) == false) goto L59;
        if (Intrinsics.areEqual("live_cell", r128) == false) goto L55;
        Integer r131 = c.f497175a.getValue();
        if (r131 == null) goto L55;
        if (r131.intValue() != 1) goto L55;
    L56:
        if (r129 == null) goto L59;
        r126.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_CURRENT_ROOM_IS_DRAW, r129.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_PRE_ROOM_IS_DRAW, false));
        r126.putInt(ILiveRoomPlayFragmentConstant.EXTRA_CURRENT_ROOM_DRAW_TYPE, r129.getInt(ILiveRoomPlayFragmentConstant.EXTRA_PRE_ROOM_DRAW_TYPE, -1));
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_CURRENT_ROOM_INNER_URL, r129.getString(ILiveRoomPlayFragmentConstant.EXTRA_PRE_ROOM_INNER_URL, ""));
    L55:
        if (Intrinsics.areEqual("video_head", r128) == true) goto L56;
    L59:
        if (Intrinsics.areEqual("live_merge", r127) == false) goto L62;
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_FIRST_REQUEST_PAGE, "live_merge");
    L72:
        if (r121 == false) goto L90;
        if (r120 == null) goto L90;
        String r132 = r120.getIdStr().toString();
        String r133 = r120.getAnchorId();
        if (r133 != null) goto L78;
        r133 = "";
    L78:
        if (p.a().isMicRoom(r120) == false) goto L89;
        VSRoom r134 = (VSRoom) r120.castToOrNull(VSRoom.class);
        if (r134 == null) goto L88;
        IOfficialChannelInfo r135 = r134.getOfficialChannelInfo();
        if (r135 == null) goto L88;
        IBaseUser r136 = r135.getChannelUser();
        if (r136 == null) goto L88;
        String r137 = r136.getIdString();
        if (r137 == null) goto L88;
        r130 = r137;
    L88:
        r133 = r130;
    L89:
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_INSERTED, "1");
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ROOM_ID, r132);
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ANCHOR_ID, r133);
    L91:
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_AUTO_PLAY, "1");
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ORDER, String.valueOf(1));
        d.a().f(r117.f106187c, r119, r126);
    L90:
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_INSERTED, "0");
        goto L91
    L62:
        if (Intrinsics.areEqual(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, r127) == false) goto L67;
        if (Intrinsics.areEqual("video_head", r128) == false) goto L67;
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_FIRST_REQUEST_PAGE, "feed_video_head");
    L67:
        if (Intrinsics.areEqual(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, r127) == false) goto L72;
        if (Intrinsics.areEqual("live_cell", r128) == false) goto L72;
        r126.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_FIRST_REQUEST_PAGE, "feed_live_cell");
        goto L72
    L30:
        if (r116.invoke().booleanValue() != true) goto L32;
        return null;
    L26:
        ALogger.i("EndPageHybridHelper", "format error!");
        goto L27
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = "null";
        goto L6
    }
}
