package com.bytedance.android.live.messagewindow.framework.manager;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T1, T2> implements BiPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f83123a = null;

    static {
        f83123a = new b();
    }

    public b() {
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
