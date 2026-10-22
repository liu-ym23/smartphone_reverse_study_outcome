package com.amap.api.col.jmsl;

import com.amap.api.col.jmsl.O2;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class b3 extends U2 {

    /* renamed from: j, reason: collision with root package name */
    public double f16537j;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public LatLonPoint f16538a;

        /* renamed from: b, reason: collision with root package name */
        public double f16539b;

        public a(double d10, double d11, double d12) {
            this.f16538a = null;
            this.f16539b = 0.0d;
            this.f16538a = new LatLonPoint(d10, d11);
            this.f16539b = d12;
        }

        public boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.f16538a;
                a aVar = (a) obj;
                if (latLonPoint == aVar.f16538a) {
                    return true;
                }
                if (latLonPoint != null && C1631z1.b(latLonPoint, r2) <= aVar.f16539b) {
                    return true;
                }
            }
            return false;
        }
    }

    public b3(String... strArr) {
        super(strArr);
        this.f16537j = 0.0d;
    }

    @Override // com.amap.api.col.jmsl.U2
    public void c(O2.a aVar) {
        super.c(aVar);
        this.f16537j = aVar.a();
    }

    @Override // com.amap.api.col.jmsl.U2
    public boolean f(LinkedHashMap<O2.b, Object> linkedHashMap, O2.b bVar) {
        String str;
        if (linkedHashMap != null) {
            if (bVar.f16253b == null) {
                return super.f(linkedHashMap, bVar);
            }
            for (O2.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f16252a) != null && str.equals(bVar.f16252a)) {
                    Object obj = bVar2.f16253b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f16253b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.amap.api.col.jmsl.U2
    public Object g(LinkedHashMap<O2.b, Object> linkedHashMap, O2.b bVar) {
        String str;
        if (linkedHashMap != null) {
            if (bVar.f16253b == null) {
                return super.g(linkedHashMap, bVar);
            }
            for (O2.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f16252a) != null && str.equals(bVar.f16252a)) {
                    Object obj = bVar2.f16253b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f16253b)) {
                        return linkedHashMap.get(bVar2);
                    }
                }
            }
        }
        return null;
    }

    @Override // com.amap.api.col.jmsl.U2
    public Object i(LinkedHashMap<O2.b, Object> linkedHashMap, O2.b bVar) {
        O2.b next;
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f16253b == null) {
                return super.i(linkedHashMap, bVar);
            }
            Iterator<O2.b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && (str = next.f16252a) != null && str.equals(bVar.f16252a)) {
                    Object obj = next.f16253b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f16253b)) {
                        break;
                    }
                }
            }
            if (next != null) {
                return linkedHashMap.remove(next);
            }
        }
        return null;
    }

    public double j() {
        return this.f16537j;
    }
}
