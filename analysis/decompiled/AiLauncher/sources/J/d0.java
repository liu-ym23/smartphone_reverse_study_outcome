package J;

import androidx.camera.core.ImageCaptureException;

/* loaded from: classes.dex */
public interface d0 {

    public static abstract class a {
        public static a c(int i10, ImageCaptureException imageCaptureException) {
            return new C0854i(i10, imageCaptureException);
        }

        public abstract ImageCaptureException a();

        public abstract int b();
    }

    public interface b {
        d0 a(C c10);
    }

    void a(D d10);

    void b();

    void pause();

    void resume();
}
