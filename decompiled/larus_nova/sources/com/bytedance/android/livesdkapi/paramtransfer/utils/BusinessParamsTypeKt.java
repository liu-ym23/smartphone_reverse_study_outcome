package com.bytedance.android.livesdkapi.paramtransfer.utils;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"realName", "", "Lcom/bytedance/android/livesdkapi/paramtransfer/utils/BusinessParamsType;", "room_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class BusinessParamsTypeKt {
    public static final String realName(BusinessParamsType r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$realName");
        String r101 = r100.name();
        Locale r102 = Locale.getDefault();
        if (r101 == null) goto L7;
        return r101.toLowerCase(r102);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
