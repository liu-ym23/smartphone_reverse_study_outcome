package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplBaseParcelizer {
    public AudioAttributesImplBaseParcelizer() {
    }

    public static AudioAttributesImplBase read(VersionedParcel r10) {
        AudioAttributesImplBase r11 = new AudioAttributesImplBase();
        r11.f3605a = r10.p(r11.f3605a, 1);
        r11.f3606b = r10.p(r11.f3606b, 2);
        r11.f3607c = r10.p(r11.f3607c, 3);
        r11.f3608d = r10.p(r11.f3608d, 4);
        return r11;
    }

    public static void write(AudioAttributesImplBase r10, VersionedParcel r11) {
        r11.x(false, false);
        r11.F(r10.f3605a, 1);
        r11.F(r10.f3606b, 2);
        r11.F(r10.f3607c, 3);
        r11.F(r10.f3608d, 4);
    }
}
