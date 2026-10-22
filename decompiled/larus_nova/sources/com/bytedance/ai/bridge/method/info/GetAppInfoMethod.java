package com.bytedance.ai.bridge.method.info;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import e3.d;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r4.a;
import z3.c;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/GetAppInfoMethod;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoResultModel;", "getContextDependInstance", "Lcom/bytedance/ai/bridge/service/IHostContextDepend;", "getLogDependInstance", "Lcom/bytedance/ai/bridge/service/IHostLogDepend;", "getScreenOrientation", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "is32Bit", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAppInfoMethod extends AbsGetAppInfoMethodIDL {
    public GetAppInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r210, ParamModel r211, final h r212) {
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetAppInfoMethodIDL.a) r211, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        final IHostContextDepend r100 = a.f535974a;
        Activity r101 = null;
        if (r100 == null) goto L27;
        final Context r102 = r100.getApplicationContext();
        final s4.a.C7565a r103 = s4.a.a(r102);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r104 = s4.a.b(r102, false);
        Resources r105 = r102.getResources();
        final int r110 = s4.a.c(r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density);
        int r111 = s4.a.b(r102, false);
        View r106 = r210.getEngineView();
        if (r106 == null) goto L7;
        Context r107 = r106.getContext();
    L8:
        if (r107 == null) goto L15;
        if ((r107 instanceof Activity) == true) goto L11;
        if ((r107 instanceof ContextWrapper) == false) goto L15;
        r107 = ((ContextWrapper) r107).getBaseContext();
        goto L8
    L11:
        r101 = (Activity) r107;
    L15:
        if (r101 != null) goto L17;
        r101 = k.b();
    L17:
        final Activity r112 = r101;
        int r108 = com.bytedance.ai.bridge.method.system.d.f35975a;
        int r113 = r103.f540519b;
        int r114 = r103.f540520c;
        int r115 = r103.f540522e;
        Resources r109 = r102.getResources();
        double r116 = WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()).density;
        if (r112 == null) goto L21;
        Resources r117 = r112.getResources();
        if (r117 == null) goto L21;
    L23:
        if (r117.getConfiguration().orientation != 2) goto L25;
        boolean r118 = true;
    L26:
        com.bytedance.ai.bridge.method.system.d.c(r112, r113, r114, r115, r116, r110, r111, r118, false, new c(r212, r100, r112, r102, this, r110, r103));
        return;
    L25:
        r118 = false;
    L21:
        r117 = r102.getResources();
        goto L23
    L7:
        r107 = null;
        goto L8
    L27:
        h.a.a(r212, "context dependency is not binded", null, null, 14);
    }
}
