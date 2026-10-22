package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.innerfeed;

import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class SessionCheckLiveBusiness extends os2.d<ik1.a> {
    @Override // os2.a
    public final String b() {
        return "RoomSessionTaskConst_live_room_check_live_data";
    }

    @Override // os2.a
    public final boolean e() {
        return true;
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> h(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // os2.a
    public final ls2.c d() {
        return new ik1.a();
    }

    public SessionCheckLiveBusiness() {
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> l(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> g(final ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        ts2.d.d(r101, new SessionCheckLiveBusiness$containerStateChanged$1(this, r100));
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
