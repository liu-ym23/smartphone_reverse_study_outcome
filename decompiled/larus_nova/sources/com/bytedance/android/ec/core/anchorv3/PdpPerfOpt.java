package com.bytedance.android.ec.core.anchorv3;

import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class PdpPerfOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f43774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f43775b = null;

    public static m a() {
        return (m) f43774a.getValue();
    }

    public static n b() {
        return (n) f43775b.getValue();
    }

    static {
        f43774a = LazyKt.lazy(PdpPerfOpt$setting$2.INSTANCE);
        f43775b = LazyKt.lazy(PdpPerfOpt$settingV2$2.INSTANCE);
    }

    public static int j() {
        int r100 = ECSdk.f48106a;
        cj.b r101 = (cj.b) ECSdk.a(cj.b.class);
        if (r101 == null) goto L6;
        r101.f();
    L6:
        return a().d();
    }

    public static boolean c() {
        return b().f();
    }

    public static boolean d() {
        return a().c();
    }

    public static boolean e() {
        if (b().i() == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.android.ec.core.abtest.d.a() == true) goto L8;
        return false;
    }

    public static boolean f() {
        if (a().f() == false) goto L8;
        int r100 = ECSdk.f48106a;
        cj.b r101 = (cj.b) ECSdk.a(cj.b.class);
        if (r101 == null) goto L7;
        r101.f();
    L7:
        return true;
    L8:
        return false;
    }

    public static boolean g() {
        if (a().g() == false) goto L8;
        int r100 = ECSdk.f48106a;
        cj.b r101 = (cj.b) ECSdk.a(cj.b.class);
        if (r101 == null) goto L7;
        r101.f();
    L7:
        qh.a.a();
        return true;
    L8:
        return false;
    }

    public static boolean h() {
        return a().e();
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.a("PdpPerfOpt").i(r100);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
