package com.stepos.core.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 *2\u00020\u0001:\u0001*B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b%\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b&\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/stepos/core/data/AudioContent;", "Lcom/stepos/core/data/base/Content;", "", "audioBytes", "", "sampleRate", "channelCount", "encoding", "Landroid/os/ParcelFileDescriptor;", "pfd", "<init>", "([BIIILandroid/os/ParcelFileDescriptor;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "[B", "getAudioBytes", "()[B", "I", "getSampleRate", "getChannelCount", "getEncoding", "Landroid/os/ParcelFileDescriptor;", "getPfd", "()Landroid/os/ParcelFileDescriptor;", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<AudioContent> CREATOR = new Parcelable.Creator<AudioContent>() { // from class: com.stepos.core.data.AudioContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioContent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            AudioContent audioContent = new AudioContent(parcel);
            ((Content) audioContent).params = contentParamsCreateFromParcel;
            return audioContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioContent[] newArray(int size) {
            return new AudioContent[size];
        }
    };

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stepos/core/data/AudioContent$Companion;", "", "<init>", "()V", "ENCODING_PCM_16BIT", "", "ENCODING_PCM_FLOAT32", "ENCODING_FILE_PATH", "ENCODING_FILE_DESCRIPTOR", "ENCODING_AUDIO_URL", "readFieldsFromParcel", "Lcom/stepos/core/data/AudioContent;", "parcel", "Landroid/os/Parcel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final AudioContent readFieldsFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AudioContent(parcel);
        }

        private Companion() {
        }
    }

    public /* synthetic */ AudioContent(byte[] bArr, int i10, int i11, int i12, ParcelFileDescriptor parcelFileDescriptor, int i13, i iVar) {
        this(bArr, i10, i11, (i13 & 8) != 0 ? 2 : i12, (i13 & 16) != 0 ? null : parcelFileDescriptor);
    }

    public static final AudioContent readFieldsFromParcel(Parcel parcel) {
        return INSTANCE.readFieldsFromParcel(parcel);
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
        return "AudioContent(sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", encoding=" + this.encoding + ", size=" + this.audioBytes.length + ")";
    }

    public final boolean validate() {
        return !(this.audioBytes.length == 0) && this.sampleRate > 0 && this.channelCount > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeByteArray(this.audioBytes);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.encoding);
        parcel.writeTypedObject(this.pfd, flags);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioContent(byte[] audioBytes, int i10, int i11, int i12, ParcelFileDescriptor parcelFileDescriptor) {
        super(3);
        p.i(audioBytes, "audioBytes");
        this.audioBytes = audioBytes;
        this.sampleRate = i10;
        this.channelCount = i11;
        this.encoding = i12;
        this.pfd = parcelFileDescriptor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AudioContent(Parcel parcel) {
        p.i(parcel, "parcel");
        byte[] bArrCreateByteArray = parcel.createByteArray();
        this(bArrCreateByteArray == null ? new byte[0] : bArrCreateByteArray, parcel.readInt(), parcel.readInt(), parcel.readInt(), (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR));
    }
}
