package r3;

import android.content.res.TypedArray;

/* renamed from: r3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1010f {

    /* renamed from: a, reason: collision with root package name */
    public static final C1010f f20022a = new C1010f();

    private C1010f() {
    }

    public final K2.o a(int i5) {
        if (i5 == -1) {
            return null;
        }
        if (i5 == 0) {
            return K2.o.f3626h.g();
        }
        if (i5 == 1) {
            return K2.o.f3626h.k();
        }
        if (i5 == 2) {
            return K2.o.f3626h.j();
        }
        if (i5 == 3) {
            return K2.o.f3626h.i();
        }
        if (i5 == 4) {
            return K2.o.f3626h.h();
        }
        throw new IllegalArgumentException("steposGlassEffect must be clear(0), light_small(1), light_medium(2), dark_small(3), or dark_medium(4) but was " + i5);
    }

    public final K2.o b(TypedArray typedArray, int i5) {
        j4.k.g(typedArray, "array");
        if (typedArray.hasValue(i5)) {
            return a(typedArray.getInt(i5, -1));
        }
        return null;
    }
}
