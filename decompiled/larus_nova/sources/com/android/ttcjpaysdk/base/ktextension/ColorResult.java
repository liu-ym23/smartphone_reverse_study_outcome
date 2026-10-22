package com.android.ttcjpaysdk.base.ktextension;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0007J\r\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/ColorResult;", "", "color", "", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOrElse", "fallbackColor", "Lkotlin/Function0;", "getOrNull", "()Ljava/lang/Integer;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ColorResult {
    private final Integer color;

    public final Integer getOrNull() {
        return this.color;
    }

    public ColorResult(Integer r100) {
        this.color = r100;
    }

    public final int getOrElse(Function0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "fallbackColor");
        Integer r101 = this.color;
        if (r101 == null) goto L6;
        return r101.intValue();
    L6:
        return r100.invoke().intValue();
    }
}
