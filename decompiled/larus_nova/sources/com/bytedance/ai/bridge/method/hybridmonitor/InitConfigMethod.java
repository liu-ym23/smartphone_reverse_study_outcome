package com.bytedance.ai.bridge.method.hybridmonitor;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.hybridMonitor.AbsInitConfigMethodIDL;
import com.ivy.ivykit.api.plugin.IIvyHybridMonitorService;
import com.ss.android.lark.utils.statistics.PerfLog;
import d3.a0;
import e3.d;
import f3.h;
import java.util.Map;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/hybridmonitor/InitConfigMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$SlardarConfigModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitConfigMethod extends AbsInitConfigMethodIDL {

    public static final class a {
    }

    static {
    }

    public InitConfigMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r110) {
        String r102 = "";
        AbsInitConfigMethodIDL.b r103 = (AbsInitConfigMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        com.bytedance.ai.applet.base.log.a.c("HybridMonitor", "init config");     // Catch: Exception -> L30
        IIvyHybridMonitorService.Companion r104 = IIvyHybridMonitorService.f278327a;     // Catch: Exception -> L30
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L30
        String r106 = r103.getBid();     // Catch: Exception -> L30
        if (r106 == null) goto L6;
        r105.put("bid", r106);     // Catch: Exception -> L30
    L6:
        String r107 = r103.getPid();     // Catch: Exception -> L30
        if (r107 == null) goto L9;
        r105.put("pid", r107);     // Catch: Exception -> L30
    L9:
        String r108 = r103.getEnv();     // Catch: Exception -> L30
        if (r108 == null) goto L12;
        r105.put("env", r108);     // Catch: Exception -> L30
    L12:
        String r109 = r103.getRelease();     // Catch: Exception -> L30
        if (r109 == null) goto L15;
        r105.put("release", r109);     // Catch: Exception -> L30
    L15:
        Map<String, Object> r111 = r103.getContext();     // Catch: Exception -> L30
        if (r111 == null) goto L18;
        r105.put(PerfLog.PARAM_KEY_CONTEXT_ID, r111);     // Catch: Exception -> L30
    L18:
        JSONObject r112 = r104.b(r105);     // Catch: Exception -> L30
        RefType r113 = RefType.NORMAL;     // Catch: Exception -> L30
        Object r114 = r100.d(y3.a.class);     // Catch: Exception -> L30
        if (r114 != null) goto L25;
        com.bytedance.ai.applet.base.log.a.c("HybridMonitor", "creating event reporter");     // Catch: Exception -> L30
        a0 r115 = r100.getContainerContext();     // Catch: Exception -> L30
        if (r115 == null) goto L23;
        String r116 = r115.getUrl();     // Catch: Exception -> L30
    L24:
        r114 = new y3.a(r116);     // Catch: Exception -> L30
        r100.b(y3.a.class, r114, r113);     // Catch: Exception -> L30
        goto L25
    L23:
        r116 = null;
    L25:
        Intrinsics.checkNotNullParameter(r112, "value");     // Catch: Exception -> L30
        com.ivy.ivykit.api.plugin.a r117 = ((y3.a) r114).f565728b;     // Catch: Exception -> L30
        if (r117 == null) goto L28;
        r117.updateConfig(r112);     // Catch: Exception -> L30
    L28:
        Intrinsics.checkNotNullParameter(AbsInitConfigMethodIDL.a.class, "<this>");     // Catch: Exception -> L30
        r110.b((ResultModel) c.a(AbsInitConfigMethodIDL.a.class), "");     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        com.bytedance.ai.applet.base.log.a.b("HybridMonitor", "init config failed", e);
        String r118 = e.getMessage();
        if (r118 == null) goto L35;
        r102 = r118;
    L35:
        h.a.a(r110, r102, null, null, 14);
    }
}
