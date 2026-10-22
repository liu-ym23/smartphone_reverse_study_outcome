package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import v9.C5680i;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a1\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u000e\u0010\f\u001a7\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0000*\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0000*\u00020\u00132\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0017\u0010\f\u001a%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aG\u0010\u001e\u001a\u00020\u001b\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001a*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00072\b\u0010\u0014\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001f\u001a'\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\"\u0010#\u001a\u000f\u0010$\u001a\u00020!H\u0001¢\u0006\u0004\b$\u0010%\u001a\u000f\u0010&\u001a\u00020!H\u0001¢\u0006\u0004\b&\u0010%\"\u0019\u0010*\u001a\u00020'*\u0006\u0012\u0002\b\u00030\u00048F¢\u0006\u0006\u001a\u0004\b(\u0010)\"!\u0010-\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "isVarargs", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "([Ljava/lang/Object;Z)Ljava/util/Collection;", "", "m", "()Ljava/util/List;", "elements", "p", "([Ljava/lang/Object;)Ljava/util/List;", "", "s", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "([Ljava/lang/Object;)Ljava/util/ArrayList;", "", "element", "q", "(Ljava/lang/Object;)Ljava/util/List;", "r", "t", "(Ljava/util/List;)Ljava/util/List;", "", "", "fromIndex", "toIndex", "k", "(Ljava/util/List;Ljava/lang/Comparable;II)I", ContentDisposition.Parameters.Size, "LY8/t;", "u", "(III)V", "w", "()V", "v", "Lv9/i;", "n", "(Ljava/util/Collection;)Lv9/i;", "indices", "o", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* renamed from: Z8.v, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1173v extends C1172u {
    public static <T> ArrayList<T> h(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(i(elements, true));
    }

    public static final <T> Collection<T> i(T[] tArr, boolean z10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return new C1164l(tArr, z10);
    }

    public static /* synthetic */ Collection j(Object[] objArr, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return i(objArr, z10);
    }

    public static final <T extends Comparable<? super T>> int k(List<? extends T> list, T t10, int i10, int i11) {
        kotlin.jvm.internal.p.i(list, "<this>");
        u(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iD = b9.b.d(list.get(i13), t10);
            if (iD < 0) {
                i10 = i13 + 1;
            } else {
                if (iD <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int l(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return k(list, comparable, i10, i11);
    }

    public static <T> List<T> m() {
        return EmptyList.f34708a;
    }

    public static C5680i n(Collection<?> collection) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        return new C5680i(0, collection.size() - 1);
    }

    public static <T> int o(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> p(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return elements.length > 0 ? C1168p.d(elements) : m();
    }

    public static <T> List<T> q(T t10) {
        return t10 != null ? C1172u.e(t10) : m();
    }

    public static <T> List<T> r(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return r.V(elements);
    }

    public static <T> List<T> s(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(i(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> t(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : C1172u.e(list.get(0)) : m();
    }

    public static final void u(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        }
        if (i12 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
    }

    public static void v() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void w() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
