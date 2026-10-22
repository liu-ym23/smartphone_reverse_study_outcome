package androidx.camera.core.impl;

import J.C;
import J.d0;
import J.h0;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.l;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public interface z<T extends UseCase> extends P.m<T>, r {

    /* renamed from: A, reason: collision with root package name */
    public static final Config.a<SessionConfig> f11540A = Config.a.a("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);

    /* renamed from: B, reason: collision with root package name */
    public static final Config.a<l> f11541B = Config.a.a("camerax.core.useCase.defaultCaptureConfig", l.class);

    /* renamed from: C, reason: collision with root package name */
    public static final Config.a<SessionConfig.e> f11542C = Config.a.a("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.e.class);

    /* renamed from: D, reason: collision with root package name */
    public static final Config.a<l.b> f11543D = Config.a.a("camerax.core.useCase.captureConfigUnpacker", l.b.class);

    /* renamed from: E, reason: collision with root package name */
    public static final Config.a<Integer> f11544E;

    /* renamed from: F, reason: collision with root package name */
    public static final Config.a<Integer> f11545F;

    /* renamed from: G, reason: collision with root package name */
    public static final Config.a<Range<Integer>> f11546G;

    /* renamed from: H, reason: collision with root package name */
    public static final Config.a<Boolean> f11547H;

    /* renamed from: I, reason: collision with root package name */
    public static final Config.a<Map<Size, Integer>> f11548I;

    /* renamed from: J, reason: collision with root package name */
    public static final Config.a<Boolean> f11549J;

    /* renamed from: K, reason: collision with root package name */
    public static final Config.a<Boolean> f11550K;

    /* renamed from: L, reason: collision with root package name */
    public static final Config.a<UseCaseConfigFactory.CaptureType> f11551L;

    /* renamed from: M, reason: collision with root package name */
    public static final Config.a<Integer> f11552M;

    /* renamed from: N, reason: collision with root package name */
    public static final Config.a<Integer> f11553N;

    /* renamed from: O, reason: collision with root package name */
    public static final Config.a<Boolean> f11554O;

    /* renamed from: P, reason: collision with root package name */
    public static final Config.a<d0.b> f11555P;

    /* renamed from: Q, reason: collision with root package name */
    public static final Config.a<StreamUseCase> f11556Q;

    public class a implements d0.b {
        public a() {
        }

        @Override // J.d0.b
        public d0 a(C c10) {
            return new h0(c10);
        }
    }

    public interface b<T extends UseCase, C extends z<T>, B> extends D.C<T> {
        C d();
    }

    static {
        Class cls = Integer.TYPE;
        f11544E = Config.a.a("camerax.core.useCase.surfaceOccupancyPriority", cls);
        f11545F = Config.a.a("camerax.core.useCase.sessionType", cls);
        f11546G = Config.a.a("camerax.core.useCase.targetFrameRate", Range.class);
        f11547H = Config.a.a("camerax.core.useCase.isStrictFrameRateRequired", Boolean.class);
        f11548I = Config.a.a("camerax.core.useCase.resolutionToMaxFrameRate", Map.class);
        Class cls2 = Boolean.TYPE;
        f11549J = Config.a.a("camerax.core.useCase.zslDisabled", cls2);
        f11550K = Config.a.a("camerax.core.useCase.highResolutionDisabled", cls2);
        f11551L = Config.a.a("camerax.core.useCase.captureType", UseCaseConfigFactory.CaptureType.class);
        f11552M = Config.a.a("camerax.core.useCase.previewStabilizationMode", cls);
        f11553N = Config.a.a("camerax.core.useCase.videoStabilizationMode", cls);
        f11554O = Config.a.a("camerax.core.useCase.isVideoQualitySelectorDefault", Boolean.class);
        f11555P = Config.a.a("camerax.core.useCase.takePictureManagerProvider", d0.b.class);
        f11556Q = Config.a.a("camerax.core.useCase.streamUseCase", StreamUseCase.class);
    }

    default Range<Integer> A(Range<Integer> range) {
        return (Range) g(f11546G, range);
    }

    default int D(int i10) {
        return ((Integer) g(f11544E, Integer.valueOf(i10))).intValue();
    }

    default int F() {
        return ((Integer) g(f11552M, 0)).intValue();
    }

    default boolean G() {
        Boolean bool = (Boolean) g(f11547H, Boolean.FALSE);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    default SessionConfig P() {
        return (SessionConfig) a(f11540A);
    }

    default boolean Q(boolean z10) {
        return ((Boolean) g(f11549J, Boolean.valueOf(z10))).booleanValue();
    }

    default StreamUseCase U() {
        StreamUseCase streamUseCase = (StreamUseCase) g(f11556Q, StreamUseCase.DEFAULT);
        Objects.requireNonNull(streamUseCase);
        return streamUseCase;
    }

    default UseCaseConfigFactory.CaptureType V() {
        return (UseCaseConfigFactory.CaptureType) a(f11551L);
    }

    default int W(Size size) {
        Map map = (Map) g(f11548I, null);
        if (map == null || !map.containsKey(size)) {
            return Integer.MAX_VALUE;
        }
        Integer num = (Integer) map.get(size);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    default boolean c0(boolean z10) {
        return ((Boolean) g(f11550K, Boolean.valueOf(z10))).booleanValue();
    }

    default boolean e0() {
        return b(f11546G);
    }

    default SessionConfig.e f0(SessionConfig.e eVar) {
        return (SessionConfig.e) g(f11542C, eVar);
    }

    default int n(int i10) {
        return ((Integer) g(f11545F, Integer.valueOf(i10))).intValue();
    }

    default SessionConfig p(SessionConfig sessionConfig) {
        return (SessionConfig) g(f11540A, sessionConfig);
    }

    default d0.b r() {
        d0.b bVar = (d0.b) g(f11555P, new a());
        Objects.requireNonNull(bVar);
        return bVar;
    }

    default l.b s(l.b bVar) {
        return (l.b) g(f11543D, bVar);
    }

    default l u(l lVar) {
        return (l) g(f11541B, lVar);
    }

    default int z() {
        return ((Integer) g(f11553N, 0)).intValue();
    }
}
