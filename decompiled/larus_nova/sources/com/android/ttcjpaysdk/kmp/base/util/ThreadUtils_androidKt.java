package com.android.ttcjpaysdk.kmp.base.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"runOnFFIThread", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "cj_base_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ThreadUtils_androidKt {
    public static final <R> R runOnFFIThread(Function0<? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return r100.invoke();
    }
}
