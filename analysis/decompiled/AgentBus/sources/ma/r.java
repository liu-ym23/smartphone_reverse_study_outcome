package ma;

import ia.d0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class r extends i7.c implements la.k {

    /* renamed from: f, reason: collision with root package name */
    public final la.k f6507f;

    /* renamed from: g, reason: collision with root package name */
    public final g7.l f6508g;

    /* renamed from: h, reason: collision with root package name */
    public final int f6509h;

    /* renamed from: i, reason: collision with root package name */
    public g7.l f6510i;

    /* renamed from: j, reason: collision with root package name */
    public g7.d f6511j;

    public r(la.k kVar, g7.l lVar) {
        super(p.f6505f, g7.m.f3866f);
        this.f6507f = kVar;
        this.f6508g = lVar;
        this.f6509h = ((Number) lVar.r(0, new g7.b(5))).intValue();
    }

    public final Object d(g7.d dVar, Object obj) throws IOException {
        int length;
        g7.l context = dVar.getContext();
        d0.h(context);
        g7.l lVar = this.f6510i;
        if (lVar != context) {
            if (lVar instanceof m) {
                String str = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((m) lVar).f6504g + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                q7.k.e(str, "<this>");
                List listX0 = ga.k.x0(str);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : listX0) {
                    if (!ga.k.t0((String) obj2)) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (true) {
                    length = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    int length2 = str2.length();
                    while (true) {
                        if (length >= length2) {
                            length = -1;
                            break;
                        }
                        if (!ib.c.E(str2.charAt(length))) {
                            break;
                        }
                        length++;
                    }
                    if (length == -1) {
                        length = str2.length();
                    }
                    arrayList2.add(Integer.valueOf(length));
                }
                Integer num = (Integer) d7.r.Y0(arrayList2);
                int iIntValue = num != null ? num.intValue() : 0;
                int length3 = str.length();
                listX0.size();
                int iT0 = d7.s.t0(listX0);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : listX0) {
                    int i2 = length + 1;
                    String strSubstring = null;
                    if (length < 0) {
                        d7.s.z0();
                        throw null;
                    }
                    String str3 = (String) obj3;
                    if ((length != 0 && length != iT0) || !ga.k.t0(str3)) {
                        q7.k.e(str3, "<this>");
                        if (iIntValue < 0) {
                            throw new IllegalArgumentException(a1.a.f(iIntValue, "Requested character count ", " is less than zero.").toString());
                        }
                        int length4 = str3.length();
                        if (iIntValue <= length4) {
                            length4 = iIntValue;
                        }
                        strSubstring = str3.substring(length4);
                        q7.k.d(strSubstring, "substring(...)");
                    }
                    if (strSubstring != null) {
                        arrayList3.add(strSubstring);
                    }
                    length = i2;
                }
                StringBuilder sb2 = new StringBuilder(length3);
                d7.r.T0(arrayList3, sb2, "\n", null, null, null, 124);
                throw new IllegalStateException(sb2.toString().toString());
            }
            if (((Number) context.r(0, new b0.r(6, this))).intValue() != this.f6509h) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f6508g + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.f6510i = context;
        }
        this.f6511j = dVar;
        p7.o oVar = t.f6513a;
        la.k kVar = this.f6507f;
        q7.k.c(kVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object objJ = oVar.j(kVar, obj, this);
        if (!q7.k.a(objJ, h7.a.f4212f)) {
            this.f6511j = null;
        }
        return objJ;
    }

    @Override // la.k
    public final Object emit(Object obj, g7.d dVar) {
        try {
            Object objD = d(dVar, obj);
            return objD == h7.a.f4212f ? objD : c7.r.f1986a;
        } catch (Throwable th) {
            this.f6510i = new m(dVar.getContext(), th);
            throw th;
        }
    }

    @Override // i7.a, i7.d
    public final i7.d getCallerFrame() {
        g7.d dVar = this.f6511j;
        if (dVar instanceof i7.d) {
            return (i7.d) dVar;
        }
        return null;
    }

    @Override // i7.c, g7.d
    public final g7.l getContext() {
        g7.l lVar = this.f6510i;
        return lVar == null ? g7.m.f3866f : lVar;
    }

    @Override // i7.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        Throwable thA = c7.m.a(obj);
        if (thA != null) {
            this.f6510i = new m(getContext(), thA);
        }
        g7.d dVar = this.f6511j;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return h7.a.f4212f;
    }
}
