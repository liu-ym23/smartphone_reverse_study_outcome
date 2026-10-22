package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class w<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f64625a = null;

    static {
        f64625a = new w();
    }

    public w() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        return (IBaseUser) r101.data;
    }
}
