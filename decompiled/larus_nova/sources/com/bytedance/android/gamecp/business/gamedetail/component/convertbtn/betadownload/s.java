package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import com.bytedance.android.gamecp.business.gamedetail.base.model.AcquireBetaTestQualificationResponse;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f54042a = null;

    static {
        f54042a = new s();
    }

    public s() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        Pair r102 = (Pair) r100;
        AcquireBetaTestQualificationResponse r103 = (AcquireBetaTestQualificationResponse) r101;
        Intrinsics.checkNotNullParameter(r102, "orderGame");
        Intrinsics.checkNotNullParameter(r103, "acquireQualification");
        return new Pair(r102, r103);
    }
}
