package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesCompatParcelizer {
    public AudioAttributesCompatParcelizer() {
    }

    public static AudioAttributesCompat read(VersionedParcel r10) {
        AudioAttributesCompat r11 = new AudioAttributesCompat();
        r11.f3601a = (AudioAttributesImpl) r10.v(r11.f3601a, 1);
        return r11;
    }

    public static void write(AudioAttributesCompat r10, VersionedParcel r11) {
        r11.x(false, false);
        r11.M(r10.f3601a, 1);
    }
}
