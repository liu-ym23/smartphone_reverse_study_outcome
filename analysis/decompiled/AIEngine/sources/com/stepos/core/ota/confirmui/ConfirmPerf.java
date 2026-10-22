package com.stepos.core.ota.confirmui;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ConfirmPerf {
    public static final ConfirmPerf INSTANCE = new ConfirmPerf();
    private static final String PERF_TAG = "OtaConfirmPerf";

    private ConfirmPerf() {
    }

    public static /* synthetic */ void mark$default(ConfirmPerf confirmPerf, String str, long j10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = "";
        }
        confirmPerf.mark(str, j10, str2, str3);
    }

    public final void mark(String traceId, long j10, String stage, String extra) {
        kotlin.jvm.internal.g.f(traceId, "traceId");
        kotlin.jvm.internal.g.f(stage, "stage");
        kotlin.jvm.internal.g.f(extra, "extra");
        if (traceId.length() == 0) {
            return;
        }
        Log.i(PERF_TAG, com.stepos.core.ota.d.j(com.stepos.core.ota.d.l("OCPERF tid=", SystemClock.elapsedRealtime() - j10, traceId, " +"), "ms stage=", stage, " ", extra));
    }
}
