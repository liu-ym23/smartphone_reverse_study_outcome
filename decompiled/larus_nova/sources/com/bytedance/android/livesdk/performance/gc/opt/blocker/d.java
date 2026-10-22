package com.bytedance.android.livesdk.performance.gc.opt.blocker;

import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements a {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void prepare() {
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void a(GcBlockScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IMiddlewareHostAction r101 = (IMiddlewareHostAction) k.f(IMiddlewareHostAction.class);
        if (r101 == null) goto L6;
        r101.startBlockGc(r100.getSceneName());
        return;
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void b(GcBlockScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IMiddlewareHostAction r101 = (IMiddlewareHostAction) k.f(IMiddlewareHostAction.class);
        if (r101 == null) goto L6;
        r101.stopBlockGc(r100.getSceneName());
        return;
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void requestBlockGc(int r100) {
        IMiddlewareHostAction r101 = (IMiddlewareHostAction) k.f(IMiddlewareHostAction.class);
        if (r101 == null) goto L6;
        r101.requestBlockGc(r100);
        return;
    }
}
