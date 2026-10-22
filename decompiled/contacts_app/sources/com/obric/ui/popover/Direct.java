package com.obric.ui.popover;

import kotlin.Metadata;

/* JADX INFO: compiled from: Direct.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/ui/popover/Direct;", "", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "TOP_MID", "BOTTOM_LEFT", "BOTTOM_RIGHT", "BOTTOM_MID", "LEFT", "RIGHT", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum Direct extends Enum<Direct> {
    private static final /* synthetic */ Direct[] $VALUES = null;
    public static final Direct BOTTOM_LEFT = null;
    public static final Direct BOTTOM_MID = null;
    public static final Direct BOTTOM_RIGHT = null;
    public static final Direct LEFT = null;
    public static final Direct RIGHT = null;
    public static final Direct TOP_LEFT = null;
    public static final Direct TOP_MID = null;
    public static final Direct TOP_RIGHT = null;

    private static final /* synthetic */ Direct[] $values() {
        return new Direct[]{TOP_LEFT, TOP_RIGHT, TOP_MID, BOTTOM_LEFT, BOTTOM_RIGHT, BOTTOM_MID, LEFT, RIGHT};
    }

    public static Direct valueOf(String r1) {
        return (Direct) Enum.valueOf(Direct.class, r1);
    }

    public static Direct[] values() {
        return (Direct[]) $VALUES.clone();
    }

    private Direct(String r1, int r2) {
        super(r1, r2);
    }

    static {
        TOP_LEFT = new Direct("TOP_LEFT", 0);
        TOP_RIGHT = new Direct("TOP_RIGHT", 1);
        TOP_MID = new Direct("TOP_MID", 2);
        BOTTOM_LEFT = new Direct("BOTTOM_LEFT", 3);
        BOTTOM_RIGHT = new Direct("BOTTOM_RIGHT", 4);
        BOTTOM_MID = new Direct("BOTTOM_MID", 5);
        LEFT = new Direct("LEFT", 6);
        RIGHT = new Direct("RIGHT", 7);
        $VALUES = $values();
    }
}
