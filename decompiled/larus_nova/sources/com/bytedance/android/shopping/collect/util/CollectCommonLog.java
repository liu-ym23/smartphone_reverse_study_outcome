package com.bytedance.android.shopping.collect.util;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectCommonLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f172289a = null;

    static {
        f172289a = LazyKt.lazy(CollectCommonLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if (((Boolean) f172289a.getValue()).booleanValue() == false) goto L15;
        dm.a.b r102 = dm.a.f469202a;     // Catch: Exception -> L10
        dm.a.b r103 = dm.a.a("collect_log_".concat(r100));     // Catch: Exception -> L10
        String r104 = (String) r101.invoke();     // Catch: Exception -> L10
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r103.a(r104);     // Catch: Exception -> L10
        return;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        dm.a.b r102 = dm.a.f469202a;     // Catch: Exception -> L5
        dm.a.a("collect_log_" + r100).b(r101, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        dm.a.b r102 = dm.a.f469202a;     // Catch: Exception -> L5
        dm.a.a("collect_log_" + r100).i(r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
