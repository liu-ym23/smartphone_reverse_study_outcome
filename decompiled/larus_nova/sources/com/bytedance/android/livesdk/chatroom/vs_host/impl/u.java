package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u implements com.bytedance.android.scope.o, vr1.r {
    public u() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr1.r
    public final void a(boolean r100, Float r101, Float r102, Float r103, Float r104) {
        Intrinsics.checkNotNullParameter("vsLandscapeMessageBoard", "source");
        MsgWindowAdjustSource r105 = MsgWindowAdjustSource.VS_LANDSCAPE_MSG_BOARD;
        if (Intrinsics.areEqual("vsLandscapeMessageBoard", r105.getDescription()) == true) goto L6;
        r105 = MsgWindowAdjustSource.UNKNOWN;
    L6:
        IMsgWindowService r106 = (IMsgWindowService) jc1.k.n(IMsgWindowService.class);
        h71.a r107 = new h71.a();
        r107.f483968a = r100;
        r107.f483969b = r101;
        r107.f483970c = r102;
        r107.f483971d = r103;
        r107.f483972e = r104;
        Unit r108 = Unit.INSTANCE;
        r106.msgWindowPositionAdjust(r105, r107);
    }
}
