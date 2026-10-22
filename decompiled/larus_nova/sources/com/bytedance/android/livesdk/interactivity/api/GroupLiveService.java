package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.grouplive.CollaborateWidget;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.ChangeRoomInfoKt;
import com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/GroupLiveService;", "Lcom/bytedance/android/livesdk/interactivity/api/IGroupLiveService;", "()V", "anchorIdBeforeJump", "", "getAnchorIdBeforeJump", "()Ljava/lang/String;", "setAnchorIdBeforeJump", "(Ljava/lang/String;)V", "requestIdBeforeJump", "getRequestIdBeforeJump", "setRequestIdBeforeJump", "roomIdBeforeJump", "", "getRoomIdBeforeJump", "()J", "setRoomIdBeforeJump", "(J)V", "getCloudCollaborateExtraParams", "", "roomId", "getCollaborateWidgetClass", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GroupLiveService implements IGroupLiveService {
    private String anchorIdBeforeJump;
    private String requestIdBeforeJump;
    private long roomIdBeforeJump;

    public GroupLiveService() {
        this.anchorIdBeforeJump = "";
        this.requestIdBeforeJump = "";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public String getAnchorIdBeforeJump() {
        return this.anchorIdBeforeJump;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public Class<? extends LiveRecyclableWidget> getCollaborateWidgetClass() {
        return CollaborateWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public String getRequestIdBeforeJump() {
        return this.requestIdBeforeJump;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public long getRoomIdBeforeJump() {
        return this.roomIdBeforeJump;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public Map<String, String> getCloudCollaborateExtraParams(long r110) {
        LinkedHashMap r100 = new LinkedHashMap();
        Long r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, r110, 1);
        if (r102 == null) goto L71;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L71;
        Room r104 = r103.getValue();
        if (r104 == null) goto L71;
        RoomOthersData r105 = r104.others;
        if (r105 == null) goto L71;
        IGroupLiveData r106 = r105.getGroupData();
        if (r106 == null) goto L71;
        int r107 = r106.getGroupLiveMode();
        User r108 = r104.mo8271getOwner();
        if (r108 == null) goto L15;
        String r109 = r108.getIdString();
    L17:
        if (r107 != 4) goto L71;
        RoomOthersData r111 = r104.others;
        if (r111 == null) goto L60;
        IChangeRoomInfo r112 = r111.getChangeRoomInfo();
        if (r112 == null) goto L60;
        if (r112.getChangeRoomReason() != ChangeRoomInfoKt.getCHANGE_ROOM_REASON_CLOUD_COLLABORATE()) goto L60;
        RoomOthersData r113 = r104.others;
        if (r113 == null) goto L29;
        IChangeRoomInfo r114 = r113.getChangeRoomInfo();
        if (r114 == null) goto L29;
        long r115 = r114.getBeforeAnchorId();
    L31:
        if (r115 <= 0) goto L60;
        RoomOthersData r116 = r104.others;
        if (r116 == null) goto L37;
        IChangeRoomInfo r117 = r116.getChangeRoomInfo();
        if (r117 == null) goto L37;
        long r118 = r117.getBeforeRoomId();
    L39:
        if (r118 <= 0) goto L60;
        RoomOthersData r119 = r104.others;
        if (r119 == null) goto L45;
        IChangeRoomInfo r120 = r119.getChangeRoomInfo();
        if (r120 == null) goto L45;
        Long r121 = Long.valueOf(r120.getBeforeAnchorId());
    L46:
        r100.put("throw_user_id", String.valueOf(r121));
        RoomOthersData r122 = r104.others;
        if (r122 == null) goto L51;
        IChangeRoomInfo r123 = r122.getChangeRoomInfo();
        if (r123 == null) goto L51;
        r101 = Long.valueOf(r123.getBeforeRoomId());
    L51:
        r100.put("throw_room_id", String.valueOf(r101));
        com.bytedance.android.livesdk.log.filter.o r124 = u.l().c(Room.class);
        if (r124 == null) goto L57;
        Map<String, String> r125 = r124.getMap();
        if (r125 == null) goto L57;
        String r126 = r125.get("request_id");
        if (r126 == null) goto L57;
    L58:
        r100.put("link_screen_request_id", r126);
        r100.put("is_link_screen_co_rec", "2");
        r100.put("group_live_mode", "4");
    L57:
        r126 = "";
    L45:
        r121 = null;
    L37:
        r118 = 0;
    L29:
        r115 = 0;
    L60:
        if (getAnchorIdBeforeJump().length() <= 0) goto L62;
        boolean r127 = true;
    L63:
        if (r127 == false) goto L71;
        if ((!Intrinsics.areEqual(getAnchorIdBeforeJump(), "0")) == false) goto L71;
        if (getRoomIdBeforeJump() <= 0) goto L71;
        if ((!Intrinsics.areEqual(r109, getAnchorIdBeforeJump())) == false) goto L71;
        r100.put("throw_user_id", getAnchorIdBeforeJump());
        r100.put("throw_room_id", String.valueOf(getRoomIdBeforeJump()));
        r100.put("link_screen_request_id", getRequestIdBeforeJump());
        r100.put("is_link_screen_co_rec", "1");
        r100.put("group_live_mode", "4");
        goto L71
    L62:
        r127 = false;
        goto L63
    L15:
        r109 = null;
    L71:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public void setAnchorIdBeforeJump(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorIdBeforeJump = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public void setRequestIdBeforeJump(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestIdBeforeJump = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public void setRoomIdBeforeJump(long r100) {
        this.roomIdBeforeJump = r100;
    }
}
