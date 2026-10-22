package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.room.record;

import com.bytedance.android.livesdk.room.b;
import com.bytedance.android.livesdk.room.c;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.RoomStateChangeLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import ts2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends c<ls2.c> {
    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(final b r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        d.j(r101, new RoomRecordMonitorBusiness$containerStateChanged$1(r100));
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void p(final b r100, RoomStateChangeLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        d.k(r101, new RoomRecordMonitorBusiness$onRoomStateChanged$1(r100));
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
