package w;

import java.util.ArrayList;
import v.e;

/* loaded from: classes.dex */
public class i {
    public static o a(v.e eVar, int i5, ArrayList<o> arrayList, o oVar) {
        int iS1;
        int i6 = i5 == 0 ? eVar.f23037I0 : eVar.f23039J0;
        if (i6 != -1 && (oVar == null || i6 != oVar.f23456b)) {
            int i7 = 0;
            while (true) {
                if (i7 >= arrayList.size()) {
                    break;
                }
                o oVar2 = arrayList.get(i7);
                if (oVar2.c() == i6) {
                    if (oVar != null) {
                        oVar.g(i5, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i7++;
                }
            }
        } else if (i6 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof v.j) && (iS1 = ((v.j) eVar).s1(i5)) != -1) {
                int i8 = 0;
                while (true) {
                    if (i8 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = arrayList.get(i8);
                    if (oVar3.c() == iS1) {
                        oVar = oVar3;
                        break;
                    }
                    i8++;
                }
            }
            if (oVar == null) {
                oVar = new o(i5);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof v.h) {
                v.h hVar = (v.h) eVar;
                hVar.r1().c(hVar.s1() == 0 ? 1 : 0, arrayList, oVar);
            }
            if (i5 == 0) {
                eVar.f23037I0 = oVar.c();
                eVar.f23044O.c(i5, arrayList, oVar);
                eVar.f23046Q.c(i5, arrayList, oVar);
            } else {
                eVar.f23039J0 = oVar.c();
                eVar.f23045P.c(i5, arrayList, oVar);
                eVar.f23048S.c(i5, arrayList, oVar);
                eVar.f23047R.c(i5, arrayList, oVar);
            }
            eVar.f23051V.c(i5, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList<o> arrayList, int i5) {
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            o oVar = arrayList.get(i6);
            if (i5 == oVar.f23456b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:165:0x0341  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(v.f r17, w.C1196b.InterfaceC0254b r18) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.i.c(v.f, w.b$b):boolean");
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        e.b bVar5;
        e.b bVar6;
        e.b bVar7 = e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = e.b.WRAP_CONTENT) || (bVar3 == e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = e.b.WRAP_CONTENT) || (bVar4 == e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
