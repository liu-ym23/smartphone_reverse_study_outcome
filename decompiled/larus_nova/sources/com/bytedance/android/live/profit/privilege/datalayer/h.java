package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f88398a = null;

    static {
        f88398a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (com.bytedance.android.live.profit.privilege.model.danmu.a) r101.data;
    }
}
