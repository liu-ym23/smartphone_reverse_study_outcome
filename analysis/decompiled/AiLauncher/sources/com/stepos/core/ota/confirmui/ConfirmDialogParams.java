package com.stepos.core.ota.confirmui;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.core.download.ModelFlowMeta;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmDialogParams;", "", "plan", "", "sizeBytes", "", "modelLabel", "updateInfo", "deferCellularToGate", "", OtaConfirmTrampolineActivity.EXTRA_UPDATE_CONFIRM_FIRST, "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZ)V", "getPlan", "()Ljava/lang/String;", "getSizeBytes", "()J", "getModelLabel", "getUpdateInfo", "getDeferCellularToGate", "()Z", "getUpdateConfirmFirst", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "Companion", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConfirmDialogParams {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean deferCellularToGate;
    private final String modelLabel;
    private final String plan;
    private final long sizeBytes;
    private final boolean updateConfirmFirst;
    private final String updateInfo;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0013"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmDialogParams$Companion;", "", "<init>", "()V", "unavailable", "Lcom/stepos/core/ota/confirmui/ConfirmDialogParams;", "modelLabel", "", "noNetworkGuide", "insufficientSpace", "lowBattery", "serviceDisabled", "cellularReminderDownload", "sizeBytes", "", "cellularReminderUpdate", "updateInfo", "resumeConfirm", "resumeCellular", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ConfirmDialogParams cellularReminderDownload(String modelLabel, long sizeBytes) {
            kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_DL_CELLULAR_REMINDER, sizeBytes, modelLabel, "", false, false, 48, null);
        }

        public final ConfirmDialogParams cellularReminderUpdate(String modelLabel, long sizeBytes, String updateInfo) {
            kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
            kotlin.jvm.internal.p.i(updateInfo, "updateInfo");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_UPD_CELLULAR_REMINDER, sizeBytes, modelLabel, updateInfo, false, false, 48, null);
        }

        public final ConfirmDialogParams insufficientSpace() {
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_GATE_INSUFFICIENT_SPACE, 0L, "", "", false, false, 48, null);
        }

        public final ConfirmDialogParams lowBattery() {
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_GATE_LOW_BATTERY, 0L, "", "", false, false, 48, null);
        }

        public final ConfirmDialogParams noNetworkGuide(String modelLabel) {
            kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_DL_NO_NETWORK_GUIDE, 0L, modelLabel, "", false, false, 48, null);
        }

        public final ConfirmDialogParams resumeCellular(String modelLabel) {
            kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_DL_RESUME_CELLULAR, 0L, modelLabel, "", false, false, 48, null);
        }

        public final ConfirmDialogParams resumeConfirm(String modelLabel) {
            kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_DL_RESUME_CONFIRM, 0L, modelLabel, "", false, false, 48, null);
        }

        public final ConfirmDialogParams serviceDisabled() {
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_GATE_SERVICE_DISABLED, 0L, "", "", false, false, 48, null);
        }

        public final ConfirmDialogParams unavailable(String modelLabel) {
            kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_UNAVAILABLE, 0L, modelLabel, "", false, false, 48, null);
        }

        private Companion() {
        }
    }

    public ConfirmDialogParams(String plan, long j10, String modelLabel, String updateInfo, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(plan, "plan");
        kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
        kotlin.jvm.internal.p.i(updateInfo, "updateInfo");
        this.plan = plan;
        this.sizeBytes = j10;
        this.modelLabel = modelLabel;
        this.updateInfo = updateInfo;
        this.deferCellularToGate = z10;
        this.updateConfirmFirst = z11;
    }

    public static /* synthetic */ ConfirmDialogParams copy$default(ConfirmDialogParams confirmDialogParams, String str, long j10, String str2, String str3, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = confirmDialogParams.plan;
        }
        if ((i10 & 2) != 0) {
            j10 = confirmDialogParams.sizeBytes;
        }
        if ((i10 & 4) != 0) {
            str2 = confirmDialogParams.modelLabel;
        }
        if ((i10 & 8) != 0) {
            str3 = confirmDialogParams.updateInfo;
        }
        if ((i10 & 16) != 0) {
            z10 = confirmDialogParams.deferCellularToGate;
        }
        if ((i10 & 32) != 0) {
            z11 = confirmDialogParams.updateConfirmFirst;
        }
        return confirmDialogParams.copy(str, j10, str2, str3, z10, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPlan() {
        return this.plan;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModelLabel() {
        return this.modelLabel;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getDeferCellularToGate() {
        return this.deferCellularToGate;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getUpdateConfirmFirst() {
        return this.updateConfirmFirst;
    }

    public final ConfirmDialogParams copy(String plan, long sizeBytes, String modelLabel, String updateInfo, boolean deferCellularToGate, boolean updateConfirmFirst) {
        kotlin.jvm.internal.p.i(plan, "plan");
        kotlin.jvm.internal.p.i(modelLabel, "modelLabel");
        kotlin.jvm.internal.p.i(updateInfo, "updateInfo");
        return new ConfirmDialogParams(plan, sizeBytes, modelLabel, updateInfo, deferCellularToGate, updateConfirmFirst);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmDialogParams)) {
            return false;
        }
        ConfirmDialogParams confirmDialogParams = (ConfirmDialogParams) other;
        return kotlin.jvm.internal.p.d(this.plan, confirmDialogParams.plan) && this.sizeBytes == confirmDialogParams.sizeBytes && kotlin.jvm.internal.p.d(this.modelLabel, confirmDialogParams.modelLabel) && kotlin.jvm.internal.p.d(this.updateInfo, confirmDialogParams.updateInfo) && this.deferCellularToGate == confirmDialogParams.deferCellularToGate && this.updateConfirmFirst == confirmDialogParams.updateConfirmFirst;
    }

    public final boolean getDeferCellularToGate() {
        return this.deferCellularToGate;
    }

    public final String getModelLabel() {
        return this.modelLabel;
    }

    public final String getPlan() {
        return this.plan;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final boolean getUpdateConfirmFirst() {
        return this.updateConfirmFirst;
    }

    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    public int hashCode() {
        return (((((((((this.plan.hashCode() * 31) + Long.hashCode(this.sizeBytes)) * 31) + this.modelLabel.hashCode()) * 31) + this.updateInfo.hashCode()) * 31) + Boolean.hashCode(this.deferCellularToGate)) * 31) + Boolean.hashCode(this.updateConfirmFirst);
    }

    public String toString() {
        return "ConfirmDialogParams(plan=" + this.plan + ", sizeBytes=" + this.sizeBytes + ", modelLabel=" + this.modelLabel + ", updateInfo=" + this.updateInfo + ", deferCellularToGate=" + this.deferCellularToGate + ", updateConfirmFirst=" + this.updateConfirmFirst + ")";
    }

    public /* synthetic */ ConfirmDialogParams(String str, long j10, String str2, String str3, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this(str, j10, str2, str3, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11);
    }
}
