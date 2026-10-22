package androidx.media;

import android.media.VolumeProvider;

/* JADX INFO: loaded from: classes17.dex */
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int r100);

        void onSetVolumeTo(int r100);
    }

    private VolumeProviderCompatApi21() {
    }

    public static void setCurrentVolume(Object r100, int r101) {
        ((VolumeProvider) r100).setCurrentVolume(r101);
    }

    public static Object createVolumeProvider(final int r100, final int r101, final int r102, final Delegate r103) {
        return new AnonymousClass1(r100, r101, r102, r103);
    }
}
