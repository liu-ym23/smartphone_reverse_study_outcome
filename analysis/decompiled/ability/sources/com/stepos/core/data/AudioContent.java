package com.stepos.core.data;

import L.g;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.data.base.Content;
import d5.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 *2\u00020\u0001:\u0001+B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b%\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b&\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/stepos/core/data/AudioContent;", "Lcom/stepos/core/data/base/Content;", "", "audioBytes", "", "sampleRate", "channelCount", "encoding", "Landroid/os/ParcelFileDescriptor;", "pfd", AppAgent.CONSTRUCT, "([BIIILandroid/os/ParcelFileDescriptor;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "[B", "getAudioBytes", "()[B", "I", "getSampleRate", "getChannelCount", "getEncoding", "Landroid/os/ParcelFileDescriptor;", "getPfd", "()Landroid/os/ParcelFileDescriptor;", "Companion", "d5/a", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioContent extends Content {
    public static final int ENCODING_AUDIO_URL = 102;
    public static final int ENCODING_FILE_DESCRIPTOR = 101;
    public static final int ENCODING_FILE_PATH = 100;
    public static final int ENCODING_PCM_16BIT = 2;
    public static final int ENCODING_PCM_FLOAT32 = 4;
    private final byte[] audioBytes;
    private final int channelCount;
    private final int encoding;
    private final ParcelFileDescriptor pfd;
    private final int sampleRate;
    public static final a Companion = new a();
    public static final Parcelable.Creator<AudioContent> CREATOR = new g(11);

    public /* synthetic */ AudioContent(byte[] bArr, int i, int i6, int i10, ParcelFileDescriptor parcelFileDescriptor, int i11, e eVar) {
        this(bArr, i, i6, (i11 & 8) != 0 ? 2 : i10, (i11 & 16) != 0 ? null : parcelFileDescriptor);
    }

    public static final AudioContent readFieldsFromParcel(Parcel parcel) {
        Companion.getClass();
        k.f(parcel, "parcel");
        return new AudioContent(parcel);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioContent)) {
            return false;
        }
        AudioContent audioContent = (AudioContent) other;
        return Arrays.equals(this.audioBytes, audioContent.audioBytes) && this.sampleRate == audioContent.sampleRate && this.channelCount == audioContent.channelCount && this.encoding == audioContent.encoding;
    }

    public final byte[] getAudioBytes() {
        return this.audioBytes;
    }

    public final int getChannelCount() {
        return this.channelCount;
    }

    public final int getEncoding() {
        return this.encoding;
    }

    public final ParcelFileDescriptor getPfd() {
        return this.pfd;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        return (((((Arrays.hashCode(this.audioBytes) * 31) + this.sampleRate) * 31) + this.channelCount) * 31) + this.encoding;
    }

    public String toString() {
        int i = this.sampleRate;
        int i6 = this.channelCount;
        int i10 = this.encoding;
        int length = this.audioBytes.length;
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "AudioContent(sampleRate=", i6, ", channelCount=", ", encoding=");
        sbS.append(i10);
        sbS.append(", size=");
        sbS.append(length);
        sbS.append(")");
        return sbS.toString();
    }

    public final boolean validate() {
        return !(this.audioBytes.length == 0) && this.sampleRate > 0 && this.channelCount > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeByteArray(this.audioBytes);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.encoding);
        parcel.writeTypedObject(this.pfd, flags);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioContent(byte[] audioBytes, int i, int i6, int i10, ParcelFileDescriptor parcelFileDescriptor) {
        super(3);
        k.f(audioBytes, "audioBytes");
        this.audioBytes = audioBytes;
        this.sampleRate = i;
        this.channelCount = i6;
        this.encoding = i10;
        this.pfd = parcelFileDescriptor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AudioContent(Parcel parcel) {
        k.f(parcel, "parcel");
        byte[] bArrCreateByteArray = parcel.createByteArray();
        this(bArrCreateByteArray == null ? new byte[0] : bArrCreateByteArray, parcel.readInt(), parcel.readInt(), parcel.readInt(), (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR));
    }
}
