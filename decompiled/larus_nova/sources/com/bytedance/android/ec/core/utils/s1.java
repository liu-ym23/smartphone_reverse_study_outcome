package com.bytedance.android.ec.core.utils;

import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s1<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f45718a;

    public s1(List r100) {
        this.f45718a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Object[] r101 = (Object[]) r100;
        Intrinsics.checkNotNullParameter(r101, "rets");
        Iterator<T> r102 = ArraysKt.sortedWith(r101, new r1()).iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        T r103 = r102.next();
        if ((r103 instanceof m1) == true) goto L8;
        r103 = (T) null;
    L8:
        m1 r104 = r103;
        if (r104 == null) goto L4;
        p1.f45667c.d(r104.f45646c, r104.f45645b);
        this.f45718a.add(r104.f45645b);
        goto L4
    L12:
        return Unit.INSTANCE;
    }
}
