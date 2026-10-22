package com.bytedance.ai.bridge.method.sqlite;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements f3.h<AbsExecuteSqliteActionMethodIDL.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> f35916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> f35917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f35918c;

    @Override // f3.h
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f35916a.a(r100, r101);
    }

    @Override // f3.h
    public final void c(String r100, int r101, f3.a r102, JsonObject r103) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f35916a.c(r100, r101, r102, r103);
    }

    public i(f3.h<AbsExecuteSqliteActionMethodIDL.b> r100, String r101) {
        this.f35917b = r100;
        this.f35918c = r101;
        this.f35916a = r100;
    }

    @Override // f3.h
    public final void b(ResultModel r100, String r101) {
        AbsExecuteSqliteActionMethodIDL.b r102 = (AbsExecuteSqliteActionMethodIDL.b) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        SqliteActionManager.f35892b.remove(this.f35918c);
        f3.h.a.b(this.f35917b, r102);
    }
}
