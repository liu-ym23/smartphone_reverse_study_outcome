package k4;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f3625a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3626b;

    /* renamed from: c, reason: collision with root package name */
    public final double f3627c;

    public k(String value, List params) {
        Double d;
        Object next;
        String str;
        Double dT0;
        kotlin.jvm.internal.p.e(value, "value");
        kotlin.jvm.internal.p.e(params, "params");
        this.f3625a = value;
        this.f3626b = params;
        Iterator it = params.iterator();
        while (true) {
            d = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (kotlin.jvm.internal.p.a(((l) next).f3628a, "q")) {
                    break;
                }
            }
        }
        l lVar = (l) next;
        double dDoubleValue = 1.0d;
        if (lVar != null && (str = lVar.f3629b) != null && (dT0 = x5.t.T0(str)) != null) {
            double dDoubleValue2 = dT0.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                d = dT0;
            }
            if (d != null) {
                dDoubleValue = d.doubleValue();
            }
        }
        this.f3627c = dDoubleValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.p.a(this.f3625a, kVar.f3625a) && kotlin.jvm.internal.p.a(this.f3626b, kVar.f3626b);
    }

    public final int hashCode() {
        return this.f3626b.hashCode() + (this.f3625a.hashCode() * 31);
    }

    public final String toString() {
        return "HeaderValue(value=" + this.f3625a + ", params=" + this.f3626b + ')';
    }
}
