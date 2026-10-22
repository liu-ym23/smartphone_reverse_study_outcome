package androidx.media;

import android.media.AudioAttributes;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public AudioAttributesImplApi21Parcelizer() {
    }

    public static AudioAttributesImplApi21 read(androidx.versionedparcelable.a r4) {
        AudioAttributesImplApi21 r0 = new AudioAttributesImplApi21();
        r0.f2119a = (AudioAttributes) ZeusTransformUtils.preCheckCast(r4.b(r0.f2119a, 1), AudioAttributes.class, "com.obric.aiagent.plugin");
        r0.f2120b = r4.b(r0.f2120b, 2);
        return r0;
    }

    public static void write(AudioAttributesImplApi21 r2, androidx.versionedparcelable.a r3) {
        r3.a(false, false);
        r3.a(r2.f2119a, 1);
        r3.a(r2.f2120b, 2);
    }
}
