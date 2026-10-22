package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.network;

import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import os2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class NetworkGlobalConfigBusiness extends d<ls2.c> {
    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public NetworkGlobalConfigBusiness() {
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> h(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r101 = new ArrayList();
        r101.add(new c());
        return r101;
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> g(ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        ts2.d.d(r101, NetworkGlobalConfigBusiness$containerStateChanged$1.INSTANCE);
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
