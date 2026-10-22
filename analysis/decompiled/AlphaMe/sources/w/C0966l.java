package w;

import java.util.ArrayList;

/* renamed from: w.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0966l {

    /* renamed from: a, reason: collision with root package name */
    public p f15767a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f15768b;

    public static long a(C0960f c0960f, long j4) {
        p pVar = c0960f.f15755d;
        if (pVar instanceof C0964j) {
            return j4;
        }
        ArrayList arrayList = c0960f.f15762k;
        int size = arrayList.size();
        long jMin = j4;
        for (int i4 = 0; i4 < size; i4++) {
            InterfaceC0958d interfaceC0958d = (InterfaceC0958d) arrayList.get(i4);
            if (interfaceC0958d instanceof C0960f) {
                C0960f c0960f2 = (C0960f) interfaceC0958d;
                if (c0960f2.f15755d != pVar) {
                    jMin = Math.min(jMin, a(c0960f2, c0960f2.f15757f + j4));
                }
            }
        }
        if (c0960f != pVar.f15793i) {
            return jMin;
        }
        long j5 = pVar.j();
        long j6 = j4 - j5;
        return Math.min(Math.min(jMin, a(pVar.f15792h, j6)), j6 - r9.f15757f);
    }

    public static long b(C0960f c0960f, long j4) {
        p pVar = c0960f.f15755d;
        if (pVar instanceof C0964j) {
            return j4;
        }
        ArrayList arrayList = c0960f.f15762k;
        int size = arrayList.size();
        long jMax = j4;
        for (int i4 = 0; i4 < size; i4++) {
            InterfaceC0958d interfaceC0958d = (InterfaceC0958d) arrayList.get(i4);
            if (interfaceC0958d instanceof C0960f) {
                C0960f c0960f2 = (C0960f) interfaceC0958d;
                if (c0960f2.f15755d != pVar) {
                    jMax = Math.max(jMax, b(c0960f2, c0960f2.f15757f + j4));
                }
            }
        }
        if (c0960f != pVar.f15792h) {
            return jMax;
        }
        long j5 = pVar.j();
        long j6 = j4 + j5;
        return Math.max(Math.max(jMax, b(pVar.f15793i, j6)), j6 - r9.f15757f);
    }
}
