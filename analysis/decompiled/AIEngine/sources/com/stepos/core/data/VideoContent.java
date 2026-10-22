package com.stepos.core.data;

import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VideoContent extends Content {
    private final long duration;
    private final int format;
    private final int frameRate;
    private final int height;
    private final HardwareBuffer hwBuffer;
    private final ParcelFileDescriptor shmFd;
    private final long shmSize;
    private final int width;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<VideoContent> CREATOR = new Parcelable.Creator<VideoContent>() { // from class: com.stepos.core.data.VideoContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoContent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            VideoContent videoContent = new VideoContent(parcel);
            ((Content) videoContent).params = contentParamsCreateFromParcel;
            return videoContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoContent[] newArray(int i10) {
            return new VideoContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final VideoContent readFieldsFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new VideoContent(parcel);
        }

        private Companion() {
        }
    }

    public /* synthetic */ VideoContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j10, int i10, int i11, int i12, long j11, int i13, int i14, e eVar) {
        this((i14 & 1) != 0 ? null : hardwareBuffer, (i14 & 2) != 0 ? null : parcelFileDescriptor, (i14 & 4) != 0 ? 0L : j10, i10, i11, i12, j11, i13);
    }

    public static final VideoContent readFieldsFromParcel(Parcel parcel) {
        return Companion.readFieldsFromParcel(parcel);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getFormat() {
        return this.format;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getHeight() {
        return this.height;
    }

    public final HardwareBuffer getHwBuffer() {
        return this.hwBuffer;
    }

    public final ParcelFileDescriptor getShmFd() {
        return this.shmFd;
    }

    public final long getShmSize() {
        return this.shmSize;
    }

    public final int getWidth() {
        return this.width;
    }

    public String toString() {
        int i10 = this.width;
        int i11 = this.height;
        long j10 = this.duration;
        int i12 = this.frameRate;
        StringBuilder sbD = h0.e.d(i10, "VideoContent(width=", i11, ", height=", ", duration=");
        sbD.append(j10);
        sbD.append(", frameRate=");
        sbD.append(i12);
        sbD.append(")");
        return sbD.toString();
    }

    public final boolean validate() {
        return !(this.hwBuffer == null && this.shmFd == null) && this.width > 0 && this.height > 0 && this.duration > 0 && this.frameRate > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        parcel.writeTypedObject(this.hwBuffer, i10);
        parcel.writeTypedObject(this.shmFd, i10);
        parcel.writeLong(this.shmSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.format);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.frameRate);
    }

    public VideoContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j10, int i10, int i11, int i12, long j11, int i13) {
        super(2);
        this.hwBuffer = hardwareBuffer;
        this.shmFd = parcelFileDescriptor;
        this.shmSize = j10;
        this.width = i10;
        this.height = i11;
        this.format = i12;
        this.duration = j11;
        this.frameRate = i13;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoContent(Parcel parcel) {
        this((HardwareBuffer) parcel.readTypedObject(HardwareBuffer.CREATOR), (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt());
        g.f(parcel, "parcel");
    }
}
