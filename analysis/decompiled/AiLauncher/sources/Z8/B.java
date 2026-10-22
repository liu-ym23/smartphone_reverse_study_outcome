package Z8;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import v9.C5680i;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0004\u001a#\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"", "", "index", ExifInterface.LONGITUDE_WEST, "(Ljava/util/List;I)I", "Y", "X", ExifInterface.GPS_DIRECTION_TRUE, "U", "(Ljava/util/List;)Ljava/util/List;", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes4.dex */
public class B extends A {
    public static <T> List<T> U(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        return new V(list);
    }

    public static <T> List<T> V(List<T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        return new U(list);
    }

    public static final int W(List<?> list, int i10) {
        if (i10 >= 0 && i10 <= C1173v.o(list)) {
            return C1173v.o(list) - i10;
        }
        throw new IndexOutOfBoundsException("Element index " + i10 + " must be in range [" + new C5680i(0, C1173v.o(list)) + "].");
    }

    public static final int X(List<?> list, int i10) {
        return C1173v.o(list) - i10;
    }

    public static final int Y(List<?> list, int i10) {
        if (i10 >= 0 && i10 <= list.size()) {
            return list.size() - i10;
        }
        throw new IndexOutOfBoundsException("Position index " + i10 + " must be in range [" + new C5680i(0, list.size()) + "].");
    }
}
