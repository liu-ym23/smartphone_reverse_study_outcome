package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsRequestMethodIDL;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.lynx.tasm.LynxError;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements b4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsRequestMethodIDL.b> f35757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RequestMethod f35758b;

    public j(f3.h<AbsRequestMethodIDL.b> r100, RequestMethod r101) {
        this.f35757a = r100;
        this.f35758b = r101;
    }

    @Override // b4.h
    public final void b(Object r100, Map<String, String> r101, Integer r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "responseHeader");
        com.bytedance.ai.utils.g r104 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r105 = new StringBuilder("call success, statusCode=");
        int r106 = -1;
        if (r102 == null) goto L5;
        int r107 = r102.intValue();
    L6:
        r105.append(r107);
        r104.d("AISDK_JSB_RequestMethod", r105.toString());
        f3.h<AbsRequestMethodIDL.b> r108 = this.f35757a;
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.b.class, "<this>");
        BaseModel r109 = k3.c.a(AbsRequestMethodIDL.b.class);
        AbsRequestMethodIDL.b r110 = (AbsRequestMethodIDL.b) r109;
        if (r102 == null) goto L9;
        r106 = r102.intValue();
    L9:
        r110.setStatusCode(r106);
        r110.setHeader(r101);
        r110.setData(r100);
        f3.h.a.b(r108, (ResultModel) r109);
        return;
    L5:
        r107 = -1;
        goto L6
    }

    @Override // b4.h
    public final void c(Integer r100, Map<String, String> r101, Throwable r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        RequestMethod r104 = this.f35758b;
        int r105 = RequestMethod.f35629b;
        r104.getClass();
        int r106 = -408;
        if ((r102 instanceof NetworkNotAvailabeException) == false) goto L5;
        f3.a r107 = f3.a.f475283x;
    L11:
        StringBuilder r108 = new StringBuilder("Request failed, httpCode: ");
        if (r100 == null) goto L14;
        int r109 = r100.intValue();
    L15:
        r108.append(r109);
        r108.append(", message: ");
        r108.append(r102.getMessage());
        String r110 = r108.toString();
        com.bytedance.ai.utils.g.f37637a.e("AISDK_JSB_RequestMethod", "call failed, errNo=" + r107.f475285a + ", msg=" + r107.f475286b + ", errorType=" + r102.getClass().getSimpleName());
        f3.h<AbsRequestMethodIDL.b> r111 = this.f35757a;
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.b.class, "<this>");
        AbsRequestMethodIDL.b r112 = (AbsRequestMethodIDL.b) k3.c.a(AbsRequestMethodIDL.b.class);
        if (r100 == null) goto L18;
        r106 = r100.intValue();
    L18:
        r112.setStatusCode(r106);
        r112.setHeader(r101);
        Unit r113 = Unit.INSTANCE;
        f3.h.a.a(r111, r110, r107, r112.toJson(), 2);
        return;
    L14:
        r109 = -408;
        goto L15
    L5:
        if (r100 != null) goto L8;
    L10:
        r107 = f3.a.f475284y;
        goto L11
    L8:
        if (r100.intValue() != (-408)) goto L10;
        r107 = f3.a.f475282w;
        goto L11
    }

    @Override // b4.h
    public final void a(String r100, Map<String, String> r101, Throwable r102, Integer r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "base64Body");
        Intrinsics.checkNotNullParameter(r101, "responseHeader");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        com.bytedance.ai.utils.g r105 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r106 = new StringBuilder("call success, statusCode=");
        int r107 = -1;
        if (r103 == null) goto L5;
        int r108 = r103.intValue();
    L6:
        r106.append(r108);
        r106.append(", responseType=base64");
        r105.d("AISDK_JSB_RequestMethod", r106.toString());
        f3.h<AbsRequestMethodIDL.b> r109 = this.f35757a;
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.b.class, "<this>");
        BaseModel r110 = k3.c.a(AbsRequestMethodIDL.b.class);
        AbsRequestMethodIDL.b r111 = (AbsRequestMethodIDL.b) r110;
        if (r103 == null) goto L9;
        r107 = r103.intValue();
    L9:
        r111.setStatusCode(r107);
        r111.setHeader(r101);
        r111.setData(r100);
        f3.h.a.b(r109, (ResultModel) r110);
        return;
    L5:
        r108 = -1;
        goto L6
    }
}
