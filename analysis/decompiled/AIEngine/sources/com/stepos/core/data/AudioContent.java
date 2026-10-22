package com.stepos.core.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import java.util.Arrays;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
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
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<AudioContent> CREATOR = new Parcelable.Creator<AudioContent>() { // from class: com.stepos.core.data.AudioContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioContent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            AudioContent audioContent = new AudioContent(parcel);
            ((Content) audioContent).params = contentParamsCreateFromParcel;
            return audioContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioContent[] newArray(int i10) {
            return new AudioContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AudioContent readFieldsFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new AudioContent(parcel);
        }

        private Companion() {
        }
    }

    public /* synthetic */ AudioContent(byte[] bArr, int i10, int i11, int i12, ParcelFileDescriptor parcelFileDescriptor, int i13, e eVar) {
        this(bArr, i10, i11, (i13 & 8) != 0 ? 2 : i12, (i13 & 16) != 0 ? null : parcelFileDescriptor);
    }

    public static final AudioContent readFieldsFromParcel(Parcel parcel) {
        return Companion.readFieldsFromParcel(parcel);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioContent)) {
            return false;
        }
        AudioContent audioContent = (AudioContent) obj;
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
        int i10 = this.sampleRate;
        int i11 = this.channelCount;
        int i12 = this.encoding;
        int length = this.audioBytes.length;
        StringBuilder sbD = h0.e.d(i10, "AudioContent(sampleRate=", i11, ", channelCount=", ", encoding=");
        sbD.append(i12);
        sbD.append(", size=");
        sbD.append(length);
        sbD.append(")");
        return sbD.toString();
    }

    public final boolean validate() {
        return !(this.audioBytes.length == 0) && this.sampleRate > 0 && this.channelCount > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        parcel.writeByteArray(this.audioBytes);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.encoding);
        parcel.writeTypedObject(this.pfd, i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioContent(byte[] audioBytes, int i10, int i11, int i12, ParcelFileDescriptor parcelFileDescriptor) {
        super(3);
        g.f(audioBytes, "audioBytes");
        this.audioBytes = audioBytes;
        this.sampleRate = i10;
        this.channelCount = i11;
        this.encoding = i12;
        this.pfd = parcelFileDescriptor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AudioContent(Parcel parcel) {
        g.f(parcel, "parcel");
        byte[] bArrCreateByteArray = parcel.createByteArray();
        this(bArrCreateByteArray == null ? new byte[0] : bArrCreateByteArray, parcel.readInt(), parcel.readInt(), parcel.readInt(), (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR));
    }
}
