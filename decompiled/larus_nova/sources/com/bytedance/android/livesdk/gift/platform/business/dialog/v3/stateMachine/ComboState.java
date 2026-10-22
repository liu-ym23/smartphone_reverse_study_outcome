package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "", "(Ljava/lang/String;I)V", "IDLE", "ON_SINGLE_CLICK", "ON_LONG_CLICK", "ON_COUNT_DOWN", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComboState extends Enum<ComboState> {
    private static final /* synthetic */ ComboState[] $VALUES = null;
    public static final ComboState IDLE = null;
    public static final ComboState ON_COUNT_DOWN = null;
    public static final ComboState ON_LONG_CLICK = null;
    public static final ComboState ON_SINGLE_CLICK = null;

    static {
        ComboState r100 = new ComboState("IDLE", 0);
        IDLE = r100;
        ComboState r101 = new ComboState("ON_SINGLE_CLICK", 1);
        ON_SINGLE_CLICK = r101;
        ComboState r102 = new ComboState("ON_LONG_CLICK", 2);
        ON_LONG_CLICK = r102;
        ComboState r103 = new ComboState("ON_COUNT_DOWN", 3);
        ON_COUNT_DOWN = r103;
        $VALUES = new ComboState[]{r100, r101, r102, r103};
    }

    public static ComboState valueOf(String r100) {
        return (ComboState) a.a(ComboState.class, r100);
    }

    public static ComboState[] values() {
        return (ComboState[]) $VALUES.clone();
    }

    private ComboState(String r100, int r101) {
        super(r100, r101);
    }
}
