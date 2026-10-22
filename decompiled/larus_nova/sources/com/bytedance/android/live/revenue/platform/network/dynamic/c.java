package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ stc.b f91516a;

    public c(stc.b r100) {
        this.f91516a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r101 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new Pair(this.f91516a.f543577a, r101);
    }
}
