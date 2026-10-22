package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes17.dex */
public final class AudioAttributesImplBaseParcelizer {
    public AudioAttributesImplBaseParcelizer() {
    }

    public static AudioAttributesImplBase read(VersionedParcel r100) {
        AudioAttributesImplBase r101 = new AudioAttributesImplBase();
        r101.mUsage = r100.readInt(r101.mUsage, 1);
        r101.mContentType = r100.readInt(r101.mContentType, 2);
        r101.mFlags = r100.readInt(r101.mFlags, 3);
        r101.mLegacyStream = r100.readInt(r101.mLegacyStream, 4);
        return r101;
    }

    public static void write(AudioAttributesImplBase r100, VersionedParcel r101) {
        r101.setSerializationFlags(false, false);
        r101.writeInt(r100.mUsage, 1);
        r101.writeInt(r100.mContentType, 2);
        r101.writeInt(r100.mFlags, 3);
        r101.writeInt(r100.mLegacyStream, 4);
    }
}
