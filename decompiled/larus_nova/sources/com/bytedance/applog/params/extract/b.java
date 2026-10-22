package com.bytedance.applog.params.extract;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f192567a;

    public b() {
        this.f192567a = new a();
    }

    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "cpId");
        Intrinsics.checkNotNullParameter(r101, "json");
        ParamsExtractDao.a r102 = new ParamsExtractDao.a(r100, r101, System.currentTimeMillis());
        this.f192567a.put(r100, r102);
    }
}
