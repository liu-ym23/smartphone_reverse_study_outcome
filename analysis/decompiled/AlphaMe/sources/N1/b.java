package N1;

import androidx.lifecycle.EnumC0327y;
import androidx.lifecycle.G;
import androidx.lifecycle.I;
import androidx.lifecycle.V;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f1458i = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final g f1459a;

    /* renamed from: b, reason: collision with root package name */
    public int f1460b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1461c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Object f1462d;

    /* renamed from: e, reason: collision with root package name */
    public int f1463e;

    /* renamed from: f, reason: collision with root package name */
    public int f1464f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1465g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1466h;

    public b(Object obj) {
        g gVar = new g();
        gVar.f1478c = new WeakHashMap();
        gVar.f1479d = 0;
        this.f1459a = gVar;
        this.f1460b = 0;
        this.f1464f = -1;
        this.f1462d = obj;
        this.f1463e = 0;
    }

    public final void a(a aVar) {
        if (aVar.f1453b) {
            if (!((I) aVar.f1456e.getLifecycle()).f3871d.a(EnumC0327y.f3986d)) {
                aVar.b(false);
                return;
            }
            int i4 = aVar.f1454c;
            int i5 = this.f1463e;
            if (i4 >= i5) {
                return;
            }
            aVar.f1454c = i5;
            aVar.f1452a.onChanged(this.f1462d);
        }
    }

    public final void b(a aVar) {
        if (this.f1465g) {
            this.f1466h = true;
            return;
        }
        this.f1465g = true;
        do {
            this.f1466h = false;
            if (aVar != null) {
                a(aVar);
                aVar = null;
            } else {
                g gVar = this.f1459a;
                gVar.getClass();
                e eVar = new e(gVar);
                gVar.f1478c.put(eVar, Boolean.FALSE);
                while (eVar.hasNext()) {
                    a((a) ((Map.Entry) eVar.next()).getValue());
                    if (this.f1466h) {
                        break;
                    }
                }
            }
        } while (this.f1466h);
        this.f1465g = false;
    }

    public final void c(G g4, V v4) {
        Object obj;
        if (((I) g4.getLifecycle()).f3871d == EnumC0327y.f3983a) {
            return;
        }
        a aVar = new a(this, g4, v4);
        g gVar = this.f1459a;
        d dVar = gVar.f1476a;
        while (dVar != null && !dVar.f1469a.equals(v4)) {
            dVar = dVar.f1471c;
        }
        if (dVar != null) {
            obj = dVar.f1470b;
        } else {
            d dVar2 = new d(v4, aVar);
            gVar.f1479d++;
            d dVar3 = gVar.f1477b;
            if (dVar3 == null) {
                gVar.f1476a = dVar2;
                gVar.f1477b = dVar2;
            } else {
                dVar3.f1471c = dVar2;
                dVar2.f1472d = dVar3;
                gVar.f1477b = dVar2;
            }
            obj = null;
        }
        a aVar2 = (a) obj;
        if (aVar2 != null && aVar2.f1456e != g4) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (aVar2 != null) {
            return;
        }
        this.f1464f = this.f1463e;
        g4.getLifecycle().a(aVar);
    }

    public final void d(V v4) {
        g gVar = this.f1459a;
        d dVar = gVar.f1476a;
        while (dVar != null && !dVar.f1469a.equals(v4)) {
            dVar = dVar.f1471c;
        }
        Object obj = null;
        if (dVar != null) {
            gVar.f1479d--;
            WeakHashMap weakHashMap = gVar.f1478c;
            if (!weakHashMap.isEmpty()) {
                Iterator it = weakHashMap.keySet().iterator();
                while (it.hasNext()) {
                    ((f) it.next()).a(dVar);
                }
            }
            d dVar2 = dVar.f1472d;
            if (dVar2 != null) {
                dVar2.f1471c = dVar.f1471c;
            } else {
                gVar.f1476a = dVar.f1471c;
            }
            d dVar3 = dVar.f1471c;
            if (dVar3 != null) {
                dVar3.f1472d = dVar2;
            } else {
                gVar.f1477b = dVar2;
            }
            dVar.f1471c = null;
            dVar.f1472d = null;
            obj = dVar.f1470b;
        }
        a aVar = (a) obj;
        if (aVar == null) {
            return;
        }
        aVar.f1456e.getLifecycle().b(aVar);
        aVar.b(false);
    }
}
