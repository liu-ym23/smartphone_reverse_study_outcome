package d2;

import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.agentsafetycenter.R;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import h0.t1;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3181c;

    public /* synthetic */ x(int i) {
        this.f3181c = i;
    }

    /* JADX WARN: Type inference failed for: r1v24, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        i iVar;
        Object objA;
        int i = this.f3181c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                g gVar = (g) obj2;
                return ac.a.h(gVar.f3101f, c0.a(gVar.f3100c, c0.f3050b, (t0.b) obj));
            case 1:
                return Integer.valueOf(((n2.l) obj2).f8665a);
            case 2:
                n2.p pVar = (n2.p) obj2;
                return ac.a.h(Float.valueOf(pVar.f8669a), Float.valueOf(pVar.f8670b));
            case 3:
                t0.b bVar = (t0.b) obj;
                n2.q qVar = (n2.q) obj2;
                o2.n nVarA = o2.n.a(qVar.f8672a);
                b0 b0Var = c0.f3066s;
                return ac.a.h(c0.a(nVarA, b0Var, bVar), c0.a(o2.n.a(qVar.f8673b), b0Var, bVar));
            case 4:
                return Integer.valueOf(((g2.k) obj2).f4256c);
            case 5:
                l lVar = (l) obj2;
                return ac.a.h(lVar.f3137a, c0.a(lVar.f3138b, c0.f3057j, (t0.b) obj));
            case 6:
                return Float.valueOf(((n2.a) obj2).f8644a);
            case 7:
                t0.b bVar2 = (t0.b) obj;
                List list = (List) obj2;
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.add(c0.a((e) list.get(i3), c0.f3051c, bVar2));
                }
                return arrayList;
            case 8:
                k0 k0Var = (k0) obj2;
                return ac.a.h(Integer.valueOf((int) (k0Var.f3136a >> 32)), Integer.valueOf((int) (k0Var.f3136a & 4294967295L)));
            case 9:
                t0.b bVar3 = (t0.b) obj;
                d1.i0 i0Var = (d1.i0) obj2;
                return ac.a.h(c0.a(d1.p.a(i0Var.f2998a), c0.f3065r, bVar3), c0.a(c1.b.a(i0Var.f2999b), c0.f3067t, bVar3), Float.valueOf(i0Var.f3000c));
            case 10:
                o2.n nVar = (o2.n) obj2;
                if (nVar != null ? o2.n.b(nVar.f9129a, o2.n.f9128c) : false) {
                    return Boolean.FALSE;
                }
                Float fValueOf = Float.valueOf(o2.n.d(nVar.f9129a));
                long jC = o2.n.c(nVar.f9129a);
                o2.o oVar = new o2.o();
                oVar.f9130a = jC;
                VarHandle.storeStoreFence();
                return ac.a.h(fValueOf, oVar);
            case 11:
                c1.b bVar4 = (c1.b) obj2;
                return bVar4 != null ? c1.b.c(bVar4.f2165a, 9205357640488583168L) : false ? Boolean.FALSE : ac.a.h(Float.valueOf(Float.intBitsToFloat((int) (bVar4.f2165a >> 32))), Float.valueOf(Float.intBitsToFloat((int) (bVar4.f2165a & 4294967295L))));
            case 12:
                t0.b bVar5 = (t0.b) obj;
                ?? r12 = ((j2.b) obj2).f6545c;
                ArrayList arrayList2 = new ArrayList(r12.size());
                int size2 = r12.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    arrayList2.add(c0.a((j2.a) r12.get(i10), c0.f3069v, bVar5));
                }
                return arrayList2;
            case 13:
                return ((j2.a) obj2).f6543a.toLanguageTag();
            case 14:
                n2.i iVar2 = (n2.i) obj2;
                float f5 = iVar2.f8657a;
                n2.f fVar = new n2.f();
                fVar.f8654a = f5;
                VarHandle.storeStoreFence();
                int i11 = iVar2.f8658b;
                n2.h hVar = new n2.h();
                hVar.f8655a = i11;
                VarHandle.storeStoreFence();
                n2.g gVar2 = new n2.g();
                VarHandle.storeStoreFence();
                return ac.a.h(fVar, hVar, gVar2);
            case 15:
                t0.b bVar6 = (t0.b) obj;
                e eVar = (e) obj2;
                Object obj3 = eVar.f3077a;
                if (obj3 instanceof t) {
                    iVar = i.f3115c;
                } else if (obj3 instanceof e0) {
                    iVar = i.f3116f;
                } else if (obj3 instanceof n0) {
                    iVar = i.f3117g;
                } else if (obj3 instanceof m0) {
                    iVar = i.f3118h;
                } else if (obj3 instanceof l) {
                    iVar = i.i;
                } else if (obj3 instanceof k) {
                    iVar = i.f3119j;
                } else {
                    if (!(obj3 instanceof g0)) {
                        b8.z.c();
                        return null;
                    }
                    iVar = i.f3120k;
                }
                switch (iVar.ordinal()) {
                    case 0:
                        obj3.getClass();
                        objA = c0.a((t) obj3, c0.f3056h, bVar6);
                        break;
                    case 1:
                        obj3.getClass();
                        objA = c0.a((e0) obj3, c0.i, bVar6);
                        break;
                    case 2:
                        obj3.getClass();
                        objA = c0.a((n0) obj3, c0.f3052d, bVar6);
                        break;
                    case 3:
                        obj3.getClass();
                        objA = c0.a((m0) obj3, c0.f3053e, bVar6);
                        break;
                    case 4:
                        obj3.getClass();
                        objA = c0.a((l) obj3, c0.f3054f, bVar6);
                        break;
                    case 5:
                        obj3.getClass();
                        objA = c0.a((k) obj3, c0.f3055g, bVar6);
                        break;
                    case 6:
                        obj3.getClass();
                        objA = ((g0) obj3).f3104a;
                        break;
                    default:
                        g5.f.a();
                        return null;
                }
                return ac.a.h(iVar, objA, Integer.valueOf(eVar.f3078b), Integer.valueOf(eVar.f3079c), eVar.f3080d);
            case 16:
                k kVar = (k) obj2;
                return ac.a.h(kVar.f3132a, c0.a(kVar.f3133b, c0.f3057j, (t0.b) obj));
            case 17:
                return ((n0) obj2).f3148a;
            case 18:
                return ((m0) obj2).f3143a;
            case 19:
                t0.b bVar7 = (t0.b) obj;
                t tVar = (t) obj2;
                n2.k kVarA = n2.k.a(tVar.f3169a);
                int i12 = tVar.f3170b;
                n2.m mVar = new n2.m();
                mVar.f8666a = i12;
                VarHandle.storeStoreFence();
                Object objA2 = c0.a(o2.n.a(tVar.f3171c), c0.f3066s, bVar7);
                n2.q qVar2 = tVar.f3172d;
                n2.q qVar3 = n2.q.f8671c;
                Object objA3 = c0.a(qVar2, c0.f3060m, bVar7);
                Object objA4 = c0.a(tVar.f3173e, d0.f3074a, bVar7);
                n2.i iVar3 = tVar.f3174f;
                n2.i iVar4 = n2.i.f8656c;
                Object objA5 = c0.a(iVar3, c0.f3070w, bVar7);
                int i13 = tVar.f3175g;
                n2.e eVar2 = new n2.e();
                eVar2.f8650a = i13;
                VarHandle.storeStoreFence();
                Object objA6 = c0.a(eVar2, d0.f3075b, bVar7);
                int i14 = tVar.f3176h;
                n2.d dVar = new n2.d();
                dVar.f8648a = i14;
                VarHandle.storeStoreFence();
                return ac.a.h(kVarA, mVar, objA2, objA3, objA4, objA5, objA6, dVar, c0.a(tVar.i, d0.f3076c, bVar7));
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                t0.b bVar8 = (t0.b) obj;
                e0 e0Var = (e0) obj2;
                d1.p pVarA = d1.p.a(e0Var.f3081a.a());
                b0 b0Var2 = c0.f3065r;
                Object objA7 = c0.a(pVarA, b0Var2, bVar8);
                o2.n nVarA2 = o2.n.a(e0Var.f3082b);
                b0 b0Var3 = c0.f3066s;
                Object objA8 = c0.a(nVarA2, b0Var3, bVar8);
                g2.k kVar2 = e0Var.f3083c;
                g2.k kVar3 = g2.k.f4251f;
                Object objA9 = c0.a(kVar2, c0.f3061n, bVar8);
                g2.i iVar5 = e0Var.f3084d;
                g2.j jVar = e0Var.f3085e;
                String str = e0Var.f3087g;
                Object objA10 = c0.a(o2.n.a(e0Var.f3088h), b0Var3, bVar8);
                Object objA11 = c0.a(e0Var.i, c0.f3062o, bVar8);
                Object objA12 = c0.a(e0Var.f3089j, c0.f3059l, bVar8);
                j2.b bVar9 = e0Var.f3090k;
                j2.b bVar10 = j2.b.f6544g;
                Object objA13 = c0.a(bVar9, c0.f3068u, bVar8);
                Object objA14 = c0.a(d1.p.a(e0Var.f3091l), b0Var2, bVar8);
                Object objA15 = c0.a(e0Var.f3092m, c0.f3058k, bVar8);
                d1.i0 i0Var2 = e0Var.f3093n;
                d1.i0 i0Var3 = d1.i0.f2997d;
                return ac.a.h(objA7, objA8, objA9, iVar5, jVar, -1, str, objA10, objA11, objA12, objA13, objA14, objA15, c0.a(i0Var2, c0.f3064q, bVar8));
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                t0.b bVar11 = (t0.b) obj;
                j0 j0Var = (j0) obj2;
                e0 e0Var2 = j0Var.f3128a;
                p5.u uVar = c0.i;
                return ac.a.h(c0.a(e0Var2, uVar, bVar11), c0.a(j0Var.f3129b, uVar, bVar11), c0.a(j0Var.f3130c, uVar, bVar11), c0.a(j0Var.f3131d, uVar, bVar11));
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                Boolean boolValueOf = Boolean.valueOf(((v) obj2).f3179a);
                p5.u uVar2 = c0.f3049a;
                j jVar2 = new j();
                VarHandle.storeStoreFence();
                return ac.a.h(boolValueOf, jVar2);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                return Integer.valueOf(((n2.e) obj2).f8650a);
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                n2.s sVar = (n2.s) obj2;
                int i15 = sVar.f8677a;
                n2.r rVar = new n2.r();
                rVar.f8674a = i15;
                VarHandle.storeStoreFence();
                p5.u uVar3 = c0.f3049a;
                return ac.a.h(rVar, Boolean.valueOf(sVar.f8678b));
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                ((Integer) obj).intValue();
                ((e9.c) obj2).getClass();
                throw null;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                t0.b bVar12 = (t0.b) obj;
                h2.c cVar = (h2.c) obj2;
                Object objA16 = c0.a(cVar.f5283a, c0.f3049a, bVar12);
                long j10 = cVar.f5284b;
                k0 k0Var2 = new k0();
                k0Var2.f3136a = j10;
                VarHandle.storeStoreFence();
                return ac.a.h(objA16, c0.a(k0Var2, c0.f3063p, bVar12));
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                ((Integer) obj).getClass();
                i9.c cVar2 = (i9.c) obj2;
                cVar2.getClass();
                return cVar2.f5844a;
            case 28:
                k0.s sVar2 = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (sVar2.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    t1.b(t2.a.o(R.string.installed_apps_consent_title, sVar2), null, 0L, 0L, null, 0L, null, 0L, 0, false, 0, 0, null, sVar2, 0, 0, 131070);
                } else {
                    sVar2.S();
                }
                return vVar;
            default:
                k0.s sVar3 = (k0.s) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (sVar3.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    t1.b(t2.a.o(R.string.installed_apps_consent_message, sVar3), null, 0L, 0L, null, 0L, null, 0L, 0, false, 0, 0, null, sVar3, 0, 0, 131070);
                } else {
                    sVar3.S();
                }
                return vVar;
        }
    }
}
