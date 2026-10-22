package Y;

import D.B;
import androidx.camera.core.impl.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class a {
    public static B a(List<B> list) {
        if (list.isEmpty()) {
            return null;
        }
        B b10 = list.get(0);
        Integer numValueOf = Integer.valueOf(b10.b());
        Integer numValueOf2 = Integer.valueOf(b10.a());
        for (int i10 = 1; i10 < list.size(); i10++) {
            B b11 = list.get(i10);
            numValueOf = c(numValueOf, Integer.valueOf(b11.b()));
            numValueOf2 = b(numValueOf2, Integer.valueOf(b11.a()));
            if (numValueOf == null || numValueOf2 == null) {
                return null;
            }
        }
        return new B(numValueOf.intValue(), numValueOf2.intValue());
    }

    public static Integer b(Integer num, Integer num2) {
        if (num.equals(0)) {
            return num2;
        }
        if (num2.equals(0) || num.equals(num2)) {
            return num;
        }
        return null;
    }

    public static Integer c(Integer num, Integer num2) {
        if (num.equals(0)) {
            return num2;
        }
        if (!num2.equals(0)) {
            if (num.equals(2) && !num2.equals(1)) {
                return num2;
            }
            if ((!num2.equals(2) || num.equals(1)) && !num.equals(num2)) {
                return null;
            }
        }
        return num;
    }

    public static B d(Set<z<?>> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<z<?>> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().K());
        }
        return a(arrayList);
    }
}
