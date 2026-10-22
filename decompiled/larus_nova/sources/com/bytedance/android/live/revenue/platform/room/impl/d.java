package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f91607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f91608b;

    public d(Class r100, String r101) {
        this.f91607a = r100;
        this.f91608b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        Intrinsics.checkNotNullParameter(r101, "optional");
        com.bytedance.android.livesdk.revenue.message.c r102 = (com.bytedance.android.livesdk.revenue.message.c) sh6.c.b(r101);
        if (r102 != null) goto L7;
        Observable<tlc.d> r103 = BaseRoomMessageService.f91573j;
        if (r103 == null) goto L9;
        return r103;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<T>");
    L7:
        return RxCompatKt.c(Observable.create(new c(this, r102)));
    }
}
