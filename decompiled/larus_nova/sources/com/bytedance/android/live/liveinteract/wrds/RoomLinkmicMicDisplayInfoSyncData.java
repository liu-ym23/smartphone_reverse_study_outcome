package com.bytedance.android.live.liveinteract.wrds;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016R \u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/wrds/RoomLinkmicMicDisplayInfoSyncData;", "", "()V", "roomDisplayInfo", "", "", "Lcom/bytedance/android/live/liveinteract/wrds/RoomLinkmicMicDisplayInfo;", "roomId", "toString", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomLinkmicMicDisplayInfoSyncData implements vh7.h {

    @SerializedName("room_display_info")
    public Map<Long, ? extends RoomLinkmicMicDisplayInfo> roomDisplayInfo;

    @SerializedName("room_id")
    public long roomId;

    public RoomLinkmicMicDisplayInfoSyncData() {
    }

    public String toString() {
        return "RoomLinkmicMicDisplayInfoSyncData(roomId=" + this.roomId + ", roomDisplayInfo=" + this.roomDisplayInfo + ')';
    }

    public RoomLinkmicMicDisplayInfoSyncData(am3.g r110) {
        this.roomDisplayInfo = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.roomId = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r102 = r110.c();
        Long r103 = null;
        Object r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = Long.valueOf(r110.j());
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = vh7.f.a(r110, RoomLinkmicMicDisplayInfo.class);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r102);
        Map<Long, ? extends RoomLinkmicMicDisplayInfo> r106 = this.roomDisplayInfo;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L27:
        r110.d(r100);
    }
}
