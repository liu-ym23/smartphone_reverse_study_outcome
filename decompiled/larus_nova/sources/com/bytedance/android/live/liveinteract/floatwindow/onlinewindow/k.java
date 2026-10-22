package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f73430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gm2.i f73431b;

    public k(long r100, gm2.i r101) {
        this.f73430a = r100;
        this.f73431b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        long r102 = this.f73430a;
        InteractLinkFullLinkMonitor.T(100102, System.currentTimeMillis() - r102, r101);
        int r103 = nd0.g.f518750a;
        nd0.g.h(this.f73431b, this.f73430a, r101);
        ALogger.stacktrace(6, "LinkmicOnlineFloatWindowManager", r101.getStackTrace());
    }
}
