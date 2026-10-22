package com.bytedance.android.live.schema.helper;

import com.bytedance.keva.Keva;
import io.reactivex.Completable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Keva f100514a;

    public b(Keva r100) {
        this.f100514a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "timestamp");
        final long r102 = System.currentTimeMillis() / ((long) 1000);
        long r103 = TimeUnit.DAYS.toSeconds(1);
        if ((r102 - r101.longValue()) <= r103) goto L6;
        return Completable.fromCallable(new LynxCacheHelper$evictCacheIfNeed$1$1(this, r102));
    L6:
        return Completable.complete();
    }
}
