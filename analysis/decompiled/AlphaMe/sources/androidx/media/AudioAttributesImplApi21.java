package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* loaded from: classes.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f3992a;

    /* renamed from: b, reason: collision with root package name */
    public int f3993b = -1;

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f3992a.equals(((AudioAttributesImplApi21) obj).f3992a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3992a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3992a;
    }
}
