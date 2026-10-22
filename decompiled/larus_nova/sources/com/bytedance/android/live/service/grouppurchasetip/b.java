package com.bytedance.android.live.service.grouppurchasetip;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f100869a = null;

    static {
        f100869a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (IBaseUser) r101.data;
    }
}
