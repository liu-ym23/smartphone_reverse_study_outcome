package x;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import s1.e0;
import s1.o0;
import y.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public h f15420a;

    /* renamed from: b, reason: collision with root package name */
    public x f15421b;

    /* renamed from: c, reason: collision with root package name */
    public long f15422c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ x f15423d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ int f15424e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f15425f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ w0.c f15426g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ int f15427h;
    public /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ long f15428j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ r f15429k;

    public final n a(int i, long j10) {
        h hVar = this.f15420a;
        Object objD = hVar.d(i);
        Object objB = hVar.b(i);
        x xVar = this.f15421b;
        h hVar2 = xVar.f15835g;
        HashMap map = xVar.f15836h;
        List list = (List) map.get(Integer.valueOf(i));
        List list2 = list;
        if (list == null) {
            Object objD2 = hVar2.d(i);
            List listW = xVar.f15834f.W(objD2, xVar.f15833c.a(i, objD2, hVar2.b(i)));
            int size = listW.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(((e0) listW.get(i3)).q(j10));
            }
            map.put(Integer.valueOf(i), arrayList);
            list2 = arrayList;
        }
        int i10 = i == this.f15424e + (-1) ? 0 : this.f15425f;
        w0.c cVar = this.f15426g;
        o2.l layoutDirection = this.f15423d.f15834f.getLayoutDirection();
        long j11 = this.f15428j;
        androidx.compose.foundation.lazy.layout.a aVar = this.f15429k.f15491n;
        n nVar = new n();
        nVar.f15455a = i;
        nVar.f15456b = list2;
        nVar.f15457c = cVar;
        nVar.f15458d = layoutDirection;
        nVar.f15459e = i10;
        nVar.f15460f = j11;
        nVar.f15461g = objD;
        nVar.f15462h = objB;
        nVar.i = aVar;
        nVar.f15467n = Integer.MIN_VALUE;
        int size2 = list2.size();
        int i11 = 0;
        int iMax = 0;
        for (int i12 = 0; i12 < size2; i12++) {
            o0 o0Var = (o0) list2.get(i12);
            i11 += o0Var.f11278f;
            iMax = Math.max(iMax, o0Var.f11277c);
        }
        nVar.f15464k = i11;
        int i13 = i11 + nVar.f15459e;
        nVar.f15465l = i13 >= 0 ? i13 : 0;
        nVar.f15466m = iMax;
        nVar.f15468o = new int[nVar.f15456b.size() * 2];
        VarHandle.storeStoreFence();
        return nVar;
    }
}
