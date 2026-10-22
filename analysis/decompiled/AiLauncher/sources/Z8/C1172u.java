package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;

@Metadata(d1 = {"\u0000>\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u0016\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00162\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "element", "", "e", "(Ljava/lang/Object;)Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "", "c", "()Ljava/util/List;", "", "capacity", Const.INTENT_KEY_UMID, "(I)Ljava/util/List;", "builder", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", "", "Ljava/util/Random;", "random", "f", "(Ljava/lang/Iterable;Ljava/util/Random;)Ljava/util/List;", "collectionSize", "", "array", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "", "isVarargs", "", Const.INTENT_KEY_PKGNAME, "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* renamed from: Z8.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1172u {
    public static <E> List<E> a(List<E> builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        return ((ListBuilder) builder).x();
    }

    public static final <T> Object[] b(T[] tArr, boolean z10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (z10 && kotlin.jvm.internal.p.d(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static <E> List<E> c() {
        return new ListBuilder(0, 1, null);
    }

    public static <E> List<E> d(int i10) {
        return new ListBuilder(i10);
    }

    public static <T> List<T> e(T t10) {
        List<T> listSingletonList = Collections.singletonList(t10);
        kotlin.jvm.internal.p.h(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static <T> List<T> f(Iterable<? extends T> iterable, Random random) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(random, "random");
        List<T> listO1 = F.o1(iterable);
        Collections.shuffle(listO1, random);
        return listO1;
    }

    public static <T> T[] g(int i10, T[] array) {
        kotlin.jvm.internal.p.i(array, "array");
        if (i10 < array.length) {
            array[i10] = null;
        }
        return array;
    }
}
