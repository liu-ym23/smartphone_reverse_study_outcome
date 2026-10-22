package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* loaded from: classes.dex */
public final class T {
    public static int a(int i4, Object obj, Object obj2) {
        S s4 = (S) obj;
        Q q4 = (Q) obj2;
        int iA = 0;
        if (!s4.isEmpty()) {
            for (Map.Entry entry : s4.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                q4.getClass();
                int iC = AbstractC0268o.C(i4);
                int iA2 = Q.a(q4.f3434a, key, value);
                iA = B0.g.A(iA2, iA2, iC, iA);
            }
        }
        return iA;
    }

    public static S b(Object obj, Object obj2) {
        S sB = (S) obj;
        S s4 = (S) obj2;
        if (!s4.isEmpty()) {
            if (!sB.f3438a) {
                sB = sB.b();
            }
            sB.a();
            if (!s4.isEmpty()) {
                sB.putAll(s4);
            }
        }
        return sB;
    }
}
