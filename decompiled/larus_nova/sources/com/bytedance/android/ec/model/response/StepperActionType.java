package com.bytedance.android.ec.model.response;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/model/response/StepperActionType;", "", "STEPPER_ADD", "STEPPER_SUB", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum StepperActionType extends Enum<StepperActionType> {
    public static final StepperActionType STEPPER_ADD = null;
    public static final StepperActionType STEPPER_SUB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StepperActionType[] f47923a = null;

    static {
        StepperActionType r100 = new StepperActionType("STEPPER_ADD", 0);
        STEPPER_ADD = r100;
        StepperActionType r101 = new StepperActionType("STEPPER_SUB", 1);
        STEPPER_SUB = r101;
        f47923a = new StepperActionType[]{r100, r101};
    }

    public static StepperActionType valueOf(String r100) {
        return (StepperActionType) r27.a.a(StepperActionType.class, r100);
    }

    public static StepperActionType[] values() {
        return (StepperActionType[]) f47923a.clone();
    }

    public StepperActionType(String r100, int r101) {
        super(r100, r101);
    }
}
