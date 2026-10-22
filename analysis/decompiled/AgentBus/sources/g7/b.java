package g7;

import a4.u;
import c2.q;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import d2.o;
import d7.s;
import ia.y1;
import java.util.ArrayList;
import java.util.List;
import na.w;
import o4.a2;
import p5.p;
import s1.a0;
import s1.c0;
import s1.g0;
import s1.j0;
import s1.k0;
import s1.x;
import s1.y;
import u0.b0;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3862f;

    public /* synthetic */ b(int i2) {
        this.f3862f = i2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        Object obj3;
        s1.g gVar;
        Object objA;
        switch (this.f3862f) {
            case 0:
                String str = (String) obj;
                j jVar = (j) obj2;
                q7.k.e(str, "acc");
                q7.k.e(jVar, "element");
                if (str.length() == 0) {
                    return jVar.toString();
                }
                return str + ", " + jVar;
            case 1:
                return h.plus$lambda$0((l) obj, (j) obj2);
            case 2:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                obj3 = bool;
                break;
            case 3:
                return ((l) obj).Q((j) obj2);
            case 4:
                return ((l) obj).Q((j) obj2);
            case 5:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 6:
                j jVar2 = (j) obj2;
                if (!(jVar2 instanceof y1)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? jVar2 : Integer.valueOf(iIntValue + 1);
            case 7:
                y1 y1Var = (y1) obj;
                j jVar3 = (j) obj2;
                if (y1Var != null) {
                    return y1Var;
                }
                if (jVar3 instanceof y1) {
                    return (y1) jVar3;
                }
                return null;
            case 8:
                obj3 = (w) obj;
                break;
            case 9:
                String str2 = (String) obj;
                String str3 = (String) obj2;
                q7.k.e(str2, "old");
                q7.k.e(str3, "new");
                return (str2.hashCode() == 1429828318 && str2.equals("assistant")) ? str2 : str3;
            case 10:
                Integer num2 = (Integer) obj2;
                q7.k.e((String) obj, "<unused var>");
                return Integer.valueOf((num2 != null ? num2.intValue() : 0) + 1);
            case 11:
                a2 a2Var = (a2) obj2;
                q7.k.e((String) obj, "<unused var>");
                q7.k.e(a2Var, "e");
                String str4 = a2Var.f7267a;
                String str5 = a2Var.f7268b;
                c5.b bVar = a2Var.f7269c;
                String str6 = a2Var.f7270d;
                long j2 = a2Var.f7272f;
                q7.k.e(str4, "frameId");
                q7.k.e(str5, "sessionKey");
                return new a2(str4, str5, bVar, str6, true, j2);
            case 12:
                p pVar = (p) obj2;
                q7.k.e((String) obj, "<unused var>");
                if (pVar == null) {
                    pVar = new p();
                }
                return new p(pVar.f8477a, 0);
            case 13:
                s1.e eVar = (s1.e) obj2;
                return s.q0(eVar.f9246g, y.a(eVar.f9245f, y.f9312a, (k0.b) obj));
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return Integer.valueOf(((c2.l) obj2).f1877a);
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                c2.p pVar2 = (c2.p) obj2;
                return s.q0(Float.valueOf(pVar2.f1881a), Float.valueOf(pVar2.f1882b));
            case 16:
                k0.b bVar2 = (k0.b) obj;
                q qVar = (q) obj2;
                d2.n nVar = new d2.n(qVar.f1884a);
                x xVar = y.f9328q;
                return s.q0(y.a(nVar, xVar, bVar2), y.a(new d2.n(qVar.f1885b), xVar, bVar2));
            case 17:
                return Integer.valueOf(((v1.k) obj2).f10363f);
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                s1.j jVar4 = (s1.j) obj2;
                return s.q0(jVar4.f9277a, y.a(jVar4.f9278b, y.f9320i, (k0.b) obj));
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                return Float.valueOf(((c2.a) obj2).f1857a);
            case 20:
                k0.b bVar3 = (k0.b) obj;
                List list = (List) obj2;
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(y.a((s1.c) list.get(i2), y.f9313b, bVar3));
                }
                return arrayList;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                g0 g0Var = (g0) obj2;
                return s.q0(Integer.valueOf((int) (g0Var.f9270a >> 32)), Integer.valueOf((int) (g0Var.f9270a & 4294967295L)));
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                k0.b bVar4 = (k0.b) obj;
                b0 b0Var = (b0) obj2;
                return s.q0(y.a(new u0.m(b0Var.f9890a), y.f9327p, bVar4), y.a(new t0.b(b0Var.f9891b), y.f9329r, bVar4), Float.valueOf(b0Var.f9892c));
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                d2.n nVar2 = (d2.n) obj2;
                return nVar2 == null ? false : d2.n.a(nVar2.f2799a, d2.n.f2798c) ? Boolean.FALSE : s.q0(Float.valueOf(d2.n.c(nVar2.f2799a)), new o(d2.n.b(nVar2.f2799a)));
            case 24:
                t0.b bVar5 = (t0.b) obj2;
                return bVar5 == null ? false : t0.b.b(bVar5.f9654a, 9205357640488583168L) ? Boolean.FALSE : s.q0(Float.valueOf(Float.intBitsToFloat((int) (bVar5.f9654a >> 32))), Float.valueOf(Float.intBitsToFloat((int) (bVar5.f9654a & 4294967295L))));
            case 25:
                k0.b bVar6 = (k0.b) obj;
                List list2 = ((y1.b) obj2).f11543f;
                ArrayList arrayList2 = new ArrayList(list2.size());
                int size2 = list2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    arrayList2.add(y.a((y1.a) list2.get(i10), y.f9331t, bVar6));
                }
                return arrayList2;
            case 26:
                return ((y1.a) obj2).f11541a.toLanguageTag();
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                c2.i iVar = (c2.i) obj2;
                return s.q0(new c2.f(iVar.f1869a), new c2.h(iVar.f1870b), new c2.g());
            case 28:
                k0.b bVar7 = (k0.b) obj;
                s1.c cVar = (s1.c) obj2;
                Object obj4 = cVar.f9229a;
                if (obj4 instanceof s1.p) {
                    gVar = s1.g.f9260f;
                } else if (obj4 instanceof a0) {
                    gVar = s1.g.f9261g;
                } else if (obj4 instanceof k0) {
                    gVar = s1.g.f9262h;
                } else if (obj4 instanceof j0) {
                    gVar = s1.g.f9263i;
                } else if (obj4 instanceof s1.j) {
                    gVar = s1.g.f9264j;
                } else if (obj4 instanceof s1.i) {
                    gVar = s1.g.f9265k;
                } else {
                    if (!(obj4 instanceof c0)) {
                        throw new UnsupportedOperationException();
                    }
                    gVar = s1.g.f9266l;
                }
                switch (gVar.ordinal()) {
                    case 0:
                        q7.k.c(obj4, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                        objA = y.a((s1.p) obj4, y.f9318g, bVar7);
                        break;
                    case 1:
                        q7.k.c(obj4, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                        objA = y.a((a0) obj4, y.f9319h, bVar7);
                        break;
                    case 2:
                        q7.k.c(obj4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                        objA = y.a((k0) obj4, y.f9314c, bVar7);
                        break;
                    case 3:
                        q7.k.c(obj4, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                        objA = y.a((j0) obj4, y.f9315d, bVar7);
                        break;
                    case 4:
                        q7.k.c(obj4, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                        objA = y.a((s1.j) obj4, y.f9316e, bVar7);
                        break;
                    case 5:
                        q7.k.c(obj4, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                        objA = y.a((s1.i) obj4, y.f9317f, bVar7);
                        break;
                    case 6:
                        q7.k.c(obj4, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
                        objA = ((c0) obj4).f9233a;
                        break;
                    default:
                        throw new u();
                }
                return s.q0(gVar, objA, Integer.valueOf(cVar.f9230b), Integer.valueOf(cVar.f9231c), cVar.f9232d);
            default:
                s1.i iVar2 = (s1.i) obj2;
                return s.q0(iVar2.f9275a, y.a(iVar2.f9276b, y.f9320i, (k0.b) obj));
        }
        return obj3;
    }
}
