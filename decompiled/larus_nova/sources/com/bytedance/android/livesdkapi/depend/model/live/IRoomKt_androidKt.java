package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.z5;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a\u000e\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001\"\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0019\u0010\t\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0019\u0010\n\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0019\u0010\f\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0019\u0010\r\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0019\u0010\u0012\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"\u0019\u0010\u0013\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000b\"!\u0010\u0018\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"!\u0010\u001d\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"=\u0010$\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u001fj\u0002` 0\u001ej\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u001fj\u0002` `!*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u001d\u0010'\u001a\u00060\u001fj\u0002` *\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u001d\u0010)\u001a\u00060\u001fj\u0002` *\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b(\u0010&\"\u0019\u0010+\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b*\u0010\u000b\"\u0019\u0010/\u001a\u00020,*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0019\u00100\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b0\u0010\u000b\"\u0019\u00101\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b1\u0010\u000b\"\u0019\u00102\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b2\u0010\u000b\"\"\u00109\u001a\u00020\u0004*\u000603j\u0002`48FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u00108\u001a\u0004\b5\u00106\"\u001e\u0010?\u001a\u000203*\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b;\u0010<\"\u001e\u0010@\u001a\u00020\u0002*\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010>\u001a\u0004\b@\u0010A\"\u001e\u0010C\u001a\u00020\u0002*\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010>\u001a\u0004\bC\u0010A\"\u001e\u0010E\u001a\u00020\u0002*\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010>\u001a\u0004\bE\u0010A\"\u001e\u0010G\u001a\u00020\u0002*\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010>\u001a\u0004\bG\u0010A\"\u001e\u0010I\u001a\u00020\u0002*\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010>\u001a\u0004\bI\u0010A\",\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e*\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010>\u001a\u0004\bK\u0010L\" \u0010R\u001a\u0004\u0018\u00010\u001f*\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010>\u001a\u0004\bO\u0010P\"\u0015\u0010T\u001a\u00020\u0002*\u00020:8F¢\u0006\u0006\u001a\u0004\bS\u0010A*\n\u0010U\"\u0002032\u000203*\n\u0010V\"\u00020\u00002\u00020\u0000¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "", "isSupportCameraExt", "", "getAnchorId", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Ljava/lang/String;", "anchorId", "getOwnerUserIdString", "ownerUserIdString", "isMergeVSRoomKt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Z", "isMediaRoomKt", "isGameRoomKt", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorData;", "getAnchorDataKt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorData;", "anchorDataKt", "isScreenshotKt", "isThirdPartyKt", "Lcom/bytedance/android/livesdk/link/model/z5;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkerDetailKt;", "getLinkerDetailKt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Lcom/bytedance/android/livesdk/link/model/z5;", "linkerDetailKt", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlKt;", "getStreamUrlKt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "streamUrlKt", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkMapKt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Ljava/util/Map;", "linkMapKt", "getLayout", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)J", "layout", "getRoomLayoutKt", "roomLayoutKt", "getWithLinkmic", "withLinkmic", "", "getUserCountExt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)I", "userCountExt", "isVideoCameraVersionExt", "isVirtualLiveKt", "isPrivatePlayExt", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveModeKt;", "getSceneName", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;)Ljava/lang/String;", "getSceneName$annotations", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;)V", "sceneName", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;", "getStreamType", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;)Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;", "getStreamType$annotations", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;)V", "streamType", "isStarRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;)Z", "isStarRoom$annotations", "isKoiRoom", "isKoiRoom$annotations", "isMediaRoom", "isMediaRoom$annotations", "isVSRoom", "isVSRoom$annotations", "isPaidSubscribeRoom", "isPaidSubscribeRoom$annotations", "getAnchorABMap", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;)Ljava/util/Map;", "getAnchorABMap$annotations", "anchorABMap", "getPlatform", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;)Ljava/lang/Long;", "getPlatform$annotations", "platform", "getRoomAuthStatusIsEnableGift", "roomAuthStatusIsEnableGift", "ILiveModeKt", "IRoomKt", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IRoomKt_androidKt {
    public static /* synthetic */ void getAnchorABMap$annotations(IRoomBase r100) {
    }

    public static /* synthetic */ void getPlatform$annotations(IRoomBase r100) {
    }

    public static /* synthetic */ void getSceneName$annotations(ILiveMode r100) {
    }

    public static /* synthetic */ void getStreamType$annotations(IRoomBase r100) {
    }

    public static /* synthetic */ void isKoiRoom$annotations(IRoomBase r100) {
    }

    public static /* synthetic */ void isMediaRoom$annotations(IRoomBase r100) {
    }

    public static /* synthetic */ void isPaidSubscribeRoom$annotations(IRoomBase r100) {
    }

    public static /* synthetic */ void isStarRoom$annotations(IRoomBase r100) {
    }

    public static /* synthetic */ void isVSRoom$annotations(IRoomBase r100) {
    }

    public static final Map<String, String> getAnchorABMap(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$anchorABMap");
        return ((IRoom) r100).getAnchorABMap();
    }

    public static final IAnchorData getAnchorDataKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$anchorDataKt");
        return r100.getAnchorData();
    }

    public static final String getAnchorId(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$anchorId");
        if (r100.getOwner() == null) goto L10;
        IBaseUser r101 = r100.getOwner();
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.getIdString();
    L10:
        return getOwnerUserIdString(r100);
    }

    public static final long getLayout(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layout");
        return r100.getLayout();
    }

    public static final Map<String, Long> getLinkMapKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linkMapKt");
        return r100.getLinkMap();
    }

    public static final z5 getLinkerDetailKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linkerDetailKt");
        return r100.getLinkerDetail();
    }

    public static final String getOwnerUserIdString(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$ownerUserIdString");
        return r100.getOwnerUserIdString();
    }

    public static final Long getPlatform(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$platform");
        if ((r100 instanceof IRoom) == true) goto L5;
        r100 = null;
    L5:
        IRoom r101 = (IRoom) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return Long.valueOf(r101.getPlatform());
    }

    public static final boolean getRoomAuthStatusIsEnableGift(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$roomAuthStatusIsEnableGift");
        if ((r100 instanceof IRoom) == true) goto L5;
        r100 = null;
    L5:
        IRoom r101 = (IRoom) r100;
        if (r101 == null) goto L10;
        IRoomAuthStatus r102 = r101.getRoomAuthStatus();
        if (r102 == null) goto L10;
        return r102.getEnableGift();
    L10:
        return false;
    }

    public static final long getRoomLayoutKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$roomLayoutKt");
        return r100.getRoomLayout();
    }

    public static final String getSceneName(ILiveMode r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$sceneName");
        return String.valueOf(r100.getSceneName());
    }

    public static final ILiveMode getStreamType(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$streamType");
        return IRoomKtKt.getStreamType((IRoom) r100);
    }

    public static final IBaseStreamUrl getStreamUrlKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$streamUrlKt");
        return r100.getStreamUrl();
    }

    public static final int getUserCountExt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$userCountExt");
        return (int) r100.getUserCount();
    }

    public static final boolean getWithLinkmic(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withLinkmic");
        return r100.getWithLinkMic();
    }

    public static final boolean isGameRoomKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isGameRoomKt");
        if (r100.isGameRoom() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean isKoiRoom(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isKoiRoom");
        return ((IRoom) r100).isKoiRoom();
    }

    public static final boolean isMediaRoom(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMediaRoom");
        return ((IRoom) r100).isMediaRoom();
    }

    public static final boolean isMediaRoomKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMediaRoomKt");
        return r100.isMediaRoom();
    }

    public static final boolean isMergeVSRoomKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMergeVSRoomKt");
        return r100.isMergeVSRoom();
    }

    public static final boolean isPaidSubscribeRoom(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPaidSubscribeRoom");
        return ((IRoom) r100).isPaidSubscribeRoom();
    }

    public static final boolean isPrivatePlayExt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPrivatePlayExt");
        return r100.isPrivatePlay();
    }

    public static final boolean isScreenshotKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isScreenshotKt");
        return r100.isScreenshot();
    }

    public static final boolean isStarRoom(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isStarRoom");
        return ((IRoom) r100).isStar();
    }

    public static final boolean isSupportCameraExt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportCameraExt");
        return r100.isSupportCamera();
    }

    public static final boolean isThirdPartyKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isThirdPartyKt");
        return r100.isThirdParty();
    }

    public static final boolean isVSRoom(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVSRoom");
        return ((IRoom) r100).isVsRoom();
    }

    public static final boolean isVideoCameraVersionExt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVideoCameraVersionExt");
        return r100.isVideoCameraVersion();
    }

    public static final boolean isVirtualLiveKt(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVirtualLiveKt");
        return r100.isVirtualLive();
    }
}
