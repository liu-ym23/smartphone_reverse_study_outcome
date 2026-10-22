package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.degrade;

import com.bytedance.android.livesdk.room.Task.base.a;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ls2.c;
import os2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class SessionDegradeBusiness extends d<c> {
    @Override // os2.a
    public final c d() {
        return null;
    }

    public SessionDegradeBusiness() {
    }

    @Override // os2.d
    public final List<a<ls2.d, ?>> g(ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        final ck1.d r103 = (ck1.d) r100.a(ck1.d.class);
        if (r101 == null) goto L5;
        ts2.d.a(r101, new SessionDegradeBusiness$containerStateChanged$1(r103));
    L5:
        if (r101 == null) goto L7;
        ts2.d.d(r101, new SessionDegradeBusiness$containerStateChanged$2(r103));
    L7:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
