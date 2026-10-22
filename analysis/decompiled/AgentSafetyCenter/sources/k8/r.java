package k8;

import android.content.ContentResolver;
import android.content.Context;
import com.stepos.agentsafetycenter.MainActivity;
import g9.l1;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import k0.c1;
import s8.g1;
import s8.j3;
import s8.m1;
import s8.p3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements androidx.lifecycle.v {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7339c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7340f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7341g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7342h;

    public /* synthetic */ r(int i) {
        this.f7339c = i;
    }

    @Override // androidx.lifecycle.v
    public final void e(androidx.lifecycle.x xVar, androidx.lifecycle.o oVar) {
        Boolean bool;
        int i;
        Integer numValueOf;
        Object obj;
        m1 m1Var;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        int size;
        String str;
        String str2;
        j3 j3VarA;
        switch (this.f7339c) {
            case 0:
                c1 c1Var = (c1) this.f7340f;
                c1 c1Var2 = (c1) this.f7341g;
                Context context = (Context) this.f7342h;
                int i3 = MainActivity.f2491h;
                if (oVar == androidx.lifecycle.o.ON_RESUME) {
                    d0 d0Var = (d0) c1Var.getValue();
                    x xVar2 = x.f7359a;
                    boolean zA = yb.k.a(d0Var, xVar2);
                    z zVar = z.f7361a;
                    a0 a0Var = a0.f7278a;
                    y yVar = y.f7360a;
                    if (zA || yb.k.a(d0Var, zVar) || yb.k.a(d0Var, yVar) || yb.k.a(d0Var, a0Var) || (d0Var instanceof w)) {
                        m8.a aVar = (m8.a) c1Var2.getValue();
                        Boolean boolValueOf = yb.k.a(d0Var, yVar) ? Boolean.valueOf(((e9.z) e9.h.f3655f.l(context).f3661e.f8841c.getValue()).f3740a) : null;
                        if (yb.k.a(d0Var, a0Var)) {
                            ContentResolver contentResolver = ((MainActivity) context).getContentResolver();
                            contentResolver.getClass();
                            bool = (Boolean) a.a.Q(contentResolver).f6759c;
                        } else {
                            bool = null;
                        }
                        if (d0Var instanceof w) {
                            w wVar = (w) d0Var;
                            aVar.getClass();
                            b bVar = wVar.f7358d;
                            if (bVar == null) {
                                bVar = wVar.f7356b ? b.f7280f : wVar.f7355a;
                            }
                            s8.t tVarB = aVar.b();
                            a aVar2 = wVar.f7357c;
                            bVar.getClass();
                            ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
                            List<j3> listT = tVarB.f11967e;
                            if (aVar2 != null) {
                                listT = g1.t(listT, aVar2);
                            }
                            int iOrdinal = bVar.ordinal();
                            if (iOrdinal == 0) {
                                i = 0;
                                ArrayList arrayList = new ArrayList(kb.m.m0(listT, 10));
                                for (j3 j3VarA2 : listT) {
                                    List listR = g1.R(j3VarA2.f11702e);
                                    if (!listR.isEmpty()) {
                                        jb.g gVarQ = g1.Q(listR);
                                        List list = (List) gVarQ.f6759c;
                                        int iIntValue = ((Number) gVarQ.f6760f).intValue();
                                        int size2 = listR.size();
                                        p3 p3Var = (p3) kb.l.x0(list);
                                        if (p3Var == null || (str = p3Var.f11877c) == null) {
                                            str = j3VarA2.f11705h;
                                        }
                                        j3VarA2 = j3.a(j3VarA2, list, iIntValue, size2, null, str, 881);
                                    }
                                    arrayList.add(j3VarA2);
                                }
                                int size3 = arrayList.size();
                                size = 0;
                                int i10 = 0;
                                while (i10 < size3) {
                                    Object obj6 = arrayList.get(i10);
                                    i10++;
                                    size += ((j3) obj6).f11699b.size();
                                }
                            } else if (iOrdinal == 1) {
                                ArrayList arrayList2 = new ArrayList();
                                for (j3 j3Var : listT) {
                                    List list2 = j3Var.f11702e;
                                    ArrayList arrayList3 = new ArrayList();
                                    for (Object obj7 : list2) {
                                        if (((p3) obj7).f11880f) {
                                            arrayList3.add(obj7);
                                        }
                                    }
                                    List listR2 = g1.R(arrayList3);
                                    if (listR2.isEmpty()) {
                                        j3VarA = null;
                                    } else {
                                        List listR3 = g1.R(listR2);
                                        jb.g gVar = listR3.isEmpty() ? new jb.g(kb.s.f7404c, 0) : listR3.size() <= 3 ? new jb.g(listR3, 0) : new jb.g(kb.l.J0(listR3, 3), Integer.valueOf(listR3.size() - 3));
                                        List list3 = (List) gVar.f6759c;
                                        int iIntValue2 = ((Number) gVar.f6760f).intValue();
                                        p3 p3Var2 = (p3) kb.l.x0(listR2);
                                        if (p3Var2 == null || (str2 = p3Var2.f11877c) == null) {
                                            str2 = j3Var.f11705h;
                                        }
                                        j3VarA = j3.a(j3Var, list3, iIntValue2, listR2.size(), listR2, str2, 865);
                                    }
                                    if (j3VarA != null) {
                                        arrayList2.add(j3VarA);
                                    }
                                }
                                i = 0;
                                int size4 = arrayList2.size();
                                size = 0;
                                int i11 = 0;
                                while (i11 < size4) {
                                    Object obj8 = arrayList2.get(i11);
                                    i11++;
                                    size += ((j3) obj8).f11699b.size();
                                }
                            } else if (iOrdinal != 2) {
                                g5.f.a();
                                break;
                            } else {
                                zoneIdSystemDefault.getClass();
                                Iterator it = g1.l(listT, aVar2, zoneIdSystemDefault).iterator();
                                size = 0;
                                while (it.hasNext()) {
                                    size += ((j3) it.next()).f11699b.size();
                                }
                                i = 0;
                            }
                            numValueOf = Integer.valueOf(size);
                        } else {
                            i = 0;
                            numValueOf = null;
                        }
                        Iterator it2 = g9.t.f4612c.iterator();
                        int size5 = i;
                        while (it2.hasNext()) {
                            size5 += ((l1) it2.next()).f4524b.size();
                        }
                        d0Var.getClass();
                        aVar.getClass();
                        if (d0Var.equals(xVar2)) {
                            List list4 = aVar.f8272d.f11965c;
                            if (list4.isEmpty()) {
                                m1Var = new m1("", 0.0f, true, 0L, 0, 0, 0, (String) null, 504);
                            } else {
                                int i12 = aVar.f8278k;
                                int i13 = i12 < 0 ? i : i12;
                                int iOrdinal2 = aVar.f8277j.ordinal();
                                if (iOrdinal2 == 0) {
                                    ListIterator listIterator = list4.listIterator(list4.size());
                                    while (true) {
                                        if (listIterator.hasPrevious()) {
                                            Object objPrevious = listIterator.previous();
                                            if (((m1) objPrevious).f11794c) {
                                                obj = objPrevious;
                                            }
                                        } else {
                                            obj = null;
                                        }
                                    }
                                    m1Var = (m1) obj;
                                    if (m1Var == null) {
                                        int size6 = list4.size() - 1;
                                        if (i13 > size6) {
                                            i13 = size6;
                                        }
                                        m1Var = (m1) ((i13 < 0 || i13 >= list4.size()) ? (m1) kb.l.w0(list4) : list4.get(i13));
                                    }
                                } else if (iOrdinal2 == 1) {
                                    int size7 = list4.size() - 1;
                                    if (i13 > size7) {
                                        i13 = size7;
                                    }
                                    if (i13 < 0 || i13 >= list4.size()) {
                                        ListIterator listIterator2 = list4.listIterator(list4.size());
                                        while (true) {
                                            if (listIterator2.hasPrevious()) {
                                                Object objPrevious2 = listIterator2.previous();
                                                if (((m1) objPrevious2).f11794c) {
                                                    obj2 = objPrevious2;
                                                }
                                            } else {
                                                obj2 = null;
                                            }
                                        }
                                        Object obj9 = (m1) obj2;
                                        obj3 = obj9 == null ? (m1) kb.l.w0(list4) : obj9;
                                    } else {
                                        obj3 = list4.get(i13);
                                    }
                                    m1Var = (m1) obj3;
                                } else if (iOrdinal2 == 2) {
                                    List list5 = aVar.f8283p;
                                    int iX = ac.a.x(list5);
                                    if (i13 > iX) {
                                        i13 = iX;
                                    }
                                    m1Var = (m1) kb.l.y0(i13, list5);
                                    if (m1Var == null) {
                                        ListIterator listIterator3 = list4.listIterator(list4.size());
                                        while (true) {
                                            if (listIterator3.hasPrevious()) {
                                                Object objPrevious3 = listIterator3.previous();
                                                if (((m1) objPrevious3).f11794c) {
                                                    obj4 = objPrevious3;
                                                }
                                            } else {
                                                obj4 = null;
                                            }
                                        }
                                        m1Var = (m1) obj4;
                                        if (m1Var == null) {
                                            m1Var = (m1) kb.l.w0(list4);
                                        }
                                    }
                                } else if (iOrdinal2 != 3) {
                                    g5.f.a();
                                    break;
                                } else {
                                    List list6 = aVar.f8282o;
                                    int iX2 = ac.a.x(list6);
                                    if (i13 > iX2) {
                                        i13 = iX2;
                                    }
                                    m1Var = (m1) kb.l.y0(i13, list6);
                                    if (m1Var == null) {
                                        ListIterator listIterator4 = list4.listIterator(list4.size());
                                        while (true) {
                                            if (listIterator4.hasPrevious()) {
                                                Object objPrevious4 = listIterator4.previous();
                                                if (((m1) objPrevious4).f11794c) {
                                                    obj5 = objPrevious4;
                                                }
                                            } else {
                                                obj5 = null;
                                            }
                                        }
                                        m1Var = (m1) obj5;
                                        if (m1Var == null) {
                                            m1Var = (m1) kb.l.w0(list4);
                                        }
                                    }
                                }
                            }
                            td.h.P("page_view_security_center", "security_center", kb.w.N(new jb.g("action_count", String.valueOf(m1Var.f11796e)), new jb.g("intercepted_count", String.valueOf(m1Var.f11797f)), new jb.g("revocable_count", String.valueOf(m1Var.f11798g))));
                            break;
                        } else if (d0Var instanceof w) {
                            Map mapSingletonMap = Collections.singletonMap("record_count", String.valueOf(numValueOf != null ? numValueOf.intValue() : i));
                            mapSingletonMap.getClass();
                            td.h.P("page_view_all_records", "all_records", mapSingletonMap);
                            break;
                        } else if (d0Var.equals(zVar)) {
                            Map mapSingletonMap2 = Collections.singletonMap("permission_count", String.valueOf(size5));
                            mapSingletonMap2.getClass();
                            td.h.P("page_view_permission_manage", "permission_manage", mapSingletonMap2);
                            break;
                        } else {
                            if (d0Var.equals(yVar)) {
                                Map mapSingletonMap3 = Collections.singletonMap("gui_status", yb.k.a(boolValueOf, Boolean.TRUE) ? "on" : "off");
                                mapSingletonMap3.getClass();
                                td.h.P("page_view_gui_manage", "gui_manage", mapSingletonMap3);
                                break;
                            } else if (d0Var.equals(a0Var)) {
                                Map mapSingletonMap4 = Collections.singletonMap("perception_status", yb.k.a(bool, Boolean.TRUE) ? "on" : "off");
                                mapSingletonMap4.getClass();
                                td.h.P("page_view_smart_perception_manage", "smart_perception_manage", mapSingletonMap4);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                n3.m mVar = (n3.m) this.f7340f;
                androidx.lifecycle.p pVar = (androidx.lifecycle.p) this.f7341g;
                n3.n nVar = (n3.n) this.f7342h;
                mVar.getClass();
                Runnable runnable = mVar.f8730a;
                CopyOnWriteArrayList copyOnWriteArrayList = mVar.f8731b;
                androidx.lifecycle.o.Companion.getClass();
                pVar.getClass();
                int iOrdinal3 = pVar.ordinal();
                if (oVar == (iOrdinal3 != 2 ? iOrdinal3 != 3 ? iOrdinal3 != 4 ? null : androidx.lifecycle.o.ON_RESUME : androidx.lifecycle.o.ON_START : androidx.lifecycle.o.ON_CREATE)) {
                    copyOnWriteArrayList.add(nVar);
                    runnable.run();
                    break;
                } else if (oVar == androidx.lifecycle.o.ON_DESTROY) {
                    mVar.d(nVar);
                    break;
                } else if (oVar == androidx.lifecycle.m.a(pVar)) {
                    copyOnWriteArrayList.remove(nVar);
                    runnable.run();
                    break;
                }
                break;
        }
    }
}
