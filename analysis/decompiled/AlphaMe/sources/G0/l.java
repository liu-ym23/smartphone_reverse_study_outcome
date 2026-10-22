package G0;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class l implements m, j {

    /* renamed from: a, reason: collision with root package name */
    public final Path f534a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Path f535b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f536c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f537d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final L0.h f538e;

    public l(L0.h hVar) {
        hVar.getClass();
        this.f538e = hVar;
    }

    public final void a(Path.Op op) {
        Matrix matrixI;
        Matrix matrixI2;
        Path path = this.f535b;
        path.reset();
        Path path2 = this.f534a;
        path2.reset();
        ArrayList arrayList = this.f537d;
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            m mVar = (m) arrayList.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                ArrayList arrayList2 = (ArrayList) dVar.c();
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Path pathE = ((m) arrayList2.get(size2)).e();
                    o2.d dVar2 = dVar.f490h;
                    if (dVar2 != null) {
                        matrixI2 = dVar2.i();
                    } else {
                        matrixI2 = dVar.f483a;
                        matrixI2.reset();
                    }
                    pathE.transform(matrixI2);
                    path.addPath(pathE);
                }
            } else {
                path.addPath(mVar.e());
            }
        }
        int i4 = 0;
        m mVar2 = (m) arrayList.get(0);
        if (mVar2 instanceof d) {
            d dVar3 = (d) mVar2;
            List listC = dVar3.c();
            while (true) {
                ArrayList arrayList3 = (ArrayList) listC;
                if (i4 >= arrayList3.size()) {
                    break;
                }
                Path pathE2 = ((m) arrayList3.get(i4)).e();
                o2.d dVar4 = dVar3.f490h;
                if (dVar4 != null) {
                    matrixI = dVar4.i();
                } else {
                    matrixI = dVar3.f483a;
                    matrixI.reset();
                }
                pathE2.transform(matrixI);
                path2.addPath(pathE2);
                i4++;
            }
        } else {
            path2.set(mVar2.e());
        }
        this.f536c.op(path2, path, op);
    }

    @Override // G0.c
    public final void b(List list, List list2) {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f537d;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((m) arrayList.get(i4)).b(list, list2);
            i4++;
        }
    }

    @Override // G0.j
    public final void c(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar instanceof m) {
                this.f537d.add((m) cVar);
                listIterator.remove();
            }
        }
    }

    @Override // G0.m
    public final Path e() {
        Path path = this.f536c;
        path.reset();
        int iA = t.h.a(this.f538e.f1181a);
        if (iA == 0) {
            int i4 = 0;
            while (true) {
                ArrayList arrayList = this.f537d;
                if (i4 >= arrayList.size()) {
                    break;
                }
                path.addPath(((m) arrayList.get(i4)).e());
                i4++;
            }
        } else if (iA == 1) {
            a(Path.Op.UNION);
        } else if (iA == 2) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (iA == 3) {
            a(Path.Op.INTERSECT);
        } else if (iA == 4) {
            a(Path.Op.XOR);
        }
        return path;
    }
}
