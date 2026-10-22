package androidx.media;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public AudioAttributesCompatParcelizer() {
    }

    public static AudioAttributesCompat read(androidx.versionedparcelable.a r3) {
        AudioAttributesCompat r0 = new AudioAttributesCompat();
        r0.f2118a = (AudioAttributesImpl) ZeusTransformUtils.preCheckCast(r3.b(r0.f2118a, 1), AudioAttributesImpl.class, "com.obric.aiagent.plugin");
        return r0;
    }

    public static void write(AudioAttributesCompat r1, androidx.versionedparcelable.a r2) {
        r2.a(false, false);
        r2.a(r1.f2118a, 1);
    }
}
