package com.android.ttcjpaysdk.base.ui.component.input;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/input/AmountType;", "", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "LEFT", "RIGHT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum AmountType extends Enum<AmountType> {
    private static final /* synthetic */ AmountType[] $VALUES = null;
    public static final AmountType LEFT = null;
    public static final AmountType NONE = null;
    public static final AmountType RIGHT = null;

    private static final /* synthetic */ AmountType[] $values() {
        return new AmountType[]{NONE, LEFT, RIGHT};
    }

    public static AmountType valueOf(String r100) {
        return (AmountType) r27.a.a(AmountType.class, r100);
    }

    public static AmountType[] values() {
        return (AmountType[]) $VALUES.clone();
    }

    static {
        NONE = new AmountType(UserProfileEvent.POSITION_NONE, 0);
        LEFT = new AmountType("LEFT", 1);
        RIGHT = new AmountType("RIGHT", 2);
        $VALUES = $values();
    }

    private AmountType(String r100, int r101) {
        super(r100, r101);
    }
}
