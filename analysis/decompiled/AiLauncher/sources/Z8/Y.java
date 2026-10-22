package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a7\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\f\u0010\r\u001a7\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u000f\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00122\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0004\"\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0007\u001a%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "e", "()Ljava/util/Set;", "", "elements", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "([Ljava/lang/Object;)Ljava/util/Set;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "f", "([Ljava/lang/Object;)Ljava/util/HashSet;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", Const.INTENT_KEY_BACKGROUND_COMMAND, "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "", "element", "k", "(Ljava/lang/Object;)Ljava/util/Set;", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Set;)Ljava/util/Set;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
/* loaded from: classes4.dex */
public class Y extends X {
    public static <T> Set<T> e() {
        return EmptySet.f34710a;
    }

    public static <T> HashSet<T> f(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return (HashSet) r.M0(elements, new HashSet(Q.e(elements.length)));
    }

    public static <T> LinkedHashSet<T> g(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return (LinkedHashSet) r.M0(elements, new LinkedHashSet(Q.e(elements.length)));
    }

    public static <T> Set<T> h(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return (Set) r.M0(elements, new LinkedHashSet(Q.e(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> i(Set<? extends T> set) {
        kotlin.jvm.internal.p.i(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : X.d(set.iterator().next()) : e();
    }

    public static <T> Set<T> j(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return r.i1(elements);
    }

    public static <T> Set<T> k(T t10) {
        return t10 != null ? X.d(t10) : e();
    }

    public static <T> Set<T> l(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return (Set) r.W(elements, new LinkedHashSet());
    }
}
