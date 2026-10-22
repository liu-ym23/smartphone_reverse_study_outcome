package o1;

import c7.r;
import p7.k;
import q7.m;

/* loaded from: classes.dex */
public final class b extends m implements k {

    /* renamed from: h, reason: collision with root package name */
    public static final b f7194h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f7195i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f7196j;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7197g;

    static {
        int i2 = 1;
        f7194h = new b(i2, 0);
        f7195i = new b(i2, 1);
        f7196j = new b(i2, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i2, int i10) {
        super(i2);
        this.f7197g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f7197g) {
            case 0:
                ((Number) obj).longValue();
                return r.f1986a;
            case 1:
                return Integer.valueOf(((j) obj).f7216b);
            default:
                d2.j jVar = ((j) obj).f7217c;
                return Integer.valueOf(jVar.f2791d - jVar.f2789b);
        }
    }
}
