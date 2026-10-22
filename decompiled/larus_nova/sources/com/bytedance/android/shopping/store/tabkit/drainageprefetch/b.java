package com.bytedance.android.shopping.store.tabkit.drainageprefetch;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.shopping.store.utils.n;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f186737a = 0;

    static {
    }

    public static boolean a(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        boolean r102 = true;
        if ((r100 & 1) > 0) goto L7;
        r102 = false;
    L7:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = null;
    L14:
        Boolean r104 = (Boolean) r103;
        if (r104 != null) goto L17;
        return false;
    L17:
        return r104.booleanValue();
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static int b(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return 0;
    L8:
        Uri r102 = n.c(r100);
        if (r102 == null) goto L16;
        String r103 = j1.c(r102, "na_prefetch_strategy");
        if (r103 == null) goto L17;
        Integer r104 = StringsKt.toIntOrNull(r103);
        if (r104 != null) goto L15;
        return 0;
    L15:
        return r104.intValue();
    L17:
        return 0;
    L16:
        return 0;
    L5:
        r101 = false;
        goto L6
    }

    public static boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(r100), "na_prefetch_strategy");
        if (r101 == null) goto L7;
        Integer r102 = StringsKt.toIntOrNull(r101);
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L9:
        return a(r103);
    L7:
        r103 = 0;
        goto L9
    }
}
