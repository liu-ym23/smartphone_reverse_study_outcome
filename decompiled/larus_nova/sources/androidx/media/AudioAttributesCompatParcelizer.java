package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes17.dex */
public final class AudioAttributesCompatParcelizer {
    public AudioAttributesCompatParcelizer() {
    }

    public static AudioAttributesCompat read(VersionedParcel r100) {
        AudioAttributesCompat r101 = new AudioAttributesCompat();
        r101.mImpl = (AudioAttributesImpl) r100.readVersionedParcelable(r101.mImpl, 1);
        return r101;
    }

    public static void write(AudioAttributesCompat r100, VersionedParcel r101) {
        r101.setSerializationFlags(false, false);
        r101.writeVersionedParcelable(r100.mImpl, 1);
    }
}
