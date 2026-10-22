package cja;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23989a = null;

    public b() {
    }

    static {
        f23989a = new b();
    }

    @Override // cja.a
    public final boolean a(long r100, long r101, gja.a<Float> r102) {
        Intrinsics.checkNotNullParameter(r102, "spec");
        return r102.a(r100, r101);
    }

    @Override // cja.a
    public final Float b(long r100, Float r110, Float r111, float r112, gja.a<Float> r113) {
        float r114 = r110.floatValue();
        float r115 = r111.floatValue();
        Intrinsics.checkNotNullParameter(r113, "spec");
        return r113.c(r100, Float.valueOf(r114), Float.valueOf(r115), r112);
    }

    @Override // cja.a
    public final float c(long r100, Float r110, Float r111, float r112, gja.a<Float> r113) {
        float r114 = r110.floatValue();
        float r115 = r111.floatValue();
        Intrinsics.checkNotNullParameter(r113, "spec");
        return r113.d(r100, Float.valueOf(r114), Float.valueOf(r115), r112);
    }
}
