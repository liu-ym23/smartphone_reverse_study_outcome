package com.android.ttcjpaysdk.base.ktextension;

import com.bytedance.android.ec.core.event.a;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\r\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0005J\b\u0010\r\u001a\u0004\u0018\u00010\u0007J5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0086\bø\u0001\u0000J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140\u0010H\u0086\bø\u0001\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/CJResult;", "R", "", "r", "isSuccess", "", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/Object;ZLjava/lang/Throwable;)V", "Ljava/lang/Object;", "getR", "()Ljava/lang/Object;", "getResult", "getThrowable", "onFailure", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", a.KEY_EXCEPTION, "", "onSuccess", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJResult<R> {
    private final boolean isSuccess;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final R f29347r;
    private final Throwable throwable;

    public final R getR() {
        return this.f29347r;
    }

    public final boolean getResult() {
        return this.isSuccess;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final CJResult<R> onFailure(Function1<? super Throwable, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Throwable r101 = getThrowable();
        if (r101 != null) goto L6;
        r101 = new Throwable();
    L6:
        if ((!getResult()) == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L11;
        r100.invoke(r101);
    L11:
        return this;
    }

    public final CJResult<R> onSuccess(Function1<? super R, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        R r101 = getR();
        if (r101 != null) goto L5;
    L10:
        return this;
    L5:
        if (getResult() == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        r100.invoke(r101);
        goto L10
    }

    public CJResult(R r100, boolean r101, Throwable r102) {
        this.f29347r = r100;
        this.isSuccess = r101;
        this.throwable = r102;
    }
}
