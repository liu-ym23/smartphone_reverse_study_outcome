package com.stepos.core.data;

import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 .2\u00020\u0001:\u0001.BQ\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0011\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b)\u0010\u0018R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b*\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b+\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b,\u0010'R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b-\u0010\u0018¨\u0006/"}, d2 = {"Lcom/stepos/core/data/VideoContent;", "Lcom/stepos/core/data/base/Content;", "Landroid/hardware/HardwareBuffer;", "hwBuffer", "Landroid/os/ParcelFileDescriptor;", "shmFd", "", "shmSize", "", "width", "height", "format", "duration", "frameRate", "<init>", "(Landroid/hardware/HardwareBuffer;Landroid/os/ParcelFileDescriptor;JIIIJI)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "", "toString", "()Ljava/lang/String;", "Landroid/hardware/HardwareBuffer;", "getHwBuffer", "()Landroid/hardware/HardwareBuffer;", "Landroid/os/ParcelFileDescriptor;", "getShmFd", "()Landroid/os/ParcelFileDescriptor;", "J", "getShmSize", "()J", "I", "getWidth", "getHeight", "getFormat", "getDuration", "getFrameRate", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VideoContent extends Content {
    private final long duration;
    private final int format;
    private final int frameRate;
    private final int height;
    private final HardwareBuffer hwBuffer;
    private final ParcelFileDescriptor shmFd;
    private final long shmSize;
    private final int width;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<VideoContent> CREATOR = new Parcelable.Creator<VideoContent>() { // from class: com.stepos.core.data.VideoContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoContent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            VideoContent videoContent = new VideoContent(parcel);
            ((Content) videoContent).params = contentParamsCreateFromParcel;
            return videoContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoContent[] newArray(int size) {
            return new VideoContent[size];
        }
    };

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/core/data/VideoContent$Companion;", "", "<init>", "()V", "readFieldsFromParcel", "Lcom/stepos/core/data/VideoContent;", "parcel", "Landroid/os/Parcel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final VideoContent readFieldsFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new VideoContent(parcel);
        }

        private Companion() {
        }
    }

    public /* synthetic */ VideoContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j10, int i10, int i11, int i12, long j11, int i13, int i14, i iVar) {
        this((i14 & 1) != 0 ? null : hardwareBuffer, (i14 & 2) != 0 ? null : parcelFileDescriptor, (i14 & 4) != 0 ? 0L : j10, i10, i11, i12, j11, i13);
    }

    public static final VideoContent readFieldsFromParcel(Parcel parcel) {
        return INSTANCE.readFieldsFromParcel(parcel);
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
        return "VideoContent(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", frameRate=" + this.frameRate + ")";
    }

    public final boolean validate() {
        return !(this.hwBuffer == null && this.shmFd == null) && this.width > 0 && this.height > 0 && this.duration > 0 && this.frameRate > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeTypedObject(this.hwBuffer, flags);
        parcel.writeTypedObject(this.shmFd, flags);
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
        p.i(parcel, "parcel");
    }
}
