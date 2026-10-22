package com.stepos.core.data;

import L.g;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import androidx.appfunctions.metadata.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.data.base.Content;
import d5.x;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 .2\u00020\u0001:\u0001/BQ\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0011\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b)\u0010\u0018R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b*\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b+\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b,\u0010'R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b-\u0010\u0018¨\u00060"}, d2 = {"Lcom/stepos/core/data/VideoContent;", "Lcom/stepos/core/data/base/Content;", "Landroid/hardware/HardwareBuffer;", "hwBuffer", "Landroid/os/ParcelFileDescriptor;", "shmFd", "", "shmSize", "", "width", "height", "format", TypedValues.TransitionType.S_DURATION, "frameRate", AppAgent.CONSTRUCT, "(Landroid/hardware/HardwareBuffer;Landroid/os/ParcelFileDescriptor;JIIIJI)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "", "toString", "()Ljava/lang/String;", "Landroid/hardware/HardwareBuffer;", "getHwBuffer", "()Landroid/hardware/HardwareBuffer;", "Landroid/os/ParcelFileDescriptor;", "getShmFd", "()Landroid/os/ParcelFileDescriptor;", "J", "getShmSize", "()J", "I", "getWidth", "getHeight", "getFormat", "getDuration", "getFrameRate", "Companion", "d5/x", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
    public static final x Companion = new x();
    public static final Parcelable.Creator<VideoContent> CREATOR = new g(23);

    public /* synthetic */ VideoContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j5, int i, int i6, int i10, long j6, int i11, int i12, e eVar) {
        this((i12 & 1) != 0 ? null : hardwareBuffer, (i12 & 2) != 0 ? null : parcelFileDescriptor, (i12 & 4) != 0 ? 0L : j5, i, i6, i10, j6, i11);
    }

    @RequiresApi(26)
    public static final VideoContent readFieldsFromParcel(Parcel parcel) {
        Companion.getClass();
        k.f(parcel, "parcel");
        return new VideoContent(parcel);
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
        int i = this.width;
        int i6 = this.height;
        long j5 = this.duration;
        int i10 = this.frameRate;
        StringBuilder sbS = a.s(i, "VideoContent(width=", i6, ", height=", ", duration=");
        sbS.append(j5);
        sbS.append(", frameRate=");
        sbS.append(i10);
        sbS.append(")");
        return sbS.toString();
    }

    public final boolean validate() {
        return !(this.hwBuffer == null && this.shmFd == null) && this.width > 0 && this.height > 0 && this.duration > 0 && this.frameRate > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    @RequiresApi(26)
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
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

    public VideoContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j5, int i, int i6, int i10, long j6, int i11) {
        super(2);
        this.hwBuffer = hardwareBuffer;
        this.shmFd = parcelFileDescriptor;
        this.shmSize = j5;
        this.width = i;
        this.height = i6;
        this.format = i10;
        this.duration = j6;
        this.frameRate = i11;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public VideoContent(Parcel parcel) {
        this((HardwareBuffer) parcel.readTypedObject(HardwareBuffer.CREATOR), (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt());
        k.f(parcel, "parcel");
    }
}
