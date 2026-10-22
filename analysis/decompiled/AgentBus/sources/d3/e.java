package d3;

import d7.s;
import d7.z;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final List f2810a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2811b;

    public e(int i2, List list) {
        this.f2810a = list;
        this.f2811b = i2;
        if (list.isEmpty() && i2 == -1) {
            return;
        }
        if (!list.isEmpty()) {
            int size = list.size();
            if (i2 >= 0 && i2 < size) {
                return;
            }
        }
        StringBuilder sbN = a1.a.n(i2, "Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '", "', bounds = '");
        sbN.append(s.s0(list));
        sbN.append("'.");
        throw new IllegalArgumentException(sbN.toString().toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f2811b == eVar.f2811b && q7.k.a(this.f2810a, eVar.f2810a);
    }

    public final int hashCode() {
        return this.f2810a.hashCode() + (this.f2811b * 31);
    }

    public final String toString() {
        return "NavigationEventHistory(currentIndex=" + this.f2811b + ", mergedHistory=" + this.f2810a + ')';
    }

    public e() {
        this(-1, z.f2978f);
    }
}
