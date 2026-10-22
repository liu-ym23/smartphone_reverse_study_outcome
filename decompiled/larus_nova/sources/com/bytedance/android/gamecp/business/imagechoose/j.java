package com.bytedance.android.gamecp.business.imagechoose;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f56089a = null;

    static {
        f56089a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
