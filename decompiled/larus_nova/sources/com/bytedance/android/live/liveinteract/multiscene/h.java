package com.bytedance.android.live.liveinteract.multiscene;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/h;", "", "", "roomBattleCreateTimeMs", "J", "", "toRoomIntroduction", "Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements vh7.h {

    @SerializedName("room_battle_create_time_ms")
    public long roomBattleCreateTimeMs;

    @SerializedName("to_room_instruction")
    public String toRoomIntroduction;

    public h() {
        this.toRoomIntroduction = "";
    }

    public h(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.roomBattleCreateTimeMs = r100.j();
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.toRoomIntroduction = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.toRoomIntroduction != null) goto L25;
        this.toRoomIntroduction = "";
        return;
    }
}
