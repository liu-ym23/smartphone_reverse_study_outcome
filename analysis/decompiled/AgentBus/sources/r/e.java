package r;

import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8857a = 0;

    public static final a c(int i2, String str) {
        WeakHashMap weakHashMap = p0.f8908u;
        return new a(i2, str);
    }

    public static final n0 d(int i2, String str) {
        WeakHashMap weakHashMap = p0.f8908u;
        return new n0(new z(0, 0, 0, 0), str);
    }

    @Override // r.c
    public void b(i1.m0 m0Var, int i2, int[] iArr, d2.l lVar, int[] iArr2) {
        if (lVar == d2.l.f2793f) {
            i.b(iArr, iArr2, false);
        } else {
            i.c(i2, iArr, iArr2, true);
        }
    }

    public String toString() {
        switch (this.f8857a) {
            case 0:
                return "Arrangement#Start";
            default:
                return super.toString();
        }
    }
}
