package com.stepos.scene.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.collector.base.SceneEntity;
import android.os.collector.base.StepOSBaseEntity;

/* loaded from: classes.dex */
public class SceneState implements Parcelable {
    public static final Parcelable.Creator<SceneState> CREATOR = new Parcelable.Creator<SceneState>() { // from class: com.stepos.scene.entity.SceneState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SceneState createFromParcel(Parcel in) {
            return new SceneState(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SceneState[] newArray(int size) {
            return new SceneState[size];
        }
    };
    private SceneEntity mStepOSBaseEntity;
    private final int sceneId;
    private SceneStatus status;
    private long timestamp;

    public SceneState(int sceneId, SceneStatus status, long timestamp) {
        this.sceneId = sceneId;
        this.status = status;
        this.timestamp = timestamp;
    }

    public SceneState(int sceneId, SceneStatus status, long timestamp, SceneEntity steposBaseEntity) {
        this.sceneId = sceneId;
        this.status = status;
        this.timestamp = timestamp;
        this.mStepOSBaseEntity = steposBaseEntity;
    }

    protected SceneState(Parcel in) {
        this.sceneId = in.readInt();
        int statusOrdinal = in.readInt();
        this.status = statusOrdinal >= 0 ? SceneStatus.values()[statusOrdinal] : null;
        this.timestamp = in.readLong();
        this.mStepOSBaseEntity = (SceneEntity) in.readParcelable(SceneState.class.getClassLoader());
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public SceneStatus getStatus() {
        return this.status;
    }

    public void setStatus(SceneStatus status) {
        this.status = status;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public StepOSBaseEntity getStepOSBaseEntity() {
        if (this.mStepOSBaseEntity instanceof StepOSBaseEntity) {
            return (StepOSBaseEntity) this.mStepOSBaseEntity;
        }
        return null;
    }

    public void setStepOSBaseEntity(SceneEntity steposBaseEntity) {
        this.mStepOSBaseEntity = steposBaseEntity;
    }

    public SceneEntity getSceneEntity() {
        return this.mStepOSBaseEntity;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.sceneId);
        dest.writeInt(this.status != null ? this.status.ordinal() : -1);
        dest.writeLong(this.timestamp);
        dest.writeParcelable(this.mStepOSBaseEntity, flags);
    }
}
