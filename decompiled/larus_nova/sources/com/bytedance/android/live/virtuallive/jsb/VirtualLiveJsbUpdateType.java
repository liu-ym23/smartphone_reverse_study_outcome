package com.bytedance.android.live.virtuallive.jsb;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/virtuallive/jsb/VirtualLiveJsbUpdateType;", "", UserProfileEvent.POSITION_NONE, "OPEN", "AVATAR", "SCENE", "SCENE_AREA", "SCENE_EFFECT", "SETTING", "VIDEO_PREVIEW", "LENS_SET", "SET_DATA", "PITCH_ANGLE", "DEBUG", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VirtualLiveJsbUpdateType extends Enum<VirtualLiveJsbUpdateType> {
    public static final VirtualLiveJsbUpdateType AVATAR = null;
    public static final VirtualLiveJsbUpdateType DEBUG = null;
    public static final VirtualLiveJsbUpdateType LENS_SET = null;
    public static final VirtualLiveJsbUpdateType NONE = null;
    public static final VirtualLiveJsbUpdateType OPEN = null;
    public static final VirtualLiveJsbUpdateType PITCH_ANGLE = null;
    public static final VirtualLiveJsbUpdateType SCENE = null;
    public static final VirtualLiveJsbUpdateType SCENE_AREA = null;
    public static final VirtualLiveJsbUpdateType SCENE_EFFECT = null;
    public static final VirtualLiveJsbUpdateType SETTING = null;
    public static final VirtualLiveJsbUpdateType SET_DATA = null;
    public static final VirtualLiveJsbUpdateType VIDEO_PREVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VirtualLiveJsbUpdateType[] f102644a = null;

    static {
        VirtualLiveJsbUpdateType r100 = new VirtualLiveJsbUpdateType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VirtualLiveJsbUpdateType r101 = new VirtualLiveJsbUpdateType("OPEN", 1);
        OPEN = r101;
        VirtualLiveJsbUpdateType r102 = new VirtualLiveJsbUpdateType("AVATAR", 2);
        AVATAR = r102;
        VirtualLiveJsbUpdateType r103 = new VirtualLiveJsbUpdateType("SCENE", 3);
        SCENE = r103;
        VirtualLiveJsbUpdateType r104 = new VirtualLiveJsbUpdateType("SCENE_AREA", 4);
        SCENE_AREA = r104;
        VirtualLiveJsbUpdateType r105 = new VirtualLiveJsbUpdateType("SCENE_EFFECT", 5);
        SCENE_EFFECT = r105;
        VirtualLiveJsbUpdateType r106 = new VirtualLiveJsbUpdateType("SETTING", 6);
        SETTING = r106;
        VirtualLiveJsbUpdateType r107 = new VirtualLiveJsbUpdateType("VIDEO_PREVIEW", 7);
        VIDEO_PREVIEW = r107;
        VirtualLiveJsbUpdateType r108 = new VirtualLiveJsbUpdateType("LENS_SET", 8);
        LENS_SET = r108;
        VirtualLiveJsbUpdateType r109 = new VirtualLiveJsbUpdateType("SET_DATA", 9);
        SET_DATA = r109;
        VirtualLiveJsbUpdateType r110 = new VirtualLiveJsbUpdateType("PITCH_ANGLE", 10);
        PITCH_ANGLE = r110;
        VirtualLiveJsbUpdateType r111 = new VirtualLiveJsbUpdateType("DEBUG", 11);
        DEBUG = r111;
        f102644a = new VirtualLiveJsbUpdateType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public static VirtualLiveJsbUpdateType valueOf(String r100) {
        return (VirtualLiveJsbUpdateType) a.a(VirtualLiveJsbUpdateType.class, r100);
    }

    public static VirtualLiveJsbUpdateType[] values() {
        return (VirtualLiveJsbUpdateType[]) f102644a.clone();
    }

    public VirtualLiveJsbUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
