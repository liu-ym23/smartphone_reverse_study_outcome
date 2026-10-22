package com.bytedance.android.shopping.api.host.store;

import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/api/host/store/RoomExitReason;", "", "LIVE_DISTRIBUTION_EXIT", EffectConstants.NORMAL, "LIVE_END", "NEW_ROOM_CREATE", "USER_PASSIVE_KICTOUT", "USER_PROACTIVE_LEAVE", "ROOM_ERROR", "REPEAT_ENTER", "SLIDE", FlowDoraWifiScene.OTHER, "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RoomExitReason extends Enum<RoomExitReason> {
    public static final RoomExitReason LIVE_DISTRIBUTION_EXIT = null;
    public static final RoomExitReason LIVE_END = null;
    public static final RoomExitReason NEW_ROOM_CREATE = null;
    public static final RoomExitReason NORMAL = null;
    public static final RoomExitReason OTHER = null;
    public static final RoomExitReason REPEAT_ENTER = null;
    public static final RoomExitReason ROOM_ERROR = null;
    public static final RoomExitReason SLIDE = null;
    public static final RoomExitReason USER_PASSIVE_KICTOUT = null;
    public static final RoomExitReason USER_PROACTIVE_LEAVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RoomExitReason[] f170192a = null;

    static {
        RoomExitReason r100 = new RoomExitReason("LIVE_DISTRIBUTION_EXIT", 0);
        LIVE_DISTRIBUTION_EXIT = r100;
        RoomExitReason r101 = new RoomExitReason(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        RoomExitReason r102 = new RoomExitReason("LIVE_END", 2);
        LIVE_END = r102;
        RoomExitReason r103 = new RoomExitReason("NEW_ROOM_CREATE", 3);
        NEW_ROOM_CREATE = r103;
        RoomExitReason r104 = new RoomExitReason("USER_PASSIVE_KICTOUT", 4);
        USER_PASSIVE_KICTOUT = r104;
        RoomExitReason r105 = new RoomExitReason("USER_PROACTIVE_LEAVE", 5);
        USER_PROACTIVE_LEAVE = r105;
        RoomExitReason r106 = new RoomExitReason("ROOM_ERROR", 6);
        ROOM_ERROR = r106;
        RoomExitReason r107 = new RoomExitReason("REPEAT_ENTER", 7);
        REPEAT_ENTER = r107;
        RoomExitReason r108 = new RoomExitReason("SLIDE", 8);
        SLIDE = r108;
        RoomExitReason r109 = new RoomExitReason(FlowDoraWifiScene.OTHER, 9);
        OTHER = r109;
        f170192a = new RoomExitReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static RoomExitReason valueOf(String r100) {
        return (RoomExitReason) a.a(RoomExitReason.class, r100);
    }

    public static RoomExitReason[] values() {
        return (RoomExitReason[]) f170192a.clone();
    }

    public RoomExitReason(String r100, int r101) {
        super(r100, r101);
    }
}
