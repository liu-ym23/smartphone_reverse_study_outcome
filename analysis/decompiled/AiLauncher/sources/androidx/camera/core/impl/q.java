package androidx.camera.core.impl;

import D.X;
import K.P;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.Config;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class q implements z<ImageCapture>, s, P.e {

    /* renamed from: S, reason: collision with root package name */
    public static final Config.a<Integer> f11469S;

    /* renamed from: T, reason: collision with root package name */
    public static final Config.a<Integer> f11470T;

    /* renamed from: U, reason: collision with root package name */
    public static final Config.a<P> f11471U;

    /* renamed from: V, reason: collision with root package name */
    public static final Config.a<Integer> f11472V;

    /* renamed from: W, reason: collision with root package name */
    public static final Config.a<Integer> f11473W;

    /* renamed from: X, reason: collision with root package name */
    public static final Config.a<Integer> f11474X;

    /* renamed from: Y, reason: collision with root package name */
    public static final Config.a<X> f11475Y;

    /* renamed from: Z, reason: collision with root package name */
    public static final Config.a<Boolean> f11476Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final Config.a<Integer> f11477a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final Config.a<Integer> f11478b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final Config.a<ImageCapture.h> f11479c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final Config.a<X.c> f11480d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final Config.a<Boolean> f11481e0;

    /* renamed from: R, reason: collision with root package name */
    public final v f11482R;

    static {
        Class cls = Integer.TYPE;
        f11469S = Config.a.a("camerax.core.imageCapture.captureMode", cls);
        f11470T = Config.a.a("camerax.core.imageCapture.flashMode", cls);
        f11471U = Config.a.a("camerax.core.imageCapture.captureBundle", P.class);
        f11472V = Config.a.a("camerax.core.imageCapture.bufferFormat", Integer.class);
        f11473W = Config.a.a("camerax.core.imageCapture.outputFormat", Integer.class);
        f11474X = Config.a.a("camerax.core.imageCapture.maxCaptureStages", Integer.class);
        f11475Y = Config.a.a("camerax.core.imageCapture.imageReaderProxyProvider", X.class);
        f11476Z = Config.a.a("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
        f11477a0 = Config.a.a("camerax.core.imageCapture.flashType", cls);
        f11478b0 = Config.a.a("camerax.core.imageCapture.jpegCompressionQuality", cls);
        f11479c0 = Config.a.a("camerax.core.imageCapture.screenFlash", ImageCapture.h.class);
        f11480d0 = Config.a.a("camerax.core.useCase.postviewResolutionSelector", X.c.class);
        f11481e0 = Config.a.a("camerax.core.useCase.isPostviewEnabled", Boolean.class);
    }

    public q(v vVar) {
        this.f11482R = vVar;
    }

    @Override // androidx.camera.core.impl.x
    public Config getConfig() {
        return this.f11482R;
    }

    public P h0(P p10) {
        return (P) g(f11471U, p10);
    }

    public int i0() {
        return ((Integer) a(f11469S)).intValue();
    }

    public int j0(int i10) {
        return ((Integer) g(f11470T, Integer.valueOf(i10))).intValue();
    }

    public int k0(int i10) {
        return ((Integer) g(f11477a0, Integer.valueOf(i10))).intValue();
    }

    public X l0() {
        return (X) g(f11475Y, null);
    }

    public Executor m0(Executor executor) {
        return (Executor) g(P.e.f5330a, executor);
    }

    public ImageCapture.h n0() {
        return (ImageCapture.h) g(f11479c0, null);
    }

    @Override // androidx.camera.core.impl.r
    public int o() {
        return ((Integer) a(r.f11483n)).intValue();
    }

    public boolean o0() {
        return b(f11469S);
    }
}
