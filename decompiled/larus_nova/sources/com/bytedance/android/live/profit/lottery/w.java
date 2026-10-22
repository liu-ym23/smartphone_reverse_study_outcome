package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class w<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f88227a = null;

    static {
        f88227a = new w();
    }

    public w() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "res");
        v.c r102 = v.f88217a;
        com.bytedance.android.live.profit.lottery.model.a r103 = (com.bytedance.android.live.profit.lottery.model.a) r101.data;
        int r104 = r103.a();
        if (r104 != 1) goto L5;
        ParticipateStatus r105 = ParticipateStatus.NOTPARTICIPATED;
    L12:
        s r106 = new s(r105, r103.b());
        if (r106.f88186a == ParticipateStatus.UNKNOWN) goto L16;
        return r106;
    L16:
        throw new Throwable("unknown");
    L5:
        if (r104 != 2) goto L7;
        r105 = ParticipateStatus.PARTICIPATEINSUCCESS;
        goto L12
    L7:
        if (r104 == 3) goto L9;
        r105 = ParticipateStatus.UNKNOWN;
        goto L12
    L9:
        r105 = ParticipateStatus.ISLUCKY;
        goto L12
    }
}
