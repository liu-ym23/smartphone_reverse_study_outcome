package com.bytedance.android.monitorV2.exception;

import android.os.Handler;
import com.bytedance.android.monitorV2.util.u;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class HybridCrashHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f163027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f163028b;

    static {
        f163027a = "";
        f163028b = "";
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Npth.addAttachUserData(a.f163029a, CrashType.ALL);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void a(String r100, String r101) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        f163027a = r100;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        f163028b = r101;
        HashMap r102 = new HashMap();
        Pattern r103 = u.f163257a;
        r102.put("last_bdhm_url", u.a(f163027a));
        r102.put("last_bdhm_bid", f163028b);
        Npth.addTags(r102);
    }

    public static void b(final String r100, final String r101) {
        Handler r102 = com.bytedance.android.monitorV2.executor.a.f163034a;
        com.bytedance.android.monitorV2.executor.a.b(new HybridCrashHelper$injectInfo$1(r100, r101));
    }
}
