package com.bytedance.android.livesdkapi.distribution;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/ExternalRoomExitReason;", "", "(Ljava/lang/String;I)V", "LIVE_DISTRIBUTION_EXIT", EffectConstants.NORMAL, "SLIDE", "LIVE_END", "FINAL_CLEANUP", "NEW_ROOM_CREATE", "USER_PASSIVE_KICTOUT", "USER_PROACTIVE_LEAVE", "REPEAT_ENTER", "ROOM_ERROR", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExternalRoomExitReason extends Enum<ExternalRoomExitReason> {
    private static final /* synthetic */ ExternalRoomExitReason[] $VALUES = null;
    public static final ExternalRoomExitReason FINAL_CLEANUP = null;
    public static final ExternalRoomExitReason LIVE_DISTRIBUTION_EXIT = null;
    public static final ExternalRoomExitReason LIVE_END = null;
    public static final ExternalRoomExitReason NEW_ROOM_CREATE = null;
    public static final ExternalRoomExitReason NORMAL = null;
    public static final ExternalRoomExitReason REPEAT_ENTER = null;
    public static final ExternalRoomExitReason ROOM_ERROR = null;
    public static final ExternalRoomExitReason SLIDE = null;
    public static final ExternalRoomExitReason USER_PASSIVE_KICTOUT = null;
    public static final ExternalRoomExitReason USER_PROACTIVE_LEAVE = null;

    static {
        ExternalRoomExitReason r100 = new ExternalRoomExitReason("LIVE_DISTRIBUTION_EXIT", 0);
        LIVE_DISTRIBUTION_EXIT = r100;
        ExternalRoomExitReason r101 = new ExternalRoomExitReason(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        ExternalRoomExitReason r102 = new ExternalRoomExitReason("SLIDE", 2);
        SLIDE = r102;
        ExternalRoomExitReason r103 = new ExternalRoomExitReason("LIVE_END", 3);
        LIVE_END = r103;
        ExternalRoomExitReason r104 = new ExternalRoomExitReason("FINAL_CLEANUP", 4);
        FINAL_CLEANUP = r104;
        ExternalRoomExitReason r105 = new ExternalRoomExitReason("NEW_ROOM_CREATE", 5);
        NEW_ROOM_CREATE = r105;
        ExternalRoomExitReason r106 = new ExternalRoomExitReason("USER_PASSIVE_KICTOUT", 6);
        USER_PASSIVE_KICTOUT = r106;
        ExternalRoomExitReason r107 = new ExternalRoomExitReason("USER_PROACTIVE_LEAVE", 7);
        USER_PROACTIVE_LEAVE = r107;
        ExternalRoomExitReason r108 = new ExternalRoomExitReason("REPEAT_ENTER", 8);
        REPEAT_ENTER = r108;
        ExternalRoomExitReason r109 = new ExternalRoomExitReason("ROOM_ERROR", 9);
        ROOM_ERROR = r109;
        $VALUES = new ExternalRoomExitReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static ExternalRoomExitReason valueOf(String r100) {
        return (ExternalRoomExitReason) a.a(ExternalRoomExitReason.class, r100);
    }

    public static ExternalRoomExitReason[] values() {
        return (ExternalRoomExitReason[]) $VALUES.clone();
    }

    private ExternalRoomExitReason(String r100, int r101) {
        super(r100, r101);
    }
}
