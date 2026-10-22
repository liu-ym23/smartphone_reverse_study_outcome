package com.stepos.core.ota.confirmui;

import android.os.SystemClock;
import android.util.Log;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmPerf;", "", "<init>", "()V", "", DidiCardProvider.KEY_TRACE_ID, "", "t0", "stage", "extra", "LY8/t;", "mark", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "PERF_TAG", "Ljava/lang/String;", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    public final void mark(String traceId, long t02, String stage, String extra) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(stage, "stage");
        kotlin.jvm.internal.p.i(extra, "extra");
        if (traceId.length() == 0) {
            return;
        }
        Log.i(PERF_TAG, "OCPERF tid=" + traceId + " +" + (SystemClock.elapsedRealtime() - t02) + "ms stage=" + stage + " " + extra);
    }
}
