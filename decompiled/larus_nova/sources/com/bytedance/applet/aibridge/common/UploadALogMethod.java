package com.bytedance.applet.aibridge.common;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/common/UploadALogMethod;", "Lcom/bytedance/applet/aibridge/common/AbsUploadALogMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/common/AbsUploadALogMethodIDL$UploadALogMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/common/AbsUploadALogMethodIDL$UploadALogMethodResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadALogMethod extends AbsUploadALogMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f191006b = 0;

    public static final class a {
    }

    static {
    }

    public UploadALogMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, final h r110) {
        final AbsUploadALogMethodIDL.a r102 = (AbsUploadALogMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        FLogger r103 = FLogger.f375446a;
        r103.i("UploadALogMethod", "uploadALog triggered, scene: " + r102.getScene() + ", duration: " + (r102.getEndTime() - r102.getStartTime()) + ", startTime: " + r102.getStartTime() + ", endTime: " + r102.getEndTime());
        r103.k(r102.getScene(), r102.getStartTime(), r102.getEndTime(), new gv3.a(r110, r102));
    }
}
