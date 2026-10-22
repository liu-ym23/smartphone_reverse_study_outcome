package androidx.camera.core.impl;

import D.B;
import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public interface r extends x {

    /* renamed from: n, reason: collision with root package name */
    public static final Config.a<Integer> f11483n;

    /* renamed from: o, reason: collision with root package name */
    public static final Config.a<Integer> f11484o;

    /* renamed from: p, reason: collision with root package name */
    public static final Config.a<B> f11485p;

    static {
        Class cls = Integer.TYPE;
        f11483n = Config.a.a("camerax.core.imageInput.inputFormat", cls);
        f11484o = Config.a.a("camerax.core.imageInput.secondaryInputFormat", cls);
        f11485p = Config.a.a("camerax.core.imageInput.inputDynamicRange", B.class);
    }

    default B K() {
        return (B) B0.h.f((B) g(f11485p, B.f1997c));
    }

    default boolean N() {
        return b(f11485p);
    }

    default int Y() {
        return ((Integer) g(f11484o, 0)).intValue();
    }

    default int o() {
        return ((Integer) a(f11483n)).intValue();
    }
}
