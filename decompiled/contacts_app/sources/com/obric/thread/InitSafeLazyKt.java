package com.obric.thread;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitSafeLazy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0005"}, d2 = {"initSafeLazy", "Lcom/obric/thread/InitSafeLazy;", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function0;", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InitSafeLazyKt {
    public static final <T> InitSafeLazy<T> initSafeLazy(Function0<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "initializer");
        return new InitSafeLazy(r1);
    }
}
