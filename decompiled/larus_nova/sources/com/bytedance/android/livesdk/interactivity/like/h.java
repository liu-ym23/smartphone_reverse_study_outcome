package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f137674a;

    public h(d r100) {
        this.f137674a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        ALogger.i("DiggHandler", "interval map, current diggCount: " + this.f137674a.f137654b);
        d r101 = this.f137674a;
        int r102 = r101.f137654b;
        r101.f137654b = 0;
        return Integer.valueOf(r102);
    }
}
