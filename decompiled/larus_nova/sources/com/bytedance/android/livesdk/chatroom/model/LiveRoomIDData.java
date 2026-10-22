package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.LiveRoomIDData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004R \u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LiveRoomIDData;", "", "()V", "roomIdStr", "", "", "roomIds", "", "roomIdsForOpenId", "getRoomIds2", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomIDData implements vh7.h {

    @SerializedName("room_id_str")
    public Map<String, String> roomIdStr;

    @SerializedName("room_id")
    protected Map<Long, Long> roomIds;

    @SerializedName("open_room_id")
    protected Map<String, Long> roomIdsForOpenId;

    public LiveRoomIDData() {
    }

    public final Map<String, Long> getRoomIds2() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Map<String, Long> r101 = this.roomIdsForOpenId;
        r100.getClass();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return MapsKt.emptyMap();
    }

    public LiveRoomIDData(am3.g r110) {
        this.roomIds = new HashMap();
        this.roomIdsForOpenId = new HashMap();
        this.roomIdStr = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L59;
        Object r102 = null;
        if (r101 == 1) goto L43;
        if (r101 == 2) goto L27;
        if (r101 != 5000) goto L10;
        long r103 = r110.c();
        Object r104 = null;
    L12:
        int r111 = r110.f();
        if (r111 == (-1)) goto L19;
        if (r111 != 1) goto L15;
        r102 = am3.h.c(r110);
        goto L12
    L15:
        if (r111 != 2) goto L16;
        r104 = Long.valueOf(r110.j());
        goto L12
    L16:
        am3.h.e(r110);
        goto L12
    L19:
        r110.d(r103);
        Map r105 = this.roomIdsForOpenId;
        if (r102 == null) goto L26;
        if (r104 == null) goto L24;
    L54:
        r105.put(r102, r104);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L10:
        am3.h.e(r110);
        goto L3
    L27:
        long r106 = r110.c();
        r104 = null;
    L28:
        int r112 = r110.f();
        if (r112 == (-1)) goto L35;
        if (r112 != 1) goto L31;
        r102 = am3.h.c(r110);
        goto L28
    L31:
        if (r112 != 2) goto L32;
        r104 = am3.h.c(r110);
        goto L28
    L32:
        am3.h.e(r110);
        goto L28
    L35:
        r110.d(r106);
        r105 = this.roomIdStr;
        if (r102 == null) goto L42;
        if (r104 != null) goto L54;
        throw new IllegalStateException("Value must not be null");
    L42:
        throw new IllegalStateException("Key must not be null");
    L43:
        long r107 = r110.c();
        r104 = null;
    L44:
        int r113 = r110.f();
        if (r113 == (-1)) goto L51;
        if (r113 != 1) goto L47;
        r102 = Long.valueOf(r110.j());
        goto L44
    L47:
        if (r113 != 2) goto L48;
        r104 = Long.valueOf(r110.j());
        goto L44
    L48:
        am3.h.e(r110);
        goto L44
    L51:
        r110.d(r107);
        r105 = this.roomIds;
        if (r102 == null) goto L58;
        if (r104 != null) goto L54;
        throw new IllegalStateException("Value must not be null");
    L58:
        throw new IllegalStateException("Key must not be null");
    L59:
        r110.d(r100);
    }
}
