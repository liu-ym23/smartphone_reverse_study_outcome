package com.bytedance.android.livedress.impl;

import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class PbDecodeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f102884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PbDecodeService f102885b = null;

    public PbDecodeService() {
    }

    static {
        f102885b = new PbDecodeService();
        f102884a = LazyKt.lazy(PbDecodeService$pbService$2.INSTANCE);
    }

    public static a a(byte[] r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "pbData");
        Intrinsics.checkNotNullParameter(r101, "definition");
        Intrinsics.checkNotNullParameter(r102, "typeName");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl((JsonObject) GsonHelper.get().fromJson(r101, JsonObject.class));     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L12;
        return new a("definition parse failed: " + r105);
    L12:
        if (Result.m9455isFailureimpl(r104) == false) goto L14;
        r104 = null;
    L14:
        JsonObject r106 = (JsonObject) r104;
        if (r106 == null) goto L17;
        t9.b r107 = ((t9.c) f102884a.getValue()).M0(r106);
        if (r107 == null) goto L26;
        if (r107.b(r102, null) == false) goto L26;
        return new a(true, r107.a(r100, r102).toString(), null);
    L26:
        return new a("invalid definition or cannot decode " + r102);
    L17:
        return new a("definition parse failed");
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
