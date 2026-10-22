package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/model/BusinessSwitchState;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "MULTI_CHORUS", "NOT_SING", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BusinessSwitchState extends Enum<BusinessSwitchState> {
    public static final BusinessSwitchState MULTI_CHORUS = null;
    public static final BusinessSwitchState NOT_SING = null;
    public static final BusinessSwitchState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BusinessSwitchState[] f144127a = null;
    private final int value;

    static {
        BusinessSwitchState r100 = new BusinessSwitchState("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        BusinessSwitchState r101 = new BusinessSwitchState("MULTI_CHORUS", 1, 1);
        MULTI_CHORUS = r101;
        BusinessSwitchState r102 = new BusinessSwitchState("NOT_SING", 2, 2);
        NOT_SING = r102;
        f144127a = new BusinessSwitchState[]{r100, r101, r102};
    }

    public static BusinessSwitchState valueOf(String r100) {
        return (BusinessSwitchState) a.a(BusinessSwitchState.class, r100);
    }

    public static BusinessSwitchState[] values() {
        return (BusinessSwitchState[]) f144127a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public BusinessSwitchState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
