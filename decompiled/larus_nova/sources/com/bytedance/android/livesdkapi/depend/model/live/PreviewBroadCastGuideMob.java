package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewBroadCastGuideMob;", "", "()V", "lastRoomId", "", "getLastRoomId", "()J", "setLastRoomId", "(J)V", "mostRoomid", "getMostRoomid", "setMostRoomid", "mostTime", "getMostTime", "setMostTime", "recentStartBroadcasrTime", "getRecentStartBroadcasrTime", "setRecentStartBroadcasrTime", "clear", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewBroadCastGuideMob {
    public static final PreviewBroadCastGuideMob INSTANCE = null;
    private static long lastRoomId;
    private static long mostRoomid;
    private static long mostTime;
    private static long recentStartBroadcasrTime;

    private PreviewBroadCastGuideMob() {
    }

    static {
        INSTANCE = new PreviewBroadCastGuideMob();
    }

    public final void clear() {
        mostRoomid = 0;
        lastRoomId = 0;
        mostTime = 0;
    }

    public final long getLastRoomId() {
        return lastRoomId;
    }

    public final long getMostRoomid() {
        return mostRoomid;
    }

    public final long getMostTime() {
        return mostTime;
    }

    public final long getRecentStartBroadcasrTime() {
        return recentStartBroadcasrTime;
    }

    public final void setLastRoomId(long r100) {
        lastRoomId = r100;
    }

    public final void setMostRoomid(long r100) {
        mostRoomid = r100;
    }

    public final void setMostTime(long r100) {
        mostTime = r100;
    }

    public final void setRecentStartBroadcasrTime(long r100) {
        recentStartBroadcasrTime = r100;
    }
}
