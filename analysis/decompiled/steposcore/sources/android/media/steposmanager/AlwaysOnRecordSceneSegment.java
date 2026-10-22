package android.media.steposmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AlwaysOnRecordSceneSegment implements Parcelable {
    public static final Parcelable.Creator<AlwaysOnRecordSceneSegment> CREATOR = new Parcelable.Creator<AlwaysOnRecordSceneSegment>() { // from class: android.media.steposmanager.AlwaysOnRecordSceneSegment.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnRecordSceneSegment createFromParcel(Parcel in) {
            return new AlwaysOnRecordSceneSegment(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnRecordSceneSegment[] newArray(int size) {
            return new AlwaysOnRecordSceneSegment[size];
        }
    };
    public final int captureMask;
    public final long endTimeNanos;
    public final String extensionString;
    public final String sceneSubTag;
    public final String sceneTag;
    public final long startTimeNanos;

    public AlwaysOnRecordSceneSegment(String sceneTag, String sceneSubTag, String extensionString, long startTimeNanos, long endTimeNanos, int captureMask) {
        this.sceneTag = (String) Objects.requireNonNull(sceneTag, "sceneTag");
        this.sceneSubTag = sceneSubTag;
        this.extensionString = extensionString;
        this.startTimeNanos = startTimeNanos;
        this.endTimeNanos = endTimeNanos;
        this.captureMask = captureMask;
    }

    private AlwaysOnRecordSceneSegment(Parcel in) {
        this.sceneTag = (String) Objects.requireNonNull(in.readString());
        this.sceneSubTag = in.readString();
        this.extensionString = in.readString();
        this.startTimeNanos = in.readLong();
        this.endTimeNanos = in.readLong();
        this.captureMask = in.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sceneTag);
        dest.writeString(this.sceneSubTag);
        dest.writeString(this.extensionString);
        dest.writeLong(this.startTimeNanos);
        dest.writeLong(this.endTimeNanos);
        dest.writeInt(this.captureMask);
    }
}
