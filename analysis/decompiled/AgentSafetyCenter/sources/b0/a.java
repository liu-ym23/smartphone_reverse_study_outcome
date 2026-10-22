package b0;

import java.util.ArrayList;
import s1.n0;
import s1.o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1710c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1711f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(ArrayList arrayList, int i) {
        super(1);
        this.f1710c = i;
        this.f1711f = arrayList;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f1710c) {
            case 0:
                n0 n0Var = (n0) obj;
                ArrayList arrayList = this.f1711f;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    n0.l(n0Var, (o0) arrayList.get(i), 0, 0);
                }
                break;
            case 1:
                n0 n0Var2 = (n0) obj;
                ArrayList arrayList2 = this.f1711f;
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    n0Var2.g((o0) arrayList2.get(i3), 0, 0, 0.0f);
                }
                break;
            case 2:
                n0 n0Var3 = (n0) obj;
                ArrayList arrayList3 = this.f1711f;
                int size3 = arrayList3.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    n0.m(n0Var3, (o0) arrayList3.get(i10), 0, 0);
                }
                break;
            default:
                n0 n0Var4 = (n0) obj;
                ArrayList arrayList4 = this.f1711f;
                int size4 = arrayList4.size();
                for (int i11 = 0; i11 < size4; i11++) {
                    n0.l(n0Var4, (o0) arrayList4.get(i11), 0, 0);
                }
                break;
        }
        return jb.v.f6774a;
    }
}
