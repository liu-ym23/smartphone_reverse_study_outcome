package com.android.contacts.calllog.blocked;

import kotlin.Metadata;

/* JADX INFO: compiled from: TitleBarViewPosition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/calllog/blocked/TitleBarViewPosition;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum TitleBarViewPosition extends Enum<TitleBarViewPosition> {
    private static final /* synthetic */ TitleBarViewPosition[] $VALUES = null;
    public static final TitleBarViewPosition LEFT = null;
    public static final TitleBarViewPosition RIGHT = null;

    private static final /* synthetic */ TitleBarViewPosition[] $values() {
        return new TitleBarViewPosition[]{LEFT, RIGHT};
    }

    public static TitleBarViewPosition valueOf(String r1) {
        return (TitleBarViewPosition) Enum.valueOf(TitleBarViewPosition.class, r1);
    }

    public static TitleBarViewPosition[] values() {
        return (TitleBarViewPosition[]) $VALUES.clone();
    }

    private TitleBarViewPosition(String r1, int r2) {
        super(r1, r2);
    }

    static {
        LEFT = new TitleBarViewPosition("LEFT", 0);
        RIGHT = new TitleBarViewPosition("RIGHT", 1);
        $VALUES = $values();
    }
}
