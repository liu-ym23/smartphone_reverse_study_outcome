package com.stepos.core.ota.confirmui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.OtaAlertDialog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaConfirmDialogPresenter {
    private static final String ACTION_OPEN_ENHANCED_SERVICE = "com.stepos.aiengine.action.OPEN_ENHANCED_SERVICE_SETTINGS";
    private static final String AIENGINE_PKG = "com.stepos.aiengine";
    public static final Companion Companion = new Companion(null);
    private static final String ENHANCED_SERVICE_REDIRECT_CLASS = "com.stepos.aiengine.settings.EnhancedServiceRedirectActivity";
    private final Context context;
    private final String modelLabel;
    private final zb.l<OtaAlertDialog, lb.n> onShow;
    private final ConfirmDialogParams params;
    private final long perfT0;
    private final String perfTraceId;
    private final Sink sink;
    private final String updateInfo;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String formatSize(long j10) {
            double d8 = j10 / 1048576.0d;
            return d8 >= 1024.0d ? String.format(Locale.US, "%.1fGB", Arrays.copyOf(new Object[]{Double.valueOf(d8 / 1024)}, 1)) : String.format(Locale.US, "%.0fMB", Arrays.copyOf(new Object[]{Double.valueOf(d8)}, 1));
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface Sink {
        void stage(ConfirmDecisionBus.SubStage subStage);

        void submit(ConfirmDecisionBus.Decision decision);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OtaConfirmDialogPresenter(Context context, ConfirmDialogParams params, Sink sink, zb.l<? super OtaAlertDialog, lb.n> onShow, String perfTraceId, long j10) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(params, "params");
        kotlin.jvm.internal.g.f(sink, "sink");
        kotlin.jvm.internal.g.f(onShow, "onShow");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
        this.context = context;
        this.params = params;
        this.sink = sink;
        this.onShow = onShow;
        this.perfTraceId = perfTraceId;
        this.perfT0 = j10;
        String modelLabel = params.getModelLabel();
        if (modelLabel.length() == 0) {
            modelLabel = context.getString(R.string.ocu_default_model);
            kotlin.jvm.internal.g.e(modelLabel, "getString(...)");
        }
        this.modelLabel = modelLabel;
        this.updateInfo = params.getUpdateInfo();
    }

    private final OtaAlertDialog.Builder builder() {
        return new OtaAlertDialog.Builder(this.context);
    }

    private final String getSizeLabel() {
        return this.params.getSizeBytes() > 0 ? Companion.formatSize(this.params.getSizeBytes()) : "";
    }

    private final void openEnhancedServiceSettings() {
        Object objA;
        if (tryRedirectViaAiEngine()) {
            return;
        }
        try {
            zb.l<Context, Integer> launcher = EnhancedServiceGuide.getLauncher();
            objA = launcher != null ? (Integer) launcher.invoke(this.context) : null;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Integer num = (Integer) (objA instanceof Result.Failure ? null : objA);
        int iIntValue = num != null ? num.intValue() : -1;
        if (iIntValue == 0) {
            return;
        }
        Log.w("OtaConfirmPresenter", "delegated launch unavailable/failed rc=" + iIntValue + ", try local");
        if (tryLocalOpenEnhancedServiceSettings()) {
            return;
        }
        try {
            Toast.makeText(this.context.getApplicationContext(), this.context.getString(R.string.ocu_service_open_failed), 1).show();
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th2) {
            kotlin.c.a(th2);
        }
    }

    private final void present(OtaAlertDialog.Builder builder) {
        OtaAlertDialog otaAlertDialogCreate = builder.create();
        otaAlertDialogCreate.show();
        this.onShow.invoke(otaAlertDialogCreate);
        ConfirmPerf.INSTANCE.mark(this.perfTraceId, this.perfT0, "DIALOG_SHOWN", ai.onnxruntime.a.k("plan=", this.params.getPlan()));
    }

    private final void showCellularReminder() {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_cellular_msg, this.modelLabel, getSizeLabel()) : this.context.getString(R.string.ocu_cellular_msg_no_size, this.modelLabel);
        kotlin.jvm.internal.g.c(string);
        present(builder().setTitle(R.string.ocu_cellular_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_download_now, OtaAlertDialog.ButtonStyle.EMPHASIZED, new u(this, 5)).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new t(this, 8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showCellularReminder$lambda$8(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showCellularReminder$lambda$9(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showCellularUpdate(boolean z) {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_cellular_update_msg, this.modelLabel, getSizeLabel(), updateLog()) : this.context.getString(R.string.ocu_cellular_update_msg_no_size, updateLog());
        kotlin.jvm.internal.g.c(string);
        OtaAlertDialog.Builder builderAddButton = builder().setTitle(R.string.ocu_cellular_update_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_update_now, OtaAlertDialog.ButtonStyle.EMPHASIZED, new u(this, 6));
        if (z) {
            builderAddButton.addButton(R.string.ocu_connect_wifi_auto, OtaAlertDialog.ButtonStyle.NORMAL, new t(this, 9));
        }
        present(builderAddButton.addButton(R.string.ocu_update_later, OtaAlertDialog.ButtonStyle.NORMAL, new u(this, 7)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showCellularUpdate$lambda$24(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showCellularUpdate$lambda$25(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.stage(ConfirmDecisionBus.SubStage.WIFI_GUIDE);
        otaConfirmDialogPresenter.showWifiGuide(true);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showCellularUpdate$lambda$26(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showDownloadConfirm(final boolean z) {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_download_msg, this.modelLabel, getSizeLabel()) : this.context.getString(R.string.ocu_download_msg_no_size, this.modelLabel);
        kotlin.jvm.internal.g.c(string);
        present(builder().setTitle(R.string.ocu_download_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_download_now, OtaAlertDialog.ButtonStyle.EMPHASIZED, new zb.a() { // from class: com.stepos.core.ota.confirmui.v
            @Override // zb.a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showDownloadConfirm$lambda$4(z, this);
            }
        }).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new t(this, 4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showDownloadConfirm$lambda$4(boolean z, OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        if (!z || otaConfirmDialogPresenter.params.getDeferCellularToGate()) {
            otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM);
        } else {
            otaConfirmDialogPresenter.sink.stage(ConfirmDecisionBus.SubStage.CELLULAR_REMINDER);
            otaConfirmDialogPresenter.showCellularReminder();
        }
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showDownloadConfirm$lambda$5(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showNoNetworkGuide() {
        String modelLabel = this.params.getModelLabel();
        Locale US = Locale.US;
        kotlin.jvm.internal.g.e(US, "US");
        String lowerCase = modelLabel.toLowerCase(US);
        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        String str = gc.q.l0(lowerCase, "asr", false) ? "ASR" : gc.q.l0(lowerCase, "tts", false) ? "TTS" : null;
        String string = str != null ? this.context.getString(R.string.ocu_no_net_msg_voice, str) : this.context.getString(R.string.ocu_no_net_msg_generic);
        kotlin.jvm.internal.g.c(string);
        present(builder().setTitle(R.string.ocu_no_net_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_no_net_connect_wifi, OtaAlertDialog.ButtonStyle.EMPHASIZED, new u(this, 11)).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new t(this, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showNoNetworkGuide$lambda$6(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.SCHEDULE_WIFI_DOWNLOAD);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showNoNetworkGuide$lambda$7(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showResourceGate(int i10) {
        present(builder().setTitle(this.context.getString(i10)).setMessage(null).setCancelable(false).addButton(R.string.ocu_gate_confirm, OtaAlertDialog.ButtonStyle.EMPHASIZED, new t(this, 13)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showResourceGate$lambda$37(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showResumeCellular() {
        present(builder().setTitle(R.string.ocu_cellular_title).setMessage(this.context.getString(R.string.ocu_resume_cellular_msg, this.modelLabel)).setCancelable(false).addButton(R.string.ocu_cellular_continue, OtaAlertDialog.ButtonStyle.EMPHASIZED, new u(this, 4)).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new t(this, 7)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showResumeCellular$lambda$12(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showResumeCellular$lambda$13(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showResumeConfirm() {
        present(builder().setTitle(R.string.ocu_download_title).setMessage(this.context.getString(R.string.ocu_resume_msg, this.modelLabel)).setCancelable(false).addButton(R.string.ocu_cellular_continue, OtaAlertDialog.ButtonStyle.EMPHASIZED, new t(this, 11)).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new u(this, 9)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showResumeConfirm$lambda$10(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showResumeConfirm$lambda$11(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showServiceGuide() {
        present(builder().setTitle(R.string.ocu_service_title).setMessage(this.context.getString(R.string.ocu_service_msg)).setCancelable(false).addButton(R.string.ocu_service_goto, OtaAlertDialog.ButtonStyle.EMPHASIZED, new u(this, 3)).addButton(R.string.ocu_service_later, OtaAlertDialog.ButtonStyle.NORMAL, new t(this, 6)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showServiceGuide$lambda$28(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.openEnhancedServiceSettings();
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.OPEN_SERVICE_SETTINGS);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showServiceGuide$lambda$29(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showSwitchCellularDownload() {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_switch_dl_msg, this.modelLabel, getSizeLabel()) : this.context.getString(R.string.ocu_switch_dl_msg_no_size, this.modelLabel);
        kotlin.jvm.internal.g.c(string);
        present(builder().setTitle(R.string.ocu_switch_dl_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_switch_dl_continue, OtaAlertDialog.ButtonStyle.EMPHASIZED, new t(this, 10)).addButton(R.string.ocu_switch_dl_wait_wifi, OtaAlertDialog.ButtonStyle.NORMAL, new u(this, 8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showSwitchCellularDownload$lambda$14(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showSwitchCellularDownload$lambda$15(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showSwitchCellularUpdate() {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_switch_upd_msg, this.modelLabel, getSizeLabel(), updateLog()) : this.context.getString(R.string.ocu_switch_upd_msg_no_size, this.modelLabel, updateLog());
        kotlin.jvm.internal.g.c(string);
        present(builder().setTitle(R.string.ocu_switch_upd_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_switch_upd_continue, OtaAlertDialog.ButtonStyle.EMPHASIZED, new t(this, 12)).addButton(R.string.ocu_switch_upd_wait_wifi, OtaAlertDialog.ButtonStyle.NORMAL, new u(this, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showSwitchCellularUpdate$lambda$16(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showSwitchCellularUpdate$lambda$17(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showUnavailable() {
        present(builder().setTitle(this.context.getString(R.string.ocu_unavailable_msg, this.modelLabel)).setMessage(null).setCancelable(false).addButton(R.string.ocu_unavailable_confirm, OtaAlertDialog.ButtonStyle.EMPHASIZED, new u(this, 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showUnavailable$lambda$27(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showUpdateConfirm(zb.a<lb.n> aVar) {
        present(builder().setTitle(R.string.ocu_update_title).setMessage(updateLog()).setCancelable(false).addButton(R.string.ocu_update_now, OtaAlertDialog.ButtonStyle.EMPHASIZED, new cb.d(8, aVar, this)).addButton(R.string.ocu_update_later, OtaAlertDialog.ButtonStyle.NORMAL, new t(this, 5)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showUpdateConfirm$default(OtaConfirmDialogPresenter otaConfirmDialogPresenter, zb.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        otaConfirmDialogPresenter.showUpdateConfirm(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showUpdateConfirm$lambda$18(zb.a aVar, OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        if (aVar != null) {
            otaConfirmDialogPresenter.sink.stage(ConfirmDecisionBus.SubStage.CELLULAR_REMINDER);
            aVar.invoke();
        } else {
            otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM);
        }
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showUpdateConfirm$lambda$19(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    private final void showWifiGuide(boolean z) {
        OtaAlertDialog.Builder builderAddButton = builder().setTitle(R.string.ocu_wifi_guide_title).setMessage(this.context.getString(R.string.ocu_wifi_guide_msg, updateLog())).setCancelable(false).addButton(z ? R.string.ocu_wifi_enable_now : R.string.ocu_wifi_enable_and_update, OtaAlertDialog.ButtonStyle.EMPHASIZED, new cb.d(9, this, z ? ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_ONLY : ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_AND_UPDATE));
        if (z) {
            builderAddButton.addButton(R.string.ocu_service_later, OtaAlertDialog.ButtonStyle.NORMAL, new t(this, 2));
        } else {
            int i10 = R.string.ocu_wifi_update_direct;
            OtaAlertDialog.ButtonStyle buttonStyle = OtaAlertDialog.ButtonStyle.NORMAL;
            builderAddButton.addButton(i10, buttonStyle, new u(this, 1));
            builderAddButton.addButton(R.string.ocu_update_later, buttonStyle, new t(this, 3));
        }
        present(builderAddButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showWifiGuide$lambda$20(OtaConfirmDialogPresenter otaConfirmDialogPresenter, ConfirmDecisionBus.Decision decision) {
        otaConfirmDialogPresenter.sink.submit(decision);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showWifiGuide$lambda$21(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showWifiGuide$lambda$22(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showWifiGuide$lambda$23(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n start$lambda$1(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.showCellularUpdate(false);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n start$lambda$2(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.showCellularUpdate(true);
        return lb.n.f10413a;
    }

    private final boolean tryLocalOpenEnhancedServiceSettings() {
        Object objA;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.SubSettings");
            intent.putExtra(":settings:show_fragment", "com.stepos.settings.accessibility.StepOSEnhancedServiceFragment");
            intent.addFlags(268468224);
            this.context.startActivity(intent);
            objA = Boolean.TRUE;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.w("local open settings failed: ", thB.getClass().getSimpleName(), " ", thB.getMessage(), "OtaConfirmPresenter");
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final boolean tryRedirectViaAiEngine() {
        Object objA;
        boolean z;
        try {
            Intent intentAddFlags = new Intent(ACTION_OPEN_ENHANCED_SERVICE).setClassName(AIENGINE_PKG, ENHANCED_SERVICE_REDIRECT_CLASS).addFlags(268435456);
            kotlin.jvm.internal.g.e(intentAddFlags, "addFlags(...)");
            if (intentAddFlags.resolveActivity(this.context.getPackageManager()) == null) {
                Log.w("OtaConfirmPresenter", "redirect activity not present on this build");
                z = false;
            } else {
                this.context.startActivity(intentAddFlags);
                z = true;
            }
            objA = Boolean.valueOf(z);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.w("redirect via AIEngine failed: ", thB.getClass().getSimpleName(), " ", thB.getMessage(), "OtaConfirmPresenter");
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final String updateLog() {
        if (gc.q.t0(this.updateInfo)) {
            String string = this.context.getString(R.string.ocu_update_log_empty);
            kotlin.jvm.internal.g.c(string);
            return string;
        }
        String string2 = this.context.getString(R.string.ocu_update_log_prefix, this.updateInfo);
        kotlin.jvm.internal.g.c(string2);
        return string2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean start() {
        String plan = this.params.getPlan();
        switch (plan.hashCode()) {
            case -1533454946:
                if (plan.equals(ModelFlowMeta.PLAN_GATE_INSUFFICIENT_SPACE)) {
                    showResourceGate(R.string.ocu_gate_space_msg);
                    return true;
                }
                return false;
            case -1370383067:
                if (plan.equals(ModelFlowMeta.PLAN_DL_RESUME_CONFIRM)) {
                    showResumeConfirm();
                    return true;
                }
                return false;
            case -932319312:
                if (plan.equals(ModelFlowMeta.PLAN_DL_CELLULAR_REMINDER)) {
                    showCellularReminder();
                    return true;
                }
                return false;
            case -842789414:
                if (plan.equals(ModelFlowMeta.PLAN_GATE_SERVICE_DISABLED)) {
                    showServiceGuide();
                    return true;
                }
                return false;
            case -633829314:
                if (plan.equals(ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_OFF)) {
                    if (this.params.getUpdateConfirmFirst()) {
                        showUpdateConfirm(new t(this, 1));
                        return true;
                    }
                    showCellularUpdate(true);
                    return true;
                }
                return false;
            case -38012348:
                if (plan.equals(ModelFlowMeta.PLAN_DL_NO_NETWORK_GUIDE)) {
                    showNoNetworkGuide();
                    return true;
                }
                return false;
            case 131329925:
                if (plan.equals(ModelFlowMeta.PLAN_DL_RESUME_CELLULAR)) {
                    showResumeCellular();
                    return true;
                }
                return false;
            case 264901467:
                if (plan.equals(ModelFlowMeta.PLAN_DL_WIFI_TO_CELLULAR)) {
                    showSwitchCellularDownload();
                    return true;
                }
                return false;
            case 521900019:
                if (plan.equals(ModelFlowMeta.PLAN_UPD_WIFI_AUTO_OFF)) {
                    if (this.params.getUpdateConfirmFirst()) {
                        showUpdateConfirm$default(this, null, 1, null);
                        return true;
                    }
                    showWifiGuide(false);
                    return true;
                }
                return false;
            case 660809078:
                if (plan.equals(ModelFlowMeta.PLAN_DL_CONFIRM_THEN_CELLULAR)) {
                    showDownloadConfirm(true);
                    return true;
                }
                return false;
            case 848119483:
                if (plan.equals(ModelFlowMeta.PLAN_UPD_WIFI_AUTO_ON)) {
                    showUpdateConfirm$default(this, null, 1, null);
                    return true;
                }
                return false;
            case 1050369646:
                if (plan.equals(ModelFlowMeta.PLAN_GATE_LOW_BATTERY)) {
                    showResourceGate(R.string.ocu_gate_battery_msg);
                    return true;
                }
                return false;
            case 1226479888:
                if (plan.equals(ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_ON)) {
                    if (this.params.getUpdateConfirmFirst()) {
                        showUpdateConfirm(new u(this, 0));
                        return true;
                    }
                    showCellularUpdate(false);
                    return true;
                }
                return false;
            case 1487498288:
                if (plan.equals(ModelFlowMeta.PLAN_UNAVAILABLE)) {
                    showUnavailable();
                    return true;
                }
                return false;
            case 1702523377:
                if (plan.equals(ModelFlowMeta.PLAN_UPD_CELLULAR_REMINDER)) {
                    showCellularUpdate(false);
                    return true;
                }
                return false;
            case 2007072834:
                if (plan.equals(ModelFlowMeta.PLAN_DL_CONFIRM_ONLY)) {
                    showDownloadConfirm(false);
                    return true;
                }
                return false;
            case 2012464378:
                if (plan.equals(ModelFlowMeta.PLAN_UPD_WIFI_TO_CELLULAR)) {
                    showSwitchCellularUpdate();
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ OtaConfirmDialogPresenter(android.content.Context r9, com.stepos.core.ota.confirmui.ConfirmDialogParams r10, com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink r11, zb.l r12, java.lang.String r13, long r14, int r16, kotlin.jvm.internal.e r17) {
        /*
            r8 = this;
            r0 = r16 & 16
            if (r0 == 0) goto L6
            java.lang.String r13 = ""
        L6:
            r5 = r13
            r13 = r16 & 32
            if (r13 == 0) goto L14
            r0 = 0
            r6 = r0
            r2 = r10
            r3 = r11
            r4 = r12
            r0 = r8
            r1 = r9
            goto L1a
        L14:
            r6 = r14
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
        L1a:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.<init>(android.content.Context, com.stepos.core.ota.confirmui.ConfirmDialogParams, com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter$Sink, zb.l, java.lang.String, long, int, kotlin.jvm.internal.e):void");
    }
}
