package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f3602c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f3603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3604b;

    public AudioAttributesImplApi21() {
        this.f3604b = -1;
    }

    public static Method a() {
    L8:
        return null;
    L4:
        if (f3602c != null) goto L7;
        f3602c = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[]{AudioAttributes.class});     // Catch: NoSuchMethodException -> L8
    L7:
        return f3602c;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof AudioAttributesImplApi21) == true) goto L7;
        return false;
    L7:
        return this.f3603a.equals(((AudioAttributesImplApi21) r10).f3603a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return this.f3603a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.f3603a.getContentType();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        return this.f3603a.getFlags();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r10 = this.f3604b;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        Method r11 = a();
        if (r11 != null) goto L14;
        Log.w("AudioAttributesCompat21", "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
        return -1;
    L14:
        return ((Integer) r11.invoke(null, new Object[]{this.f3603a})).intValue();
    L11:
        e = move-exception;
        Log.w("AudioAttributesCompat21", "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, e);
        return -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.f3604b;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.f3603a.getUsage();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return this.f3603a.getVolumeControlStream();
    }

    public int hashCode() {
        return this.f3603a.hashCode();
    }

    @Override // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle r10 = new Bundle();
        r10.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.f3603a);
        int r11 = this.f3604b;
        if (r11 == (-1)) goto L5;
        r10.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r11);
    L5:
        return r10;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3603a;
    }
}
