package androidx.media;

import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import q0.AbstractC0822a;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC0822a abstractC0822a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3994a = abstractC0822a.f(audioAttributesImplBase.f3994a, 1);
        audioAttributesImplBase.f3995b = abstractC0822a.f(audioAttributesImplBase.f3995b, 2);
        audioAttributesImplBase.f3996c = abstractC0822a.f(audioAttributesImplBase.f3996c, 3);
        audioAttributesImplBase.f3997d = abstractC0822a.f(audioAttributesImplBase.f3997d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC0822a abstractC0822a) {
        abstractC0822a.getClass();
        abstractC0822a.j(audioAttributesImplBase.f3994a, 1);
        abstractC0822a.j(audioAttributesImplBase.f3995b, 2);
        abstractC0822a.j(audioAttributesImplBase.f3996c, 3);
        abstractC0822a.j(audioAttributesImplBase.f3997d, 4);
    }
}
