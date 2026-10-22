package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes17.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public AudioAttributesImplApi21Parcelizer() {
    }

    public static AudioAttributesImplApi21 read(VersionedParcel r100) {
        AudioAttributesImplApi21 r101 = new AudioAttributesImplApi21();
        r101.mAudioAttributes = (AudioAttributes) r100.readParcelable(r101.mAudioAttributes, 1);
        r101.mLegacyStreamType = r100.readInt(r101.mLegacyStreamType, 2);
        return r101;
    }

    public static void write(AudioAttributesImplApi21 r100, VersionedParcel r101) {
        r101.setSerializationFlags(false, false);
        r101.writeParcelable(r100.mAudioAttributes, 1);
        r101.writeInt(r100.mLegacyStreamType, 2);
    }
}
