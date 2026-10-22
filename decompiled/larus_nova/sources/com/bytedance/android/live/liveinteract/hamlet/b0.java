package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b0<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f73493a = null;

    static {
        f73493a = new b0();
    }

    public b0() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        Boolean r102 = (Boolean) r100;
        Boolean r103 = (Boolean) r101;
        Intrinsics.checkNotNullParameter(r102, "xplyStartMessageRecived");
        Intrinsics.checkNotNullParameter(r103, "isRtcClientInitialized");
        if (r102.booleanValue() == true) goto L5;
    L7:
        boolean r104 = false;
    L9:
        return Boolean.valueOf(r104);
    L5:
        if (r103.booleanValue() == false) goto L7;
        r104 = true;
        goto L9
    }
}
