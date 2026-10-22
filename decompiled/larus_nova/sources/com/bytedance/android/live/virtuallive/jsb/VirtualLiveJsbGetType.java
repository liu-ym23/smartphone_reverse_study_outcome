package com.bytedance.android.live.virtuallive.jsb;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/virtuallive/jsb/VirtualLiveJsbGetType;", "", UserProfileEvent.POSITION_NONE, "OPEN", "AVATAR", "SCENE", "UE_INIT_INFO", "ANCHOR_LIVE_STATUS", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VirtualLiveJsbGetType extends Enum<VirtualLiveJsbGetType> {
    public static final VirtualLiveJsbGetType ANCHOR_LIVE_STATUS = null;
    public static final VirtualLiveJsbGetType AVATAR = null;
    public static final VirtualLiveJsbGetType NONE = null;
    public static final VirtualLiveJsbGetType OPEN = null;
    public static final VirtualLiveJsbGetType SCENE = null;
    public static final VirtualLiveJsbGetType UE_INIT_INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VirtualLiveJsbGetType[] f102643a = null;

    static {
        VirtualLiveJsbGetType r100 = new VirtualLiveJsbGetType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VirtualLiveJsbGetType r101 = new VirtualLiveJsbGetType("OPEN", 1);
        OPEN = r101;
        VirtualLiveJsbGetType r102 = new VirtualLiveJsbGetType("AVATAR", 2);
        AVATAR = r102;
        VirtualLiveJsbGetType r103 = new VirtualLiveJsbGetType("SCENE", 3);
        SCENE = r103;
        VirtualLiveJsbGetType r104 = new VirtualLiveJsbGetType("UE_INIT_INFO", 4);
        UE_INIT_INFO = r104;
        VirtualLiveJsbGetType r105 = new VirtualLiveJsbGetType("ANCHOR_LIVE_STATUS", 5);
        ANCHOR_LIVE_STATUS = r105;
        f102643a = new VirtualLiveJsbGetType[]{r100, r101, r102, r103, r104, r105};
    }

    public static VirtualLiveJsbGetType valueOf(String r100) {
        return (VirtualLiveJsbGetType) a.a(VirtualLiveJsbGetType.class, r100);
    }

    public static VirtualLiveJsbGetType[] values() {
        return (VirtualLiveJsbGetType[]) f102643a.clone();
    }

    public VirtualLiveJsbGetType(String r100, int r101) {
        super(r100, r101);
    }
}
