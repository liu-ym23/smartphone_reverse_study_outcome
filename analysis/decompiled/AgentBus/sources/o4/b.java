package o4;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7279f;

    public /* synthetic */ b(int i2) {
        this.f7279f = i2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        s1.a0 a0Var = null;
        iVar = null;
        s1.i iVar = null;
        jVar = null;
        s1.j jVar = null;
        j0Var = null;
        s1.j0 j0Var = null;
        k0Var = null;
        s1.k0 k0Var = null;
        a0Var = null;
        s1.a0 a0Var2 = null;
        pVar = null;
        s1.p pVar = null;
        f0Var = null;
        s1.f0 f0Var = null;
        a0Var = null;
        boolean z4 = false;
        z4 = false;
        switch (this.f7279f) {
            case 0:
                Byte b10 = (Byte) obj;
                b10.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b10}, 1));
            case 1:
                q7.k.e((String) obj, "it");
                return new ConcurrentHashMap();
            case 2:
                q7.k.e((String) obj, "it");
                return new LinkedHashMap();
            case 3:
                q7.k.e((String) obj, "it");
                return new LinkedHashMap();
            case 4:
                q7.k.e((String) obj, "it");
                return new LinkedHashMap();
            case 5:
                Byte b11 = (Byte) obj;
                b11.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b11}, 1));
            case 6:
                Byte b12 = (Byte) obj;
                b12.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b12}, 1));
            case 7:
                q7.k.e((d5.e) obj, "it");
                return Boolean.TRUE;
            case 8:
                String str = (String) obj;
                q7.k.e(str, "it");
                return Boolean.valueOf(str.equals("linux"));
            case 9:
                String str2 = (String) obj;
                q7.k.e(str2, "it");
                if (str2.length() > 0 && !str2.equals("android")) {
                    z4 = true;
                }
                return Boolean.valueOf(z4);
            case 10:
                q7.k.e((String) obj, "it");
                return ConcurrentHashMap.newKeySet();
            case 11:
                s1.m mVar = (s1.m) obj;
                StringBuilder sb2 = new StringBuilder("[");
                sb2.append(mVar.f9284b);
                sb2.append(", ");
                return m.x.m(sb2, mVar.f9285c, ')');
            case 12:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list = (List) obj;
                Object obj2 = list.get(0);
                p7.k kVar = (p7.k) s1.y.f9319h.f8787g;
                Boolean bool = Boolean.FALSE;
                s1.a0 a0Var3 = (q7.k.a(obj2, bool) || obj2 == null) ? null : (s1.a0) kVar.invoke(obj2);
                Object obj3 = list.get(1);
                s1.a0 a0Var4 = (q7.k.a(obj3, bool) || obj3 == null) ? null : (s1.a0) kVar.invoke(obj3);
                Object obj4 = list.get(2);
                s1.a0 a0Var5 = (q7.k.a(obj4, bool) || obj4 == null) ? null : (s1.a0) kVar.invoke(obj4);
                Object obj5 = list.get(3);
                if (!q7.k.a(obj5, bool) && obj5 != null) {
                    a0Var = (s1.a0) kVar.invoke(obj5);
                }
                return new s1.f0(a0Var3, a0Var4, a0Var5, a0Var);
            case 13:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list2 = (List) obj;
                Object obj6 = list2.get(1);
                List list3 = (q7.k.a(obj6, Boolean.FALSE) || obj6 == null) ? null : (List) ((p7.k) s1.y.f9312a.f8787g).invoke(obj6);
                Object obj7 = list2.get(0);
                String str3 = obj7 != null ? (String) obj7 : null;
                q7.k.b(str3);
                return new s1.e(list3, str3);
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.Int");
                return new c2.l(((Integer) obj).intValue());
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
                List list4 = (List) obj;
                return new c2.p(((Number) list4.get(0)).floatValue(), ((Number) list4.get(1)).floatValue());
            case 16:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list5 = (List) obj;
                Object obj8 = list5.get(0);
                d2.o[] oVarArr = d2.n.f2797b;
                p7.k kVar2 = s1.y.f9328q.f9311g;
                Boolean bool2 = Boolean.FALSE;
                q7.k.a(obj8, bool2);
                d2.n nVar = obj8 != null ? (d2.n) kVar2.invoke(obj8) : null;
                q7.k.b(nVar);
                long j2 = nVar.f2799a;
                Object obj9 = list5.get(1);
                q7.k.a(obj9, bool2);
                d2.n nVar2 = obj9 != null ? (d2.n) kVar2.invoke(obj9) : null;
                q7.k.b(nVar2);
                return new c2.q(j2, nVar2.f2799a);
            case 17:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.Int");
                return new v1.k(((Integer) obj).intValue());
            case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.Float");
                return new c2.a(((Float) obj).floatValue());
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list6 = (List) obj;
                Object obj10 = list6.get(0);
                Integer num = obj10 != null ? (Integer) obj10 : null;
                q7.k.b(num);
                int iIntValue = num.intValue();
                Object obj11 = list6.get(1);
                Integer num2 = obj11 != null ? (Integer) obj11 : null;
                q7.k.b(num2);
                return new s1.g0(s1.z.b(iIntValue, num2.intValue()));
            case 20:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list7 = (List) obj;
                Object obj12 = list7.get(0);
                int i2 = u0.m.f9917g;
                Boolean bool3 = Boolean.FALSE;
                q7.k.a(obj12, bool3);
                u0.m mVar2 = obj12 != null ? q7.k.a(obj12, Boolean.FALSE) ? new u0.m(u0.m.f9916f) : new u0.m(u0.z.b(((Integer) obj12).intValue())) : null;
                q7.k.b(mVar2);
                long j4 = mVar2.f9918a;
                Object obj13 = list7.get(1);
                s1.x xVar = s1.y.f9329r;
                q7.k.a(obj13, bool3);
                t0.b bVar = obj13 != null ? (t0.b) xVar.f9311g.invoke(obj13) : null;
                q7.k.b(bVar);
                long j10 = bVar.f9654a;
                Object obj14 = list7.get(2);
                Float f10 = obj14 != null ? (Float) obj14 : null;
                q7.k.b(f10);
                return new u0.b0(j4, j10, f10.floatValue());
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                if (q7.k.a(obj, Boolean.FALSE)) {
                    return new d2.n(d2.n.f2798c);
                }
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list8 = (List) obj;
                Object obj15 = list8.get(0);
                Float f11 = obj15 != null ? (Float) obj15 : null;
                q7.k.b(f11);
                float fFloatValue = f11.floatValue();
                Object obj16 = list8.get(1);
                d2.o oVar = obj16 != null ? (d2.o) obj16 : null;
                q7.k.b(oVar);
                return new d2.n(s7.a.Q(fFloatValue, oVar.f2800a));
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list9 = (List) obj;
                Object obj17 = list9.get(0);
                String str4 = obj17 != null ? (String) obj17 : null;
                q7.k.b(str4);
                Object obj18 = list9.get(1);
                q6.b bVar2 = s1.y.f9320i;
                if (!q7.k.a(obj18, Boolean.FALSE) && obj18 != null) {
                    f0Var = (s1.f0) ((p7.k) bVar2.f8787g).invoke(obj18);
                }
                return new s1.j(str4, f0Var);
            case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                if (q7.k.a(obj, Boolean.FALSE)) {
                    return new t0.b(9205357640488583168L);
                }
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list10 = (List) obj;
                Object obj19 = list10.get(0);
                Float f12 = obj19 != null ? (Float) obj19 : null;
                q7.k.b(f12);
                float fFloatValue2 = f12.floatValue();
                Object obj20 = list10.get(1);
                q7.k.b(obj20 != null ? (Float) obj20 : null);
                return new t0.b((Float.floatToRawIntBits(fFloatValue2) << 32) | (Float.floatToRawIntBits(r9.floatValue()) & 4294967295L));
            case 24:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list11 = (List) obj;
                ArrayList arrayList = new ArrayList(list11.size());
                int size = list11.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj21 = list11.get(i10);
                    y1.a aVar = (q7.k.a(obj21, Boolean.FALSE) || obj21 == null) ? null : (y1.a) ((p7.k) s1.y.f9331t.f8787g).invoke(obj21);
                    q7.k.b(aVar);
                    arrayList.add(aVar);
                }
                return new y1.b(arrayList);
            case 25:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list12 = (List) obj;
                ArrayList arrayList2 = new ArrayList(list12.size());
                int size2 = list12.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    Object obj22 = list12.get(i11);
                    s1.c cVar = (q7.k.a(obj22, Boolean.FALSE) || obj22 == null) ? null : (s1.c) ((p7.k) s1.y.f9313b.f8787g).invoke(obj22);
                    q7.k.b(cVar);
                    arrayList2.add(cVar);
                }
                return arrayList2;
            case 26:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.String");
                String str5 = (String) obj;
                y1.c.f11545a.getClass();
                Locale localeForLanguageTag = Locale.forLanguageTag(str5);
                if (q7.k.a(localeForLanguageTag.toLanguageTag(), "und")) {
                    Log.e("Locale", "The language tag " + str5 + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
                }
                return new y1.a(localeForLanguageTag);
            case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list13 = (List) obj;
                Object obj23 = list13.get(0);
                c2.f fVar = obj23 != null ? (c2.f) obj23 : null;
                q7.k.b(fVar);
                float f13 = fVar.f1866a;
                Object obj24 = list13.get(1);
                c2.h hVar = obj24 != null ? (c2.h) obj24 : null;
                q7.k.b(hVar);
                int i12 = hVar.f1867a;
                Object obj25 = list13.get(2);
                q7.k.b(obj25 != null ? (c2.g) obj25 : null);
                return new c2.i(i12, f13);
            case 28:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list14 = (List) obj;
                Object obj26 = list14.get(0);
                s1.g gVar = obj26 != null ? (s1.g) obj26 : null;
                q7.k.b(gVar);
                Object obj27 = list14.get(2);
                Integer num3 = obj27 != null ? (Integer) obj27 : null;
                q7.k.b(num3);
                int iIntValue2 = num3.intValue();
                Object obj28 = list14.get(3);
                Integer num4 = obj28 != null ? (Integer) obj28 : null;
                q7.k.b(num4);
                int iIntValue3 = num4.intValue();
                Object obj29 = list14.get(4);
                String str6 = obj29 != null ? (String) obj29 : null;
                q7.k.b(str6);
                switch (gVar.ordinal()) {
                    case 0:
                        Object obj30 = list14.get(1);
                        q6.b bVar3 = s1.y.f9318g;
                        if (!q7.k.a(obj30, Boolean.FALSE) && obj30 != null) {
                            pVar = (s1.p) ((p7.k) bVar3.f8787g).invoke(obj30);
                        }
                        q7.k.b(pVar);
                        return new s1.c(pVar, iIntValue2, iIntValue3, str6);
                    case 1:
                        Object obj31 = list14.get(1);
                        q6.b bVar4 = s1.y.f9319h;
                        if (!q7.k.a(obj31, Boolean.FALSE) && obj31 != null) {
                            a0Var2 = (s1.a0) ((p7.k) bVar4.f8787g).invoke(obj31);
                        }
                        q7.k.b(a0Var2);
                        return new s1.c(a0Var2, iIntValue2, iIntValue3, str6);
                    case 2:
                        Object obj32 = list14.get(1);
                        q6.b bVar5 = s1.y.f9314c;
                        if (!q7.k.a(obj32, Boolean.FALSE) && obj32 != null) {
                            k0Var = (s1.k0) ((p7.k) bVar5.f8787g).invoke(obj32);
                        }
                        q7.k.b(k0Var);
                        return new s1.c(k0Var, iIntValue2, iIntValue3, str6);
                    case 3:
                        Object obj33 = list14.get(1);
                        q6.b bVar6 = s1.y.f9315d;
                        if (!q7.k.a(obj33, Boolean.FALSE) && obj33 != null) {
                            j0Var = (s1.j0) ((p7.k) bVar6.f8787g).invoke(obj33);
                        }
                        q7.k.b(j0Var);
                        return new s1.c(j0Var, iIntValue2, iIntValue3, str6);
                    case 4:
                        Object obj34 = list14.get(1);
                        q6.b bVar7 = s1.y.f9316e;
                        if (!q7.k.a(obj34, Boolean.FALSE) && obj34 != null) {
                            jVar = (s1.j) ((p7.k) bVar7.f8787g).invoke(obj34);
                        }
                        q7.k.b(jVar);
                        return new s1.c(jVar, iIntValue2, iIntValue3, str6);
                    case 5:
                        Object obj35 = list14.get(1);
                        q6.b bVar8 = s1.y.f9317f;
                        if (!q7.k.a(obj35, Boolean.FALSE) && obj35 != null) {
                            iVar = (s1.i) ((p7.k) bVar8.f8787g).invoke(obj35);
                        }
                        q7.k.b(iVar);
                        return new s1.c(iVar, iIntValue2, iIntValue3, str6);
                    case 6:
                        Object obj36 = list14.get(1);
                        String str7 = obj36 != null ? (String) obj36 : null;
                        q7.k.b(str7);
                        return new s1.c(new s1.c0(str7), iIntValue2, iIntValue3, str6);
                    default:
                        throw new a4.u();
                }
            default:
                String str8 = obj != null ? (String) obj : null;
                q7.k.b(str8);
                return new s1.k0(str8);
        }
    }
}
