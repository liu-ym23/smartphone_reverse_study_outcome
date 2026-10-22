package com.bytedance.android.live.profit.util;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f89105a;

    public i(j r100) {
        this.f89105a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "resp");
        j r102 = this.f89105a;
        long r103 = 0;
        if (r102.f89108c.element != 0) goto L9;
        Ref.LongRef r104 = r102.f89109d;
        py.j r105 = ((IBaseUser) r101.data).getFollowInfo();
        if (r105 == null) goto L7;
        long r106 = r105.getFollowerCount();
    L8:
        r104.element = r106;
        goto L9
    L7:
        r106 = 0;
    L9:
        py.j r107 = ((IBaseUser) r101.data).getFollowInfo();
        if (r107 == null) goto L12;
        r103 = r107.getFollowerCount();
    L12:
        j r108 = this.f89105a;
        long r109 = r108.f89109d.element;
        Ref.IntRef r110 = r108.f89110e;
        int r111 = r110.element;
        long r112 = r103 - r109;
        if (r112 <= r111) goto L16;
        r111 = (int) r112;
    L16:
        r110.element = r111;
        r108.f89108c.element++;
        return Integer.valueOf(r111);
    }
}
