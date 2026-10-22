package androidx.media;

import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import java.lang.reflect.InvocationTargetException;
import q0.AbstractC0822a;
import q0.InterfaceC0824c;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0822a abstractC0822a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        InterfaceC0824c interfaceC0824cH = audioAttributesCompat.f3991a;
        if (abstractC0822a.e(1)) {
            interfaceC0824cH = abstractC0822a.h();
        }
        audioAttributesCompat.f3991a = (AudioAttributesImpl) interfaceC0824cH;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0822a abstractC0822a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0822a.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f3991a;
        abstractC0822a.i(1);
        abstractC0822a.k(audioAttributesImpl);
    }
}
