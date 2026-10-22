package buc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final c b() {
        f.a r100 = f.a.f20774a;
        Intrinsics.checkNotNullParameter(r100, "trace");
        return new c(r100);
    }

    public static final a a(boolean r100) {
        f.a r101 = f.a.f20774a;
        Intrinsics.checkNotNullParameter(r101, "trace");
        return new a(r100, r101);
    }

    public static final d c(long r100) {
        f.a r101 = f.a.f20774a;
        Intrinsics.checkNotNullParameter(r101, "trace");
        return new d(r100, r101);
    }

    public static final <T> e<T> d(T r100) {
        f.a r101 = f.a.f20774a;
        Intrinsics.checkNotNullParameter(r101, "trace");
        return new e(r100, r101);
    }
}
