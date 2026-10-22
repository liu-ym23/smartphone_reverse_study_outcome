package android.media.alwayson;

import android.media.steposmanager.AlwaysOnRecordSceneSegment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SharedMemory;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class AlwaysOnPreRollFetchResult implements Parcelable, Closeable, AutoCloseable {
    public static final Parcelable.Creator<AlwaysOnPreRollFetchResult> CREATOR = new Parcelable.Creator<AlwaysOnPreRollFetchResult>() { // from class: android.media.alwayson.AlwaysOnPreRollFetchResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnPreRollFetchResult createFromParcel(Parcel in) {
            return new AlwaysOnPreRollFetchResult(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnPreRollFetchResult[] newArray(int size) {
            return new AlwaysOnPreRollFetchResult[size];
        }
    };
    public final long endTimeNanos;
    public final AlwaysOnCaptureAudioFormat format;
    public final List<AlwaysOnRecordSceneSegment> sceneSegments;
    public final SharedMemory sharedMemory;
    public final int sizeInBytes;
    public final long startTimeNanos;

    public AlwaysOnPreRollFetchResult(SharedMemory sharedMemory, int sizeInBytes, long startTimeNanos, long endTimeNanos, AlwaysOnCaptureAudioFormat format, List<AlwaysOnRecordSceneSegment> sceneSegments) {
        this.sharedMemory = sharedMemory;
        this.sizeInBytes = sizeInBytes;
        this.startTimeNanos = startTimeNanos;
        this.endTimeNanos = endTimeNanos;
        this.format = format;
        this.sceneSegments = sceneSegments == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(sceneSegments));
    }

    private AlwaysOnPreRollFetchResult(Parcel in) {
        this.sharedMemory = (SharedMemory) in.readTypedObject(SharedMemory.CREATOR);
        this.sizeInBytes = in.readInt();
        this.startTimeNanos = in.readLong();
        this.endTimeNanos = in.readLong();
        this.format = (AlwaysOnCaptureAudioFormat) in.readTypedObject(AlwaysOnCaptureAudioFormat.CREATOR);
        ArrayList<AlwaysOnRecordSceneSegment> segments = new ArrayList<>();
        in.readTypedList(segments, AlwaysOnRecordSceneSegment.CREATOR);
        this.sceneSegments = Collections.unmodifiableList(segments);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.sharedMemory != null) {
            this.sharedMemory.close();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedObject(this.sharedMemory, flags);
        dest.writeInt(this.sizeInBytes);
        dest.writeLong(this.startTimeNanos);
        dest.writeLong(this.endTimeNanos);
        dest.writeTypedObject(this.format, flags);
        dest.writeTypedList(this.sceneSegments, flags);
    }
}
