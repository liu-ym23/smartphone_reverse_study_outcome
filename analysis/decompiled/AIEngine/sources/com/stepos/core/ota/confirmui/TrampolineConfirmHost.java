package com.stepos.core.ota.confirmui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.core.ota.confirmui.OtaConfirmTrampolineActivity;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TrampolineConfirmHost implements ConfirmUiHost {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "TrampolineConfirmHost";
    private final Context appContext;
    private final Handler main;
    private final String perfLabel;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public TrampolineConfirmHost(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        this.appContext = context.getApplicationContext();
        this.main = new Handler(Looper.getMainLooper());
        this.perfLabel = "trampoline";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(ConfirmUiRequest confirmUiRequest, long j10, TrampolineConfirmHost trampolineConfirmHost) {
        Object objA;
        ConfirmPerf confirmPerf = ConfirmPerf.INSTANCE;
        String perfTraceId = confirmUiRequest.getPerfTraceId();
        long perfT0 = confirmUiRequest.getPerfT0();
        StringBuilder sbL = com.stepos.core.ota.d.l("plan=", SystemClock.elapsedRealtime() - j10, confirmUiRequest.getParams().getPlan(), " queueDelay=");
        sbL.append("ms");
        confirmPerf.mark(perfTraceId, perfT0, "START_ACTIVITY", sbL.toString());
        try {
            Context appContext = trampolineConfirmHost.appContext;
            OtaConfirmTrampolineActivity.Companion companion = OtaConfirmTrampolineActivity.Companion;
            kotlin.jvm.internal.g.e(appContext, "appContext");
            appContext.startActivity(companion.newIntent(appContext, confirmUiRequest.getReqId(), confirmUiRequest.getParams().getPlan(), confirmUiRequest.getParams().getSizeBytes(), confirmUiRequest.getParams().getModelLabel(), confirmUiRequest.getParams().getUpdateInfo(), confirmUiRequest.getPerfTraceId(), confirmUiRequest.getPerfT0(), confirmUiRequest.getParams().getUpdateConfirmFirst()));
            objA = lb.n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.e(TAG, "launch confirm trampoline failed", thB);
            confirmUiRequest.getOnShowFailed().invoke();
        }
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public String getPerfLabel() {
        return this.perfLabel;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public void show(final ConfirmUiRequest request) {
        kotlin.jvm.internal.g.f(request, "request");
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.w
            @Override // java.lang.Runnable
            public final void run() {
                TrampolineConfirmHost.show$lambda$2(request, jElapsedRealtime, this);
            }
        });
    }
}
