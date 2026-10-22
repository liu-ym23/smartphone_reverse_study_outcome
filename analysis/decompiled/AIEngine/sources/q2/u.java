package q2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface u {
    ArrayList a(String str);

    void b(t tVar);

    default void c(String id2, Set<String> tags) {
        kotlin.jvm.internal.g.f(id2, "id");
        kotlin.jvm.internal.g.f(tags, "tags");
        Iterator<T> it = tags.iterator();
        while (it.hasNext()) {
            b(new t((String) it.next(), id2));
        }
    }
}
