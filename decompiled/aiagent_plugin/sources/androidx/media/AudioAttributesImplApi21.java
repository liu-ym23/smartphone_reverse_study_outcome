package androidx.media;

import android.media.AudioAttributes;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AudioAttributes f2119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2120b;

    AudioAttributesImplApi21() {
        this.f2120b = -1;
    }

    public int hashCode() {
        return this.f2119a.hashCode();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, AudioAttributesImplApi21.class) == true) goto L6;
        return false;
    L6:
        AudioAttributesImplApi21 r4 = (AudioAttributesImplApi21) ZeusTransformUtils.preCheckCast(r3, AudioAttributesImplApi21.class, "com.obric.aiagent.plugin");
        return this.f2119a.equals(r4.f2119a);
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2119a;
    }
}
