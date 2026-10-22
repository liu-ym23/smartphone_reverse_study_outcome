package com.bytedance.android.bcm.impl2;

import android.util.Log;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import zc.g;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f41889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f41890b;

    public a(Function0 r100, Throwable r101) {
        this.f41889a = r100;
        this.f41890b = r101;
    }

    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L18
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L18
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L18
        Unit r103 = null;
        Function0 r104 = this.f41889a;     // Catch: Throwable -> L21
        if (r104 == null) goto L7;
        Unit r105 = (Unit) r104.invoke();     // Catch: Throwable -> L21
    L8:
        r102.put("error_msg", String.valueOf(r105));     // Catch: Throwable -> L21
        Throwable r106 = this.f41890b;     // Catch: Throwable -> L21
        if (r106 == null) goto L13;
        String r107 = Log.getStackTraceString(r106);     // Catch: Throwable -> L21
        int r108 = RangesKt.coerceAtMost(r107.length(), 500);     // Catch: Throwable -> L21
        if (r108 <= 0) goto L13;
        r102.put("stack_trace", r107.substring(0, r108));     // Catch: Throwable -> L21
        goto L13
    L7:
        r105 = null;
    L13:
        g r109 = BtmHostDependManager.F.f();     // Catch: Throwable -> L18
        if (r109 == null) goto L16;
        r109.a("bizbcm_monitor", r101, r102);     // Catch: Throwable -> L18
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
