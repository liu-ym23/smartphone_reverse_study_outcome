package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable<S> f126603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<S, e, Unit> f126604b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Observable<S> r100, Function2<? super S, ? super e, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "emitter");
        this.f126603a = r100;
        this.f126604b = r101;
    }
}
