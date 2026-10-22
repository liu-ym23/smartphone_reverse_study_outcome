package androidx.media;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3608d;

    public AudioAttributesImplBase() {
        this.f3605a = 0;
        this.f3606b = 0;
        this.f3607c = 0;
        this.f3608d = -1;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof AudioAttributesImplBase) == true) goto L5;
        return false;
    L5:
        AudioAttributesImplBase r11 = (AudioAttributesImplBase) r10;
        if (this.f3606b == r11.getContentType()) goto L8;
        return false;
    L8:
        if (this.f3607c == r11.getFlags()) goto L10;
        return false;
    L10:
        if (this.f3605a == r11.getUsage()) goto L12;
        return false;
    L12:
        if (this.f3608d != r11.f3608d) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return null;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.f3606b;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        int r10 = this.f3607c;
        int r11 = getLegacyStreamType();
        if (r11 != 6) goto L6;
        r10 = r10 | 4;
    L9:
        return r10 & 273;
    L6:
        if (r11 != 7) goto L9;
        r10 = r10 | 1;
        goto L9
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r10 = this.f3608d;
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        return AudioAttributesCompat.a(false, this.f3607c, this.f3605a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.f3608d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.f3605a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return AudioAttributesCompat.a(true, this.f3607c, this.f3605a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3606b), Integer.valueOf(this.f3607c), Integer.valueOf(this.f3605a), Integer.valueOf(this.f3608d)});
    }

    @Override // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle r10 = new Bundle();
        r10.putInt("androidx.media.audio_attrs.USAGE", this.f3605a);
        r10.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.f3606b);
        r10.putInt("androidx.media.audio_attrs.FLAGS", this.f3607c);
        int r11 = this.f3608d;
        if (r11 == (-1)) goto L5;
        r10.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r11);
    L5:
        return r10;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder("AudioAttributesCompat:");
        if (this.f3608d == (-1)) goto L5;
        r10.append(" stream=");
        r10.append(this.f3608d);
        r10.append(" derived");
    L5:
        r10.append(" usage=");
        r10.append(AudioAttributesCompat.b(this.f3605a));
        r10.append(" content=");
        r10.append(this.f3606b);
        r10.append(" flags=0x");
        r10.append(Integer.toHexString(this.f3607c).toUpperCase());
        return r10.toString();
    }
}
