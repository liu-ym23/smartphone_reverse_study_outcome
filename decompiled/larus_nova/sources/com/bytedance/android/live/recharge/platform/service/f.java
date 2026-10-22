package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.platform.model.DiamondExtraListResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f90298a = null;

    static {
        f90298a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (DiamondExtraListResult) r101.data;
    }
}
