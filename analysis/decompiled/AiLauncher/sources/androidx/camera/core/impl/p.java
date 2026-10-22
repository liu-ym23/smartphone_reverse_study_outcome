package androidx.camera.core.impl;

import D.H;
import D.X;
import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public final class p implements z<H>, s, P.n {

    /* renamed from: S, reason: collision with root package name */
    public static final Config.a<Integer> f11462S = Config.a.a("camerax.core.imageAnalysis.backpressureStrategy", H.b.class);

    /* renamed from: T, reason: collision with root package name */
    public static final Config.a<Integer> f11463T = Config.a.a("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);

    /* renamed from: U, reason: collision with root package name */
    public static final Config.a<X> f11464U = Config.a.a("camerax.core.imageAnalysis.imageReaderProxyProvider", X.class);

    /* renamed from: V, reason: collision with root package name */
    public static final Config.a<Integer> f11465V = Config.a.a("camerax.core.imageAnalysis.outputImageFormat", H.e.class);

    /* renamed from: W, reason: collision with root package name */
    public static final Config.a<Boolean> f11466W = Config.a.a("camerax.core.imageAnalysis.onePixelShiftEnabled", Boolean.class);

    /* renamed from: X, reason: collision with root package name */
    public static final Config.a<Boolean> f11467X = Config.a.a("camerax.core.imageAnalysis.outputImageRotationEnabled", Boolean.class);

    /* renamed from: R, reason: collision with root package name */
    public final v f11468R;

    public p(v vVar) {
        this.f11468R = vVar;
    }

    @Override // androidx.camera.core.impl.x
    public Config getConfig() {
        return this.f11468R;
    }

    public int h0(int i10) {
        return ((Integer) g(f11462S, Integer.valueOf(i10))).intValue();
    }

    public int i0(int i10) {
        return ((Integer) g(f11463T, Integer.valueOf(i10))).intValue();
    }

    public X j0() {
        return (X) g(f11464U, null);
    }

    public Boolean k0(Boolean bool) {
        return (Boolean) g(f11466W, bool);
    }

    public int l0(int i10) {
        return ((Integer) g(f11465V, Integer.valueOf(i10))).intValue();
    }

    public Boolean m0(Boolean bool) {
        return (Boolean) g(f11467X, bool);
    }

    @Override // androidx.camera.core.impl.r
    public int o() {
        return 35;
    }
}
