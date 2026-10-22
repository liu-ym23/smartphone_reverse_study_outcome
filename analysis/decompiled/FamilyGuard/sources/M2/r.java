package M2;

import L2.e;
import W3.C0403n;
import i4.InterfaceC0772l;
import java.util.List;

/* loaded from: classes.dex */
final class r implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final e.c f4085a;

    public r(e.c cVar) {
        j4.k.g(cVar, "token");
        this.f4085a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(Object obj) {
        j4.k.g(obj, "d");
        L2.e.f3817a.g(obj, "setBlendArray", new Class[]{int[].class, int[].class}, new int[0], new int[0]);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(int[] iArr, int[] iArr2, Object obj) {
        j4.k.g(obj, "d");
        L2.e.f3817a.g(obj, "setBlendArray", new Class[]{int[].class, int[].class}, iArr, iArr2);
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        this.f4085a.c(new InterfaceC0772l() { // from class: M2.p
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return r.d(obj);
            }
        });
    }

    public void e(K2.E e6) {
        j4.k.g(e6, "params");
        C0374k c0374k = e6 instanceof C0374k ? (C0374k) e6 : null;
        if (c0374k == null) {
            return;
        }
        List listR = C0403n.R(c0374k.e(), 4);
        int size = listR.size();
        final int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr[i5] = ((Number) ((V3.m) listR.get(i5)).c()).intValue();
        }
        int size2 = listR.size();
        final int[] iArr2 = new int[size2];
        for (int i6 = 0; i6 < size2; i6++) {
            iArr2[i6] = ((Number) ((V3.m) listR.get(i6)).d()).intValue();
        }
        this.f4085a.b(new InterfaceC0772l() { // from class: M2.q
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return r.f(iArr, iArr2, obj);
            }
        });
    }
}
