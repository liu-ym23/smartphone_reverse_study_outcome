package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer {
    public AudioAttributesImplApi21Parcelizer() {
    }

    public static AudioAttributesImplApi21 read(VersionedParcel r10) {
        AudioAttributesImplApi21 r11 = new AudioAttributesImplApi21();
        r11.f3603a = (AudioAttributes) r10.r(r11.f3603a, 1);
        r11.f3604b = r10.p(r11.f3604b, 2);
        return r11;
    }

    public static void write(AudioAttributesImplApi21 r10, VersionedParcel r11) {
        r11.x(false, false);
        r11.H(r10.f3603a, 1);
        r11.F(r10.f3604b, 2);
    }
}
