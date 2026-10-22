package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.logger.room;

import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.RoomStateChangeLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.bytedance.android.livesdk.room.c<ls2.c> {
    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(final com.bytedance.android.livesdk.room.b r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L7;
        Function0<Unit> r103 = new HighPriorityLiveLoggerBusiness$containerStateChanged$1(r100);
        Intrinsics.checkNotNullParameter(r101, "$this$onDrawerOpened");
        Intrinsics.checkNotNullParameter(r103, "action");
        if (r101 != ContainerLifecycle.ON_DRAWER_OPENED) goto L7;
        r103.invoke();
    L7:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void p(final com.bytedance.android.livesdk.room.b r100, RoomStateChangeLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        ts2.d.k(r101, new HighPriorityLiveLoggerBusiness$onRoomStateChanged$1(r100));
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
