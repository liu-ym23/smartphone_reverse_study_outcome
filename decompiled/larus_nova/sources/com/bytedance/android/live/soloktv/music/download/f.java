package com.bytedance.android.live.soloktv.music.download;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f101424a = null;

    static {
        f101424a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        Boolean r102 = (Boolean) r100;
        Boolean r103 = (Boolean) r101;
        Intrinsics.checkNotNullParameter(r102, "t1");
        Intrinsics.checkNotNullParameter(r103, "t2");
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
