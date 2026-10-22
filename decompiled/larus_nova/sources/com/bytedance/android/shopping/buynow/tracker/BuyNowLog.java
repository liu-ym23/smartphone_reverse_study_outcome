package com.bytedance.android.shopping.buynow.tracker;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class BuyNowLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f171168a = null;

    static {
        f171168a = LazyKt.lazy(BuyNowLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.b r103 = dm.a.f469202a;     // Catch: Throwable -> L5
        dm.a.a("buynow_" + r100).a(r101);     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        ECExceptionMonitor.e(r105);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if (((Boolean) f171168a.getValue()).booleanValue() == false) goto L15;
        dm.a.b r102 = dm.a.f469202a;     // Catch: Exception -> L10
        dm.a.b r103 = dm.a.a("buynow_".concat(r100));     // Catch: Exception -> L10
        String r104 = (String) r101.invoke();     // Catch: Exception -> L10
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r103.a(r104);     // Catch: Exception -> L10
        return;
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.b r103 = dm.a.f469202a;     // Catch: Throwable -> L5
        dm.a.a("buynow_".concat(r100)).b(r101, null);     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        ECExceptionMonitor.e(r105);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.b r103 = dm.a.f469202a;     // Catch: Throwable -> L5
        dm.a.a("buynow_".concat(r100)).i(r101);     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        ECExceptionMonitor.e(r105);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
