package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";
    static Method sAudioAttributesToLegacyStreamType;
    AudioAttributes mAudioAttributes;
    int mLegacyStreamType;

    public static Method getAudioAttributesToLegacyStreamTypeMethod() {
    L7:
        return null;
    L3:
        if (sAudioAttributesToLegacyStreamType != null) goto L6;
        sAudioAttributesToLegacyStreamType = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[]{AudioAttributes.class});     // Catch: NoSuchMethodException -> L7
    L6:
        return sAudioAttributesToLegacyStreamType;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mAudioAttributes.getContentType();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        return this.mAudioAttributes.getFlags();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r100 = this.mLegacyStreamType;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        Method r101 = getAudioAttributesToLegacyStreamTypeMethod();
        if (r101 != null) goto L14;
        return -1;
    L14:
        return ((Integer) r101.invoke(null, new Object[]{this.mAudioAttributes})).intValue();
    L13:
        return -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mAudioAttributes.getUsage();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mAudioAttributes.getVolumeControlStream();
    L7:
        return AudioAttributesCompat.toVolumeStreamType(true, getFlags(), getUsage());
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    @Override // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.mAudioAttributes);
        int r101 = this.mLegacyStreamType;
        if (r101 == (-1)) goto L5;
        r100.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r101);
    L5:
        return r100;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }

    public AudioAttributesImplApi21() {
        this.mLegacyStreamType = -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStreamType;
    }

    public AudioAttributesImplApi21(AudioAttributes r100) {
        this(r100, -1);
    }

    public static AudioAttributesImpl fromBundle(Bundle r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        AudioAttributes r101 = (AudioAttributes) r100.getParcelable("androidx.media.audio_attrs.FRAMEWORKS");
        if (r101 != null) goto L9;
        return null;
    L9:
        return new AudioAttributesImplApi21(r101, r100.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AudioAttributesImplApi21) == true) goto L7;
        return false;
    L7:
        return this.mAudioAttributes.equals(((AudioAttributesImplApi21) r100).mAudioAttributes);
    }

    public AudioAttributesImplApi21(AudioAttributes r100, int r101) {
        this.mAudioAttributes = r100;
        this.mLegacyStreamType = r101;
    }
}
