package com.bytedance.android.shopping.sku.common.utils;

import android.net.Uri;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final void a(String r100, Function1<? super Uri, Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$skuCheckUriValid");
        Intrinsics.checkNotNullParameter(r101, "validCallback");
        Intrinsics.checkNotNullParameter(r102, "invalidCallback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        Object r105 = null;
    L11:
        Uri r106 = (Uri) r105;
        if (Result.m9456isSuccessimpl(r104) == false) goto L15;
        if (r106 == null) goto L15;
        r101.invoke(r106);
        return;
    L15:
        r102.invoke();
        return;
    L10:
        r105 = r104;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final <T> T b(com.bytedance.android.shopping.sku.common.monitor.error.a r100, String r101, T r102, T r103) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        boolean r104 = true;
        if (r102 == null) goto L5;
        boolean r105 = r102 instanceof String;
    L6:
        if (r105 == false) goto L31;
        if (r103 == null) goto L9;
        boolean r106 = r103 instanceof String;
    L10:
        if (r106 == false) goto L31;
        CharSequence r107 = (CharSequence) r102;
        if (r107 != null) goto L14;
    L17:
        boolean r108 = true;
    L18:
        if (r108 == false) goto L28;
        CharSequence r109 = (CharSequence) r103;
        if (r109 != null) goto L22;
    L25:
        boolean r110 = true;
    L26:
        if (r110 == false) goto L28;
    L32:
        if (r104 == true) goto L35;
        if (r100 == null) goto L35;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r111 = com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b;
        r100.a(SkuErrorMonitorType.SERVER_BUSINESS_ERROR, r101 + " 值不等  input:" + r102 + "  fallback:" + r103, null);
    L35:
        if (r102 == null) goto L37;
        return r102;
    L37:
        return r103;
    L22:
        if (r109.length() == 0) goto L25;
        r110 = false;
    L28:
        if (Intrinsics.areEqual(r102, r103) == true) goto L32;
        r104 = false;
        goto L32
    L14:
        if (r107.length() == 0) goto L17;
        r108 = false;
        goto L18
    L9:
        r106 = true;
    L31:
        r104 = Intrinsics.areEqual(r102, r103);
        goto L32
    L5:
        r105 = true;
        goto L6
    }
}
