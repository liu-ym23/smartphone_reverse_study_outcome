package J2;

import V3.l;
import j4.k;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: J2.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0044a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3211a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.f3212a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.f3213b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c.f3214c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3211a = iArr;
        }
    }

    @Override // J2.b
    public void a(f fVar) {
        k.g(fVar, "error");
        int i5 = C0044a.f3211a[fVar.b().ordinal()];
        if (i5 == 1) {
            d.f3217a.b("Core", fVar.c(), fVar.a());
        } else if (i5 == 2) {
            d.f3217a.a("Core", fVar.c(), fVar.a());
        } else {
            if (i5 == 3) {
                throw new IllegalStateException(fVar.c(), fVar.a());
            }
            throw new l();
        }
    }
}
