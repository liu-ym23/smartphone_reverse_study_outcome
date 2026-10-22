package androidx.camera.core.impl;

import D.B;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {
    public static b a(SurfaceConfig surfaceConfig, int i10, Size size, B b10, List<UseCaseConfigFactory.CaptureType> list, Config config, int i11, Range<Integer> range, boolean z10, int i12) {
        return new c(surfaceConfig, i10, size, b10, list, config, i11, range, z10, i12);
    }

    public abstract List<UseCaseConfigFactory.CaptureType> b();

    public abstract int c();

    public abstract B d();

    public abstract int e();

    public abstract Config f();

    public abstract int g();

    public abstract Size h();

    public abstract SurfaceConfig i();

    public abstract Range<Integer> j();

    public abstract boolean k();

    public y l(Config config) {
        return y.a(h()).g(g()).c(j()).b(d()).d(config).a();
    }
}
