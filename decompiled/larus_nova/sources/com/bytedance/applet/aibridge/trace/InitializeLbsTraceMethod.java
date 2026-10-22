package com.bytedance.applet.aibridge.trace;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.lbs.trace.api.ILbsTraceService;
import com.larus.lbs.trace.api.model.LbsTraceInitializationStatus;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/trace/InitializeLbsTraceMethod;", "Lcom/bytedance/applet/aibridge/trace/AbsInitializeLbsTraceIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/trace/AbsInitializeLbsTraceIDL$InitializeLbsTraceParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/trace/AbsInitializeLbsTraceIDL$InitializeLbsTraceResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitializeLbsTraceMethod extends AbsInitializeLbsTraceIDL {

    public static final class a {
    }

    static {
    }

    public InitializeLbsTraceMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsInitializeLbsTraceIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        FLogger.f375446a.i("InitializeLbsTraceMethod", "InitializeLbsTraceMethod.handle");
        LbsTraceInitializationStatus r103 = ILbsTraceService.f355708a.init();
        Intrinsics.checkNotNullParameter(AbsInitializeLbsTraceIDL.b.class, "<this>");
        BaseModel r104 = c.a(AbsInitializeLbsTraceIDL.b.class);
        ((AbsInitializeLbsTraceIDL.b) r104).setStatus(r103.getValue());
        r102.b((ResultModel) r104, "");
    }
}
