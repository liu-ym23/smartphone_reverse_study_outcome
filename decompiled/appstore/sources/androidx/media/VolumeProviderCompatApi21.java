package androidx.media;

import android.media.VolumeProvider;

/* JADX INFO: loaded from: classes.dex */
public abstract class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int r10);

        void onSetVolumeTo(int r10);
    }

    public static class a extends VolumeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Delegate f3718a;

        public a(int r10, int r11, int r12, Delegate r13) {
            this.f3718a = r13;
            super(r10, r11, r12);
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int r10) {
            this.f3718a.onAdjustVolume(r10);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int r10) {
            this.f3718a.onSetVolumeTo(r10);
        }
    }

    public static Object a(int r10, int r11, int r12, Delegate r13) {
        return new a(r10, r11, r12, r13);
    }
}
