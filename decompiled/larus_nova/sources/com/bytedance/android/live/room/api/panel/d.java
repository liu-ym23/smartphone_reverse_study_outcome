package com.bytedance.android.live.room.api.panel;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f99047a = 0;

    public d() {
    }

    static {
    }

    public static c a(RoomContext r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        IPanelService r101 = (IPanelService) k.f(IPanelService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getPanelManager(r100);
    }

    public static c b(DataCenter r100, long r101) {
        IPanelService r102 = (IPanelService) k.f(IPanelService.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getPanelManager(r100, r101);
    }

    public static /* synthetic */ c c(DataCenter r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        return b(r100, 0);
    }
}
