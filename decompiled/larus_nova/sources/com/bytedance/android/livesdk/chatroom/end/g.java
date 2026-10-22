package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.x1;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f106066a = null;

    static {
        f106066a = new g();
    }

    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        Response r102 = (Response) r100;
        Response r103 = (Response) r101;
        Intrinsics.checkNotNullParameter(r102, "endInfo");
        Intrinsics.checkNotNullParameter(r103, "tabliveData");
        x1 r104 = (x1) r102.data;
        if (r104 == null) goto L5;
        r104.f106985a = (com.bytedance.android.livesdk.chatroom.model.c0) r103.data;
    L5:
        return r102;
    }
}
