package android.os.collector.scene;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.collector.base.SceneEntity;

/* loaded from: classes.dex */
public final class StepOSPerfSceneData implements SceneEntity {
    public static final Parcelable.Creator<StepOSPerfSceneData> CREATOR = new Parcelable.Creator<StepOSPerfSceneData>() { // from class: android.os.collector.scene.StepOSPerfSceneData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSPerfSceneData createFromParcel(Parcel in) {
            return new StepOSPerfSceneData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSPerfSceneData[] newArray(int size) {
            return new StepOSPerfSceneData[size];
        }
    };
    public Bundle mData;
    public int mSceneId;

    public StepOSPerfSceneData() {
        this.mData = new Bundle();
    }

    public StepOSPerfSceneData(int sceneId) {
        this.mSceneId = sceneId;
        this.mData = new Bundle();
    }

    public StepOSPerfSceneData(int sceneId, Bundle data) {
        this.mSceneId = sceneId;
        this.mData = data != null ? data : new Bundle();
    }

    public String toString() {
        return "StepOSPerfSceneData{mSceneId=" + this.mSceneId + ", mData=" + this.mData + '}';
    }

    protected StepOSPerfSceneData(Parcel in) {
        this.mSceneId = in.readInt();
        this.mData = in.readBundle(getClass().getClassLoader());
        if (this.mData == null) {
            this.mData = new Bundle();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mSceneId);
        dest.writeBundle(this.mData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
