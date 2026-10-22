package V3;

import i4.InterfaceC0761a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5523a;

        static {
            int[] iArr = new int[j.values().length];
            try {
                iArr[j.f5524a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[j.f5525b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[j.f5526c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5523a = iArr;
        }
    }

    public static <T> f<T> a(j jVar, InterfaceC0761a<? extends T> interfaceC0761a) {
        j4.k.g(jVar, "mode");
        j4.k.g(interfaceC0761a, "initializer");
        int i5 = a.f5523a[jVar.ordinal()];
        int i6 = 2;
        if (i5 == 1) {
            j4.g gVar = null;
            return new q(interfaceC0761a, gVar, i6, gVar);
        }
        if (i5 == 2) {
            return new p(interfaceC0761a);
        }
        if (i5 == 3) {
            return new w(interfaceC0761a);
        }
        throw new l();
    }

    public static <T> f<T> b(InterfaceC0761a<? extends T> interfaceC0761a) {
        j4.k.g(interfaceC0761a, "initializer");
        j4.g gVar = null;
        return new q(interfaceC0761a, gVar, 2, gVar);
    }
}
