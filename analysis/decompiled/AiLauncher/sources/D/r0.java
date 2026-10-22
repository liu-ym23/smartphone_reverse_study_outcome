package D;

import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface r0 extends Closeable {

    public static abstract class a {
        public static a f(Size size, Rect rect, CameraInternal cameraInternal, int i10, boolean z10) {
            return new C0768f(size, rect, cameraInternal, i10, z10);
        }

        public abstract CameraInternal a();

        public abstract Rect b();

        public abstract Size c();

        public abstract boolean d();

        public abstract int e();
    }

    public static abstract class b {
        public static b c(int i10, r0 r0Var) {
            return new C0770g(i10, r0Var);
        }

        public abstract int a();

        public abstract r0 b();
    }

    void B0(float[] fArr, float[] fArr2);

    Surface Q(Executor executor, B0.a<b> aVar);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    default int getFormat() {
        return 34;
    }

    Size getSize();

    default void x(float[] fArr, float[] fArr2, boolean z10) {
    }
}
