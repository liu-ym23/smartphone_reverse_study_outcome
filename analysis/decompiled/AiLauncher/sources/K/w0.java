package K;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    public final List<s0> f4019a;

    public w0(List<s0> list) {
        this.f4019a = new ArrayList(list);
    }

    public static String d(w0 w0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<s0> it = w0Var.f4019a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getClass().getSimpleName());
        }
        return String.join(" | ", arrayList);
    }

    public boolean a(Class<? extends s0> cls) {
        Iterator<s0> it = this.f4019a.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next().getClass())) {
                return true;
            }
        }
        return false;
    }

    public <T extends s0> T b(Class<T> cls) {
        Iterator<s0> it = this.f4019a.iterator();
        while (it.hasNext()) {
            T t10 = (T) it.next();
            if (t10.getClass() == cls) {
                return t10;
            }
        }
        return null;
    }

    public <T extends s0> List<T> c(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (s0 s0Var : this.f4019a) {
            if (cls.isAssignableFrom(s0Var.getClass())) {
                arrayList.add(s0Var);
            }
        }
        return arrayList;
    }
}
