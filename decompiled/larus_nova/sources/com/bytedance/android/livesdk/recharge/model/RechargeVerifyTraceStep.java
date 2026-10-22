package com.bytedance.android.livesdk.recharge.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/recharge/model/RechargeVerifyTraceStep;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "STEP_RECHARGE_MINOR_VERIFY_2", "STEP_RECHARGE_MINOR_VERIFY_3", "STEP_RECHARGE_VERIFY_CONFIRM_CLICK", "STEP_RECHARGE_VERIFY_CANCEL_CLICK", "STEP_RECHARGE_VERIFY_CONFLICT_OPT", "STEP_RECHARGE_COMMON_VERIFY_START", "STEP_RECHARGE_VERIFY_SDK", "STEP_RECHARGE_VERIFY_RESULT", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RechargeVerifyTraceStep extends Enum<RechargeVerifyTraceStep> {
    public static final RechargeVerifyTraceStep STEP_RECHARGE_COMMON_VERIFY_START = null;
    public static final RechargeVerifyTraceStep STEP_RECHARGE_MINOR_VERIFY_2 = null;
    public static final RechargeVerifyTraceStep STEP_RECHARGE_MINOR_VERIFY_3 = null;
    public static final RechargeVerifyTraceStep STEP_RECHARGE_VERIFY_CANCEL_CLICK = null;
    public static final RechargeVerifyTraceStep STEP_RECHARGE_VERIFY_CONFIRM_CLICK = null;
    public static final RechargeVerifyTraceStep STEP_RECHARGE_VERIFY_CONFLICT_OPT = null;
    public static final RechargeVerifyTraceStep STEP_RECHARGE_VERIFY_RESULT = null;
    public static final RechargeVerifyTraceStep STEP_RECHARGE_VERIFY_SDK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RechargeVerifyTraceStep[] f157046a = null;
    private final String value;

    public static RechargeVerifyTraceStep valueOf(String r100) {
        return (RechargeVerifyTraceStep) a.a(RechargeVerifyTraceStep.class, r100);
    }

    public static RechargeVerifyTraceStep[] values() {
        return (RechargeVerifyTraceStep[]) f157046a.clone();
    }

    static {
        RechargeVerifyTraceStep r100 = new RechargeVerifyTraceStep("STEP_RECHARGE_MINOR_VERIFY_2", 0, "step_recharge_verify_minor_old");
        STEP_RECHARGE_MINOR_VERIFY_2 = r100;
        RechargeVerifyTraceStep r101 = new RechargeVerifyTraceStep("STEP_RECHARGE_MINOR_VERIFY_3", 1, "step_recharge_verify_minor_new");
        STEP_RECHARGE_MINOR_VERIFY_3 = r101;
        RechargeVerifyTraceStep r102 = new RechargeVerifyTraceStep("STEP_RECHARGE_VERIFY_CONFIRM_CLICK", 2, "step_recharge_verify_confirm_click");
        STEP_RECHARGE_VERIFY_CONFIRM_CLICK = r102;
        RechargeVerifyTraceStep r103 = new RechargeVerifyTraceStep("STEP_RECHARGE_VERIFY_CANCEL_CLICK", 3, "step_recharge_verify_cancel_click");
        STEP_RECHARGE_VERIFY_CANCEL_CLICK = r103;
        RechargeVerifyTraceStep r104 = new RechargeVerifyTraceStep("STEP_RECHARGE_VERIFY_CONFLICT_OPT", 4, "step_recharge_verify_conflict_opt");
        STEP_RECHARGE_VERIFY_CONFLICT_OPT = r104;
        RechargeVerifyTraceStep r105 = new RechargeVerifyTraceStep("STEP_RECHARGE_COMMON_VERIFY_START", 5, "step_recharge_common_verify_start");
        STEP_RECHARGE_COMMON_VERIFY_START = r105;
        RechargeVerifyTraceStep r106 = new RechargeVerifyTraceStep("STEP_RECHARGE_VERIFY_SDK", 6, "step_recharge_verify_sdk");
        STEP_RECHARGE_VERIFY_SDK = r106;
        RechargeVerifyTraceStep r107 = new RechargeVerifyTraceStep("STEP_RECHARGE_VERIFY_RESULT", 7, "step_recharge_verify_result");
        STEP_RECHARGE_VERIFY_RESULT = r107;
        f157046a = new RechargeVerifyTraceStep[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getValue() {
        return this.value;
    }

    public RechargeVerifyTraceStep(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
