package com.bytedance.ai.bridge.method.system;

import android.content.Context;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.window.AbsGetWindowInfoMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import f3.h;
import f4.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\f\u0010\u0013\u001a\u00020\n*\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetWindowInfoMethod;", "Lcom/bytedance/ai/bridge/system/window/AbsGetWindowInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/window/AbsGetWindowInfoMethodIDL$GetWindowInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/window/AbsGetWindowInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "toResultModel", "Lcom/bytedance/ai/bridge/method/system/WindowInfoHelper$WindowInfo;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetWindowInfoMethod extends AbsGetWindowInfoMethodIDL {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f35940c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f35941b;

    public static final class a {
    }

    static {
    }

    public GetWindowInfoMethod() {
        this.f35941b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.f35941b;
    }

    public static AbsGetWindowInfoMethodIDL.b b(c.C0701c r100) {
        Intrinsics.checkNotNullParameter(AbsGetWindowInfoMethodIDL.b.class, "<this>");
        AbsGetWindowInfoMethodIDL.b r101 = (AbsGetWindowInfoMethodIDL.b) k3.c.a(AbsGetWindowInfoMethodIDL.b.class);
        r101.setPixelRatio(r100.f35967a);
        r101.setScreenWidth(r100.f35968b);
        r101.setScreenHeight(r100.f35969c);
        r101.setWindowWidth(r100.f35970d);
        r101.setWindowHeight(r100.f35971e);
        r101.setStatusBarHeight(r100.f35972f);
        c.b r102 = r100.f35973g;
        r101.setSafeArea(new AbsGetWindowInfoMethodIDL.WindowSafeArea(r102.f35961a, r102.f35962b, r102.f35963c, r102.f35964d, r102.f35965e, r102.f35966f));
        r101.setScreenTop(r100.f35974h);
        return r101;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final com.bytedance.ai.bridge.core.a handleSync(e3.d r100, ParamModel r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetWindowInfoMethodIDL.a) r110, "params");
        g r111 = g.f37637a;
        StringBuilder r101 = new StringBuilder("call start, appletId=");
        a0 r102 = r100.getContainerContext();
        Context r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getAppletId();
    L6:
        r101.append(r104);
        r111.i("AISDK_JSB_GetWindowInfoMethod", r101.toString());
        int r105 = c.f35954a;
        View r106 = r100.getEngineView();
        if (r106 == null) goto L9;
        r103 = r106.getContext();
    L9:
        c.C0701c r107 = c.d(r103);
        if (r107 != null) goto L12;
        StringBuilder r108 = new StringBuilder("call failed, errNo=");
        f3.a r109 = f3.a.f475265f;
        r108.append(r109.f475285a);
        r108.append(", msg=context not provided in host");
        r111.e("AISDK_JSB_GetWindowInfoMethod", r108.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "context not provided in host", null, r109, 21);
    L12:
        r111.i("AISDK_JSB_GetWindowInfoMethod", "call success");
        return new com.bytedance.ai.bridge.core.a.c(b(r107));
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, final h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetWindowInfoMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        g r103 = g.f37637a;
        StringBuilder r104 = new StringBuilder("call start, appletId=");
        a0 r105 = r100.getContainerContext();
        Context r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.getAppletId();
    L6:
        r104.append(r107);
        r103.i("AISDK_JSB_GetWindowInfoMethod", r104.toString());
        int r108 = c.f35954a;
        View r109 = r100.getEngineView();
        if (r109 == null) goto L9;
        r106 = r109.getContext();
    L9:
        c.c(r106, new f(r102, this));
        return;
    L5:
        r107 = null;
        goto L6
    }
}
