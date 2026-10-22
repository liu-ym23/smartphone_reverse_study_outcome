package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f137464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f137465b = false;

    static {
        f137464a = l42.a.f507316c.getValue().booleanValue();
        f137465b = com.bytedance.android.live.core.utils.v.a();
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "TAG");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f137465b == true) goto L5;
        return;
    L5:
        if (f137464a == false) goto L17;
        ALogger.i(r100, r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    L19:
        return;
    }
}
