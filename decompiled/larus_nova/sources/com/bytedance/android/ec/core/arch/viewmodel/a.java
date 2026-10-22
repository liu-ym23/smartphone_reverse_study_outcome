package com.bytedance.android.ec.core.arch.viewmodel;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final c a(FragmentActivity r100, KClass r101, Function0 r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$createViewModelLazy");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "storeProducer");
        Intrinsics.checkNotNullParameter(r103, "factoryProducer");
        return new c(r101, r102, r103);
    }
}
