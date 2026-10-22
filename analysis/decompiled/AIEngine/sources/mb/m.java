package mb;

import androidx.datastore.preferences.protobuf.b1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class m extends b1 {
    public static <T> int Z(Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.g.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }

    public static int a0(List list) {
        kotlin.jvm.internal.g.f(list, "<this>");
        return list.size() - 1;
    }

    public static List b0(Object... elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        return elements.length > 0 ? b1.g(elements) : EmptyList.f10001a;
    }

    public static ArrayList c0(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new j(objArr, true));
    }

    public static final List d0(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : b1.P(list.get(0)) : EmptyList.f10001a;
    }

    public static void e0() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void f0() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
