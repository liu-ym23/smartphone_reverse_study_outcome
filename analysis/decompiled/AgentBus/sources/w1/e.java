package w1;

import c7.r;
import p7.k;
import q7.m;

/* loaded from: classes.dex */
public final class e extends m implements k {

    /* renamed from: h, reason: collision with root package name */
    public static final e f10645h;

    /* renamed from: i, reason: collision with root package name */
    public static final e f10646i;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f10647g;

    static {
        int i2 = 1;
        f10645h = new e(i2, 0);
        f10646i = new e(i2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i2, int i10) {
        super(i2);
        this.f10647g = i10;
    }

    @Override // p7.k
    public final /* synthetic */ Object invoke(Object obj) {
        switch (this.f10647g) {
            case 0:
                return r.f1986a;
            default:
                throw null;
        }
    }
}
