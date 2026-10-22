package com.bytedance.android.livesdkapi.room.handler.enterroom;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomCallback;", "", "getEnterParams", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomParams;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessSession;", "onBeforeEnterRoom", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveEnterRoomCallback {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onBeforeEnterRoom(ILiveEnterRoomCallback r100, ILivePreviewBusinessSession r101) {
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }
    }

    ILiveEnterRoomParams getEnterParams(ILivePreviewBusinessSession r100);

    void onBeforeEnterRoom(ILivePreviewBusinessSession r100);
}
