package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f87380a = null;

    static {
        f87380a = new f();
    }

    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (n) r101.data;
    }
}
