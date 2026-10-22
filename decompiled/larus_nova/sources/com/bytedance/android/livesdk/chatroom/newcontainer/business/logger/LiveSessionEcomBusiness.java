package com.bytedance.android.livesdk.chatroom.newcontainer.business.logger;

import com.bytedance.android.livesdk.room.Task.base.a;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import ls2.c;
import os2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveSessionEcomBusiness extends d<c> {
    @Override // os2.a
    public final c d() {
        return null;
    }

    public LiveSessionEcomBusiness() {
    }

    @Override // os2.d
    public final void i(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostCommerceServiceLive r101 = (IHostCommerceServiceLive) k.f(IHostCommerceServiceLive.class);
        if (r101 == null) goto L5;
        r101.onExistLiveSession(r100.f510523l, r100.f510516e, r100.f510517f);
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // os2.d
    public final List<a<ls2.d, ?>> g(ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        final ArrayList r103 = new ArrayList();
        if (r101 == null) goto L5;
        ts2.d.a(r101, new LiveSessionEcomBusiness$containerStateChanged$1(r103));
    L5:
        if (r101 == null) goto L7;
        ts2.d.d(r101, LiveSessionEcomBusiness$containerStateChanged$2.INSTANCE);
    L7:
        return r103;
    }
}
