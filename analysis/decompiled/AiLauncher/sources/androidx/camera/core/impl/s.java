package androidx.camera.core.impl;

import D.C0764d;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.Config;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface s extends x {

    /* renamed from: q, reason: collision with root package name */
    public static final Config.a<Integer> f11486q = Config.a.a("camerax.core.imageOutput.targetAspectRatio", C0764d.class);

    /* renamed from: r, reason: collision with root package name */
    public static final Config.a<Integer> f11487r;

    /* renamed from: s, reason: collision with root package name */
    public static final Config.a<Integer> f11488s;

    /* renamed from: t, reason: collision with root package name */
    public static final Config.a<Integer> f11489t;

    /* renamed from: u, reason: collision with root package name */
    public static final Config.a<Size> f11490u;

    /* renamed from: v, reason: collision with root package name */
    public static final Config.a<Size> f11491v;

    /* renamed from: w, reason: collision with root package name */
    public static final Config.a<Size> f11492w;

    /* renamed from: x, reason: collision with root package name */
    public static final Config.a<List<Pair<Integer, Size[]>>> f11493x;

    /* renamed from: y, reason: collision with root package name */
    public static final Config.a<X.c> f11494y;

    /* renamed from: z, reason: collision with root package name */
    public static final Config.a<List<Size>> f11495z;

    public interface a<B> {
        B b(int i10);

        B c(Size size);
    }

    static {
        Class cls = Integer.TYPE;
        f11487r = Config.a.a("camerax.core.imageOutput.targetRotation", cls);
        f11488s = Config.a.a("camerax.core.imageOutput.appTargetRotation", cls);
        f11489t = Config.a.a("camerax.core.imageOutput.mirrorMode", cls);
        f11490u = Config.a.a("camerax.core.imageOutput.targetResolution", Size.class);
        f11491v = Config.a.a("camerax.core.imageOutput.defaultResolution", Size.class);
        f11492w = Config.a.a("camerax.core.imageOutput.maxResolution", Size.class);
        f11493x = Config.a.a("camerax.core.imageOutput.supportedResolutions", List.class);
        f11494y = Config.a.a("camerax.core.imageOutput.resolutionSelector", X.c.class);
        f11495z = Config.a.a("camerax.core.imageOutput.customOrderedResolutions", List.class);
    }

    static void y(s sVar) {
        boolean zB = sVar.B();
        boolean z10 = sVar.S(null) != null;
        if (zB && z10) {
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }
        if (sVar.R(null) != null) {
            if (zB || z10) {
                throw new IllegalArgumentException("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
            }
        }
    }

    default boolean B() {
        return b(f11486q);
    }

    default int E() {
        return ((Integer) a(f11486q)).intValue();
    }

    default int I(int i10) {
        return ((Integer) g(f11487r, Integer.valueOf(i10))).intValue();
    }

    default List<Size> L(List<Size> list) {
        List list2 = (List) g(f11495z, list);
        if (list2 != null) {
            return new ArrayList(list2);
        }
        return null;
    }

    default Size O(Size size) {
        return (Size) g(f11491v, size);
    }

    default X.c R(X.c cVar) {
        return (X.c) g(f11494y, cVar);
    }

    default Size S(Size size) {
        return (Size) g(f11490u, size);
    }

    default int g0(int i10) {
        return ((Integer) g(f11489t, Integer.valueOf(i10))).intValue();
    }

    default Size j(Size size) {
        return (Size) g(f11492w, size);
    }

    default List<Pair<Integer, Size[]>> l(List<Pair<Integer, Size[]>> list) {
        return (List) g(f11493x, list);
    }

    default X.c m() {
        return (X.c) a(f11494y);
    }

    default int v(int i10) {
        return ((Integer) g(f11488s, Integer.valueOf(i10))).intValue();
    }
}
