package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/NewReceiverPanelStatus;", "", "(Ljava/lang/String;I)V", "Idle", "Hide", "Show", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NewReceiverPanelStatus extends Enum<NewReceiverPanelStatus> {
    private static final /* synthetic */ NewReceiverPanelStatus[] $VALUES = null;
    public static final NewReceiverPanelStatus Hide = null;
    public static final NewReceiverPanelStatus Idle = null;
    public static final NewReceiverPanelStatus Show = null;

    static {
        NewReceiverPanelStatus r100 = new NewReceiverPanelStatus("Idle", 0);
        Idle = r100;
        NewReceiverPanelStatus r101 = new NewReceiverPanelStatus("Hide", 1);
        Hide = r101;
        NewReceiverPanelStatus r102 = new NewReceiverPanelStatus("Show", 2);
        Show = r102;
        $VALUES = new NewReceiverPanelStatus[]{r100, r101, r102};
    }

    public static NewReceiverPanelStatus valueOf(String r100) {
        return (NewReceiverPanelStatus) a.a(NewReceiverPanelStatus.class, r100);
    }

    public static NewReceiverPanelStatus[] values() {
        return (NewReceiverPanelStatus[]) $VALUES.clone();
    }

    private NewReceiverPanelStatus(String r100, int r101) {
        super(r100, r101);
    }
}
