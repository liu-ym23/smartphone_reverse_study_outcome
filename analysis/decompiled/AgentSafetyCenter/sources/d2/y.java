package d2;

import android.util.Log;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.agentsafetycenter.MainActivity;
import com.stepos.agentsafetycenter.mcp.service.AbilityService;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import g9.t0;
import io.modelcontextprotocol.spec.McpSchema;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import r.o0;
import r.q0;
import s.h1;
import s8.g1;
import s8.j3;
import s8.y2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3182c;

    public /* synthetic */ y(int i) {
        this.f3182c = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xb.l
    public final Object invoke(Object obj) throws Exception {
        e eVar;
        int i;
        int i3;
        n2.s sVar;
        ArrayList arrayList;
        r.v vVarQ;
        int i10 = 2;
        lValueOf = null;
        Long lValueOf = null;
        k0Var = null;
        k0 k0Var = null;
        int i11 = 0;
        switch (this.f3182c) {
            case 0:
                obj.getClass();
                String str = (String) obj;
                p5.m mVar = j2.c.f6547a;
                Locale localeForLanguageTag = Locale.forLanguageTag(str);
                if (yb.k.a(localeForLanguageTag.toLanguageTag(), "und")) {
                    Log.e("Locale", "The language tag " + str + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
                }
                return new j2.a(localeForLanguageTag);
            case 1:
                obj.getClass();
                List list = (List) obj;
                Object obj2 = list.get(0);
                n2.f fVar = obj2 != null ? (n2.f) obj2 : null;
                fVar.getClass();
                float f5 = fVar.f8654a;
                Object obj3 = list.get(1);
                n2.h hVar = obj3 != null ? (n2.h) obj3 : null;
                hVar.getClass();
                int i12 = hVar.f8655a;
                Object obj4 = list.get(2);
                (obj4 != null ? (n2.g) obj4 : null).getClass();
                return new n2.i(f5, i12);
            case 2:
                obj.getClass();
                List list2 = (List) obj;
                Object obj5 = list2.get(0);
                i iVar = obj5 != null ? (i) obj5 : null;
                iVar.getClass();
                Object obj6 = list2.get(2);
                Integer num = obj6 != null ? (Integer) obj6 : null;
                num.getClass();
                int iIntValue = num.intValue();
                Object obj7 = list2.get(3);
                Integer num2 = obj7 != null ? (Integer) obj7 : null;
                num2.getClass();
                int iIntValue2 = num2.intValue();
                Object obj8 = list2.get(4);
                String str2 = obj8 != null ? (String) obj8 : null;
                str2.getClass();
                switch (iVar.ordinal()) {
                    case 0:
                        Object obj9 = list2.get(1);
                        t tVar = (yb.k.a(obj9, Boolean.FALSE) || obj9 == null) ? null : (t) ((xb.l) c0.f3056h.f9808g).invoke(obj9);
                        tVar.getClass();
                        eVar = new e(iIntValue, iIntValue2, tVar, str2);
                        break;
                    case 1:
                        Object obj10 = list2.get(1);
                        e0 e0Var = (yb.k.a(obj10, Boolean.FALSE) || obj10 == null) ? null : (e0) ((xb.l) c0.i.f9808g).invoke(obj10);
                        e0Var.getClass();
                        eVar = new e(iIntValue, iIntValue2, e0Var, str2);
                        break;
                    case 2:
                        Object obj11 = list2.get(1);
                        n0 n0Var = (yb.k.a(obj11, Boolean.FALSE) || obj11 == null) ? null : (n0) ((xb.l) c0.f3052d.f9808g).invoke(obj11);
                        n0Var.getClass();
                        eVar = new e(iIntValue, iIntValue2, n0Var, str2);
                        break;
                    case 3:
                        Object obj12 = list2.get(1);
                        m0 m0Var = (yb.k.a(obj12, Boolean.FALSE) || obj12 == null) ? null : (m0) ((xb.l) c0.f3053e.f9808g).invoke(obj12);
                        m0Var.getClass();
                        eVar = new e(iIntValue, iIntValue2, m0Var, str2);
                        break;
                    case 4:
                        Object obj13 = list2.get(1);
                        l lVar = (yb.k.a(obj13, Boolean.FALSE) || obj13 == null) ? null : (l) ((xb.l) c0.f3054f.f9808g).invoke(obj13);
                        lVar.getClass();
                        eVar = new e(iIntValue, iIntValue2, lVar, str2);
                        break;
                    case 5:
                        Object obj14 = list2.get(1);
                        k kVar = (yb.k.a(obj14, Boolean.FALSE) || obj14 == null) ? null : (k) ((xb.l) c0.f3055g.f9808g).invoke(obj14);
                        kVar.getClass();
                        eVar = new e(iIntValue, iIntValue2, kVar, str2);
                        break;
                    case 6:
                        Object obj15 = list2.get(1);
                        String str3 = obj15 != null ? (String) obj15 : null;
                        str3.getClass();
                        g0 g0Var = new g0();
                        g0Var.f3104a = str3;
                        VarHandle.storeStoreFence();
                        eVar = new e(iIntValue, iIntValue2, g0Var, str2);
                        break;
                    default:
                        g5.f.a();
                        return null;
                }
                return eVar;
            case 3:
                String str4 = obj != null ? (String) obj : null;
                str4.getClass();
                n0 n0Var2 = new n0();
                n0Var2.f3148a = str4;
                VarHandle.storeStoreFence();
                return n0Var2;
            case 4:
                String str5 = obj != null ? (String) obj : null;
                str5.getClass();
                m0 m0Var2 = new m0();
                m0Var2.f3143a = str5;
                VarHandle.storeStoreFence();
                return m0Var2;
            case 5:
                obj.getClass();
                List list3 = (List) obj;
                Object obj16 = list3.get(0);
                String str6 = obj16 != null ? (String) obj16 : null;
                str6.getClass();
                Object obj17 = list3.get(1);
                j0 j0Var = (yb.k.a(obj17, Boolean.FALSE) || obj17 == null) ? null : (j0) ((xb.l) c0.f3057j.f9808g).invoke(obj17);
                k kVar2 = new k();
                kVar2.f3132a = str6;
                kVar2.f3133b = j0Var;
                VarHandle.storeStoreFence();
                return kVar2;
            case 6:
                obj.getClass();
                List list4 = (List) obj;
                Object obj18 = list4.get(0);
                n2.k kVar3 = obj18 != null ? (n2.k) obj18 : null;
                kVar3.getClass();
                int i13 = kVar3.f8662a;
                Object obj19 = list4.get(1);
                n2.m mVar2 = obj19 != null ? (n2.m) obj19 : null;
                mVar2.getClass();
                int i14 = mVar2.f8666a;
                Object obj20 = list4.get(2);
                o2.o[] oVarArr = o2.n.f9127b;
                b0 b0Var = c0.f3066s;
                Boolean bool = Boolean.FALSE;
                o2.n nVar = ((yb.k.a(obj20, bool) && b0Var == null) || obj20 == null) ? null : (o2.n) b0Var.f3044f.invoke(obj20);
                nVar.getClass();
                long j10 = nVar.f9129a;
                Object obj21 = list4.get(3);
                n2.q qVar = n2.q.f8671c;
                n2.q qVar2 = (yb.k.a(obj21, bool) || obj21 == null) ? null : (n2.q) ((xb.l) c0.f3060m.f9808g).invoke(obj21);
                Object obj22 = list4.get(4);
                v vVar = (yb.k.a(obj22, bool) || obj22 == null) ? null : (v) ((xb.l) d0.f3074a.f9808g).invoke(obj22);
                Object obj23 = list4.get(5);
                n2.i iVar2 = n2.i.f8656c;
                n2.i iVar3 = (yb.k.a(obj23, bool) || obj23 == null) ? null : (n2.i) ((xb.l) c0.f3070w.f9808g).invoke(obj23);
                Object obj24 = list4.get(6);
                n2.e eVar2 = (yb.k.a(obj24, bool) || obj24 == null) ? null : (n2.e) ((xb.l) d0.f3075b.f9808g).invoke(obj24);
                eVar2.getClass();
                int i15 = eVar2.f8650a;
                Object obj25 = list4.get(7);
                n2.d dVar = obj25 != null ? (n2.d) obj25 : null;
                dVar.getClass();
                int i16 = dVar.f8648a;
                Object obj26 = list4.get(8);
                p5.u uVar = d0.f3076c;
                if (yb.k.a(obj26, bool) || obj26 == null) {
                    i = i16;
                    i3 = i15;
                    sVar = null;
                } else {
                    i = i16;
                    i3 = i15;
                    sVar = (n2.s) ((xb.l) uVar.f9808g).invoke(obj26);
                }
                return new t(i13, i14, j10, qVar2, vVar, iVar3, i3, i, sVar);
            case 7:
                obj.getClass();
                List list5 = (List) obj;
                Object obj27 = list5.get(0);
                int i17 = d1.p.f3025h;
                b0 b0Var2 = c0.f3065r;
                Boolean bool2 = Boolean.FALSE;
                d1.p pVar = ((yb.k.a(obj27, bool2) && b0Var2 == null) || obj27 == null) ? null : (d1.p) b0Var2.f3044f.invoke(obj27);
                pVar.getClass();
                long j11 = pVar.f3026a;
                Object obj28 = list5.get(1);
                o2.o[] oVarArr2 = o2.n.f9127b;
                b0 b0Var3 = c0.f3066s;
                o2.n nVar2 = ((yb.k.a(obj28, bool2) && b0Var3 == null) || obj28 == null) ? null : (o2.n) b0Var3.f3044f.invoke(obj28);
                nVar2.getClass();
                long j12 = nVar2.f9129a;
                Object obj29 = list5.get(2);
                g2.k kVar4 = g2.k.f4251f;
                g2.k kVar5 = (yb.k.a(obj29, bool2) || obj29 == null) ? null : (g2.k) ((xb.l) c0.f3061n.f9808g).invoke(obj29);
                Object obj30 = list5.get(3);
                g2.i iVar4 = obj30 != null ? (g2.i) obj30 : null;
                Object obj31 = list5.get(4);
                g2.j jVar = obj31 != null ? (g2.j) obj31 : null;
                Object obj32 = list5.get(6);
                String str7 = obj32 != null ? (String) obj32 : null;
                Object obj33 = list5.get(7);
                o2.n nVar3 = ((yb.k.a(obj33, bool2) && b0Var3 == null) || obj33 == null) ? null : (o2.n) b0Var3.f3044f.invoke(obj33);
                nVar3.getClass();
                long j13 = nVar3.f9129a;
                Object obj34 = list5.get(8);
                n2.a aVar = (yb.k.a(obj34, bool2) || obj34 == null) ? null : (n2.a) ((xb.l) c0.f3062o.f9808g).invoke(obj34);
                Object obj35 = list5.get(9);
                n2.p pVar2 = (yb.k.a(obj35, bool2) || obj35 == null) ? null : (n2.p) ((xb.l) c0.f3059l.f9808g).invoke(obj35);
                Object obj36 = list5.get(10);
                j2.b bVar = j2.b.f6544g;
                j2.b bVar2 = (yb.k.a(obj36, bool2) || obj36 == null) ? null : (j2.b) ((xb.l) c0.f3068u.f9808g).invoke(obj36);
                Object obj37 = list5.get(11);
                d1.p pVar3 = ((yb.k.a(obj37, bool2) && b0Var2 == null) || obj37 == null) ? null : (d1.p) b0Var2.f3044f.invoke(obj37);
                pVar3.getClass();
                long j14 = pVar3.f3026a;
                Object obj38 = list5.get(12);
                n2.l lVar2 = (yb.k.a(obj38, bool2) || obj38 == null) ? null : (n2.l) ((xb.l) c0.f3058k.f9808g).invoke(obj38);
                Object obj39 = list5.get(13);
                d1.i0 i0Var = d1.i0.f2997d;
                return new e0(j11, j12, kVar5, iVar4, jVar, (g2.q) null, str7, j13, aVar, pVar2, bVar2, j14, lVar2, (yb.k.a(obj39, bool2) || obj39 == null) ? null : (d1.i0) ((xb.l) c0.f3064q.f9808g).invoke(obj39), 49184);
            case 8:
                obj.getClass();
                List list6 = (List) obj;
                Object obj40 = list6.get(0);
                Boolean bool3 = obj40 != null ? (Boolean) obj40 : null;
                bool3.getClass();
                boolean zBooleanValue = bool3.booleanValue();
                Object obj41 = list6.get(1);
                (obj41 != null ? (j) obj41 : null).getClass();
                v vVar2 = new v();
                vVar2.f3179a = zBooleanValue;
                return vVar2;
            case 9:
                obj.getClass();
                int iIntValue3 = ((Integer) obj).intValue();
                n2.e eVar3 = new n2.e();
                eVar3.f8650a = iIntValue3;
                VarHandle.storeStoreFence();
                return eVar3;
            case 10:
                obj.getClass();
                List list7 = (List) obj;
                Object obj42 = list7.get(0);
                n2.r rVar = obj42 != null ? (n2.r) obj42 : null;
                rVar.getClass();
                int i18 = rVar.f8674a;
                Object obj43 = list7.get(1);
                Boolean bool4 = obj43 != null ? (Boolean) obj43 : null;
                bool4.getClass();
                return new n2.s(i18, bool4.booleanValue());
            case 11:
                b9.b bVar3 = (b9.b) obj;
                int i19 = AbilityService.f2507g;
                bVar3.getClass();
                List list8 = bVar3.f2046a;
                if (list8.isEmpty()) {
                    arrayList = new ArrayList();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj44 : list8) {
                        if (obj44 instanceof String) {
                            arrayList2.add(new McpSchema.TextContent((String) obj44));
                        }
                    }
                    arrayList = arrayList2;
                }
                return new McpSchema.CallToolResult(arrayList, Boolean.FALSE, null, bVar3.f2047b);
            case 12:
                t0 t0Var = (t0) obj;
                t0Var.getClass();
                return Boolean.valueOf(t0Var.f4619e != null);
            case 13:
                return Boolean.valueOf(obj == null);
            case 14:
                obj.getClass();
                List list9 = (List) obj;
                Object obj45 = list9.get(0);
                p5.u uVar2 = c0.f3049a;
                Boolean bool5 = Boolean.FALSE;
                g gVar = (yb.k.a(obj45, bool5) || obj45 == null) ? null : (g) ((xb.l) uVar2.f9808g).invoke(obj45);
                gVar.getClass();
                Object obj46 = list9.get(1);
                int i20 = k0.f3135c;
                p5.u uVar3 = c0.f3063p;
                if (!yb.k.a(obj46, bool5) && obj46 != null) {
                    k0Var = (k0) ((xb.l) uVar3.f9808g).invoke(obj46);
                }
                k0Var.getClass();
                return new h2.c(gVar, k0Var.f3136a);
            case 15:
                return ((i9.c) obj).f5844a;
            case 16:
                r.n nVar4 = (r.n) obj;
                int i21 = MainActivity.f2491h;
                nVar4.getClass();
                k8.d0 d0Var = (k8.d0) nVar4.b();
                k8.d0 d0Var2 = (k8.d0) nVar4.c();
                d0Var.getClass();
                d0Var2.getClass();
                Object[] objArr = ac.a.J(d0Var2) > ac.a.J(d0Var);
                boolean z10 = ac.a.J(d0Var2) < ac.a.J(d0Var);
                if (!(d0Var2 instanceof k8.x) && (d0Var instanceof k8.x)) {
                    vVarQ = h5.t.Q(ac.a.V(), r.c0.b(s.d.n(220, 6, null), 2));
                } else if (z10) {
                    h1 h1VarN = s.d.n(320, 6, null);
                    y yVar = new y(21);
                    n6.a aVar2 = r.c0.f10254a;
                    LinkedHashMap linkedHashMap = null;
                    int i22 = 61;
                    r.j0 j0Var2 = null;
                    id.c cVar = null;
                    id.k kVar6 = null;
                    vVarQ = h5.t.Q(new r.h0(new q0(j0Var2, new o0(new r.b0(yVar, i11), h1VarN), cVar, kVar6, linkedHashMap, i22)).a(r.c0.a(s.d.n(280, 6, null), 2)), new r.i0(new q0(j0Var2, new o0(new r.b0(new y(20), i10), s.d.n(300, 6, null)), cVar, kVar6, linkedHashMap, i22)).a(r.c0.b(s.d.n(220, 6, null), 2)));
                } else {
                    vVarQ = objArr != false ? h5.t.Q(ac.a.V(), new r.i0(new q0((r.j0) null, new o0(new r.b0(new y(19), i10), s.d.n(300, 6, null)), (id.c) null, (id.k) null, (LinkedHashMap) null, 61)).a(r.c0.b(s.d.n(220, 6, null), 2))) : h5.t.Q(r.c0.a(s.d.n(180, 6, null), 2), r.c0.b(s.d.n(180, 6, null), 2));
                }
                vVarQ.f10347d = h5.t.e(2);
                return vVarQ;
            case 17:
                nb.e eVar4 = (nb.e) obj;
                if (eVar4 instanceof kc.p) {
                    return (kc.p) eVar4;
                }
                return null;
            case 18:
                return kb.l.r0(((j3) obj).f11702e);
            case 19:
                return Integer.valueOf(-((Integer) obj).intValue());
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                Integer num3 = (Integer) obj;
                num3.intValue();
                return num3;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return Integer.valueOf(-((Integer) obj).intValue());
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                Byte b10 = (Byte) obj;
                b10.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b10}, 1));
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                x4.a aVar3 = (x4.a) obj;
                aVar3.getClass();
                x4.c cVarK = aVar3.K("SELECT MIN(day_start_millis) FROM dashboard_days");
                try {
                    if (cVarK.G() && !cVarK.isNull(0)) {
                        lValueOf = Long.valueOf(cVarK.getLong(0));
                    }
                    return lValueOf;
                } finally {
                }
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                x4.a aVar4 = (x4.a) obj;
                aVar4.getClass();
                x4.c cVarK2 = aVar4.K("SELECT day_start_millis FROM dashboard_days ORDER BY day_start_millis ASC");
                try {
                    ArrayList arrayList3 = new ArrayList();
                    while (cVarK2.G()) {
                        arrayList3.add(Long.valueOf(cVarK2.getLong(0)));
                    }
                    return arrayList3;
                } finally {
                }
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                x4.a aVar5 = (x4.a) obj;
                aVar5.getClass();
                x4.c cVarK3 = aVar5.K("SELECT row_key FROM intercept_reads");
                try {
                    ArrayList arrayList4 = new ArrayList();
                    while (cVarK3.G()) {
                        arrayList4.add(cVarK3.z(0));
                    }
                    return arrayList4;
                } finally {
                }
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                String str8 = (String) obj;
                str8.getClass();
                return "• ".concat(str8);
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                y2 y2Var = (y2) obj;
                y2Var.getClass();
                return y2Var.f12124a;
            case 28:
                String str9 = (String) obj;
                str9.getClass();
                return g1.w(str9);
            default:
                String str10 = (String) obj;
                str10.getClass();
                return g1.w(str10);
        }
    }
}
