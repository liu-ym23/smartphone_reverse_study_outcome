package androidx.camera.core.impl;

import K.Z;
import K.z0;
import androidx.camera.core.impl.Config;
import java.util.List;

/* loaded from: classes.dex */
public interface g extends x {

    /* renamed from: e, reason: collision with root package name */
    public static final Config.a<UseCaseConfigFactory> f11414e = Config.a.a("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);

    /* renamed from: f, reason: collision with root package name */
    public static final Config.a<Z> f11415f = Config.a.a("camerax.core.camera.compatibilityId", Z.class);

    /* renamed from: g, reason: collision with root package name */
    public static final Config.a<Integer> f11416g = Config.a.a("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);

    /* renamed from: h, reason: collision with root package name */
    public static final Config.a<z0> f11417h = Config.a.a("camerax.core.camera.SessionProcessor", z0.class);

    /* renamed from: i, reason: collision with root package name */
    public static final Config.a<Boolean> f11418i = Config.a.a("camerax.core.camera.isZslDisabled", Boolean.class);

    /* renamed from: j, reason: collision with root package name */
    public static final Config.a<Boolean> f11419j = Config.a.a("camerax.core.camera.isPostviewSupported", Boolean.class);

    /* renamed from: k, reason: collision with root package name */
    public static final Config.a<a> f11420k = Config.a.a("camerax.core.camera.PostviewFormatSelector", a.class);

    /* renamed from: l, reason: collision with root package name */
    public static final Config.a<Boolean> f11421l = Config.a.a("camerax.core.camera.isCaptureProcessProgressSupported", Boolean.class);

    /* renamed from: m, reason: collision with root package name */
    public static final a f11422m = new a() { // from class: K.p
        @Override // androidx.camera.core.impl.g.a
        public final int a(int i10, List list) {
            return androidx.camera.core.impl.g.M(i10, list);
        }
    };

    public interface a {
        int a(int i10, List<Integer> list);
    }

    static /* synthetic */ int M(int i10, List list) {
        if (list.contains(35)) {
            return 35;
        }
        if (list.contains(256)) {
            return 256;
        }
        return list.contains(4101) ? 4101 : 0;
    }

    default a H() {
        return (a) g(f11420k, f11422m);
    }

    default z0 T(z0 z0Var) {
        return (z0) g(f11417h, z0Var);
    }

    Z a0();

    default boolean b0() {
        return ((Boolean) g(f11421l, Boolean.FALSE)).booleanValue();
    }

    default boolean i() {
        return ((Boolean) g(f11419j, Boolean.FALSE)).booleanValue();
    }

    default UseCaseConfigFactory k() {
        return (UseCaseConfigFactory) g(f11414e, UseCaseConfigFactory.f11371a);
    }

    default int x() {
        return ((Integer) g(f11416g, 0)).intValue();
    }
}
