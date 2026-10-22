package com.bytedance.android.ec.hybrid.card.util;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f46608a = 0;

    static {
    }

    public static boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUri");
        String r101 = UriProtector.getQueryParameter(r100, "enable_code_cache");
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (CastIntegerProtector.parseInt(r101) != 1) goto L7;
        return true;
    }

    public static boolean b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUri");
        String r101 = UriProtector.getQueryParameter(r100, "enable_js_runtime");
        if (r101 != null) goto L7;
        return true;
    L7:
        return Boolean.parseBoolean(r101);
    }

    public static boolean c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUri");
        String r101 = UriProtector.getQueryParameter(r100, "enable_lynx_strict_mode");
        if (r101 != null) goto L7;
        return false;
    L7:
        return Boolean.parseBoolean(r101);
    }

    public static int d(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUri");
        String r101 = UriProtector.getQueryParameter(r100, "thread_strategy");
        if (r101 != null) goto L7;
        return 0;
    L7:
        return CastIntegerProtector.parseInt(r101);
    }

    public static Uri e(ECLynxLoadParam r100) {
        Intrinsics.checkNotNullParameter(r100, "loadParam");
        Uri r101 = UriProtector.parse(r100.f46313d);
        uj.b r102 = r100.f46330u;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return f(r101, r102);
    }

    public static String g(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUri");
        return UriProtector.getQueryParameter(r100, "surl");
    }

    public static Uri f(Uri r100, uj.b r101) {
        Intrinsics.checkNotNullParameter(r100, "originSchema");
        Intrinsics.checkNotNullParameter(r101, "groupParams");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(ECLynxBuildUtilKt.c(r100, r101));     // Catch: Throwable -> L5
    L7:
        Object r104 = r100;
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        r104 = r103;
    L12:
        return (Uri) r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
