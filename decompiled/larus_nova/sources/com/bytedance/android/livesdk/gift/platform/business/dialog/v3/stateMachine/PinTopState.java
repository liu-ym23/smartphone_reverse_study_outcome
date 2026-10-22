package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PinTopState;", "", "pinStrategy", "", "disableSwitchToPinTop", "", "isSwitching", "(IZZ)V", "getDisableSwitchToPinTop", "()Z", "getPinStrategy", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinTopState {
    public static final Companion Companion = null;
    private static final PinTopState DEFAULT_PIN_TOP_STATE = null;
    private final boolean disableSwitchToPinTop;
    private final boolean isSwitching;
    private final int pinStrategy;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PinTopState$Companion;", "", "()V", "DEFAULT_PIN_TOP_STATE", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PinTopState;", "getDEFAULT_PIN_TOP_STATE", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PinTopState;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final PinTopState getDEFAULT_PIN_TOP_STATE() {
            return PinTopState.access$getDEFAULT_PIN_TOP_STATE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public static /* synthetic */ PinTopState copy$default(PinTopState r100, int r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.pinStrategy;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.disableSwitchToPinTop;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isSwitching;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.pinStrategy;
    }

    public final boolean component2() {
        return this.disableSwitchToPinTop;
    }

    public final boolean component3() {
        return this.isSwitching;
    }

    public final PinTopState copy(int r100, boolean r101, boolean r102) {
        return new PinTopState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PinTopState) == false) goto L12;
        PinTopState r101 = (PinTopState) r100;
        if (this.pinStrategy == r101.pinStrategy) goto L8;
        return false;
    L8:
        if (this.disableSwitchToPinTop == r101.disableSwitchToPinTop) goto L10;
        return false;
    L10:
        if (this.isSwitching == r101.isSwitching) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r100 = this.pinStrategy * 31;
        boolean r101 = this.disableSwitchToPinTop;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.isSwitching;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return r104 + r102;
    }

    public String toString() {
        return "PinTopState(pinStrategy=" + this.pinStrategy + ", disableSwitchToPinTop=" + this.disableSwitchToPinTop + ", isSwitching=" + this.isSwitching + ")";
    }

    static {
        Companion = new Companion(null);
        DEFAULT_PIN_TOP_STATE = new PinTopState(0, false, false);
    }

    public static final /* synthetic */ PinTopState access$getDEFAULT_PIN_TOP_STATE$cp() {
        return DEFAULT_PIN_TOP_STATE;
    }

    public final boolean getDisableSwitchToPinTop() {
        return this.disableSwitchToPinTop;
    }

    public final int getPinStrategy() {
        return this.pinStrategy;
    }

    public final boolean isSwitching() {
        return this.isSwitching;
    }

    public PinTopState(int r100, boolean r101, boolean r102) {
        this.pinStrategy = r100;
        this.disableSwitchToPinTop = r101;
        this.isSwitching = r102;
    }
}
