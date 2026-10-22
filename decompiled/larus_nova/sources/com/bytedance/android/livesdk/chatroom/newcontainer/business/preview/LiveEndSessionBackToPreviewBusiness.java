package com.bytedance.android.livesdk.chatroom.newcontainer.business.preview;

import com.bytedance.android.livesdk.room.Task.base.a;
import com.bytedance.android.livesdk.room.state.ContainerScrollLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ls2.c;
import os2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveEndSessionBackToPreviewBusiness extends d<c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f107510b;

    @Override // os2.a
    public final c d() {
        return null;
    }

    public LiveEndSessionBackToPreviewBusiness() {
    }

    @Override // os2.d
    public final List<a<ls2.d, ?>> f(ls2.d r100, ContainerScrollLifecycle r101, final ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        ts2.d.f(r101, new LiveEndSessionBackToPreviewBusiness$containerScrollStateChanged$1(this, r102));
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
