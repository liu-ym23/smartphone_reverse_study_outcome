package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.bytedance.android.live.revlink.link.core.service.s;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements c<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f98293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f98294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f98295c;

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        Disposable r100 = this.f98293a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public g(s r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "dynamicLayoutClient");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98294b = r100;
        this.f98295c = r101;
    }
}
