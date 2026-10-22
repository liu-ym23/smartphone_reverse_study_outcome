package com.bytedance.android.livesdk.chatroom.newcontainer.business.anchor;

import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.livesdk.room.Task.base.a;
import com.bytedance.android.livesdk.room.service.ExternalFunctionInjectorService;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ls2.c;
import os2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class AnchorRoomContainerBusiness extends d<c> {
    @Override // os2.a
    public final c d() {
        return null;
    }

    public AnchorRoomContainerBusiness() {
    }

    @Override // os2.d
    public final List<a<ls2.d, ?>> h(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ExternalFunctionInjectorService.Companion.getClass();
        ExternalFunctionInjectorService.a.d(false);
        AnchorMainPostOptUtils.a();
        return null;
    }

    @Override // os2.d
    public final List<a<ls2.d, ?>> g(ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        ts2.d.d(r101, AnchorRoomContainerBusiness$containerStateChanged$1.INSTANCE);
    L5:
        if (r101 == null) goto L7;
        ts2.d.h(r101, AnchorRoomContainerBusiness$containerStateChanged$2.INSTANCE);
    L7:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
