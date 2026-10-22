package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.tasm.LynxError;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsAppletRequestMethodIDL.b> f35631a;

    public a(f3.h<AbsAppletRequestMethodIDL.b> r100) {
        this.f35631a = r100;
    }

    @Override // b4.h
    public final void b(Object r100, Map<String, String> r101, Integer r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "responseHeader");
        f3.h<AbsAppletRequestMethodIDL.b> r104 = this.f35631a;
        BaseModel r105 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.b.class));
        AbsAppletRequestMethodIDL.b r106 = (AbsAppletRequestMethodIDL.b) r105;
        if (r102 != null) goto L6;
        r102 = -1;
    L6:
        r106.setHttpCode(r102);
        r106.setClientCode(Integer.valueOf(r103));
        r106.setHeader(r101);
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        r106.setResponse(r100);
        f3.h.a.b(r104, (ResultModel) r105);
    }

    @Override // b4.h
    public final void c(Integer r100, Map<String, String> r101, Throwable r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        if (r100 == null) goto L5;
        int r104 = r100.intValue();
    L6:
        f3.h<AbsAppletRequestMethodIDL.b> r105 = this.f35631a;
        String r106 = "Request failed, httpCode: " + r104 + ", clientCode:" + r103 + ", message: " + r102.getMessage();
        AbsAppletRequestMethodIDL.b r107 = (AbsAppletRequestMethodIDL.b) k3.a.b(Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.b.class));
        r107.setHttpCode(Integer.valueOf(r104));
        r107.setClientCode(Integer.valueOf(r103));
        r107.setHeader(r101);
        Unit r108 = Unit.INSTANCE;
        f3.h.a.a(r105, r106, null, r107.toJson(), 6);
        return;
    L5:
        r104 = -408;
        goto L6
    }

    @Override // b4.h
    public final void a(String r100, Map<String, String> r101, Throwable r102, Integer r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "base64Body");
        Intrinsics.checkNotNullParameter(r101, "responseHeader");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        f3.h<AbsAppletRequestMethodIDL.b> r105 = this.f35631a;
        BaseModel r106 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.b.class));
        AbsAppletRequestMethodIDL.b r107 = (AbsAppletRequestMethodIDL.b) r106;
        if (r103 != null) goto L6;
        r103 = -1;
    L6:
        r107.setHttpCode(r103);
        r107.setClientCode(Integer.valueOf(r104));
        r107.setHeader(r101);
        r107.setResponse(r100);
        r107.setResponseType(TTVideoEngineInterface.PLAY_API_KEY_BASE64);
        f3.h.a.b(r105, (ResultModel) r106);
    }
}
