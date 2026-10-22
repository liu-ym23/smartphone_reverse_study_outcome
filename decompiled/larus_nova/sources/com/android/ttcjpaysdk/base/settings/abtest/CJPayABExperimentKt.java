package com.android.ttcjpaysdk.base.settings.abtest;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"tryGetWithNoClassDefCatch", ExifInterface.GPS_DIRECTION_TRUE, "originalCall", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayABExperimentKt {
    public static final <T> T tryGetWithNoClassDefCatch(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "originalCall");
        if (CJPayABExperimentUtils.INSTANCE.checkABSDKInstalled() == true) goto L9;
        return null;
    L9:
        return r100.invoke();
    L11:
        return null;
    }
}
