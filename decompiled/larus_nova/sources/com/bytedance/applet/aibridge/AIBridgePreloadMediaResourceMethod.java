package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.k0;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.lynx.canvas.KryptonCamera;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgePreloadMediaResourceMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePreloadMediaResourceMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgePreloadMediaResourceMethodIDL$PreloadMediaResourceParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePreloadMediaResourceMethodIDL$PreloadMediaResourceResultModel;", "preloadUrl", "preloadViewModel", "Companion", "PreloadCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgePreloadMediaResourceMethod extends AbsAIBridgePreloadMediaResourceMethodIDL {

    public static final class a {
    }

    public static final class b implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> f190841a;

        public b(f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.f190841a = r100;
        }

        @Override // com.larus.platform.api.k0
        public final void a(yq9.c r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            int r101 = r100.f568867a;
            if (r101 != 2) goto L5;
            f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> r102 = this.f190841a;
            Intrinsics.checkNotNullParameter(AbsAIBridgePreloadMediaResourceMethodIDL.b.class, "<this>");
            f3.h.a.b(r102, (ResultModel) k3.c.a(AbsAIBridgePreloadMediaResourceMethodIDL.b.class));
            return;
        L5:
            if (r101 != 3) goto L7;
        L9:
            f3.h.a.a(this.f190841a, "preload fails with infoKey: " + r100.f568867a, null, null, 14);
            return;
        L7:
            if (r101 == 5) goto L9;
        }
    }

    static {
    }

    public AIBridgePreloadMediaResourceMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r110, f3.h r111) {
        AbsAIBridgePreloadMediaResourceMethodIDL.a r101 = (AbsAIBridgePreloadMediaResourceMethodIDL.a) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r102 = r101.getResourceType();
        boolean r112 = Intrinsics.areEqual(r102, "url");
        long r103 = LynxResourceModule.DEFAULT_MEDIA_SIZE;
        if (r112 == false) goto L12;
        Long r104 = r101.getPreloadSize();
        if (r104 == null) goto L7;
        r103 = r104.longValue();
    L7:
        Lazy r105 = q3.f365794a;
        z3 r106 = q3.a();
        if (r106 != null) goto L10;
        f3.h.a.a(r111, "getVideoControllerService fails", null, null, 14);
        return;
    L10:
        int r107 = d88.a.f467435a;
        r106.i(new yq9.d(d88.a.a(r101.getResource()), r103, r101.getResource()), new b(r111));
        return;
    L12:
        if (Intrinsics.areEqual(r102, "videoModel") == false) goto L24;
        Long r108 = r101.getPreloadSize();
        if (r108 == null) goto L16;
        long r109 = r108.longValue();
    L17:
        String r113 = r101.getResolution();
        if (r113 != null) goto L20;
        r113 = KryptonCamera.Config.RESOLUTION_MEDIUM;
    L20:
        String r114 = i.f191168a.k(r113);
        Lazy r115 = q3.f365794a;
        z3 r116 = q3.a();
        if (r116 != null) goto L23;
        f3.h.a.a(r111, "getVideoControllerService fails", null, null, 14);
        return;
    L23:
        r116.f(r101.getResource(), new k(r101, r111, r116, r114, r109));
        return;
    L16:
        r109 = 512000;
        goto L17
    L24:
        f3.h.a.a(r111, "wrong resourceType", null, null, 14);
    }
}
