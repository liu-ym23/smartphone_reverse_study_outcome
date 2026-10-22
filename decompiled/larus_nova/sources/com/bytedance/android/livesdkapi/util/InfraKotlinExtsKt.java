package com.bytedance.android.livesdkapi.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0005"}, d2 = {"mainThreadLazy", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function0;", "infrastructure_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class InfraKotlinExtsKt {
    public static final <T> Lazy<T> mainThreadLazy(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, r100);
    }
}
