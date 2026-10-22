package i1;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class h1 implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final h1 f4491b = new h1(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4492a;

    public /* synthetic */ h1(int i2) {
        this.f4492a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f4492a) {
            case 0:
                f0 f0Var = (f0) obj;
                f0 f0Var2 = (f0) obj2;
                int iF = q7.k.f(f0Var2.f4465s, f0Var.f4465s);
                return iF != 0 ? iF : q7.k.f(f0Var.hashCode(), f0Var2.hashCode());
            default:
                f0 f0Var3 = (f0) obj;
                f0 f0Var4 = (f0) obj2;
                int iF2 = q7.k.f(f0Var3.f4465s, f0Var4.f4465s);
                return iF2 != 0 ? iF2 : q7.k.f(f0Var3.hashCode(), f0Var4.hashCode());
        }
    }
}
