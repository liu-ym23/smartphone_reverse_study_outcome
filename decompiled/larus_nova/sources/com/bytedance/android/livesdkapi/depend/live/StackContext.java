package com.bytedance.android.livesdkapi.depend.live;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/StackContext;", "", "()V", "activityHashCode", "", "getActivityHashCode", "()I", "setActivityHashCode", "(I)V", "isPortrait", "", "()Z", "setPortrait", "(Z)V", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StackContext {
    private int activityHashCode;
    private boolean isPortrait;
    private Room room;

    public StackContext() {
        this.isPortrait = true;
    }

    public final int getActivityHashCode() {
        return this.activityHashCode;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final boolean isPortrait() {
        return this.isPortrait;
    }

    public final void setActivityHashCode(int r100) {
        this.activityHashCode = r100;
    }

    public final void setPortrait(boolean r100) {
        this.isPortrait = r100;
    }

    public final void setRoom(Room r100) {
        this.room = r100;
    }
}
