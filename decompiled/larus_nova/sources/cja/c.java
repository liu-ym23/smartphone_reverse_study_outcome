package cja;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c implements a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23990a = null;

    public c() {
    }

    static {
        f23990a = new c();
    }

    @Override // cja.a
    public final boolean a(long r100, long r101, gja.a<Integer> r102) {
        Intrinsics.checkNotNullParameter(r102, "spec");
        return r102.a(r100, r101);
    }

    @Override // cja.a
    public final Integer b(long r100, Integer r110, Integer r111, float r112, gja.a<Integer> r113) {
        int r114 = r110.intValue();
        int r115 = r111.intValue();
        Intrinsics.checkNotNullParameter(r113, "spec");
        return r113.c(r100, Integer.valueOf(r114), Integer.valueOf(r115), r112);
    }

    @Override // cja.a
    public final float c(long r100, Integer r110, Integer r111, float r112, gja.a<Integer> r113) {
        int r114 = r110.intValue();
        int r115 = r111.intValue();
        Intrinsics.checkNotNullParameter(r113, "spec");
        return r113.d(r100, Integer.valueOf(r114), Integer.valueOf(r115), r112);
    }
}
