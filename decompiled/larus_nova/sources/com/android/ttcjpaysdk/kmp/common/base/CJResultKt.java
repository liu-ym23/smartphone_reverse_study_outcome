package com.android.ttcjpaysdk.kmp.common.base;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0005"}, d2 = {"isSuccess", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/kmp/common/base/CJResult;", "isFail", "cj_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CJResultKt {
    public static final <T> boolean isFail(CJResult<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getCode() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean isSuccess(CJResult<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
