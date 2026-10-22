package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f81994a;

    public u(Function1 r100) {
        this.f81994a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        this.f81994a.invoke((IUser) r101.data);
    }
}
