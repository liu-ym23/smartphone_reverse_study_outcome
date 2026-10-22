package com.bytedance.android.livesdkapi.player;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/AnchorPushStreamStatusForSei;", "", "streamStatus", "Lcom/bytedance/android/livesdkapi/player/AnchorLiveRoomStatus;", "(Lcom/bytedance/android/livesdkapi/player/AnchorLiveRoomStatus;)V", "getStreamStatus", "()Lcom/bytedance/android/livesdkapi/player/AnchorLiveRoomStatus;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPushStreamStatusForSei {

    @SerializedName("anchor_stream_status")
    private final AnchorLiveRoomStatus streamStatus;

    public final AnchorLiveRoomStatus getStreamStatus() {
        return this.streamStatus;
    }

    public AnchorPushStreamStatusForSei(AnchorLiveRoomStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "streamStatus");
        this.streamStatus = r100;
    }
}
