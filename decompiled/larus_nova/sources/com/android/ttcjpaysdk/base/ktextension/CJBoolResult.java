package com.android.ttcjpaysdk.base.ktextension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u0005J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH\u0086\bø\u0001\u0000J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH\u0086\bø\u0001\u0000R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/CJBoolResult;", "R", "", "r", "result", "", "(Ljava/lang/Object;Z)V", "Ljava/lang/Object;", "getR", "()Ljava/lang/Object;", "getResult", "onFalse", "action", "Lkotlin/Function1;", "", "onTrue", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJBoolResult<R> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final R f29346r;
    private final boolean result;

    public final R getR() {
        return this.f29346r;
    }

    public final boolean getResult() {
        return this.result;
    }

    public final CJBoolResult<R> onFalse(Function1<? super R, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (getResult() == true) goto L5;
        r100.invoke(getR());
    L5:
        return this;
    }

    public final CJBoolResult<R> onTrue(Function1<? super R, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (getResult() == false) goto L5;
        r100.invoke(getR());
    L5:
        return this;
    }

    public CJBoolResult(R r100, boolean r101) {
        this.f29346r = r100;
        this.result = r101;
    }
}
