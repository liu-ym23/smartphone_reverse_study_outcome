package com.bytedance.android.live.pushstream;

import io.reactivex.functions.Function;
import java.io.File;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f89399a = null;

    static {
        f89399a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        File r101 = (File) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return ArraysKt.toList(r101.listFiles());
    }
}
