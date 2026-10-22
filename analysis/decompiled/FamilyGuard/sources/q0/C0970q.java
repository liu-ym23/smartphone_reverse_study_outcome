package q0;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.InterfaceC0890c;

/* renamed from: q0.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0970q implements p0.t {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T b(C0888a c0888a) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 4) {
            String strN = interfaceC0890c.N();
            interfaceC0890c.A(16);
            return (T) strN.toCharArray();
        }
        if (interfaceC0890c.U() == 2) {
            Number numberS = interfaceC0890c.S();
            interfaceC0890c.A(16);
            return (T) numberS.toString().toCharArray();
        }
        Object objS = c0888a.S();
        if (objS instanceof String) {
            return (T) ((String) objS).toCharArray();
        }
        if (!(objS instanceof Collection)) {
            if (objS == null) {
                return null;
            }
            return (T) AbstractC0822a.F(objS).toCharArray();
        }
        Collection collection = (Collection) objS;
        for (Object obj : collection) {
            if ((obj instanceof String) && ((String) obj).length() != 1) {
                throw new l0.d("can not cast to char[]");
            }
        }
        char[] cArr = new char[collection.size()];
        Iterator it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            cArr[i5] = ((String) it.next()).charAt(0);
            i5++;
        }
        return cArr;
    }

    @Override // p0.t
    public int d() {
        return 4;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        return (T) b(c0888a);
    }
}
