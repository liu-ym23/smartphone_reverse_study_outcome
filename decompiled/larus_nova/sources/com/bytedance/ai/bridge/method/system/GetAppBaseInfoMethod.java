package com.bytedance.ai.bridge.method.system;

import android.content.Context;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ai.bridge.system.appBaseInfo.AbsGetAppBaseInfoMethodIDL;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetAppBaseInfoMethod;", "Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL$GetAppBaseInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "toTheme", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAppBaseInfoMethod extends AbsGetAppBaseInfoMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f35936b;

    public GetAppBaseInfoMethod() {
        this.f35936b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.f35936b;
    }

    public static com.bytedance.ai.bridge.core.a.c b(e3.d r100, AbsGetAppBaseInfoMethodIDL.a r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        IHostContextDepend r102 = r4.a.f535974a;
        Intrinsics.checkNotNullParameter(AbsGetAppBaseInfoMethodIDL.b.class, "<this>");
        BaseModel r103 = k3.c.a(AbsGetAppBaseInfoMethodIDL.b.class);
        AbsGetAppBaseInfoMethodIDL.b r104 = (AbsGetAppBaseInfoMethodIDL.b) r103;
        r104.setSDKVersion("1.15.0-rc.7");
        r104.setEnableDebug(Boolean.valueOf(k.f475104b));
        AbsGetAppBaseInfoMethodIDL.AppBaseInfoHost r105 = null;
        if (r102 == null) goto L5;
        String r106 = r102.getLanguage();
    L6:
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        if (r106.length() != 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        r106 = "zh";
    L14:
        r104.setLanguage(r106);
        if (r102 == null) goto L17;
        String r108 = r102.getVersionName();
    L18:
        r104.setVersion(r108);
        View r109 = r100.getEngineView();
        if (r109 == null) goto L21;
        Context r110 = r109.getContext();
    L22:
        r104.setTheme(t2.a.a(r110));
        if (r102 == null) goto L25;
        r105 = new AbsGetAppBaseInfoMethodIDL.AppBaseInfoHost(String.valueOf(r102.getAppId()));
    L25:
        r104.setHost(r105);
        return new com.bytedance.ai.bridge.core.a.c(r103);
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L11:
        r107 = false;
        goto L12
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(e3.d r100, ParamModel r101) {
        return b(r100, (AbsGetAppBaseInfoMethodIDL.a) r101);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsGetAppBaseInfoMethodIDL.a r103 = (AbsGetAppBaseInfoMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r100, r103), r102);
    }
}
