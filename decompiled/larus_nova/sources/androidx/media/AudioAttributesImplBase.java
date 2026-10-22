package androidx.media;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    int mContentType;
    int mFlags;
    int mLegacyStream;
    int mUsage;

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream)});
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        int r100 = this.mFlags;
        int r101 = getLegacyStreamType();
        if (r101 != 6) goto L6;
        r100 = r100 | 4;
    L9:
        return r100 & 273;
    L6:
        if (r101 != 7) goto L9;
        r100 = r100 | 1;
        goto L9
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r100 = this.mLegacyStream;
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        return AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return AudioAttributesCompat.toVolumeStreamType(true, this.mFlags, this.mUsage);
    }

    @Override // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putInt("androidx.media.audio_attrs.USAGE", this.mUsage);
        r100.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.mContentType);
        r100.putInt("androidx.media.audio_attrs.FLAGS", this.mFlags);
        int r101 = this.mLegacyStream;
        if (r101 == (-1)) goto L5;
        r100.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r101);
    L5:
        return r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream == (-1)) goto L5;
        r100.append(" stream=");
        r100.append(this.mLegacyStream);
        r100.append(" derived");
    L5:
        r100.append(" usage=");
        r100.append(AudioAttributesCompat.usageToString(this.mUsage));
        r100.append(" content=");
        r100.append(this.mContentType);
        r100.append(" flags=0x");
        r100.append(Integer.toHexString(this.mFlags).toUpperCase());
        return r100.toString();
    }

    public AudioAttributesImplBase() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mContentType;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStream;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mUsage;
    }

    public static AudioAttributesImpl fromBundle(Bundle r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.getInt("androidx.media.audio_attrs.USAGE", 0);
        return new AudioAttributesImplBase(r100.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), r100.getInt("androidx.media.audio_attrs.FLAGS", 0), r101, r100.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AudioAttributesImplBase) == true) goto L5;
        return false;
    L5:
        AudioAttributesImplBase r101 = (AudioAttributesImplBase) r100;
        if (this.mContentType == r101.getContentType()) goto L8;
        return false;
    L8:
        if (this.mFlags == r101.getFlags()) goto L10;
        return false;
    L10:
        if (this.mUsage == r101.getUsage()) goto L12;
        return false;
    L12:
        if (this.mLegacyStream != r101.mLegacyStream) goto L18;
        return true;
    L18:
        return false;
    }

    public AudioAttributesImplBase(int r100, int r101, int r102, int r103) {
        this.mContentType = r100;
        this.mFlags = r101;
        this.mUsage = r102;
        this.mLegacyStream = r103;
    }
}
