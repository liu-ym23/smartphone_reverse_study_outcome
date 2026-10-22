package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.lynx.tasm.LynxError;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import xb6.f;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements wb6.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkConfig f81361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkPipelineManager f81362b;

    public c(MultiLinkConfig r100, LinkPipelineManager r101) {
        this.f81361a = r100;
        this.f81362b = r101;
    }

    @Override // wb6.a.b
    public final void bp(long r100, ExtraResponse<LinkFinishResult, Extra> r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        LinkMonitor.a("PipeLineM", "startFinishReq", "onFinishSuccess duration " + r100, null, null, false, 120);
        Iterator<f> r101 = this.f81361a.f252220k.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r101.next().f563128a.bp(r100, r110);
        goto L4
    L7:
        if (this.f81362b.f81330s.p() == false) goto L9;
        this.f81362b.f81330s.L("unMuteAudio");
    L9:
        this.f81362b.N0("AnchorFinishSuccess");
    }

    @Override // wb6.a.b
    public final void yp(long r100, Throwable r110) {
        Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
        LinkMonitor.a("PipeLineM", "startFinishReq", "onFinishFailed", null, null, false, 120);
        this.f81362b.v0().f(false, "finish failed");
        Iterator<f> r101 = this.f81361a.f252220k.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().f563128a.yp(r100, r110);
        goto L4
    }
}
