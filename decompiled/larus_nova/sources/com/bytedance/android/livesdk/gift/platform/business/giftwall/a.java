package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.google.gson.JsonObject;
import io.reactivex.functions.BiFunction;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f129640a = null;

    static {
        f129640a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        JsonObject r102 = (JsonObject) r100;
        JsonObject r103 = (JsonObject) r101;
        Intrinsics.checkNotNullParameter(r102, "home");
        Intrinsics.checkNotNullParameter(r103, "rare");
        return TuplesKt.to(r102, r103);
    }
}
