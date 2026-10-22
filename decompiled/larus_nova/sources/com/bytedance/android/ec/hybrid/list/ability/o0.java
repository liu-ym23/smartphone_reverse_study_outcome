package com.bytedance.android.ec.hybrid.list.ability;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o0 implements n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f46996b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends Object> f46997a;

    public static final class a {
    }

    static {
        f46996b = new Gson();
    }

    public o0(Class<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        this.f46997a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.n0
    public final Object a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(f46996b.fromJson(r100, this.f46997a));     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L10;
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.k.a.f47501b, "modelTransform failed, target class is ".concat(this.f46997a.getName()));
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        if (r102 != null) goto L15;
        return r100;
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
