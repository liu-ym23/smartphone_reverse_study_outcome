package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.location.AbsStopLocationUpdateMethodIDL;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k implements f3.h<AbsStopLocationUpdateMethodIDL.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsStopLocationUpdateMethodIDL.a> f36025a;

    public k(f3.h<AbsStopLocationUpdateMethodIDL.a> r100) {
        this.f36025a = r100;
    }

    @Override // f3.h
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f36025a.a(r100, r101);
    }

    @Override // f3.h
    public final void b(ResultModel r100, String r101) {
        AbsStopLocationUpdateMethodIDL.a r102 = (AbsStopLocationUpdateMethodIDL.a) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        com.bytedance.ai.utils.g.f37637a.i("AISDK_JSB_StopLocationUpdateMethod", "call success");
        this.f36025a.b(r102, r101);
    }

    @Override // f3.h
    public final void c(String r100, int r101, f3.a r102, JsonObject r103) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r102 != null) goto L5;
        r102 = f3.a.f475265f;
    L5:
        com.bytedance.ai.utils.g.f37637a.e("AISDK_JSB_StopLocationUpdateMethod", "call failed, errNo=" + r102.f475285a + ", msg=" + r100);
        this.f36025a.c(r100, r101, r102, r103);
    }
}
