package com.android.server.usage;

import android.util.LongArrayQueue;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class BroadcastEvent {
    private long mIdForResponseEvent;
    private int mSourceUid;
    private String mTargetPackage;
    private int mTargetUserId;
    private final LongArrayQueue mTimestampsMs;

    BroadcastEvent(int sourceUid, String targetPackage, int targetUserId, long idForResponseEvent) {
        this.mSourceUid = sourceUid;
        this.mTargetPackage = targetPackage;
        this.mTargetUserId = targetUserId;
        this.mIdForResponseEvent = idForResponseEvent;
        this.mTimestampsMs = new LongArrayQueue();
    }

    public int getSourceUid() {
        return this.mSourceUid;
    }

    public String getTargetPackage() {
        return this.mTargetPackage;
    }

    public int getTargetUserId() {
        return this.mTargetUserId;
    }

    public long getIdForResponseEvent() {
        return this.mIdForResponseEvent;
    }

    public LongArrayQueue getTimestampsMs() {
        return this.mTimestampsMs;
    }

    public void addTimestampMs(long timestampMs) {
        this.mTimestampsMs.addLast(timestampMs);
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if (obj != null) goto L8;
    L21:
        return false;
    L8:
        if ((obj instanceof BroadcastEvent) == false) goto L21;
        BroadcastEvent other = (BroadcastEvent) obj;
        if (this.mSourceUid != other.mSourceUid) goto L20;
        if (this.mIdForResponseEvent != other.mIdForResponseEvent) goto L20;
        if (this.mTargetUserId != other.mTargetUserId) goto L20;
        if (this.mTargetPackage.equals(other.mTargetPackage) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mSourceUid), this.mTargetPackage, Integer.valueOf(this.mTargetUserId), Long.valueOf(this.mIdForResponseEvent)});
    }

    public String toString() {
        return "BroadcastEvent {srcUid=" + this.mSourceUid + ",tgtPkg=" + this.mTargetPackage + ",tgtUser=" + this.mTargetUserId + ",id=" + this.mIdForResponseEvent + "}";
    }
}
