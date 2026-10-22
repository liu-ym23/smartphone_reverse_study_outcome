package android.media.steposmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AlwaysOnRecordSceneInfo implements Parcelable {
    public static final Parcelable.Creator<AlwaysOnRecordSceneInfo> CREATOR = new Parcelable.Creator<AlwaysOnRecordSceneInfo>() { // from class: android.media.steposmanager.AlwaysOnRecordSceneInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnRecordSceneInfo createFromParcel(Parcel in) {
            return new AlwaysOnRecordSceneInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnRecordSceneInfo[] newArray(int size) {
            return new AlwaysOnRecordSceneInfo[size];
        }
    };
    public final int audioSessionId;
    public final int captureMask;
    public final String extensionString;
    public final String sceneSubTag;
    public final String sceneTag;
    public final long timestampNanos;

    public AlwaysOnRecordSceneInfo(String sceneTag, String sceneSubTag, long timestampNanos, int captureMask, int audioSessionId, String extensionString) {
        this.sceneTag = (String) Objects.requireNonNull(sceneTag, "sceneTag");
        this.sceneSubTag = sceneSubTag;
        this.timestampNanos = timestampNanos;
        this.captureMask = captureMask;
        this.audioSessionId = audioSessionId;
        this.extensionString = extensionString;
    }

    private AlwaysOnRecordSceneInfo(Parcel in) {
        this.sceneTag = (String) Objects.requireNonNull(in.readString());
        this.sceneSubTag = in.readString();
        this.timestampNanos = in.readLong();
        this.captureMask = in.readInt();
        this.audioSessionId = in.readInt();
        this.extensionString = in.readString();
    }

    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    public String getSceneTag() {
        return this.sceneTag;
    }

    public String getSceneSubTag() {
        return this.sceneSubTag;
    }

    public long getTimestampNanos() {
        return this.timestampNanos;
    }

    public int getCaptureMask() {
        return this.captureMask;
    }

    public String getExtensionString() {
        return this.extensionString;
    }

    public String toString() {
        return "AlwaysOnRecordSceneInfo{sceneTag=" + this.sceneTag + ", sceneSubTag=" + this.sceneSubTag + ", audioSessionId=" + this.audioSessionId + ", captureMask=" + this.captureMask + ", timestampNanos=" + this.timestampNanos + ", extensionString=" + this.extensionString + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sceneTag);
        dest.writeString(this.sceneSubTag);
        dest.writeLong(this.timestampNanos);
        dest.writeInt(this.captureMask);
        dest.writeInt(this.audioSessionId);
        dest.writeString(this.extensionString);
    }
}
