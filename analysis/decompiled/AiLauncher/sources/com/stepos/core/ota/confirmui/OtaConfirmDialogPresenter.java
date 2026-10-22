package com.stepos.core.ota.confirmui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.core.ability.AbilityType;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.OtaAlertDialog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0013\b\u0000\u0018\u0000 A2\u00020\u0001:\u0002BABG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\n*\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u001cJ!\u0010$\u001a\u00020\n2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0017H\u0002¢\u0006\u0004\b'\u0010\u001aJ\u0017\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0017H\u0002¢\u0006\u0004\b)\u0010\u001aJ\u000f\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010\u001cJ\u000f\u0010+\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010\u001cJ\u000f\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010\u001cJ\u000f\u0010-\u001a\u00020\u0017H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0017H\u0002¢\u0006\u0004\b/\u0010.J\u0017\u00102\u001a\u00020\n2\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\fH\u0002¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0017¢\u0006\u0004\b6\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00107R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00108R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00109R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010:R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010;R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010<R\u0014\u0010=\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010>\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010;R\u0014\u0010@\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u00105¨\u0006C"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaConfirmDialogPresenter;", "", "Landroid/content/Context;", "context", "Lcom/stepos/core/ota/confirmui/ConfirmDialogParams;", "params", "Lcom/stepos/core/ota/confirmui/OtaConfirmDialogPresenter$Sink;", "sink", "Lkotlin/Function1;", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog;", "LY8/t;", "onShow", "", OtaConfirmTrampolineActivity.EXTRA_TRACE_ID, "", OtaConfirmTrampolineActivity.EXTRA_T0, "<init>", "(Landroid/content/Context;Lcom/stepos/core/ota/confirmui/ConfirmDialogParams;Lcom/stepos/core/ota/confirmui/OtaConfirmDialogPresenter$Sink;Lp9/l;Ljava/lang/String;J)V", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;", "builder", "()Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;", "present", "(Lcom/stepos/core/ota/confirmui/OtaAlertDialog$Builder;)V", "", "thenCellular", "showDownloadConfirm", "(Z)V", "showNoNetworkGuide", "()V", "showCellularReminder", "showResumeConfirm", "showResumeCellular", "showSwitchCellularDownload", "showSwitchCellularUpdate", "Lkotlin/Function0;", "next", "showUpdateConfirm", "(Lp9/a;)V", "fromCellular", "showWifiGuide", "threeButton", "showCellularUpdate", "showUnavailable", "showServiceGuide", "openEnhancedServiceSettings", "tryRedirectViaAiEngine", "()Z", "tryLocalOpenEnhancedServiceSettings", "", "msgResId", "showResourceGate", "(I)V", "updateLog", "()Ljava/lang/String;", "start", "Landroid/content/Context;", "Lcom/stepos/core/ota/confirmui/ConfirmDialogParams;", "Lcom/stepos/core/ota/confirmui/OtaConfirmDialogPresenter$Sink;", "Lp9/l;", "Ljava/lang/String;", "J", "modelLabel", "updateInfo", "getSizeLabel", "sizeLabel", "Companion", "Sink", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OtaConfirmDialogPresenter {
    private static final String ACTION_OPEN_ENHANCED_SERVICE = "com.stepos.aiengine.action.OPEN_ENHANCED_SERVICE_SETTINGS";
    private static final String AIENGINE_PKG = "com.stepos.aiengine";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ENHANCED_SERVICE_REDIRECT_CLASS = "com.stepos.aiengine.settings.EnhancedServiceRedirectActivity";
    private final Context context;
    private final String modelLabel;
    private final InterfaceC5074l<OtaAlertDialog, Y8.t> onShow;
    private final ConfirmDialogParams params;
    private final long perfT0;
    private final String perfTraceId;
    private final Sink sink;
    private final String updateInfo;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaConfirmDialogPresenter$Companion;", "", "<init>", "()V", "AIENGINE_PKG", "", "ENHANCED_SERVICE_REDIRECT_CLASS", "ACTION_OPEN_ENHANCED_SERVICE", "formatSize", SingleFileBundle.KEY_BYTES, "", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String formatSize(long bytes) {
            String str;
            double d10 = bytes / 1048576.0d;
            if (d10 >= 1024.0d) {
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                str = String.format(Locale.US, "%.1fGB", Arrays.copyOf(new Object[]{Double.valueOf(d10 / 1024)}, 1));
            } else {
                kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
                str = String.format(Locale.US, "%.0fMB", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1));
            }
            kotlin.jvm.internal.p.h(str, "format(...)");
            return str;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/core/ota/confirmui/OtaConfirmDialogPresenter$Sink;", "", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;", "decision", "LY8/t;", "submit", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;)V", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;", "stage", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;)V", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Sink {
        void stage(ConfirmDecisionBus.SubStage stage);

        void submit(ConfirmDecisionBus.Decision decision);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OtaConfirmDialogPresenter(Context context, ConfirmDialogParams params, Sink sink, InterfaceC5074l<? super OtaAlertDialog, Y8.t> onShow, String perfTraceId, long j10) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(sink, "sink");
        kotlin.jvm.internal.p.i(onShow, "onShow");
        kotlin.jvm.internal.p.i(perfTraceId, "perfTraceId");
        this.context = context;
        this.params = params;
        this.sink = sink;
        this.onShow = onShow;
        this.perfTraceId = perfTraceId;
        this.perfT0 = j10;
        String modelLabel = params.getModelLabel();
        if (modelLabel.length() == 0) {
            modelLabel = context.getString(R.string.ocu_default_model);
            kotlin.jvm.internal.p.h(modelLabel, "getString(...)");
        }
        this.modelLabel = modelLabel;
        this.updateInfo = params.getUpdateInfo();
    }

    private final OtaAlertDialog.Builder builder() {
        return new OtaAlertDialog.Builder(this.context);
    }

    private final String getSizeLabel() {
        return this.params.getSizeBytes() > 0 ? INSTANCE.formatSize(this.params.getSizeBytes()) : "";
    }

    private final void openEnhancedServiceSettings() {
        Object objB;
        if (tryRedirectViaAiEngine()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            InterfaceC5074l<Context, Integer> launcher = EnhancedServiceGuide.getLauncher();
            objB = Result.b(launcher != null ? launcher.invoke(this.context) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Integer num = (Integer) (Result.g(objB) ? null : objB);
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
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
    }

    private final void present(OtaAlertDialog.Builder builder) {
        OtaAlertDialog otaAlertDialogCreate = builder.create();
        otaAlertDialogCreate.show();
        this.onShow.invoke(otaAlertDialogCreate);
        ConfirmPerf.INSTANCE.mark(this.perfTraceId, this.perfT0, "DIALOG_SHOWN", "plan=" + this.params.getPlan());
    }

    private final void showCellularReminder() {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_cellular_msg, this.modelLabel, getSizeLabel()) : this.context.getString(R.string.ocu_cellular_msg_no_size, this.modelLabel);
        kotlin.jvm.internal.p.f(string);
        present(builder().setTitle(R.string.ocu_cellular_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_download_now, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.k0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showCellularReminder$lambda$8(this.f29598a);
            }
        }).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.l0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showCellularReminder$lambda$9(this.f29600a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showCellularReminder$lambda$8(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showCellularReminder$lambda$9(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showCellularUpdate(boolean threeButton) {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_cellular_update_msg, this.modelLabel, getSizeLabel(), updateLog()) : this.context.getString(R.string.ocu_cellular_update_msg_no_size, updateLog());
        kotlin.jvm.internal.p.f(string);
        OtaAlertDialog.Builder builderAddButton = builder().setTitle(R.string.ocu_cellular_update_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_update_now, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.m0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showCellularUpdate$lambda$24(this.f29602a);
            }
        });
        if (threeButton) {
            builderAddButton.addButton(R.string.ocu_connect_wifi_auto, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.n0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return OtaConfirmDialogPresenter.showCellularUpdate$lambda$25(this.f29606a);
                }
            });
        }
        present(builderAddButton.addButton(R.string.ocu_update_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.o0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showCellularUpdate$lambda$26(this.f29607a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showCellularUpdate$lambda$24(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showCellularUpdate$lambda$25(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.stage(ConfirmDecisionBus.SubStage.WIFI_GUIDE);
        otaConfirmDialogPresenter.showWifiGuide(true);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showCellularUpdate$lambda$26(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showDownloadConfirm(final boolean thenCellular) {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_download_msg, this.modelLabel, getSizeLabel()) : this.context.getString(R.string.ocu_download_msg_no_size, this.modelLabel);
        kotlin.jvm.internal.p.f(string);
        present(builder().setTitle(R.string.ocu_download_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_download_now, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.c0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showDownloadConfirm$lambda$4(thenCellular, this);
            }
        }).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.d0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showDownloadConfirm$lambda$5(this.f29579a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showDownloadConfirm$lambda$4(boolean z10, OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        if (!z10 || otaConfirmDialogPresenter.params.getDeferCellularToGate()) {
            otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM);
        } else {
            otaConfirmDialogPresenter.sink.stage(ConfirmDecisionBus.SubStage.CELLULAR_REMINDER);
            otaConfirmDialogPresenter.showCellularReminder();
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showDownloadConfirm$lambda$5(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showNoNetworkGuide() {
        String modelLabel = this.params.getModelLabel();
        Locale US = Locale.US;
        kotlin.jvm.internal.p.h(US, "US");
        String lowerCase = modelLabel.toLowerCase(US);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        String str = null;
        if (La.H.g0(lowerCase, AbilityType.ASR, false, 2, null)) {
            str = "ASR";
        } else if (La.H.g0(lowerCase, "tts", false, 2, null)) {
            str = "TTS";
        }
        String string = str != null ? this.context.getString(R.string.ocu_no_net_msg_voice, str) : this.context.getString(R.string.ocu_no_net_msg_generic);
        kotlin.jvm.internal.p.f(string);
        present(builder().setTitle(R.string.ocu_no_net_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_no_net_connect_wifi, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.w0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showNoNetworkGuide$lambda$6(this.f29630a);
            }
        }).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.V
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showNoNetworkGuide$lambda$7(this.f29563a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showNoNetworkGuide$lambda$6(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.SCHEDULE_WIFI_DOWNLOAD);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showNoNetworkGuide$lambda$7(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showResourceGate(int msgResId) {
        present(builder().setTitle(this.context.getString(msgResId)).setMessage(null).setCancelable(false).addButton(R.string.ocu_gate_confirm, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.v0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showResourceGate$lambda$37(this.f29629a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showResourceGate$lambda$37(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showResumeCellular() {
        present(builder().setTitle(R.string.ocu_cellular_title).setMessage(this.context.getString(R.string.ocu_resume_cellular_msg, this.modelLabel)).setCancelable(false).addButton(R.string.ocu_cellular_continue, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.i0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showResumeCellular$lambda$12(this.f29592a);
            }
        }).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.j0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showResumeCellular$lambda$13(this.f29594a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showResumeCellular$lambda$12(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showResumeCellular$lambda$13(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showResumeConfirm() {
        present(builder().setTitle(R.string.ocu_download_title).setMessage(this.context.getString(R.string.ocu_resume_msg, this.modelLabel)).setCancelable(false).addButton(R.string.ocu_cellular_continue, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.r0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showResumeConfirm$lambda$10(this.f29616a);
            }
        }).addButton(R.string.ocu_download_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.s0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showResumeConfirm$lambda$11(this.f29618a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showResumeConfirm$lambda$10(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showResumeConfirm$lambda$11(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showServiceGuide() {
        present(builder().setTitle(R.string.ocu_service_title).setMessage(this.context.getString(R.string.ocu_service_msg)).setCancelable(false).addButton(R.string.ocu_service_goto, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.g0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showServiceGuide$lambda$28(this.f29586a);
            }
        }).addButton(R.string.ocu_service_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.h0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showServiceGuide$lambda$29(this.f29589a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showServiceGuide$lambda$28(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.openEnhancedServiceSettings();
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.OPEN_SERVICE_SETTINGS);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showServiceGuide$lambda$29(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showSwitchCellularDownload() {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_switch_dl_msg, this.modelLabel, getSizeLabel()) : this.context.getString(R.string.ocu_switch_dl_msg_no_size, this.modelLabel);
        kotlin.jvm.internal.p.f(string);
        present(builder().setTitle(R.string.ocu_switch_dl_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_switch_dl_continue, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.p0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showSwitchCellularDownload$lambda$14(this.f29609a);
            }
        }).addButton(R.string.ocu_switch_dl_wait_wifi, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.q0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showSwitchCellularDownload$lambda$15(this.f29614a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showSwitchCellularDownload$lambda$14(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showSwitchCellularDownload$lambda$15(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showSwitchCellularUpdate() {
        String string = getSizeLabel().length() > 0 ? this.context.getString(R.string.ocu_switch_upd_msg, this.modelLabel, getSizeLabel(), updateLog()) : this.context.getString(R.string.ocu_switch_upd_msg_no_size, this.modelLabel, updateLog());
        kotlin.jvm.internal.p.f(string);
        present(builder().setTitle(R.string.ocu_switch_upd_title).setMessage(string).setCancelable(false).addButton(R.string.ocu_switch_upd_continue, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.t0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showSwitchCellularUpdate$lambda$16(this.f29620a);
            }
        }).addButton(R.string.ocu_switch_upd_wait_wifi, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.u0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showSwitchCellularUpdate$lambda$17(this.f29622a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showSwitchCellularUpdate$lambda$16(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM_CELLULAR);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showSwitchCellularUpdate$lambda$17(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showUnavailable() {
        present(builder().setTitle(this.context.getString(R.string.ocu_unavailable_msg, this.modelLabel)).setMessage(null).setCancelable(false).addButton(R.string.ocu_unavailable_confirm, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.e0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showUnavailable$lambda$27(this.f29581a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showUnavailable$lambda$27(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showUpdateConfirm(final InterfaceC5063a<Y8.t> next) {
        present(builder().setTitle(R.string.ocu_update_title).setMessage(updateLog()).setCancelable(false).addButton(R.string.ocu_update_now, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.U
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showUpdateConfirm$lambda$18(next, this);
            }
        }).addButton(R.string.ocu_update_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.f0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showUpdateConfirm$lambda$19(this.f29583a);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showUpdateConfirm$default(OtaConfirmDialogPresenter otaConfirmDialogPresenter, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5063a = null;
        }
        otaConfirmDialogPresenter.showUpdateConfirm(interfaceC5063a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showUpdateConfirm$lambda$18(InterfaceC5063a interfaceC5063a, OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        if (interfaceC5063a != null) {
            otaConfirmDialogPresenter.sink.stage(ConfirmDecisionBus.SubStage.CELLULAR_REMINDER);
            interfaceC5063a.invoke();
        } else {
            otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showUpdateConfirm$lambda$19(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    private final void showWifiGuide(boolean fromCellular) {
        int i10 = fromCellular ? R.string.ocu_wifi_enable_now : R.string.ocu_wifi_enable_and_update;
        final ConfirmDecisionBus.Decision decision = fromCellular ? ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_ONLY : ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_AND_UPDATE;
        OtaAlertDialog.Builder builderAddButton = builder().setTitle(R.string.ocu_wifi_guide_title).setMessage(this.context.getString(R.string.ocu_wifi_guide_msg, updateLog())).setCancelable(false).addButton(i10, OtaAlertDialog.ButtonStyle.EMPHASIZED, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.Y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OtaConfirmDialogPresenter.showWifiGuide$lambda$20(this.f29566a, decision);
            }
        });
        if (fromCellular) {
            builderAddButton.addButton(R.string.ocu_service_later, OtaAlertDialog.ButtonStyle.NORMAL, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.Z
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return OtaConfirmDialogPresenter.showWifiGuide$lambda$21(this.f29568a);
                }
            });
        } else {
            int i11 = R.string.ocu_wifi_update_direct;
            OtaAlertDialog.ButtonStyle buttonStyle = OtaAlertDialog.ButtonStyle.NORMAL;
            builderAddButton.addButton(i11, buttonStyle, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.a0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return OtaConfirmDialogPresenter.showWifiGuide$lambda$22(this.f29570a);
                }
            });
            builderAddButton.addButton(R.string.ocu_update_later, buttonStyle, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.b0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return OtaConfirmDialogPresenter.showWifiGuide$lambda$23(this.f29572a);
                }
            });
        }
        present(builderAddButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showWifiGuide$lambda$20(OtaConfirmDialogPresenter otaConfirmDialogPresenter, ConfirmDecisionBus.Decision decision) {
        otaConfirmDialogPresenter.sink.submit(decision);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showWifiGuide$lambda$21(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showWifiGuide$lambda$22(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CONFIRM);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showWifiGuide$lambda$23(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.sink.submit(ConfirmDecisionBus.Decision.CANCEL);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t start$lambda$1(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.showCellularUpdate(false);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t start$lambda$2(OtaConfirmDialogPresenter otaConfirmDialogPresenter) {
        otaConfirmDialogPresenter.showCellularUpdate(true);
        return Y8.t.f7040a;
    }

    private final boolean tryLocalOpenEnhancedServiceSettings() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.SubSettings");
            intent.putExtra(":settings:show_fragment", "com.stepos.settings.accessibility.StepOSEnhancedServiceFragment");
            intent.addFlags(268468224);
            this.context.startActivity(intent);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("OtaConfirmPresenter", "local open settings failed: " + thE.getClass().getSimpleName() + " " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    private final boolean tryRedirectViaAiEngine() {
        Object objB;
        boolean z10;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intentAddFlags = new Intent(ACTION_OPEN_ENHANCED_SERVICE).setClassName(AIENGINE_PKG, ENHANCED_SERVICE_REDIRECT_CLASS).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            kotlin.jvm.internal.p.h(intentAddFlags, "addFlags(...)");
            if (intentAddFlags.resolveActivity(this.context.getPackageManager()) == null) {
                Log.w("OtaConfirmPresenter", "redirect activity not present on this build");
                z10 = false;
            } else {
                this.context.startActivity(intentAddFlags);
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("OtaConfirmPresenter", "redirect via AIEngine failed: " + thE.getClass().getSimpleName() + " " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    private final String updateLog() {
        if (La.H.x0(this.updateInfo)) {
            String string = this.context.getString(R.string.ocu_update_log_empty);
            kotlin.jvm.internal.p.f(string);
            return string;
        }
        String string2 = this.context.getString(R.string.ocu_update_log_prefix, this.updateInfo);
        kotlin.jvm.internal.p.f(string2);
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
                        showUpdateConfirm(new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.X
                            @Override // p9.InterfaceC5063a
                            public final Object invoke() {
                                return OtaConfirmDialogPresenter.start$lambda$2(this.f29565a);
                            }
                        });
                    } else {
                        showCellularUpdate(true);
                    }
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
                    } else {
                        showWifiGuide(false);
                    }
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
                        showUpdateConfirm(new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.W
                            @Override // p9.InterfaceC5063a
                            public final Object invoke() {
                                return OtaConfirmDialogPresenter.start$lambda$1(this.f29564a);
                            }
                        });
                    } else {
                        showCellularUpdate(false);
                    }
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
        java.lang.NullPointerException
        */
    public /* synthetic */ OtaConfirmDialogPresenter(android.content.Context r9, com.stepos.core.ota.confirmui.ConfirmDialogParams r10, com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink r11, p9.InterfaceC5074l r12, java.lang.String r13, long r14, int r16, kotlin.jvm.internal.i r17) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.<init>(android.content.Context, com.stepos.core.ota.confirmui.ConfirmDialogParams, com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter$Sink, p9.l, java.lang.String, long, int, kotlin.jvm.internal.i):void");
    }
}
