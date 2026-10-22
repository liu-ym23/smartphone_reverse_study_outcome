package com.stepos.core.ota.confirmui;

import com.stepos.core.download.ModelFlowMeta;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ConfirmDialogParams {
    public static final Companion Companion = new Companion(null);
    private final boolean deferCellularToGate;
    private final String modelLabel;
    private final String plan;
    private final long sizeBytes;
    private final boolean updateConfirmFirst;
    private final String updateInfo;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final ConfirmDialogParams cellularReminderDownload(String modelLabel, long j10) {
            kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_DL_CELLULAR_REMINDER, j10, modelLabel, "", false, false, 48, null);
        }

        public final ConfirmDialogParams cellularReminderUpdate(String modelLabel, long j10, String updateInfo) {
            kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
            kotlin.jvm.internal.g.f(updateInfo, "updateInfo");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_UPD_CELLULAR_REMINDER, j10, modelLabel, updateInfo, false, false, 48, null);
        }

        public final ConfirmDialogParams insufficientSpace() {
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_GATE_INSUFFICIENT_SPACE, 0L, "", "", false, false, 48, null);
        }

        public final ConfirmDialogParams lowBattery() {
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_GATE_LOW_BATTERY, 0L, "", "", false, false, 48, null);
        }

        public final ConfirmDialogParams noNetworkGuide(String modelLabel) {
            kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_DL_NO_NETWORK_GUIDE, 0L, modelLabel, "", false, false, 48, null);
        }

        public final ConfirmDialogParams resumeCellular(String modelLabel) {
            kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_DL_RESUME_CELLULAR, 0L, modelLabel, "", false, false, 48, null);
        }

        public final ConfirmDialogParams resumeConfirm(String modelLabel) {
            kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_DL_RESUME_CONFIRM, 0L, modelLabel, "", false, false, 48, null);
        }

        public final ConfirmDialogParams serviceDisabled() {
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_GATE_SERVICE_DISABLED, 0L, "", "", false, false, 48, null);
        }

        public final ConfirmDialogParams unavailable(String modelLabel) {
            kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
            return new ConfirmDialogParams(ModelFlowMeta.PLAN_UNAVAILABLE, 0L, modelLabel, "", false, false, 48, null);
        }

        private Companion() {
        }
    }

    public ConfirmDialogParams(String plan, long j10, String modelLabel, String updateInfo, boolean z, boolean z3) {
        kotlin.jvm.internal.g.f(plan, "plan");
        kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
        kotlin.jvm.internal.g.f(updateInfo, "updateInfo");
        this.plan = plan;
        this.sizeBytes = j10;
        this.modelLabel = modelLabel;
        this.updateInfo = updateInfo;
        this.deferCellularToGate = z;
        this.updateConfirmFirst = z3;
    }

    public static /* synthetic */ ConfirmDialogParams copy$default(ConfirmDialogParams confirmDialogParams, String str, long j10, String str2, String str3, boolean z, boolean z3, int i10, Object obj) {
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
            z = confirmDialogParams.deferCellularToGate;
        }
        if ((i10 & 32) != 0) {
            z3 = confirmDialogParams.updateConfirmFirst;
        }
        return confirmDialogParams.copy(str, j10, str2, str3, z, z3);
    }

    public final String component1() {
        return this.plan;
    }

    public final long component2() {
        return this.sizeBytes;
    }

    public final String component3() {
        return this.modelLabel;
    }

    public final String component4() {
        return this.updateInfo;
    }

    public final boolean component5() {
        return this.deferCellularToGate;
    }

    public final boolean component6() {
        return this.updateConfirmFirst;
    }

    public final ConfirmDialogParams copy(String plan, long j10, String modelLabel, String updateInfo, boolean z, boolean z3) {
        kotlin.jvm.internal.g.f(plan, "plan");
        kotlin.jvm.internal.g.f(modelLabel, "modelLabel");
        kotlin.jvm.internal.g.f(updateInfo, "updateInfo");
        return new ConfirmDialogParams(plan, j10, modelLabel, updateInfo, z, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmDialogParams)) {
            return false;
        }
        ConfirmDialogParams confirmDialogParams = (ConfirmDialogParams) obj;
        return kotlin.jvm.internal.g.b(this.plan, confirmDialogParams.plan) && this.sizeBytes == confirmDialogParams.sizeBytes && kotlin.jvm.internal.g.b(this.modelLabel, confirmDialogParams.modelLabel) && kotlin.jvm.internal.g.b(this.updateInfo, confirmDialogParams.updateInfo) && this.deferCellularToGate == confirmDialogParams.deferCellularToGate && this.updateConfirmFirst == confirmDialogParams.updateConfirmFirst;
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
        return Boolean.hashCode(this.updateConfirmFirst) + ai.onnxruntime.a.f(v1.d.a(v1.d.a(a0.a.c(this.plan.hashCode() * 31, this.sizeBytes, 31), 31, this.modelLabel), 31, this.updateInfo), 31, this.deferCellularToGate);
    }

    public String toString() {
        String str = this.plan;
        long j10 = this.sizeBytes;
        String str2 = this.modelLabel;
        String str3 = this.updateInfo;
        boolean z = this.deferCellularToGate;
        boolean z3 = this.updateConfirmFirst;
        StringBuilder sbL = com.stepos.core.ota.d.l("ConfirmDialogParams(plan=", j10, str, ", sizeBytes=");
        ai.onnxruntime.a.z(sbL, ", modelLabel=", str2, ", updateInfo=", str3);
        sbL.append(", deferCellularToGate=");
        sbL.append(z);
        sbL.append(", updateConfirmFirst=");
        sbL.append(z3);
        sbL.append(")");
        return sbL.toString();
    }

    public /* synthetic */ ConfirmDialogParams(String str, long j10, String str2, String str3, boolean z, boolean z3, int i10, kotlin.jvm.internal.e eVar) {
        this(str, j10, str2, str3, (i10 & 16) != 0 ? false : z, (i10 & 32) != 0 ? false : z3);
    }
}
