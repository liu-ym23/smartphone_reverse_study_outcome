package com.bytedance.android.shopping.anchorv3.utils.purchaseV2;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165328a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getQueryParameter");
        Intrinsics.checkNotNullParameter("mega_object", "key");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L15
        if (r102.isHierarchical() == false) goto L8;
        boolean r103 = true;
        if ((!StringsKt.isBlank("mega_object")) == false) goto L8;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L22;
        return UriProtector.getQueryParameter(r102, "mega_object");
    L22:
        return null;
    L8:
        r103 = false;
    L15:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Throwable r105 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r105 == null) goto L19;
        dm.a.a("ECVideoPurchaseBuild").b("String.getQueryParameter", r105);
    L19:
        return null;
    }
}
