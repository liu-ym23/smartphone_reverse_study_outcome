package h0;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4947c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ s1.h0 f4948f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4949g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4950h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ArrayList arrayList, s1.h0 h0Var, int i, ArrayList arrayList2) {
        super(1);
        float f5 = m.f5059a;
        this.f4947c = arrayList;
        this.f4948f = h0Var;
        this.f4949g = i;
        this.f4950h = arrayList2;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        s1.h0 h0Var;
        s1.n0 n0Var = (s1.n0) obj;
        float f5 = m.f5061c;
        ArrayList arrayList = this.f4947c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            List list = (List) arrayList.get(i);
            int size2 = list.size();
            int[] iArr = new int[size2];
            int i3 = 0;
            while (true) {
                h0Var = this.f4948f;
                if (i3 >= size2) {
                    break;
                }
                iArr[i3] = ((s1.o0) list.get(i3)).f11277c + (i3 < list.size() + (-1) ? h0Var.e0(f5) : 0);
                i3++;
            }
            w.e eVar = w.k.f14991b;
            int[] iArr2 = new int[size2];
            for (int i10 = 0; i10 < size2; i10++) {
                iArr2[i10] = 0;
            }
            eVar.b(h0Var, this.f4949g, iArr, h0Var.getLayoutDirection(), iArr2);
            int size3 = list.size();
            for (int i11 = 0; i11 < size3; i11++) {
                n0Var.g((s1.o0) list.get(i11), iArr2[i11], ((Number) this.f4950h.get(i)).intValue(), 0.0f);
            }
        }
        return jb.v.f6774a;
    }
}
