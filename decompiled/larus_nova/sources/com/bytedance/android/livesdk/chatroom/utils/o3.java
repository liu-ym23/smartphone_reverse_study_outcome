package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o3 {
    public static final com.bytedance.android.livesdk.chatroom.t a() {
        return IRoomContextService.a.c((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 3);
    }

    public static final MiddlewareRoomContext b() {
        return MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
    }

    public static final com.bytedance.android.livesdk.chatroom.u d() {
        return ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomMultiLinkService(null, 0);
    }

    public static final com.bytedance.android.livesdk.chatroom.o f() {
        return IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 0, 3);
    }

    public static final MiddlewareRoomContext c(DataCenter r100) {
        return MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r100, 0, 2);
    }

    public static final com.bytedance.android.livesdk.chatroom.u e(RealTimeChorusMainViewWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$multiLinkContext");
        return ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomMultiLinkService(r100.getRoomContext());
    }

    public static final com.bytedance.android.livesdk.chatroom.o g(MiddlewareRoomWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$roomContext");
        return ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomDataContext(r100.getRoomContext());
    }

    public static /* synthetic */ com.bytedance.android.livesdk.chatroom.o j(DataCenter r100) {
        return i(r100, 0L);
    }

    public static final com.bytedance.android.livesdk.chatroom.o h(MiddlewareRoomWidget r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$roomContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        return IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), r101, 0, 2);
    }

    public static final com.bytedance.android.livesdk.chatroom.o i(DataCenter r100, Long r101) {
        IRoomContextService r102 = (IRoomContextService) jc1.k.n(IRoomContextService.class);
        if (r101 == null) goto L5;
        long r103 = r101.longValue();
    L7:
        return r102.getRoomDataContext(r100, r103);
    L5:
        r103 = 0;
        goto L7
    }
}
