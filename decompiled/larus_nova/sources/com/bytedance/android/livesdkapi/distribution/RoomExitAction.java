package com.bytedance.android.livesdkapi.distribution;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/RoomExitAction;", "", "action", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "NO_ACTION", "REMOVE_CONTAINER", "BACK_TO_FIRST", "MOVE_TO_NEXT", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RoomExitAction extends Enum<RoomExitAction> {
    private static final /* synthetic */ RoomExitAction[] $VALUES = null;
    public static final RoomExitAction BACK_TO_FIRST = null;
    public static final RoomExitAction MOVE_TO_NEXT = null;
    public static final RoomExitAction NO_ACTION = null;
    public static final RoomExitAction REMOVE_CONTAINER = null;
    private final String action;

    static {
        RoomExitAction r100 = new RoomExitAction("NO_ACTION", 0, "no_action");
        NO_ACTION = r100;
        RoomExitAction r101 = new RoomExitAction("REMOVE_CONTAINER", 1, "remove_container");
        REMOVE_CONTAINER = r101;
        RoomExitAction r102 = new RoomExitAction("BACK_TO_FIRST", 2, "back_to_first");
        BACK_TO_FIRST = r102;
        RoomExitAction r103 = new RoomExitAction("MOVE_TO_NEXT", 3, "move_to_next");
        MOVE_TO_NEXT = r103;
        $VALUES = new RoomExitAction[]{r100, r101, r102, r103};
    }

    public static RoomExitAction valueOf(String r100) {
        return (RoomExitAction) a.a(RoomExitAction.class, r100);
    }

    public static RoomExitAction[] values() {
        return (RoomExitAction[]) $VALUES.clone();
    }

    public final String getAction() {
        return this.action;
    }

    private RoomExitAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.action = r102;
    }
}
