package com.stepos.core.ota.confirmui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.ota.confirmui.OtaConfirmTrampolineActivity;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/core/ota/confirmui/TrampolineConfirmHost;", "Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;", "request", "LY8/t;", "show", "(Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;)V", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "Landroid/os/Handler;", "main", "Landroid/os/Handler;", "", "perfLabel", "Ljava/lang/String;", "getPerfLabel", "()Ljava/lang/String;", "Companion", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrampolineConfirmHost implements ConfirmUiHost {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "TrampolineConfirmHost";
    private final Context appContext;
    private final Handler main;
    private final String perfLabel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/core/ota/confirmui/TrampolineConfirmHost$Companion;", "", "<init>", "()V", "TAG", "", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    public TrampolineConfirmHost(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.appContext = context.getApplicationContext();
        this.main = new Handler(Looper.getMainLooper());
        this.perfLabel = "trampoline";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(ConfirmUiRequest confirmUiRequest, long j10, TrampolineConfirmHost trampolineConfirmHost) {
        Object objB;
        ConfirmPerf.INSTANCE.mark(confirmUiRequest.getPerfTraceId(), confirmUiRequest.getPerfT0(), "START_ACTIVITY", "plan=" + confirmUiRequest.getParams().getPlan() + " queueDelay=" + (SystemClock.elapsedRealtime() - j10) + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        try {
            Result.Companion companion = Result.INSTANCE;
            Context appContext = trampolineConfirmHost.appContext;
            OtaConfirmTrampolineActivity.Companion companion2 = OtaConfirmTrampolineActivity.INSTANCE;
            kotlin.jvm.internal.p.h(appContext, "appContext");
            appContext.startActivity(companion2.newIntent(appContext, confirmUiRequest.getReqId(), confirmUiRequest.getParams().getPlan(), confirmUiRequest.getParams().getSizeBytes(), confirmUiRequest.getParams().getModelLabel(), confirmUiRequest.getParams().getUpdateInfo(), confirmUiRequest.getPerfTraceId(), confirmUiRequest.getPerfT0(), confirmUiRequest.getParams().getUpdateConfirmFirst()));
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(TAG, "launch confirm trampoline failed", thE);
            confirmUiRequest.getOnShowFailed().invoke();
        }
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public String getPerfLabel() {
        return this.perfLabel;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public void show(final ConfirmUiRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.y0
            @Override // java.lang.Runnable
            public final void run() {
                TrampolineConfirmHost.show$lambda$2(request, jElapsedRealtime, this);
            }
        });
    }
}
