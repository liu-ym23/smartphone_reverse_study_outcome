package com.bytedance.android.livesdk.chatroom.model.interact;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class f3 implements am3.c<RoomLinkMicAnchorSettings> {
    public f3() {
    }

    @Override // am3.c
    public final RoomLinkMicAnchorSettings decode(am3.g r100) throws Exception {
        RoomLinkMicAnchorSettings r101 = new RoomLinkMicAnchorSettings();
        r101.settings = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.settings.add((com.bytedance.android.livesdk.chatroom.interact.model.y) vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.interact.model.y.class));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }
}
