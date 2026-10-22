package f8;

import java.util.List;

/* loaded from: classes.dex */
public final class r extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final r f3508h;

    /* renamed from: i, reason: collision with root package name */
    public static final r f3509i;

    /* renamed from: j, reason: collision with root package name */
    public static final r f3510j;

    /* renamed from: k, reason: collision with root package name */
    public static final r f3511k;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3512g;

    static {
        int i2 = 1;
        f3508h = new r(i2, 0);
        f3509i = new r(i2, 1);
        f3510j = new r(i2, 2);
        f3511k = new r(i2, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i2, int i10) {
        super(i2);
        this.f3512g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f3512g) {
            case 0:
                q7.k.e((e9.b) obj, "it");
                return 0;
            case 1:
                e0 e0Var = (e0) obj;
                q7.k.e(e0Var, "it");
                return ((i8.c0) e0Var).f4758j;
            case 2:
                q7.k.e((j) obj, "it");
                return Boolean.valueOf(!(r1 instanceof i));
            default:
                j jVar = (j) obj;
                q7.k.e(jVar, "it");
                List typeParameters = ((b) jVar).getTypeParameters();
                q7.k.d(typeParameters, "it as CallableDescriptor).typeParameters");
                return d7.r.H0(typeParameters);
        }
    }
}
