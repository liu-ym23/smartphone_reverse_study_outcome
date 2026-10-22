package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.scan.AbsScanCodeMethodIDL;
import com.bytedance.ai.bridge.service.IHostScanCodeDepend;
import com.bytedance.ai.bridge.service.ScanCodeRequest;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t3.a2;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/ScanCodeMethod;", "Lcom/bytedance/ai/bridge/device/scan/AbsScanCodeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/scan/AbsScanCodeMethodIDL$ScanCodeParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/scan/AbsScanCodeMethodIDL$ScanCodeResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCodeMethod extends AbsScanCodeMethodIDL {

    public static final class a {
    }

    static {
    }

    public ScanCodeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsScanCodeMethodIDL.a r103 = (AbsScanCodeMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        g r104 = g.f37637a;
        StringBuilder r105 = new StringBuilder("call start, onlyFromCamera=");
        r105.append(r103.getOnlyFromCamera());
        r105.append(", appletId=");
        a0 r106 = r100.getContainerContext();
        List r107 = null;
        if (r106 == null) goto L5;
        String r108 = r106.getAppletId();
    L6:
        r105.append(r108);
        r104.i("AISDK_JSB_ScanCodeMethod", r105.toString());
        IHostScanCodeDepend r109 = r4.a.f535988o;
        if (r109 != null) goto L9;
        StringBuilder r110 = new StringBuilder("call failed, errNo=");
        f3.a r111 = f3.a.f475266g;
        r110.append(r111.f475285a);
        r110.append(", msg=HostScanCodeDepend is null");
        r104.e("AISDK_JSB_ScanCodeMethod", r110.toString());
        h.a.a(r102, "HostScanCodeDepend is null", r111, null, 10);
        return;
    L9:
        String r112 = this.f35285a;
        Boolean r113 = r103.getOnlyFromCamera();
        List<String> r114 = r103.getScanType();
        if (r114 == null) goto L12;
        r107 = CollectionsKt.toList(r114);
    L12:
        if (r107 != null) goto L14;
        r107 = CollectionsKt.emptyList();
    L14:
        r109.scanCode(new ScanCodeRequest(r100, r112, r113, r107), new a2(r102));
        return;
    L5:
        r108 = null;
        goto L6
    }
}
