package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements r4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsGetLocationMethodIDL.b> f36001a;

    public c(f3.h<AbsGetLocationMethodIDL.b> r100) {
        this.f36001a = r100;
    }

    @Override // r4.c
    public final void b(r4.d r100) {
        Intrinsics.checkNotNullParameter(r100, "locationResult");
        com.bytedance.ai.utils.g.f37637a.i("AISDK_JSB_GetLocationMethod", "call success");
        f3.h<AbsGetLocationMethodIDL.b> r101 = this.f36001a;
        Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.b.class, "<this>");
        BaseModel r102 = k3.c.a(AbsGetLocationMethodIDL.b.class);
        AbsGetLocationMethodIDL.b r103 = (AbsGetLocationMethodIDL.b) r102;
        r103.setTimestamp(r100.f535994c);
        r103.setLatitude(Double.valueOf(r100.f535992a));
        r103.setLongitude(Double.valueOf(r100.f535993b));
        r103.setSpeed(r100.f535995d);
        r103.setAccuracy(r100.f535996e);
        Boolean r104 = r100.f535997f;
        if (r104 == null) goto L5;
        r103.setLightLocation(Boolean.valueOf(r104.booleanValue()));
    L5:
        f3.h.a.b(r101, (ResultModel) r102);
    }

    @Override // r4.c
    public final void a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        com.bytedance.ai.utils.g r102 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r103 = new StringBuilder("call failed, errNo=");
        f3.a r104 = f3.a.f475265f;
        r103.append(r104.f475285a);
        r103.append(", msg=");
        r103.append(r100);
        r103.append(", errorCode: ");
        r103.append(r101);
        r102.e("AISDK_JSB_GetLocationMethod", r103.toString());
        f3.h<AbsGetLocationMethodIDL.b> r105 = this.f36001a;
        JsonObject r106 = new JsonObject();
        r106.addProperty("errMsg", r100);
        r106.addProperty("errCode", Integer.valueOf(r101));
        Unit r107 = Unit.INSTANCE;
        f3.h.a.a(r105, r100, r104, r106, 2);
    }
}
