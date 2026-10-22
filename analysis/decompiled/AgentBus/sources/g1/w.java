package g1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3768g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3769h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(int i2, ArrayList arrayList) {
        super(1);
        this.f3768g = i2;
        this.f3769h = arrayList;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f3768g) {
            case 0:
                r rVar = (r) obj;
                ArrayList arrayList = this.f3769h;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    r.k(rVar, (s) arrayList.get(i2), 0, 0);
                }
                break;
            default:
                r rVar2 = (r) obj;
                ArrayList arrayList2 = this.f3769h;
                int size2 = arrayList2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    r.g(rVar2, (s) arrayList2.get(i10), 0, 0);
                }
                break;
        }
        return c7.r.f1986a;
    }
}
