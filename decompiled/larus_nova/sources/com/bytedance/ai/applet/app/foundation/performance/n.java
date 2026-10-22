package com.bytedance.ai.applet.app.foundation.performance;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class n extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f34359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f34360i;

    @Override // com.bytedance.ai.applet.app.foundation.performance.k
    public final e b(AppletPerformanceOutcome r100, long r101, AppletPerformanceErrorCode r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "outcome");
        Intrinsics.checkNotNullParameter(r102, "errorCode");
        return null;
    }

    public n(c r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter("__APP__", TextureRenderKeys.KEY_MODULE_NAME);
        super(r100, r101);
        this.f34359h = "__APP__";
    }
}
