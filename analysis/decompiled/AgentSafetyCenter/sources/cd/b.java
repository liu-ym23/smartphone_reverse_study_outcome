package cd;

import ad.d0;
import ad.e0;
import ad.h0;
import ad.n;
import ad.r;
import ad.x;
import ad.z;
import fd.f;
import hc.h;
import hc.o;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p5.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements r {
    @Override // ad.r
    public final e0 a(f fVar) throws Throwable {
        n nVar;
        System.currentTimeMillis();
        z zVar = fVar.f4066e;
        zVar.getClass();
        Throwable th = null;
        c cVar = new c(zVar, (e0) null);
        if (zVar.h().f449j) {
            cVar = new c((z) null, (e0) null);
        }
        z zVar2 = (z) cVar.f9717f;
        e0 e0Var = (e0) cVar.f9718g;
        if (zVar2 == null && e0Var == null) {
            d0 d0Var = new d0();
            d0Var.f453a = zVar;
            d0Var.f454b = x.HTTP_1_1;
            d0Var.f455c = 504;
            d0Var.f456d = "Unsatisfiable Request (only-if-cached)";
            d0Var.f459g = bd.b.f2076c;
            d0Var.f462k = -1L;
            d0Var.f463l = System.currentTimeMillis();
            return d0Var.a();
        }
        if (zVar2 == null) {
            e0Var.getClass();
            d0 d0VarG = e0Var.g();
            e0 e0VarA = a.a(e0Var);
            d0.b(e0VarA, "cacheResponse");
            d0VarG.i = e0VarA;
            return d0VarG.a();
        }
        e0 e0VarB = fVar.b(zVar2);
        if (e0Var != null) {
            if (e0VarB.f471h == 304) {
                d0 d0VarG2 = e0Var.g();
                n nVar2 = e0Var.f472j;
                n nVar3 = e0VarB.f472j;
                ArrayList arrayList = new ArrayList(20);
                int size = nVar2.size();
                int i = 0;
                while (i < size) {
                    String strB = nVar2.b(i);
                    Throwable th2 = th;
                    String strD = nVar2.d(i);
                    if ("Warning".equalsIgnoreCase(strB)) {
                        nVar = nVar2;
                        if (o.U(strD, "1", false)) {
                        }
                        i++;
                        th = th2;
                        nVar2 = nVar;
                    } else {
                        nVar = nVar2;
                    }
                    if (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strB) || "Content-Encoding".equalsIgnoreCase(strB) || HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(strB) || !a.b(strB) || nVar3.a(strB) == null) {
                        strB.getClass();
                        strD.getClass();
                        arrayList.add(strB);
                        arrayList.add(h.w0(strD).toString());
                    }
                    i++;
                    th = th2;
                    nVar2 = nVar;
                }
                Throwable th3 = th;
                int size2 = nVar3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String strB2 = nVar3.b(i3);
                    if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strB2) && !"Content-Encoding".equalsIgnoreCase(strB2) && !HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(strB2) && a.b(strB2)) {
                        String strD2 = nVar3.d(i3);
                        strB2.getClass();
                        strD2.getClass();
                        arrayList.add(strB2);
                        arrayList.add(h.w0(strD2).toString());
                    }
                }
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                ne.b bVar = new ne.b();
                ArrayList arrayList2 = bVar.f8958c;
                arrayList2.getClass();
                strArr.getClass();
                List listAsList = Arrays.asList(strArr);
                listAsList.getClass();
                arrayList2.addAll(listAsList);
                d0VarG2.f458f = bVar;
                d0VarG2.f462k = e0VarB.f477o;
                d0VarG2.f463l = e0VarB.f478p;
                e0 e0VarA2 = a.a(e0Var);
                d0.b(e0VarA2, "cacheResponse");
                d0VarG2.i = e0VarA2;
                e0 e0VarA3 = a.a(e0VarB);
                d0.b(e0VarA3, "networkResponse");
                d0VarG2.f460h = e0VarA3;
                d0VarG2.a();
                h0 h0Var = e0VarB.f473k;
                h0Var.getClass();
                h0Var.close();
                throw th3;
            }
            h0 h0Var2 = e0Var.f473k;
            if (h0Var2 != null) {
                bd.b.d(h0Var2);
            }
        }
        d0 d0VarG3 = e0VarB.g();
        e0 e0VarA4 = a.a(e0Var);
        d0.b(e0VarA4, "cacheResponse");
        d0VarG3.i = e0VarA4;
        e0 e0VarA5 = a.a(e0VarB);
        d0.b(e0VarA5, "networkResponse");
        d0VarG3.f460h = e0VarA5;
        return d0VarG3.a();
    }
}
