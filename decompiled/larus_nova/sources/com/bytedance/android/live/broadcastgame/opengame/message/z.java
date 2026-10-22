package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f60288a = null;

    static {
        f60288a = new z();
    }

    public z() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.statusCode != 0) goto L6;
        return new com.bytedance.android.live.broadcastgame.j0();
    L6:
        return new com.bytedance.android.live.broadcastgame.j0(1, r101.error.message);
    }
}
