package com.bytedance.android.live.pushstream;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f89398a = null;

    static {
        f89398a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new PolarisFileWrapper(r101);
    }
}
