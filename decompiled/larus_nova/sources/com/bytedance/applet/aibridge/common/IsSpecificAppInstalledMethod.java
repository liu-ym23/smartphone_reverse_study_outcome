package com.bytedance.applet.aibridge.common;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.utils.z0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/common/IsSpecificAppInstalledMethod;", "Lcom/bytedance/applet/aibridge/common/AbsIsSpecificAppInstalledMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/common/AbsIsSpecificAppInstalledMethodIDL$IsSpecificAppInstalledParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/common/AbsIsSpecificAppInstalledMethodIDL$IsSpecificAppInstalledResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsSpecificAppInstalledMethod extends AbsIsSpecificAppInstalledMethodIDL {
    public IsSpecificAppInstalledMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsIsSpecificAppInstalledMethodIDL.a r103 = (AbsIsSpecificAppInstalledMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getAppName();
        if (Intrinsics.areEqual(r104, AppPlatform.DouYin.getAppName()) == false) goto L6;
        boolean r105 = z0.a("com.ss.android.ugc.aweme");
        Intrinsics.checkNotNullParameter(AbsIsSpecificAppInstalledMethodIDL.b.class, "<this>");
        BaseModel r106 = c.a(AbsIsSpecificAppInstalledMethodIDL.b.class);
        ((AbsIsSpecificAppInstalledMethodIDL.b) r106).setInstalled(r105);
        r102.b((ResultModel) r106, "");
        return;
    L6:
        if (Intrinsics.areEqual(r104, AppPlatform.Luna.getAppName()) == false) goto L9;
        boolean r107 = z0.a("com.luna.music");
        Intrinsics.checkNotNullParameter(AbsIsSpecificAppInstalledMethodIDL.b.class, "<this>");
        BaseModel r108 = c.a(AbsIsSpecificAppInstalledMethodIDL.b.class);
        ((AbsIsSpecificAppInstalledMethodIDL.b) r108).setInstalled(r107);
        r102.b((ResultModel) r108, "");
        return;
    L9:
        if (Intrinsics.areEqual(r104, AppPlatform.QQMusic.getAppName()) == false) goto L13;
        boolean r109 = z0.a("com.tencent.qqmusic");
        Intrinsics.checkNotNullParameter(AbsIsSpecificAppInstalledMethodIDL.b.class, "<this>");
        BaseModel r110 = c.a(AbsIsSpecificAppInstalledMethodIDL.b.class);
        ((AbsIsSpecificAppInstalledMethodIDL.b) r110).setInstalled(r109);
        r102.b((ResultModel) r110, "");
        return;
    L13:
        throw new IllegalStateException("not support this app".toString());
    }
}
