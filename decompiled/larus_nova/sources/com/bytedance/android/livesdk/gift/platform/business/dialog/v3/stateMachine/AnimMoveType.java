package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/AnimMoveType;", "", "(Ljava/lang/String;I)V", "Left", "Right", "Keep", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimMoveType extends Enum<AnimMoveType> {
    private static final /* synthetic */ AnimMoveType[] $VALUES = null;
    public static final AnimMoveType Keep = null;
    public static final AnimMoveType Left = null;
    public static final AnimMoveType Right = null;

    static {
        AnimMoveType r100 = new AnimMoveType("Left", 0);
        Left = r100;
        AnimMoveType r101 = new AnimMoveType("Right", 1);
        Right = r101;
        AnimMoveType r102 = new AnimMoveType("Keep", 2);
        Keep = r102;
        $VALUES = new AnimMoveType[]{r100, r101, r102};
    }

    public static AnimMoveType valueOf(String r100) {
        return (AnimMoveType) a.a(AnimMoveType.class, r100);
    }

    public static AnimMoveType[] values() {
        return (AnimMoveType[]) $VALUES.clone();
    }

    private AnimMoveType(String r100, int r101) {
        super(r100, r101);
    }
}
