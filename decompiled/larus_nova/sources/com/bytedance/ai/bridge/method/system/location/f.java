package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.location.AbsStartLocationUpdateMethodIDL;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements f3.h<AbsStartLocationUpdateMethodIDL.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsStartLocationUpdateMethodIDL.a> f36015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationUpdateManager f36016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f36017c;

    @Override // f3.h
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
    }

    @Override // f3.h
    public final void b(ResultModel r100, String r101) {
        AbsStartLocationUpdateMethodIDL.a r102 = (AbsStartLocationUpdateMethodIDL.a) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f36015a.b(r102, r101);
    }

    public f(j r100, LocationUpdateManager r101, int r102) {
        this.f36015a = r100;
        this.f36016b = r101;
        this.f36017c = r102;
    }

    @Override // f3.h
    public final void c(String r100, int r101, f3.a r102, JsonObject r103) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f36016b.d(this.f36017c);
        this.f36015a.c(r100, r101, r102, r103);
    }
}
