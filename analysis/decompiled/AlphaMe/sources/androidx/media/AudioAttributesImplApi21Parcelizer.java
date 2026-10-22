package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import q0.AbstractC0822a;
import q0.C0823b;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC0822a abstractC0822a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f3992a = (AudioAttributes) abstractC0822a.g(audioAttributesImplApi21.f3992a, 1);
        audioAttributesImplApi21.f3993b = abstractC0822a.f(audioAttributesImplApi21.f3993b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC0822a abstractC0822a) {
        abstractC0822a.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi21.f3992a;
        abstractC0822a.i(1);
        ((C0823b) abstractC0822a).f13979e.writeParcelable(audioAttributes, 0);
        abstractC0822a.j(audioAttributesImplApi21.f3993b, 2);
    }
}
