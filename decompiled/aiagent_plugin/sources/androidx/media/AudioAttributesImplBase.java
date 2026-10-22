package androidx.media;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2124d;

    AudioAttributesImplBase() {
        this.f2121a = 0;
        this.f2122b = 0;
        this.f2123c = 0;
        this.f2124d = -1;
    }

    public int a() {
        int r0 = this.f2124d;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return AudioAttributesCompat.a(false, this.f2123c, this.f2121a);
    }

    public int b() {
        return this.f2122b;
    }

    public int c() {
        return this.f2121a;
    }

    public int d() {
        int r0 = this.f2123c;
        int r2 = a();
        if (r2 != 6) goto L6;
        r0 = r0 | 4;
    L9:
        return r0 & 273;
    L6:
        if (r2 != 7) goto L9;
        r0 = r0 | 1;
        goto L9
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2122b), Integer.valueOf(this.f2123c), Integer.valueOf(this.f2121a), Integer.valueOf(this.f2124d)});
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, AudioAttributesImplBase.class) == true) goto L5;
        return false;
    L5:
        AudioAttributesImplBase r5 = (AudioAttributesImplBase) ZeusTransformUtils.preCheckCast(r4, AudioAttributesImplBase.class, "com.obric.aiagent.plugin");
        if (this.f2122b == r5.b()) goto L8;
        return false;
    L8:
        if (this.f2123c == r5.d()) goto L10;
        return false;
    L10:
        if (this.f2121a == r5.c()) goto L12;
        return false;
    L12:
        if (this.f2124d != r5.f2124d) goto L18;
        return true;
    L18:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AudioAttributesCompat:");
        if (this.f2124d == (-1)) goto L5;
        r0.append(" stream=").append(this.f2124d);
        r0.append(" derived");
    L5:
        r0.append(" usage=").append(AudioAttributesCompat.a(this.f2121a)).append(" content=").append(this.f2122b).append(" flags=0x").append(Integer.toHexString(this.f2123c).toUpperCase());
        return r0.toString();
    }
}
