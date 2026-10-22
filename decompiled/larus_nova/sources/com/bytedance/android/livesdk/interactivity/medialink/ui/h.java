package com.bytedance.android.livesdk.interactivity.medialink.ui;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f138283a = null;

    static {
        f138283a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        return (IBaseUser) r101.data;
    }
}
