package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ReceiverUIType;", "", "(Ljava/lang/String;I)V", "AllMic", "MultiReceiver", "SingleReceiver", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReceiverUIType extends Enum<ReceiverUIType> {
    private static final /* synthetic */ ReceiverUIType[] $VALUES = null;
    public static final ReceiverUIType AllMic = null;
    public static final ReceiverUIType MultiReceiver = null;
    public static final ReceiverUIType SingleReceiver = null;

    static {
        ReceiverUIType r100 = new ReceiverUIType("AllMic", 0);
        AllMic = r100;
        ReceiverUIType r101 = new ReceiverUIType("MultiReceiver", 1);
        MultiReceiver = r101;
        ReceiverUIType r102 = new ReceiverUIType("SingleReceiver", 2);
        SingleReceiver = r102;
        $VALUES = new ReceiverUIType[]{r100, r101, r102};
    }

    public static ReceiverUIType valueOf(String r100) {
        return (ReceiverUIType) a.a(ReceiverUIType.class, r100);
    }

    public static ReceiverUIType[] values() {
        return (ReceiverUIType[]) $VALUES.clone();
    }

    private ReceiverUIType(String r100, int r101) {
        super(r100, r101);
    }
}
