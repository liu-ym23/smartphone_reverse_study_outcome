package com.stepos.core.ota.confirmui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaConfirmTrampolineActivity;", "Landroid/app/Activity;", "<init>", "()V", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;", "decision", "LY8/t;", "submitDecision", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "", OtaConfirmTrampolineActivity.EXTRA_REQ_ID, "Ljava/lang/String;", "", "decided", "Z", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog;", C3081a.FOCUS_DIALOG_NAME, "Lcom/stepos/core/ota/confirmui/OtaAlertDialog;", OtaConfirmTrampolineActivity.EXTRA_TRACE_ID, "", OtaConfirmTrampolineActivity.EXTRA_T0, "J", "Companion", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OtaConfirmTrampolineActivity extends Activity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaConfirmTrampolineActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_REQ_ID", "EXTRA_PLAN", "EXTRA_SIZE_BYTES", "EXTRA_MODEL_LABEL", "EXTRA_UPDATE_INFO", "EXTRA_UPDATE_CONFIRM_FIRST", "EXTRA_TRACE_ID", "EXTRA_T0", "newIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", OtaConfirmTrampolineActivity.EXTRA_REQ_ID, "plan", "sizeBytes", "", "modelLabel", "updateInfo", OtaConfirmTrampolineActivity.EXTRA_TRACE_ID, OtaConfirmTrampolineActivity.EXTRA_T0, OtaConfirmTrampolineActivity.EXTRA_UPDATE_CONFIRM_FIRST, "", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Intent newIntent(Context context, String reqId, String plan, long sizeBytes, String modelLabel, String updateInfo, String perfTraceId, long perfT0, boolean updateConfirmFirst) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(reqId, "reqId");
            kotlin.jvm.internal.p.i(plan, "plan");
            kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
            kotlin.jvm.internal.p.i(updateInfo, "updateInfo");
            kotlin.jvm.internal.p.i(perfTraceId, "perfTraceId");
            Intent intent = new Intent(context, (Class<?>) OtaConfirmTrampolineActivity.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra(OtaConfirmTrampolineActivity.EXTRA_REQ_ID, reqId);
            intent.putExtra("plan", plan);
            intent.putExtra("sizeBytes", sizeBytes);
            intent.putExtra("modelLabel", modelLabel);
            intent.putExtra("updateInfo", updateInfo);
            intent.putExtra(OtaConfirmTrampolineActivity.EXTRA_UPDATE_CONFIRM_FIRST, updateConfirmFirst);
            intent.putExtra(OtaConfirmTrampolineActivity.EXTRA_TRACE_ID, perfTraceId);
            intent.putExtra(OtaConfirmTrampolineActivity.EXTRA_T0, perfT0);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onCreate$lambda$0(OtaConfirmTrampolineActivity otaConfirmTrampolineActivity, OtaAlertDialog it) {
        kotlin.jvm.internal.p.i(it, "it");
        otaConfirmTrampolineActivity.dialog = it;
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitDecision(ConfirmDecisionBus.Decision decision) {
        if (this.decided) {
            return;
        }
        this.decided = true;
        Log.i(TAG, "dialogClick: reqId=" + this.reqId + " decision=" + decision);
        try {
            Result.Companion companion = Result.INSTANCE;
            ConfirmDecisionBus.INSTANCE.submit(this.reqId, decision);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra(EXTRA_TRACE_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.perfTraceId = stringExtra;
        long longExtra = getIntent().getLongExtra(EXTRA_T0, 0L);
        this.perfT0 = longExtra;
        ConfirmPerf.INSTANCE.mark(this.perfTraceId, longExtra, "ACTIVITY_ONCREATE", "plan=" + getIntent().getStringExtra("plan"));
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
                kotlin.jvm.internal.p.i(stage, "stage");
                OtaConfirmTrampolineActivity otaConfirmTrampolineActivity = this.this$0;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ConfirmDecisionBus.INSTANCE.notifyStage(otaConfirmTrampolineActivity.reqId, stage);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }

            @Override // com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink
            public void submit(ConfirmDecisionBus.Decision decision) {
                kotlin.jvm.internal.p.i(decision, "decision");
                this.this$0.submitDecision(decision);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.x0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return OtaConfirmTrampolineActivity.onCreate$lambda$0(this.f29632a, (OtaAlertDialog) obj);
            }
        }, this.perfTraceId, this.perfT0).start()) {
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
                Result.Companion companion = Result.INSTANCE;
                ConfirmDecisionBus.INSTANCE.submit(this.reqId, ConfirmDecisionBus.Decision.CANCEL);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        super.onDestroy();
    }
}
