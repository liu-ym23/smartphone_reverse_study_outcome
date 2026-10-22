package com.bytedance.ai.bridge.method.log;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.monitor.b;
import e3.d;
import f3.h;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/log/ReportAppLogMethod;", "Lcom/bytedance/ai/bridge/method/log/AbsReportAppLogMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/log/AbsReportAppLogMethodIDL$ReportAppLogParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/log/AbsReportAppLogMethodIDL$ReportAppLogResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportAppLogMethod extends AbsReportAppLogMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35531b = 0;

    public static final class a {
    }

    static {
    }

    public ReportAppLogMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsReportAppLogMethodIDL.a r103 = (AbsReportAppLogMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        AtomicBoolean r104 = b.f37194a;
        b.b(r103.getEventName(), new com.bytedance.ai.bridge.method.log.a(r100, r103));
        Intrinsics.checkNotNullParameter(AbsReportAppLogMethodIDL.b.class, "<this>");
        r102.b((ResultModel) c.a(AbsReportAppLogMethodIDL.b.class), "");
    }
}
