package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\" \u0010\b\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0017\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0019\u0010\u0011\u001a\u00060\u0004j\u0002`\u0012*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u001b\u0010\u0015\u001a\u0004\u0018\u00010\r*\u00060\u0016j\u0002`\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u001d\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c*\u00060\u0016j\u0002`\u00178F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0019\u0010\u001f\u001a\u00020 *\u00060\u0016j\u0002`\u00178F¢\u0006\u0006\u001a\u0004\b!\u0010\"\"\u0019\u0010#\u001a\u00020\u0001*\u00060\u0016j\u0002`\u00178F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"IM_GROUP_LIVE_GAME_PRIVATE_CHAT", "", "IM_GROUP_LIVE_GAME_PUBLIC_CHAT", "ROOM_LAYOUT_MEDIA", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getROOM_LAYOUT_MEDIA", "()J", "ROOM_TYPE_OFFICIAL_ACTIVITY", "getROOM_TYPE_OFFICIAL_ACTIVITY$annotations", "()V", "getROOM_TYPE_OFFICIAL_ACTIVITY", "anchorIdStr", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;", "getAnchorIdStr", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;)Ljava/lang/String;", "id", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "getId", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;)J", "mutliStreamDataFromPool", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getMutliStreamDataFromPool", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Ljava/lang/String;", "streamType", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveModeKt;", "getStreamType", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "streamUrlExtraSafely", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "getStreamUrlExtraSafely", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "vrType", "getVrType", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)I", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IRoomKtKt {
    public static final int IM_GROUP_LIVE_GAME_PRIVATE_CHAT = 16;
    public static final int IM_GROUP_LIVE_GAME_PUBLIC_CHAT = 17;
    private static final long ROOM_LAYOUT_MEDIA = 0;
    private static final long ROOM_TYPE_OFFICIAL_ACTIVITY = 0;

    static {
        long r100 = 1;
        ROOM_LAYOUT_MEDIA = r100;
        ROOM_TYPE_OFFICIAL_ACTIVITY = r100;
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getROOM_TYPE_OFFICIAL_ACTIVITY$annotations() {
    }

    public static final long getROOM_LAYOUT_MEDIA() {
        return ROOM_LAYOUT_MEDIA;
    }

    public static final long getROOM_TYPE_OFFICIAL_ACTIVITY() {
        return ROOM_TYPE_OFFICIAL_ACTIVITY;
    }

    public static final String getAnchorIdStr(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$anchorIdStr");
        if ((r100 instanceof IRoom) == true) goto L5;
        r100 = null;
    L5:
        IRoom r101 = (IRoom) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return IRoomKt_androidKt.getAnchorId(r101);
    }

    public static final long getId(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$id");
        Long r101 = StringsKt.toLongOrNull(r100.getIdStr());
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.longValue();
    }

    public static final String getMutliStreamDataFromPool(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mutliStreamDataFromPool");
        IBaseStreamUrl r101 = IRoomKt_androidKt.getStreamUrlKt(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return IBaseStreamUrlKt_androidKt.getMultiStreamDataEx(r101);
    }

    public static final LiveMode getStreamType(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$streamType");
        if (IRoomKt_androidKt.getRoomLayoutKt(r100) != ROOM_LAYOUT_MEDIA) goto L7;
        return LiveMode.MEDIA;
    L7:
        if (r100.getLayout() != ROOM_TYPE_OFFICIAL_ACTIVITY) goto L11;
        return LiveMode.MEDIA;
    L11:
        if (IRoomKt_androidKt.isScreenshotKt(r100) == false) goto L15;
        return LiveMode.SCREEN_RECORD;
    L15:
        if (IRoomKt_androidKt.isThirdPartyKt(r100) == false) goto L19;
        return LiveMode.THIRD_PARTY;
    L19:
        if (r100.isLiveTypeAudio() == false) goto L23;
        return LiveMode.AUDIO;
    L23:
        return LiveMode.VIDEO;
    }

    public static final IStreamUrlExtra getStreamUrlExtraSafely(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$streamUrlExtraSafely");
        IBaseStreamUrl r101 = IRoomKt_androidKt.getStreamUrlKt(r100);
        if (r101 == null) goto L7;
        IStreamUrlExtra r102 = r101.getExtra();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return (IStreamUrlExtra) f.c(IStreamUrlExtra.class);
    }

    public static final int getVrType(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$vrType");
        IBaseStreamUrl r101 = IRoomKt_androidKt.getStreamUrlKt(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getVrType();
    }
}
