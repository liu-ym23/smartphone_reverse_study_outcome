package com.bytedance.ai.bridge.method.hybridmonitor;

import com.bytedance.ai.applet.base.log.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.hybridMonitor.AbsReportErrorMethodIDL;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/hybridmonitor/ReportErrorMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$ErrorInfoModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportErrorMethod extends AbsReportErrorMethodIDL {

    public static final class a {
    }

    static {
    }

    public ReportErrorMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        String r103 = "";
        AbsReportErrorMethodIDL.b r104 = (AbsReportErrorMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        y3.a r105 = (y3.a) r100.d(y3.a.class);
        if (r105 != null) goto L17;
        h.a.a(r102, "hybrid monitor not initialized", null, null, 14);
        return;
    L17:
        JSONObject r106 = new JSONObject(r104.toJson().toString());     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r106, "data");     // Catch: Exception -> L10
        b r107 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Exception -> L10
        com.bytedance.ai.applet.base.log.a.c("EventReporter", "reportError: data = " + r106);     // Catch: Exception -> L10
        com.ivy.ivykit.api.plugin.a r108 = r105.f565728b;     // Catch: Exception -> L10
        if (r108 == null) goto L8;
        r108.b(r106, r105.f565727a);     // Catch: Exception -> L10
    L8:
        Intrinsics.checkNotNullParameter(AbsReportErrorMethodIDL.a.class, "<this>");     // Catch: Exception -> L10
        r102.b((ResultModel) c.a(AbsReportErrorMethodIDL.a.class), "");     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.ai.applet.base.log.a.b("HybridMonitor", "custom report failed", e);
        String r109 = e.getMessage();
        if (r109 == null) goto L15;
        r103 = r109;
    L15:
        h.a.a(r102, r103, null, null, 14);
    }
}
