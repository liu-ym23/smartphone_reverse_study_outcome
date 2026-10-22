package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.p1;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0017\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StartMapLocationMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapLocationIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapLocationIDL$StartLocationParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapLocationIDL$StartLocationResult;", "mapCoordinateType", "Lcom/larus/platform/model/CoordinateType;", "type", "", "(Ljava/lang/Integer;)Lcom/larus/platform/model/CoordinateType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartMapLocationMethod extends AbsStartMapLocationIDL {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191291a = null;

        static {
            int[] r100 = new int[LocationResult.values().length];
            r100[LocationResult.NOT_INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LocationResult.NO_PERMISSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f191291a = r100;
        }
    }

    static {
    }

    public StartMapLocationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r210, ParamModel r211, f3.h r212) {
        AbsStartMapLocationIDL.a r100 = (AbsStartMapLocationIDL.a) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        Integer r110 = r100.getMinInterval();     // Catch: Exception -> L34
        if (r110 == null) goto L6;
        int r111 = r110.intValue();     // Catch: Exception -> L34
    L7:
        long r112 = r111;
        Integer r113 = r100.getCoordinateType();     // Catch: Exception -> L34
        if (r113 != null) goto L11;
    L13:
        CoordinateType r114 = CoordinateType.GCJ_O2;     // Catch: Exception -> L34
    L14:
        String r115 = r100.getIdentifier();     // Catch: Exception -> L34
        String r116 = "";
        if (r115 == null) goto L19;
        r116 = r115;
    L19:
        int r117 = com.larus.navigation.api.c.f359656a;     // Catch: Exception -> L34
        com.larus.navigation.api.c.d("jsb_start_location", "handle: interval=" + r112 + "ms, coordType=" + r114 + ", identifier=" + r116);     // Catch: Exception -> L34
        int r101 = com.larus.navigation.api.j.f359662a;     // Catch: Exception -> L34
        StringBuilder r118 = new StringBuilder("interval=");     // Catch: Exception -> L34
        r118.append(r112);     // Catch: Exception -> L34
        r118.append("ms, coordType=");     // Catch: Exception -> L34
        r118.append(r114);     // Catch: Exception -> L34
        com.larus.navigation.api.j.a("flow.startMapLocation", r118.toString());     // Catch: Exception -> L34
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.startMapLocation] minInterval=" + r112 + "ms coordType=" + r114 + " rawMinInterval=" + r100.getMinInterval() + " rawCoordinateType=" + r100.getCoordinateType());     // Catch: Exception -> L34
        com.larus.platform.service.m r102 = com.larus.platform.service.m.f365762a;     // Catch: Exception -> L34
        p1 r103 = com.larus.platform.service.m.i();     // Catch: Exception -> L34
        if (r103 != null) goto L22;
        com.larus.navigation.api.c.b("jsb_start_location", "LocationService not available");     // Catch: Exception -> L34
        f3.h.a.a(r212, "location_service_not_available", null, null, 14);     // Catch: Exception -> L34
        return;
    L22:
        LocationResult r104 = r103.h(r112, r114, new g0(), r116, r100.getExtra());     // Catch: Exception -> L34
        if (r104 == LocationResult.SUCCESS) goto L32;
        int r105 = b.f191291a[r104.ordinal()];     // Catch: Exception -> L34
        if (r105 != 1) goto L27;
        String r106 = "location_sdk_not_initialized";
    L31:
        com.larus.navigation.api.c.b("jsb_start_location", "continuousLocate failed: code=" + r104 + " errId=" + r106);     // Catch: Exception -> L34
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.startMapLocation] code=" + r104 + " errId=" + r106);     // Catch: Exception -> L34
        f3.h.a.a(r212, r106, null, null, 14);     // Catch: Exception -> L34
        return;
    L27:
        if (r105 == 2) goto L29;
        r106 = "location_start_failed: " + r104.getMessage();     // Catch: Exception -> L34
        goto L31
    L29:
        r106 = "no_location_permission";
        goto L31
    L32:
        Intrinsics.checkNotNullParameter(AbsStartMapLocationIDL.b.class, "<this>");     // Catch: Exception -> L34
        BaseModel r107 = k3.c.a(AbsStartMapLocationIDL.b.class);     // Catch: Exception -> L34
        ((AbsStartMapLocationIDL.b) r107).setSuccess(Boolean.TRUE);     // Catch: Exception -> L34
        r212.b((ResultModel) r107, "");     // Catch: Exception -> L34
        return;
    L11:
        if (r113.intValue() != 1) goto L13;
        r114 = CoordinateType.WGS_84;     // Catch: Exception -> L34
        goto L14
    L6:
        r111 = 1000;
    L34:
        e = move-exception;
        int r108 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("jsb_start_location", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.startMapLocation] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r109 = new StringBuilder("internal_error: ");
        r109.append(e.getMessage());
        f3.h.a.a(r212, r109.toString(), null, null, 14);
    }
}
