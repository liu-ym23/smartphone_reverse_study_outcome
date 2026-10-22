package com.bytedance.android.livesdkapi.room.handler.enterroom;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;", "", "PreviewRightBottomCard", "PreviewToolbar", "RoomFunction", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveEnterRoomScene {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene$PreviewRightBottomCard;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewRightBottomCard implements ILiveEnterRoomScene {
        public static final PreviewRightBottomCard INSTANCE = null;

        private PreviewRightBottomCard() {
        }

        static {
            INSTANCE = new PreviewRightBottomCard();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene$PreviewToolbar;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewToolbar implements ILiveEnterRoomScene {
        public static final PreviewToolbar INSTANCE = null;

        private PreviewToolbar() {
        }

        static {
            INSTANCE = new PreviewToolbar();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene$RoomFunction;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RoomFunction implements ILiveEnterRoomScene {
        public static final RoomFunction INSTANCE = null;

        private RoomFunction() {
        }

        static {
            INSTANCE = new RoomFunction();
        }
    }
}
