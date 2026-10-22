package com.bytedance.android.livesdkapi.depend.model.live.room;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.room.EnterRoomBizParams")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/room/EnterRoomBizParams;", "", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterRoomBizParams implements h {
    public EnterRoomBizParams() {
    }

    public EnterRoomBizParams(g r100) {
        long r101 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r101);
    }
}
