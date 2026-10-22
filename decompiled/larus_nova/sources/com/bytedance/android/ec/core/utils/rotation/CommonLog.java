package com.bytedance.android.ec.core.utils.rotation;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class CommonLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45699a = null;

    static {
        f45699a = LazyKt.lazy(CommonLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(Function0 r100) {
        Intrinsics.checkNotNullParameter("tryWaitValidActivityCreatedWithErrorMessage", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if (((Boolean) f45699a.getValue()).booleanValue() == false) goto L15;
        dm.a.b r101 = dm.a.a("common_log_tryWaitValidActivityCreatedWithErrorMessage");     // Catch: Exception -> L10
        String r102 = (String) r100.invoke();     // Catch: Exception -> L10
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r101.a(r102);     // Catch: Exception -> L10
        return;
    }
}
