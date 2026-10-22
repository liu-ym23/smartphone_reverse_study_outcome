package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.location.AbsOpenLocationMethodIDL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/OpenLocationMethod;", "Lcom/bytedance/ai/bridge/system/location/AbsOpenLocationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/location/AbsOpenLocationMethodIDL$OpenLocationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/location/AbsOpenLocationMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenLocationMethod extends AbsOpenLocationMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35995b = 0;

    public static final class a {
    }

    static {
    }

    public OpenLocationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r110, ParamModel r111, final f3.h r112) {
        final AbsOpenLocationMethodIDL.a r113 = (AbsOpenLocationMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        double r100 = r113.getLatitude();
        boolean r101 = true;
        if ((-90.0d) <= r100) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L11;
        int r114 = LocationAuthorization.f35985a;
        f3.h.a.a(r112, "invalid latitude", null, LocationAuthorization.b("invalid latitude", 0), 6);
        return;
    L11:
        double r103 = r113.getLongitude();
        if ((-180.0d) <= r103) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == true) goto L19;
        int r115 = LocationAuthorization.f35985a;
        f3.h.a.a(r112, "invalid longitude", null, LocationAuthorization.b("invalid longitude", 0), 6);
        return;
    L19:
        int r105 = r113.getScale();
        if (5 <= r105) goto L22;
    L24:
        r101 = false;
    L25:
        if (r101 == true) goto L27;
        int r116 = LocationAuthorization.f35985a;
        f3.h.a.a(r112, "invalid scale", null, LocationAuthorization.b("invalid scale", 0), 6);
        return;
    L27:
        int r106 = LocationAuthorization.f35985a;
        Function1 r107 = new h(this, r110, r113, r112);
        LocationAuthorization.a(r110, r112, Scope.userLocation, "doubao.getLocation.permission_check.call", r107);
        return;
    L22:
        if (r105 >= 19) goto L24;
    L14:
        if (r103 > 180.0d) goto L16;
        r104 = true;
        goto L17
    L5:
        if (r100 > 90.0d) goto L7;
        r102 = true;
        goto L9
    }
}
