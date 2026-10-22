package com.bytedance.android.livesdkapi.depend.model.live.pushpreload;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pushpreload/LivePushPreloadNetResult;", "", "()V", "error", "", "hasNetwork", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "status", "getError", "getHasNetwork", "getRoom", "getStatus", "setError", "setHasNetwork", "setRoom", "setStatus", "isSuccess", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePushPreloadNetResult {
    private Throwable error;
    private boolean hasNetwork;
    private Room room;
    private boolean status;

    public LivePushPreloadNetResult() {
        this.hasNetwork = true;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final boolean getHasNetwork() {
        return this.hasNetwork;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final LivePushPreloadNetResult setError(Throwable r100) {
        this.error = r100;
        return this;
    }

    public final LivePushPreloadNetResult setHasNetwork(boolean r100) {
        this.hasNetwork = r100;
        return this;
    }

    public final LivePushPreloadNetResult setRoom(Room r100) {
        this.room = r100;
        return this;
    }

    public final LivePushPreloadNetResult setStatus(boolean r100) {
        this.status = r100;
        return this;
    }
}
