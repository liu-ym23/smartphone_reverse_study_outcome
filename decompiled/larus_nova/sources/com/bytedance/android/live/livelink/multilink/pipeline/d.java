package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.lynx.tasm.LynxError;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import xb6.f;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements wb6.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkConfig f81363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkPipelineManager f81364b;

    public d(MultiLinkConfig r100, LinkPipelineManager r101) {
        this.f81363a = r100;
        this.f81364b = r101;
    }

    @Override // wb6.a.e
    public final void F2(long r100, Throwable r110) {
        Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
        LinkMonitor.a("PipeLineM", "startLeaveChannelReq", "onLeaveFailed", null, null, false, 120);
        this.f81364b.v0().f(false, "leave channel failed");
        Iterator<f> r101 = this.f81363a.f252220k.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().f563128a.F2(r100, r110);
        goto L4
    }

    @Override // wb6.a.e
    public final void Xf(long r100, ExtraResponse<? extends g1, Extra> r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        LinkMonitor.a("PipeLineM", "startLeaveChannelReq", "leave channel success duration " + r100, null, null, false, 120);
        Iterator<f> r101 = this.f81363a.f252220k.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().f563128a.Xf(r100, r110);
        goto L4
    L6:
        this.f81364b.N0("LeaveChannel");
    }
}
