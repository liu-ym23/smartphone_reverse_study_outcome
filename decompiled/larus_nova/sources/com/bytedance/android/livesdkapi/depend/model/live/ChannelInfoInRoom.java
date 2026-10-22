package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import am3.h;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.LinkMic.LinkMicChannelInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ChannelInfoInRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ChannelInfo;", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelInfoInRoom extends ChannelInfo {
    public ChannelInfoInRoom() {
    }

    public ChannelInfoInRoom(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.layout = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.f162579vendor = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.dimension = (int) r100.j();
        goto L3
    L11:
        h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
