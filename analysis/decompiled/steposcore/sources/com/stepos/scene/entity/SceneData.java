package com.stepos.scene.entity;

/* loaded from: classes.dex */
public class SceneData {
    private int mSceneId;
    private int mStatus;
    private long mTimestamp;

    public SceneData(int mSceneId, int mStatus, long mTimestamp) {
        this.mSceneId = mSceneId;
        this.mStatus = mStatus;
        this.mTimestamp = mTimestamp;
    }

    public int getSceneId() {
        return this.mSceneId;
    }

    public void setSceneId(int mSceneId) {
        this.mSceneId = mSceneId;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTimestamp(long mTimestamp) {
        this.mTimestamp = mTimestamp;
    }

    public String toString() {
        return "SceneData{mSceneId=" + this.mSceneId + ", mStatus=" + this.mStatus + ", mTimestamp=" + this.mTimestamp + '}';
    }
}
