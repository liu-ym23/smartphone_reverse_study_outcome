package com.bytedance.android.live.profit.util;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.user.a f89106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f89107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f89108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f89109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f89110e;

    public j(com.bytedance.android.livesdk.revenue.service.user.a r100, HashMap r101, Ref.IntRef r102, Ref.LongRef r103, Ref.IntRef r104) {
        this.f89106a = r100;
        this.f89107b = r101;
        this.f89108c = r102;
        this.f89109d = r103;
        this.f89110e = r104;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        return this.f89106a.W1(this.f89107b).toObservable().onErrorResumeNext(Observable.empty()).map(new i(this));
    }
}
