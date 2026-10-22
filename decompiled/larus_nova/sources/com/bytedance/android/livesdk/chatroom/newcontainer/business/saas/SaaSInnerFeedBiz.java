package com.bytedance.android.livesdk.chatroom.newcontainer.business.saas;

import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.ContainerScrollLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class SaaSInnerFeedBiz extends os2.d<a> {
    @Override // os2.a
    public final ls2.c d() {
        return new a();
    }

    public SaaSInnerFeedBiz() {
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> h(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IEnterGuideService r101 = (IEnterGuideService) k.f(IEnterGuideService.class);
        if (r101 == null) goto L5;
        r101.firstEnterLiveRoom();
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> f(ls2.d r100, ContainerScrollLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> g(final ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r103 = new ArrayList();
        if (r101 == null) goto L5;
        ts2.d.a(r101, new SaaSInnerFeedBiz$containerStateChanged$1(r100, r103));
    L5:
        if (r101 == null) goto L7;
        ts2.d.d(r101, new SaaSInnerFeedBiz$containerStateChanged$2(this, r100));
    L7:
        return r103;
    }
}
