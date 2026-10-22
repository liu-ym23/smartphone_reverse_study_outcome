package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m {
    public static final IGameDataService a() {
        return (IGameDataService) jc1.k.f(IGameDataService.class);
    }

    public static final t b() {
        return IRoomContextService.a.c((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 3);
    }

    public static final u d() {
        return ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomMultiLinkService(null, 0);
    }

    public static final com.bytedance.android.livesdk.chatroom.o i() {
        return IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 0, 3);
    }

    public static final boolean c() {
        com.bytedance.live.datacontext.m<IRoom> r100 = i().getRoom();
        if (r100 == null) goto L8;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L8;
        String r102 = r101.getAnchorAbValue("audio_radio_v2");
        if (r102 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r102, "1") == false) goto L18;
        com.bytedance.live.datacontext.m<IRoom> r103 = i().getRoom();
        if (r103 == null) goto L18;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L18;
        if (r104.isLiveTypeAudio() != true) goto L18;
        return true;
    L18:
        return false;
    L8:
        r102 = "0";
        goto L10
    }

    public static final u e(MiddlewareRoomWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$multiLinkContext");
        return ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomMultiLinkService(r100.getRoomContext());
    }

    public static final u g(DataContext r100) {
        return ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomMultiLinkService(r100);
    }

    public static final com.bytedance.android.livesdk.chatroom.o j(MiddlewareRoomWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$roomContext");
        return ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomDataContext(r100.getRoomContext());
    }

    public static final com.bytedance.android.livesdk.chatroom.o m(DataContext r100) {
        return ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomDataContext(r100);
    }

    public static com.bytedance.android.livesdk.chatroom.k o(DataCenter r100) {
        long r101 = 0;
        Long r102 = 0L;
        IRoomContextService r103 = (IRoomContextService) jc1.k.n(IRoomContextService.class);
        if (r102 == null) goto L6;
        r101 = r102.longValue();
    L6:
        return r103.getBottomToolbarService(r100, r101);
    }

    public static final u f(DataCenter r100, Long r101) {
        IRoomContextService r102 = (IRoomContextService) jc1.k.n(IRoomContextService.class);
        if (r101 == null) goto L5;
        long r103 = r101.longValue();
    L7:
        return r102.getRoomMultiLinkService(r100, r103);
    L5:
        r103 = 0;
        goto L7
    }

    public static final com.bytedance.android.livesdk.chatroom.o k(MiddlewareRoomWidget r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$roomContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        return IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), r101, 0, 2);
    }

    public static final com.bytedance.android.livesdk.chatroom.o l(DataCenter r100, Long r101) {
        IRoomContextService r102 = (IRoomContextService) jc1.k.n(IRoomContextService.class);
        if (r101 == null) goto L5;
        long r103 = r101.longValue();
    L7:
        return r102.getRoomDataContext(r100, r103);
    L5:
        r103 = 0;
        goto L7
    }

    public static /* synthetic */ u h(DataCenter r100, Long r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = 0L;
    L9:
        return f(r100, r101);
    }

    public static /* synthetic */ com.bytedance.android.livesdk.chatroom.o n(DataCenter r100, Long r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = 0L;
    L9:
        return l(r100, r101);
    }
}
