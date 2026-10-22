package com.bytedance.android.ec.core.arch.viewmodel;

import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final c a(Fragment r100, KClass r101, Function0 r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$createViewModelLazy");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "storeProducer");
        Intrinsics.checkNotNullParameter(r103, "factoryProducer");
        return new c(r101, r102, r103);
    }
}
