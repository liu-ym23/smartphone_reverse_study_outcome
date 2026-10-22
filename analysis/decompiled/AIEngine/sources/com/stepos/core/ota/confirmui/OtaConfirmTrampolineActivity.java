package com.stepos.core.ota.confirmui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaConfirmTrampolineActivity extends Activity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_MODEL_LABEL = "modelLabel";
    public static final String EXTRA_PLAN = "plan";
    public static final String EXTRA_REQ_ID = "reqId";
    public static final String EXTRA_SIZE_BYTES = "sizeBytes";
    public static final String EXTRA_T0 = "perfT0";
    public static final String EXTRA_TRACE_ID = "perfTraceId";
    public static final String EXTRA_UPDATE_CONFIRM_FIRST = "updateConfirmFirst";
    public static final String EXTRA_UPDATE_INFO = "updateInfo";
    private static final String TAG = "OtaConfirmTrampoline";
    private boolean decided;
    private OtaAlertDialog dialog;
    private long perfT0;
    private String reqId = "";
    private String perfTraceId = "";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final Intent newIntent(Context context, String reqId, String plan, long j10, String modelLabel, String updateInfo, String perfTraceId, long j11, boolean z) {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(reqId, "reqId");
            kotlin.jvm.internal.g.f(plan, "plan");
            kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
            kotlin.jvm.internal.g.f(updateInfo, "updateInfo");
            kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
            Intent intent = new Intent(context, (Class<?>) OtaConfirmTrampolineActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(OtaConfirmTrampolineActivity.EXTRA_REQ_ID, reqId);
            intent.putExtra("plan", plan);
            intent.putExtra("sizeBytes", j10);
            intent.putExtra("modelLabel", modelLabel);
            intent.putExtra("updateInfo", updateInfo);
            intent.putExtra(OtaConfirmTrampolineActivity.EXTRA_UPDATE_CONFIRM_FIRST, z);
            intent.putExtra(OtaConfirmTrampolineActivity.EXTRA_TRACE_ID, perfTraceId);
            intent.putExtra(OtaConfirmTrampolineActivity.EXTRA_T0, j11);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n onCreate$lambda$0(OtaConfirmTrampolineActivity otaConfirmTrampolineActivity, OtaAlertDialog it) {
        kotlin.jvm.internal.g.f(it, "it");
        otaConfirmTrampolineActivity.dialog = it;
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitDecision(ConfirmDecisionBus.Decision decision) {
        if (this.decided) {
            return;
        }
        this.decided = true;
        Log.i(TAG, "dialogClick: reqId=" + this.reqId + " decision=" + decision);
        try {
            ConfirmDecisionBus.INSTANCE.submit(this.reqId, decision);
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(EXTRA_TRACE_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.perfTraceId = stringExtra;
        long longExtra = getIntent().getLongExtra(EXTRA_T0, 0L);
        this.perfT0 = longExtra;
        ConfirmPerf.INSTANCE.mark(this.perfTraceId, longExtra, "ACTIVITY_ONCREATE", ai.onnxruntime.a.k("plan=", getIntent().getStringExtra("plan")));
        String stringExtra2 = getIntent().getStringExtra(EXTRA_REQ_ID);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.reqId = stringExtra2;
        if (stringExtra2.length() == 0) {
            Log.w(TAG, "onCreate: empty reqId, finishing");
            finish();
            return;
        }
        String stringExtra3 = getIntent().getStringExtra("plan");
        if (stringExtra3 == null) {
            stringExtra3 = ModelFlowMeta.PLAN_NONE;
        }
        String str = stringExtra3;
        long longExtra2 = getIntent().getLongExtra("sizeBytes", 0L);
        String stringExtra4 = getIntent().getStringExtra("modelLabel");
        String str2 = stringExtra4 == null ? "" : stringExtra4;
        String stringExtra5 = getIntent().getStringExtra("updateInfo");
        ConfirmDialogParams confirmDialogParams = new ConfirmDialogParams(str, longExtra2, str2, stringExtra5 == null ? "" : stringExtra5, false, getIntent().getBooleanExtra(EXTRA_UPDATE_CONFIRM_FIRST, false), 16, null);
        if (new OtaConfirmDialogPresenter(this, confirmDialogParams, new OtaConfirmDialogPresenter.Sink() { // from class: com.stepos.core.ota.confirmui.OtaConfirmTrampolineActivity$onCreate$presenter$1
            @Override // com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink
            public void stage(ConfirmDecisionBus.SubStage stage) {
                kotlin.jvm.internal.g.f(stage, "stage");
                try {
                    ConfirmDecisionBus.INSTANCE.notifyStage(this.this$0.reqId, stage);
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
            }

            @Override // com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink
            public void submit(ConfirmDecisionBus.Decision decision) {
                kotlin.jvm.internal.g.f(decision, "decision");
                this.this$0.submitDecision(decision);
            }
        }, new androidx.compose.runtime.g(this, 13), this.perfTraceId, this.perfT0).start()) {
            return;
        }
        Log.w(TAG, "onCreate: unsupported plan=" + confirmDialogParams.getPlan() + ", finishing");
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        OtaAlertDialog otaAlertDialog = this.dialog;
        if (otaAlertDialog != null) {
            if (!otaAlertDialog.isShowing()) {
                otaAlertDialog = null;
            }
            if (otaAlertDialog != null) {
                otaAlertDialog.dismiss();
            }
        }
        this.dialog = null;
        if (!this.decided && !isChangingConfigurations()) {
            this.decided = true;
            try {
                ConfirmDecisionBus.INSTANCE.submit(this.reqId, ConfirmDecisionBus.Decision.CANCEL);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
        super.onDestroy();
    }
}
