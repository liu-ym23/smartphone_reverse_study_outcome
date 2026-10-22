package com.bytedance.android.anniex.scene.handler.idle;

import java.util.ArrayList;
import java.util.function.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T, R> f41219a = null;

    static {
        f41219a = new g();
    }

    public g() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((TaskType) r100, "it");
        return new ArrayList();
    }
}
