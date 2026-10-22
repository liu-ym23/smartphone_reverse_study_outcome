package t3;

import kotlin.ranges.l;

/* renamed from: t3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1146a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1146a f22641a = new C1146a();

    private C1146a() {
    }

    private final int a(int i5, int i6, int i7, int i8) {
        int iB = l.b(i5, 0);
        int i9 = (int) ((iB * i8) / 100);
        int i10 = iB - i9;
        if (i6 > iB - i7) {
            if (i6 <= i10) {
                i7 = iB - i6;
            } else if (i7 > i9) {
                i7 = i9;
            }
        }
        return l.h(i7, 0, iB);
    }

    public final int b(int i5, int i6, int i7) {
        return a(i5, i6, i7, 50);
    }

    public final int c(int i5, int i6, int i7) {
        return a(i5, i6, i7, 30);
    }

    public final boolean d(boolean z5, boolean z6, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (!z5 || !z6) {
            return false;
        }
        if (i5 <= i6) {
            return i7 > i8 && i9 > i10;
        }
        return true;
    }
}
