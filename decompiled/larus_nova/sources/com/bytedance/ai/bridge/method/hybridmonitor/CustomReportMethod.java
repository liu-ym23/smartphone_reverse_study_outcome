package com.bytedance.ai.bridge.method.hybridmonitor;

import com.bytedance.ai.applet.base.log.b;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.hybridMonitor.AbsCustomReportMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/hybridmonitor/CustomReportMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$CustomEventDataModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomReportMethod extends AbsCustomReportMethodIDL {

    public static final class a {
    }

    static {
    }

    public CustomReportMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r110, h r111) {
        AbsCustomReportMethodIDL.a r112 = (AbsCustomReportMethodIDL.a) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        g r101 = g.f37637a;
        StringBuilder r102 = new StringBuilder("call start, hasBid=");
        String r103 = r112.getBid();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        r102.append(!r104);
        r101.i("AISDK_JSB_CustomReportMethod", r102.toString());
        if (StringsKt.isBlank(r112.getEventName()) == false) goto L30;
        StringBuilder r105 = new StringBuilder("call failed, errNo=");
        f3.a r113 = f3.a.f475267h;
        r105.append(r113.f475285a);
        r105.append(", msg=eventName is empty");
        r101.e("AISDK_JSB_CustomReportMethod", r105.toString());
        h.a.a(r111, "eventName is empty", r113, null, 10);
        return;
    L30:
        RefType r106 = RefType.NORMAL;     // Catch: Exception -> L24
        Object r107 = r100.d(y3.a.class);     // Catch: Exception -> L24
        if (r107 != null) goto L19;
        a0 r108 = r100.getContainerContext();     // Catch: Exception -> L24
        if (r108 == null) goto L17;
        String r109 = r108.getUrl();     // Catch: Exception -> L24
    L18:
        r107 = new y3.a(r109);     // Catch: Exception -> L24
        r100.b(y3.a.class, r107, r106);     // Catch: Exception -> L24
        goto L19
    L17:
        r109 = null;
    L19:
        y3.a r114 = (y3.a) r107;     // Catch: Exception -> L24
        JSONObject r115 = new JSONObject(r112.toJson().toString());     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r115, "data");     // Catch: Exception -> L24
        b r116 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Exception -> L24
        com.bytedance.ai.applet.base.log.a.c("EventReporter", "reportCustomEvent: data = " + r115);     // Catch: Exception -> L24
        com.ivy.ivykit.api.plugin.a r117 = r114.f565728b;     // Catch: Exception -> L24
        if (r117 == null) goto L22;
        r117.a(r115, r114.f565727a);     // Catch: Exception -> L24
    L22:
        r101.i("AISDK_JSB_CustomReportMethod", "call success");     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(AbsCustomReportMethodIDL.b.class, "<this>");     // Catch: Exception -> L24
        r111.b((ResultModel) c.a(AbsCustomReportMethodIDL.b.class), "");     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        g r118 = g.f37637a;
        StringBuilder r119 = new StringBuilder("call failed, errNo=");
        f3.a r120 = f3.a.f475265f;
        r119.append(r120.f475285a);
        r119.append(", msg=");
        r119.append(e.getMessage());
        r118.e("AISDK_JSB_CustomReportMethod", r119.toString(), e);
        String r121 = e.getMessage();
        if (r121 != null) goto L28;
        r121 = "custom report failed";
    L28:
        h.a.a(r111, r121, r120, null, 10);
        return;
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r104 = false;
        goto L9
    }
}
