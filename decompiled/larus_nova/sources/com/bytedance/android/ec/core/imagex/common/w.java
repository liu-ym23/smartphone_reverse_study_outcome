package com.bytedance.android.ec.core.imagex.common;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<T> f44663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f44664b;

    public w(T r100) {
        this.f44664b = r100;
        LinkedHashSet r101 = new LinkedHashSet();
        this.f44663a = r101;
        if (r100 == null) goto L6;
        r101.add(r100);
        return;
    }

    public final void a(Function1<? super T, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Iterator<T> r101 = this.f44663a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        T r102 = r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r100.invoke(r102);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    }
}
