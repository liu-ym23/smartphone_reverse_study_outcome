package com.bytedance.android.livesdkapi.broadcastgame;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/broadcastgame/AnchorAction;", "", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "RESUME", "PAUSE", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorAction extends Enum<AnchorAction> {
    private static final /* synthetic */ AnchorAction[] $VALUES = null;
    public static final AnchorAction NONE = null;
    public static final AnchorAction PAUSE = null;
    public static final AnchorAction RESUME = null;

    static {
        AnchorAction r100 = new AnchorAction(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AnchorAction r101 = new AnchorAction("RESUME", 1);
        RESUME = r101;
        AnchorAction r102 = new AnchorAction("PAUSE", 2);
        PAUSE = r102;
        $VALUES = new AnchorAction[]{r100, r101, r102};
    }

    public static AnchorAction valueOf(String r100) {
        return (AnchorAction) a.a(AnchorAction.class, r100);
    }

    public static AnchorAction[] values() {
        return (AnchorAction[]) $VALUES.clone();
    }

    private AnchorAction(String r100, int r101) {
        super(r100, r101);
    }
}
