package com.bytedance.android.live.anchormodelink.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/model/DynamicCenterUpdateType;", "", "dynamic_none", "sendSEI", "registerSEI", "videoLinkmicAction", "liveLinkCall", "common_set_data", "linkmicBeautyPanel", "effect", "nativeCallChannel", "inviteMore", "check_media_permission", "send_private_invite", "switchRoom", "updatePublicScreenAvoidOffset", "fullScreenDoubleTap", "updateGlobalTracker", "closeVideoChorus", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicCenterUpdateType extends Enum<DynamicCenterUpdateType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicCenterUpdateType[] f58788a = null;
    public static final DynamicCenterUpdateType check_media_permission = null;
    public static final DynamicCenterUpdateType closeVideoChorus = null;
    public static final DynamicCenterUpdateType common_set_data = null;
    public static final DynamicCenterUpdateType dynamic_none = null;
    public static final DynamicCenterUpdateType effect = null;
    public static final DynamicCenterUpdateType fullScreenDoubleTap = null;
    public static final DynamicCenterUpdateType inviteMore = null;
    public static final DynamicCenterUpdateType linkmicBeautyPanel = null;
    public static final DynamicCenterUpdateType liveLinkCall = null;
    public static final DynamicCenterUpdateType nativeCallChannel = null;
    public static final DynamicCenterUpdateType registerSEI = null;
    public static final DynamicCenterUpdateType sendSEI = null;
    public static final DynamicCenterUpdateType send_private_invite = null;
    public static final DynamicCenterUpdateType switchRoom = null;
    public static final DynamicCenterUpdateType updateGlobalTracker = null;
    public static final DynamicCenterUpdateType updatePublicScreenAvoidOffset = null;
    public static final DynamicCenterUpdateType videoLinkmicAction = null;

    static {
        DynamicCenterUpdateType r100 = new DynamicCenterUpdateType("dynamic_none", 0);
        dynamic_none = r100;
        DynamicCenterUpdateType r101 = new DynamicCenterUpdateType("sendSEI", 1);
        sendSEI = r101;
        DynamicCenterUpdateType r102 = new DynamicCenterUpdateType("registerSEI", 2);
        registerSEI = r102;
        DynamicCenterUpdateType r103 = new DynamicCenterUpdateType("videoLinkmicAction", 3);
        videoLinkmicAction = r103;
        DynamicCenterUpdateType r104 = new DynamicCenterUpdateType("liveLinkCall", 4);
        liveLinkCall = r104;
        DynamicCenterUpdateType r105 = new DynamicCenterUpdateType("common_set_data", 5);
        common_set_data = r105;
        DynamicCenterUpdateType r106 = new DynamicCenterUpdateType("linkmicBeautyPanel", 6);
        linkmicBeautyPanel = r106;
        DynamicCenterUpdateType r107 = new DynamicCenterUpdateType("effect", 7);
        effect = r107;
        DynamicCenterUpdateType r108 = new DynamicCenterUpdateType("nativeCallChannel", 8);
        nativeCallChannel = r108;
        DynamicCenterUpdateType r109 = new DynamicCenterUpdateType("inviteMore", 9);
        inviteMore = r109;
        DynamicCenterUpdateType r110 = new DynamicCenterUpdateType("check_media_permission", 10);
        check_media_permission = r110;
        DynamicCenterUpdateType r111 = new DynamicCenterUpdateType("send_private_invite", 11);
        send_private_invite = r111;
        DynamicCenterUpdateType r112 = new DynamicCenterUpdateType("switchRoom", 12);
        switchRoom = r112;
        DynamicCenterUpdateType r113 = new DynamicCenterUpdateType("updatePublicScreenAvoidOffset", 13);
        updatePublicScreenAvoidOffset = r113;
        DynamicCenterUpdateType r114 = new DynamicCenterUpdateType("fullScreenDoubleTap", 14);
        fullScreenDoubleTap = r114;
        DynamicCenterUpdateType r115 = new DynamicCenterUpdateType("updateGlobalTracker", 15);
        updateGlobalTracker = r115;
        DynamicCenterUpdateType r116 = new DynamicCenterUpdateType("closeVideoChorus", 16);
        closeVideoChorus = r116;
        f58788a = new DynamicCenterUpdateType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116};
    }

    public static DynamicCenterUpdateType valueOf(String r100) {
        return (DynamicCenterUpdateType) a.a(DynamicCenterUpdateType.class, r100);
    }

    public static DynamicCenterUpdateType[] values() {
        return (DynamicCenterUpdateType[]) f58788a.clone();
    }

    public DynamicCenterUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
