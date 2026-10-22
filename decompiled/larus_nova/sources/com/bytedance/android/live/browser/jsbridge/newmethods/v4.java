package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "GetMaixuRoomStatus")
public final class v4 extends com.bytedance.ies.web.jsbridge2.g<Object, JSONObject> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final JSONObject j() throws Exception {
        ?? r100 = new JSONObject();
        ILiveRoomService r101 = (ILiveRoomService) jc1.k.f(IRoomService.class);
        ?? r102 = 0;
        boolean r103 = false;
        if (r101 == null) goto L25;
        Room r104 = r101.getCurrentRoom();
        if (r104 == null) goto L25;
        IMicRoomService r105 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r105 != null) goto L9;
        boolean r106 = false;
    L10:
        IMicRoomService r107 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r107 != null) goto L13;
        boolean r108 = false;
    L14:
        OfficialChannelInfo r109 = r104.officialChannelInfo;
        if (r109 != null) goto L17;
    L19:
        int r110 = 0;
    L20:
        IMicRoomService r111 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r111 == null) goto L24;
        r103 = r111.isLoyalAudience();
    L24:
        boolean r112 = r106;
        ?? r113 = r103;
        r102 = r112;
        ?? r114 = r108;
    L26:
        r100.put("isInMaixuRoom", r102);
        r100.put("iswillNext", r114);
        r100.put("isBackupRoom", r110);
        r100.put("isLoyalAudience", r113);
        return r100;
    L17:
        if (r109.getBackupRoomId() != r104.getId()) goto L19;
        r110 = 1;
        goto L20
    L13:
        r108 = r107.willNext(r104);
        goto L14
    L9:
        r106 = r105.isMicRoom(r104);
    L25:
        r110 = 0;
        r113 = 0;
        r114 = 0;
        goto L26
    }

    public v4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final /* bridge */ /* synthetic */ JSONObject invoke(Object r100, CallContext r101) throws Exception {
        return j();
    }
}
