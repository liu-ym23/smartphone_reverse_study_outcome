package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.lynx.tasm.LynxError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements wb6.a.f {
    public e() {
    }

    @Override // wb6.a.f
    public final void a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        LinkMonitor.a("PipeLineM", "startNotifyJoinRtc", "failed " + r100.getMessage(), null, LinkMonitor.LogLevel.ERROR, true, 40);
    }

    @Override // wb6.a.f
    public final void b(long r100, ExtraResponse<Unit, Extra> r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        LinkMonitor.a("PipeLineM", "startNotifyJoinRtc", "success duration " + r100, null, null, true, 56);
    }
}
