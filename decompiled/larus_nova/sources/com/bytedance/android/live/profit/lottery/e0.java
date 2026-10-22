package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f88061a;

    public e0(boolean r100) {
        this.f88061a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        k r102 = ((f) r101.data).getLotteryInfo();
        t r103 = null;
        if (r102 == null) goto L5;
        v.c r104 = v.f88217a;
        t r105 = v.b(r102, 0);
    L6:
        f3.a(r105);
        if (r105 == null) goto L20;
        if (this.f88061a == false) goto L13;
        boolean r106 = true;
        if (r105.f88195b == 1) goto L13;
    L14:
        if (r106 == true) goto L16;
        r103 = r105;
    L16:
        if (r103 == null) goto L20;
        sh6.b r107 = sh6.c.a(r103);
        if (r107 == null) goto L20;
        return r107;
    L13:
        r106 = false;
    L20:
        return sh6.a.f541970a;
    L5:
        r105 = null;
        goto L6
    }
}
