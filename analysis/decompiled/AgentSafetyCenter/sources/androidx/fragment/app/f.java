package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements t4.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1278a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1279b;

    public /* synthetic */ f(int i) {
        this.f1278a = i;
    }

    @Override // t4.c
    public final Bundle a() {
        ArrayList arrayList;
        b[] bVarArr;
        int size;
        int i = this.f1278a;
        Object obj = this.f1279b;
        switch (i) {
            case 0:
                j jVar = (j) obj;
                jVar.markFragmentsCreated();
                jVar.mFragmentLifecycleRegistry.f(androidx.lifecycle.o.ON_STOP);
                return new Bundle();
            default:
                v vVar = (v) obj;
                vVar.getClass();
                Bundle bundle = new Bundle();
                Iterator it = vVar.b().iterator();
                while (it.hasNext()) {
                    ((d0) it.next()).getClass();
                }
                Iterator it2 = vVar.b().iterator();
                if (it2.hasNext()) {
                    ((d0) it2.next()).a();
                    throw null;
                }
                vVar.e(true);
                vVar.f1328y = true;
                vVar.E.getClass();
                a0 a0Var = vVar.f1307c;
                a0Var.getClass();
                HashMap map = a0Var.f1249b;
                ArrayList arrayList2 = new ArrayList(map.size());
                Iterator it3 = map.values().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        a0 a0Var2 = vVar.f1307c;
                        a0Var2.getClass();
                        ArrayList arrayList3 = new ArrayList(a0Var2.f1250c.values());
                        int i3 = 2;
                        if (arrayList3.isEmpty()) {
                            if (!u.h(2)) {
                                return bundle;
                            }
                            Log.v("FragmentManager", "saveAllState: no fragments!");
                            return bundle;
                        }
                        a0 a0Var3 = vVar.f1307c;
                        synchronized (a0Var3.f1248a) {
                            try {
                                if (a0Var3.f1248a.isEmpty()) {
                                    arrayList = null;
                                } else {
                                    arrayList = new ArrayList(a0Var3.f1248a.size());
                                    Iterator it4 = a0Var3.f1248a.iterator();
                                    if (it4.hasNext()) {
                                        if (it4.next() == null) {
                                            throw null;
                                        }
                                        throw new ClassCastException();
                                    }
                                }
                            } finally {
                            }
                        }
                        ArrayList arrayList4 = vVar.f1308d;
                        if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
                            bVarArr = null;
                        } else {
                            bVarArr = new b[size];
                            int i10 = 0;
                            while (i10 < size) {
                                a aVar = (a) vVar.f1308d.get(i10);
                                b bVar = new b();
                                int size2 = aVar.f1232a.size();
                                bVar.f1252c = new int[size2 * 6];
                                if (aVar.f1238g) {
                                    bVar.f1253f = new ArrayList(size2);
                                    bVar.f1254g = new int[size2];
                                    bVar.f1255h = new int[size2];
                                    int i11 = 0;
                                    int i12 = 0;
                                    while (i11 < size2) {
                                        int i13 = i3;
                                        b0 b0Var = (b0) aVar.f1232a.get(i11);
                                        bVar.f1252c[i12] = b0Var.f1265a;
                                        bVar.f1253f.add(null);
                                        int[] iArr = bVar.f1252c;
                                        iArr[i12 + 1] = b0Var.f1266b ? 1 : 0;
                                        iArr[i12 + 2] = b0Var.f1267c;
                                        iArr[i12 + 3] = b0Var.f1268d;
                                        int i14 = i12 + 5;
                                        iArr[i12 + 4] = b0Var.f1269e;
                                        i12 += 6;
                                        iArr[i14] = b0Var.f1270f;
                                        bVar.f1254g[i11] = b0Var.f1271g.ordinal();
                                        bVar.f1255h[i11] = b0Var.f1272h.ordinal();
                                        i11++;
                                        i3 = i13;
                                        size = size;
                                    }
                                    int i15 = size;
                                    int i16 = i3;
                                    bVar.i = aVar.f1237f;
                                    bVar.f1256j = aVar.f1239h;
                                    bVar.f1257k = aVar.f1247q;
                                    bVar.f1258l = aVar.i;
                                    bVar.f1259m = aVar.f1240j;
                                    bVar.f1260n = aVar.f1241k;
                                    bVar.f1261o = aVar.f1242l;
                                    bVar.f1262p = aVar.f1243m;
                                    bVar.f1263q = aVar.f1244n;
                                    bVar.f1264r = aVar.f1245o;
                                    bVarArr[i10] = bVar;
                                    if (u.h(i16)) {
                                        StringBuilder sbT = k0.a.t(i10, "saveAllState: adding back stack #", ": ");
                                        sbT.append(vVar.f1308d.get(i10));
                                        Log.v("FragmentManager", sbT.toString());
                                    }
                                    i10++;
                                    i3 = i16;
                                    size = i15;
                                } else {
                                    od.f.e("Not on back stack");
                                }
                            }
                        }
                        w wVar = new w();
                        wVar.i = null;
                        ArrayList arrayList5 = new ArrayList();
                        wVar.f1334j = arrayList5;
                        ArrayList arrayList6 = new ArrayList();
                        wVar.f1335k = arrayList6;
                        wVar.f1330c = arrayList2;
                        wVar.f1331f = arrayList;
                        wVar.f1332g = bVarArr;
                        wVar.f1333h = vVar.f1312h.get();
                        arrayList5.addAll(vVar.i.keySet());
                        arrayList6.addAll(vVar.i.values());
                        wVar.f1336l = new ArrayList(vVar.f1327x);
                        bundle.putParcelable("state", wVar);
                        for (String str : vVar.f1313j.keySet()) {
                            bundle.putBundle(w2.c.b("result_", str), (Bundle) vVar.f1313j.get(str));
                        }
                        int size3 = arrayList3.size();
                        int i17 = 0;
                        while (i17 < size3) {
                            Object obj2 = arrayList3.get(i17);
                            i17++;
                            z zVar = (z) obj2;
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable("state", zVar);
                            bundle.putBundle("fragment_" + zVar.f1344f, bundle2);
                        }
                        return bundle;
                    }
                    if (it3.next() != null) {
                        od.f.j();
                    }
                }
                return null;
        }
    }
}
