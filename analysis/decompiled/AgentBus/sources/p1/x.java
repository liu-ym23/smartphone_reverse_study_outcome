package p1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator[] f8378a;

    /* renamed from: b, reason: collision with root package name */
    public static final r f8379b;

    static {
        Comparator[] comparatorArr = new Comparator[2];
        int i2 = 0;
        while (i2 < 2) {
            comparatorArr[i2] = new w(1, new w(i2 == 0 ? d.f8271c : d.f8270b));
            i2++;
        }
        f8378a = comparatorArr;
        f8379b = r.f8342x;
    }

    public static final void a(n nVar, ArrayList arrayList, c1.w wVar, c1.w wVar2, k.t tVar) {
        i iVar = nVar.f8315d;
        Object objG = iVar.f8304f.g(s.f8356m);
        if (objG == null) {
            objG = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) objG).booleanValue();
        if ((zBooleanValue || ((Boolean) wVar2.invoke(nVar)).booleanValue()) && ((Boolean) wVar.invoke(nVar)).booleanValue()) {
            arrayList.add(nVar);
        }
        if (zBooleanValue) {
            tVar.g(nVar.f8318g, b(nVar, wVar, wVar2, nVar.i((4 & 1) != 0 ? !nVar.f8313b : false, (4 & 2) == 0)));
            return;
        }
        List listI = nVar.i((4 & 1) != 0 ? !nVar.f8313b : false, (4 & 2) == 0);
        int size = listI.size();
        for (int i2 = 0; i2 < size; i2++) {
            a((n) listI.get(i2), arrayList, wVar, wVar2, tVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.ArrayList b(p1.n r17, c1.w r18, c1.w r19, java.util.List r20) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.x.b(p1.n, c1.w, c1.w, java.util.List):java.util.ArrayList");
    }
}
