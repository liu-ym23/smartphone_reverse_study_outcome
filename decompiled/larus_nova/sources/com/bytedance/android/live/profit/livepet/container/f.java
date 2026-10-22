package com.bytedance.android.live.profit.livepet.container;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T1, T2> implements BiPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f87852a = null;

    static {
        f87852a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.BiPredicate
    public final boolean test(Object r100, Object r101) {
        i32.a r102 = (i32.a) r100;
        i32.a r103 = (i32.a) r101;
        Intrinsics.checkNotNullParameter(r102, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r103, "b");
        if (r102.f488089a == r103.f488089a) goto L5;
    L7:
        return false;
    L5:
        if (r102.f488090b != r103.f488090b) goto L7;
        return true;
    }
}
