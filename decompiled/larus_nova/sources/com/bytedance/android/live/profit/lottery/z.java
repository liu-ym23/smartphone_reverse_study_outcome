package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class z<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f88264a = null;

    static {
        f88264a = new z();
    }

    public z() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        com.bytedance.android.live.profit.lottery.model.c r102 = (com.bytedance.android.live.profit.lottery.model.c) r101.data;
        if (r102 == null) goto L9;
        List<com.bytedance.android.live.profit.lottery.model.b> r103 = r102.a();
        if (r103 == null) goto L9;
        if (r103.isEmpty() == true) goto L9;
        boolean r104 = true;
    L11:
        return Boolean.valueOf(r104);
    L9:
        r104 = false;
        goto L11
    }
}
