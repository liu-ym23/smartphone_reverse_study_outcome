package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.RoomInteractEntranceResponse.GroupProperty")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/o0;", "", "", "name", "Ljava/lang/String;", "", "capacity", "J", "<init>", "()V", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o0 implements vh7.h {

    @SerializedName("capacity")
    public long capacity;

    @SerializedName("name")
    public String name;

    public o0() {
        this.name = "";
        this.capacity = -1;
    }

    public o0(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.name = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.capacity = r100.j();
        r102 = r102 | true;
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if (this.name != null) goto L15;
        this.name = "";
    L15:
        if ((r102 & true) == true) goto L27;
        this.capacity = -1;
        return;
    }
}
