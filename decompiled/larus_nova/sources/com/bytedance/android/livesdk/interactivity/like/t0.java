package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t0<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f137705a = null;

    static {
        f137705a = new t0();
    }

    public t0() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        Integer r102 = (Integer) r100;
        Response r103 = (Response) r101;
        Intrinsics.checkNotNullParameter(r102, "t1");
        Intrinsics.checkNotNullParameter(r103, "t2");
        return new Pair(r102, r103);
    }
}
