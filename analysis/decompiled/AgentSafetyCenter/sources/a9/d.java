package a9;

import aa.u;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import d1.i0;
import d2.b0;
import d2.c0;
import d2.e0;
import d2.j0;
import d2.k0;
import h5.t;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import jb.v;
import kb.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f255c;

    public /* synthetic */ d(int i) {
        this.f255c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f255c;
        v vVar = v.f6774a;
        e0 e0Var = null;
        j0Var = null;
        j0 j0Var = null;
        nVar = null;
        o2.n nVar = null;
        e0Var = null;
        int i3 = 0;
        switch (i) {
            case 0:
                File file = (File) obj;
                file.getClass();
                return Boolean.valueOf(file.isFile());
            case 1:
                File file2 = (File) obj;
                file2.getClass();
                return Boolean.valueOf(file2.isDirectory());
            case 2:
                l lVar = (l) obj;
                lVar.getClass();
                return lVar.f284b;
            case 3:
                z9.g gVar = (z9.g) obj;
                gVar.getClass();
                gVar.D = false;
                return vVar;
            case 4:
                z9.g gVar2 = (z9.g) obj;
                gVar2.getClass();
                gVar2.H = false;
                gVar2.K = 0.0f;
                return vVar;
            case 5:
                z9.g gVar3 = (z9.g) obj;
                gVar3.getClass();
                gVar3.f16543n = false;
                gVar3.f16553x = 0.0f;
                gVar3.f16554y = false;
                return vVar;
            case 6:
                obj.getClass();
                z9.f fVar = z9.f.f16523a;
                z9.f.b(obj, "setBlendArray", new Class[]{int[].class, int[].class}, new int[0], new int[0]);
                return vVar;
            case 7:
                z9.g gVar4 = (z9.g) obj;
                gVar4.getClass();
                gVar4.f16536f = s.f7404c;
                return vVar;
            case 8:
                obj.getClass();
                z9.f fVar2 = z9.f.f16523a;
                Class cls = z9.f.i;
                Class cls2 = z9.f.f16529g;
                Class cls3 = z9.f.f16530h;
                Class[] clsArr = {cls, cls2, cls3, cls3, cls3, cls3};
                Boolean bool = Boolean.FALSE;
                Float fValueOf = Float.valueOf(0.0f);
                z9.f.b(obj, "setInnerShadow", clsArr, bool, 0, fValueOf, fValueOf, fValueOf, fValueOf);
                return vVar;
            case 9:
                obj.getClass();
                z9.f fVar3 = z9.f.f16523a;
                Class cls4 = z9.f.i;
                Class cls5 = z9.f.f16530h;
                Boolean bool2 = Boolean.FALSE;
                Float fValueOf2 = Float.valueOf(0.0f);
                z9.f.b(obj, "setRefraction", new Class[]{cls4, cls5, cls5}, bool2, fValueOf2, fValueOf2);
                z9.f.b(obj, "setDispersion", new Class[]{cls5}, fValueOf2);
                return vVar;
            case 10:
                obj.getClass();
                z9.f fVar4 = z9.f.f16523a;
                Class cls6 = z9.f.i;
                Class cls7 = z9.f.f16530h;
                Class[] clsArr2 = {cls6, cls7, cls7, cls7, z9.f.f16529g};
                Boolean bool3 = Boolean.FALSE;
                Float fValueOf3 = Float.valueOf(0.0f);
                z9.f.b(obj, "setGlassStroke", clsArr2, bool3, fValueOf3, fValueOf3, fValueOf3, 0);
                z9.f.b(obj, "setAmbient", new Class[]{cls7}, fValueOf3);
                return vVar;
            case 11:
                u uVar = (u) obj;
                uVar.getClass();
                uVar.f367c = 1.0f;
                uVar.f369e = 0.18f;
                uVar.f370f = 4.0f;
                uVar.f368d = 4.0f;
                uVar.f375l = true;
                uVar.f374k = 1.0f;
                uVar.f376m = 866559654;
                uVar.f377n = 866559654;
                double radians = Math.toRadians(270.0d);
                double radians2 = Math.toRadians(45.0d);
                uVar.f371g = (float) Math.cos(radians);
                uVar.f372h = (float) Math.sin(radians);
                uVar.i = (float) Math.cos(radians2);
                uVar.f373j = (float) Math.sin(radians2);
                return vVar;
            case 12:
                x4.c cVar = (x4.c) obj;
                cVar.getClass();
                return Boolean.valueOf(cVar.G());
            case 13:
                x4.c cVar2 = (x4.c) obj;
                cVar2.getClass();
                lb.i iVar = new lb.i();
                while (cVar2.G()) {
                    iVar.add(Integer.valueOf((int) cVar2.getLong(0)));
                }
                return t.n(iVar);
            case 14:
                return Boolean.valueOf(!(((d2.b) obj) instanceof d2.t));
            case 15:
                d2.q qVar = (d2.q) obj;
                StringBuilder sb2 = new StringBuilder("[");
                sb2.append(qVar.f3160b);
                sb2.append(", ");
                return androidx.activity.b.l(sb2, qVar.f3161c, ')');
            case 16:
                obj.getClass();
                List list = (List) obj;
                Object obj2 = list.get(0);
                p5.u uVar2 = c0.i;
                Boolean bool4 = Boolean.FALSE;
                e0 e0Var2 = (yb.k.a(obj2, bool4) || obj2 == null) ? null : (e0) ((xb.l) uVar2.f9808g).invoke(obj2);
                Object obj3 = list.get(1);
                e0 e0Var3 = (yb.k.a(obj3, bool4) || obj3 == null) ? null : (e0) ((xb.l) uVar2.f9808g).invoke(obj3);
                Object obj4 = list.get(2);
                e0 e0Var4 = (yb.k.a(obj4, bool4) || obj4 == null) ? null : (e0) ((xb.l) uVar2.f9808g).invoke(obj4);
                Object obj5 = list.get(3);
                if (!yb.k.a(obj5, bool4) && obj5 != null) {
                    e0Var = (e0) ((xb.l) uVar2.f9808g).invoke(obj5);
                }
                j0 j0Var2 = new j0();
                j0Var2.f3128a = e0Var2;
                j0Var2.f3129b = e0Var3;
                j0Var2.f3130c = e0Var4;
                j0Var2.f3131d = e0Var;
                VarHandle.storeStoreFence();
                return j0Var2;
            case 17:
                obj.getClass();
                List list2 = (List) obj;
                Object obj6 = list2.get(1);
                List list3 = (yb.k.a(obj6, Boolean.FALSE) || obj6 == null) ? null : (List) ((xb.l) c0.f3050b.f9808g).invoke(obj6);
                Object obj7 = list2.get(0);
                String str = obj7 != null ? (String) obj7 : null;
                str.getClass();
                return new d2.g(list3, str);
            case 18:
                obj.getClass();
                return new n2.l(((Integer) obj).intValue());
            case 19:
                obj.getClass();
                List list4 = (List) obj;
                return new n2.p(((Number) list4.get(0)).floatValue(), ((Number) list4.get(1)).floatValue());
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                obj.getClass();
                List list5 = (List) obj;
                Object obj8 = list5.get(0);
                o2.o[] oVarArr = o2.n.f9127b;
                b0 b0Var = c0.f3066s;
                Boolean bool5 = Boolean.FALSE;
                o2.n nVar2 = ((yb.k.a(obj8, bool5) && b0Var == null) || obj8 == null) ? null : (o2.n) b0Var.f3044f.invoke(obj8);
                nVar2.getClass();
                long j10 = nVar2.f9129a;
                Object obj9 = list5.get(1);
                if ((!yb.k.a(obj9, bool5) || b0Var != null) && obj9 != null) {
                    nVar = (o2.n) b0Var.f3044f.invoke(obj9);
                }
                nVar.getClass();
                return new n2.q(j10, nVar.f9129a);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                obj.getClass();
                return new g2.k(((Integer) obj).intValue());
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                obj.getClass();
                float fFloatValue = ((Float) obj).floatValue();
                n2.a aVar = new n2.a();
                aVar.f8644a = fFloatValue;
                VarHandle.storeStoreFence();
                return aVar;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                obj.getClass();
                List list6 = (List) obj;
                Object obj10 = list6.get(0);
                Integer num = obj10 != null ? (Integer) obj10 : null;
                num.getClass();
                int iIntValue = num.intValue();
                Object obj11 = list6.get(1);
                Integer num2 = obj11 != null ? (Integer) obj11 : null;
                num2.getClass();
                long jA = com.stepos.statsrpk.h.a(iIntValue, num2.intValue());
                k0 k0Var = new k0();
                k0Var.f3136a = jA;
                VarHandle.storeStoreFence();
                return k0Var;
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                obj.getClass();
                List list7 = (List) obj;
                Object obj12 = list7.get(0);
                int i10 = d1.p.f3025h;
                b0 b0Var2 = c0.f3065r;
                Boolean bool6 = Boolean.FALSE;
                d1.p pVar = ((yb.k.a(obj12, bool6) && b0Var2 == null) || obj12 == null) ? null : (d1.p) b0Var2.f3044f.invoke(obj12);
                pVar.getClass();
                long j11 = pVar.f3026a;
                Object obj13 = list7.get(1);
                b0 b0Var3 = c0.f3067t;
                c1.b bVar = ((yb.k.a(obj13, bool6) && b0Var3 == null) || obj13 == null) ? null : (c1.b) b0Var3.f3044f.invoke(obj13);
                bVar.getClass();
                long j12 = bVar.f2165a;
                Object obj14 = list7.get(2);
                Float f5 = obj14 != null ? (Float) obj14 : null;
                f5.getClass();
                return new i0(j11, j12, f5.floatValue());
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                if (yb.k.a(obj, Boolean.FALSE)) {
                    return o2.n.a(o2.n.f9128c);
                }
                obj.getClass();
                List list8 = (List) obj;
                Object obj15 = list8.get(0);
                Float f10 = obj15 != null ? (Float) obj15 : null;
                f10.getClass();
                float fFloatValue2 = f10.floatValue();
                Object obj16 = list8.get(1);
                o2.o oVar = obj16 != null ? (o2.o) obj16 : null;
                oVar.getClass();
                return o2.n.a(com.stepos.statsrpk.h.C(fFloatValue2, oVar.f9130a));
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                obj.getClass();
                List list9 = (List) obj;
                Object obj17 = list9.get(0);
                String str2 = obj17 != null ? (String) obj17 : null;
                str2.getClass();
                Object obj18 = list9.get(1);
                p5.u uVar3 = c0.f3057j;
                if (!yb.k.a(obj18, Boolean.FALSE) && obj18 != null) {
                    j0Var = (j0) ((xb.l) uVar3.f9808g).invoke(obj18);
                }
                d2.l lVar2 = new d2.l();
                lVar2.f3137a = str2;
                lVar2.f3138b = j0Var;
                VarHandle.storeStoreFence();
                return lVar2;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                if (yb.k.a(obj, Boolean.FALSE)) {
                    return c1.b.a(9205357640488583168L);
                }
                obj.getClass();
                List list10 = (List) obj;
                Object obj19 = list10.get(0);
                Float f11 = obj19 != null ? (Float) obj19 : null;
                f11.getClass();
                float fFloatValue3 = f11.floatValue();
                Object obj20 = list10.get(1);
                (obj20 != null ? (Float) obj20 : null).getClass();
                return c1.b.a((Float.floatToRawIntBits(r3.floatValue()) & 4294967295L) | (Float.floatToRawIntBits(fFloatValue3) << 32));
            case 28:
                obj.getClass();
                List list11 = (List) obj;
                ArrayList arrayList = new ArrayList(list11.size());
                int size = list11.size();
                while (i3 < size) {
                    Object obj21 = list11.get(i3);
                    j2.a aVar2 = (yb.k.a(obj21, Boolean.FALSE) || obj21 == null) ? null : (j2.a) ((xb.l) c0.f3069v.f9808g).invoke(obj21);
                    aVar2.getClass();
                    arrayList.add(aVar2);
                    i3++;
                }
                return new j2.b(arrayList);
            default:
                obj.getClass();
                List list12 = (List) obj;
                ArrayList arrayList2 = new ArrayList(list12.size());
                int size2 = list12.size();
                while (i3 < size2) {
                    Object obj22 = list12.get(i3);
                    d2.e eVar = (yb.k.a(obj22, Boolean.FALSE) || obj22 == null) ? null : (d2.e) ((xb.l) c0.f3051c.f9808g).invoke(obj22);
                    eVar.getClass();
                    arrayList2.add(eVar);
                    i3++;
                }
                return arrayList2;
        }
    }
}
