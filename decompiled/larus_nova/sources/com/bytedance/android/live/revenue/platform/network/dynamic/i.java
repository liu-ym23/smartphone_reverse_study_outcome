package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f91526a = null;

    static {
        f91526a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r101 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f458186g;
    }
}
