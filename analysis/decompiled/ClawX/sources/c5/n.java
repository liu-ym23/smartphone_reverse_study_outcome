package c5;

import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class n extends a.a {
    public static int j0(List list) {
        kotlin.jvm.internal.p.e(list, "<this>");
        return list.size() - 1;
    }

    public static List k0(Object... objArr) {
        return objArr.length > 0 ? l.S(objArr) : s.f1092a;
    }

    public static final List l0(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : a.a.S(list.get(0)) : s.f1092a;
    }

    public static void m0() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
