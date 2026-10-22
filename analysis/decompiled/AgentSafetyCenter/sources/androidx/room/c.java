package androidx.room;

import android.content.UriMatcher;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.agentsafetycenter.ledger.LedgerProvider;
import com.stepos.agentsafetycenter.permission.AgentPermissionProvider;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import g9.f1;
import g9.k1;
import g9.l1;
import g9.v0;
import g9.w0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import k0.s2;
import nc.t0;
import s8.l2;
import s8.x2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1512c;

    public /* synthetic */ c(int i) {
        this.f1512c = i;
    }

    @Override // xb.a
    public final Object invoke() {
        int i = this.f1512c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                return vVar;
            case 1:
                return Boolean.TRUE;
            case 2:
                int i3 = e9.g0.f3654b;
                return vVar;
            case 3:
                throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present");
            case 4:
                return Long.valueOf(System.currentTimeMillis());
            case 5:
                UriMatcher uriMatcher = AgentPermissionProvider.f2512f;
                l8.b bVar = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case 6:
                l8.b bVar2 = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case 7:
                List list = g9.t.f4612c;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    kb.q.p0(((l1) it.next()).f4524b, arrayList);
                }
                int iL = kb.x.L(kb.m.m0(arrayList, 10));
                LinkedHashMap linkedHashMap = new LinkedHashMap(iL >= 16 ? iL : 16);
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    linkedHashMap.put(((w0) obj).f4638b, obj);
                }
                return linkedHashMap;
            case 8:
                lb.f fVar = new lb.f();
                for (l1 l1Var : g9.t.f4612c) {
                    Iterator it2 = l1Var.f4524b.iterator();
                    while (it2.hasNext()) {
                        fVar.put(((w0) it2.next()).f4638b, Integer.valueOf(l1Var.f4523a));
                    }
                }
                return fVar.b();
            case 9:
                l8.b bVar3 = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case 10:
                int i11 = 0;
                List list2 = g9.t.f4612c;
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    kb.q.p0(((l1) it3.next()).f4524b, arrayList2);
                }
                int iL2 = kb.x.L(kb.m.m0(arrayList2, 10));
                if (iL2 < 16) {
                    iL2 = 16;
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(iL2);
                int size2 = arrayList2.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj2 = arrayList2.get(i12);
                    i12++;
                    w0 w0Var = (w0) obj2;
                    linkedHashMap2.put(w0Var.f4637a, w0Var.f4644h);
                }
                f1 f1Var = new f1();
                List list3 = g9.t.f4612c;
                ArrayList arrayList3 = new ArrayList();
                Iterator it4 = list3.iterator();
                while (it4.hasNext()) {
                    kb.q.p0(((l1) it4.next()).f4524b, arrayList3);
                }
                int iL3 = kb.x.L(kb.m.m0(arrayList3, 10));
                if (iL3 < 16) {
                    iL3 = 16;
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(iL3);
                int size3 = arrayList3.size();
                while (i11 < size3) {
                    Object obj3 = arrayList3.get(i11);
                    i11++;
                    linkedHashMap3.put(((w0) obj3).f4637a, obj3);
                }
                f1Var.f4449a = linkedHashMap3;
                f1Var.f4450b = new LinkedHashMap(linkedHashMap2);
                Set setKeySet = linkedHashMap2.keySet();
                int iL4 = kb.x.L(kb.m.m0(setKeySet, 10));
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(iL4 >= 16 ? iL4 : 16);
                for (Object obj4 : setKeySet) {
                    linkedHashMap4.put(obj4, Long.valueOf(System.currentTimeMillis()));
                }
                f1Var.f4451c = new LinkedHashMap(linkedHashMap4);
                mc.a aVar = mc.a.f8550c;
                nc.j0 j0Var = new nc.j0(1, 65, mc.a.f8550c);
                f1Var.f4452d = j0Var;
                t0 t0VarA = nc.k0.a(f1Var.b());
                f1Var.f4453e = t0VarA;
                nc.e0 e0Var = new nc.e0();
                e0Var.f8839c = j0Var;
                VarHandle.storeStoreFence();
                f1Var.f4454f = e0Var;
                f1Var.f4455g = new nc.f0(t0VarA);
                VarHandle.storeStoreFence();
                return f1Var;
            case 11:
                f1 f1Var2 = (f1) k1.f4513a.getValue();
                f1Var2.getClass();
                v0 v0Var = new v0();
                v0Var.f4631a = f1Var2;
                VarHandle.storeStoreFence();
                return v0Var;
            case 12:
                k0.e0 e0Var2 = i4.a.f5776a;
                return null;
            case 13:
                ArrayList arrayList4 = j9.b0.f6645n;
                return vVar;
            case 14:
                k0.t.d("Unexpected call to default provider");
                throw new androidx.fragment.app.d();
            case 15:
                d2.l0 l0Var = s8.s.i;
                return vVar;
            case 16:
                int i13 = l2.f11775m;
                return vVar;
            case 17:
                int i14 = x2.f12108j;
                return vVar;
            case 18:
                return new t0.e(new LinkedHashMap());
            case 19:
                s2 s2Var = t0.i.f13120a;
                return null;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                return new ad.w(new ad.v());
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present");
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                s2 s2Var2 = v0.c.f14319a;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                return null;
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                s2 s2Var3 = v0.e.f14321a;
                return null;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                vc.g gVar = vc.g.f14894e;
                vc.e[] eVarArr = new vc.e[0];
                if (hc.h.g0("kotlin.Unit")) {
                    g5.f.s("Blank serial names are prohibited");
                    return null;
                }
                if (gVar.equals(vc.g.f14891b)) {
                    g5.f.s("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
                    return null;
                }
                vc.a aVar2 = new vc.a("kotlin.Unit");
                return new vc.f("kotlin.Unit", gVar, aVar2.f14868b.size(), kb.k.u0(eVarArr), aVar2);
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                l8.b bVar4 = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                return Long.valueOf(System.currentTimeMillis());
            case 28:
                int i15 = LedgerProvider.f2504g;
                l8.b bVar5 = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            default:
                return Long.valueOf(System.currentTimeMillis());
        }
    }
}
