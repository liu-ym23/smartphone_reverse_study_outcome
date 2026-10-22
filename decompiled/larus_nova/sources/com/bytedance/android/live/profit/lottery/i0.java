package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f88111a = null;

    static {
        f88111a = new i0();
    }

    public i0() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if ((r101 instanceof sh6.d) == false) goto L14;
        sh6.d r102 = (sh6.d) r101;
        t r103 = (t) r102.f541971a;
        int r104 = r103.f88195b;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L17;
        if (r104 == 5) goto L16;
        return v.b.C1348b.f88221a;
    L16:
        return new v.b.c(new i1("", ""), (t) r102.f541971a);
    L17:
        return new v.b.a(r103);
    L14:
        return v.b.C1348b.f88221a;
    }
}
