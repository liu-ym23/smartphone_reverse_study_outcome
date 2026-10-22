package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T> implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f60838a;

    public i(List<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        this.f60838a = r100;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Iterator<T> r103 = this.f60838a.iterator();
        Object r104 = null;
    L4:
        if (r103.hasNext() == false) goto L16;
        T r105 = r103.next();
        if (r102 == null) goto L8;
        Integer r106 = Integer.valueOf(r102.length);
    L10:
        if (r106 == null) goto L11;
        if (r106.intValue() == 1) goto L14;
        r104 = r101.invoke(r105, new Object[]{r102});
        goto L4
    L14:
        r104 = r101.invoke(r105, new Object[]{r102[0]});
        goto L4
    L11:
        r104 = r101.invoke(r105, new Object[0]);
        goto L4
    L8:
        r106 = null;
        goto L10
    L16:
        return r104;
    }
}
