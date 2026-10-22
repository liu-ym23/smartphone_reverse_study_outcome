package androidx.media;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public AudioAttributesImplBaseParcelizer() {
    }

    public static AudioAttributesImplBase read(androidx.versionedparcelable.a r3) {
        AudioAttributesImplBase r0 = new AudioAttributesImplBase();
        r0.f2121a = r3.b(r0.f2121a, 1);
        r0.f2122b = r3.b(r0.f2122b, 2);
        r0.f2123c = r3.b(r0.f2123c, 3);
        r0.f2124d = r3.b(r0.f2124d, 4);
        return r0;
    }

    public static void write(AudioAttributesImplBase r2, androidx.versionedparcelable.a r3) {
        r3.a(false, false);
        r3.a(r2.f2121a, 1);
        r3.a(r2.f2122b, 2);
        r3.a(r2.f2123c, 3);
        r3.a(r2.f2124d, 4);
    }
}
