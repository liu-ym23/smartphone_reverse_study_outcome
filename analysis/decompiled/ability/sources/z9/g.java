package z9;

import H4.o;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public interface g {
    default boolean b() {
        return false;
    }

    int c(String str);

    int d();

    String e(int i);

    List f(int i);

    g g(int i);

    default List getAnnotations() {
        return EmptyList.f4893a;
    }

    o getKind();

    String h();

    boolean i(int i);

    default boolean isInline() {
        return false;
    }
}
